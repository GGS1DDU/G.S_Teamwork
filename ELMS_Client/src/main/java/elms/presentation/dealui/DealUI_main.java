package elms.presentation.dealui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;




import elms.vo.UserVO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DealUI_main extends JFrame {

	private JPanel contentPane;
	UserVO vo;


	public DealUI_main(final UserVO vo) {
		this.vo=vo;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 753, 516);
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
		buildorder.setBounds(88, 74, 194, 57);
		contentPane.add(buildorder);
		
		JButton srsjxx = new JButton("输入收件信息");
		srsjxx.setBounds(398, 74, 194, 57);
		contentPane.add(srsjxx);
		
		JButton inquiryorder = new JButton("查询订单");
		inquiryorder.setBounds(88, 233, 194, 57);
		contentPane.add(inquiryorder);
		
		JButton cancel = new JButton("退出系统");
		cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DealUI_main.this.dispose();
			}
		});
		cancel.setBounds(398, 233, 194, 57);
		contentPane.add(cancel);
	}
}
