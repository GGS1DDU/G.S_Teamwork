package elms.presentation.dealui;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import elms.businesslogic.dealbl.CheckOrder;
import elms.businesslogic.dealbl.DealBL;
import elms.vo.DealVO;
import elms.vo.UserVO;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class DealUI_CheckAnOrder extends JPanel {

	UserVO uservo;
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
	
	public DealUI_CheckAnOrder(UserVO uservo) {
		setBackground(new Color(240, 248, 255));
		this.uservo=uservo;
		
		setSize(1050,1166);
		
		this.setLayout(null);
		
		JLabel label = new JLabel("订单号");
		label.setBounds(63, 156, 66, 21);
		this.add(label);

		orderID = new JTextField(" ");
		orderID.setEditable(false);
		orderID.setBounds(169, 154, 173, 24);
		this.add(orderID);
		orderID.setColumns(10);
		
		JLabel label_2 = new JLabel("生成时间");
		label_2.setBounds(478, 156, 81, 21);
		this.add(label_2);
		
		dealtime = new JTextField(" ");
		dealtime.setEditable(false);
		dealtime.setBounds(606, 156, 184, 24);
		this.add(dealtime);
		dealtime.setColumns(10);
		
		JLabel label_1 = new JLabel("快递员");
		label_1.setBounds(63, 207, 66, 21);
		this.add(label_1);
		
		couriername = new JTextField(" ");
		couriername.setEditable(false);
		couriername.setBounds(169, 205, 109, 24);
		this.add(couriername);
		couriername.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("所属营业厅");
		lblNewLabel.setBounds(478, 207, 95, 21);
		this.add(lblNewLabel);
		
		hall = new JTextField(" ");
		hall.setEditable(false);
		hall.setBounds(606, 204, 305, 27);
		this.add(hall);
		hall.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(34, 260, 959, 8);
		this.add(separator);
		
		JLabel label_3 = new JLabel("寄件人信息");
		label_3.setBounds(34, 283, 103, 21);
		this.add(label_3);
		
		JLabel lblNewLabel_1 = new JLabel("姓名");
		lblNewLabel_1.setBounds(114, 319, 44, 21);
		this.add(lblNewLabel_1);
		
		sendername = new JTextField(" ");
		sendername.setEditable(false);
		sendername.setBounds(182, 317, 96, 24);
		this.add(sendername);
		sendername.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("所在城市");
		lblNewLabel_2.setBounds(85, 368, 81, 21);
		this.add(lblNewLabel_2);
		
		sendercity = new JTextField(" ");
		sendercity.setEditable(false);
		sendercity.setBounds(182, 365, 96, 27);
		this.add(sendercity);
		sendercity.setColumns(10);
		
		JLabel label_4 = new JLabel("联系方式");
		label_4.setBounds(436, 319, 81, 21);
		this.add(label_4);
		
		senderphone = new JTextField(" ");
		senderphone.setEditable(false);
		senderphone.setBounds(556, 317, 201, 24);
		this.add(senderphone);
		senderphone.setColumns(10);
	
		JLabel lblNewLabel_3 = new JLabel("单位");
		lblNewLabel_3.setBounds(436, 368, 55, 21);
		this.add(lblNewLabel_3);
		
		sendercompany = new JTextField(" ");
		sendercompany.setEditable(false);
		sendercompany.setBounds(556, 366, 430, 24);
		this.add(sendercompany);
		sendercompany.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("收件人信息");
		lblNewLabel_4.setBounds(34, 421, 95, 21);
		this.add(lblNewLabel_4);
		
		JLabel label_5 = new JLabel("姓名");
		label_5.setBounds(114, 457, 44, 21);
		this.add(label_5);
		
		receivername = new JTextField(" ");
		receivername.setEditable(false);
		receivername.setBounds(182, 455, 96, 24);
		this.add(receivername);
		receivername.setColumns(10);
		
		JLabel label_6 = new JLabel("联系方式");
		label_6.setBounds(436, 457, 81, 21);
		this.add(label_6);
				
		receiverphone = new JTextField(" ");
		receiverphone.setEditable(false);
		receiverphone.setBounds(556, 455, 201, 24);
		this.add(receiverphone);
		receiverphone.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("所在城市");
		lblNewLabel_5.setBounds(77, 510, 81, 21);
		this.add(lblNewLabel_5);
		
		receivercity = new JTextField(" ");
		receivercity.setEditable(false);
		receivercity.setBounds(182, 507, 96, 27);
		this.add(receivercity);
		receivercity.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("单位");
		lblNewLabel_6.setBounds(449, 510, 55, 21);
		this.add(lblNewLabel_6);
		
		receivercompany = new JTextField(" ");
		receivercompany.setEditable(false);
		receivercompany.setBounds(556, 508, 430, 24);
		this.add(receivercompany);
		receivercompany.setColumns(10);
		
		JLabel label_7 = new JLabel("货物信息");
		label_7.setBounds(26, 561, 81, 21);
		this.add(label_7);
		
		JLabel lblNewLabel_7 = new JLabel("名称");
		lblNewLabel_7.setBounds(63, 597, 44, 21);
		this.add(lblNewLabel_7);
		
		goodsname = new JTextField(" ");
		goodsname.setEditable(false);
		goodsname.setBounds(124, 595, 154, 24);
		this.add(goodsname);
		goodsname.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("数量");
		lblNewLabel_8.setBounds(326, 597, 44, 21);
		this.add(lblNewLabel_8);
				
		goodsamount = new JTextField(" ");
		goodsamount.setEditable(false);
		goodsamount.setBounds(368, 595, 96, 24);
		this.add(goodsamount);
		goodsamount.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("重量");
		lblNewLabel_9.setBounds(508, 597, 44, 21);
		this.add(lblNewLabel_9);
		
		JLabel lblG = new JLabel("g");
		lblG.setBounds(648, 597, 20, 21);
		this.add(lblG);
		
		goodweight = new JTextField(" ");
		goodweight.setEditable(false);
		goodweight.setBounds(567, 596, 66, 23);
		this.add(goodweight);
		goodweight.setColumns(10);
		
		JLabel label_8 = new JLabel("体积");
		label_8.setBounds(693, 597, 44, 21);
		this.add(label_8);
		
		JLabel lblCmcmcm = new JLabel("cm*cm*cm");
		lblCmcmcm.setBounds(822, 597, 81, 21);
		this.add(lblCmcmcm);
		
		goodsV = new JTextField(" ");
		goodsV.setEditable(false);
		goodsV.setBounds(752, 597, 55, 21);
		this.add(goodsV);
		goodsV.setColumns(10);
		
		JLabel label_9 = new JLabel("快递种类");
		label_9.setBounds(56, 649, 81, 21);
		this.add(label_9);
		
		JLabel lblNewLabel_10 = new JLabel("包装方式");
		lblNewLabel_10.setBounds(326, 649, 81, 21);
		this.add(lblNewLabel_10);
		
		JLabel label_10 = new JLabel("运费");
		label_10.setBounds(63, 706, 44, 21);
		this.add(label_10);
		
		type = new JTextField(" ");
		type.setEditable(false);
		type.setBounds(169, 643, 96, 27);
		this.add(type);
		type.setColumns(10);
		
		pack = new JTextField(" ");
		pack.setEditable(false);
		pack.setBounds(436, 646, 96, 27);
		this.add(pack);
		pack.setColumns(10);
		
		fee = new JTextField(" ");
		fee.setEditable(false);
		fee.setBounds(138, 704, 109, 24);
		this.add(fee);
		fee.setColumns(10);
		
		JLabel label_11 = new JLabel("元");
		label_11.setBounds(247, 706, 27, 21);
		this.add(label_11);
		
		JLabel label_12 = new JLabel("预计到达天数");
		label_12.setBounds(326, 706, 118, 21);
		this.add(label_12);
		
		days = new JTextField(" ");
		days.setEditable(false);
		days.setBounds(459, 704, 34, 24);
		this.add(days);
		days.setColumns(10);
		
		JLabel label_13 = new JLabel("天");
		label_13.setBounds(493, 706, 27, 21);
		this.add(label_13);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(27, 757, 959, 2);
		this.add(separator_1);
		
		JLabel label_14 = new JLabel("物流信息");
		label_14.setBounds(27, 774, 81, 21);
		this.add(label_14);
		
		track = new JTextArea();
		track.setBorder(new LineBorder(new Color(0, 0, 0)));
		track.setText(" ");
		track.setEditable(false);
		track.setBounds(138, 814, 599, 113);
		this.add(track);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(37, 991, 949, 2);
		this.add(separator_2);
		
		JLabel label_15 = new JLabel("收件信息");
		label_15.setBounds(37, 1008, 81, 21);
		this.add(label_15);
		
		JLabel label_16 = new JLabel("实际收件人");
		label_16.setBounds(85, 1066, 103, 21);
		this.add(label_16);
		
		
		actualreceiver = new JTextField(" ");
		actualreceiver.setEditable(false);
		actualreceiver.setBounds(222, 1064, 96, 24);
		this.add(actualreceiver);
		actualreceiver.setColumns(10);
				
		JLabel label_17 = new JLabel("货物状态");
		label_17.setBounds(752, 774, 81, 21);
		this.add(label_17);
		
		state = new JTextField(" ");
		state.setEditable(false);
		state.setBounds(752, 810, 96, 27);
		this.add(state);
		state.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("收件时间");
		lblNewLabel_11.setBounds(478, 1066, 81, 21);
		this.add(lblNewLabel_11);
		
		receivetime = new JTextField(" ");
		receivetime.setEditable(false);
		receivetime.setBounds(587, 1064, 184, 24);
		this.add(receivetime);
		receivetime.setColumns(10);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(28, 126, 958, 15);
		add(separator_3);
		
		JLabel label_18 = new JLabel("输入订单号");
		label_18.setBounds(85, 67, 95, 21);
		add(label_18);
		
		textField = new JTextField();
		textField.setBounds(232, 64, 401, 27);
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
		button.setBounds(674, 63, 123, 29);
		add(button);
		
		
		
		

	}

	public void paintComponent(Graphics g){
	int x=0;int y=0;
	ImageIcon icon = new ImageIcon("inbg.jpg");
	g.drawImage(icon.getImage(), x, y, getSize().width,
		     getSize().height, this);
	
	}

}
