package elms.presentation.dealui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import elms.vo.DealVO;
import elms.vo.UserVO;

import java.awt.Rectangle;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * 
 * @author ZWH
 *
 */
public class DealUI_CheckOrder extends JFrame {
	UserVO uservo;
	DealVO dealvo;
	private JPanel Jp;
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
/**
 * 
 * @param uservo
 * @param dealvo
 */
	public DealUI_CheckOrder(UserVO uservo,DealVO dealvo) {
		this.dealvo=dealvo;
		this.uservo=uservo;
		
		setDefaultCloseOperation(JFrame. HIDE_ON_CLOSE);
		setBounds(100, 100, 1103, 1106);
		Jp = new JPanel();
		Jp.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Jp);
		Jp.setLayout(null);
		
		JLabel label = new JLabel("订单号");
		label.setBounds(63, 15, 66, 21);
		Jp.add(label);

		orderID = new JTextField(dealvo.getOrderID());
		orderID.setEditable(false);
		orderID.setBounds(169, 13, 173, 24);
		Jp.add(orderID);
		orderID.setColumns(10);
		
		JLabel label_2 = new JLabel("生成时间");
		label_2.setBounds(478, 16, 81, 21);
		Jp.add(label_2);
		
		dealtime = new JTextField(dealvo.getDealTime());
		dealtime.setEditable(false);
		dealtime.setBounds(604, 12, 184, 24);
		Jp.add(dealtime);
		dealtime.setColumns(10);
		
		JLabel label_1 = new JLabel("快递员");
		label_1.setBounds(63, 68, 66, 21);
		Jp.add(label_1);
		
		couriername = new JTextField(dealvo.getCourier_name());
		couriername.setEditable(false);
		couriername.setBounds(169, 66, 109, 24);
		Jp.add(couriername);
		couriername.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("所属营业厅");
		lblNewLabel.setBounds(478, 68, 95, 21);
		Jp.add(lblNewLabel);
		
		hall = new JTextField(dealvo.getHall());
		hall.setEditable(false);
		hall.setBounds(604, 65, 305, 27);
		Jp.add(hall);
		hall.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(27, 104, 959, 8);
		Jp.add(separator);
		
		JLabel label_3 = new JLabel("寄件人信息");
		label_3.setBounds(27, 120, 103, 21);
		Jp.add(label_3);
		
		JLabel lblNewLabel_1 = new JLabel("姓名");
		lblNewLabel_1.setBounds(114, 156, 44, 21);
		Jp.add(lblNewLabel_1);
		
		sendername = new JTextField(dealvo.getSender_name());
		sendername.setEditable(false);
		sendername.setBounds(173, 153, 96, 24);
		Jp.add(sendername);
		sendername.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("所在城市");
		lblNewLabel_2.setBounds(85, 205, 81, 21);
		Jp.add(lblNewLabel_2);
		
		sendercity = new JTextField(dealvo.getSender_city());
		sendercity.setEditable(false);
		sendercity.setBounds(169, 202, 96, 27);
		Jp.add(sendercity);
		sendercity.setColumns(10);
		
		JLabel label_4 = new JLabel("联系方式");
		label_4.setBounds(436, 156, 81, 21);
		Jp.add(label_4);
		
		senderphone = new JTextField(dealvo.getSender_phonenumber());
		senderphone.setEditable(false);
		senderphone.setBounds(556, 154, 201, 24);
		Jp.add(senderphone);
		senderphone.setColumns(10);
	
		JLabel lblNewLabel_3 = new JLabel("单位");
		lblNewLabel_3.setBounds(446, 205, 55, 21);
		Jp.add(lblNewLabel_3);
		
		sendercompany = new JTextField(dealvo.getSender_company());
		sendercompany.setEditable(false);
		sendercompany.setBounds(556, 203, 430, 24);
		Jp.add(sendercompany);
		sendercompany.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("收件人信息");
		lblNewLabel_4.setBounds(27, 258, 95, 21);
		Jp.add(lblNewLabel_4);
		
		JLabel label_5 = new JLabel("姓名");
		label_5.setBounds(114, 312, 44, 21);
		Jp.add(label_5);
		
		receivername = new JTextField(dealvo.getReceiver_name());
		receivername.setEditable(false);
		receivername.setBounds(173, 309, 96, 24);
		Jp.add(receivername);
		receivername.setColumns(10);
		
		JLabel label_6 = new JLabel("联系方式");
		label_6.setBounds(436, 312, 81, 21);
		Jp.add(label_6);
				
		receiverphone = new JTextField(dealvo.getReceiver_phonenumber());
		receiverphone.setEditable(false);
		receiverphone.setBounds(556, 309, 201, 24);
		Jp.add(receiverphone);
		receiverphone.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("所在城市");
		lblNewLabel_5.setBounds(85, 375, 81, 21);
		Jp.add(lblNewLabel_5);
		
		receivercity = new JTextField(dealvo.getReceiver_city());
		receivercity.setEditable(false);
		receivercity.setBounds(169, 372, 96, 27);
		Jp.add(receivercity);
		receivercity.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("单位");
		lblNewLabel_6.setBounds(446, 385, 55, 21);
		Jp.add(lblNewLabel_6);
		
		receivercompany = new JTextField(dealvo.getReceiver_company());
		receivercompany.setEditable(false);
		receivercompany.setBounds(556, 382, 430, 24);
		Jp.add(receivercompany);
		receivercompany.setColumns(10);
		
