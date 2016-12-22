package com.ssh.action;

import java.io.IOException;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.ssh.bean.Json;
import com.ssh.bean.Role;
import com.ssh.bean.User;
import com.ssh.forms.RoleForm;
import com.ssh.forms.UserForm;
import com.ssh.service.RoleService;
import com.ssh.service.UserService;

public class RoleAction extends ActionSupport {

	@Autowired
	private RoleService roleService;
	private String roleName;
	private String description;
	private String id;
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
		List<Role> list = roleService.grid();
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
		RoleForm  form = new RoleForm();
		form.setRoleName(roleName);
		form.setDescription(description);
		roleService.createRole(form);
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
		roleService.deleteRole(uid);
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
}
