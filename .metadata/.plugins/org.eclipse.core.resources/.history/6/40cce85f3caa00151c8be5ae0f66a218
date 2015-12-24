package elms.presentation.financeui.bankaccount;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;

import elms.businesslogic.financebl.BankAccountManager;
import elms.presentation.uihelper.ScreenSize;
import elms.presentation.uihelper.TagPanel;
import elms.presentation.uihelper.UserInfo;
import elms.vo.BankAccountVO;
import elms.vo.UserVO;

public class BankAccount_init extends JFrame {

//	JTextArea text = new JTextArea(10, 10);
	String bank = null;
	JComboBox<String> bank_c;
	ArrayList<BankAccountVO> arr;// 全部的账户vo
	BankAccountManager bam = new BankAccountManager();
	int screenWidth = ScreenSize.screenWidth;
	int screenHeight = ScreenSize.screenHeight;
	
	private BankAccountList accountList;
	private JPanel tag;
	private UserVO uservo;

	public static void main(String args[]) {
		UserVO vo = new UserVO();
		BankAccount_init bi = new BankAccount_init(vo);
	}

	public BankAccount_init(final UserVO vo) {
		this.uservo = vo;
		setLayout(null);
		setTitle("账户初始化");
		setResizable(false);
		setSize(screenWidth / 2, screenHeight / 2 - 60);
		setLocation(screenWidth / 4, screenHeight / 8);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel user = new UserInfo(uservo);
		user.setBounds(0, 0, this.getWidth(), 25);
		add(user);
		// 在账户管理界面上显示的各种清单列表
		tag = new TagPanel("账户清单");
		tag.setBounds(0, 23, 70, 25);
		add(tag);

		// 表头和内容
		JPanel info2 = new JPanel();
		info2.setLayout(null);
		info2.setBackground(Color.white);
		info2.setBounds(50, 75, this.getWidth() - 110,
				this.getHeight() / 2 - 70);


		Dimension accountD =new Dimension(this.getWidth(),this.getHeight()*2/3-15);
		accountList = new BankAccountList(accountD,uservo);
		add(accountList);


		// 选择银行类别的combobox
		bank_c = new JComboBox<String>();
		bank_c.addItem("全部");
		bank_c.addItem("中国银行");
		bank_c.addItem("中国人民银行");
		bank_c.addItem("中国工商银行");
		bank_c.addItem("中国邮政银行");
		bank_c.setBackground(Color.white);
		bank_c.setFont(new Font("楷体", Font.CENTER_BASELINE, 15));
		add(bank_c);
		bank_c.setBounds(3 * this.getWidth() / 4 - 20,
				this.getHeight() / 2 + 15, 135, 25);
		bam = new BankAccountManager();
		
		accountList.removeAllData();
		bank_c.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				accountList.removeAllData();
				bank = bank_c.getSelectedItem().toString();

				try {
					
					arr = bam.getAllAccount();
				} catch (Exception e) {
					// TODO 自动生成的 catch 块
					System.out.println("there is no account in the file!");
					e.printStackTrace();
				}

				switch (bank) {
				case "全部":
					accountList.removeAllData();
					accountList.addAllData(arr);
					break;
				default: {
					arr = bam.inquiryAccountByBank(bank);
					accountList.addAllData(arr);
				}
				}
			}

		});

		JButton add = new JButton("添加账户");
		JButton edit = new JButton("修改账户");
		JButton back = new JButton("返回");
		add(add);
		add.setBounds(screenWidth / 12, screenHeight / 4 + 20, 100, 28);
		add(edit);
		edit.setBounds(screenWidth / 5, screenHeight / 4 + 20, 100, 28);
		add(back);
		back.setBounds(screenWidth / 3, screenHeight / 4 + 20, 100, 28);

		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				JFrame j_add = new BankAccount_add(accountList);
				j_add.setVisible(true);
			}

		});

		edit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				String id = accountList.getSelectedID();
				
				BankAccountVO b_vo = null;
				try {
					b_vo = bam.inquiryAccount(id);
				} catch (IOException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
				if(b_vo==null){
					JOptionPane.showMessageDialog(null, "请选择一个银行账户！");
					return;
				}
				JFrame j_change = new BankAccount_edit(accountList,b_vo,vo);
				j_change.setVisible(true);
			}

		});

		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				BankAccount_init.this.dispose();
			}

		});
		setVisible(true);
	}
}
