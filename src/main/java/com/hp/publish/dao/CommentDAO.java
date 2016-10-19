package com.hp.publish.dao;

import java.io.IOException;
import java.sql.Blob;
import java.util.List;

import com.hp.publish.model.Comment;

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
public class CommentDAO {

	@Autowired
    private SessionFactory sessionFactory;
     
    public void save(Comment comment) {
        Session session = sessionFactory.getCurrentSession();
        session.save(comment);
    }
     
//    @Transactional
    public List<Comment> list() {
        Session session = sessionFactory.getCurrentSession();
        List<Comment> commentList = null;
        try {
            commentList = (List<Comment>)session.createQuery("from Comment").list();
// 			be careful about query object
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return commentList;
    }
     
//    @Transactional
    public Comment get(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return (Comment)session.get(Comment.class, id);
    }
 
    public void remove(Integer id) {
        Session session = sessionFactory.getCurrentSession();
         
        Comment comment = (Comment)session.get(Comment.class, id);
         
        session.delete(comment);
    }
    
    public List<Comment> listByPostId(Integer postId) {
        Session session = sessionFactory.getCurrentSession();
        List<Comment> commentListById = null;
        
        try {
        	String post_Id = postId.toString();
        	String hql = "from Comment cmt where cmt.postId=" + post_Id;
            commentListById = (List<Comment>)session.createQuery(hql).list();
// 			be careful about query object
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return commentListById;
    }
}
