package elms.presentation.dealui;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import elms.businesslogic.dealbl.CalFee;
import elms.businesslogic.dealbl.CheckOrder;
import elms.businesslogic.dealbl.DealBL;
import elms.businesslogic.dealbl.EstDay;
import elms.vo.DealVO;
import elms.vo.UserVO;

import java.awt.Dimension;
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
	static Toolkit kit=Toolkit.getDefaultToolkit();
	static Dimension screenSize=kit.getScreenSize();
	static int screenWidth=(int) screenSize.getWidth();
	static int screenHeight=(int)screenSize.getHeight();
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
	
	public static void main(String args[]){
		JFrame f=new JFrame();
		f.setLayout(null);
		f.setResizable(false);
		f.setVisible(true);
		f.setDefaultCloseOperation(3);
		f.setBounds(screenWidth/6,screenHeight/8,screenWidth*2/3,screenHeight*3/4);
		UserVO vo=new UserVO();
		DealUI_BuildAnOrder s=new DealUI_BuildAnOrder(vo);

	JScrollPane js=new JScrollPane(s);
		f.add(js);js.setBounds(200, 40,screenWidth*2/3 -200, screenHeight*3/4-80);
	s.setPreferredSize(new Dimension(screenWidth*2/3-220,1120));
	 js.setOpaque(false);js.getViewport().setOpaque(false);
	js.getVerticalScrollBar().setUnitIncrement(20);
	
	}
	public DealUI_BuildAnOrder(UserVO vo) {
		this.vo=vo;
		setLayout(null);
		setOpaque(false);
		setVisible(true);
		
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
		couriername.setText(vo.getName());
		couriername.setEditable(false);
		couriername.setBounds(100, 60, 100, 25);
		add(couriername);
		
		JLabel label_2 = new JLabel("生成时间");
		label_2.setBounds(300, 25, 80, 25);
		add(label_2);
		
		dealtime = new JTextField();
		dealtime.setEditable(false);
		Date dt=new Date();
		SimpleDateFormat matter=new SimpleDateFormat("yyyy-MM-dd");
		dealtime.setText(matter.format(dt));
		dealtime.setBounds(screenWidth/4+50, 25, 100, 25);
		add(dealtime);
		
		JLabel lblNewLabel = new JLabel("所属营业厅");
		lblNewLabel.setBounds(300, 60, 100, 25);
		add(lblNewLabel);
		
		final JComboBox hall = new JComboBox();
		hall.setModel(new DefaultComboBoxModel(new String[] {"南京市鼓楼营业厅", "南京市仙林营业厅"}));
		hall.setOpaque(false);hall.setBackground(Color.white);
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
		
		final JComboBox sendercity = new JComboBox();
		sendercity.setBackground(Color.WHITE);
		sendercity.setModel(new DefaultComboBoxModel(new String[] {"北京", "上海", "广州", "南京"}));
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
		
		final JComboBox receivercity = new JComboBox();
		receivercity.setBackground(Color.WHITE);
		receivercity.setModel(new DefaultComboBoxModel(new String[] {"北京", "上海", "广州", "南京"}));
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
		
		final JRadioButton type1 = new JRadioButton("经济快递");
		type1.setBackground(Color.WHITE);
		type1.setBounds(100, 470, 100, 29);
		this.add(type1);
		
		final JRadioButton type2 = new JRadioButton("标准快递");
		type2.setBackground(Color.WHITE);
		type2.setBounds(260, 470, 100, 29);
		this.add(type2);
		
		final JRadioButton type3 = new JRadioButton("特快专递");
		type3.setBackground(Color.WHITE);
		type3.setBounds(420, 470, 100, 29);
		this.add(type3);
		
		ButtonGroup bg1=new ButtonGroup();
		bg1.add(type1);bg1.add(type2);bg1.add(type3);
		
		
		final JRadioButton pack1 = new JRadioButton("纸箱");
		pack1.setBackground(Color.WHITE);
		pack1.setBounds(100, 535, 100, 29);
		this.add(pack1);
		final JRadioButton pack2 = new JRadioButton("木箱");
		pack2.setBackground(Color.WHITE);
		pack2.setBounds(260, 535, 100, 29);
		this.add(pack2);
		final JRadioButton pack3 = new JRadioButton("快递袋");
		pack3.setBackground(Color.WHITE);
		pack3.setBounds(420, 535, 100, 29);
		this.add(pack3);
		final JRadioButton pack4 = new JRadioButton("其他");
		pack4.setBackground(Color.WHITE);
		pack4.setBounds(580, 535, 100, 29);
		this.add(pack4);
		
		ButtonGroup bg2=new ButtonGroup();
		bg2.add(pack1);bg2.add(pack2);bg2.add(pack3);bg2.add(pack4);
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
		build.setBounds(470, 1050, 125, 30);
		this.add(build);
		
		JButton CalAndEst = new JButton("生成运费");
		CalAndEst.setBackground(Color.WHITE);
		CalAndEst.addMouseListener(new MouseAdapter() {
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
		CalAndEst.setBounds(450, 600, 125, 30);
		this.add(CalAndEst);
		
	
		
	}


}
