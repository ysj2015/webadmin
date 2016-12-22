package com.ssh.action;

import java.io.IOException;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.ssh.bean.Json;
import com.ssh.bean.User;
import com.ssh.forms.UserForm;
import com.ssh.service.UserService;

public class UserAction extends ActionSupport {
	
	@Autowired
	private UserService userService;
	private String userName;
	private String password;
	private String id;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String home() {
		return "list";
	}
	public void grid() {
		System.out.println("UserAction.grid()");
		List<User> list = userService.grid();
		try {
			ServletActionContext.getResponse().getWriter().write(JSON.toJSONString(list));
			ServletActionContext.getResponse().getWriter().flush();
			ServletActionContext.getResponse().getWriter().close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//return "list";
	}
	public void add() {
		UserForm  form = new UserForm();
		form.setUsername(userName);
		form.setPassword(password);
		userService.createUser(form);
		Json json = new Json();
		json.setResult(true);
		try {
			ServletActionContext.getResponse().getWriter().write(JSON.toJSONString(json));
			ServletActionContext.getResponse().getWriter().flush();
			ServletActionContext.getResponse().getWriter().close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void delete() {
		int uid = Integer.parseInt(id);
		System.out.println(id);
		userService.deleteUser(uid);
		Json json = new Json();
		json.setResult(true);
		try {
			ServletActionContext.getResponse().getWriter().write(JSON.toJSONString(json));
			ServletActionContext.getResponse().getWriter().flush();
			ServletActionContext.getResponse().getWriter().close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String login() {
		return SUCCESS;
	}
//	public String grid() {}
	
}
