package com.hp.publish.dao;

import java.io.IOException;
import java.sql.Blob;
import java.util.List;

import com.hp.publish.model.User;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.LobHelper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDAO {
	
	@Autowired
    private SessionFactory sessionFactory;
     
    public void save(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }
     
    public List<User> list() {
        Session session = sessionFactory.getCurrentSession();
        List<User> userList = null;
        try {
            userList = (List<User>)session.createQuery("from User").list();
 
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return userList;
    }
     
    public User get(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return (User)session.get(User.class, id);
    }
 
    public void remove(Integer id) {
        Session session = sessionFactory.getCurrentSession();
         
        User user = (User)session.get(User.class, id);
         
        session.delete(user);
    }
    
    public User getByName(String userName) {
    	Session session = sessionFactory.getCurrentSession();
    	String hql = "from User user where user.userName='" + userName + "'";
    	User currentUser = null;
    	try {
    		currentUser = (User)session.createQuery(hql).uniqueResult();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	if(currentUser != null)
    		return currentUser;
    	else
    		return null;
    }
    
    public boolean isExsit(String userName) {
    	Session session = sessionFactory.getCurrentSession();
    	String hql = "from User user where user.userName='" + userName + "'";
    	User testedUser = null;
    	try {
    		testedUser = (User)session.createQuery(hql).uniqueResult();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	if(testedUser == null)
    		return false;
    	else
    		return true;
    }
}
