package com.ssh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ssh.bean.Node;
import com.ssh.bean.User;
import com.ssh.dao.BaseDao;
import com.ssh.service.ResourceService;

@Service
public class ResourceServiceImpl implements ResourceService{
	@Autowired
	@Qualifier("baseDao")
	private BaseDao<Node> baseDao;
	public List<Node> getAllNodes() {
		System.out.println("getAllNodes");
		return baseDao.find("from Node");
	}
}
