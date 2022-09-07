package com.bk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bk.model.User;
import com.bk.util.ToolUtil;
public class UserDao {

	//设置登录验证，登录成功，会返回登录用户的所有信息
	public User login(Connection conn,User user)throws SQLException{
		User resultuser=null;//声明用户
		String sql ="select * from user where username=? and password=?";//预处理
		PreparedStatement pstmt=conn.prepareStatement(sql);//创建预处理对象
		pstmt.setString(1, user.getUsername());//设置第一个?的值
		pstmt.setString(2, user.getPassword());
		ResultSet rs=pstmt.executeQuery();//如果查询成功，返回结果集对象
		if(rs.next()) {
			resultuser=new User();//如果有数据，返回用户实例化
			resultuser.setId(rs.getInt("id"));
			resultuser.setUsername(rs.getString("username"));//设置用户实例的用户名为结果集中的用户名
			resultuser.setPassword(rs.getString("password"));
		}
		return resultuser;//返回用户的实体信息
	}
	//用户查询
		public ResultSet list(Connection conn,User user)throws SQLException{
			StringBuffer sb=new StringBuffer("select * from user");
			//判断用户名文本框是否为空，不为空，则有条件
			if(ToolUtil.isnotEmpty(user.getUsername())) {
				sb.append(" and username like '%"+user.getUsername()+"%'");			
			}
			//sb转化为字符串并且将第一个的单词and改成where形成条件
			PreparedStatement pstmt=conn.prepareStatement(sb.toString().replaceFirst("and", "where"));
			return pstmt.executeQuery();
			
		}
	//用户添加
		public int add(Connection conn,User user)throws SQLException{
			String sql="insert into user values(null,?,?)";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			return pstmt.executeUpdate();
		}
	//是否有重复用户
		 public boolean existUserName(Connection conn,String userName)throws SQLException{
			 String sql="select * from user where username=?";
			 PreparedStatement pstmt=conn.prepareStatement(sql);
			 pstmt.setString(1, userName);
			 ResultSet rs=pstmt.executeQuery();
			 return rs.next();
		 }
	//用户修改
		 public int update(Connection conn,User user)throws SQLException{
			String sql="update user set username=?,password=? where id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setInt(3, user.getId());
			return pstmt.executeUpdate();
				
		} 
		//(用于修改中除了此id)是否有重复用户
		 public boolean existUserName2(Connection conn,User user)throws SQLException{
			 String sql="select * from user where id!=? and username=?";
			 PreparedStatement pstmt=conn.prepareStatement(sql);
			 pstmt.setInt(1, user.getId());
			 pstmt.setString(2, user.getUsername());
			 ResultSet rs=pstmt.executeQuery();
			 return rs.next();
		 }
	//用户删除
		 public int delete(Connection conn,String id)throws SQLException{
				String sql="delete from user where id=?";
				PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, id);
				return pstmt.executeUpdate();
			} 
}
