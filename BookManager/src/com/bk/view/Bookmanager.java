package com.bk.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.bk.dao.BookDao;
import com.bk.dao.BookTypeDao;
import com.bk.model.Book;
import com.bk.model.BookType;
import com.bk.util.DbUtil;
import com.bk.util.ToolUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Bookmanager extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6053608908945986365L;
	private JTable bookTable;
	private JTextField s_bookNameTxt;
	private JTextField s_authorTxt;
	private JComboBox<BookType> s_bookTypeJcb;
	private JTextArea bookDescTxt;
	private JComboBox<BookType> bookTypeJcb;
	
	private DbUtil dbUtil=new DbUtil();
	private BookDao bookDao=new BookDao();
	private BookTypeDao bookTypeDao=new BookTypeDao();
	private JTextField idTxt;
	private JTextField bookNameTxT;
	private JTextField authorTxt;
	private JTextField priceTxt;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bookmanager frame = new Bookmanager();
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
	public Bookmanager() {
		setClosable(true);
		setTitle("\u56FE\u4E66\u7EF4\u62A4");
		setBorder(null);
		setBounds(100, 100, 732, 599);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		
		s_bookNameTxt = new JTextField();
		s_bookNameTxt.setFont(new Font("宋体", Font.PLAIN, 15));
		s_bookNameTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u4F5C \u8005\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 15));
		
		s_authorTxt = new JTextField();
		s_authorTxt.setFont(new Font("宋体", Font.PLAIN, 15));
		s_authorTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u56FE\u4E66\u7C7B\u522B");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 15));
		
		 s_bookTypeJcb = new JComboBox<BookType>();
		s_bookTypeJcb.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookSearchActionPerformed(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(Bookmanager.class.getResource("/images/\u56FE\u4E66\u67E5\u627E .png")));
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\u56FE\u4E66\u7EF4\u62A4", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)), "\u56FE\u4E66\u7EF4\u62A4", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(s_bookNameTxt, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(s_authorTxt, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addGap(19)
					.addComponent(lblNewLabel_2)
					.addGap(18)
					.addComponent(s_bookTypeJcb, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(btnNewButton)
					.addContainerGap(78, Short.MAX_VALUE))
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(56)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(s_bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(2))
						.addComponent(lblNewLabel_1)
						.addComponent(s_authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(s_bookTypeJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2)
						.addComponent(btnNewButton))
					.addGap(51)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
					.addGap(34)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_3 = new JLabel("\u7F16 \u53F7\uFF1A");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 15));
		
		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setFont(new Font("宋体", Font.PLAIN, 15));
		idTxt.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 15));
		
		bookNameTxT = new JTextField();
		bookNameTxT.setFont(new Font("宋体", Font.PLAIN, 15));
		bookNameTxT.setColumns(10);
		
		authorTxt = new JTextField();
		authorTxt.setFont(new Font("宋体", Font.PLAIN, 15));
		authorTxt.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("\u4F5C \u8005\uFF1A");
		lblNewLabel_6.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JLabel lblNewLabel_5 = new JLabel("\u4EF7 \u683C\uFF1A");
		lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 15));
		
		priceTxt = new JTextField();
		priceTxt.setFont(new Font("宋体", Font.PLAIN, 15));
		priceTxt.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("\u56FE\u4E66\u7C7B\u522B");
		lblNewLabel_7.setFont(new Font("宋体", Font.PLAIN, 15));
		
		 bookTypeJcb = new JComboBox<BookType>();
		bookTypeJcb.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JLabel lblNewLabel_8 = new JLabel("\u56FE\u4E66\u7B80\u4ECB\uFF1A");
		lblNewLabel_8.setFont(new Font("宋体", Font.PLAIN, 15));
		
		 bookDescTxt = new JTextArea();
		
		JButton btnNewButton_1 = new JButton("\u4FEE \u6539");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				bookUpdateActionPerformed(evt);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(Bookmanager.class.getResource("/images/\u4FEE\u6539.png")));
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JButton btnNewButton_2 = new JButton("\u5220 \u9664");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				bookDeleteActionPerforme(evt);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(Bookmanager.class.getResource("/images/\u5220 \u9664.png")));
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 15));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(33)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_8)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(bookDescTxt, GroupLayout.PREFERRED_SIZE, 297, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_3)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_6)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(47)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_4)
								.addComponent(lblNewLabel_5))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addContainerGap(328, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
										.addComponent(btnNewButton_1)
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(bookNameTxT, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
											.addGap(57)
											.addComponent(lblNewLabel_7)))
									.addGap(18)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(bookTypeJcb, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addGap(90))
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(btnNewButton_2)
											.addContainerGap())))))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(17)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(bookTypeJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_7)
						.addComponent(bookNameTxT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4)
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3))
					.addGap(20)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_6)
						.addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_5)
						.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(33)
							.addComponent(lblNewLabel_8)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton_1)
								.addComponent(btnNewButton_2)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(18)
							.addComponent(bookDescTxt, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(27, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		bookTable = new JTable();
		bookTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent met) {
				bookTableMousePressed(met);
			}
		});
		bookTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u56FE\u4E66\u540D\u79F0", "\u4F5C\u8005", "\u4EF7\u683C", "\u7B80\u4ECB", "\u56FE\u4E66\u7C7B\u578B"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = -4650227136843340378L;
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		bookTable.getColumnModel().getColumn(4).setPreferredWidth(172);
		bookTable.getColumnModel().getColumn(5).setPreferredWidth(119);
		scrollPane.setViewportView(bookTable);
		getContentPane().setLayout(groupLayout);
		//设置文本域边框
		bookDescTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185),1,false));
		
		this.fillBookType("search");
		this.fillBookType("modify");
		this.fillTable(new Book());
	}
	
	//图书删除事件处理
	private void bookDeleteActionPerforme(ActionEvent evt) {
		// TODO 自动生成的方法存根
		String id=idTxt.getText();
		if(ToolUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请选择要删除的记录");
			return;
		}
		int n=JOptionPane.showConfirmDialog(null, "确定删除该记录吗？");
		if(n==0) {
			Connection conn=null;
			try {
				conn=dbUtil.getconn();
				int deleteNum=bookDao.delete(conn, id);
				if(deleteNum==1) {
					JOptionPane.showMessageDialog(null, "删除成功！");
					this.resetValue();
					this.fillTable(new Book());
				}
				else {
					JOptionPane.showMessageDialog(null, "删除失败！");
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "删除失败！");
			}finally {
				try {
					dbUtil.clossconn(conn);
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		}
	}

	//图书修改事件处理
	private void bookUpdateActionPerformed(ActionEvent evt) {
		// TODO 自动生成的方法存根
		String id=this.idTxt.getText();
		if(ToolUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请选择要修改的记录");
			return;
		}
		String bookName=this.bookNameTxT.getText();
		String author=this.authorTxt.getText();
		String price=this.priceTxt.getText();
		String bookDesc=this.bookDescTxt.getText();
		BookType bookType=(BookType)bookTypeJcb.getSelectedItem();
		int bookTypeId=bookType.getId();
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
		Book book=new Book(Integer.parseInt(id),  bookName,  author, Float.parseFloat(price) ,  bookTypeId,  bookDesc);
		Connection conn=null;
		try {
			conn=dbUtil.getconn();
			int updateNum=bookDao.update(conn, book);
			if(updateNum==1) {
				JOptionPane.showMessageDialog(null, "图书修改成功！");
				resetValue();
				this.fillTable(new Book());
			}
			else {
				JOptionPane.showMessageDialog(null, "图书修改失败！");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "图书修改失败！");
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
		this.idTxt.setText("");
		this.bookNameTxT.setText("");
		this.bookDescTxt.setText("");
		this.authorTxt.setText("");
		this.priceTxt.setText("");
		if(this.bookTypeJcb.getItemCount()>0) {
			this.bookTypeJcb.setSelectedIndex(0);
		}
	}

	//表格行点击事件处理
	private void bookTableMousePressed(MouseEvent met) {
		// TODO 自动生成的方法存根
		int row=this.bookTable.getSelectedRow();
		this.idTxt.setText((String)bookTable.getValueAt(row, 0));
		this.bookNameTxT.setText((String)bookTable.getValueAt(row, 1));
		this.authorTxt.setText((String)bookTable.getValueAt(row, 2));
		this.priceTxt.setText((Float)bookTable.getValueAt(row, 3)+"");
		this.bookDescTxt.setText((String)bookTable.getValueAt(row, 4));
		String bookTypeName=(String)this.bookTable.getValueAt(row, 5);
		int n=this.bookTypeJcb.getItemCount();
		for(int i=0;i<n;i++) {
			BookType item=(BookType)this.bookTypeJcb.getItemAt(i);
			if(item.getBookTypeName().equals(bookTypeName)) {
				this.bookTypeJcb.setSelectedIndex(i);
			}
		}
	}

	//图书查询事件处理
	private void bookSearchActionPerformed(ActionEvent evt) {
		// TODO 自动生成的方法存根
		String bookName=this.s_bookNameTxt.getText();
		String author=this.s_authorTxt.getText();
		BookType bookType=(BookType)this.s_bookTypeJcb.getSelectedItem();
		int bookTypeId=bookType.getId();
		Book book=new Book( bookName,  author,  bookTypeId);
		this.fillTable(book);
	}

	//初始化下拉框,@param type 下拉框类型
	private void fillBookType(String type) {
		Connection conn=null;
		BookType bookType=null;
		try {
			conn=dbUtil.getconn();
			ResultSet rs=bookTypeDao.list(conn, new BookType());
			if("search".equals(type)) {
				bookType=new BookType();
				bookType.setBookTypeName("请选择");
				bookType.setId(-1);
				this.s_bookTypeJcb.addItem(bookType);
			}
			while(rs.next()) {
				bookType=new BookType();
				bookType.setBookTypeName(rs.getString("bookTypeName"));
				bookType.setId(rs.getInt("id"));
				if("search".equals(type)) {
					this.s_bookTypeJcb.addItem(bookType);
				}
				else if("modify".equals(type)) {
					this.bookTypeJcb.addItem(bookType);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				dbUtil.clossconn(conn);
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
	
	//初始化表格
	private void fillTable(Book book) {
		DefaultTableModel dtm=(DefaultTableModel) bookTable.getModel();
		dtm.setRowCount(0);//设置成0行,清空表格
		Connection conn=null;
		try {
			conn=dbUtil.getconn();
			ResultSet rs=bookDao.list(conn, book);
			while(rs.next()) {
				@SuppressWarnings("rawtypes")
				Vector<Comparable> v=new Vector<Comparable>();
				v.add(rs.getString("id"));
				v.add(rs.getString("bookName"));
				v.add(rs.getString("author"));
				v.add(rs.getFloat("price"));
				v.add(rs.getString("bookDesc"));
				v.add(rs.getString("bookTypeName"));
				dtm.addRow(v);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				dbUtil.clossconn(conn);
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
}
