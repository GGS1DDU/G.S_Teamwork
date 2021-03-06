package elms.presentation.financeui.bankaccount;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.JButton;

import elms.businesslogic.ResultMessage;
import elms.businesslogic.financebl.BankAccountManager;
import elms.businesslogic.financebl.InitAll;
import elms.presentation.uihelper.JTabbedPanel;
import elms.presentation.uihelper.MyButton;
import elms.presentation.uihelper.TagPanel;
import elms.presentation.uihelper.UserInfo;
import elms.vo.BankAccountVO;
import elms.vo.UserVO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/*
 * 银行账户管理主界面，点进来之后直接显示现有的所有银行账户清单，可以在下面选择所属银行
 * 根据所选择的银行显示对应的银行账户清单
 * 左下角是buttonpanel区，包含新建，删除/修改，转账三个按钮，
 * 最下方一栏可显示当前时间 格式为yyyy-mm-dd hh:mm:ss  需要修改对应数据区中比较时间的方法
 */
public class BankAccount_main extends JPanel {

	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension screenSize = kit.getScreenSize();
	int screenWidth = (int) screenSize.getWidth();
	int screenHeight = (int) screenSize.getHeight();
	// JTextArea text=new JTextArea(10,10);
	String bank = null;
	private JComboBox<String> bank_c;
	private JTabbedPanel tabbedPane;
	private JPanel content;
	private JPanel userInfo;
	private JPanel tag;
	private JPanel buttonPanel;

	private JLabel time;// 时间显示

	private BankAccountList accountList;// 放在panel中的table
	private UserVO uservo;

	private MyButton init;
	private JButton finishInit;

	static ArrayList<BankAccountVO> arr;// 全部的账户vo
	BankAccountManager bam;

