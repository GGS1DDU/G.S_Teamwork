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
import elms.vo.ArrivalListVO;

public class InvoiceUI_ArrivalList extends JFrame{
	Toolkit kit=Toolkit.getDefaultToolkit();
	Dimension screenSize=kit.getScreenSize();
	int screenWidth=(int) screenSize.getWidth();
	int screenHeight=(int) screenSize.getHeight();
	
	public static void main(String args[]){
		  new InvoiceUI_ArrivalList();
	  }
	  
	public InvoiceUI_ArrivalList(){
		setLayout(null);
		setResizable(false);
		setTitle("新建营业厅到达单   ");
		setBounds(screenWidth/4,screenHeight/4,screenWidth/3,3*screenHeight/8);
		setVisible(true);
		
		final JPanel newin=new JPanel();
		newin.setLayout(null);
		add(newin);
		newin.setBounds(0, 0, this.getWidth(), 7*this.getHeight()/10);
		newin.setBorder(BorderFactory.createTitledBorder(""));
		
		
		JLabel invoiceNum=new JLabel("单据ID");
		//前两位al 后面五位数字
		newin.add(invoiceNum);
		invoiceNum.setBounds(120,10,80,20);
		final JTextField inf=new JTextField();
		inf.setFont(new Font("SanSerif",Font.PLAIN,12));
		newin.add(inf);
		inf.setBounds(220, 10, 100, 24);
		inf.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		JLabel transferNum=new JLabel("中转单编号");
		//21位
		newin.add(transferNum);
		transferNum.setBounds(120,40,80,20);
		final JTextField tnf=new JTextField();
		tnf.setFont(new Font("SanSerif",Font.PLAIN,12));
		newin.add(tnf);
		tnf.setBounds(220, 40, 100, 24);
		tnf.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		JLabel date=new JLabel("到达日期");
		newin.add(date);
		date.setBounds(120,70,80,20);
		final JTextField datef=new JTextField();
		datef.setFont(new Font("Dialog",Font.CENTER_BASELINE,12));
		newin.add(datef);
		datef.setBounds(220, 70, 100, 24);
		datef.setHorizontalAlignment(SwingConstants.CENTER);
		datef.addMouseListener(new MouseAdapter(){
			
			public void mouseClicked(MouseEvent e){
				if(e.getClickCount()==2){
					SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
					datef.setText(sdf.format(new Date()));
				}		
			}
		});
		
		
		JLabel state=new JLabel("到达状态");
		newin.add(state);
		state.setBounds(120, 100, 80, 20);
		final JComboBox<String> jcb=new JComboBox<String>();
		jcb.addItem("完整");
		jcb.addItem("损坏");
		jcb.addItem("丢失");
		jcb.setBackground(Color.WHITE);
		jcb.setFont(new Font("SanSerif",Font.CENTER_BASELINE,12));
		newin.add(jcb);
		jcb.setBounds(220, 100, 100, 24);
		
		JLabel departurePlace=new JLabel("出发地");
		newin.add(departurePlace);
		departurePlace.setBounds(120, 130, 80, 20);
		final JTextField dpf=new JTextField();
		dpf.setFont(new Font("SanSerif",Font.PLAIN,12));
		newin.add(dpf);
		dpf.setBounds(220, 130, 100, 24);
		dpf.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel place=new JLabel("所属营业厅");
		newin.add(place);
		place.setBounds(120, 160, 80, 20);
		final JTextField pf=new JTextField();
		pf.setFont(new Font("SanSerif",Font.PLAIN,12));
		newin.add(pf);
		pf.setBounds(220, 160, 100, 24);
		pf.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		JPanel buttonpanel=new JPanel();
		buttonpanel.setLayout(null);
		JButton save=new JButton("保存(S)");
		JButton cancel=new JButton("取消(C)");
		buttonpanel.add(save);
		buttonpanel.add(cancel);
		save.setBounds(this.getWidth()/2-140,20,100,30);
		cancel.setBounds(this.getWidth()/2+30, 20, 100, 30);
		add(buttonpanel);
		buttonpanel.setBounds(0, 7*this.getHeight()/10,this.getWidth(),70);
		
		save.addActionListener(new ActionListener(){
			ArrivalListBL arrivallistdata=new ArrivalListBL();
	
			public void actionPerformed(ActionEvent arg0){
				try{				
					if(!datef.getText().matches("\\d{4}-\\d{1,2}-\\d{1,2}")||tnf.getText().length()!=21||jcb.getSelectedItem()==null)				
						JOptionPane.showMessageDialog(null, "营业厅到达单格式错误");				
					else{				
						ArrivalListVO vo=new ArrivalListVO(inf.getText(),tnf.getText(),datef.getText(),jcb.getSelectedItem().toString(),dpf.getText(),pf.getText());		
						JOptionPane.showMessageDialog(newin, "保存至营业厅到达单");
						arrivallistdata.record(vo);
						InvoiceUI_ArrivalList.this.dispose();
						
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
