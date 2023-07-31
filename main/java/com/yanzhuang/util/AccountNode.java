package com.yanzhuang.util;

import javax.servlet.http.HttpSession;

public class AccountNode {
	private String stuid;
	private HttpSession session;
	public AccountNode(String stuid, HttpSession session) {
		super();
		this.stuid = stuid;
		this.session = session;
	}
	public String getStuid() {
		return stuid;
	}
	public void setStuid(String stuid) {
		this.stuid = stuid;
	}
	public HttpSession getSession() {
		return session;
	}
	public void setSession(HttpSession session) {
		this.session = session;
	}

}
