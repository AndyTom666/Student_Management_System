package com.yanzhuang.po;

public class WeiXinConfigInfo {
	private String appid;
	private String secret;
	public AccessToken token;
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getSecret() {
		return secret;
	}
	public void setSecret(String secret) {
		this.secret = secret;
	}

}
