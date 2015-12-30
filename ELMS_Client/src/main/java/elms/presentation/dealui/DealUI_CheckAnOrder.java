package elms.presentation.dealui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import elms.businesslogic.dealbl.CheckOrder;
import elms.businesslogic.dealbl.DealBL;
import elms.vo.DealVO;
import elms.vo.UserVO;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Color;

import javax.swing.border.LineBorder;

public class DealUI_CheckAnOrder extends JPanel {

	UserVO uservo;
	static Toolkit kit=Toolkit.getDefaultToolkit();
	static Dimension screenSize=kit.getScreenSize();
	static int screenWidth=(int) screenSize.getWidth();
	static int screenHeight=(int)screenSize.getHeight();
	DealVO dealvo;
	private JTextField orderID;
	private JTextField couriername;
	private JTextField dealtime;
	private JTextField sendername;
	private JTextField senderphone;
	private JTextField sendercompany;
	private JTextField receivername;
	private JTextField receiverphone;
	private JTextField receivercompany;
	private JTextField goodsname;
	private JTextField goodsamount;
	private JTextField goodweight;
	private JTextField goodsV;
	private JTextField fee;
	private JTextField days;
	private JTextField actualreceiver;
	private JTextField state;
	private JTextField receivetime;
	private JTextField hall;
	private JTextField sendercity;
	private JTextField receivercity;
	private JTextField type;
	private JTextField pack;
	private JTextField textField;
	private JTextArea track;
	
