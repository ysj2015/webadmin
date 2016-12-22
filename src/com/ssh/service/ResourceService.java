package com.ssh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ssh.bean.Node;
import com.ssh.bean.User;
import com.ssh.dao.BaseDao;

public interface ResourceService {
	
	public List<Node> getAllNodes();
}
