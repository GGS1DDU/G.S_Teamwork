package elms.presentation.invoiceui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
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

public class InvoiceUI_SendingListEdit extends JFrame{
	SendingListVO voall;
	Toolkit kit=Toolkit.getDefaultToolkit();
	Dimension screenSize=kit.getScreenSize();
	int screenWidth=(int) screenSize.getWidth();
	int screenHeight=(int) screenSize.getHeight();
	boolean Edit;
	
	public SendingListVO getVO(){
		return voall;
	}

	public InvoiceUI_SendingListEdit(SendingListVO vo, boolean edit) {
		voall=vo;
		setLayout(null);
		setTitle("派件单  No："+vo.getID());
		setResizable(false);
		setBounds(screenWidth/4,screenHeight/4,screenWidth/3,3*screenHeight/8);
		setVisible(true);
		
		Edit=edit;
		
		final JPanel newin=new JPanel();
		newin.setLayout(null);
		add(newin);newin.setBounds(0,0,this.getWidth(),3*this.getHeight()/5);
		newin.setBorder(BorderFactory.createTitledBorder(""));
		
		JLabel id=new JLabel("单据ID");
		newin.add(id);
		id.setBounds(100,20,80,20);
		final JTextField idf=new JTextField(vo.getID());
		newin.add(idf);
		idf.setBounds(220,20,100,24);
		idf.setEditable(Edit);
		idf.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel orderNum=new JLabel("托运订单条形号码");
		newin.add(orderNum);orderNum.setBounds(100,60,120,20);
		final JTextField onf=new JTextField(vo.getOrderID());
		onf.setFont(new Font("SansSerif",Font.CENTER_BASELINE,12));
		newin.add(onf);onf.setBounds(220, 60, 100, 24);onf.setEditable(Edit);
		onf.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel courier=new JLabel("派件员");
		newin.add(courier);
		courier.setBounds(100, 100, 80, 20);
		final JTextField cf=new JTextField(vo.getCourier());
		cf.setFont(new Font("SansSerif",Font.PLAIN,12));
		newin.add(cf);cf.setBounds(220, 100, 100, 24);cf.setEditable(Edit);
		cf.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel date=new JLabel("到达日期");
		newin.add(date);date.setBounds(100,140,80,20);
		final JTextField df=new JTextField(vo.getTime());
		df.setFont(new Font("Dialog",Font.CENTER_BASELINE,12));
		newin.add(df);df.setBounds(220, 140, 100, 24);
		df.setEditable(Edit);
		df.setHorizontalAlignment(SwingConstants.CENTER);
		if(Edit){
			df.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
					if(e.getClickCount()==2){
						SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
						df.setText(sdf.format(new Date()));
					}
				}
			});
		}
			
		JPanel buttonpanel=new JPanel();
		buttonpanel.setLayout(null);
		JButton cancle=new JButton("编辑(E)");
		buttonpanel.add(cancle);
		cancle.setBounds(this.getWidth()/2+90,25,100,30);
		add(buttonpanel);
		buttonpanel.setBounds(0,3*this.getHeight()/5,this.getWidth(),70);
		
		cancle.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				InvoiceUI_SendingListEdit.this.dispose();
				new InvoiceUI_SendingListEdit(getVO(),true);
			}
		});
		
		if(Edit){
			JButton save=new JButton("保存(S)");
			buttonpanel.add(save);
			save.setBounds(this.getWidth()/3-120,25,100,30);
			
			save.addActionListener(new ActionListener(){
				SendingListBL sendinglistdata=new SendingListBL();
				SendingListVO newvo;

				public void actionPerformed(ActionEvent e) {
					if(idf.getText().equals(voall.getID())&&df.getText().equals(voall.getTime())
							&&onf.getText().equals(voall.getOrderID())&&cf.getText().equals(voall.getCourier())){
						JOptionPane.showMessageDialog(newin, "未发生改变");
						InvoiceUI_SendingListEdit.this.dispose();
						new InvoiceUI_SendingListEdit(voall,false);
					}else{
						try{
							if(df.getText().matches("\\d{4}-\\d{2}-\\d{2}\\s")||onf.getText().length()!=10){
								JOptionPane.showMessageDialog(newin,"修改信息格式错误");
							}
							InvoiceUI_SendingListEdit.this.dispose();
							sendinglistdata.delete(getVO());
							sendinglistdata.record(newvo);
							new InvoiceUI_SendingListEdit(newvo,false);
							
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
					InvoiceUI_SendingListEdit.this.dispose();
					new InvoiceUI_SendingListEdit(getVO(),false);
				}
			});			
		}
		else{
			JButton back=new JButton("删除(D)");
			buttonpanel.add(back);
			back.setBounds(this.getWidth()/2-50,25,100,30);
			back.addActionListener(new ActionListener(){
				SendingListBL sendinglistdata=new SendingListBL();

				public void actionPerformed(ActionEvent e) {
					try{
						sendinglistdata.delete(voall);
					}catch(IOException e1){
						e1.printStackTrace();
					}
					InvoiceUI_SendingListEdit.this.dispose();
					JOptionPane.showMessageDialog(null, voall.getID()+"已删除");					
				}				
			});			
		}		
	}
}
