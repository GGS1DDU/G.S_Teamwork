package elms.presentation.dealui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import elms.vo.DealVO;

import java.awt.Font;

public class DealUI_sender_message extends JFrame {

	String wlxx="";
	public DealUI_sender_message(DealVO vo){
		wlxx=vo.getTrack();
	}

	
	public DealUI_sender_message() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 769, 504);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea text = new JTextArea();
		text.setFont(new Font("宋体", Font.BOLD, 23));
		text.setLineWrap(true);
		text.setText(wlxx);
		text.setBounds(190, 98, 376, 336);
		contentPane.add(text);
		
		JLabel label = new JLabel("您的订单物流信息如下");
		label.setFont(new Font("宋体", Font.PLAIN, 22));
		label.setBounds(92, 51, 348, 32);
		contentPane.add(label);
		
	}
}
