package com.hp.common.manager;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.hp.common.Constants;
import com.hp.common.dao.IBaseDao;
import com.hp.common.pagination.Page;
import com.hp.common.pagination.PageUtil;
@Transactional
public abstract class BaseService<M extends java.io.Serializable, PK extends java.io.Serializable>{
    public abstract IBaseDao<M, PK> getdao();
    public M save(M model) {
        getdao().save(model);
        return model;
    }
    public void merge(M model) {
        getdao().merge(model);
    }
    public void saveOrUpdate(M model) {
        getdao().saveOrUpdate(model);
    }
    public void update(M model) {
        getdao().update(model);
    }
    
   
    public void delete(PK id) {
        getdao().delete(id);
    }

   
    public void deleteObject(M model) {
        getdao().deleteObject(model);
    }

   
    public M get(PK id) {
        return getdao().get(id);
    }
  
    public int countAll() {
        return getdao().countAll();
    }

   
    public List<M> listAll() {
        return getdao().listAll();
    }
   
    public Page<M> listAll(int pn) {

        return this.listAll(pn, Constants.DEFAULT_PAGE_SIZE);
    }
    
    public Page<M> listAllWithOptimize(int pn) {
        return this.listAllWithOptimize(pn, Constants.DEFAULT_PAGE_SIZE);
    }
    
   
    public Page<M> listAll(int pn, int pageSize) {
        Integer count = countAll();
        List<M> items = getdao().listAll(pn, pageSize);
        return PageUtil.getPage(count, pn, items, pageSize);
    }
    public Page<M> listAllWithOptimize(int pn, int pageSize) {
        Integer count = countAll();
        List<M> items = getdao().listAll(pn, pageSize);
        return PageUtil.getPage(count, pn, items, pageSize);
    }
    
   
    public Page<M> pre(PK pk, int pn, int pageSize) {
        Integer count = countAll();
        List<M> items = getdao().pre(pk, pn, pageSize);
        return PageUtil.getPage(count, pn, items, pageSize);
    }
   
    public Page<M> next(PK pk, int pn, int pageSize) {
        Integer count = countAll();
        List<M> items = getdao().next(pk, pn, pageSize);
        return PageUtil.getPage(count, pn, items, pageSize);
    }
   
    public Page<M> pre(PK pk, int pn) {
        return pre(pk, pn, Constants.DEFAULT_PAGE_SIZE);
    }
   
    public Page<M> next(PK pk, int pn) {
        return next(pk, pn, Constants.DEFAULT_PAGE_SIZE);
    }
    
}
