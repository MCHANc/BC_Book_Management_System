package com.bk.dao;

//ͼ�������
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bk.model.Book;
import com.bk.util.ToolUtil;



public class BookDao {

	//ͼ�����
	public int add(Connection conn,Book book)throws SQLException{
		String sql="insert into book values(null,?,?,?,?,?)";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, book.getBookName());
		pstmt.setString(2, book.getAuthor());
		pstmt.setFloat(3, book.getPrice());
		pstmt.setInt(4, book.getBookTypeId());
		pstmt.setString(5, book.getBookDesc());
		return pstmt.executeUpdate();
	}
	
	//ͼ���ѯ
	 public ResultSet list(Connection conn,Book book)throws SQLException{
		 StringBuffer sb=new StringBuffer("select * from book b,booktype bt where b.bookTypeId=bt.id");
			//�ж�ͼ�������ı����Ƿ�Ϊ�գ���Ϊ�գ���������
			if(ToolUtil.isnotEmpty(book.getBookName())) {
				sb.append(" and b.bookName like '%"+book.getBookName()+"%'");			
			}
			if(ToolUtil.isnotEmpty(book.getAuthor())) {
				sb.append(" and b.author like '%"+book.getAuthor()+"%'");			
			}
			if(book.getBookTypeId()!=null && book.getBookTypeId()!=-1) {
				sb.append(" and b.bookTypeId="+book.getBookTypeId());
			}
			//sbת��Ϊ�ַ������ҽ���һ���ĵ���and�ĳ�where�γ�����
			PreparedStatement pstmt=conn.prepareStatement(sb.toString());
			return pstmt.executeQuery();
	}
	 
	 //ͼ��ɾ��
	 public int delete(Connection conn,String id)throws SQLException {
		 String sql="delete from book where id=?";
		  PreparedStatement pstmt=conn.prepareStatement(sql);
		  pstmt.setString(1, id);
		  return pstmt.executeUpdate();
	 }
	 
	 //ͼ���޸�
	 public int update(Connection conn,Book book)throws SQLException{
		 String sql="update book set bookName=?,author=?,price=?,bookTypeId=?,bookDesc=? where id=?";
		 PreparedStatement pstmt=conn.prepareStatement(sql);
		 pstmt.setString(1, book.getBookName());
		 pstmt.setString(2, book.getAuthor());
		 pstmt.setFloat(3, book.getPrice());
		 pstmt.setInt(4, book.getBookTypeId());
		 pstmt.setString(5, book.getBookDesc());
		 pstmt.setInt(6, book.getId());
		 return pstmt.executeUpdate();	
	 }
	 
	 //ͼ���������Ƿ���ͼ��
	 public boolean existBookByBookTypeId(Connection conn,String bookTypeId)throws SQLException{
		 String sql="select * from book where bookTypeID=?";
		 PreparedStatement pstmt=conn.prepareStatement(sql);
		 pstmt.setString(1, bookTypeId);
		 ResultSet rs=pstmt.executeQuery();
		 return rs.next();
	 }
}
