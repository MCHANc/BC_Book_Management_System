package com.bk.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.bk.dao.UserDao;
import com.bk.model.User;
import com.bk.util.DbUtil;
import com.bk.util.ToolUtil;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Register extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7691663101831571168L;
	private JPanel contentPane;
	private JTextField userNameTxt;
	private JPasswordField passwordTxt;
	private JLabel lblNewLabel_3;
	private JPasswordField c_passwordTxt;
	private DbUtil dbUtil=new DbUtil();
	private UserDao userDao=new UserDao();
	private JButton btnNewButton_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		setTitle("\u6CE8\u518C\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 596, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setIcon(new ImageIcon(Register.class.getResource("/images/\u56FE\u4E66\u9986.png")));
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 23));
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 15));
		
		userNameTxt = new JTextField();
		userNameTxt.setFont(new Font("宋体", Font.PLAIN, 15));
		userNameTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u5BC6 \u7801\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 15));
		
		passwordTxt = new JPasswordField();
		passwordTxt.setFont(new Font("宋体", Font.PLAIN, 15));
		
		lblNewLabel_3 = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 15));
		
		c_passwordTxt = new JPasswordField();
		c_passwordTxt.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JButton btnNewButton = new JButton("\u6CE8 \u518C");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				userAddActionPerformed(evt);
			}
		});
		btnNewButton.setIcon(new ImageIcon(Register.class.getResource("/images/\u6CE8\u518C.png")));
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JButton btnNewButton_1 = new JButton("\u91CD \u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				resetValueActionPerformed(evt);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(Register.class.getResource("/images/\u91CD\u7F6E.png")));
		
		btnNewButton_2 = new JButton("\u8FD4 \u56DE");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				returnActionPerformed(e);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(Register.class.getResource("/images/\u8FD4\u56DE.png")));
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 15));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(62)
					.addComponent(btnNewButton)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_1)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblNewLabel_2)
												.addComponent(lblNewLabel_3))
											.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addPreferredGap(ComponentPlacement.RELATED)
													.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
														.addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)))
												.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
													.addGap(20)
													.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addComponent(btnNewButton_2)
														.addComponent(c_passwordTxt, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))))))
									.addGap(6)))
							.addGap(167))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton_1)
							.addGap(57))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(48)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addGap(42)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_1)
						.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(25)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(21)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(c_passwordTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3))
					.addPreferredGap(ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnNewButton_1)
							.addComponent(btnNewButton_2)))
					.addGap(56))
		);
		contentPane.setLayout(gl_contentPane);
		//设置JFrame居中显示
				this.setLocationRelativeTo(null);
	}

	//返回事件处理
	private void returnActionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		this.dispose();
		new Loginframe().setVisible(true);
	}

	//注册事件处理
	private void userAddActionPerformed(ActionEvent evt) {
		// TODO 自动生成的方法存根
		String userName=this.userNameTxt.getText();
		String password=new String(this.passwordTxt.getPassword());
		String c_password=new String(this.c_passwordTxt.getPassword());	
		boolean flag=password.equals(c_password);
		String matches="^\\w{6,20}$";
		boolean flag2=password.matches(matches);
		if(ToolUtil.isEmpty(userName)) {
			JOptionPane.showMessageDialog(null, "用户名不能为空！");
			return;
		}
		if(userName.indexOf(" ")!=-1) {
			JOptionPane.showMessageDialog(null, "用户名不能包含空格！");
			return;
		}
		if(ToolUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(null, "密码不能为空！");
			return;
		}
		if(flag2==false) {
			JOptionPane.showMessageDialog(null, "密码为6-20位且只能由字母，数字，下划线组成！");
			return;
		}
		
		if(ToolUtil.isEmpty(c_password)) {
			JOptionPane.showMessageDialog(null, "请确认密码！");
			return;
		}
		
		if(userName.length()>20) {
			JOptionPane.showMessageDialog(null, "用户名必须小于20位");
			return;
		}
		if(flag==false) {
			JOptionPane.showMessageDialog(null, "两次输入的密码不相同!");
			return;
		}
		User user=new User(userName,password);
		Connection conn=null;
		try {
			conn=dbUtil.getconn();
			boolean flag3=userDao.existUserName(conn, userName);
			if(flag3) {
				JOptionPane.showMessageDialog(null, "用户名已存在!");
				return;
			}
			int n=userDao.add(conn, user);
			if(n==1) {
				JOptionPane.showMessageDialog(null, "注册成功！");
				resetValue();
			}
			else {
				resetValue();
				JOptionPane.showMessageDialog(null, "注册失败！");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "注册失败！");
		}finally {
			try {
				dbUtil.clossconn(conn);
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}

	//重置事件处理
	private void resetValueActionPerformed(ActionEvent evt) {
		// TODO 自动生成的方法存根
		this.resetValue();
	}

	//重置表单
	private void resetValue() {
		// TODO 自动生成的方法存根
		this.userNameTxt.setText("");
		this.passwordTxt.setText("");
		this.c_passwordTxt.setText("");
	}
}
