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

public class InvoiceUI_RecivalList extends JFrame{
	Toolkit kit=Toolkit.getDefaultToolkit();
	Dimension screenSize=kit.getScreenSize();
	int screenWidth=(int) screenSize.getWidth();
	int screenHeight=(int) screenSize.getHeight();
	
	public InvoiceUI_RecivalList(){
		setLayout(null);
		setResizable(false);
		setTitle("新建中转中心接收单   ");
		setBounds(screenWidth/4,screenHeight/4,screenWidth/3,screenHeight/2);
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
		date.setBounds(120,60,80,20);
		final JTextField datef=new JTextField();
		datef.setFont(new Font("Dialog",Font.CENTER_BASELINE,12));
		newin.add(datef);
		datef.setBounds(220, 60, 100, 24);
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
		centerNum.setBounds(120,100,80,20);
		final JTextField cnf=new JTextField();
		cnf.setFont(new Font("SanSerif",Font.PLAIN,12));
		newin.add(cnf);
		cnf.setBounds(220, 100, 100, 24);
		cnf.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel transferNum=new JLabel("中转单编号");
		//21位
		newin.add(transferNum);
		transferNum.setBounds(120,140,80,20);
		final JTextField tnf=new JTextField();
		tnf.setFont(new Font("SanSerif",Font.PLAIN,12));
		newin.add(tnf);
		tnf.setBounds(220, 140, 100, 24);
		tnf.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel departurePlace=new JLabel("出发地");
		newin.add(departurePlace);
		departurePlace.setBounds(120, 180, 80, 20);
		final JTextField dpf=new JTextField();
		dpf.setFont(new Font("SanSerif",Font.PLAIN,12));
		newin.add(dpf);
		dpf.setBounds(220, 180, 100, 24);
		dpf.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel state=new JLabel("到达状态");
		newin.add(state);
		state.setBounds(120, 220, 80, 20);
		final JComboBox<String> jcb=new JComboBox<String>();
		jcb.addItem("完整");
		jcb.addItem("损坏");
		jcb.addItem("丢失");
		jcb.setBackground(Color.WHITE);
		jcb.setFont(new Font("SanSerif",Font.CENTER_BASELINE,12));
		newin.add(jcb);
		jcb.setBounds(220, 220, 100, 24);
		
		
		JPanel buttonpanel=new JPanel();
		buttonpanel.setLayout(null);
		JButton save=new JButton("保存(S)");
		JButton cancel=new JButton("取消(C)");
		buttonpanel.add(save);
		buttonpanel.add(cancel);
		save.setBounds(this.getWidth()/2-140,60,100,30);
		cancel.setBounds(this.getWidth()/2+30, 60, 100, 30);
		add(buttonpanel);
		buttonpanel.setBounds(0, 3*this.getHeight()/5,this.getWidth(),90);
		
		save.addActionListener(new ActionListener(){
			RecivalListBL recivallistdata=new RecivalListBL();
	
			public void actionPerformed(ActionEvent arg0){
				try{				
					if(!datef.getText().matches("\\d{4}-\\d{1,2}-\\d{1,2}")||tnf.getText().length()!=21||cnf.getText().length()!=6||jcb.getSelectedItem()==null)				
						JOptionPane.showMessageDialog(null, "中转中心接收单格式错误");				
					else{				
						RecivalListVO vo=new RecivalListVO(inf.getText(),datef.getText(),cnf.getText(),tnf.getText(),dpf.getText(),jcb.getSelectedItem().toString());		
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
