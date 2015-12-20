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

public class aduit_storagelist extends JFrame{
	Toolkit kit=Toolkit.getDefaultToolkit();
	Dimension screenSize=kit.getScreenSize();
	int screenWidth=(int) screenSize.getWidth();
	int screenHeight=(int)screenSize.getHeight();
public static void main(String args[]){
	new aduit_storagelist();
}
public aduit_storagelist(){
	setLayout(null);
	setResizable(false);
	setTitle("库存变化单");
	setBounds(screenWidth/4,screenHeight/4, screenWidth/3, 3*screenHeight/8);
	setVisible(true); 
	JPanel inf=new JPanel();inf.setLayout(null);
	add(inf);inf.setBounds(0,0,this.getWidth(),210);
	inf.setBorder(BorderFactory.createTitledBorder(""));
	
	JLabel id=new JLabel("ID");
	inf.add(id);id.setBounds(20,20,20,20);
	final JTextField idf=new JTextField();idf.setFont(new Font("SansSerif",Font.PLAIN,12));
	inf.add(idf);idf.setBounds(90,20,100,24);idf.setHorizontalAlignment(SwingConstants.CENTER);
	
	JLabel area=new JLabel("分区");
	inf.add(area);area.setBounds(this.getWidth()/2,20,100,20);
	final JTextField jc=new JTextField();jc.setFont(new Font("SansSerif",Font.PLAIN,12));
	inf.add(jc);jc.setBounds(this.getWidth()/2+80, 20, 120, 24);
	
	JLabel sn=new JLabel("位置");
	inf.add(sn);sn.setBounds(20,60,80,20);
	final JTextField snf=new JTextField();snf.setFont(new Font("SansSerif",Font.PLAIN,12));
	inf.add(snf);snf.setBounds(90,60,100,24);snf.setHorizontalAlignment(SwingConstants.CENTER);
	
	JLabel tn=new JLabel("订单编号");
	inf.add(tn);tn.setBounds(this.getWidth()/2,60,100,20);
	final JTextField tnc=new JTextField();tnc.setFont(new Font("SansSerif",Font.PLAIN,12));
	inf.add(tnc);tnc.setBounds(this.getWidth()/2+80, 60, 120, 24);
	
	JLabel ar=new JLabel("入库时间");
	inf.add(ar);ar.setBounds(20,100,80,20);
	final JTextField arf=new JTextField();arf.setFont(new Font("SansSerif",Font.PLAIN,12));
	inf.add(arf);arf.setBounds(90,100,100,24);arf.setHorizontalAlignment(SwingConstants.CENTER);
	
	JLabel cn=new JLabel("出库时间");
	inf.add(cn);cn.setBounds(this.getWidth()/2,100,100,20);
	final JTextField cnc=new JTextField();cnc.setFont(new Font("SansSerif",Font.PLAIN,12));
	inf.add(cnc);cnc.setBounds(this.getWidth()/2+80, 100, 120, 24);
	
	JLabel surpervisor=new JLabel("状态");
	inf.add(surpervisor);surpervisor.setBounds(20,140,80,20);
	final JTextField surpervisorf=new JTextField();surpervisorf.setFont(new Font("SansSerif",Font.PLAIN,12));
	inf.add(surpervisorf);surpervisorf.setBounds(90,140,100,24);surpervisorf.setHorizontalAlignment(SwingConstants.CENTER);
	
	JLabel supercargo=new JLabel("中转中心");
	inf.add(supercargo);supercargo.setBounds(this.getWidth()/2,140,100,20);
	final JTextField supercargoc=new JTextField();supercargoc.setFont(new Font("SansSerif",Font.PLAIN,12));
	inf.add(supercargoc);supercargoc.setBounds(this.getWidth()/2+80, 140, 120, 24);
	
	
	JButton tg=new JButton("通过");add(tg);tg.setBounds(50,220,80,30);
	JButton refuse=new JButton("未通过");add(refuse);refuse.setBounds(180,220,80,30);
	JButton cancel=new JButton("取消");add(cancel);cancel.setBounds(310,220,80,30);
}
}
