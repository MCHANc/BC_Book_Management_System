package com.bk.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.bk.dao.UserDao;
import com.bk.model.User;
import com.bk.util.DbUtil;
import com.bk.util.ToolUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Usermanager extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3078924177389559048L;
	private JTextField s_userNameTxt;
	private JTable userTable;
	
	private DbUtil dbUtil=new DbUtil();
	private UserDao userDao=new UserDao();
	private JTextField userNameTxt;
	private JTextField passwordTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Usermanager frame = new Usermanager();
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
	public Usermanager() {
		setClosable(true);
		setTitle("\u7528\u6237\u7EF4\u62A4\u754C\u9762");
		setBorder(null);
		setBounds(100, 100, 711, 494);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 16));
		
		s_userNameTxt = new JTextField();
		s_userNameTxt.setFont(new Font("����", Font.PLAIN, 15));
		s_userNameTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				userSearchActionPerformed(evt);
			}
		});
		btnNewButton.setIcon(new ImageIcon(Usermanager.class.getResource("/images/\u56FE\u4E66\u67E5\u627E .png")));
		btnNewButton.setFont(new Font("����", Font.PLAIN, 15));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\u7528\u6237\u7EF4\u62A4", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(182)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(s_userNameTxt, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addGap(54)
					.addComponent(btnNewButton)
					.addContainerGap(179, Short.MAX_VALUE))
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 711, Short.MAX_VALUE)
				.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 711, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(50)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton)
						.addComponent(s_userNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addGap(56)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 15));
		
		userNameTxt = new JTextField();
		userNameTxt.setFont(new Font("����", Font.PLAIN, 15));
		userNameTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u5BC6 \u7801\uFF1A");
		lblNewLabel_2.setFont(new Font("����", Font.PLAIN, 15));
		
		passwordTxt = new JTextField();
		passwordTxt.setFont(new Font("����", Font.PLAIN, 15));
		passwordTxt.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\u4FEE \u6539");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				userUpdateActionPerformed(evt);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(Usermanager.class.getResource("/images/\u4FEE\u6539.png")));
		btnNewButton_1.setFont(new Font("����", Font.PLAIN, 15));
		
		JButton btnNewButton_2 = new JButton("\u5220 \u9664");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				userDeleteActionPerformed(evt);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(Usermanager.class.getResource("/images/\u5220 \u9664.png")));
		btnNewButton_2.setFont(new Font("����", Font.PLAIN, 15));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(115)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnNewButton_1)
							.addGap(134)
							.addComponent(btnNewButton_2))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
							.addGap(60)
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(137, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2)
						.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addPreferredGap(ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		userTable = new JTable();
		userTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				userTableMousePressed(e);
			}
		});
		userTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u7528\u6237\u540D", "\u5BC6\u7801"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = -5656686532579478866L;
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(userTable);
		getContentPane().setLayout(groupLayout);
		
		this.fillTable(new User());
	}
	
	//�û�ɾ���¼�����
	private void userDeleteActionPerformed(ActionEvent evt) {
		// TODO �Զ����ɵķ������
		String userName=userNameTxt.getText();
		System.out.println(userName);
		if(ToolUtil.isEmpty(userName)) {
			JOptionPane.showMessageDialog(null, "��ѡ��Ҫɾ���ļ�¼");
			return;
		}
		int row=userTable.getSelectedRow();
		String id=(String) userTable.getValueAt(row, 0);
		int n=JOptionPane.showConfirmDialog(null, "ȷ��ɾ���ü�¼��");
		if(n==0) {
			Connection conn=null;
			try {
				conn=dbUtil.getconn();
				int deleteNum=userDao.delete(conn, id);
				if(deleteNum==1) {
					JOptionPane.showMessageDialog(null, "ɾ���ɹ���");
					this.resetValue();
					this.fillTable(new User());
				}
				else {
					JOptionPane.showMessageDialog(null, "ɾ��ʧ�ܣ�");
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "ɾ��ʧ�ܣ�");
			}finally {
				try {
					dbUtil.clossconn(conn);
				} catch (SQLException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			}
		}
	}

	//�û��޸��¼�����
	private void userUpdateActionPerformed(ActionEvent evt) {
		// TODO �Զ����ɵķ������
		String userName=userNameTxt.getText();
		String password=passwordTxt.getText();
		String matches="^\\w{6,20}$";
		boolean flag2=password.matches(matches);
		if(ToolUtil.isEmpty(userName)) {
			JOptionPane.showMessageDialog(null, "��ѡ��Ҫ�޸ĵļ�¼");
			return;
		}
		int row=userTable.getSelectedRow();
		String id=(String) userTable.getValueAt(row, 0);
		if(ToolUtil.isEmpty(userName)) {
			JOptionPane.showMessageDialog(null, "�û�������Ϊ��");
			return;
		}
		if(userName.indexOf(" ")!=-1) {
			JOptionPane.showMessageDialog(null, "�û������ܰ����ո�");
			return;
		}
		if(ToolUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(null, "���벻��Ϊ�գ�");
			return;
		}
		if(flag2==false) {
			JOptionPane.showMessageDialog(null, "����Ϊ6-20λ��ֻ������ĸ�����֣��»�����ɣ�");
			return;
		}
		if(userName.length()>20) {
			JOptionPane.showMessageDialog(null, "�û�������С��20λ");
			return;
		}
		User user=new User(Integer.parseInt(id),userName,password);
		Connection conn=null;
		try {
			conn=dbUtil.getconn();
			boolean flag=userDao.existUserName2(conn, user);
			if(flag) {
				JOptionPane.showMessageDialog(null, "�û����Ѵ���!");
				return;
			}
			int modifyNum=userDao.update(conn,user);
			if(modifyNum==1) {
				JOptionPane.showMessageDialog(null, "�޸ĳɹ�!");
				this.resetValue();
				this.fillTable(new User());
			}
			
			else {
				JOptionPane.showMessageDialog(null, "�޸�ʧ��!");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "�޸�ʧ��!");
		}finally {
			try {
				dbUtil.clossconn(conn);
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
	}

	//���ñ�
	private void resetValue() {
		// TODO �Զ����ɵķ������
		this.userNameTxt.setText("");
		this.passwordTxt.setText("");
	}

	//����е���¼�����
	private void userTableMousePressed(MouseEvent e) {
		// TODO �Զ����ɵķ������
		//��ȡѡ����
		int row=userTable.getSelectedRow();
		//��ȡ��
		userNameTxt.setText((String)userTable.getValueAt(row, 1));
		passwordTxt.setText((String)userTable.getValueAt(row, 2));
	}

	//�û���ѯ�¼�����
	private void userSearchActionPerformed(ActionEvent evt) {
		// TODO �Զ����ɵķ������
		String s_userName=this.s_userNameTxt.getText();
		User user=new User();
		user.setUsername(s_userName);
		this.fillTable(user);
	}

	//��ʼ�����
	private void fillTable(User user) {
		DefaultTableModel dtm=(DefaultTableModel) userTable.getModel();
		dtm.setRowCount(0);//���ó�0��,��ձ��
		Connection conn=null;
		try {
			conn=dbUtil.getconn();
			ResultSet rs=userDao.list(conn, user);
			while(rs.next()) {
				Vector<String> v=new Vector<String>();
				v.add(rs.getString("id"));
				v.add(rs.getString("username"));
				v.add(rs.getString("password"));
				dtm.addRow(v);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				dbUtil.clossconn(conn);
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
	}
	
}
