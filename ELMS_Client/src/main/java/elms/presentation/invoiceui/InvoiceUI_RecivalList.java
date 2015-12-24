package elms.presentation.invoiceui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import elms.businesslogic.invoicebl.ArrivalListBL;
import elms.businesslogic.invoicebl.RecivalListBL;
import elms.vo.ArrivalListVO;
import elms.vo.RecivalListVO;
import elms.vo.UserVO;

public class InvoiceUI_RecivalList extends JFrame{
	Toolkit kit=Toolkit.getDefaultToolkit();
	Dimension screenSize=kit.getScreenSize();
	int screenWidth=(int) screenSize.getWidth();
	int screenHeight=(int) screenSize.getHeight();
	
//	public static void main(String args[]){
//		new InvoiceUI_RecivalList();
//	}
	
	public InvoiceUI_RecivalList(final UserVO vo){
		setLayout(null);
		setResizable(false);
		setTitle("新建中转中心接收单   ");
		setBounds(screenWidth/4,screenHeight/4,screenWidth/3,screenHeight/2+40);
		setVisible(true);
		
		final JPanel newin=new JPanel();
		newin.setLayout(null);
		add(newin);
		newin.setBounds(0, 0, this.getWidth(), 7*this.getHeight()/10);
		newin.setBorder(BorderFactory.createTitledBorder(""));
		

		JLabel invoiceNum=new JLabel("单据ID");
		//前两位rl 后面五位数字
		newin.add(invoiceNum);
		invoiceNum.setBounds(120,20,80,20);
		final JTextField inf=new JTextField();
		inf.setFont(new Font("SanSerif",Font.PLAIN,12));
		newin.add(inf);
		inf.setBounds(220, 20, 100, 24);
		inf.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		JLabel date=new JLabel("装车日期");
		newin.add(date);
		date.setBounds(120,55,80,20);
		final JTextField datef=new JTextField();
		datef.setFont(new Font("Dialog",Font.CENTER_BASELINE,12));
		newin.add(datef);
		datef.setBounds(220, 55, 100, 24);
		datef.setHorizontalAlignment(SwingConstants.CENTER);
		datef.addMouseListener(new MouseAdapter(){
			
			public void mouseClicked(MouseEvent e){
				if(e.getClickCount()==2){
					SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
					datef.setText(sdf.format(new Date()));
				}		
			}
		});
		
		JLabel centerNum=new JLabel("中转中心编号");
		//6位
		newin.add(centerNum);
		centerNum.setBounds(120,90,80,20);
		final JTextField cnf=new JTextField();
		cnf.setFont(new Font("SanSerif",Font.PLAIN,12));
		newin.add(cnf);
		cnf.setBounds(220, 90, 100, 24);
		cnf.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel transferNum=new JLabel("中转单编号");
		//21位
		newin.add(transferNum);
		transferNum.setBounds(120,125,80,20);
		final JTextField tnf=new JTextField();
		tnf.setFont(new Font("SanSerif",Font.PLAIN,12));
		newin.add(tnf);
		tnf.setBounds(220, 125, 100, 24);
		tnf.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel departurePlace=new JLabel("出发地");
		newin.add(departurePlace);
		departurePlace.setBounds(120, 160, 80, 20);
		final JTextField dpf=new JTextField();
		dpf.setFont(new Font("SanSerif",Font.PLAIN,12));
		newin.add(dpf);
		dpf.setBounds(220, 160, 100, 24);
		dpf.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel state=new JLabel("到达状态");
		newin.add(state);
		state.setBounds(120, 195, 80, 20);
		final JComboBox<String> jcb=new JComboBox<String>();
		jcb.addItem("完整");
		jcb.addItem("损坏");
		jcb.addItem("丢失");
		jcb.setBackground(Color.WHITE);
		jcb.setFont(new Font("SanSerif",Font.CENTER_BASELINE,12));
		newin.add(jcb);
		jcb.setBounds(220, 195, 100, 24);

		JLabel place=new JLabel("所属中转中心");
		newin.add(place);
		place.setBounds(120, 230, 80, 20);
		final JComboBox<String> jcb2=new JComboBox<String>();
		jcb2.addItem("南京仙林");
		jcb2.addItem("南京鼓楼");
		jcb2.setBackground(Color.WHITE);
		jcb2.setFont(new Font("SanSerif",Font.CENTER_BASELINE,12));
		newin.add(jcb2);
		jcb2.setBounds(220, 230, 100, 24);
		
		JLabel maker=new JLabel("单据生成者");
		newin.add(maker);
		maker.setBounds(120,265,80,20);
		final JTextField mf=new JTextField(vo.getId());
		mf.setFont(new Font("SanSerif",Font.PLAIN,12));
		newin.add(mf);
		mf.setBounds(220,265, 100, 24);mf.setEditable(true);
		mf.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel buttonpanel=new JPanel();
		buttonpanel.setLayout(null);
		JButton save=new JButton("保存(S)");
		JButton cancel=new JButton("取消(C)");
		buttonpanel.add(save);
		buttonpanel.add(cancel);
		save.setBounds(this.getWidth()/2-140,30,100,30);
		cancel.setBounds(this.getWidth()/2+30, 30, 100, 30);
		add(buttonpanel);
		buttonpanel.setBounds(0, 7*this.getHeight()/10,this.getWidth(),90);
		
		save.addActionListener(new ActionListener(){
			RecivalListBL recivallistdata=new RecivalListBL();
	
			public void actionPerformed(ActionEvent arg0){
				try{				
					if(!datef.getText().matches("\\d{4}-\\d{1,2}-\\d{1,2}")||tnf.getText().length()!=21||cnf.getText().length()!=6||jcb.getSelectedItem()==null)				
						JOptionPane.showMessageDialog(null, "中转中心接收单格式错误");				
					else{				
						RecivalListVO vo=new RecivalListVO(inf.getText(),datef.getText(),cnf.getText(),tnf.getText(),dpf.getText(),jcb.getSelectedItem().toString(),jcb2.getSelectedItem().toString(),mf.getText(),"草稿");		
						JOptionPane.showMessageDialog(newin, "保存至中转中心接收单");
						recivallistdata.record(vo);
						InvoiceUI_RecivalList.this.dispose();
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
