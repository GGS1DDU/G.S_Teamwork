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
import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.JButton;

import elms.businesslogic.dealbl.CheckOrder;
import elms.businesslogic.dealbl.DealBL;
import elms.vo.DealVO;
import elms.vo.UserVO;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DealUI_receive extends JFrame {

	private JPanel contentPane;
	private JTextField orderID;
	private JLabel label;
	private JTextField acturalReceiver;
	private JLabel lblNewLabel_1;
	private JTextField data;
	private JLabel lblNewLabel_2;
	private JTextField yyyy;
	private JLabel lblNewLabel_3;
	private JTextField mm;
	private JLabel aaa;
	private JTextField dd;


	/**
	 * Create the frame.
	 */
	public DealUI_receive(UserVO vo) {
		setDefaultCloseOperation(JFrame. HIDE_ON_CLOSE);
		setBounds(100, 100, 896, 494);
		contentPane = new JPanel();
		contentPane.setForeground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("订单号");
		lblNewLabel.setBounds(97, 107, 81, 21);
		contentPane.add(lblNewLabel);
		
		orderID = new JTextField();
		orderID.setBounds(285, 104, 220, 27);
		contentPane.add(orderID);
		orderID.setColumns(10);
		
		label = new JLabel("实际收件人");
		label.setBounds(97, 188, 109, 21);
		contentPane.add(label);
		
		acturalReceiver = new JTextField();
		acturalReceiver.setBounds(287, 185, 126, 27);
		contentPane.add(acturalReceiver);
		acturalReceiver.setColumns(10);
		
		lblNewLabel_1 = new JLabel("收件时间");
		lblNewLabel_1.setBounds(97, 262, 98, 21);
		contentPane.add(lblNewLabel_1);
		
		
		
		Date dt=new Date();
		SimpleDateFormat matter=new SimpleDateFormat("yyyy-MM-dd");
		String today=matter.format(dt);		
		String [] Today=today.split("-");
		
		
		

		
		lblNewLabel_2 = new JLabel("请输入形如xxxx-xx-xx形式的日期");
		lblNewLabel_2.setForeground(SystemColor.controlShadow);
		lblNewLabel_2.setFont(new Font("宋体", Font.ITALIC, 18));
		lblNewLabel_2.setBounds(532, 262, 287, 21);
		contentPane.add(lblNewLabel_2);
		
		JButton button = new JButton("确认收件");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String ID=orderID.getText();
				CheckOrder co=new CheckOrder();
				if(co.IsTenNumbers(ID)==2){
					JOptionPane.showMessageDialog(null, "请输入10位数字的订单号！","失败!", JOptionPane.ERROR_MESSAGE);
					return ;
				}
				else{
						if( co.IsTenNumbers(ID)==1){
							JOptionPane.showMessageDialog(null, "请确保输入的10位订单号是纯数字！","失败!", JOptionPane.ERROR_MESSAGE);
							return;
						}
					}
				
		
				
				if(acturalReceiver.getText().equals("")){
					JOptionPane.showMessageDialog(null, "请输入实际收件人姓名!","失败!", JOptionPane.ERROR_MESSAGE);
					return ;
				}
			
				
				int y=0;
				int m=0;
				int d=0;
				try{
					y=Integer.parseInt(yyyy.getText());
					if(y<2015||y>10000){
						JOptionPane.showMessageDialog(null, "请输入正确的年份!","失败!", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}catch(Exception e1){
					JOptionPane.showMessageDialog(null, "请输入正确的年份!","失败!", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				
				try{
					m=Integer.parseInt(mm.getText());
					if(m<=0||m>=13){
						JOptionPane.showMessageDialog(null, "请输入正确的月份!","失败!", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}catch(Exception e2){
					JOptionPane.showMessageDialog(null, "请输入正确的月份!","失败!", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				
				try{
					d=Integer.parseInt(dd.getText());
					if(m==1||m==3||m==5||m==7||m==8||m==10||m==12){
						if(d<=0||d>=32){
							JOptionPane.showMessageDialog(null, "请输入正确的日期!","失败!", JOptionPane.ERROR_MESSAGE);
							return;
						}
					}
					
					else if(m==4||m==6||m==9||m==11){
						if(d<=0||d>=31){
							JOptionPane.showMessageDialog(null, "请输入正确的日期!","失败!", JOptionPane.ERROR_MESSAGE);
							return;
						}
					}
					else if(m==2){
						if(d<=0||d>=30){
							JOptionPane.showMessageDialog(null, "请输入正确的日期!","失败!", JOptionPane.ERROR_MESSAGE);
							return;
						}
					}
					
				}catch(Exception e3){
					JOptionPane.showMessageDialog(null, "请输入正确的日期!","失败!", JOptionPane.ERROR_MESSAGE);
					return;
				}
						
				String receivedata=yyyy.getText()+"-"+mm.getText()+"-"+dd.getText();
				
				DealBL dealbl=new DealBL();
				DealVO vo=null;
				try {
					vo=dealbl.recipients(ID, acturalReceiver.getText(), receivedata);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				if(vo==null){
					JOptionPane.showMessageDialog(null, "该订单不存在或已被签收!","失败!", JOptionPane.ERROR_MESSAGE);
					return;
				}
				else{
					JOptionPane.showMessageDialog(null, "已成功更新该订单的收件信息!", "成功!", JOptionPane.INFORMATION_MESSAGE);
				}
				
				
				
				
				
				
			}
		});
		button.setBounds(654, 330, 123, 29);
		contentPane.add(button);
		
		JButton button_1 = new JButton("取消");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DealUI_receive.this.dispose();
			}
		});
		button_1.setBounds(654, 395, 123, 29);
		contentPane.add(button_1);
		
		yyyy = new JTextField(Today[0]);
		yyyy.setBounds(285, 260, 54, 24);
		contentPane.add(yyyy);
		yyyy.setColumns(10);
		
		lblNewLabel_3 = new JLabel("-");
		lblNewLabel_3.setBounds(344, 262, 24, 21);
		contentPane.add(lblNewLabel_3);
		
		mm = new JTextField(Today[1]);
		mm.setBounds(364, 260, 32, 24);
		contentPane.add(mm);
		mm.setColumns(10);
		
		aaa = new JLabel("-");
		aaa.setBounds(406, 262, 24, 21);
		contentPane.add(aaa);
		
		dd = new JTextField(Today[2]);
		dd.setColumns(10);
		dd.setBounds(416, 260, 32, 24);
		contentPane.add(dd);
	}
}
