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
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
import elms.vo.UserVO;

public class InvoiceUI_TransferList extends JFrame{
	Toolkit kit=Toolkit.getDefaultToolkit();
	Dimension screenSize=kit.getScreenSize();
	int screenWidth=(int) screenSize.getWidth();
	int screenHeight=(int) screenSize.getHeight();
	
//	public static void main(String args[]){
//		new InvoiceUI_TransferList();
//	}
	
	public InvoiceUI_TransferList(final UserVO vo){
		setLayout(null);
		setResizable(false);
		setTitle("新建中转中心中转单   ");
		setBounds(screenWidth/4,screenHeight/4,screenWidth/3,6*screenHeight/8+40);
		setVisible(true);
		
		final JPanel newin=new JPanel();
		newin.setLayout(null);
		add(newin);
		newin.setBounds(0, 0, this.getWidth(), 4*this.getHeight()/5);
		newin.setBorder(BorderFactory.createTitledBorder(""));
		
		JLabel invoiceNum=new JLabel("单据ID");
		//前两位tl 后面五位数字
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
		datef.setBounds(220,55,100,24);
		datef.setHorizontalAlignment(SwingConstants.CENTER);
		datef.addMouseListener(new MouseAdapter(){
			
			public void mouseClicked(MouseEvent e){
				if(e.getClickCount()==2){
					SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
					datef.setText(sdf.format(new Date()));
				}		
			}
		});
		
		JLabel transferID=new JLabel("中转单编号");
		//21位
		newin.add(transferID);
		transferID.setBounds(120,90,80,20);
		final JTextField tif=new JTextField();
		tif.setFont(new Font("SanSerif",Font.PLAIN,12));
		newin.add(tif);
		tif.setBounds(220, 90, 100, 24);
		tif.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel transportNum=new JLabel("航班号/车次号");
		newin.add(transportNum);
		transportNum.setBounds(120,125,90,20);
		final JTextField tnf=new JTextField();
		tnf.setFont(new Font("SanSerif",Font.PLAIN,12));
		newin.add(tnf);
		tnf.setBounds(220, 125, 100, 24);
		tnf.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel departurePlace=new JLabel("出发地");
		newin.add(departurePlace);
		departurePlace.setBounds(120,160,80,20);
		final JTextField dpf=new JTextField();
		dpf.setFont(new Font("SanSerif",Font.PLAIN,12));
		newin.add(dpf);
		dpf.setBounds(220, 160, 100, 24);
		dpf.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel arrivalPlace=new JLabel("到达地");
		newin.add(arrivalPlace);
		arrivalPlace.setBounds(120,195,80,20);
		final JTextField apf=new JTextField();
		apf.setFont(new Font("SanSerif",Font.PLAIN,12));
		newin.add(apf);
		apf.setBounds(220, 195, 100, 24);
		apf.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel seatNum=new JLabel("货柜号");
		newin.add(seatNum);
		seatNum.setBounds(120,230,80,20);
		final JTextField snf=new JTextField();
		snf.setFont(new Font("SanSerif",Font.PLAIN,12));
		newin.add(snf);
		snf.setBounds(220, 230, 100, 24);
		snf.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel surpervisor=new JLabel("监装员");
		newin.add(surpervisor);
		surpervisor.setBounds(120,265,80,20);
		final JTextField s1f=new JTextField();
		s1f.setFont(new Font("SanSerif",Font.PLAIN,12));
		newin.add(s1f);
		s1f.setBounds(220, 265, 100, 24);
		s1f.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel orderNum=new JLabel("托运单号");
		//10位 多文本域
		newin.add(orderNum);
		orderNum.setBounds(120,300,80,20);
		final JTextArea area=new JTextArea();
		area.setLineWrap(true);
		area.setFont(new Font("SanSerif",Font.PLAIN,12));
		JScrollPane pane=new JScrollPane(area,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		newin.add(pane);
		pane.setViewportView(area);
		pane.setBounds(220,300,100,64);

		
		//应该是自动生成的，这边暂时先写输入的
		JLabel cost=new JLabel("运费");
		newin.add(cost);
		cost.setBounds(120,375,80,20);
		final JTextField cf=new JTextField();
		cf.setFont(new Font("SanSerif",Font.PLAIN,12));
		newin.add(cf);
		cf.setBounds(220, 375, 100, 24);
		cf.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel place=new JLabel("所属中转中心");
		newin.add(place);
		place.setBounds(120, 410, 80, 20);
		final JComboBox<String> jcb2=new JComboBox<String>();
		jcb2.addItem("南京仙林");
		jcb2.addItem("南京鼓楼");
		jcb2.setBackground(Color.WHITE);
		jcb2.setFont(new Font("SanSerif",Font.CENTER_BASELINE,12));
		newin.add(jcb2);
		jcb2.setBounds(220, 410, 100, 24);
		
		JLabel maker=new JLabel("单据生成者");
		newin.add(maker);
		maker.setBounds(120,445,80,20);
		final JTextField mf=new JTextField(vo.getId());
		mf.setFont(new Font("SanSerif",Font.PLAIN,12));
		newin.add(mf);
		mf.setBounds(220, 445, 100, 24);mf.setEditable(true);
		mf.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		JPanel buttonpanel=new JPanel();
		buttonpanel.setLayout(null);
		JButton save=new JButton("保存(S)");
		JButton cancel=new JButton("取消(C)");
		buttonpanel.add(save);
		buttonpanel.add(cancel);
		save.setBounds(this.getWidth()/2-140, 25,100,30);
		cancel.setBounds(this.getWidth()/2+30, 25, 100, 30);
		add(buttonpanel);
		buttonpanel.setBounds(0,4*this.getHeight()/5,this.getWidth(),70);
		// 
		save.addActionListener(new ActionListener(){
			TransferListBL transferlistdata=new TransferListBL();
	
			public void actionPerformed(ActionEvent arg0){
				try{				
					if(!datef.getText().matches("\\d{4}-\\d{1,2}-\\d{1,2}")||tif.getText().length()!=21)				
						JOptionPane.showMessageDialog(null, "营业厅装车单格式错误");				
					else{	
//						String data=area.getText();
//						String[] str=data.split("\n");
//					    ArrayList<String> arr=new ArrayList<String>();
//					    for(int i=0;i<str.length;i++){
//					    	arr.add(str[i]);
//					    }
						TransferListVO vo=new TransferListVO(inf.getText(),datef.getText(),tif.getText(),tnf.getText(),
								dpf.getText(),apf.getText(),snf.getText(),s1f.getText(),area.getText(),
								Double.valueOf(cf.getText()),jcb2.getSelectedItem().toString(),mf.getText(),"提交");		
						JOptionPane.showMessageDialog(newin, "保存至中转中心中转单");
						transferlistdata.record(vo);
						InvoiceUI_TransferList.this.dispose();
						
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
