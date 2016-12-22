package com.ssh.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Iterator;
import java.util.Set;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.ssh.bean.DataList;
import com.ssh.bean.Role;
import com.ssh.bean.User;
import com.ssh.dto.UserDto;
import com.ssh.service.UserService;

public class UserGridAction extends ActionSupport {
	@Autowired
	private UserService userService;
	public String execute() {
		List<User> list = userService.grid();
		List<UserDto> dtoList = new ArrayList<UserDto>();
		for(int i = 0;i < list.size();i ++) {
			User user = list.get(i);
			UserDto dto= new UserDto();
			dto.setUserId(user.getUserId());
			dto.setUserName(user.getUserName());
			dto.setIsDelete(user.getIsDelete());
			if(user.getRoles().size()>0) {
				Set<String> role_text = new HashSet<String>();
				for(Iterator<Role> it = user.getRoles().iterator();it.hasNext();) {
					Role r = (Role)it.next();
					role_text.add(r.getRoleName());
				}
				dto.setRoleName(role_text.toString());
			}
			dtoList.add(dto);
		}
		DataList dl = new DataList();
		dl.setTotal(dtoList.size());
		dl.setRows(dtoList);
		System.out.println(JSON.toJSONString(dl));
		try {
			ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
			ServletActionContext.getResponse().getWriter().write(JSON.toJSONString(dl));
			ServletActionContext.getResponse().getWriter().flush();
			ServletActionContext.getResponse().getWriter().close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "userlist";
	}
}
