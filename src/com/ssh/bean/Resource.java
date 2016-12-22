package com.ssh.bean;

import java.util.HashSet;
import java.util.Set;

public class Resource {
	private Integer id;
	private String resourceName;
	private String url;
	private Resource parent;
	private Set<Resource> childResource = new HashSet<Resource>(0);
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}	
	
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Resource getParent() {
		return parent;
	}
	public void setParent(Resource parent) {
		this.parent = parent;
	}
	public Set<Resource> getChildResource() {
		return childResource;
	}
	public void setChildResource(Set<Resource> childResource) {
		this.childResource = childResource;
	}
	
}
