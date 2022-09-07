package com.bk.view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.bk.dao.BookDao;
import com.bk.dao.BookTypeDao;
import com.bk.model.BookType;
import com.bk.util.DbUtil;
import com.bk.util.ToolUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BookTypemanager extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8084387207202497915L;
	private JTable bookTypeTable;
	private DbUtil dbUtil=new DbUtil();
	private BookTypeDao bookTypeDao=new BookTypeDao();
	private BookDao bookDao=new BookDao();
	private JTextField s_bookTypeNameTxt;
	private JTextField idTxt;
	private JTextField bookTypeNameTxt;
	private JTextArea bookTypeDescTxt;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookTypemanager frame = new BookTypemanager();
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
	public BookTypemanager() {
		setBorder(null);
		setClosable(true);
		setTitle("\u56FE\u4E66\u7C7B\u578B\u7EF4\u62A4");
		setBounds(100, 100, 583, 522);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u7C7B\u578B\u540D\u79F0\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		
		s_bookTypeNameTxt = new JTextField();
		s_bookTypeNameTxt.setFont(new Font("宋体", Font.PLAIN, 15));
		s_bookTypeNameTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookTypeSearchActionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 15));
		btnNewButton.setIcon(new ImageIcon(BookTypemanager.class.getResource("/images/\u67E5\u627E.png")));
		
		JPanel panel = new JPanel();
		panel.setToolTipText("");
		panel.setBorder(new TitledBorder(null, "\u7EF4\u62A4\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(64)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(s_bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addComponent(btnNewButton)
					.addContainerGap(142, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(s_bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(2)))
					.addGap(28)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_1 = new JLabel("\u7F16 \u53F7\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JLabel lblNewLabel_2 = new JLabel("\u56FE\u4E66\u7C7B\u578B\u63CF\u8FF0\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JLabel lblNewLabel_3 = new JLabel("\u56FE\u4E66\u7C7B\u578B\u540D\u79F0");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 15));
		
		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setFont(new Font("宋体", Font.PLAIN, 15));
		idTxt.setColumns(10);
		
		bookTypeNameTxt = new JTextField();
		bookTypeNameTxt.setFont(new Font("宋体", Font.PLAIN, 15));
		bookTypeNameTxt.setColumns(10);
		
		bookTypeDescTxt = new JTextArea();
		bookTypeDescTxt.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JButton btnNewButton_1 = new JButton("\u4FEE\u6539");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookTypeUpdateActionEvent(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(BookTypemanager.class.getResource("/images/\u4FEE\u6539.png")));
		
		JButton btnNewButton_2 = new JButton("\u5220\u9664");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookTypeDeleteActionPerformed(e);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(BookTypemanager.class.getResource("/images/\u5220 \u9664.png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addGap(18)
							.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(120)
							.addComponent(lblNewLabel_3)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(bookTypeDescTxt, GroupLayout.PREFERRED_SIZE, 364, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(14, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(132)
					.addComponent(btnNewButton_1)
					.addPreferredGap(ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
					.addComponent(btnNewButton_2)
					.addGap(125))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3)
						.addComponent(bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(bookTypeDescTxt, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		bookTypeTable = new JTable();
		bookTypeTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				bookTypeTableMousePressed(e);
			}
		});
		bookTypeTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u56FE\u4E66\u7C7B\u578B\u540D\u79F0", "\u56FE\u4E66\u7C7B\u578B\u63CF\u8FF0"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 5220340724561095795L;
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		bookTypeTable.getColumnModel().getColumn(0).setResizable(false);
		bookTypeTable.getColumnModel().getColumn(1).setResizable(false);
		bookTypeTable.getColumnModel().getColumn(1).setPreferredWidth(100);
		bookTypeTable.getColumnModel().getColumn(2).setResizable(false);
		bookTypeTable.getColumnModel().getColumn(2).setPreferredWidth(107);
		scrollPane.setViewportView(bookTypeTable);
		getContentPane().setLayout(groupLayout);
		//设置文本域边框
				bookTypeDescTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185),1,false));
		this.fillTable(new BookType());

	}
	
	
	//类型删除事件处理
	private void bookTypeDeleteActionPerformed(ActionEvent evt) {
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
				boolean flag=bookDao.existBookByBookTypeId(conn, id);
				if(flag) {
					JOptionPane.showMessageDialog(null, "此图书类型下有图书，无法删除！");
					return;
				}
				int deleteNum=bookTypeDao.delete(conn,id);
				if(deleteNum==1) {
					JOptionPane.showMessageDialog(null, "删除成功！");
					this.resetValue();
					this.fillTable(new BookType());
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

	//类别修改事件处理
	private void bookTypeUpdateActionEvent(ActionEvent evt) {
		// TODO 自动生成的方法存根
		String id=idTxt.getText();
		String bookTypeName=bookTypeNameTxt.getText();
		String bookTypeDesc=bookTypeDescTxt.getText();
		if(ToolUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请选择要修改的记录");
			return;
		}
		if(ToolUtil.isEmpty(bookTypeName)) {
			JOptionPane.showMessageDialog(null, "图书类型名称不能为空");
			return;
		}
		BookType bookType=new BookType(Integer.parseInt(id),bookTypeName,bookTypeDesc);
		Connection conn=null;
		try {
			conn=dbUtil.getconn();
			boolean flag=bookTypeDao.existBookTypeName2(conn, bookType);
			if(flag) {
				JOptionPane.showMessageDialog(null, "该图书类型已存在!");
				return;
			}
			int modifyNum=bookTypeDao.update(conn, bookType);
			if(modifyNum==1) {
				JOptionPane.showMessageDialog(null, "修改成功!");
				this.resetValue();
				this.fillTable(new BookType());
			}
			else {
				JOptionPane.showMessageDialog(null, "修改失败!");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "修改失败!");
		}finally {
			try {
				dbUtil.clossconn(conn);
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}

	//表格行点击事件处理
	private void bookTypeTableMousePressed(MouseEvent evt) {
		// TODO 自动生成的方法存根
		
		//获取选中行
		int row=bookTypeTable.getSelectedRow();
		//获取列
		idTxt.setText((String)bookTypeTable.getValueAt(row, 0)); 
		bookTypeNameTxt.setText((String)bookTypeTable.getValueAt(row, 1));
		bookTypeDescTxt.setText((String)bookTypeTable.getValueAt(row, 2));
	}

	//图书类型查询事件处理
	private void bookTypeSearchActionPerformed(ActionEvent evt) {
		// TODO 自动生成的方法存根
		String s_bookTypeNameTxt=this.s_bookTypeNameTxt.getText();
		BookType bookType=new BookType();
		bookType.setBookTypeName(s_bookTypeNameTxt);
		this.fillTable(bookType);
		
	}

	//初始化表格
	private void fillTable(BookType bookType) {
		DefaultTableModel dtm=(DefaultTableModel) bookTypeTable.getModel();
		dtm.setRowCount(0);//设置成0行,清空表格
		Connection conn=null;
		try {
			conn=dbUtil.getconn();
			ResultSet rs=bookTypeDao.list(conn, bookType);
			while(rs.next()) {
				Vector<String> v=new Vector<String>();
				v.add(rs.getString("id"));
				v.add(rs.getString("bookTypeName"));
				v.add(rs.getString("bookTypeDesc"));
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
	
	//重置表单
	private void resetValue() {
		this.idTxt.setText("");
		this.bookTypeNameTxt.setText("");
		this.bookTypeDescTxt.setText("");
	}
}
