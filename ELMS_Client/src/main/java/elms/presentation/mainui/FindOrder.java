package elms.presentation.mainui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import elms.businesslogic.dealbl.DealBL;
import elms.presentation.MyButton;
import elms.presentation.MyFrame;
import elms.presentation.MyLabel;
import elms.presentation.MyPanel;
import elms.presentation.dealui.DealUI_trackMessage;
import elms.presentation.uihelper.ScreenSize;
import elms.vo.DealVO;

public class FindOrder extends JFrame {

	private int screenWidth = ScreenSize.screenWidth;
	private int screenHeight = ScreenSize.screenHeight;
	private JPanel contentPane;
	private JPanel tipPanel;
	private JLabel label;
	private JLabel tips;
	private JTextField orderID;
	private JButton inquiry;
	
	private Font f = new Font("微软雅黑",1,15);
	
	public static void main(String[] args){
		JFrame jf = new FindOrder();
		jf.setVisible(true);
	}

	public FindOrder() {
//		super("star.jpg");
		setTitle("查询物流信息");
		setBounds(screenWidth / 3, screenHeight / 3-50, screenWidth / 3,
				screenHeight / 3+100);
		setLayout(null);

		contentPane = new MyPanel("star.jpg");
		add(contentPane);
		contentPane.setBounds(0, 0, this.getWidth(), this.getHeight());
		contentPane.setLayout(null);

		label = new JLabel("快递单号:");
		label.setForeground(Color.white);
		label.setFont(f);
		label.setBounds(this.getWidth() / 6, this.getHeight() / 6, 80, 30);
		contentPane.add(label);

		orderID = new JTextField();
		orderID.setBounds(label.getX() + label.getWidth(), label.getY(), 200,
				30);
		contentPane.add(orderID);
		orderID.setColumns(10);

//		tipPanel = new MyPanel("bg.jpg", 0.2f);
//		tipPanel.setOpaque(false);
//		tipPanel.setBackground(Color.white);
//		contentPane.add(tipPanel);
//		tipPanel.setBounds(label.getX() - 40,
//				orderID.getY() + orderID.getHeight() + 30, orderID.getWidth()
//						+ label.getWidth() + 100, 100);
		
		tips = new MyLabel("注意：快递单号为十位数字",0.2f);
		tips.setFocusable(false);
		tips.setBounds(label.getX() - 40,
				orderID.getY() + orderID.getHeight() + 30, orderID.getWidth()
						+ label.getWidth() + 100, 100);
		contentPane.add(tips);
		tips.setHorizontalAlignment(SwingConstants.CENTER);
		
		tips.setText("注意：快递单号为十位数字");
		tips.setFont(f);
//		tips.setOpaque(true);
		tips.setForeground(Color.WHITE);
		
		inquiry = new MyButton("查询",15);
//		inquiry.setFont(f);
		inquiry.setBounds(this.getWidth()/3+30,tips.getY()+tips.getHeight()+10,80,30);
		contentPane.add(inquiry);
		
		
		inquiry.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
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
					DealUI_trackMessage dt=new DealUI_trackMessage(dealvo);
					dt.setVisible(true);					
				}
				
				
			}
			

		});
	}
}
