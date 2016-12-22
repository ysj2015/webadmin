package com.ssh.test;

public class Node implements java.io.Serializable{
	private String id;
	private String text;
	private String parentId;
	private Children children = new Children();
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public Children getChildren() {
		return children;
	}
	public void setChildren(Children children) {
		this.children = children;
	}
	public String toString() {
		StringBuilder sb = new StringBuilder("");
		sb.append("{"  
				   + "\"id\" : \"" + id + "\""  
				   + ", \"text\" : \"" + text + "\"");
		if(children != null && children.getSize() != 0) {
			sb.append(", \"children\" : "+children.toString());
		} else {
			sb.append(", \"leaf\" : true");
		}
		sb.append("}");
		return sb.toString();
	}
	public void addChild(Node n) {
		children.addChild(n);
	}
}
