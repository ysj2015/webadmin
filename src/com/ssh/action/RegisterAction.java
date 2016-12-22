package com.ssh.action;

import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import com.ssh.forms.*;
import com.ssh.service.*;
public class RegisterAction extends ActionSupport {
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



	
	public String execute(){
		UserForm user = new UserForm();
		user.setPassword(password);
		user.setUsername(userName);
		try{
			userService.regUser(user);
			return SUCCESS;
		} catch(Exception e) {
			return ERROR;
		}
	}
}
