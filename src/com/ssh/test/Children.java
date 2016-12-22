package com.ssh.test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Children implements Serializable{
	private List<Node> list = new ArrayList<Node>();
	public List<Node> getList() {
		return list;
	}
	public void setList(List<Node> list) {
		this.list = list;
	}
	public int getSize() {
		return list.size();
	}
	public void addChild(Node n) {
		list.add(n);
	}
	public void sortChildren() {
		HashMap hm = new HashMap();
		Set entrySet = hm.entrySet();
		for(Iterator it = entrySet.iterator();it.hasNext();){
			
		}
	}
	//拼接孩子节点的json字符串
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		for(Iterator it = list.iterator();it.hasNext();) {
			sb.append(((Node)it.next()).toString());
			sb.append(",");
		}
		String result = sb.toString();
		String res = result.substring(0, result.length()-1);
		res = res + "]";
		return res;
	}
	class NodeComparator implements Comparator {

		@Override
		public int compare(Object o1, Object o2) {
			// TODO Auto-generated method stub
			int id1 = Integer.parseInt(((Node)o1).getId());
			int id2 = Integer.parseInt(((Node)o2).getId());
			if(id1 == id2)
				return 0;
			else if(id1 < id2)
				return -1;
			else return 1;
		}
		
	}
}
