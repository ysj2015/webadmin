package com.ssh.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.ssh.bean.Json;
import com.ssh.bean.Node;
import com.ssh.bean.Tree;
import com.ssh.bean.User;
import com.ssh.service.ResourceService;

public class ResourceAction extends ActionSupport {
	@Autowired
	private ResourceService resourceService;
	private List<User> list;
	public String execute() {
		System.out.println("resource");
		List<Node> data = resourceService.getAllNodes();
//		System.out.println("showdata");
//		for(int i = 0;i < data.size();i ++) {
//			showData(data.get(i));
//		}
//		Set<Node> set = new HashSet<Node>();
		
		HashMap<Integer,Tree> map = new HashMap<Integer,Tree>();
		for(int i = 0;i < data.size();i ++) {
			Tree tr = new Tree();
			tr.setId(data.get(i).getId());
			tr.setText(data.get(i).getName());
			if(data.get(i).getParent()!=null) {
				tr.setPid(data.get(i).getParent().getId());
			}
			map.put(data.get(i).getId(), tr);
		}
		Set set = map.entrySet();
		List<Tree> mTreeList = new ArrayList<Tree>();
		for(Iterator it = set.iterator();it.hasNext();) {
			Map.Entry m = (Map.Entry)it.next();
			Tree tr = (Tree)m.getValue();
			if(tr.getPid() != 0) {
				if(map.get(tr.getPid()).getChildren()==null){
					map.get(tr.getPid()).setChildren(new ArrayList<Tree>());
				}
				map.get(tr.getPid()).getChildren().add(tr);
			} else {
				mTreeList.add(map.get(tr.getId()));
			}
		}
		for(int i = 0;i < mTreeList.size();i ++) {
			showTree(mTreeList.get(i));
		}
		
		try {
			ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
//			Json json = new Json();
//			json.setResult(true);
//			json.setObj(mTreeList);
//			System.out.println(JSON.toJSONString(json));
			
			ServletActionContext.getResponse().getWriter().write(JSON.toJSONString(mTreeList));
			ServletActionContext.getResponse().getWriter().flush();
			ServletActionContext.getResponse().getWriter().close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "nodes";
	}
	private void showTree(Tree t) {
		System.out.println(t.getText());
		if(t.getChildren()!=null && t.getChildren().size()!=0) {
			for(int i = 0;i < t.getChildren().size();i ++) {
				showTree(t.getChildren().get(i));
			}
		}
	}
	private void showData(Node n) {
		System.out.println(n.getName());
		System.out.println("--------");
		if(n.getParent()!=null){
			System.out.println(n.getParent().getId());
		} else {
			System.out.println("root");
		}
		System.out.println("--------");
//		if(n.getChildren() != null) {
//			for(Iterator<Node> it = n.getChildren().iterator();it.hasNext();) {
//				Node nn = it.next();
//				showData(nn);
//			}
//		}
	}
}
