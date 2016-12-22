package com.ssh.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ssh.bean.User;
import com.ssh.dao.BaseDao;
import com.ssh.dao.UserDao;
import com.ssh.forms.UserForm;
import com.ssh.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	@Qualifier("baseDao")
	private BaseDao<User> dao;
	
	public void regUser(UserForm form) throws HibernateException {
		User user = new User();
		user.setIsDelete(0);
		user.setUserName(form.getUsername());
		user.setPassword(form.getPassword());
		
		//BeanUtils.
		dao.save(user);
	}
	public void createUser(UserForm form) throws HibernateException {
		User user = new User();
		user.setIsDelete(0);
		user.setUserName(form.getUsername());
		user.setPassword(form.getPassword());
		dao.save(user);
	}
	
	public void updateUser(User user) {
		dao.update(user);
	}
	public List<User> login(UserForm form) throws HibernateException {
		Map<String, Object> param = new HashMap<String,Object>();
		param.put("username", form.getUsername());
		param.put("password", form.getPassword());
		String hql = "from User where username=? and password=?";
		
		return dao.find(hql, param);

	}
	public List<User> grid() {
		return dao.find("from User");
	}
	
	public User getById(int id) {
		// TODO Auto-generated method stub
		return dao.getById(User.class, id);
	}
	public void deleteUser(int id) {
//		User user = dao.getById(User.class, id);
//		user.setIsDelete(1);
//		dao.update(user);
		dao.execute("update User set isdelete = 1 where userid = " + id);
	}
}
