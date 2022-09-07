package com.bk.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.bk.dao.UserDao;
import com.bk.model.User;
import com.bk.util.DbUtil;
import com.bk.util.ToolUtil;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Useradd extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1961922773679375691L;

	private JTextField userNameTxt;

	private DbUtil dbUtil=new DbUtil();
	private UserDao userDao=new UserDao();
	private JPasswordField passwordTxt;
	private JPasswordField c_passwordTxt;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Useradd frame = new Useradd();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Useradd() {
		setClosable(true);
		setBorder(null);
		setTitle("\u6CE8\u518C\u754C\u9762");
		setBounds(100, 100, 650, 474);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 15));
		
		userNameTxt = new JTextField();
		userNameTxt.setFont(new Font("����", Font.PLAIN, 15));
		userNameTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6 \u7801\uFF1A");
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 15));
		
		JLabel lblNewLabel_2 = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		lblNewLabel_2.setFont(new Font("����", Font.PLAIN, 15));
		
		JButton btnNewButton = new JButton("\u6CE8 \u518C");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				userAddActionPerformed(evt);
			}
		});
		btnNewButton.setIcon(new ImageIcon(Useradd.class.getResource("/images/\u6CE8\u518C.png")));
		btnNewButton.setFont(new Font("����", Font.PLAIN, 15));
		
		JButton btnNewButton_1 = new JButton("\u91CD \u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				resetValueActionPerformed(evt);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(Useradd.class.getResource("/images/\u91CD\u7F6E.png")));
		btnNewButton_1.setFont(new Font("����", Font.PLAIN, 15));
		
		passwordTxt = new JPasswordField();
		passwordTxt.setFont(new Font("����", Font.PLAIN, 15));
		
		c_passwordTxt = new JPasswordField();
		c_passwordTxt.setFont(new Font("����", Font.PLAIN, 15));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(166)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnNewButton)
							.addGap(117)
							.addComponent(btnNewButton_1))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblNewLabel_2)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(c_passwordTxt))
							.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(lblNewLabel)
									.addComponent(lblNewLabel_1))
								.addGap(18)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(userNameTxt, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
									.addComponent(passwordTxt)))))
					.addContainerGap(181, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(79)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel)
						.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(41)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_1)
						.addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(42)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_2)
						.addComponent(c_passwordTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addGap(96))
		);
		getContentPane().setLayout(groupLayout);

	}
	
	//�û�����¼�����
	private void userAddActionPerformed(ActionEvent evt) {
		// TODO �Զ����ɵķ������
		String userName=this.userNameTxt.getText();
		String password=new String(this.passwordTxt.getPassword());
		String c_password=new String(this.c_passwordTxt.getPassword());
		boolean flag=password.equals(c_password);
		String matches="^\\w{6,20}$";
		boolean flag2=password.matches(matches);
		if(ToolUtil.isEmpty(userName)) {
			JOptionPane.showMessageDialog(null, "�û�������Ϊ�գ�");
			return;
		}
		if(ToolUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(null, "���벻��Ϊ�գ�");
			return;
		}
		if(ToolUtil.isEmpty(c_password)) {
			JOptionPane.showMessageDialog(null, "��ȷ�����룡");
			return;
		}
		if(userName.indexOf(" ")!=-1) {
			JOptionPane.showMessageDialog(null, "�û������ܰ����ո�");
			return;
		}
		if(userName.length()>20) {
			JOptionPane.showMessageDialog(null, "�û�������С��20λ");
			return;
		}
		if(flag2==false) {
			JOptionPane.showMessageDialog(null, "����Ϊ6-20λ��ֻ������ĸ�����֣��»�����ɣ�");
			return;
		}
		if(flag==false) {
			JOptionPane.showMessageDialog(null, "������������벻��ͬ!");
			return;
		}
		User user=new User(userName,password);
		Connection conn=null;
		try {
			conn=dbUtil.getconn();
			boolean flag3=userDao.existUserName(conn, userName);
			if(flag3) {
				JOptionPane.showMessageDialog(null, "�û����Ѵ���!");
				return;
			}
			int n=userDao.add(conn, user);
			if(n==1) {
				JOptionPane.showMessageDialog(null, "ע��ɹ���");
				resetValue();
			}
			else {
				resetValue();
				JOptionPane.showMessageDialog(null, "ע��ʧ�ܣ�");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "ע��ʧ�ܣ�");
		}finally {
			try {
				dbUtil.clossconn(conn);
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
	}

	//�����¼�����
	private void resetValueActionPerformed(ActionEvent evt) {
		// TODO �Զ����ɵķ������
		this.resetValue();
	}

	//���ñ�
	public void resetValue() {
		this.userNameTxt.setText("");
		this.passwordTxt.setText("");
		this.c_passwordTxt.setText("");
	}
}
