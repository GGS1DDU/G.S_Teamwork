package elms.presentation.dealui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JButton;

import elms.businesslogic.dealbl.DealBL;
import elms.vo.DealVO;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DealUI_sender extends JFrame {
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DealUI_sender frame = new DealUI_sender();
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
	public DealUI_sender() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 747, 374);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("请输入要查询物流的订单号");
		label.setFont(new Font("宋体", Font.PLAIN, 22));
		label.setBounds(35, 75, 282, 38);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(132, 117, 419, 38);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton check = new JButton("查询");
		check.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
	//如果输入的不是10位数字 			if()
	//如果是		
				DealBL dealbl=new DealBL();
				DealVO vo=dealbl.CourierInquiry(textField.getText());
				if(vo==null){
					JOptionPane.showMessageDialog(null, "该订单号不存在!", "失败!", JOptionPane.ERROR_MESSAGE);
				}
				else{
					DealUI_sender_message dsm=new DealUI_sender_message(vo);
					dsm.setVisible(true);
					
				}
				
				
			}
		});
		check.setBounds(149, 212, 139, 51);
		contentPane.add(check);
		
		JButton cancel = new JButton("取消");
		cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DealUI_sender.this.dispose();
			}
		});
		cancel.setBounds(412, 212, 139, 51);
		contentPane.add(cancel);
	}
}
