package elms.presentation.memberui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
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

public class MemberUI_DriverEdit extends JFrame{
	DriverVO voall;

	Toolkit kit=Toolkit.getDefaultToolkit();
	Dimension screenSize=kit.getScreenSize();
	int screenWidth=(int) screenSize.getWidth();
	int screenHeight=(int) screenSize.getHeight();
	boolean Edit;
	
	public DriverVO getVO(){
		return voall;
	}

	public MemberUI_DriverEdit(DriverVO vo, boolean edit) {
		voall=vo;
		setLayout(null);
		setResizable(false);
		setTitle("司机信息  No: "+vo.getID());
		setBounds(screenWidth/4,screenHeight/4,screenWidth/3,3*screenHeight/5);
		setVisible(true);
		
		Edit=edit;
		
		final JPanel newin=new JPanel();
		newin.setLayout(null);
		add(newin);
		newin.setBounds(0, 0, this.getWidth(), 7*this.getHeight()/10);
		newin.setBorder(BorderFactory.createTitledBorder(""));
		
		
		JLabel driverNum=new JLabel("司机编号");
		newin.add(driverNum);
		driverNum.setBounds(120,20,80,20);
		final JTextField dnf=new JTextField(vo.getID());
		newin.add(dnf);
		dnf.setBounds(220, 20, 100, 24);
		dnf.setEditable(Edit);
		dnf.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel name=new JLabel("姓名");
		newin.add(name);
		name.setBounds(120,60,80,20);
		final JTextField nf=new JTextField(vo.getName());
		newin.add(nf);
		nf.setBounds(220, 60, 100, 24);
		nf.setEditable(Edit);
		nf.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel birthday=new JLabel("出生日期");
		//yyyy-MM-dd
		newin.add(birthday);
		birthday.setBounds(120,100,80,20);
		final JTextField bf=new JTextField(vo.getBirthday());
		newin.add(bf);
		bf.setBounds(220, 100, 100, 24);
		bf.setEditable(Edit);
		bf.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel IDCardNum=new JLabel("身份证号");
		newin.add(IDCardNum);
		IDCardNum.setBounds(120,140,80,20);
		final JTextField icf=new JTextField(vo.getIDcard());
		newin.add(icf);
		icf.setBounds(220, 140, 100, 24);
		icf.setEditable(Edit);
		icf.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel phoneNum=new JLabel("手机号");
		newin.add(phoneNum);
		phoneNum.setBounds(120,180,80,20);
		final JTextField pnf=new JTextField(vo.getCallNumber());
		newin.add(pnf);
		pnf.setBounds(220, 180, 100, 24);
		pnf.setEditable(Edit);
		pnf.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel gender=new JLabel("性别");
		newin.add(gender);
		gender.setBounds(120, 220, 80, 20);
		final JComboBox<String> jcb=new JComboBox<String>();
		if(Edit){
			jcb.addItem("男");
			jcb.addItem("女");
			jcb.setBackground(Color.WHITE);
			jcb.setFont(new Font("SanSerif",Font.CENTER_BASELINE,12));
			newin.add(jcb);jcb.setBounds(220, 100, 100, 24);
			jcb.setSelectedItem(vo.getGender());			
		}else{
			JLabel gf=new JLabel(vo.getGender());
			gf.setFont(new Font("SanSerif",Font.CENTER_BASELINE,12));
			gf.setOpaque(false);
			newin.add(gf);
			gf.setBounds(220,100,100,24);
			gf.setHorizontalAlignment(SwingConstants.CENTER);
			gf.setEnabled(false);
		}
			
		JLabel liscenseDate=new JLabel("行驶证期限");
		//yyyy-MM-dd
		newin.add(liscenseDate);
		liscenseDate.setBounds(120,260,80,20);
		final JTextField ldf=new JTextField();
		ldf.setFont(new Font("SanSerif",Font.PLAIN,12));
		newin.add(ldf);
		ldf.setBounds(220, 260, 100, 24);
		ldf.setEditable(Edit);
		ldf.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel buttonpanel=new JPanel();
		buttonpanel.setLayout(null);
		JButton cancle=new JButton("编辑(E)");
		buttonpanel.add(cancle);
		cancle.setBounds(this.getWidth()/2+90,25,100,30);
		add(buttonpanel);
		buttonpanel.setBounds(0,7*this.getHeight()/10,this.getWidth(),70);
		
		cancle.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				MemberUI_DriverEdit.this.dispose();
				new MemberUI_DriverEdit(getVO(),true);
			}
		});
		
		if(Edit){
			JButton save=new JButton("保存(S)");
			buttonpanel.add(save);
			save.setBounds(this.getWidth()/3-120,25,100,30);
			
			save.addActionListener(new ActionListener(){
				DriverBL driverdata=new DriverBL();
				DriverVO newvo;

				public void actionPerformed(ActionEvent e) {
					if(dnf.getText().equals(voall.getID())&&nf.getText().equals(voall.getName())&&
							bf.getText().equals(voall.getBirthday())&&icf.getText().equals(voall.getIDcard())&&
							pnf.getText().equals(voall.getCallNumber())&&jcb.getSelectedItem().toString().equals(voall.getGender())
							&&ldf.getText().equals(voall.getLicenseDate())){
						JOptionPane.showMessageDialog(newin, "未发生改变");
						MemberUI_DriverEdit.this.dispose();
						new MemberUI_DriverEdit(voall,false);
					}else{
						try{
							if(!bf.getText().matches("\\d{4}-\\d{1,2}-\\d{1,2}")||!ldf.getText().matches("\\d{4}-\\d{1,2}-\\d{1,2}")||dnf.getText().length()!=9
									||icf.getText().length()!=18||pnf.getText().length()!=11||jcb.getSelectedItem()==null){
								JOptionPane.showMessageDialog(newin,"修改信息格式错误");
							}
							MemberUI_DriverEdit.this.dispose();
							driverdata.delete(getVO());
							driverdata.record(newvo);
							new MemberUI_DriverEdit(newvo,false);
							
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
					MemberUI_DriverEdit.this.dispose();
					new MemberUI_DriverEdit(getVO(),false);
				}
			});
			
		}
		else{
			JButton back=new JButton("删除(D)");
			buttonpanel.add(back);
			back.setBounds(this.getWidth()/2-50,25,100,30);
			back.addActionListener(new ActionListener(){
				DriverBL driverdata=new DriverBL();

				public void actionPerformed(ActionEvent e) {
					try{
						driverdata.delete(voall);
					}catch(IOException e1){
						e1.printStackTrace();
					}
					MemberUI_DriverEdit.this.dispose();
					JOptionPane.showMessageDialog(null, voall.getID()+"已删除");
					
				}
				
			});
			
			
		}
	}

}