		JLabel label_7 = new JLabel("货物信息");
		label_7.setBounds(27, 428, 81, 21);
		Jp.add(label_7);
		
		JLabel lblNewLabel_7 = new JLabel("名称");
		lblNewLabel_7.setBounds(63, 464, 44, 21);
		Jp.add(lblNewLabel_7);
		
		goodsname = new JTextField(dealvo.getGoods_name());
		goodsname.setEditable(false);
		goodsname.setBounds(114, 462, 154, 24);
		Jp.add(goodsname);
		goodsname.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("数量");
		lblNewLabel_8.setBounds(309, 464, 44, 21);
		Jp.add(lblNewLabel_8);
				
		goodsamount = new JTextField((dealvo.getGoods_amount()+""));
		goodsamount.setEditable(false);
		goodsamount.setBounds(368, 461, 96, 24);
		Jp.add(goodsamount);
		goodsamount.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("重量");
		lblNewLabel_9.setBounds(508, 464, 44, 21);
		Jp.add(lblNewLabel_9);
		
		JLabel lblG = new JLabel("g");
		lblG.setBounds(634, 464, 20, 21);
		Jp.add(lblG);
		
		goodweight = new JTextField((dealvo.getGood_weight()+""));
		goodweight.setEditable(false);
		goodweight.setBounds(567, 462, 66, 23);
		Jp.add(goodweight);
		goodweight.setColumns(10);
		
		JLabel label_8 = new JLabel("体积");
		label_8.setBounds(693, 464, 44, 21);
		Jp.add(label_8);
		
		JLabel lblCmcmcm = new JLabel("cm*cm*cm");
		lblCmcmcm.setBounds(809, 464, 81, 21);
		Jp.add(lblCmcmcm);
		
		goodsV = new JTextField((dealvo.getGood_volume()+""));
		goodsV.setEditable(false);
		goodsV.setBounds(752, 464, 55, 21);
		Jp.add(goodsV);
		goodsV.setColumns(10);
		
		JLabel label_9 = new JLabel("快递种类");
		label_9.setBounds(63, 516, 81, 21);
		Jp.add(label_9);
		
		JLabel lblNewLabel_10 = new JLabel("包装方式");
		lblNewLabel_10.setBounds(63, 565, 81, 21);
		Jp.add(lblNewLabel_10);
		
		JLabel label_10 = new JLabel("运费");
		label_10.setBounds(63, 615, 44, 21);
		Jp.add(label_10);
		
		type = new JTextField(dealvo.getType());
		type.setEditable(false);
		type.setBounds(169, 513, 96, 27);
		Jp.add(type);
		type.setColumns(10);
		
		pack = new JTextField(dealvo.getPack());
		pack.setEditable(false);
		pack.setBounds(169, 562, 96, 27);
		Jp.add(pack);
		pack.setColumns(10);
		
		fee = new JTextField((dealvo.getFee()+""));
		fee.setEditable(false);
		fee.setBounds(138, 612, 109, 24);
		Jp.add(fee);
		fee.setColumns(10);
		
		JLabel label_11 = new JLabel("元");
		label_11.setBounds(249, 615, 27, 21);
		Jp.add(label_11);
		
		JLabel label_12 = new JLabel("预计到达天数");
		label_12.setBounds(368, 615, 118, 21);
		Jp.add(label_12);
		
		days = new JTextField((dealvo.getDelaydays()+""));
		days.setEditable(false);
		days.setBounds(508, 612, 34, 24);
		Jp.add(days);
		days.setColumns(10);
		
		JLabel label_13 = new JLabel("天");
		label_13.setBounds(545, 615, 27, 21);
		Jp.add(label_13);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(37, 651, 959, 2);
		Jp.add(separator_1);
		
		JLabel label_14 = new JLabel("物流信息");
		label_14.setBounds(27, 668, 81, 21);
		Jp.add(label_14);
		
		JTextArea track = new JTextArea();
		track.setText(dealvo.getTrack());
		track.setEditable(false);
		track.setBounds(138, 693, 599, 113);
		Jp.add(track);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(37, 834, 949, 2);
		Jp.add(separator_2);
		
		JLabel label_15 = new JLabel("收件信息");
		label_15.setBounds(27, 879, 81, 21);
		Jp.add(label_15);
		
		JLabel label_16 = new JLabel("实际收件人");
		label_16.setBounds(77, 915, 103, 21);
		Jp.add(label_16);
		
		
		actualreceiver = new JTextField(dealvo.getActualreceiver_name());
		actualreceiver.setEditable(false);
		actualreceiver.setBounds(217, 912, 96, 24);
		Jp.add(actualreceiver);
		actualreceiver.setColumns(10);
				
		JLabel label_17 = new JLabel("货物状态");
		label_17.setBounds(752, 679, 81, 21);
		Jp.add(label_17);
		
		state = new JTextField(dealvo.getState());
		state.setEditable(false);
		state.setBounds(752, 717, 96, 27);
		Jp.add(state);
		state.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("收件时间");
		lblNewLabel_11.setBounds(478, 915, 81, 21);
		Jp.add(lblNewLabel_11);
		
		receivetime = new JTextField(dealvo.getReceivaltime());
		receivetime.setEditable(false);
		receivetime.setBounds(591, 912, 184, 24);
		Jp.add(receivetime);
		receivetime.setColumns(10);
		
		JButton sure = new JButton("确定");
		sure.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DealUI_CheckOrder.this.dispose();
			}
		});
		sure.setBounds(436, 978, 123, 41);
		Jp.add(sure);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