	/**
	 * Create the frame.
	 */
	public BankAccount_main(final Dimension d, final UserVO vo) {
		this.uservo = vo;
		setLayout(null);
		setSize(d.width, d.height-10);

		setOpaque(false);

		userInfo = new UserInfo(vo);

		add(userInfo);
		userInfo.setBounds(0, 0, this.getWidth(), 25);
		
		addTimer();

		// 账户管理和初始化的表头（选择）
		tabbedPane = new JTabbedPanel();
		tabbedPane.setBounds(0, 30, d.width, this.getHeight()
				- userInfo.getHeight()-time.getHeight()-time.getHeight());
		add(tabbedPane);

		content = new JPanel();
		content.setOpaque(false);
		content.setBounds(0, 0, tabbedPane.getWidth(), tabbedPane.getHeight());
		content.setLayout(null);

		tabbedPane.addTab("银行账户管理", content);
		
		

		// 在账户管理界面上显示的各种清单列表

		tag = new TagPanel("账户清单");
		tag.setBounds(0, 23, 70, 25);
		tag.setOpaque(true);
		content.add(tag);

		// 表头和内容

		Dimension listd = new Dimension(this.getWidth() - 25,
				this.getHeight() / 2);
		accountList = new BankAccountList(listd, vo);
		content.add(accountList);

		// 选择银行类别的combobox
		bank_c = new JComboBox<String>();
		bank_c.addItem("全部");
		bank_c.addItem("中国银行");
		bank_c.addItem("中国人民银行");
		bank_c.addItem("中国工商银行");
		bank_c.addItem("中国邮政银行");
		bank_c.setBackground(Color.white);
		bank_c.setFont(new Font("楷体", Font.CENTER_BASELINE, 15));
		content.add(bank_c);
		bank_c.setBounds(3 * this.getWidth() / 4, this.getHeight() / 2 + 30,
				135, 25);
		bam = new BankAccountManager();
		try {
			arr = bam.getAllAccount();
		} catch (Exception e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}

		// 开始时显示总的列表
		// accountList.addAllData(arr);

		bank_c.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				accountList.removeAllData();
				bank = bank_c.getSelectedItem().toString();

				try {
					arr = bam.getAllAccount();
				} catch (Exception e) {
					// TODO 自动生成的 catch 块
					
					e.printStackTrace();
				
					
					if(bank.equals("全部")){
						arr = bam.getAllAccount();
						accountList.removeAllData();
						accountList.addAllData(arr);
					}else {
						arr = bam.inquiryAccountByBank(bank);
						accountList.removeAllData();
						accountList.addAllData(arr);
					}
					
				}
			}

		});

		addButtons();

	}

	public JButton addInitButton(final Dimension d, final int height) {
		init = new MyButton("初始化");
		init.setSize(d);
		init.setFont(12);
		init.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				init.setForeground(Color.gray);
				init.setSize(d.width, height);
				int a = (int) (Math.random() * 1000);
				init.setFont(14);
				
				
				String s = a + "";

				String obj = JOptionPane.showInputDialog("请输入 验证码  " + a
						+ " 确认初始化库存");
				if (obj.equals(s)) {
					// BankAccount_main.this.dispose();

					BankAccountManager bankaccount = new BankAccountManager();
					try {
						ResultMessage rm = bankaccount.init();
						if (rm == ResultMessage.changeFailed) {
							int opt = JOptionPane.showConfirmDialog(null,
									"仍有账户余额不为0，确认继续？");
							if (opt == 0) {
								bankaccount.initIgnoreAmount();
								
								buttonPanel.add(finishInit);
								buttonPanel.validate();
								buttonPanel.repaint();
								
								JOptionPane.showMessageDialog(null, "开始初始化!");
								accountList.removeAllData();
								arr = null;
							} else
								JOptionPane.showMessageDialog(null, "停止初始化!");

						} else {
							bankaccount.initIgnoreAmount();
							
							buttonPanel.add(finishInit);
							buttonPanel.validate();
							buttonPanel.repaint();
							
							JOptionPane.showMessageDialog(null, "开始初始化!");
							accountList.removeAllData();
							arr = null;
						}

					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else
					JOptionPane.showMessageDialog(null, "验证码错误！", null, 0);

			}

		});
		return init;
	}

	// buttonpanel 用来放各种按钮
	private void addButtons() {
		buttonPanel = new JPanel();
		buttonPanel.setLayout(null);
		buttonPanel.setOpaque(false);
		JButton add = new JButton("新建");
		JButton delete = new JButton("删除");
		JButton trans = new JButton("转账");
		JButton find = new JButton("查询");
		
		addFinishInit();  //结束初始化  按钮的声明及监听

		// init.setForeground(Color.red);
		buttonPanel.setBounds(0, tabbedPane.getHeight()-150,
				this.getWidth() - 30, 120);

		add.setBounds(50, 60, 102, 30);
		delete.setBounds(200, 60, 104, 30);
		trans.setBounds(350, 60, 102, 30);
		find.setBounds(560, 60, 80, 30);
		// init.setBounds(560, 55, 80, 30);
		buttonPanel.add(add);
		buttonPanel.add(delete);
		buttonPanel.add(trans);
		buttonPanel.add(find);
		// buttonPanel.add(init);

		content.add(buttonPanel);

		// 各种按钮的监听
		add.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				JFrame addAccount = new BankAccount_add(accountList);
				// refresh();
				addAccount.setVisible(true);
			}

		});

		delete.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				accountList.removeData();// 与数据层的交互委托给bankaccountlist去干
			}

		});

		trans.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				JFrame transfer = new BankAccount_transfer(accountList, uservo);
				transfer.setVisible(true);
			}

		});

		find.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				JFrame find = new BankAccount_find(accountList, uservo);
				find.setVisible(true);
			}

		});

	}

	private void addFinishInit() {
		finishInit = new JButton("完成初始化");
		finishInit.setBounds(300, 0, 100, 30);
		// bp.add(finishInit);

		finishInit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根

				int a = (int) (Math.random() * 1000);
				String s = a + "";

				String obj = JOptionPane.showInputDialog("请输入 验证码  " + a
						+ " 确认完成银行账户初始化");
				if (obj.equals(s)) {

					InitAll ia = new InitAll();
					 try {
						ia.setInitState(4);
						System.out.println("____________________"+ia.getInitState(4));
//						bam.init();
//						accountList.removeAllData();
						JOptionPane.showMessageDialog(null, "初始化结束！");
					} catch (RemoteException e2) {
						// TODO 自动生成的 catch 块
						e2.printStackTrace();
						System.out.println("failed!!!!!!!!!!!!");
					} catch (IOException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
					
				} else {
					JOptionPane.showMessageDialog(null, "验证码错误！", null, 0);
				}

			}
		});
	}

	
	private void addTimer() {
		time = new JLabel("1", JLabel.CENTER);
		time.setText("1231231231");
		time.setFont(new Font("微软雅黑", Font.BOLD, 15));
		
		time.setBounds(0, this.getHeight()-50, this.getWidth(), 30);
//		time.setBounds(0, this.getHeight() - 30, this.getWidth(), 30);
		add(time);
		Timer timer = new Timer(100, new ActionListener() {
			InitAll i = new InitAll();

			public void actionPerformed(ActionEvent arg0) {
				SimpleDateFormat sdf = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");
				try {
					if (i.getInitState(4)) {
//						needInit = true;
						time.setText("需要初始化！");
						

					} else {
						time.setText(sdf.format(new Date()));
						buttonPanel.remove(finishInit);
					}
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});

		timer.start();
	}

}
