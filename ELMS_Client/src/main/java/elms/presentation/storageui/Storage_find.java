package elms.presentation.storageui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import elms.presentation.MyPanel;

public class Storage_find extends JFrame {
	Toolkit kit=Toolkit.getDefaultToolkit();
	Dimension screenSize=kit.getScreenSize();
	int screenWidth=(int) screenSize.getWidth();
	int screenHeight=(int)screenSize.getHeight();


public Storage_find(){
	setLayout(null);
	setResizable(false);
	setTitle("查询");
	setBounds(screenWidth/4,screenHeight/4, screenWidth/3, 3*screenHeight/8);
	setVisible(true); 
	MyPanel p=new MyPanel("bg3.png");
	add(p);p.setBounds(0, 0, (int) (1.2*this.getWidth()), this.getHeight());
	
	JButton j1=new JButton("单项查询");
	JButton j2=new JButton("分时查询");
	JButton j3=new JButton("当前查询");
	p.add(j1);p.add(j2);p.add(j3);
	j1.setBounds(this.getWidth()/3, this.getHeight()/8,140 , 30);
	j2.setBounds(this.getWidth()/3, this.getHeight()/8+this.getHeight()/4,140 , 30);
	j3.setBounds(this.getWidth()/3, this.getHeight()/8+this.getHeight()/2,140 , 30);
    j1.addActionListener(new ActionListener(){

		public void actionPerformed(ActionEvent arg0) {
			Storage_find.this.dispose();new Storage_findsingle();
			
		}
    	
    });
    j2.addActionListener(new ActionListener(){

  		public void actionPerformed(ActionEvent e) {
  				Storage_find.this.dispose();new Storage_findtime();
  		
  		}
      	
      });
    j3.addActionListener(new ActionListener(){

  		public void actionPerformed(ActionEvent e) {
  			Storage_find.this.dispose();	new Storage_findcenter();
  		
  		}
      	
      });
}

}
