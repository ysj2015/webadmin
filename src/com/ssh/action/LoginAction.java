package com.ssh.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.ActionSupport;
import com.ssh.bean.User;
import com.ssh.forms.UserForm;
import com.ssh.service.UserService;

public class LoginAction extends ActionSupport {
	@Autowired
	private UserService userService;
	private String userName;
	private String password;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String execute() {
		System.out.println("login");
		UserForm user = new UserForm();
		user.setPassword(password);
		user.setUsername(userName);
		try{
			List<User> list = userService.login(user);
			if(list != null &&list.size() > 0){
				return SUCCESS;
			}else {
				return ERROR;
			}
		} catch(Exception e) {
			return ERROR;
		}
	}
}
