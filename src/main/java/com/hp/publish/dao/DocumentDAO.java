package com.hp.publish.dao;

import java.io.IOException;
import java.sql.Blob;
import java.util.List;

import com.hp.publish.model.Document;

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
public class DocumentDAO {
     
    @Autowired
    private SessionFactory sessionFactory;
     
    @Transactional
    public void save(Document document) {
        Session session = sessionFactory.getCurrentSession();
        session.save(document);
    }
     
    @Transactional
    public List<Document> list() {
        Session session = sessionFactory.getCurrentSession();
        List<Document> documents = null;
        try {
            documents = (List<Document>)session.createQuery("from Document").list();
 
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return documents;
    }
     
    @Transactional
    public Document get(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return (Document)session.get(Document.class, id);
    }
 
    @Transactional
    public void remove(Integer id) {
        Session session = sessionFactory.getCurrentSession();
         
        Document document = (Document)session.get(Document.class, id);
         
        session.delete(document);
    }
    
    //blob
    public Blob getBlob(MultipartFile dataFile) {
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();
    	LobHelper lobHelper = session.getLobHelper();
    	Blob blob = null;
    	
    	try {
    		blob = lobHelper.createBlob(dataFile.getBytes());
    	} catch (IOException e) {
    		e.printStackTrace();
    	} finally {
    		session.getTransaction().commit();
    		
		}
    	
    	return blob;
    }
}
