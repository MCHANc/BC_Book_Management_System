package com.bk.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {

	private String dbDriver="com.mysql.jdbc.Driver";//��������
	private String dbUrl="jdbc:mysql://localhost:3306/bookmanager?characterEncoding=utf8&useSSL=true";//url
	private String dbusername="root";//���ݿ��û���
	private String dbpassword="1234";//���ݿ�����
	
	//�������ݿ�
	public Connection getconn()throws Exception{
		Class.forName(dbDriver);
		Connection conn=DriverManager.getConnection(dbUrl,dbusername,dbpassword);
		return conn;
	}
	//�ر�����
	public void clossconn(Connection conn)throws SQLException{
		if(conn!=null) {
			conn.close();
		}
	}
}
