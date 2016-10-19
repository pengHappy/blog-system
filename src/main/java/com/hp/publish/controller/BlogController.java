package com.hp.publish.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.publish.dao.*;
import com.hp.publish.model.*;
import com.hp.publish.service.*;

import org.apache.commons.io.IOUtils;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;	

 
@Controller
public class BlogController {
     
    @Autowired
    private DocumentDAO documentDao;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private GeneralService generalService;
    
    @Autowired
    private AdminService adminService;
    
    public String getCurrentUserName() {
    	UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
			    .getAuthentication()
			    .getPrincipal();
		String userName = userDetails.getUsername();
		return userName;
    }
    
    public Integer getCurrentUserId() {
    	UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
			    .getAuthentication()
			    .getPrincipal();
		String userName = userDetails.getUsername();
		Integer currentUserId = userService.getUId(userName);
		if(currentUserId != null)
			return currentUserId;
		else
			return null;
    }
    
    @RequestMapping("/home")
    public String home(Map<String, Object> map) {
    	try {
    		map.put("allPost", generalService.listAllPosts()); 
    		map.put("catalogList", generalService.listCatalogs());
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	return "home";
    }
    
    @RequestMapping("/cata/{catalogId}")
    public String homeByCatalog(@PathVariable("catalogId") Integer catalogId,
    							Map<String,Object> model) {
    	model.put("catalogList", generalService.listCatalogs());
    	List<Post> postList = null;
    	postList = generalService.listByCatalog(catalogId);
    	if(postList != null) {
    		model.put("allPost", postList);
    	}
    	return "home";
    }
    
    @RequestMapping("/blog")
    public String blog(Map<String, Object> map) {
    	try {
    		Integer currentUserId = getCurrentUserId();
    		map.put("postList", generalService.listPosts(currentUserId));   		  		
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	return "blog";
    }
     
    @RequestMapping("/filepart")
    public String filePart(Map<String, Object> map) {
        try {
            map.put("document", new Document());
            map.put("documentList", documentDao.list());
        }catch(Exception e) {
            e.printStackTrace();
        }
 
        return "documents";
    }
    
    @RequestMapping(value = "/look_up", method = RequestMethod.POST)
    public ModelAndView lookUp(@RequestParam("keyTitle") String theTitle) {
		Map<String,Object> model = new HashMap<String, Object>();
    	System.out.println("look up : " + theTitle);
    	List<Post> postList = null;
    	postList = generalService.lookUp(theTitle);
    	if(postList != null) {
    		model.put("resList", postList);
    	}
    	return new ModelAndView("lookup_res", model);
    }
    
    @RequestMapping(value = "/save_catalog", method = RequestMethod.POST)
    public String saveCatalog(@RequestParam("newCata") String newCata) {
    	Catalog catalog = new Catalog();
    	catalog.setCatalogName(newCata);
    	adminService.saveCatalog(catalog);
    	return "redirect:/ctr_list";
    }
    
    @RequestMapping(value = "/ctr_list", method = RequestMethod.GET)
    public ModelAndView userList() {
    	Map<String,Object> model = new HashMap<String, Object>();
    	List<User> userList = null;
    	userList = adminService.listAllUsers();
    	if(userList != null) {
    		model.put("userList", userList);
    	}
    	List<Catalog> cataList = null;
    	cataList = generalService.listCatalogs();
    	if(cataList != null) {
    		model.put("cataList", cataList);
    	}
    	return new ModelAndView("ctr_list", model);
    }
 
    @RequestMapping(value = "/save_document", method = RequestMethod.POST)
    public String save(
            @ModelAttribute("document") Document document,
            @RequestParam("file") MultipartFile file) {
         
         
        System.out.println("Name:" + document.getName());
        System.out.println("Desc:" + document.getDescription());
        System.out.println("File:" + file.getName());
        System.out.println("ContentType:" + file.getContentType());
         
        try {
            Blob blob = documentDao.getBlob(file);
 
            document.setFilename(file.getOriginalFilename());
            document.setContent(blob);
            document.setContentType(file.getContentType());
        } catch (Exception e) {
            e.printStackTrace();
        }
         
        try {
            documentDao.save(document);
            System.out.println(document.getFilename());
        } catch(Exception e) {
            e.printStackTrace();
        }
         
        return "redirect:/filepart";
    }
 
    @RequestMapping("/download/{documentId}")
    public String download(@PathVariable("documentId")
            Integer documentId, HttpServletResponse response) {
         
        Document doc = documentDao.get(documentId);
        try {
            response.setHeader("Content-Disposition", "inline;filename=\"" +doc.getFilename()+ "\"");
            OutputStream out = response.getOutputStream();
            response.setContentType(doc.getContentType());
            IOUtils.copy(doc.getContent().getBinaryStream(), out);
            out.flush();
            out.close();
         
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
         
         
        return null;
    }
    
    @RequestMapping("/authenFailure")
    public String authenFailure() {
    	return "authenFailure";
    }
 
    @RequestMapping("/remove/{documentId}")
    public String remove(@PathVariable("documentId")
            Integer documentId) {
         
        documentDao.remove(documentId);
         
        return "redirect:/filepart";
    }
    
    @RequestMapping(value = "/loginSuccess", method = RequestMethod.GET)
    public String loginPage() {
        return "loginSuccess";
    }
    
    @RequestMapping(value = "/write_blog", method = RequestMethod.GET)
    public String write_blog(Map<String, Object> map) {
    	try {
            map.put("post", new Post());
        }catch(Exception e) {
            e.printStackTrace();
        }
    	
        return "write_blog";
    }
    
    @RequestMapping(value = "/save_post", method = RequestMethod.POST)
    public String save_post(@ModelAttribute("post") Post post,
    						@RequestParam("catalogName") String catalogName) {
    	
    	System.out.println("Post Id:" + post.getPostId());
    	System.out.println("Title:" + post.getPostTitle());
    	System.out.println("Content:\n" + post.getPostContent());
    	System.out.println("CatalogName: " + catalogName);
    	
    	try {
    		//call adminService instead of postDao
    		Integer currentUserId = getCurrentUserId();
    		if(currentUserId != null) {
    			Integer catalogId = userService.catalogIsExist(catalogName);
    			if(catalogId == null) {
    				return "authenFailure";
    			}
    			post.setCatalogId(catalogId);
    			post.setUserId(currentUserId);
    			String author = getCurrentUserName();
    			post.setPostAuthor(author);
        		adminService.savePost(post);
    		}
    		else {
    			System.out.println("Find User Error");
    		}
    	} catch(Exception e) {
            e.printStackTrace();
        }
    	
    	return "redirect:/blog";
    }
    
    @RequestMapping(value = "/view/post/{postId}", method = RequestMethod.GET)
    public ModelAndView viewPost(@PathVariable Integer postId){    	
    	
        Map<String,Object> model = new HashMap<String, Object>();

        try {
        	Post post = this.userService.getByPostId(postId); 
        	System.out.println(post.getPostContent());
        
        	model.put("post",post);
        	//with specific postId, call generalService instead of commentDao
        	model.put("commentList", generalService.listByPostId(postId)); 
        	model.put("newComment", new Comment());
        } catch(Exception e) {
        	e.printStackTrace();
        }

        return new ModelAndView("view_post", model);
    }
    
    
    @RequestMapping(value = "all_post/by_user/{userId}", method = RequestMethod.GET)
    public ModelAndView viewPostByUser(@PathVariable Integer userId){
    	Map<String,Object> model = new HashMap<String, Object>();
    	try {
    		List<Post> postList = generalService.listPosts(userId);
    		model.put("postList", postList);
    	} catch(Exception e) {
        	e.printStackTrace();
        }
    	return new ModelAndView("all_by_user", model);
    }
    
    
    @RequestMapping(value = "/all_post/{postId}", method = RequestMethod.GET)
    public ModelAndView viewPostForClients(@PathVariable Integer postId){
    	Map<String,Object> model = new HashMap<String, Object>();

        try {
        	Post post = this.userService.getByPostId(postId); 
        	System.out.println(post.getPostContent());
        
        	model.put("post",post);
        	model.put("commentList", generalService.listByPostId(postId)); 
        	model.put("newComment", new Comment());
        } catch(Exception e) {
        	e.printStackTrace();
        }

        return new ModelAndView("all_post", model);
    }
    
    @RequestMapping(value = "/save_comment/{postId}", method = RequestMethod.POST)
    public String save_comment(@ModelAttribute("newComment") Comment comment,
    						   @PathVariable Integer postId) {
    	
    	System.out.println("Author:" + comment.getCommentAuthor());
    	System.out.println("Comment Content:\n" + comment.getCommentContent());
    	
    	try {
    		comment.setPostId(postId);
    		System.out.println("PostId:" + comment.getPostId());
//    		Will it set postId automatically?
//    		call userService instead of commentDao
    		userService.saveComment(comment);
    	} catch(Exception e) {
            e.printStackTrace();
        }
    	
    	return "redirect:/home";
    }
    
    @RequestMapping(value = "/sign_up", method = RequestMethod.GET)
    public String signUp(Map<String, Object> map) {   	
    	try {
    		map.put("newUser", new User());
    	} catch(Exception e) {
            e.printStackTrace();
        }
    	
    	return "sign_up";
    }
    
    @RequestMapping(value = "/save_new_user", method = RequestMethod.POST)
    public String saveNewUser(@ModelAttribute("newUser") User newUser,
    						  @RequestParam("confirmedPW") String confirmedPW) {
    	if(userService.signUpNewUser(newUser, confirmedPW) == true) {
    		return "redirect:/home";
    	}
    	return "authenFailure";
    }
    
    @RequestMapping(value = "/delete_comment/{commentId}", method = RequestMethod.GET)
    public String deleteComment(@PathVariable("commentId")
            Integer commentId) {
         
        adminService.deleteComment(commentId);
         
        return "redirect:/blog";
    }
    
    @RequestMapping(value = "/delete_user/{userId}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("userId")
            Integer userId) {
         
        adminService.deleteUser(userId);
         
        return "redirect:/ctr_list";
    }
    
    @RequestMapping(value = "/delete_catalog/{catalogId}", method = RequestMethod.GET)
    public String deleteCatalog(@PathVariable("catalogId")
            Integer catalogId) {
         adminService.deleteCatalog(catalogId);
         
        return "redirect:/ctr_list";
    }
    
    @RequestMapping(value = "/modify_post/{postId}", method = RequestMethod.POST)
    public String modifyPost(@ModelAttribute("post") Post modifiedPost) {
    	try {
    		System.out.println("Controller/ title: " + modifiedPost.getPostTitle());
        	System.out.println("Controller/ content: " + modifiedPost.getPostContent());
    		adminService.updatePost(modifiedPost);
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	return "redirect:/blog";
    }
    
    //delete_post/${post.postId
    @RequestMapping(value = "/delete_post/{postId}", method = RequestMethod.GET)
    public String deletePost(@PathVariable("postId")
            Integer postId) {
         
        adminService.deletePost(postId);
         
        return "redirect:/blog";
    }
}
