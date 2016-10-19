package com.hp.publish.dao;

import java.io.IOException;
import java.sql.Blob;
import java.util.List;

import com.hp.publish.model.Post;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.LobHelper;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Repository
public class PostDAO {

	@Autowired
    private SessionFactory sessionFactory;
     

    public void save(Post post) {
        Session session = sessionFactory.getCurrentSession();
        session.save(post);
    }
     
    public List<Post> listAll() {
    	Session session = sessionFactory.getCurrentSession();
        List<Post> postList = null;
        try {
        	postList = (List<Post>)session.createQuery("from Post").list();
        } catch (Exception e) {
        	e.printStackTrace();
        }
        
        return postList;
    }
    
    public List<Post> listByCatalog(Integer catalogId) {
    	Session session = sessionFactory.getCurrentSession();
        List<Post> postList = null;
        try {
        	String cat_Id = catalogId.toString();
        	String hql = "from Post post where post.catalogId=" + cat_Id;
            postList = (List<Post>)session.createQuery(hql).list();
            
 
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return postList;
    }

    public List<Post> list(Integer currentUserId) {
        Session session = sessionFactory.getCurrentSession();
        List<Post> postList = null;
        try {
        	String current_UserId = currentUserId.toString();
        	String hql = "from Post post where post.userId=" + current_UserId;
            postList = (List<Post>)session.createQuery(hql).list();
 
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return postList;
    }
     
//    @Transactional
    public Post get(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return (Post)session.get(Post.class, id);
    }
 
//    @Transactional
    public void remove(Integer id) {
        Session session = sessionFactory.getCurrentSession();
         
        Post post = (Post)session.get(Post.class, id);
         
        session.delete(post);
    }
    
    public void update(Post post) {
    	Session session = sessionFactory.getCurrentSession();
    	
    	System.out.println("DAO/ title: " + post.getPostTitle());
    	System.out.println("DAO/ content: " + post.getPostContent());
    	
    	session.update(post);
    }
    
    public List<Post> lookUp(String postTitle) {
    	 Session session = sessionFactory.getCurrentSession();
         List<Post> postList = null;
         try {
         	String hql = "from Post post where post.postTitle like :param";
            Query query = session.createQuery(hql);
            query.setString("param", "%" + postTitle + "%");
            postList = (List<Post>)query.list();
         } catch (HibernateException e) {
             e.printStackTrace();
         }
         return postList;
    }
	
}
