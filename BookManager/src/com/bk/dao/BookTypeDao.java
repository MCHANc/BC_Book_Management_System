package com.bk.dao;
//ͼ�����Ϳ�����

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bk.model.BookType;
import com.bk.util.ToolUtil;

public class BookTypeDao {
	//ͼ���������
	public int add(Connection conn,BookType bookType)throws SQLException{
		String sql="insert into booktype values(null,?,?)";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, bookType.getBookTypeName());
		pstmt.setString(2, bookType.getBookTypeDesc());
		return pstmt.executeUpdate();
	}
	
	//��ѯͼ������
	public ResultSet list(Connection conn,BookType bookType)throws SQLException{
		StringBuffer sb=new StringBuffer("select * from booktype");
		//�ж�ͼ�������ı����Ƿ�Ϊ�գ���Ϊ�գ���������
		if(ToolUtil.isnotEmpty(bookType.getBookTypeName())) {
			sb.append(" and bookTypeName like '%"+bookType.getBookTypeName()+"%'");			
		}
		//sbת��Ϊ�ַ������ҽ���һ���ĵ���and�ĳ�where�γ�����
		PreparedStatement pstmt=conn.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
		
	}
	
	//ɾ��ͼ������
	public int delete(Connection conn,String id)throws SQLException{
		String sql="delete from booktype where id=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}
	
	//�޸�ͼ������
	public int update(Connection conn,BookType bookType)throws SQLException{
		String sql="update booktype set bookTypeName=?,bookTypeDesc=? where id=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, bookType.getBookTypeName());
		pstmt.setString(2, bookType.getBookTypeDesc());
		pstmt.setInt(3, bookType.getId());
		return pstmt.executeUpdate();
		
	}
	//�Ƿ����ظ�ͼ��������
	 public boolean existBookTypeName(Connection conn,String bookTypeName)throws SQLException{
		 String sql="select * from booktype where bookTypeName=?";
		 PreparedStatement pstmt=conn.prepareStatement(sql);
		 pstmt.setString(1, bookTypeName);
		 ResultSet rs=pstmt.executeQuery();
		 return rs.next();
	 }
	//(�����޸��г��˴�id)�Ƿ����ظ�ͼ������
	 public boolean existBookTypeName2(Connection conn,BookType bookType)throws SQLException{
		 String sql="select * from booktype where id!=? and bookTypeName=?";
		 PreparedStatement pstmt=conn.prepareStatement(sql);
		 pstmt.setInt(1, bookType.getId());
		 pstmt.setString(2, bookType.getBookTypeName());
		 ResultSet rs=pstmt.executeQuery();
		 return rs.next();
	 }
}
