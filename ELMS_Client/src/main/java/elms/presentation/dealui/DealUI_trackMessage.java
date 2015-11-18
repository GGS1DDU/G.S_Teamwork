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
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DealUI_trackMessage extends JFrame {
	String wlxx="";
	public DealUI_trackMessage(DealVO dealvo){
		wlxx=dealvo.getTrack();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 830, 577);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea text = new JTextArea();
		text.setFont(new Font("宋体", Font.BOLD, 23));
		text.setLineWrap(true);
		text.setText(wlxx);
		text.setBounds(115, 111, 528, 237);
		contentPane.add(text);
		
		JLabel label = new JLabel("您的订单物流信息如下");
		label.setFont(new Font("宋体", Font.PLAIN, 22));
		label.setBounds(92, 51, 348, 32);
		contentPane.add(label);
		
		JButton button = new JButton("确定");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DealUI_trackMessage.this.dispose();
			}
		});
		button.setBounds(316, 428, 123, 29);
		contentPane.add(button);
		
	}
	}

	
