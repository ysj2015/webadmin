package com.ssh.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

//import javax.persistence.*;
//
//import org.hibernate.annotations.DynamicInsert;
//import org.hibernate.annotations.DynamicUpdate;

//@Entity
//@Table(name= "t_user")
//@DynamicUpdate(true)
//@DynamicInsert(true)
public class User implements Serializable{
	private Integer userId;
	private String userName;
	private String password;
	private Integer isDelete;
	private Set<Role> roles = new HashSet<Role>(0);
	
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@Column(name="user_id",unique=true,nullable=false)
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
//	@Column(name = "username", length = 100)
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
//	@Column(name = "password", length = 100)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	//	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinTable(name = "t_user_role", schema = "",
//		joinColumns = {@JoinColumn(name = "roleid", nullable = false, updatable = false)})
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}
