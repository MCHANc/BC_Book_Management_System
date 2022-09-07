package com.bk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bk.model.User;
import com.bk.util.ToolUtil;
public class UserDao {

	//���õ�¼��֤����¼�ɹ����᷵�ص�¼�û���������Ϣ
	public User login(Connection conn,User user)throws SQLException{
		User resultuser=null;//�����û�
		String sql ="select * from user where username=? and password=?";//Ԥ����
		PreparedStatement pstmt=conn.prepareStatement(sql);//����Ԥ�������
		pstmt.setString(1, user.getUsername());//���õ�һ��?��ֵ
		pstmt.setString(2, user.getPassword());
		ResultSet rs=pstmt.executeQuery();//�����ѯ�ɹ������ؽ��������
		if(rs.next()) {
			resultuser=new User();//��������ݣ������û�ʵ����
			resultuser.setId(rs.getInt("id"));
			resultuser.setUsername(rs.getString("username"));//�����û�ʵ�����û���Ϊ������е��û���
			resultuser.setPassword(rs.getString("password"));
		}
		return resultuser;//�����û���ʵ����Ϣ
	}
	//�û���ѯ
		public ResultSet list(Connection conn,User user)throws SQLException{
			StringBuffer sb=new StringBuffer("select * from user");
			//�ж��û����ı����Ƿ�Ϊ�գ���Ϊ�գ���������
			if(ToolUtil.isnotEmpty(user.getUsername())) {
				sb.append(" and username like '%"+user.getUsername()+"%'");			
			}
			//sbת��Ϊ�ַ������ҽ���һ���ĵ���and�ĳ�where�γ�����
			PreparedStatement pstmt=conn.prepareStatement(sb.toString().replaceFirst("and", "where"));
			return pstmt.executeQuery();
			
		}
	//�û����
		public int add(Connection conn,User user)throws SQLException{
			String sql="insert into user values(null,?,?)";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			return pstmt.executeUpdate();
		}
	//�Ƿ����ظ��û�
		 public boolean existUserName(Connection conn,String userName)throws SQLException{
			 String sql="select * from user where username=?";
			 PreparedStatement pstmt=conn.prepareStatement(sql);
			 pstmt.setString(1, userName);
			 ResultSet rs=pstmt.executeQuery();
			 return rs.next();
		 }
	//�û��޸�
		 public int update(Connection conn,User user)throws SQLException{
			String sql="update user set username=?,password=? where id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setInt(3, user.getId());
			return pstmt.executeUpdate();
				
		} 
		//(�����޸��г��˴�id)�Ƿ����ظ��û�
		 public boolean existUserName2(Connection conn,User user)throws SQLException{
			 String sql="select * from user where id!=? and username=?";
			 PreparedStatement pstmt=conn.prepareStatement(sql);
			 pstmt.setInt(1, user.getId());
			 pstmt.setString(2, user.getUsername());
			 ResultSet rs=pstmt.executeQuery();
			 return rs.next();
		 }
	//�û�ɾ��
		 public int delete(Connection conn,String id)throws SQLException{
				String sql="delete from user where id=?";
				PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, id);
				return pstmt.executeUpdate();
			} 
}
