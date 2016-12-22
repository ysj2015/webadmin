package com.ssh.action;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.opensymphony.xwork2.ActionSupport;
import com.ssh.test.Node;
import com.ssh.test.VirtualDataGenerator;

public class TestTreeAction extends ActionSupport {
	private String result;
	private Node root;
	private String data;
	public Node getRoot() {
		return root;
	}
	public void setRoot(Node root) {
		this.root = root;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String execute() {
		List dataList = VirtualDataGenerator.getVirtualResult();
		HashMap list = new HashMap();
		for(Iterator it = dataList.iterator();it.hasNext();) {
			Map map = (Map)it.next();
			Node node = new Node();
			node.setId((String)map.get("id"));
			node.setText((String)map.get("text"));
			node.setParentId((String)map.get("parentId"));
			list.put(node.getId(), node);
		}
		Set ns = list.entrySet();
		for(Iterator it = ns.iterator();it.hasNext();) {
			Map.Entry e = (Map.Entry)it.next();
			Node n = (Node)e.getValue();
			if(n.getParentId() == null || n.getParentId().equals("")) {
				root = n;
			} else {
				((Node)(list.get(n.getParentId()))).addChild(n);
			}
		}
		result = root.toString();
		data = "ddd";
		System.out.println(result);
		return "nodes";
	}
}
