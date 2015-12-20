package elms.presentation.memberui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import elms.businesslogic.memberbl.CarBL;
import elms.vo.CarVO;

public class MemberUI_CarFind extends JFrame{
	Toolkit kit=Toolkit.getDefaultToolkit();
	Dimension screenSize=kit.getScreenSize();
	int screenWidth=(int) screenSize.getWidth();
	int screenHeight=(int) screenSize.getHeight();
	
	public MemberUI_CarFind(){
		setLayout(null);
		setTitle("查询");
		setResizable(false);
		setBounds(screenWidth/4,screenHeight/4,screenWidth/4,screenHeight/4);
		setVisible(true);
		
		final JTextField idf=new JTextField();
		JLabel ID=new JLabel("车辆代号");
		add(ID);
		ID.setBounds(60,40,100,30);
		add(idf);
		idf.setBounds(this.getWidth()/2-14,40,150,28);
		JButton ok=new JButton("查询");
		JButton cancle=new JButton("取消");
		add(ok);ok.setBounds(this.getWidth()/2-120,3*this.getHeight()/5+10,70,25);
		add(cancle);cancle.setBounds(this.getWidth()/2+40,3*this.getHeight()/5+10,70,25);
		
		ok.addActionListener(new ActionListener(){
			CarBL cardata=new CarBL();
		
			public void actionPerformed(ActionEvent e) {
				try{
					CarVO vo=cardata.inquiry(idf.getText());
					if(vo!=null){
					 	setVisible(false);
						new MemberUI_CarEdit(vo,false);
					}else{
						JOptionPane.showMessageDialog(null, "车辆代号："+idf.getText()+"未找到");
					}
				}catch(IOException e1){
					e1.printStackTrace();
				}		
			}		
		});
		cancle.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}		
		});	
		
	}

}
