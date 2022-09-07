package com.bk.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Mainframe extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2082573445724982457L;
	private JPanel contentPane;
	private JDesktopPane table=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mainframe frame = new Mainframe();
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
	public Mainframe() {
		setTitle("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 829, 729);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u7528\u6237\u7BA1\u7406");
		mnNewMenu.setIcon(new ImageIcon(Mainframe.class.getResource("/images/\u7528\u6237\u4FE1\u606F.png")));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u6DFB\u52A0\u7528\u6237");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Useradd Useradd =new Useradd();
				Useradd.setVisible(true);
				table.add(Useradd);
			}
		});
		mntmNewMenuItem_1.setIcon(new ImageIcon(Mainframe.class.getResource("/images/\u6DFB\u52A0\u7528\u6237.png")));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("\u9000\u51FA\u7CFB\u7EDF");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result=JOptionPane.showConfirmDialog(null, "是否退出系统");
				if(result==0) {
					dispose();
				}
			}
		});
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u7528\u6237\u7EF4\u62A4");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usermanager Usermanager =new Usermanager();
				Usermanager.setVisible(true);
				table.add(Usermanager);
			}
		});
		mntmNewMenuItem.setIcon(new ImageIcon(Mainframe.class.getResource("/images/\u7EF4\u62A4.png")));
		mnNewMenu.add(mntmNewMenuItem);
		mntmNewMenuItem_4.setIcon(new ImageIcon(Mainframe.class.getResource("/images/\u9000\u51FA.png")));
		mnNewMenu.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu_1 = new JMenu("\u56FE\u4E66\u7BA1\u7406");
		mnNewMenu_1.setIcon(new ImageIcon(Mainframe.class.getResource("/images/\u56FE\u4E66\u7BA1\u7406.png")));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("\u6DFB\u52A0\u56FE\u4E66");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookAdd BookAdd =new BookAdd();
				BookAdd.setVisible(true);
				table.add(BookAdd);
			}
		});
		mntmNewMenuItem_6.setIcon(new ImageIcon(Mainframe.class.getResource("/images/\u6DFB\u52A0.png")));
		mnNewMenu_1.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("\u56FE\u4E66\u7EF4\u62A4");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Bookmanager Bookmanager =new Bookmanager();
				Bookmanager.setVisible(true);
				table.add(Bookmanager);
			}
		});
		mntmNewMenuItem_5.setIcon(new ImageIcon(Mainframe.class.getResource("/images/\u7EF4\u62A4.png")));
		mnNewMenu_1.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu_2 = new JMenu("\u56FE\u4E66\u7C7B\u578B\u7BA1\u7406");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("\u6DFB\u52A0\u56FE\u4E66\u7C7B\u578B");
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookTypeadd BookTypeadd =new BookTypeadd();
				BookTypeadd.setVisible(true);
				table.add(BookTypeadd);
			}
		});
		mntmNewMenuItem_10.setIcon(new ImageIcon(Mainframe.class.getResource("/images/\u6DFB\u52A0.png")));
		mnNewMenu_2.add(mntmNewMenuItem_10);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("\u56FE\u4E66\u7C7B\u578B\u7EF4\u62A4");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookTypemanager BookTypemanager =new BookTypemanager();
				BookTypemanager.setVisible(true);
				table.add(BookTypemanager);
			}
		});
		mntmNewMenuItem_9.setIcon(new ImageIcon(Mainframe.class.getResource("/images/\u7EF4\u62A4.png")));
		mnNewMenu_2.add(mntmNewMenuItem_9);
		
		JMenu mnNewMenu_3 = new JMenu("\u5173\u4E8E\u6211\u4EEC");
		mnNewMenu_3.setIcon(new ImageIcon(Mainframe.class.getResource("/images/\u5173\u4E8E\u6211\u4EEC.png")));
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_13 = new JMenuItem("\u5173\u4E8E\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");
		mntmNewMenuItem_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Aboutwm Aboutwm=new Aboutwm();
				Aboutwm.setVisible(true);
				table.add(Aboutwm);
				
			}
		});
		mntmNewMenuItem_13.setIcon(new ImageIcon(Mainframe.class.getResource("/images/\u56FE\u4E66\u9986.png")));
		mnNewMenu_3.add(mntmNewMenuItem_13);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		 contentPane.setLayout(new CardLayout(0, 0));
		
		 table = new JDesktopPane();
		 table.setBorder(null);
		table.setLayout(new CardLayout(0, 0));
		contentPane.add(table, "name_16415565128657");
		//设置JFrame居中显示
				this.setLocationRelativeTo(null);
	}

}
