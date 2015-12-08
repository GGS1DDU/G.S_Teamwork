package elms.presentation.memberui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import elms.businesslogic.memberbl.DriverBL;
import elms.vo.DriverVO;

public class MemberUI_DriverNew extends JFrame{
	Toolkit kit=Toolkit.getDefaultToolkit();
	Dimension screenSize=kit.getScreenSize();
	int screenWidth=(int) screenSize.getWidth();
	int screenHeight=(int) screenSize.getHeight();
	
//	public static void main(String args[]){
//		new MemberUI_DriverNew();
//	}
	
	public MemberUI_DriverNew(){
		setLayout(null);
		setResizable(false);
		setTitle("新增司机信息   ");
		setBounds(screenWidth/4,screenHeight/4,screenWidth/3,3*screenHeight/5);
		setVisible(true);
		
		final JPanel newin=new JPanel();
		newin.setLayout(null);
		add(newin);
		newin.setBounds(0, 0, this.getWidth(), 7*this.getHeight()/10);
		newin.setBorder(BorderFactory.createTitledBorder(""));
		
		
		JLabel driverNum=new JLabel("司机编号");
		newin.add(driverNum);
		driverNum.setBounds(120,20,80,20);
		final JTextField dnf=new JTextField();
		dnf.setFont(new Font("SanSerif",Font.PLAIN,12));
		newin.add(dnf);
		dnf.setBounds(220, 20, 100, 24);
		dnf.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel name=new JLabel("姓名");
		newin.add(name);
		name.setBounds(120,60,80,20);
		final JTextField nf=new JTextField();
		nf.setFont(new Font("SanSerif",Font.PLAIN,12));
		newin.add(nf);
		nf.setBounds(220, 60, 100, 24);
		nf.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel birthday=new JLabel("出生日期");
		//yyyy-MM-dd
		newin.add(birthday);
		birthday.setBounds(120,100,80,20);
		final JTextField bf=new JTextField();
		bf.setFont(new Font("SanSerif",Font.PLAIN,12));
		newin.add(bf);
		bf.setBounds(220, 100, 100, 24);
		bf.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel IDCardNum=new JLabel("身份证号");
		newin.add(IDCardNum);
		IDCardNum.setBounds(120,140,80,20);
		final JTextField icf=new JTextField();
		icf.setFont(new Font("SanSerif",Font.PLAIN,12));
		newin.add(icf);
		icf.setBounds(220, 140, 100, 24);
		icf.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel phoneNum=new JLabel("手机号");
		newin.add(phoneNum);
		phoneNum.setBounds(120,180,80,20);
		final JTextField pnf=new JTextField();
		pnf.setFont(new Font("SanSerif",Font.PLAIN,12));
		newin.add(pnf);
		pnf.setBounds(220, 180, 100, 24);
		pnf.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel gender=new JLabel("性别");
		newin.add(gender);
		gender.setBounds(120, 220, 80, 20);
		final JComboBox<String> jcb=new JComboBox<String>();
		jcb.addItem("男");
		jcb.addItem("女");
		jcb.setBackground(Color.WHITE);
		jcb.setFont(new Font("SanSerif",Font.CENTER_BASELINE,12));
		newin.add(jcb);
		jcb.setBounds(220, 220, 100, 24);
		
		
		JLabel liscenseDate=new JLabel("行驶证期限");
		//yyyy-MM-dd
		newin.add(liscenseDate);
		liscenseDate.setBounds(120,260,80,20);
		final JTextField ldf=new JTextField();
		ldf.setFont(new Font("SanSerif",Font.PLAIN,12));
		newin.add(ldf);
		ldf.setBounds(220, 260, 100, 24);
		ldf.setHorizontalAlignment(SwingConstants.CENTER);
				
		JPanel buttonpanel=new JPanel();
		buttonpanel.setLayout(null);
		JButton save=new JButton("保存(S)");
		JButton cancel=new JButton("取消(C)");
		buttonpanel.add(save);
		buttonpanel.add(cancel);
		save.setBounds(this.getWidth()/2-140,25,100,30);
		cancel.setBounds(this.getWidth()/2+30, 25, 100, 30);
		add(buttonpanel);
		buttonpanel.setBounds(0, 7*this.getHeight()/10,this.getWidth(),70);
		
		save.addActionListener(new ActionListener(){
			DriverBL driverdata=new DriverBL();
	
			public void actionPerformed(ActionEvent arg0){
				try{				
					if(!bf.getText().matches("\\d{4}-\\d{1,2}-\\d{1,2}")||!ldf.getText().matches("\\d{4}-\\d{1,2}-\\d{1,2}")||dnf.getText().length()!=9
							||icf.getText().length()!=18||pnf.getText().length()!=11||jcb.getSelectedItem()==null)				
						JOptionPane.showMessageDialog(null, "司机信息格式错误");				
					else{				
						DriverVO vo=new DriverVO(dnf.getText(),nf.getText(),bf.getText(),icf.getText(),pnf.getText(),jcb.getSelectedItem().toString(),ldf.getText());		
						JOptionPane.showMessageDialog(newin, "保存至司机信息");
						driverdata.record(vo);
						MemberUI_DriverNew.this.dispose();
						
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
