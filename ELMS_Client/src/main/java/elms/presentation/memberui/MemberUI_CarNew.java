package elms.presentation.memberui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import elms.businesslogic.memberbl.CarBL;
import elms.vo.CarVO;

public class MemberUI_CarNew extends JFrame{
	Toolkit kit=Toolkit.getDefaultToolkit();
	Dimension screenSize=kit.getScreenSize();
	int screenWidth=(int) screenSize.getWidth();
	int screenHeight=(int) screenSize.getHeight();
	
//	public static void main(String args[]){
//		new MemberUI_CarNew();
//	}
	
	public MemberUI_CarNew(){
		setLayout(null);
		setResizable(false);
		setTitle("新增车辆信息   ");
		setBounds(screenWidth/4,screenHeight/4,screenWidth/3,3*screenHeight/8);
		setVisible(true);
		
		final JPanel newin=new JPanel();
		newin.setLayout(null);
		add(newin);
		newin.setBounds(0, 0, this.getWidth(), 6*this.getHeight()/10);
		newin.setBorder(BorderFactory.createTitledBorder(""));
		
		
		JLabel carNum=new JLabel("车辆代号");
		//9位
		newin.add(carNum);
		carNum.setBounds(120,20,80,20);
		final JTextField cnf=new JTextField();
		cnf.setFont(new Font("SanSerif",Font.PLAIN,12));
		newin.add(cnf);
		cnf.setBounds(220, 20, 100, 24);
		cnf.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel plateNum=new JLabel("车牌号");
		newin.add(plateNum);
		plateNum.setBounds(120,60,80,20);
		final JTextField pnf=new JTextField();
		pnf.setFont(new Font("SanSerif",Font.PLAIN,12));
		newin.add(pnf);
		pnf.setBounds(220, 60, 100, 24);
		pnf.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel usingTime=new JLabel("服役时间");
		newin.add(usingTime);
		usingTime.setBounds(120,100,80,20);
		final JTextField utf=new JTextField();
		utf.setFont(new Font("SanSerif",Font.PLAIN,12));
		newin.add(utf);
		utf.setBounds(220, 100, 100, 24);
		utf.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel buttonpanel=new JPanel();
		buttonpanel.setLayout(null);
		JButton save=new JButton("保存(S)");
		JButton cancel=new JButton("取消(C)");
		buttonpanel.add(save);
		buttonpanel.add(cancel);
		save.setBounds(this.getWidth()/2-140,5,100,30);
		cancel.setBounds(this.getWidth()/2+30, 5, 100, 30);
		add(buttonpanel);
		buttonpanel.setBounds(0, 7*this.getHeight()/10,this.getWidth(),70);
		
		save.addActionListener(new ActionListener(){
			CarBL cardata=new CarBL();
	
			public void actionPerformed(ActionEvent arg0){
				try{				
					if(cnf.getText().length()!=9)				
						JOptionPane.showMessageDialog(null, "车辆信息格式错误");				
					else{				
						CarVO vo=new CarVO(cnf.getText(),pnf.getText(),utf.getText());		
						JOptionPane.showMessageDialog(newin, "保存至车辆信息");
						cardata.record(vo);
						MemberUI_CarNew.this.dispose();
						
					}
		
				}catch(IOException e){
					e.printStackTrace();
				}
			}
			
		});
		cancel.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0){
				setVisible(false);
			}
		});
		
	}

}
