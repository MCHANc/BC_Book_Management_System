package com.bk.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Aboutwm extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4407560069444743745L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Aboutwm frame = new Aboutwm();
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
	public Aboutwm() {
		setBorder(null);
		setClosable(true);
		setTitle("\u5173\u4E8E\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");
		setBounds(100, 100, 450, 300);
		
		JLabel lblNewLabel = new JLabel("\u4F5C \u8005\uFF1A");
		lblNewLabel.setIcon(new ImageIcon(Aboutwm.class.getResource("/images/\u4F5C\u8005.png")));
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel lblNewLabel_1 = new JLabel("\u9648\u5F66\u5B8F");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel lblNewLabel_2 = new JLabel("\u73ED \u7EA7\uFF1A");
		lblNewLabel_2.setIcon(new ImageIcon(Aboutwm.class.getResource("/images/\u73ED\u7EA7.png")));
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel lblNewLabel_3 = new JLabel("\u8F6F\u5DE5191");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel lblNewLabel_4 = new JLabel("\u5B66 \u53F7\uFF1A");
		lblNewLabel_4.setIcon(new ImageIcon(Aboutwm.class.getResource("/images/\u5B66\u53F7.png")));
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel lblNewLabel_5 = new JLabel("201915270117");
		lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 18));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(77)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(18)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_3))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_4)
							.addGap(18)
							.addComponent(lblNewLabel_5)))
					.addContainerGap(164, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(57)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(lblNewLabel_5))
					.addContainerGap(39, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}
}
