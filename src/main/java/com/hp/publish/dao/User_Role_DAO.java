package com.hp.publish.dao;

import java.io.IOException;
import java.sql.Blob;
import java.util.List;

import com.hp.publish.model.User_Role;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.LobHelper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class User_Role_DAO {

	@Autowired
    private SessionFactory sessionFactory;
     
    public void save(User_Role user_role) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user_role);
    }
     
//    @Transactional
    public List<User_Role> list() {
        Session session = sessionFactory.getCurrentSession();
        List<User_Role> user_role_List = null;
        try {
            user_role_List = (List<User_Role>)session.createQuery("from User_Role").list();
 
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return user_role_List;
    }
     
//    @Transactional
    public User_Role get(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return (User_Role)session.get(User_Role.class, id);
    }
 
//    @Transactional
    public void remove(Integer id) {
        Session session = sessionFactory.getCurrentSession();
         
        User_Role user_role = (User_Role)session.get(User_Role.class, id);
         
        session.delete(user_role);
    }
}