	public static void main(String args[]){
		JFrame f=new JFrame();
		f.setLayout(null);
		f.setResizable(false);
		f.setVisible(true);
		f.setDefaultCloseOperation(3);
		f.setBounds(screenWidth/6,screenHeight/8,screenWidth*2/3,screenHeight*3/4);
		UserVO vo=new UserVO();
		DealUI_CheckAnOrder s=new DealUI_CheckAnOrder(vo);

	JScrollPane js=new JScrollPane(s);
		f.add(js);js.setBounds(200, 40,screenWidth*2/3 -200, screenHeight*3/4-80);
	s.setPreferredSize(new Dimension(2000,1120));
	 js.setOpaque(false);js.getViewport().setOpaque(false);
	js.getVerticalScrollBar().setUnitIncrement(20);
	
	}
	public DealUI_CheckAnOrder(UserVO uservo) {
	
		this.uservo=uservo;
		setVisible(true);
		setOpaque(false);
		setLayout(null);
		
		JLabel label = new JLabel("订单号");
		label.setBounds(30, 25,60, 25);
		add(label);
		
		orderID = new JTextField();
		orderID.setBounds(100, 25, 80, 25);
		add(orderID);
		
		JLabel label_1 = new JLabel("快递员");
		label_1.setBounds(30, 60, 60, 25);
		add(label_1);
		
		couriername = new JTextField();
		couriername.setEditable(false);
		couriername.setBounds(100, 60, 100, 25);
		add(couriername);
		
		JLabel label_2 = new JLabel("生成时间");
		label_2.setBounds(300, 25, 80, 25);
		add(label_2);
		
		dealtime = new JTextField();
		dealtime.setEditable(false);
		dealtime.setBounds(screenWidth/4+50, 25, 100, 25);
		add(dealtime);
		
		JLabel lblNewLabel = new JLabel("所属营业厅");
		lblNewLabel.setBounds(300, 60, 100, 25);
		add(lblNewLabel);
		
		hall = new JTextField();
		hall.setBounds(screenWidth/4+50, 60,120, 25);
		add(hall);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(27, 100, screenWidth*3/4-200, 8);
		add(separator);
		
		JLabel label_3 = new JLabel("寄件人信息");
		label_3.setBounds(20, 120, 100, 25);
		add(label_3);
		
		JLabel lblNewLabel_1 = new JLabel("姓名");
		lblNewLabel_1.setBounds(30, 150, 40, 25);
		add(lblNewLabel_1);
		
		sendername = new JTextField();
		sendername.setBounds(100, 150, 100, 25);
		add(sendername);
		
		JLabel lblNewLabel_2 = new JLabel("所在城市");
		lblNewLabel_2.setBounds(30, 185, 80, 25);
		this.add(lblNewLabel_2);
		
		sendercity = new JTextField();
		sendercity.setBounds(100, 185, 80, 25);
		add(sendercity);
		
		JLabel label_4 = new JLabel("联系方式");
		label_4.setBounds(300, 150, 80, 25);
		add(label_4);
		
		senderphone = new JTextField();
		senderphone.setBounds(screenWidth/4+50, 150, 200, 25);
		add(senderphone);
		
		
		JLabel lblNewLabel_3 = new JLabel("单位");
		lblNewLabel_3.setBounds(300, 185, 55, 25);
		add(lblNewLabel_3);
		
		sendercompany = new JTextField();
		sendercompany.setBounds(screenWidth/4+50, 185, 300, 25);
		add(sendercompany);
		sendercompany.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("收件人信息");
		lblNewLabel_4.setBounds(20, 225, 95, 25);
		add(lblNewLabel_4);
		
		JLabel label_5 = new JLabel("姓名");
		label_5.setBounds(30, 260, 44, 25);
		add(label_5);
		
		receivername = new JTextField();
		receivername.setBounds(100, 260, 100, 25);
		add(receivername);
		
		JLabel label_6 = new JLabel("联系方式");
		label_6.setBounds(300, 260, 80, 25);
		add(label_6);
		
		receiverphone = new JTextField();
		receiverphone.setBounds(screenWidth/4+50, 260, 200, 25);
		add(receiverphone);

		
		JLabel lblNewLabel_5 = new JLabel("所在城市");
		lblNewLabel_5.setBounds(30, 295, 80, 25);
		add(lblNewLabel_5);
		
		receivercity = new JTextField();
		receivercity.setBounds(100, 295, 80, 25);
		add(receivercity);
		

		
		JLabel lblNewLabel_6 = new JLabel("单位");
		lblNewLabel_6.setBounds(300, 295, 55, 25);
		add(lblNewLabel_6);
		
		receivercompany = new JTextField();
		receivercompany.setBounds(screenWidth/4+50, 295, 300, 25);
		add(receivercompany);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(20, 350, screenWidth*3/4-200, 6);
		this.add(separator_1);
		
		JLabel label_7 = new JLabel("货物信息");
		label_7.setBounds(20, 360, 81, 25);
		add(label_7);
		
		JLabel lblNewLabel_7 = new JLabel("名称");
		lblNewLabel_7.setBounds(30, 390, 44, 25);
		add(lblNewLabel_7);
		
		goodsname = new JTextField();
		goodsname.setBounds(80, 390, 100, 25);
		add(goodsname);
		goodsname.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("数量");
		lblNewLabel_8.setBounds(200, 390, 44, 25);
		this.add(lblNewLabel_8);
		
		goodsamount = new JTextField();
		goodsamount.setBounds(250,390, 100, 25);
		this.add(goodsamount);
		goodsamount.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("重量");
		lblNewLabel_9.setBounds(360, 390, 44, 25);
		this.add(lblNewLabel_9);
		
		goodweight = new JTextField();
		goodweight.setBounds(410,390, 60, 25);
		this.add(goodweight);
		goodweight.setColumns(10);
		
		JLabel lblG = new JLabel("g");
		lblG.setBounds(470, 390, 20, 25);
		this.add(lblG);
		
		JLabel label_8 = new JLabel("体积");
		label_8.setBounds(490, 390, 40, 25);
		this.add(label_8);
		
		goodsV = new JTextField();
		goodsV.setBounds(530, 390, 55, 25);
		this.add(goodsV);
	
		
		JLabel lblCmcmcm = new JLabel("cm*cm*cm");
		lblCmcmcm.setBounds(590,390, 81, 25);
		this.add(lblCmcmcm);
		
		JLabel label_9 = new JLabel("快递种类");
		label_9.setBounds(30, 430, 81, 25);
		this.add(label_9);
		
		JLabel lblNewLabel_10 = new JLabel("包装方式");
		lblNewLabel_10.setBounds(30, 500, 81, 25);
		this.add(lblNewLabel_10);
		
	   type=new JTextField();
	   type.setBounds(80, 430, 100, 25);
		add(type);
		pack=new JTextField();
		pack.setBounds(80, 500, 100,25);
		add(pack);
		
		JLabel label_10 = new JLabel("运费");
		label_10.setBounds(30,600, 44, 25);
		this.add(label_10);
		
		fee = new JTextField();
		fee.setEditable(false);
		fee.setBounds(70, 600, 80, 25);
		this.add(fee);
		
		JLabel label_11 = new JLabel("元");
		label_11.setBounds(150, 600, 27, 25);
		this.add(label_11);
		
		JLabel label_12 = new JLabel("预计到达天数");
		label_12.setBounds(250, 600, 120, 25);
		this.add(label_12);
		
		days = new JTextField();
		days.setEditable(false);
		days.setBounds(340, 600, 40, 25);
		this.add(days);
		
		JLabel label_13 = new JLabel("天");
		label_13.setBounds(380, 600, 27, 25);
		this.add(label_13);
		
	JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(20, 670, screenWidth*3/4-200, 6);
		this.add(separator_2);
		
		JLabel label_14 = new JLabel("物流信息");
		label_14.setBounds(20, 680, 81, 25);
		this.add(label_14);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(SystemColor.control);
		textArea.setBorder(new LineBorder(new Color(0, 0, 0)));
		textArea.setEditable(false);
		textArea.setBounds(100, 720, screenWidth*2/3-400, 140);
		this.add(textArea);
		
		JLabel label_17 = new JLabel("货物状态");
		label_17.setBounds(70, 885, 81, 25);
		this.add(label_17);
		
		state = new JTextField();
		state.setEditable(false);
		state.setBounds(155, 885, 96, 25);
		this.add(state);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(27, 925, screenWidth*2/3, 8);
		add(separator_3);
		
		JLabel label_15 = new JLabel("收件信息");
		label_15.setBounds(20, 940, 81, 25);
		this.add(label_15);
		
		JLabel label_16 = new JLabel("实际收件人");
		label_16.setBounds(80, 980, 100, 25);
		this.add(label_16);
		
		actualreceiver = new JTextField();
		actualreceiver.setBackground(SystemColor.control);
		actualreceiver.setEditable(false);
		actualreceiver.setBounds(180, 980, 100, 25);
		this.add(actualreceiver);
	
			
		JLabel lblNewLabel_11 = new JLabel("收件时间");
		lblNewLabel_11.setBounds(340, 980, 80, 25);
		this.add(lblNewLabel_11);
		
		receivetime = new JTextField();
		receivetime.setBackground(SystemColor.control);
		receivetime.setEditable(false);
		receivetime.setBounds(420, 980, 180, 25);
		this.add(receivetime);

		
		JLabel label_18 = new JLabel("输入订单号");
		label_18.setBounds(40, 1060, 95, 25);
		add(label_18);
		
		textField = new JTextField();
		textField.setBounds(150, 1060, 150, 25);
		add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("查询");
		button.setBackground(Color.WHITE);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String ID=textField.getText();
				CheckOrder co=new CheckOrder();
				if(co.IsTenNumbers(ID)==2){
					JOptionPane.showMessageDialog(null, "请输入10位数字的订单号！","失败!", JOptionPane.ERROR_MESSAGE);
					return ;
				}
				else{
						if(co.IsTenNumbers(ID)==1){
							JOptionPane.showMessageDialog(null, "请确保输入的10位订单号是纯数字！","失败!", JOptionPane.ERROR_MESSAGE);
							return;
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
					orderID.setText(dealvo.getOrderID());
					dealtime.setText(dealvo.getDealTime());
					couriername.setText(dealvo.getCourier_name());
					hall.setText(dealvo.getHall());
					sendername.setText(dealvo.getSender_name());
					sendercity.setText(dealvo.getSender_city());
					senderphone.setText(dealvo.getSender_phonenumber());
					sendercompany.setText(dealvo.getSender_company());
					receivername.setText(dealvo.getReceiver_name());
					receiverphone.setText(dealvo.getReceiver_phonenumber());
					receivercity.setText(dealvo.getReceiver_city());
					receivercompany.setText(dealvo.getReceiver_company());
					goodsname.setText(dealvo.getGoods_name());
					goodsamount.setText((dealvo.getGoods_amount()+" "));
					goodweight.setText((dealvo.getGood_weight()+" "));
					goodsV.setText((dealvo.getGood_volume()+" "));
					type.setText(dealvo.getType());
					pack.setText(dealvo.getPack());
					fee.setText((dealvo.getFee()+" "));
					days.setText((dealvo.getDelaydays()+" "));
					track.setText(dealvo.getTrack());
					state.setText(dealvo.getState());
					actualreceiver.setText(dealvo.getActualreceiver_name());
					receivetime.setText(dealvo.getReceivaltime());
					
				}
				
				
				
			}
		});
		button.setBounds(400, 1060, 123, 30);
		add(button);
		
		
		
		

	}

}
