package elms.presentation.dealui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;





import elms.vo.UserVO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
/**
 * 
 * @author ZWH
 *
 */
public class DealUI_main extends JFrame {

	private JPanel contentPane;
	UserVO vo;

	/**
	 * 
	 * @param vo
	 */
	public DealUI_main(final UserVO vo) {
		this.vo=vo;
		Dimension   screensize   =   Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)screensize.getWidth();
		int height = (int)screensize.getHeight();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds((width-753)/2, (height-516)/2, 753, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton buildorder = new JButton("新建订单");
		buildorder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//转至DealUI_BuildOrder界面
				DealUI_BuildOrder DBO=new DealUI_BuildOrder(vo);
				DBO.setVisible(true);
				
			}
		});	
		buildorder.setBounds(101, 135, 194, 57);
		contentPane.add(buildorder);
		
		JButton srsjxx = new JButton("输入收件信息");
		srsjxx.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DealUI_receive dr=new DealUI_receive(vo);
				dr.setVisible(true);
			}
		});
		srsjxx.setBounds(398, 135, 194, 57);
		contentPane.add(srsjxx);
		
		JButton inquiryorder = new JButton("查询订单");
		inquiryorder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DealUI_Search ds=new DealUI_Search(vo);
				ds.setVisible(true);
			}
		});
		inquiryorder.setBounds(101, 274, 194, 57);
		contentPane.add(inquiryorder);
		
		JButton cancel = new JButton("退出系统");
		cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DealUI_main.this.dispose();
			}
		});
		cancel.setBounds(398, 274, 194, 57);
		contentPane.add(cancel);
		
		JLabel LoginMessage = new JLabel("您好,"+vo.getName()+"  身份:"+vo.getJob());
		LoginMessage.setBounds(50, 27, 303, 21);
		contentPane.add(LoginMessage);
	}
}
