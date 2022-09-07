package com.bk.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {

	private String dbDriver="com.mysql.jdbc.Driver";//驱动名称
	private String dbUrl="jdbc:mysql://localhost:3306/bookmanager?characterEncoding=utf8&useSSL=true";//url
	private String dbusername="root";//数据库用户名
	private String dbpassword="1234";//数据库密码
	
	//连接数据库
	public Connection getconn()throws Exception{
		Class.forName(dbDriver);
		Connection conn=DriverManager.getConnection(dbUrl,dbusername,dbpassword);
		return conn;
	}
	//关闭连接
	public void clossconn(Connection conn)throws SQLException{
		if(conn!=null) {
			conn.close();
		}
	}
}
