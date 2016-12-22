package com.ssh.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.ssh.bean.DataList;
import com.ssh.bean.Role;
import com.ssh.bean.Role;
import com.ssh.dto.RoleDto;
import com.ssh.service.RoleService;

public class RoleGridAction extends ActionSupport {
	@Autowired
	private RoleService roleService;
	public String execute() {
		List<Role> list = roleService.grid();
		List<RoleDto> dtoList = new ArrayList<RoleDto>();
		for(int i = 0;i < list.size();i ++) {
			Role role = list.get(i);
			RoleDto dto= new RoleDto();
			dto.setRoleId(role.getRoleId());
			dto.setRoleName(role.getRoleName());
			dto.setDescription(role.getDescription());
			dto.setIsDelete(role.getIsDelete());
//			if(user.getRoles().size()>0) {
//				Set<String> role_text = new HashSet<String>();
//				for(Iterator<Role> it = user.getRoles().iterator();it.hasNext();) {
//					Role r = (Role)it.next();
//					role_text.add(r.getRoleName());
//				}
//				dto.setRoleName(role_text.toString());
//			}
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
		
		return "rolelist";
	}
}
