package com.jxust.svsh.entity;

public class User {
	private int userid;//用户id
	private String ename;//用户名
	private String username;//用户
	private String adderss;//用户地址
	private String statrtime;//注册时间
	private String endtiem;//停用时间
	
	public User() {
		super();
	}
	public User(int userid, String ename, String username, String adderss,
			String statrtime, String endtiem) {
		super();
		this.userid = userid;
		this.ename = ename;
		this.username = username;
		this.adderss = adderss;
		this.statrtime = statrtime;
		this.endtiem = endtiem;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAdderss() {
		return adderss;
	}
	public void setAdderss(String adderss) {
		this.adderss = adderss;
	}
	public String getStatrtime() {
		return statrtime;
	}
	public void setStatrtime(String statrtime) {
		this.statrtime = statrtime;
	}
	public String getEndtiem() {
		return endtiem;
	}
	public void setEndtiem(String endtiem) {
		this.endtiem = endtiem;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", ename=" + ename + ", username="
				+ username + ", adderss=" + adderss + ", statrtime="
				+ statrtime + ", endtiem=" + endtiem + "]";
	}
	
	
	

}
