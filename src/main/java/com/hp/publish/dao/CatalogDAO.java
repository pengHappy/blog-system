package com.hp.publish.dao;

import java.io.IOException;
import java.util.List;

import com.hp.publish.model.Catalog;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.LobHelper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Repository
public class CatalogDAO {

	@Autowired
    private SessionFactory sessionFactory;
     
    public void save(Catalog catalog) {
        Session session = sessionFactory.getCurrentSession();
        session.save(catalog);
    }
     
    public List<Catalog> list() {
        Session session = sessionFactory.getCurrentSession();
        List<Catalog> catalogList = null;
        try {
            catalogList = (List<Catalog>)session.createQuery("from Catalog").list();
// 			be careful about query object
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return catalogList;
    }
     
    public Catalog get(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return (Catalog)session.get(Catalog.class, id);
    }
 
    public void remove(Integer id) {
        Session session = sessionFactory.getCurrentSession();
         
        Catalog catalog = (Catalog)session.get(Catalog.class, id);
         
        session.delete(catalog);
    }
    
    public Integer isExsit(String catalogName) {
    	Session session = sessionFactory.getCurrentSession();
    	String hql = "from Catalog catalog where catalog.catalogName='" + catalogName + "'";
    	Catalog testedCatalog = null;
    	try {
    		testedCatalog = (Catalog)session.createQuery(hql).uniqueResult();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	if(testedCatalog == null)
    		return null;
    	else
    		return testedCatalog.getCatalogId();
    }
}
