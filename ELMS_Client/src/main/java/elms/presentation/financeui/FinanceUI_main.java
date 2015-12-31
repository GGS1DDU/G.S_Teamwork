package elms.presentation.financeui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import elms.businesslogic.financebl.InitAll;
import elms.presentation.financeui.Init.InitAllButtons;
import elms.presentation.financeui.Init.browser;
import elms.presentation.financeui.bankaccount.BankAccount_main;
import elms.presentation.financeui.inAndEx.InAndEx_main;
import elms.presentation.mainui.LoginUI;
import elms.presentation.uihelper.MyButton;
import elms.presentation.uihelper.MyLabel;
import elms.presentation.uihelper.MyPanel;
import elms.presentation.uihelper.TimeLabel;
import elms.presentation.uihelper.UserInfo;
import elms.vo.AccountVO;
import elms.vo.UserVO;

/*
 * 财务人员主界面，负责对不同操作模块的选择
 */
public class FinanceUI_main extends JFrame {

	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension screenSize = kit.getScreenSize();
	int screenWidth = (int) screenSize.getWidth();
	int screenHeight = (int) screenSize.getHeight();
	int buttonWidth = 200;
	int buttonHeight = 40;
	int sButtonH = 20;
	int sButtonSelectedH = 30;
	int bButtonH = 60;

	private MyButton bank_b;
	private MyButton inAndEx_b;
	private MyButton init_b;
	private MyButton exit_b; // 注销登陆
	private JPanel buttonPanel;// 按钮panel
	private JPanel contentPane;// 图片
	private JPanel inAndEx;// 收入支出面板
	private browser initBrowser; // 期初建账历史纪录面板
	private JPanel initButtons;// 期初建账按钮面板
	private BankAccount_main bankAccount;// 银行账户面板
	
	private JPanel time;
	
	private Dimension d;

	public static void main(String[] args) {
		UserVO vo = new UserVO("00000001", "123", "张文玘", "快递员");

		
		// UIManager
		JFrame fm = new FinanceUI_main(vo);
		fm.setVisible(true);
	}

	public FinanceUI_main(final UserVO vo) {
		setLayout(null);
		setTitle("财务人员");
		setResizable(false);

		setBounds(screenWidth/6,screenHeight/8,screenWidth*2/3,screenHeight*3/4);
		
		UIManager.put("swing.boldMetal", Boolean.FALSE);
		UIManager.put("Button.background", Color.WHITE);

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {

		}

		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane = new MyPanel("inbg.jpg");
		contentPane.setBounds(0, 0, this.getWidth(), this.getHeight());
		add(contentPane);
		contentPane.setLayout(null);
		
		time = new TimeLabel(this.getWidth()-buttonWidth,30);

		d = new Dimension(this.getWidth() - buttonWidth, this.getHeight()-time.getHeight());
		inAndEx = new InAndEx_main(d, vo);
		inAndEx.setLocation(buttonWidth, 0);
		inAndEx.setOpaque(false);
		contentPane.add(inAndEx);
		
		time.setLocation(buttonWidth, this.getHeight()-60);
		contentPane.add(time);

		buttonPanel = new JPanel();
		buttonPanel.setBorder(new TitledBorder(new EtchedBorder()));
		buttonPanel.setLayout(null);
		buttonPanel.setBounds(0, 0, buttonWidth, this.getHeight());
		buttonPanel.setBackground(new Color(245, 245, 245));
		contentPane.add(buttonPanel);

		inAndEx_b = new MyButton("收支管理", 15);
		bank_b = new MyButton("银行账户管理", 15);
		init_b = new MyButton("期初建账", 15);
		exit_b = new MyButton("注销登陆", 15);
		
		setDefaultBSize();
		setDefaultBLocation();

		inAndEx_b.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				contentPane.removeAll();
				contentPane.add(inAndEx);
				contentPane.add(time);
				
				
				buttonPanel.removeAll();
				setDefaultBSize();
				inAndEx_b.setSize(buttonWidth, bButtonH);
				inAndEx_b.setForeground(Color.gray);
				inAndEx_b.setFont(20);
				
				setDefaultBLocation();
				
				contentPane.add(buttonPanel);
				

				validate();
				repaint();
			}

		});

		bank_b.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				bankAccount = new BankAccount_main(new Dimension(d.width,d.height+time.getHeight()), vo);
				bankAccount.setLocation(buttonWidth, 0);
				contentPane.removeAll();
				contentPane.add(bankAccount);
				

				buttonPanel.removeAll();
				setDefaultBSize();
				bank_b.setSize(buttonWidth,bButtonH);
				bank_b.setFont(20);
			
				setDefaultBLocation();
				
