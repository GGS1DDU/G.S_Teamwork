package elms.presentation.dealui;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import elms.businesslogic.dealbl.CalFee;
import elms.businesslogic.dealbl.CheckOrder;
import elms.businesslogic.dealbl.DealBL;
import elms.businesslogic.dealbl.EstDay;
import elms.vo.DealVO;
import elms.vo.UserVO;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Color;

import javax.swing.border.LineBorder;

import java.awt.SystemColor;

public class DealUI_BuildAnOrder extends JPanel {

	UserVO vo;
	
	int width;
	int height;
	
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
	
	
	public DealUI_BuildAnOrder(UserVO vo) {
		
		Dimension   screensize   =   Toolkit.getDefaultToolkit().getScreenSize();
		width = (int)screensize.getWidth();
		height = (int)screensize.getHeight();
		
		setBackground(new Color(240, 248, 255));
		this.vo=vo;

		setSize( width*2/3-200,height*3/4-36);
		
		this.setLayout(null);
		
		JLabel label = new JLabel("订单号");
		label.setBounds(63, 53, 66, 21);
		this.add(label);
		
		orderID = new JTextField();
		orderID.setBounds(169, 51, 173, 24);
		this.add(orderID);
		orderID.setColumns(10);
		
		JLabel label_1 = new JLabel("快递员");
		label_1.setBounds(63, 102, 66, 21);
		this.add(label_1);
		
		
		couriername = new JTextField();
		couriername.setBackground(SystemColor.control);
		couriername.setText(vo.getName());
		couriername.setEditable(false);
		couriername.setBounds(169, 100, 109, 24);
		this.add(couriername);
		couriername.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("所属营业厅");
		lblNewLabel.setBounds(480, 102, 95, 21);
		this.add(lblNewLabel);
		
		final JComboBox hall = new JComboBox();
		hall.setModel(new DefaultComboBoxModel(new String[] {"南京市鼓楼营业厅", "南京市仙林营业厅"}));
		hall.setEditable(true);
		hall.setBounds(608, 100, 219, 24);
		this.add(hall);
		
		JLabel label_2 = new JLabel("生成时间");
		label_2.setBounds(480, 53, 81, 21);
		this.add(label_2);
		
		dealtime = new JTextField();
		dealtime.setBackground(SystemColor.control);
		dealtime.setEditable(false);
		Date dt=new Date();
		SimpleDateFormat matter=new SimpleDateFormat("yyyy-MM-dd");
		dealtime.setText(matter.format(dt));
		dealtime.setBounds(604, 51, 184, 24);
		this.add(dealtime);
		dealtime.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(27, 154, 959, 8);
		this.add(separator);
		
		JLabel label_3 = new JLabel("寄件人信息");
		label_3.setBounds(26, 163, 103, 21);
		this.add(label_3);
		
		JLabel lblNewLabel_1 = new JLabel("姓名");
		lblNewLabel_1.setBounds(114, 199, 44, 21);
		this.add(lblNewLabel_1);
		
		sendername = new JTextField();
		sendername.setBounds(182, 197, 96, 24);
		this.add(sendername);
		sendername.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("所在城市");
		lblNewLabel_2.setBounds(85, 258, 81, 21);
		this.add(lblNewLabel_2);
		
		final JComboBox sendercity = new JComboBox();
		sendercity.setBackground(Color.WHITE);
		sendercity.setModel(new DefaultComboBoxModel(new String[] {"北京", "上海", "广州", "南京"}));
		sendercity.setBounds(181, 256, 81, 24);
		this.add(sendercity);
		
		JLabel label_4 = new JLabel("联系方式");
		label_4.setBounds(436, 199, 81, 21);
		this.add(label_4);
		
		senderphone = new JTextField();
		senderphone.setBounds(556, 197, 201, 24);
		this.add(senderphone);
		senderphone.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("单位");
		lblNewLabel_3.setBounds(446, 258, 55, 21);
		this.add(lblNewLabel_3);
		
		sendercompany = new JTextField();
		sendercompany.setBounds(556, 256, 430, 24);
		this.add(sendercompany);
		sendercompany.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("收件人信息");
		lblNewLabel_4.setBounds(27, 310, 95, 21);
		this.add(lblNewLabel_4);
		
		JLabel label_5 = new JLabel("姓名");
		label_5.setBounds(114, 354, 44, 21);
		this.add(label_5);
		
		receivername = new JTextField();
		receivername.setBounds(182, 352, 96, 24);
		this.add(receivername);
		receivername.setColumns(10);
		
		JLabel label_6 = new JLabel("联系方式");
		label_6.setBounds(436, 354, 81, 21);
		this.add(label_6);
		
		JLabel lblNewLabel_5 = new JLabel("所在城市");
		lblNewLabel_5.setBounds(85, 414, 81, 21);
		this.add(lblNewLabel_5);
		
		final JComboBox receivercity = new JComboBox();
		receivercity.setBackground(Color.WHITE);
		receivercity.setModel(new DefaultComboBoxModel(new String[] {"北京", "上海", "广州", "南京"}));
		receivercity.setBounds(183, 411, 86, 24);
		this.add(receivercity);
		
		receiverphone = new JTextField();
		receiverphone.setBounds(556, 352, 201, 24);
		this.add(receiverphone);
		receiverphone.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("单位");
		lblNewLabel_6.setBounds(446, 414, 55, 21);
		this.add(lblNewLabel_6);
		
		receivercompany = new JTextField();
		receivercompany.setBounds(556, 412, 430, 24);
		this.add(receivercompany);
		receivercompany.setColumns(10);
		
		JLabel label_7 = new JLabel("货物信息");
		label_7.setBounds(27, 484, 81, 21);
		this.add(label_7);
		
		JLabel lblNewLabel_7 = new JLabel("名称");
		lblNewLabel_7.setBounds(64, 540, 44, 21);
		this.add(lblNewLabel_7);
		
		goodsname = new JTextField();
		goodsname.setBounds(146, 538, 154, 24);
		this.add(goodsname);
		goodsname.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("数量");
		lblNewLabel_8.setBounds(362, 540, 44, 21);
		this.add(lblNewLabel_8);
		
		goodsamount = new JTextField();
		goodsamount.setBounds(421, 538, 96, 24);
		this.add(goodsamount);
		goodsamount.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("重量");
		lblNewLabel_9.setBounds(554, 540, 44, 21);
		this.add(lblNewLabel_9);
		
		goodweight = new JTextField();
		goodweight.setBounds(604, 539, 66, 23);
		this.add(goodweight);
		goodweight.setColumns(10);
		
		JLabel lblG = new JLabel("g");
		lblG.setBounds(670, 540, 20, 21);
		this.add(lblG);
		
		JLabel label_8 = new JLabel("体积");
		label_8.setBounds(719, 540, 44, 21);
		this.add(label_8);
		
		goodsV = new JTextField();
		goodsV.setBounds(768, 540, 55, 21);
		this.add(goodsV);
		goodsV.setColumns(10);
		
		JLabel lblCmcmcm = new JLabel("cm*cm*cm");
		lblCmcmcm.setBounds(822, 540, 81, 21);
		this.add(lblCmcmcm);
		
		JLabel label_9 = new JLabel("快递种类");
		label_9.setBounds(63, 603, 81, 21);
		this.add(label_9);
		
		JLabel lblNewLabel_10 = new JLabel("包装方式");
		lblNewLabel_10.setBounds(63, 669, 81, 21);
		this.add(lblNewLabel_10);
		
		JLabel label_10 = new JLabel("运费");
		label_10.setBounds(63, 728, 44, 21);
		this.add(label_10);
		
		fee = new JTextField();
		fee.setEditable(false);
		fee.setBounds(132, 726, 109, 24);
		this.add(fee);
		fee.setColumns(10);
		
		JLabel label_11 = new JLabel("元");
		label_11.setBounds(251, 728, 27, 21);
		this.add(label_11);
		
		JLabel label_12 = new JLabel("预计到达天数");
		label_12.setBounds(367, 728, 118, 21);
		this.add(label_12);
		
		days = new JTextField();
		days.setEditable(false);
		days.setBounds(508, 726, 34, 24);
		this.add(days);
		days.setColumns(10);
		
		JLabel label_13 = new JLabel("天");
		label_13.setBounds(550, 728, 27, 21);
		this.add(label_13);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(27, 764, 959, 2);
		this.add(separator_1);
		
		JLabel label_14 = new JLabel("物流信息");
		label_14.setBounds(27, 781, 81, 21);
		this.add(label_14);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(SystemColor.control);
		textArea.setBorder(new LineBorder(new Color(0, 0, 0)));
		textArea.setEditable(false);
		textArea.setBounds(114, 829, 623, 138);
		this.add(textArea);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(37, 1001, 949, 2);
		this.add(separator_2);
		
		JLabel label_15 = new JLabel("收件信息");
		label_15.setBounds(41, 1018, 81, 21);
		this.add(label_15);
		
		JLabel label_16 = new JLabel("实际收件人");
		label_16.setBounds(88, 1065, 103, 21);
		this.add(label_16);
		
		actualreceiver = new JTextField();
		actualreceiver.setBackground(SystemColor.control);
		actualreceiver.setEditable(false);
		actualreceiver.setBounds(216, 1063, 96, 24);
		this.add(actualreceiver);
		actualreceiver.setColumns(10);
		
		JLabel label_17 = new JLabel("货物状态");
		label_17.setBounds(752, 781, 81, 21);
		this.add(label_17);
		
		state = new JTextField();
		state.setBackground(SystemColor.control);
		state.setEditable(false);
		state.setBounds(752, 824, 96, 27);
		this.add(state);
		state.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("收件时间");
		lblNewLabel_11.setBounds(492, 1065, 81, 21);
		this.add(lblNewLabel_11);
		
		receivetime = new JTextField();
		receivetime.setBackground(SystemColor.control);
		receivetime.setEditable(false);
		receivetime.setBounds(598, 1063, 184, 24);
		this.add(receivetime);
		receivetime.setColumns(10);
		
		final JRadioButton type1 = new JRadioButton("经济快递");
		type1.setBackground(Color.WHITE);
		type1.setBounds(182, 599, 118, 29);
		this.add(type1);
		
		final JRadioButton type2 = new JRadioButton("标准快递");
		type2.setBackground(Color.WHITE);
		type2.setBounds(376, 599, 109, 29);
		this.add(type2);
		
		final JRadioButton type3 = new JRadioButton("特快专递");
		type3.setBackground(Color.WHITE);
		type3.setBounds(556, 599, 123, 29);
		this.add(type3);
		
		ButtonGroup bg1=new ButtonGroup();
		bg1.add(type1);bg1.add(type2);bg1.add(type3);
		
		
		final JRadioButton pack1 = new JRadioButton("纸箱");
		pack1.setBackground(Color.WHITE);
		pack1.setBounds(183, 665, 95, 29);
		this.add(pack1);
		final JRadioButton pack2 = new JRadioButton("木箱");
		pack2.setBackground(Color.WHITE);
		pack2.setBounds(368, 665, 109, 29);
		this.add(pack2);
		final JRadioButton pack3 = new JRadioButton("快递袋");
		pack3.setBackground(Color.WHITE);
		pack3.setBounds(556, 665, 109, 29);
		this.add(pack3);
		final JRadioButton pack4 = new JRadioButton("其他");
		pack4.setBackground(Color.WHITE);
		pack4.setBounds(719, 665, 69, 29);
		this.add(pack4);
		
		ButtonGroup bg2=new ButtonGroup();
		bg2.add(pack1);bg2.add(pack2);bg2.add(pack3);bg2.add(pack4);
		
		JButton build = new JButton("确认生成");
		build.setBackground(Color.WHITE);
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
				CheckOrder co=new CheckOrder();
				if(co.IsTenNumbers(ID)==2){
					JOptionPane.showMessageDialog(null, "请输入10位数字的订单号！","失败!", JOptionPane.ERROR_MESSAGE);
					return ;
				}
				else{
						if( co.IsTenNumbers(ID)==1  ){
							JOptionPane.showMessageDialog(null, "请确保输入的10位订单号是纯数字！","失败!", JOptionPane.ERROR_MESSAGE);
							return;						
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
					orderID.setText("");
					sendername.setText("");
					senderphone.setText("");
					sendercompany.setText("");
					receivername.setText("");
					receiverphone.setText("");
					receivercompany.setText("");
					goodsname.setText("");
					goodsamount.setText("");
					goodweight.setText("");
					goodsV.setText("");
					fee.setText("");
					days.setText("");
					JOptionPane.showMessageDialog(null, "该订单已成功生成!", "成功!", JOptionPane.INFORMATION_MESSAGE);
				}
				else{
					JOptionPane.showMessageDialog(null, "该订单号已存在！请更换订单号 。","失败!", JOptionPane.ERROR_MESSAGE);
				}
			
				
				
			}
		});
		build.setBounds(795, 1114, 123, 29);
		this.add(build);
		
		
		
		JButton CalAndEst = new JButton("生成运费");
		CalAndEst.setBackground(Color.WHITE);
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
				
				
				CalFee cae=new CalFee();
				double Fee=cae.calculatefee(name1,name2,type, pack, weight, volume);
				EstDay ed=new EstDay();
				int Days=ed.Estimate(name1, name2);
				
				
				fee.setText(Double.toString(Fee));
				days.setText(Integer.toString(Days));
				
				
				
						
				
			}
		});
		CalAndEst.setBounds(795, 724, 123, 29);
		this.add(CalAndEst);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(27, 461, 967, 8);
		add(separator_3);
		

		
		
		

	}

	
	
	public void paintComponent(Graphics g){
	int x=0;int y=0;
	ImageIcon icon = new ImageIcon("inbg.jpg");
	g.drawImage(icon.getImage(), x, y, getSize().width,
		     getSize().height, this);
	
	}
}
