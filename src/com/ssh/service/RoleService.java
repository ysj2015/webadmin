package com.ssh.service;

import java.util.List;

import com.ssh.bean.Role;
import com.ssh.forms.RoleForm;

public interface RoleService {
	public List<Role> grid();
	public void createRole(RoleForm form);
	public void deleteRole(int id);
}
