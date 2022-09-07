package com.bk.dao;
//图书类型控制类

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bk.model.BookType;
import com.bk.util.ToolUtil;

public class BookTypeDao {
	//图书类型添加
	public int add(Connection conn,BookType bookType)throws SQLException{
		String sql="insert into booktype values(null,?,?)";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, bookType.getBookTypeName());
		pstmt.setString(2, bookType.getBookTypeDesc());
		return pstmt.executeUpdate();
	}
	
	//查询图书类型
	public ResultSet list(Connection conn,BookType bookType)throws SQLException{
		StringBuffer sb=new StringBuffer("select * from booktype");
		//判断图书类型文本框是否为空，不为空，则有条件
		if(ToolUtil.isnotEmpty(bookType.getBookTypeName())) {
			sb.append(" and bookTypeName like '%"+bookType.getBookTypeName()+"%'");			
		}
		//sb转化为字符串并且将第一个的单词and改成where形成条件
		PreparedStatement pstmt=conn.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
		
	}
	
	//删除图书类型
	public int delete(Connection conn,String id)throws SQLException{
		String sql="delete from booktype where id=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}
	
	//修改图书类型
	public int update(Connection conn,BookType bookType)throws SQLException{
		String sql="update booktype set bookTypeName=?,bookTypeDesc=? where id=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, bookType.getBookTypeName());
		pstmt.setString(2, bookType.getBookTypeDesc());
		pstmt.setInt(3, bookType.getId());
		return pstmt.executeUpdate();
		
	}
	//是否有重复图书类型名
	 public boolean existBookTypeName(Connection conn,String bookTypeName)throws SQLException{
		 String sql="select * from booktype where bookTypeName=?";
		 PreparedStatement pstmt=conn.prepareStatement(sql);
		 pstmt.setString(1, bookTypeName);
		 ResultSet rs=pstmt.executeQuery();
		 return rs.next();
	 }
	//(用于修改中除了此id)是否有重复图书类型
	 public boolean existBookTypeName2(Connection conn,BookType bookType)throws SQLException{
		 String sql="select * from booktype where id!=? and bookTypeName=?";
		 PreparedStatement pstmt=conn.prepareStatement(sql);
		 pstmt.setInt(1, bookType.getId());
		 pstmt.setString(2, bookType.getBookTypeName());
		 ResultSet rs=pstmt.executeQuery();
		 return rs.next();
	 }
}
