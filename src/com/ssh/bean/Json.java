package com.ssh.bean;

import java.io.Serializable;

public class Json implements Serializable {
	private boolean result;
	private Object obj;
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	public boolean getResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	
}
