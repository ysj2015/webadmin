package com.ssh.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
//import javax.persistence.Table;


import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

//@Entity
//@Table(name= "t_role")
//@DynamicUpdate(true)
//@DynamicInsert(true)
public class Role implements Serializable{
	private Integer roleId;
	private String roleName;
	private String description;
	private Integer isDelete;
	private Set<User> users = new HashSet<User>(0);
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "roleid",unique=true,nullable=false)
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
//	@Column(name = "rolename", length = 100)
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
//	@Column(name = "desc", length = 100)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	//	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinTable(name = "t_user_role", schema = "",
//		joinColumns = {@JoinColumn(name = "userid", nullable = false, updatable = false)})
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
}
