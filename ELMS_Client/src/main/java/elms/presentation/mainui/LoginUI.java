package elms.presentation.mainui;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;












import elms.businesslogic.dealbl.DealBL;
import elms.businesslogic.userbl.UserManage;
import elms.presentation.dealui.DealUI_main;
import elms.presentation.dealui.DealUI_Search;
import elms.presentation.dealui.DealUI_trackMessage;
import elms.presentation.storageui.Storage_main;
import elms.presentation.userui.UserUI_main;
import elms.vo.DealVO;
import elms.vo.UserVO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.rmi.RemoteException;

public class LoginUI extends JFrame {

	private JPanel contentPane;
	private JTextField IDtext;
	private JPasswordField pwtext;
	UserVO vo;
	private JTextField orderID;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI frame = new LoginUI();
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
	public LoginUI() {
		setDefaultCloseOperation(JFrame. HIDE_ON_CLOSE);
		setBounds(100, 100, 909, 682);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton Login = new JButton("登录");
		Login.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent arg0) {
				UserManage user=new UserManage();
				int n=0;
				
				try {
					String s=new String(pwtext.getPassword());
					n=user.login(IDtext.getText(), s);
					vo=user.findUser(IDtext.getText());
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
				
				if(n==-1){
					JOptionPane.showMessageDialog(null, "您输入的密码错误，请重新输入", "失败!", JOptionPane.ERROR_MESSAGE);
				}
				if(n==-2){
					JOptionPane.showMessageDialog(null, "该账户不存在", "失败!", JOptionPane.ERROR_MESSAGE);
				}	
				
				if(n==0){

				}
				if(n==1){//系统管理员 进入UserUI_main
					JFrame jframe=new UserUI_main();
					jframe.setVisible(true);
					LoginUI.this.dispose();
				}
				if(n==2){					
					JFrame dm=new DealUI_main(vo);
					dm.setVisible(true);
					LoginUI.this.dispose();
					//快递员，进入DealUI_main界面
				}
				if(n==3){
					
				}
				if(n==5){
					JFrame Storage_main=new Storage_main(vo);
					LoginUI.this.dispose();
				}
				
				
				

			}
		});
		Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		Login.setBounds(196, 439, 135, 47);
		contentPane.add(Login);
		
		JButton logout = new JButton("退出");
		logout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				LoginUI.this.dispose();
			}
		});
		logout.setBounds(549, 439, 135, 47);
		contentPane.add(logout);
		
		JLabel welcome = new JLabel("欢迎使用快递物流管理系统");
		welcome.setFont(new Font("微软雅黑", Font.PLAIN, 48));
		welcome.setBounds(163, 51, 600, 126);
		contentPane.add(welcome);
		
		JLabel ID = new JLabel("账户");
		ID.setFont(new Font("宋体", Font.PLAIN, 20));
		ID.setBounds(211, 224, 40, 30);
		contentPane.add(ID);
		
		JLabel pw = new JLabel("密码");
		pw.setFont(new Font("宋体", Font.PLAIN, 20));
		pw.setBounds(211, 315, 40, 21);
		contentPane.add(pw);
		
		IDtext = new JTextField();
		IDtext.setFont(new Font("宋体", Font.PLAIN, 20));
		IDtext.setBounds(330, 224, 239, 30);
		contentPane.add(IDtext);
		IDtext.setColumns(10);
		
		pwtext = new JPasswordField();
		pwtext.setFont(new Font("宋体", Font.PLAIN, 20));
		pwtext.setBounds(330, 310, 239, 30);
		contentPane.add(pwtext);
		pwtext.setColumns(10);
		
		JLabel label = new JLabel("快捷查询物流信息，请输入10位订单条形码号");
		label.setBounds(15, 534, 393, 21);
		contentPane.add(label);
		
		orderID = new JTextField();
		orderID.setBounds(195, 569, 293, 27);
		contentPane.add(orderID);
		orderID.setColumns(10);
		
		JButton button = new JButton("查询");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String ID=orderID.getText();
				String [] id=ID.split("");
				if(id.length!=10){
					JOptionPane.showMessageDialog(null, "请输入10位数字的订单号！","失败!", JOptionPane.ERROR_MESSAGE);
					return ;
				}
				else{
					for(int i=0;i<10;i++){
						if(  (!id[i].equals("0"))&&(!id[i].equals("1"))&&(!id[i].equals("2"))&&(!id[i].equals("3"))&&(!id[i].equals("4"))&&(!id[i].equals("5"))&&(!id[i].equals("6"))&&(!id[i].equals("7"))&&(!id[i].equals("8"))&&(!id[i].equals("9"))   ){
							JOptionPane.showMessageDialog(null, "请确保输入的10位订单号是纯数字！","失败!", JOptionPane.ERROR_MESSAGE);
							return;
						}
					}
				}
				
				DealBL dealbl=new DealBL();
				DealVO dealvo=null;
				try {
					dealvo = dealbl.FindOrder(ID);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				if(dealvo==null){
					JOptionPane.showMessageDialog(null, "该订单号不存在!", "失败!", JOptionPane.ERROR_MESSAGE);
				}
				else{
					DealUI_trackMessage dt=new DealUI_trackMessage(dealvo);
					dt.setVisible(true);					
				}
				
				
			}
		});
		button.setBounds(534, 568, 69, 29);
		contentPane.add(button);
	}
}
