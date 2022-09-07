package com.bk.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import com.bk.dao.BookTypeDao;
import com.bk.model.BookType;
import com.bk.util.DbUtil;
import com.bk.util.ToolUtil;

public class BookTypeadd extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7527956650404513856L;
	private JTextField bookTypeNameTxt;
	private JTextArea bookTypeDescTxt;

	private DbUtil dbUtil=new DbUtil();
	private BookTypeDao bookTypeDao=new BookTypeDao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookTypeadd frame = new BookTypeadd();
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
	public BookTypeadd() {
		getContentPane().setFont(new Font("����", Font.PLAIN, 15));
		setBorder(null);
		setClosable(true);
		setTitle("\u56FE\u4E66\u7C7B\u522B\u6DFB\u52A0");
		setBounds(100, 100, 609, 416);
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u7C7B\u578B\u540D\u79F0\uFF1A");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 15));
		
		JLabel lblNewLabel_1 = new JLabel("\u56FE\u4E66\u7C7B\u578B\u63CF\u8FF0\uFF1A");
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 15));
		
		bookTypeNameTxt = new JTextField();
		bookTypeNameTxt.setFont(new Font("����", Font.PLAIN, 15));
		bookTypeNameTxt.setColumns(10);
		
		 bookTypeDescTxt = new JTextArea();
		 bookTypeDescTxt.setFont(new Font("����", Font.PLAIN, 15));
		
		JButton btnNewButton = new JButton("\u6DFB \u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookTypeAddActionPerformed(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(BookTypeadd.class.getResource("/images/\u6DFB\u52A0.png")));
		
		JButton btnNewButton_1 = new JButton("\u91CD \u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(BookTypeadd.class.getResource("/images/\u91CD\u7F6E.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(113)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.RELATED, 181, Short.MAX_VALUE)
							.addComponent(btnNewButton_1))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblNewLabel)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(bookTypeNameTxt))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblNewLabel_1)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(bookTypeDescTxt, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(145, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(84)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(43)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(bookTypeDescTxt, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addGap(44))
		);
		getContentPane().setLayout(groupLayout);
		
		//�����ı���߿�
		bookTypeDescTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185),1,false));
	}
	
	//ͼ����������¼�����
	private void bookTypeAddActionPerformed(ActionEvent evt) {
		// TODO �Զ����ɵķ������
		
		String bookTypeName=this.bookTypeNameTxt.getText();
		String bookTypeDesc=this.bookTypeDescTxt.getText();
		if(ToolUtil.isEmpty(bookTypeName)) {
			JOptionPane.showMessageDialog(null, "ͼ���������Ʋ���Ϊ�գ�");
			return;
		}
		
		BookType bookType=new BookType(bookTypeName,bookTypeDesc);
		Connection conn=null;
		try {
			conn=dbUtil.getconn();
			boolean flag=bookTypeDao.existBookTypeName(conn, bookTypeName);
			if(flag) {
				JOptionPane.showMessageDialog(null, "ͼ�������Ѵ���!");
				return;
			}
			int n=bookTypeDao.add(conn, bookType);
			if(n==1) {
				JOptionPane.showMessageDialog(null, "��ӳɹ���");
				resetValue();
			}
			else {
				resetValue();
				JOptionPane.showMessageDialog(null, "���ʧ�ܣ�");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "���ʧ�ܣ�");
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
	private void resetValue() {
		this.bookTypeNameTxt.setText("");
		this.bookTypeDescTxt.setText("");
	}
}
