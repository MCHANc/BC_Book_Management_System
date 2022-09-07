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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Loginframe extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5477406671525577911L;
	private JPanel contentPane;
	private JTextField userNameTxt;

	private DbUtil dbUtil=new DbUtil();
	private UserDao userDao=new UserDao();
	private JPasswordField passwordTxt;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loginframe frame = new Loginframe();
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
	public Loginframe() {
		setResizable(false);
		setTitle("\u767B\u5F55\u7A97\u53E3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 578, 418);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setIcon(new ImageIcon(Loginframe.class.getResource("/images/\u56FE\u4E66\u9986.png")));
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 23));
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel_1.setIcon(new ImageIcon(Loginframe.class.getResource("/images/\u7528\u6237.png")));
		
		JLabel lblNewLabel_2 = new JLabel("\u5BC6  \u7801\uFF1A");
		lblNewLabel_2.setIcon(new ImageIcon(Loginframe.class.getResource("/images/\u5BC6\u7801.png")));
		
		userNameTxt = new JTextField();
		userNameTxt.setColumns(10);
		
		JButton LoginButton = new JButton("\u767B\u5F55");
		LoginButton.setIcon(new ImageIcon(Loginframe.class.getResource("/images/\u767B\u5F55.png")));
		LoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginActionPerfomed(e);
			}
		});
		
		JButton RegisterButton = new JButton("\u6CE8\u518C");
		RegisterButton.setIcon(new ImageIcon(Loginframe.class.getResource("/images/\u6CE8\u518C.png")));
		RegisterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registerActionPerformed(e);
			}
		});
		
		JButton ResetButton = new JButton("\u91CD\u7F6E");
		ResetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		ResetButton.setIcon(new ImageIcon(Loginframe.class.getResource("/images/\u91CD\u7F6E.png")));
		
		passwordTxt = new JPasswordField();
		passwordTxt.setFont(new Font("宋体", Font.PLAIN, 15));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(184)
							.addComponent(lblNewLabel))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(139)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(lblNewLabel_1)
									.addComponent(LoginButton, Alignment.TRAILING))
								.addComponent(lblNewLabel_2))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(12)
									.addComponent(RegisterButton)
									.addGap(18)
									.addComponent(ResetButton))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(passwordTxt, Alignment.LEADING)
									.addComponent(userNameTxt, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)))))
					.addContainerGap(148, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(23)
					.addComponent(lblNewLabel)
					.addGap(62)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2))
					.addGap(53)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(LoginButton)
						.addComponent(RegisterButton)
						.addComponent(ResetButton))
					.addContainerGap(128, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
		//设置JFrame居中显示
		this.setLocationRelativeTo(null);
	}

	//注册事件处理
	private void registerActionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		this.dispose();
		new Register().setVisible(true);
	}

	//登录事件处理
	protected void loginActionPerfomed(ActionEvent e) {
		
		String userName=this.userNameTxt.getText();
		String password=new String(this.passwordTxt.getText());
		if(ToolUtil.isEmpty(userName) || ToolUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(null, "用户名或密码不能为空");
			return;
		}
		
		User user=new User(userName,password);//封装一个用户进行查询
		Connection conn=null;	
		try {
			conn=dbUtil.getconn();
			User currentuser=userDao.login(conn, user);
			if(currentuser!=null) {
				//登录成功一定会返回一条用户的所有信息
			JOptionPane.showMessageDialog(null,"登陆成功！");
			this.dispose();
			new Mainframe().setVisible(true);
			}
			else {
				JOptionPane.showMessageDialog(null, "用户名或密码错误");
			}
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}finally {
			try {
				dbUtil.clossconn(conn);
			} catch (SQLException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
		}
	}

	//重置事件处理
	private void resetValueActionPerformed(ActionEvent evt) {
		
		this.userNameTxt.setText("");
		this.passwordTxt.setText("");
	}
}
