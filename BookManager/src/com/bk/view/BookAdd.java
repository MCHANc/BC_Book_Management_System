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

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import com.bk.dao.BookDao;
import com.bk.dao.BookTypeDao;
import com.bk.model.Book;
import com.bk.model.BookType;
import com.bk.util.DbUtil;
import com.bk.util.ToolUtil;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BookAdd extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2530311481394365137L;
	private JTextField bookNameTxt;
	private JTextField authorTxt;
	private JTextField priceTxt;
	private JComboBox<BookType> bookTypeJcb;
	private JTextArea bookDescTxt;
	
	private DbUtil dbUtil=new DbUtil();
	private BookTypeDao bookTypeDao=new BookTypeDao();
	private BookDao bookDao=new BookDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookAdd frame = new BookAdd();
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
	public BookAdd() {
		setClosable(true);
		setTitle("\u56FE\u4E66\u6DFB\u52A0");
		setBorder(null);
		setBounds(100, 100, 692, 533);
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u540D\u79F0:");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		
		bookNameTxt = new JTextField();
		bookNameTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u4F5C \u8005\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 15));
		
		authorTxt = new JTextField();
		authorTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u4EF7 \u683C\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 15));
		
		priceTxt = new JTextField();
		priceTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u56FE\u4E66\u7C7B\u578B");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 15));
		
		 bookTypeJcb = new JComboBox<BookType>();
		 bookTypeJcb.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JLabel lblNewLabel_4 = new JLabel("\u7B80 \u4ECB\uFF1A");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 15));
		
		 bookDescTxt = new JTextArea();
		
		JButton btnNewButton = new JButton("\u6DFB  \u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookAddActionPerformed(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(BookAdd.class.getResource("/images/\u6DFB\u52A0.png")));
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JButton btnNewButton_2 = new JButton("\u91CD \u7F6E");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(BookAdd.class.getResource("/images/\u91CD\u7F6E.png")));
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 15));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(84)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGap(59)
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnNewButton_2))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel_4))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(priceTxt)
										.addComponent(bookNameTxt, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))
									.addGap(57)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblNewLabel_1)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblNewLabel_3)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(bookTypeJcb, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
								.addComponent(bookDescTxt))))
					.addContainerGap(171, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addGap(41)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_2)
						.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3)
						.addComponent(bookTypeJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(52)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(bookDescTxt, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_2))
					.addGap(105))
		);
		getContentPane().setLayout(groupLayout);
		//设置文本域边框
				bookDescTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185),1,false));
				fillBookType();

	}
	
	//重置事件处理
	private void resetValueActionPerformed(ActionEvent evt) {
		// TODO 自动生成的方法存根
		this.resetValue();
	}

	//图书添加事件处理
	protected void bookAddActionPerformed(ActionEvent evt) {
		// TODO 自动生成的方法存根
		String bookName=this.bookNameTxt.getText();
		String author=this.authorTxt.getText();
		String price=this.priceTxt.getText();
		String bookDesc=this.bookDescTxt.getText();
		
		if(ToolUtil.isEmpty(bookName)) {
			JOptionPane.showMessageDialog(null, "图书名称不能为空！");
			return;
		}
		if(ToolUtil.isEmpty(author)) {
			JOptionPane.showMessageDialog(null, "作者不能为空！");
			return;
		}
		if(ToolUtil.isEmpty(price)) {
			JOptionPane.showMessageDialog(null, "价格不能为空！");
			return;
		}
		if(price.indexOf(" ")!=-1) {
			JOptionPane.showMessageDialog(null, "价格不能包含空格！");
			return;
		}
		
		BookType bookType=(BookType)bookTypeJcb.getSelectedItem();
		int bookTypeId=bookType.getId();
		
		Book book=new Book(bookName, author, Float.parseFloat(price),  bookTypeId,  bookDesc);
		
		Connection conn=null;
		try {
			conn=dbUtil.getconn();
			int addNum=bookDao.add(conn, book);
			if(addNum==1) {
				JOptionPane.showMessageDialog(null, "图书添加成功！");
				resetValue();
			}
			else {
				JOptionPane.showMessageDialog(null, "图书添加失败！");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "图书添加失败！");
		}finally {
			try {
				dbUtil.clossconn(conn);
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}

	//重置表单
	private void resetValue() {
		// TODO 自动生成的方法存根
		this.bookNameTxt.setText("");
		this.bookDescTxt.setText("");
		this.authorTxt.setText("");
		this.priceTxt.setText("");
		if(this.bookTypeJcb.getItemCount()>0) {
			this.bookTypeJcb.setSelectedIndex(0);
		}
	}

	//初始化图书类别下拉框
	public void fillBookType() {
		Connection conn=null;
		BookType bookType=null;
		try {
			conn=dbUtil.getconn();
			ResultSet rs=bookTypeDao.list(conn, new BookType());
			while(rs.next()) {
				bookType=new BookType();
				bookType.setId(rs.getInt("id"));
				bookType.setBookTypeName(rs.getString("bookTypeName"));
				this.bookTypeJcb.addItem(bookType);
			}
		} catch (Exception e) { 
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			
		}
	}
}
