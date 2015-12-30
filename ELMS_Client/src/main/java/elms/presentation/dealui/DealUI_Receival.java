package elms.presentation.dealui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;

import elms.businesslogic.dealbl.CheckOrder;
import elms.businesslogic.dealbl.DealBL;
import elms.vo.DealVO;
import elms.vo.UserVO;

import java.awt.Color;

public class DealUI_Receival extends JPanel {

	static Toolkit kit=Toolkit.getDefaultToolkit();
	static Dimension screenSize=kit.getScreenSize();
	static int screenWidth=(int) screenSize.getWidth();
	static int screenHeight=(int)screenSize.getHeight();
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
	public static void main(String args[]){
		JFrame f=new JFrame();
		f.setLayout(null);
		f.setResizable(false);
		f.setVisible(true);
		f.setDefaultCloseOperation(3);
		f.setBounds(screenWidth/6,screenHeight/8,screenWidth*2/3,screenHeight*3/4);
		UserVO vo=new UserVO();
		DealUI_Receival s=new DealUI_Receival(vo);

	JScrollPane js=new JScrollPane(s);
		f.add(js);js.setBounds(200, 40,screenWidth*2/3 -200, screenHeight*3/4-80);
	s.setPreferredSize(new Dimension(2000,1120));
	 js.setOpaque(false);js.getViewport().setOpaque(false);
	js.getVerticalScrollBar().setUnitIncrement(20);
	
	}
	public DealUI_Receival(UserVO vo) {
		this.setOpaque(false);
		setVisible(true);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("订单号");
		lblNewLabel.setBounds(97, 107, 81, 21);
		this.add(lblNewLabel);
		
		orderID = new JTextField();
		orderID.setBounds(285, 104, 220, 27);
		this.add(orderID);
		orderID.setColumns(10);
		
		label = new JLabel("实际收件人");
		label.setBounds(97, 188, 109, 21);
		this.add(label);
		
		acturalReceiver = new JTextField();
		acturalReceiver.setBounds(287, 185, 126, 27);
		this.add(acturalReceiver);
		acturalReceiver.setColumns(10);
		
		lblNewLabel_1 = new JLabel("收件时间");
		lblNewLabel_1.setBounds(97, 262, 98, 21);
		this.add(lblNewLabel_1);
		
		
		
		Date dt=new Date();
		SimpleDateFormat matter=new SimpleDateFormat("yyyy-MM-dd");
		String today=matter.format(dt);		
		String [] Today=today.split("-");
		
		
		

		
		lblNewLabel_2 = new JLabel("请输入形如xxxx-xx-xx形式的日期");
		lblNewLabel_2.setForeground(SystemColor.controlShadow);
		lblNewLabel_2.setBounds(480, 262, 287, 25);
		this.add(lblNewLabel_2);
		
		JButton button = new JButton("确认收件");
		button.setBackground(Color.WHITE);
		button.addMouseListener(new MouseAdapter() {
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
		button.setBounds(287, 350, 123, 29);
		this.add(button);
		

		
		yyyy = new JTextField(Today[0]);
		yyyy.setBounds(285, 260, 54, 24);
		this.add(yyyy);
		yyyy.setColumns(10);
		
		lblNewLabel_3 = new JLabel("-");
		lblNewLabel_3.setBounds(344, 262, 24, 21);
		this.add(lblNewLabel_3);
		
		mm = new JTextField(Today[1]);
		mm.setBounds(364, 260, 32, 24);
		this.add(mm);
		mm.setColumns(10);
		
		aaa = new JLabel("-");
		aaa.setBounds(406, 262, 24, 21);
		this.add(aaa);
		
		dd = new JTextField(Today[2]);
		dd.setColumns(10);
		dd.setBounds(416, 260, 32, 24);
		this.add(dd);

	}

	
	public void paintComponent(Graphics g){
	int x=0;int y=0;
	ImageIcon icon = new ImageIcon("inbg.jpg");
	g.drawImage(icon.getImage(), x, y, getSize().width,
		     getSize().height, this);
	
	}
}
