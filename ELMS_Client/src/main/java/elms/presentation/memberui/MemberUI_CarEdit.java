package elms.presentation.memberui;

import java.awt.Dimension;
import java.awt.HeadlessException;
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

public class MemberUI_CarEdit extends JFrame{
	CarVO voall;
	
	Toolkit kit=Toolkit.getDefaultToolkit();
	Dimension screenSize=kit.getScreenSize();
	int screenWidth=(int) screenSize.getWidth();
	int screenHeight=(int) screenSize.getHeight();
	boolean Edit;

	public CarVO getVO(){
		return voall;
	}
	
	public MemberUI_CarEdit(CarVO vo,boolean edit){
		voall=vo;
		setLayout(null);
		setResizable(false);
		setTitle("车辆信息  No： "+vo.getID());
		setBounds(screenWidth/4,screenHeight/4,screenWidth/3,3*screenHeight/8);
		setVisible(true);
		
		Edit=edit;
		
		final JPanel newin=new JPanel();
		newin.setLayout(null);
		add(newin);
		newin.setBounds(0, 0, this.getWidth(), 6*this.getHeight()/10);
		newin.setBorder(BorderFactory.createTitledBorder(""));
		
		
		JLabel carNum=new JLabel("车辆代号");
		//9位
		newin.add(carNum);
		carNum.setBounds(120,20,80,20);
		final JTextField cnf=new JTextField(vo.getID());
		newin.add(cnf);
		cnf.setBounds(220, 20, 100, 24);
		cnf.setEditable(Edit);
		cnf.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel plateNum=new JLabel("车牌号");
		newin.add(plateNum);
		plateNum.setBounds(120,60,80,20);
		final JTextField pnf=new JTextField(vo.getPlateNumber());
		newin.add(pnf);
		pnf.setBounds(220, 60, 100, 24);
		pnf.setEditable(Edit);
		pnf.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel usingTime=new JLabel("服役时间");
		newin.add(usingTime);
		usingTime.setBounds(120,100,80,20);
		final JTextField utf=new JTextField(vo.getUsingTime());
		newin.add(utf);
		utf.setBounds(220, 100, 100, 24);
		utf.setEditable(Edit);
		utf.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel buttonpanel=new JPanel();
		buttonpanel.setLayout(null);
		JButton cancle=new JButton("编辑(E)");
		buttonpanel.add(cancle);
		cancle.setBounds(this.getWidth()/2+90,25,100,30);
		add(buttonpanel);
		buttonpanel.setBounds(0,6*this.getHeight()/10,this.getWidth(),70);
		
		cancle.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				MemberUI_CarEdit.this.dispose();
				new MemberUI_CarEdit(getVO(),true);
			}
		});
		
		if(Edit){
			JButton save=new JButton("保存(S)");
			buttonpanel.add(save);
			save.setBounds(this.getWidth()/3-120,25,100,30);
			
			save.addActionListener(new ActionListener(){
				CarBL cardata=new CarBL();
				CarVO newvo;

				public void actionPerformed(ActionEvent e) {
					if(cnf.getText().equals(voall.getID())&&pnf.getText().equals(voall.getPlateNumber())&&utf.getText().equals(voall.getUsingTime())){
						JOptionPane.showMessageDialog(newin, "未发生改变");
						MemberUI_CarEdit.this.dispose();
						new MemberUI_CarEdit(voall,false);
					}else{
						try{
							if(cnf.getText().length()!=9){
								JOptionPane.showMessageDialog(newin,"修改信息格式错误");
							}
							MemberUI_CarEdit.this.dispose();
							cardata.delete(getVO());
							cardata.record(newvo);
							new MemberUI_CarEdit(newvo,false);
							
						}catch(HeadlessException e2){
							e2.printStackTrace();
						}
						catch(IOException e2){
							e2.printStackTrace();
						}				
					}
					
				}
				
			});
		}
		
		if(Edit){
			JButton back=new JButton("取消(C)");
			buttonpanel.add(back);
			back.setBounds(this.getWidth()/2-50,25,100,30);
			back.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					MemberUI_CarEdit.this.dispose();
					new MemberUI_CarEdit(getVO(),false);
				}
			});
			
		}
		else{
			JButton back=new JButton("删除(D)");
			buttonpanel.add(back);
			back.setBounds(this.getWidth()/2-50,25,100,30);
			back.addActionListener(new ActionListener(){
				CarBL cardata=new CarBL();

				public void actionPerformed(ActionEvent e) {
					try{
						cardata.delete(voall);
					}catch(IOException e1){
						e1.printStackTrace();
					}
					MemberUI_CarEdit.this.dispose();
					JOptionPane.showMessageDialog(null, voall.getID()+"已删除");
					
				}
				
			});
			
			
		}
	}
	
	

}
