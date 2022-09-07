package com.bk.model;

//用户实体
public class User {

	private int id;//编号
	private String username;//用户名
	private String password;//密码
	
	public User() {
		super();
		// TODO 自动生成的构造函数存根
	}
	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	
	public User(int id, String username) {
		super();
		this.id = id;
		this.username = username;
	}

	public User(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
