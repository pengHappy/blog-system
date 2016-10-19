package com.hp.publish.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hp.publish.dao.*;
import com.hp.publish.model.*;

@Service
@Transactional
public class AdminService {

	@Autowired 
	private CommentDAO commentDao;
	
	@Autowired
	private PostDAO postDao;
	
	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private CatalogDAO catalogDao;
	
	
	public void savePost(Post post) {
		try {
			postDao.save(post);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void saveCatalog(Catalog catalog) {
		try {
			catalogDao.save(catalog);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteComment(Integer commentId) {
		try {
			commentDao.remove(commentId);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updatePost(Post post) {
		try {
			postDao.update(post);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deletePost(Integer postId) {
		try {
			postDao.remove(postId);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<User> listAllUsers() {
		List<User> userList = null;
		try {
			userList = userDao.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userList;
	}
	
	public void deleteUser(Integer userId) {
		try {
			userDao.remove(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteCatalog(Integer catalogId) {
		try {
			catalogDao.remove(catalogId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
