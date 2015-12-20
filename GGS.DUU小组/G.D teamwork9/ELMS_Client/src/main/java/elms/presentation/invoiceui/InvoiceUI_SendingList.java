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
import elms.businesslogic.invoicebl.SendingListBL;
import elms.vo.ArrivalListVO;
import elms.vo.SendingListVO;

public class InvoiceUI_SendingList extends JFrame{
	Toolkit kit=Toolkit.getDefaultToolkit();
	Dimension screenSize=kit.getScreenSize();
	int screenWidth=(int) screenSize.getWidth();
	int screenHeight=(int) screenSize.getHeight();
	
//	public static void main(String args[]){
//		  new InvoiceUI_SendingList();
//	  }
	  
	public InvoiceUI_SendingList(){
		setLayout(null);
		setResizable(false);
		setTitle("新建营业厅派件单   ");
		setBounds(screenWidth/4,screenHeight/4,screenWidth/3,3*screenHeight/8);
		setVisible(true);
		
		final JPanel newin=new JPanel();
		newin.setLayout(null);
		add(newin);
		newin.setBounds(0, 0, this.getWidth(), 3*this.getHeight()/5);
		newin.setBorder(BorderFactory.createTitledBorder(""));
		
		
		JLabel invoiceNum=new JLabel("单据ID");
		//前两位sl 后面五位数字
		newin.add(invoiceNum);
		invoiceNum.setBounds(100,20,80,20);
		final JTextField inf=new JTextField();
		inf.setFont(new Font("SanSerif",Font.PLAIN,12));
		newin.add(inf);
		inf.setBounds(220, 20, 100, 24);
		inf.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		JLabel orderNum=new JLabel("托运订单条形号码");
		//10位
		newin.add(orderNum);
		orderNum.setBounds(100,60,120,20);
		final JTextField onf=new JTextField();
		onf.setFont(new Font("SanSerif",Font.PLAIN,12));
		newin.add(onf);
		onf.setBounds(220, 60, 100, 24);
		onf.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		JLabel courier=new JLabel("派件员");
		newin.add(courier);
		courier.setBounds(100, 100, 80, 20);
		final JTextField cf=new JTextField();
		cf.setFont(new Font("SanSerif",Font.PLAIN,12));
		newin.add(cf);
		cf.setBounds(220, 100, 100, 24);
		cf.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		JLabel date=new JLabel("到达日期");
		newin.add(date);
		date.setBounds(100,140,80,20);
		final JTextField datef=new JTextField();
		datef.setFont(new Font("Dialog",Font.CENTER_BASELINE,12));
		newin.add(datef);
		datef.setBounds(220, 140, 100, 24);
		datef.setHorizontalAlignment(SwingConstants.CENTER);
		datef.addMouseListener(new MouseAdapter(){
			
			public void mouseClicked(MouseEvent e){
				if(e.getClickCount()==2){
					SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
					datef.setText(sdf.format(new Date()));
				}		
			}
		});
		

		JPanel buttonpanel=new JPanel();
		buttonpanel.setLayout(null);
		JButton save=new JButton("保存(S)");
		JButton cancel=new JButton("取消(C)");
		buttonpanel.add(save);
		buttonpanel.add(cancel);
		save.setBounds(this.getWidth()/2-140,25,100,30);
		cancel.setBounds(this.getWidth()/2+30, 25, 100, 30);
		add(buttonpanel);
		buttonpanel.setBounds(0, 3*this.getHeight()/5,this.getWidth(),70);
		
		save.addActionListener(new ActionListener(){
			SendingListBL sendinglistdata=new SendingListBL(); 
	
			public void actionPerformed(ActionEvent arg0){
				try{				
					if(!datef.getText().matches("\\d{4}-\\d{1,2}-\\d{1,2}")||onf.getText().length()!=10)				
						JOptionPane.showMessageDialog(null, "营业厅派件单格式错误");				
					else{				
						SendingListVO vo=new SendingListVO(inf.getText(),onf.getText(),cf.getText(),datef.getText());		
						JOptionPane.showMessageDialog(newin, "保存至营业厅派件单");
						sendinglistdata.record(vo);
						InvoiceUI_SendingList.this.dispose();
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
