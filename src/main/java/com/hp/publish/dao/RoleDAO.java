package com.hp.publish.dao;

import java.io.IOException;
import java.sql.Blob;
import java.util.List;

import com.hp.publish.model.Role;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.LobHelper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class RoleDAO {
	
	@Autowired
    private SessionFactory sessionFactory;
     
    public void save(Role role) {
        Session session = sessionFactory.getCurrentSession();
        session.save(role);
    }
     
    @Transactional
    public List<Role> list() {
        Session session = sessionFactory.getCurrentSession();
        List<Role> roleList = null;
        try {
            roleList = (List<Role>)session.createQuery("from Role").list();
 
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return roleList;
    }
     
    @Transactional
    public Role get(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return (Role)session.get(Role.class, id);
    }
 
    @Transactional
    public void remove(Integer id) {
        Session session = sessionFactory.getCurrentSession();
         
        Role role = (Role)session.get(Role.class, id);
         
        session.delete(role);
    }
}
