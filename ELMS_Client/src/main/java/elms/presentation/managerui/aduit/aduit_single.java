package elms.presentation.managerui.aduit;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class aduit_single extends JFrame {
	Toolkit kit=Toolkit.getDefaultToolkit();
	Dimension screenSize=kit.getScreenSize();
	int screenWidth=(int) screenSize.getWidth();
	int screenHeight=(int)screenSize.getHeight();
public aduit_single(){
	setLayout(null);
	setTitle("单项审批");
	setResizable(false);
	setBounds(screenWidth/4,screenHeight/4,screenWidth/4, screenHeight/4);
	setVisible(true);

	
	final JTextField idf=new JTextField();
	JLabel ID=new JLabel("Order-ID");
	add(ID);
	ID.setBounds(60, 40, 100, 30);
	add(idf);
	idf.setBounds(this.getWidth()/2-14,40,150,28);
	JButton ok=new JButton("查询");
	JButton cancle=new JButton("取消");
	add(ok);ok.setBounds(this.getWidth()/2-120,3*this.getHeight()/5+10,70,25);
	add(cancle);cancle.setBounds(this.getWidth()/2+40,3*this.getHeight()/5+10,70,25);
}
}
