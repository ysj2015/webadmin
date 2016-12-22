package com.ssh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ssh.bean.Role;
import com.ssh.dao.BaseDao;
import com.ssh.forms.RoleForm;
import com.ssh.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	@Qualifier("baseDao")
	private BaseDao<Role> dao;
	@Override
	public List<Role> grid() {
		// TODO Auto-generated method stub
		return dao.find("from Role");
	}

	@Override
	public void createRole(RoleForm form) {
		// TODO Auto-generated method stub
		Role role = new Role();
		role.setIsDelete(0);
		role.setRoleName(form.getRoleName());
		role.setDescription(form.getDescription());
		dao.save(role);
	}

	@Override
	public void deleteRole(int id) {
		// TODO Auto-generated method stub
		dao.execute("update Role set isdelete = 1 where roleid = " + id);
	}

}
