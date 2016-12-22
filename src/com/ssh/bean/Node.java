package com.ssh.bean;

import java.io.Serializable;
import java.util.Set;

public class Node implements Serializable{   
    private int id; //标识符     
    private String name; //节点名称   
    private int level; //层次，为了输出设计    
    //父节点：因为多个节点属于一个父节点，因此用hibernate映射关系说是“多对一”  
    private Node parent;  
    //子节点：因为一个节点有多个子节点，因此用hibernate映射关系说是“一对多”  
    private Set<Node> children;  
  
    public int getId() {  
        return id;  
    }  
    public void setId(int id) {  
        this.id = id;  
    }  
    public String getName() {  
        return name;  
    }  
    public void setName(String name) {  
        this.name = name;  
    }  
    public int getLevel() {  
        return level;  
    }  
    public void setLevel(int level) {  
        this.level = level;  
    }  
    
    public Node getParent() {  
        return parent;  
    }  
    public void setParent(Node parent) {  
        this.parent = parent;  
    }  
    public Set<Node> getChildren() {  
        return children;  
    }  
    public void setChildren(Set<Node> children) {  
        this.children = children;  
    }  
}  