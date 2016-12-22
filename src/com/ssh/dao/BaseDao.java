package com.ssh.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface BaseDao<T> {
	//保存
	public Serializable save(T o);
	//删除
	public void delete(T o);
	//更新
	public void update(T o);
	//更新或添加
	public void saveOrUpdate(T o);
	//通过HQL语句获取列表
	public List<T> find(String hql);
	public List<T> find(String hql, Map<String, Object> params);
	
	public T getById(Class<T> c, Serializable id);
	public void execute(String sql);
}
