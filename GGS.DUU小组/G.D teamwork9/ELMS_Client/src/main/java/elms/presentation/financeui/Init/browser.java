package elms.presentation.financeui.Init;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import elms.vo.AccountVO;

public class browser  extends JFrame {
	Toolkit kit=Toolkit.getDefaultToolkit();
	Dimension screenSize=kit.getScreenSize();
	int screenWidth=(int) screenSize.getWidth();
	int screenHeight=(int)screenSize.getHeight();
	static ArrayList<AccountVO> arr=new ArrayList<AccountVO>();
	public static void main(String args[]){
	new browser(arr);
}
	public browser(ArrayList<AccountVO> arr){
		setLayout(null);
		setTitle("历史账目");
		setResizable(false);
		setBounds(screenWidth/4,screenHeight/4, screenWidth/3, 2*screenHeight/8);
		setVisible(true);
		JMenuBar jbar=new JMenuBar(); 
		JMenu j1=new JMenu("账目名                                               ");
		JMenu j2=new JMenu("操作人员");
		JMenu j3=new JMenu("操作时间                                  ");jbar.add(j1);jbar.add(j3);jbar.add(j2);
		add(jbar);jbar.setBounds(0,0,this.getWidth(),20);jbar.setFont(new Font("Serif",Font.PLAIN,14));
		JTextArea text=new JTextArea(10,10);
		text.setEditable(false);
		text.setFont(new Font("Serif",Font.PLAIN,14));
		for(AccountVO vo:arr)
		text.append(vo.getName()+"                           "+vo.getDate()+"                         "+vo.getOperator()+"\n");
		
		JScrollPane scrollpane=new JScrollPane(text);
		add(scrollpane);
		scrollpane.setBounds(2,22,this.getWidth()-8,this.getHeight()/2);
		
		JButton back=new JButton("返回");
		add(back);back.setBounds(170,130,100,25);
		back.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
			setVisible(false);
			}
			
		});
	}

}
