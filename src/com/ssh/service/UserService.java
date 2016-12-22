package com.ssh.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssh.bean.User;
import com.ssh.dao.UserDao;
import com.ssh.forms.UserForm;

public interface UserService {	
	
	public void regUser(UserForm form);
	
	public List<User> login(UserForm form);
	public List<User> grid();
	
	public void createUser(UserForm form);
	public void updateUser(User user);
	public User getById(int id);
	public void deleteUser(int id);
}
