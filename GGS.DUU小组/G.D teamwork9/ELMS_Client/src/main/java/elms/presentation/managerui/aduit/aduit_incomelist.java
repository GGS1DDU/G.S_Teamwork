package elms.presentation.managerui.aduit;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class aduit_incomelist extends JFrame{
	Toolkit kit=Toolkit.getDefaultToolkit();
	Dimension screenSize=kit.getScreenSize();
	int screenWidth=(int) screenSize.getWidth();
	int screenHeight=(int)screenSize.getHeight();
	public static void main(String[] args) {
		new aduit_incomelist();
	}	// TODO Auto-generated method stub

	public aduit_incomelist(){
		setLayout(null);
		setResizable(false);
		setTitle("营业厅收入单");
		setBounds(screenWidth/4,screenHeight/4, screenWidth/3, 3*screenHeight/8);
		setVisible(true); 
		
		JPanel inf=new JPanel();inf.setLayout(null);
		add(inf);inf.setBounds(0,0,this.getWidth(),200);
		inf.setBorder(BorderFactory.createTitledBorder(""));
		
		JLabel id=new JLabel("ID");
		inf.add(id);id.setBounds(20,20,20,20);
		final JTextField idf=new JTextField();idf.setFont(new Font("SansSerif",Font.PLAIN,12));
		inf.add(idf);idf.setBounds(90,20,100,24);idf.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel area=new JLabel("收费金额");
		inf.add(area);area.setBounds(this.getWidth()/2,20,100,20);
		final JTextField jc=new JTextField();jc.setFont(new Font("SansSerif",Font.PLAIN,12));
		inf.add(jc);jc.setBounds(this.getWidth()/2+80, 20, 100, 24);
		
		JLabel seat=new JLabel("收款日期");
		inf.add(seat);seat.setBounds(90,80,100,20);
		final JTextField sef=new JTextField();sef.setFont(new Font("SansSerif",Font.PLAIN,12));
		inf.add(sef);sef.setBounds(210,80,140,24);sef.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel courier=new JLabel("快递员姓名");
		inf.add(courier);courier.setBounds(20,140,70,20);
		final JTextField cf=new JTextField();cf.setFont(new Font("SansSerif",Font.PLAIN,12));
		inf.add(cf);cf.setBounds(90,140,100,24);cf.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel orderID=new JLabel("订单条形码");
		inf.add(orderID);orderID.setBounds(this.getWidth()/2,140,100,20);
		JComboBox<String> jcb=new JComboBox<String>();jcb.setFont(new Font("楷体",Font.CENTER_BASELINE,12));
		inf.add(jcb);jcb.setBounds(this.getWidth()/2+80, 140, 100, 24);jcb.setBackground(Color.white);

		JButton tg=new JButton("通过");add(tg);tg.setBounds(50,210,80,30);
		JButton refuse=new JButton("未通过");add(refuse);refuse.setBounds(180,210,80,30);
		JButton cancel=new JButton("取消");add(cancel);cancel.setBounds(310,210,80,30);
	}

}
