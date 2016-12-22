package com.ssh.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.ssh.bean.User;
import com.ssh.forms.UserForm;
@Repository
public class UserDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getCurrentSession() {
		return sessionFactory.openSession();
	}
	
	public void saveObject(Object o) throws HibernateException {
		this.getCurrentSession().save(o);
	}
	public List<User> selectObject(UserForm form){
		Query query = getCurrentSession().createQuery("from User where username=? and password=?");
		query.setString(0, form.getUsername());
		query.setString(1, form.getPassword());
		List<User> list = query.list();
		return list;
	}
}
