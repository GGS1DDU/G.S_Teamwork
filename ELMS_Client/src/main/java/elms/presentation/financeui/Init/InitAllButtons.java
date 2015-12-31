package elms.presentation.financeui.Init;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import elms.businesslogic.financebl.InitAll;
import elms.presentation.storageui.Storage_main;
import elms.presentation.uihelper.MyButton;
import elms.vo.AccountVO;
import elms.vo.UserVO;

public class InitAllButtons extends JPanel {
	private JButton init;
	private JButton copy;
//	private JButton browser;
	private JButton recovery;

	private int buttonWidth;
	private int buttonHeight;

	public static void main(String[] args) {
		UserVO vo = new UserVO();
		// new InitAllButtons(vo);
	}

	public InitAllButtons(final int buttonHeight, final int changedHeight,
			final Dimension d, final UserVO vo) {
		setLayout(null);
//		setPanelSize();
		setSize(d.width, d.height);
		setOpaque(false);
		setVisible(true);
		this.buttonWidth = d.width;
		this.buttonHeight = buttonHeight;

		init = new MyButton("初始化库存");
		copy = new MyButton("备份库存  ");
//		browser = new JButton("历史查看  ");
		recovery = new MyButton("恢复备份");
		add(init);
		add(copy);
//		add(browser);
		add(recovery);
		// init.setBounds(this.getWidth() / 2 - 150, 35, 100, 30);
		// copy.setBounds(this.getWidth() / 2 - 150, 105, 100, 30);
		// browser.setBounds(this.getWidth() / 2 + 50, 35, 100, 30);
		// recovery.setBounds(this.getWidth() / 2 + 50, 105, 100, 30);

//		browser.setBounds(0, 0, d.width, buttonHeight);
//		init.setBounds(0, buttonHeight, d.width, buttonHeight);
//		copy.setBounds(0, buttonHeight * 2, d.width, buttonHeight);
//		recovery.setBounds(0, buttonHeight * 3, d.width, buttonHeight);
		
		setDefaultBSize();
		setDefaultBLocation();
		init.addActionListener(new ActionListener() {
			InitAll initall = new InitAll();

			public void actionPerformed(ActionEvent arg0) {
				try {
					
					setDefaultBSize();
					
					init.setSize(d.width, changedHeight);
					init.setForeground(Color.GRAY);
					
					setDefaultBLocation();
					setPanelSize();
					
					if (!initall.getInitState(1) && !initall.getInitState(2)
							&& !initall.getInitState(3)
							&& !initall.getInitState(4)&&!initall.getInitState(5)) {
						int a = (int) (Math.random() * 1000);
						String s = a + "";
						String obj = JOptionPane.showInputDialog("请输入 验证码  "
								+ a + " 确认初始化库存");
						if (obj.equals(s)) {
							try {
								String time = "" + new Date().toLocaleString();
								time = time.substring(0, 7);
								time = "Version-" + time;
								initall.init(time);
								AccountVO vo1 = new AccountVO(time, vo
										.getName(), new Date().toLocaleString());
								initall.addAccount(vo1);

							} catch (RemoteException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (ClassNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							// 保存所有"xxx.ser" 到"new date().getyear()+xxx.ser"
							// new date().getyear()+xxx.ser to
							// ArraylList<String> beta
							// 在data层设置参数 然后在需要新建的类别去读取这个参数 提醒新建
							// 告知管理员 重新建立用户信息
							// 告知中转中心仓库管理员 新建库存信息
							// 告知经理 新建member信
						} else
							JOptionPane.showMessageDialog(null, "验证码错误！", null,
									0);
					} else
						JOptionPane
								.showMessageDialog(null, "当前初始化未完成", null, 2);
				} catch (HeadlessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		copy.addActionListener(new ActionListener() {
			InitAll initall = new InitAll();

			public void actionPerformed(ActionEvent arg0) {
				
				setDefaultBSize();
				
				copy.setSize(d.width, changedHeight);
				copy.setForeground(Color.GRAY);
				
				setDefaultBLocation();
				setPanelSize();
				try {
					String time = "" + new Date().toLocaleString();
					time = time.substring(0, 4);
					time = "Version-" + time;
					initall.copy(time);

				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// 在数据层设置重置完成参数 当各部分都重置完成 copy才能生效 即保存当前的新的库存信息作为备份
				// 保存现有的"xxx.ser" to "copy_xxx.ser"
				JOptionPane.showMessageDialog(null, "数据已备份", null, 2);
			}

		});
		// browser.addActionListener(new ActionListener() {
		// InitAll initall = new InitAll();
		//
		// public void actionPerformed(ActionEvent e) {
		// try {
		// new browser(initall.getAccount());
		// } catch (ClassNotFoundException e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// } catch (IOException e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// }
		// }
		//
		// });
		recovery.addActionListener(new ActionListener() {
			InitAll initall = new InitAll();

			public void actionPerformed(ActionEvent e) {
				
				setDefaultBSize();
				
				recovery.setSize(d.width, changedHeight);
				recovery.setForeground(Color.GRAY);
				
				setDefaultBLocation();
				setPanelSize();
				try {
					String time = "" + new Date().toLocaleString();
					time = time.substring(0, 4);
					time = "Version-" + time;
					initall.recovery(time);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "数据已恢复", null, 2);
			}

		});
	}
	
	private void setDefaultBSize(){
		Dimension buttonSize = new Dimension(buttonWidth,buttonHeight);
		init.setSize(buttonSize);
		copy.setSize(buttonSize);
		recovery.setSize(buttonSize);
//		exit_b.setSize(buttonSize);
		
		init.setForeground(Color.black);
		copy.setForeground(Color.BLACK);
		recovery.setForeground(Color.BLACK);
//		exit_b.setForeground(Color.BLACK);
		
//		inAndEx_b.setContentAreaFilled(false);
//		bank_b.setContentAreaFilled(false);
//		init_b.setContentAreaFilled(false);
//		exit_b.setContentAreaFilled(false);
		
	}
	
	private void setDefaultBLocation(){
		
		init.setLocation(0, 0);
		copy.setLocation(0, init.getHeight());
		recovery.setLocation(0, init.getHeight()+copy.getHeight());
//		exit_b.setLocation(0, inAndEx_b.getHeight()+bank_b.getHeight()+init_b.getHeight());
		
		add(init);
		add(copy);
		add(recovery);
	
	}
	
	private void setPanelSize(){
		setSize(buttonWidth,init.getHeight()+copy.getHeight()+recovery.getHeight());
	}

}
