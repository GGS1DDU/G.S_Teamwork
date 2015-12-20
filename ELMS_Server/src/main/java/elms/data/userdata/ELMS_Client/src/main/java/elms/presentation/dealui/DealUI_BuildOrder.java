package elms.presentation.dealui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import elms.vo.DealVO;
import elms.vo.UserVO;
import elms.businesslogic.dealbl.*;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class DealUI_BuildOrder extends JFrame {

	private JPanel Jp;
	private JTextField orderID;
	private JTextField couriername;
	UserVO vo;
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

	

	public DealUI_BuildOrder(UserVO vo) {
		this.vo=vo;
		setDefaultCloseOperation(JFrame. HIDE_ON_CLOSE);
		setBounds(100, 100, 1103, 1106);
		Jp = new JPanel();
		Jp.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Jp);
		Jp.setLayout(null);
		
		JLabel label = new JLabel("订单号");
		label.setBounds(63, 15, 66, 21);
		Jp.add(label);
		
		orderID = new JTextField();
		orderID.setBounds(169, 13, 173, 24);
		Jp.add(orderID);
		orderID.setColumns(10);
		
		JLabel label_1 = new JLabel("快递员");
		label_1.setBounds(63, 68, 66, 21);
		Jp.add(label_1);
		
		
		couriername = new JTextField();
		couriername.setText(vo.getName());
		couriername.setEditable(false);
		couriername.setBounds(169, 66, 109, 24);
		Jp.add(couriername);
		couriername.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("所属营业厅");
		lblNewLabel.setBounds(478, 68, 95, 21);
		Jp.add(lblNewLabel);
		
		final JComboBox hall = new JComboBox();
		hall.setModel(new DefaultComboBoxModel(new String[] {"南京市鼓楼营业厅", "南京市仙林营业厅"}));
		hall.setEditable(true);
		hall.setBounds(604, 66, 219, 24);
		Jp.add(hall);
		
		JLabel label_2 = new JLabel("生成时间");
		label_2.setBounds(478, 16, 81, 21);
		Jp.add(label_2);
		
		dealtime = new JTextField();
		dealtime.setEditable(false);
		Date dt=new Date();
		SimpleDateFormat matter=new SimpleDateFormat("yyyy-MM-dd");
		dealtime.setText(matter.format(dt));
		dealtime.setBounds(604, 12, 184, 24);
		Jp.add(dealtime);
		dealtime.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(27, 104, 959, 8);
		Jp.add(separator);
		
		JLabel label_3 = new JLabel("寄件人信息");
		label_3.setBounds(27, 120, 103, 21);
		Jp.add(label_3);
		
		JLabel lblNewLabel_1 = new JLabel("姓名");
		lblNewLabel_1.setBounds(114, 156, 44, 21);
		Jp.add(lblNewLabel_1);
		
		sendername = new JTextField();
		sendername.setBounds(173, 153, 96, 24);
		Jp.add(sendername);
		sendername.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("所在城市");
		lblNewLabel_2.setBounds(85, 205, 81, 21);
		Jp.add(lblNewLabel_2);
		
		final JComboBox sendercity = new JComboBox();
		sendercity.setModel(new DefaultComboBoxModel(new String[] {"北京", "上海", "广州", "南京"}));
		sendercity.setBounds(183, 203, 81, 24);
		Jp.add(sendercity);
		
		JLabel label_4 = new JLabel("联系方式");
		label_4.setBounds(436, 156, 81, 21);
		Jp.add(label_4);
		
		senderphone = new JTextField();
		senderphone.setBounds(556, 154, 201, 24);
		Jp.add(senderphone);
		senderphone.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("单位");
		lblNewLabel_3.setBounds(446, 205, 55, 21);
		Jp.add(lblNewLabel_3);
		
		sendercompany = new JTextField();
		sendercompany.setBounds(556, 203, 430, 24);
		Jp.add(sendercompany);
		sendercompany.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("收件人信息");
		lblNewLabel_4.setBounds(27, 258, 95, 21);
		Jp.add(lblNewLabel_4);
		
		JLabel label_5 = new JLabel("姓名");
		label_5.setBounds(114, 312, 44, 21);
		Jp.add(label_5);
		
		receivername = new JTextField();
		receivername.setBounds(173, 309, 96, 24);
		Jp.add(receivername);
		receivername.setColumns(10);
		
		JLabel label_6 = new JLabel("联系方式");
		label_6.setBounds(436, 312, 81, 21);
		Jp.add(label_6);
		
		JLabel lblNewLabel_5 = new JLabel("所在城市");
		lblNewLabel_5.setBounds(85, 375, 81, 21);
		Jp.add(lblNewLabel_5);
		
		final JComboBox receivercity = new JComboBox();
		receivercity.setModel(new DefaultComboBoxModel(new String[] {"北京", "上海", "广州", "南京"}));
		receivercity.setBounds(183, 372, 86, 24);
		Jp.add(receivercity);
		
		receiverphone = new JTextField();
		receiverphone.setBounds(556, 309, 201, 24);
		Jp.add(receiverphone);
		receiverphone.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("单位");
		lblNewLabel_6.setBounds(446, 385, 55, 21);
		Jp.add(lblNewLabel_6);
		
		receivercompany = new JTextField();
		receivercompany.setBounds(556, 382, 430, 24);
		Jp.add(receivercompany);
		receivercompany.setColumns(10);
		
		JLabel label_7 = new JLabel("货物信息");
		label_7.setBounds(27, 428, 81, 21);
		Jp.add(label_7);
		
		JLabel lblNewLabel_7 = new JLabel("名称");
		lblNewLabel_7.setBounds(63, 464, 44, 21);
		Jp.add(lblNewLabel_7);
		
		goodsname = new JTextField();
		goodsname.setBounds(114, 462, 154, 24);
		Jp.add(goodsname);
		goodsname.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("数量");
		lblNewLabel_8.setBounds(309, 464, 44, 21);
		Jp.add(lblNewLabel_8);
		
		goodsamount = new JTextField();
		goodsamount.setBounds(368, 461, 96, 24);
		Jp.add(goodsamount);
		goodsamount.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("重量");
		lblNewLabel_9.setBounds(508, 464, 44, 21);
		Jp.add(lblNewLabel_9);
		
		goodweight = new JTextField();
		goodweight.setBounds(567, 462, 66, 23);
		Jp.add(goodweight);
		goodweight.setColumns(10);
		
		JLabel lblG = new JLabel("g");
		lblG.setBounds(634, 464, 20, 21);
		Jp.add(lblG);
		
		JLabel label_8 = new JLabel("体积");
		label_8.setBounds(693, 464, 44, 21);
		Jp.add(label_8);
		
		goodsV = new JTextField();
		goodsV.setBounds(752, 464, 55, 21);
		Jp.add(goodsV);
		goodsV.setColumns(10);
		
		JLabel lblCmcmcm = new JLabel("cm*cm*cm");
		lblCmcmcm.setBounds(809, 464, 81, 21);
		Jp.add(lblCmcmcm);
		
		JLabel label_9 = new JLabel("快递种类");
		label_9.setBounds(63, 516, 81, 21);
		Jp.add(label_9);
		
		JLabel lblNewLabel_10 = new JLabel("包装方式");
		lblNewLabel_10.setBounds(63, 565, 81, 21);
		Jp.add(lblNewLabel_10);
		
		JLabel label_10 = new JLabel("运费");
		label_10.setBounds(63, 615, 44, 21);
		Jp.add(label_10);
		
		fee = new JTextField();
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
		
		days = new JTextField();
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
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(138, 693, 599, 113);
		Jp.add(textArea);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(37, 834, 949, 2);
		Jp.add(separator_2);
		
		JLabel label_15 = new JLabel("收件信息");
		label_15.setBounds(27, 879, 81, 21);
		Jp.add(label_15);
		
		JLabel label_16 = new JLabel("实际收件人");
		label_16.setBounds(77, 915, 103, 21);
		Jp.add(label_16);
		
		actualreceiver = new JTextField();
		actualreceiver.setEditable(false);
		actualreceiver.setBounds(217, 912, 96, 24);
		Jp.add(actualreceiver);
		actualreceiver.setColumns(10);
		
		JLabel label_17 = new JLabel("货物状态");
		label_17.setBounds(752, 679, 81, 21);
		Jp.add(label_17);
		
		state = new JTextField();
		state.setEditable(false);
		state.setBounds(752, 717, 96, 27);
		Jp.add(state);
		state.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("收件时间");
		lblNewLabel_11.setBounds(478, 915, 81, 21);
		Jp.add(lblNewLabel_11);
		
		receivetime = new JTextField();
		receivetime.setEditable(false);
		receivetime.setBounds(591, 912, 184, 24);
		Jp.add(receivetime);
		receivetime.setColumns(10);
		
		final JRadioButton type1 = new JRadioButton("经济快递");
		type1.setBounds(176, 512, 118, 29);
		Jp.add(type1);
		
		final JRadioButton type2 = new JRadioButton("标准快递");
		type2.setBounds(365, 512, 109, 29);
		Jp.add(type2);
		
		final JRadioButton type3 = new JRadioButton("特快专递");
		type3.setBounds(550, 512, 123, 29);
		Jp.add(type3);
		
		ButtonGroup bg1=new ButtonGroup();
		bg1.add(type1);bg1.add(type2);bg1.add(type3);
		
		
		final JRadioButton pack1 = new JRadioButton("纸箱");
		pack1.setBounds(176, 561, 95, 29);
		Jp.add(pack1);
		final JRadioButton pack2 = new JRadioButton("木箱");
		pack2.setBounds(365, 561, 109, 29);
		Jp.add(pack2);
		final JRadioButton pack3 = new JRadioButton("快递袋");
		pack3.setBounds(550, 561, 109, 29);
		Jp.add(pack3);
		final JRadioButton pack4 = new JRadioButton("其他");
		pack4.setBounds(713, 561, 69, 29);
		Jp.add(pack4);
		
		ButtonGroup bg2=new ButtonGroup();
		bg2.add(pack1);bg2.add(pack2);bg2.add(pack3);bg2.add(pack4);
		
		JButton build = new JButton("确认生成");
		build.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Hall=hall.getSelectedItem().toString();
				String name1=sendercity.getSelectedItem().toString();
				String name2=receivercity.getSelectedItem().toString();
				int amount=0;
				double weight=0;
				double volume=0;
				String type="";
				String pack="";
				
				String ID=orderID.getText();
				String [] id=ID.split("");
				if(id.length!=10){
					JOptionPane.showMessageDialog(null, "请输入10位数字的订单号！","失败!", JOptionPane.ERROR_MESSAGE);
					return ;
				}
				else{
					for(int i=0;i<10;i++){
						if(  (!id[i].equals("0"))&&(!id[i].equals("1"))&&(!id[i].equals("2"))&&(!id[i].equals("3"))&&(!id[i].equals("4"))&&(!id[i].equals("5"))&&(!id[i].equals("6"))&&(!id[i].equals("7"))&&(!id[i].equals("8"))&&(!id[i].equals("9"))   ){
							JOptionPane.showMessageDialog(null, "请确保输入的10位订单号是纯数字！","失败!", JOptionPane.ERROR_MESSAGE);
							return;
						}
					}
				}
				
				if(sendername.getText().equals("")||senderphone.getText().equals("")||sendercompany.getText().equals("")){
					JOptionPane.showMessageDialog(null, "请输入完整的寄件人信息！","失败!", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				if(receivername.getText().equals("")||receiverphone.getText().equals("")||receivercompany.getText().equals("")){
					JOptionPane.showMessageDialog(null, "请输入完整的收件人信息！","失败!", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				

				
				
				
				
				if(!fee.getText().equals("")){
					amount=Integer.parseInt(goodsamount.getText());
					weight=Double.parseDouble(goodweight.getText());
					volume=Double.parseDouble(goodsV.getText());
					
				}
				
				
				else{
					JOptionPane.showMessageDialog(null, "您还没有输入完整的托运信息或者还未生成运费!","失败!", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				
				if(type1.isSelected()){
					type="经济快递";
				}
				else if(type2.isSelected()){
					type="标准快递";
				}
				else if(type3.isSelected()){
					type="特快专递";
				}
				else{
					//快递员没选
					return;
				}
				
				
				if(pack1.isSelected()){
					pack="纸箱";
				}
				else if(pack2.isSelected()){
					pack="木箱";
				}
				else if(pack3.isSelected()){
					pack="快递袋";
				}
				else if(pack4.isSelected()){
					pack="其他";
				}
				else{
					//快递员没选!
					return;
				}
				
				
				DealVO dealvo=new DealVO(orderID.getText(),couriername.getText(),Hall,dealtime.getText(),
				sendername.getText(),name1,sendercompany.getText(),senderphone.getText(),receivername.getText(),name2,
				receivercompany.getText(),receiverphone.getText(),goodsname.getText(),amount,weight,volume,type,pack,
				Double.parseDouble(fee.getText()),Integer.parseInt(days.getText()),"", " " , "快递员收件" , "派件中" );
				
				DealBL dealbl=new DealBL();
				boolean buildSucceed=false;
				try {
					buildSucceed=dealbl.BuildOrder(dealvo);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				if(buildSucceed==true){
					DealUI_BuildOrder.this.dispose();
					JOptionPane.showMessageDialog(null, "该订单已成功生成!", "成功!", JOptionPane.INFORMATION_MESSAGE);
				}
				else{
					JOptionPane.showMessageDialog(null, "该订单号已存在！请更换订单号 。","失败!", JOptionPane.ERROR_MESSAGE);
				}
			
				
				
			}
		});
		build.setBounds(190, 1000, 123, 29);
		Jp.add(build);
		
		JButton button = new JButton("取消");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DealUI_BuildOrder.this.dispose();
				
			}
		});
		button.setBounds(604, 1000, 123, 29);
		Jp.add(button);
		
		
		
		JButton CalAndEst = new JButton("生成运费");
		CalAndEst.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String name1=sendercity.getSelectedItem().toString();
				String name2=receivercity.getSelectedItem().toString();
				String type="";
				String pack="";
				double weight=0;
				double volume=0;

				if((goodsname.getText().equals(""))||(goodsamount.getText().equals(""))||(goodweight.getText().equals(""))||(goodsV.getText().equals(""))){
					JOptionPane.showMessageDialog(null, "请将货物信息填写完整", "失败!", JOptionPane.ERROR_MESSAGE); 
					return;
				}
				
				if(type1.isSelected()){
					type="经济快递";
				}
				else if(type2.isSelected()){
					type="标准快递";
				}
				else if(type3.isSelected()){
					type="特快专递";
				}
				else{
					JOptionPane.showMessageDialog(null, "请选择快递类型!", "失败!", JOptionPane.ERROR_MESSAGE); 
					return;
				}
				
				
				if(pack1.isSelected()){
					pack="纸箱";
				}
				else if(pack2.isSelected()){
					pack="木箱";
				}
				else if(pack3.isSelected()){
					pack="快递袋";
				}
				else if(pack4.isSelected()){
					pack="其他";
				}
				else{
					JOptionPane.showMessageDialog(null, "请选择快递包装!", "失败!", JOptionPane.ERROR_MESSAGE); 
					return;
				}
				
				
									
				weight=Double.parseDouble(goodweight.getText());
				volume=Double.parseDouble(goodsV.getText());
				
				
				CalAndEst cae=new CalAndEst();
				double Fee=cae.calculatefee(name1,name2,type, pack, weight, volume);
				int Days=cae.estDays(name1, name2);
				
				
				fee.setText(Double.toString(Fee));
				days.setText(Integer.toString(Days));
				
				
				
						
				
			}
		});
		CalAndEst.setBounds(767, 611, 123, 29);
		Jp.add(CalAndEst);
		
		
	}
}
