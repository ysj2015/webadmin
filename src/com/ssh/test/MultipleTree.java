package com.ssh.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MultipleTree {
	public static void main(String[] args) {
		List dataList = VirtualDataGenerator.getVirtualResult();
		HashMap list = new HashMap();
		Node root = null;
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
		System.out.println(root.toString());
		
	}
}
