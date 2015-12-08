package elms.presentation.invoiceui;

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
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import elms.businesslogic.invoicebl.TransferListBL;
import elms.vo.TransferListVO;

public class InvoiceUI_TransferListEdit extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6399347637155386297L;
	TransferListVO voall;
	Toolkit kit=Toolkit.getDefaultToolkit();
	Dimension screenSize=kit.getScreenSize();
	int screenWidth=(int) screenSize.getWidth();
	int screenHeight=(int) screenSize.getHeight();
	boolean Edit;
	
	public TransferListVO getVO(){
		return voall;
	}
	
	public InvoiceUI_TransferListEdit(TransferListVO vo,boolean edit){
		voall=vo;
		setLayout(null);
		setTitle("中转单  No："+vo.getID());
		setResizable(false);
		setBounds(screenWidth/4,screenHeight/4,screenWidth/3,6*screenHeight/8);
		setVisible(true);
		
		Edit=edit;
		
		final JPanel newin=new JPanel();
		newin.setLayout(null);
		add(newin);newin.setBounds(0,0,this.getWidth(),3*this.getHeight()/5);
		newin.setBorder(BorderFactory.createTitledBorder(""));
		
		JLabel id=new JLabel("单据ID");
		//前两位tl 后面五位数字
		newin.add(id);id.setBounds(120,20,80,20);
		final JTextField idf=new JTextField(vo.getID());
		newin.add(idf);idf.setBounds(220, 20, 100, 24);
		idf.setEditable(Edit);
		idf.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel date=new JLabel("装车日期");
		newin.add(date);date.setBounds(120,60,80,20);
		final JTextField df=new JTextField(vo.getTime());
		df.setFont(new Font("Dialog",Font.CENTER_BASELINE,12));
		newin.add(df);df.setBounds(220, 60, 100, 24);
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
		
		JLabel transferID=new JLabel("中转单编号");
		//21位
		newin.add(transferID);transferID.setBounds(120,100,80,20);
		final JTextField tif=new JTextField(vo.getTransferID());
		tif.setFont(new Font("SansSerif",Font.CENTER_BASELINE,12));
		newin.add(tif);tif.setBounds(220, 100, 160, 24);tif.setEditable(Edit);
		tif.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel transportNum=new JLabel("航班号/车次号");
		newin.add(transportNum);transportNum.setBounds(120,140,90,20);
		final JTextField tnf=new JTextField(vo.getTransportNum());
		tnf.setFont(new Font("SansSerif",Font.CENTER_BASELINE,12));
		newin.add(tnf);tnf.setBounds(220,140, 150, 24);tnf.setEditable(Edit);
		tnf.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel departurePlace=new JLabel("出发地");
		newin.add(departurePlace);
		departurePlace.setBounds(120, 180, 80, 20);
		final JTextField dpf=new JTextField(vo.getDeparture());
		dpf.setFont(new Font("SansSerif",Font.PLAIN,12));
		newin.add(dpf);dpf.setBounds(220, 180, 100, 24);dpf.setEditable(Edit);
		dpf.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel arrivalPlace=new JLabel("到达地");
		newin.add(arrivalPlace);
		arrivalPlace.setBounds(120, 220, 80, 20);
		final JTextField apf=new JTextField(vo.getArrival());
		apf.setFont(new Font("SansSerif",Font.PLAIN,12));
		newin.add(apf);apf.setBounds(220, 220, 100, 24);apf.setEditable(Edit);
		apf.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel seatNum=new JLabel("货柜号");
		newin.add(seatNum);seatNum.setBounds(120,260,80,20);
		final JTextField snf=new JTextField(vo.getSeatNumber());
		snf.setFont(new Font("SansSerif",Font.CENTER_BASELINE,12));
		newin.add(snf);snf.setBounds(220, 260, 100, 24);snf.setEditable(Edit);
		snf.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel supervisor=new JLabel("监装员");
		newin.add(supervisor);supervisor.setBounds(120,300,80,20);
		final JTextField s1f=new JTextField(vo.getSurpervior());
		s1f.setFont(new Font("SansSerif",Font.CENTER_BASELINE,12));
		newin.add(s1f);s1f.setBounds(220, 300, 100, 24);s1f.setEditable(Edit);
		s1f.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel orderID=new JLabel("订单条形号码");
		newin.add(orderID);orderID.setBounds(120,340,80,20);
		ArrayList<String> arr=new ArrayList<String>(vo.getOrderID());
		String[] strs=new String[arr.size()];
		String str=null;
		for(int i=0;i<arr.size();i++){
			strs[i]=arr.get(i)+"\n";
			str+=strs[i];
		}		
		final JTextArea area=new JTextArea(str);
		area.setLineWrap(true);
		area.setFont(new Font("SanSerif",Font.PLAIN,12));
		JScrollPane pane=new JScrollPane(area,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		newin.add(pane);
		pane.setViewportView(area);
		pane.setBounds(220,340,100,64);
		
		JLabel cost=new JLabel("运费");
		newin.add(cost);cost.setBounds(120,420,80,20);
		final JTextField cf=new JTextField(String.valueOf(vo.getCost()));
		cf.setFont(new Font("SansSerif",Font.CENTER_BASELINE,12));
		newin.add(cf);cf.setBounds(220, 300, 100, 24);cf.setEditable(Edit);
		cf.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel buttonpanel=new JPanel();
		buttonpanel.setLayout(null);
		JButton cancle=new JButton("编辑(E)");
		buttonpanel.add(cancle);
		cancle.setBounds(this.getWidth()/2+90,25,100,30);
		add(buttonpanel);
		buttonpanel.setBounds(0,3*this.getHeight()/5,this.getWidth(),70);
		
		cancle.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				InvoiceUI_TransferListEdit.this.dispose();
				new InvoiceUI_TransferListEdit(getVO(),true);
			}
		});
		
		if(Edit){
			JButton save=new JButton("保存(S)");
			buttonpanel.add(save);
			save.setBounds(this.getWidth()/3-120,25,100,30);
			
			save.addActionListener(new ActionListener(){
				TransferListBL loadinglistdata=new TransferListBL();
				TransferListVO newvo;

				public void actionPerformed(ActionEvent e) {
//					if(idf.getText().equals(voall.getID())&&df.getText().equals(voall.getTime())&&
//							tnf.getText().equals(voall.getOrder())&&jcb.getSelectedItem().toString().equals(voall.getState())
//							&&dpf.getText().equals(voall.getFrom())){
//						JOptionPane.showMessageDialog(newin, "未发生改变");
//						InvoiceUI_TransferListEdit.this.dispose();
//						new InvoiceUI_TransferListEdit(voall,false);
//					}else{
						try{
							if(!df.getText().matches("\\d{4}-\\d{1,2}-\\d{1,2}")||tif.getText().length()!=21){
								JOptionPane.showMessageDialog(newin,"修改信息格式错误");
							}
							InvoiceUI_TransferListEdit.this.dispose();
							loadinglistdata.delete(getVO());
							loadinglistdata.record(newvo);
							new InvoiceUI_TransferListEdit(newvo,false);
							
						}catch(HeadlessException e2){
							e2.printStackTrace();
						}
						catch(IOException e2){
							e2.printStackTrace();
//						}				
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
					InvoiceUI_TransferListEdit.this.dispose();
					new InvoiceUI_TransferListEdit(getVO(),false);
				}
			});
			
		}
		else{
			JButton back=new JButton("删除(D)");
			buttonpanel.add(back);
			back.setBounds(this.getWidth()/2-50,25,100,30);
			back.addActionListener(new ActionListener(){
				TransferListBL transferlistdata=new TransferListBL();

				public void actionPerformed(ActionEvent e) {
					try{
						transferlistdata.delete(voall);
					}catch(IOException e1){
						e1.printStackTrace();
					}
					InvoiceUI_TransferListEdit.this.dispose();
					JOptionPane.showMessageDialog(null, voall.getID()+"已删除");					
				}				
			});			
		}		
	}
}
