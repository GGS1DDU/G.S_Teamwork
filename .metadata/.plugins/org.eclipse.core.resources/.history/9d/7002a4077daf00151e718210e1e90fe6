package elms.presentation.managerui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;

import elms.businesslogic.financebl.InitAll;
import elms.presentation.financeui.inAndEx.InAndEx_form;
import elms.presentation.managerui.aduit.aduit_main;
import elms.presentation.managerui.freight.FreightUI_main;
import elms.presentation.managerui.staff.StaffUI_main;
import elms.presentation.uihelper.MyButton;
import elms.presentation.uihelper.MyPanel;
import elms.presentation.uihelper.ScreenSize;
import elms.presentation.uihelper.TimeLabel;
import elms.presentation.uihelper.UserInfo;
import elms.vo.UserVO;

public class ManagerUI_main extends JFrame {

	int screenWidth = ScreenSize.screenWidth;
	int screenHeight = ScreenSize.screenHeight;
	int buttonWidth = 200;
	int buttonHeight = 40;
	int bButtonH = 60;
	int sButtonH = 20;
	int sButtonSelectedH = 30;

	private JPanel contentPane;
	// private JPanel infoPane;
	private JPanel user;
	private JPanel buttonPanel;
	private StaffUI_main staff;
	private JPanel freight;
	private JPanel form;
	private JPanel audit;

	private JButton freight_b;
	private JButton member_b;
	private JButton log_b;
	private JButton approval_b;
	private JButton form_b;
	private JButton staffInit;

	private JPanel time;

	private Dimension d;

	public static void main(String[] args) {
		UserVO vo = new UserVO("00000002", "123123", "张文玘", "总经理");
		JFrame jf = new ManagerUI_main(vo);
	}

	public ManagerUI_main(final UserVO u_vo) {
		setLayout(null);
		setTitle("总经理");
		setResizable(false);
		setBounds(screenWidth/6,screenHeight/8,screenWidth*2/3,screenHeight*3/4);

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {

		}

		contentPane = new MyPanel("inbg.jpg");
		contentPane.setBounds(0, 0, this.getWidth(), this.getHeight());
		add(contentPane);
		contentPane.setLayout(null);

//		addTimer();// 添加时间面板
		
		time = new TimeLabel(this.getWidth()-buttonWidth,30);
		
		user = new UserInfo(u_vo);
		user.setBounds(buttonWidth, 0, this.getWidth() - buttonWidth, 30);
		user.setOpaque(false);
		contentPane.add(user);

		buttonPanel = new JPanel();
		buttonPanel.setBounds(0, 0, buttonWidth, this.getHeight());
		buttonPanel.setLayout(null);
		buttonPanel.setBackground(new Color(245, 245, 245));
		contentPane.add(buttonPanel);

		d = new Dimension(this.getWidth() - buttonWidth, this.getHeight()
				- user.getHeight()-time.getHeight());
		staff = new StaffUI_main(new Dimension(d.width,d.height+time.getHeight()), u_vo);
		staff.setLocation(buttonWidth, 0);
		contentPane.add(staff);
		
		time.setLocation(buttonWidth, this.getHeight()-60);
		
		freight = new FreightUI_main(d, u_vo);
		freight.setLocation(buttonWidth, 0);
		
		audit = new aduit_main(d);
		audit.setLocation(buttonWidth, user.getHeight());

		freight_b = new MyButton("运费策略", 15);
		member_b = new MyButton("人员管理", 15);
		approval_b = new MyButton("审批单据", 15);
		form_b = new MyButton("查看统计报表", 15);
		log_b = new MyButton("查看系统日志", 15);
		setDefaultBSize();
		setDefaultBLocation();
		
	

		freight_b.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				contentPane.removeAll();
				contentPane.add(user);
				contentPane.add(time);
				contentPane.add(freight);

				buttonPanel.removeAll();
				setDefaultBSize();

				freight_b.setSize(buttonWidth, bButtonH);
				freight_b.setForeground(Color.gray);
				setDefaultBLocation();

				contentPane.add(buttonPanel);

				contentPane.validate();
				contentPane.repaint();
			}

		});

		member_b.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				contentPane.removeAll();
				contentPane.add(user);

				setDefaultBSize();

				member_b.setSize(buttonWidth, bButtonH);
				member_b.setForeground(Color.gray);

				Dimension bd = new Dimension(buttonWidth, sButtonH);
				staffInit = staff.getInitButton(bd, sButtonSelectedH);
				staffInit.setLocation(0, member_b.getY() + member_b.getHeight());
				buttonPanel.add(staffInit);

				freight_b.setLocation(0,
						staffInit.getY() + staffInit.getHeight());
				form_b.setLocation(0, freight_b.getY() + freight_b.getHeight());
				approval_b.setLocation(0, form_b.getY() + form_b.getHeight());
				log_b.setLocation(0, approval_b.getY() + approval_b.getHeight());

				contentPane.add(staff);
				contentPane.add(buttonPanel);
				contentPane.validate();
				contentPane.repaint();
			}

		});

		form_b.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根

				SimpleDateFormat sdf = new SimpleDateFormat(
						"yyyy-MM-dd hh:mm:ss");
				String endTime = sdf.format(new Date());
				form = new ManagerUI_form(d, "2015-12-12 00:00:00", endTime,
						u_vo);
				form.setLocation(buttonWidth, 30);

				setDefaultBSize();
				form_b.setSize(buttonWidth, bButtonH);
				form_b.setForeground(Color.gray);

				buttonPanel.removeAll();
				setDefaultBLocation();

				contentPane.removeAll();
				contentPane.add(user);
				contentPane.add(form);
				contentPane.add(buttonPanel);
				contentPane.add(time);
				validate();
				repaint();
				// form.setVisible(true);
			}

		});

		approval_b.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				setDefaultBSize();
				approval_b.setSize(buttonWidth, bButtonH);
				approval_b.setForeground(Color.gray);

				buttonPanel.removeAll();
				setDefaultBLocation();

				contentPane.removeAll();
				contentPane.add(user);
				 contentPane.add(audit);
				contentPane.add(buttonPanel);

				validate();
				repaint();
			}

		});

		log_b.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				setDefaultBSize();
				log_b.setSize(buttonWidth, bButtonH);
				log_b.setForeground(Color.gray);

				buttonPanel.removeAll();
				setDefaultBLocation();

				contentPane.removeAll();
				contentPane.add(user);
				// contentPane.add(form);
				contentPane.add(buttonPanel);
				contentPane.add(time);

				validate();
				repaint();
			}

		});
		setVisible(true);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void setDefaultBSize() {
		Dimension bd = new Dimension(buttonWidth, buttonHeight);
		member_b.setSize(bd);
		freight_b.setSize(bd);
		approval_b.setSize(bd);
		form_b.setSize(bd);
		log_b.setSize(bd);

		member_b.setForeground(Color.black);
		freight_b.setForeground(Color.black);
		approval_b.setForeground(Color.black);
		form_b.setForeground(Color.black);
		log_b.setForeground(Color.black);
	}

	private void setDefaultBLocation() {

		buttonPanel.add(freight_b);
		buttonPanel.add(member_b);
		buttonPanel.add(approval_b);
		buttonPanel.add(form_b);
		buttonPanel.add(log_b);

		member_b.setLocation(0, 0);
		freight_b.setLocation(0, member_b.getHeight());
		form_b.setLocation(0, member_b.getHeight() + freight_b.getHeight());
		approval_b.setLocation(0, form_b.getY() + form_b.getHeight());
		log_b.setLocation(0, approval_b.getY() + approval_b.getHeight());
	}

	

}
