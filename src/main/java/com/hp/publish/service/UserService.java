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
public class UserService {

	@Autowired 
	private UserDAO userDao;
	
	@Autowired
	private User_Role_DAO user_role_Dao;
	
	@Autowired
	private CommentDAO commentDao;
	
	@Autowired
	private PostDAO postDao;
	
	@Autowired
	private CatalogDAO catalogDao;
	
	public boolean signUpNewUser(User newUser, String confirmedPW) {
		try {
			if(userDao.isExsit(newUser.getUserName()) == false) {
				if(!confirmedPW.equals(newUser.getUserPassword()))
					return false;
				userDao.save(newUser);
				Integer user_id = newUser.getUserId();
				System.out.println("Service/ name: " + newUser.getUserName());
				System.out.println("Service/ password: " + newUser.getUserPassword());
				
				Integer role_id;
				if(newUser.getUserName().equals("zhangpeng") && newUser.getUserPassword().equals("372015")) {
					role_id = 1;
				}
				else {
					role_id = 2;
				}
				System.out.println("Service/ role_id: " + role_id);
				
				User_Role user_role = new User_Role();
				user_role.setrId(role_id);
				user_role.setuId(user_id);
				
//				add a role according to the user's information
				user_role_Dao.save(user_role);
				
				return true;
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
	
	public void saveComment(Comment comment) {
		commentDao.save(comment);
	}
	
	public Post getByPostId(Integer postId) {
		Post post = postDao.get(postId);
		return post;
	}
	
	public Integer getUId(String userName) {
		User currentUser = userDao.getByName(userName);
		if(currentUser != null) {
			return currentUser.getUserId();
		}
		else {
			return null;
		}
	}
	
	public Integer catalogIsExist(String catalogName) {
		return catalogDao.isExsit(catalogName);
	}
	
	public User getUseById(Integer userId) {
		User currentUser = userDao.get(userId);
		return currentUser;
	}
}