//				bank_b.setContentAreaFilled(true);
				bank_b.setForeground(Color.GRAY);
				Dimension bd = new Dimension(buttonWidth,sButtonH);
				JButton bankInit = bankAccount.addInitButton(bd,sButtonSelectedH);
				bankInit.setLocation(0, bank_b.getY() + bank_b.getHeight());
				buttonPanel.add(bankInit);
				
			

				init_b.setLocation(0, bankInit.getY() + bankInit.getHeight());
				exit_b.setLocation(0, init_b.getY() + init_b.getHeight());
				contentPane.add(buttonPanel);

				validate();
				repaint();

			}

		});

		init_b.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				ArrayList<AccountVO> test = new ArrayList<AccountVO>();
				initBrowser = new browser(d, test,vo);

				contentPane.removeAll();
				initBrowser.setLocation(buttonWidth, 0);
				contentPane.add(initBrowser);
				contentPane.add(time);

				buttonPanel.removeAll();
				setDefaultBSize();
				init_b.setSize(buttonWidth, bButtonH);
				init_b.setFont(20);
				setDefaultBLocation();
				
//				init_b.setContentAreaFilled(true);
				init_b.setForeground(Color.GRAY);
				Dimension bd = new Dimension(buttonWidth, sButtonH * 4);
				initButtons = new InitAllButtons(sButtonH,sButtonSelectedH, bd, vo);
				initButtons.setLocation(0, init_b.getY() + init_b.getHeight());

				buttonPanel.add(initButtons);
				

				exit_b.setLocation(0,
						initButtons.getY() + initButtons.getHeight());

				contentPane.add(buttonPanel);
				validate();
				repaint();
			}

		});

		exit_b.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				JFrame jf = new LoginUI();
				jf.setVisible(true);
				FinanceUI_main.this.dispose();
			}

		});
	}
//	private void moveButtons(JButton start){
//		
//	}
	
	private void setDefaultBSize(){
		Dimension buttonSize = new Dimension(buttonWidth,buttonHeight);
		inAndEx_b.setSize(buttonSize);
		bank_b.setSize(buttonSize);
		init_b.setSize(buttonSize);
		exit_b.setSize(buttonSize);
		
		inAndEx_b.setFont(15);
		bank_b.setFont(15);
		init_b.setFont(15);
		exit_b.setFont(15);
		
		inAndEx_b.setForeground(Color.black);
		bank_b.setForeground(Color.BLACK);
		init_b.setForeground(Color.BLACK);
		exit_b.setForeground(Color.BLACK);
	}
	
	private void setDefaultBLocation(){
		
		inAndEx_b.setLocation(0, 0);
		bank_b.setLocation(0, inAndEx_b.getHeight());
		init_b.setLocation(0, inAndEx_b.getHeight()+bank_b.getHeight());
		exit_b.setLocation(0, inAndEx_b.getHeight()+bank_b.getHeight()+init_b.getHeight());
		
		buttonPanel.add(inAndEx_b);
		buttonPanel.add(bank_b);
		buttonPanel.add(init_b);
		buttonPanel.add(exit_b);
	}
}
