package com.ssh.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssh.bean.Node;
import com.ssh.dao.BaseDao;

@Repository("baseDao")
public class BaseDaoImpl<T> implements BaseDao<T> {

	@Autowired
	private SessionFactory sessionFactory;
	public Session getCurrentSession() {
		return sessionFactory.openSession();
	}
 	@Override
	public Serializable save(T o) {
		// TODO Auto-generated method stub
 		getCurrentSession().save(o);
		return null;
	}

	@Override
	public void delete(T o) {
		// TODO Auto-generated method stub
		getCurrentSession().delete(o);
	}

	@Override
	public void update(T o) {
		// TODO Auto-generated method stub
		getCurrentSession().update(o);
		getCurrentSession().close();
	}

	@Override
	public void saveOrUpdate(T o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<T> find(String hql) {
		// TODO Auto-generated method stub
		Query q = getCurrentSession().createQuery(hql);
		getCurrentSession().close();
		return q.list();
	}
	@Override
	public List<T> find(String hql, Map<String, Object> params) {
		// TODO Auto-generated method stub
		Query q = getCurrentSession().createQuery(hql);
		if(params != null && !params.isEmpty()) {
			for(String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		getCurrentSession().close();
		return q.list();
	}
	@Override
	public T getById(Class<T> c, Serializable id) {
		// TODO Auto-generated method stub
		T obj = (T) getCurrentSession().get(c, id);
		getCurrentSession().close();
		
		return obj;
	}
	@Override
	public void execute(String sql) {
		// TODO Auto-generated method stub
		Session session = getCurrentSession();
		Transaction tx = session.beginTransaction();
		Query q = session.createSQLQuery(sql);
		q.executeUpdate();
		tx.commit();
		session.close();
	}

	

}
