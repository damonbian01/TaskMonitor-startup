package com.cstnet.cnnic.test;

public class TestDbConf {
	private String driverClass;
	private String url;
	private String userName;
	private String passWd;
	
	
	public String getDriverClass() {
		return driverClass;
	}
	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWd() {
		return passWd;
	}
	public void setPassWd(String passWd) {
		this.passWd = passWd;
	}
	@Override
	public String toString() {
		return "TestDbConf [driverClass=" + driverClass + ", url=" + url + ", userName=" + userName + ", passWd="
				+ passWd + "]";
	}

}
