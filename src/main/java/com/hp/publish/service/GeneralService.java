package com.hp.publish.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hp.publish.dao.*;
import com.hp.publish.model.*;

@Service
@Transactional
public class GeneralService {

	@Autowired
	private CommentDAO commentDao;
	
	@Autowired
	private PostDAO postDao;
	
	@Autowired
	private CatalogDAO catalogDao;
	
	public List<Comment> listByPostId(Integer postId) {
		List<Comment> commentListById = null;
		
		try {
			commentListById = commentDao.listByPostId(postId);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return commentListById;
	}
	
	public List<Post> listPosts(Integer currentUserId) {
		return postDao.list(currentUserId);
	}
	
	public List<Post> listAllPosts() {
		return postDao.listAll();
	}
	
	public List<Post> lookUp(String postTitle) {
		List<Post> resList = null;
		resList = postDao.lookUp(postTitle);
		return resList;
	}
	
	public List<Catalog> listCatalogs() {
		return catalogDao.list();
	}
	
	public List<Post> listByCatalog(Integer catalogId) {
		return postDao.listByCatalog(catalogId);
	}
}
