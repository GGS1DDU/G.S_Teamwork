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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import elms.businesslogic.invoicebl.IncomeListBL;
import elms.presentation.uihelper.MyPanel;
import elms.vo.IncomeListVO;
import elms.vo.UserVO;

public class InvoiceUI_IncomeList extends JFrame{	
	Toolkit kit=Toolkit.getDefaultToolkit();
	Dimension screenSize=kit.getScreenSize();
	int screenWidth=(int) screenSize.getWidth();
	int screenHeight=(int) screenSize.getHeight();
	
//	public static void main(String args[]){
//		UserVO vo=new UserVO("","","","");
//		
//		new InvoiceUI_IncomeList(vo);
//	}
	
	public InvoiceUI_IncomeList(final UserVO vo){
		setLayout(null);
		setResizable(false);
		setTitle("新建收款单");
		setBounds(screenWidth/4,screenHeight/4,screenWidth/3,screenHeight/2+80);
		setVisible(true);
		
		MyPanel p=new MyPanel("bg3.png");
		add(p);p.setBounds(0, 0, this.getWidth(), this.getHeight());
		
		final JPanel newin=new JPanel();newin.setOpaque(false);
		newin.setLayout(null);
		p.add(newin);
		newin.setBounds(0,0,this.getWidth(),7*this.getHeight()/10+10);
		newin.setBorder(BorderFactory.createTitledBorder(""));
		
		JLabel invoiceNum=new JLabel("单据ID");
		//前两位il 后面五位数字
		newin.add(invoiceNum);
		invoiceNum.setBounds(120,20,80,20);
		final JTextField inf=new JTextField();
		inf.setFont(new Font("SanSerif",Font.PLAIN,12));
		newin.add(inf);
		inf.setBounds(220, 20, 100, 24);
		inf.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel income=new JLabel("收费金额");
		//精确到小数点后一位
		newin.add(income);
		income.setBounds(120,60,80,20);
		final JTextField icf=new JTextField();
		icf.setFont(new Font("SanSerif",Font.PLAIN,12));
		newin.add(icf);
		icf.setBounds(220,60,100,24);
		icf.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel courierName=new JLabel("快递员姓名");
		newin.add(courierName);
		courierName.setBounds(120,100,80,20);
		final JTextField cnf=new JTextField();
		cnf.setFont(new Font("SanSerif",Font.PLAIN,12));
		newin.add(cnf);
		cnf.setBounds(220,100,100,24);
		cnf.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel date=new JLabel("收款日期");
		newin.add(date);
		date.setBounds(120,140,80,20);
		final JTextField datef=new JTextField();
		datef.setFont(new Font("Dialog",Font.CENTER_BASELINE,12));
		newin.add(datef);
		datef.setBounds(220,140,100,24);
		datef.setHorizontalAlignment(SwingConstants.CENTER);
		datef.addMouseListener(new MouseAdapter(){
			
			public void mouseClicked(MouseEvent e){
				if(e.getClickCount()==2){
					SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
					datef.setText(sdf.format(new Date()));					
				}
			}
		});
	
		JLabel orderNum=new JLabel("订单条形号码");
		//10位 多文本域
		newin.add(orderNum);
		orderNum.setBounds(120,180,80,20);
		final JTextArea area=new JTextArea();
		area.setLineWrap(true);
		area.setFont(new Font("SanSerif",Font.PLAIN,12));
		JScrollPane pane=new JScrollPane(area,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		newin.add(pane);
		pane.setViewportView(area);
		pane.setBounds(220,180,100,64);
		
		JLabel place=new JLabel("所属营业厅");
		newin.add(place);
		place.setBounds(120, 260, 80, 20);
		final JComboBox<String> jcb2=new JComboBox<String>();
		jcb2.addItem("南京仙林");
		jcb2.addItem("南京鼓楼");
		jcb2.setBackground(Color.WHITE);
		jcb2.setFont(new Font("SanSerif",Font.CENTER_BASELINE,12));
		newin.add(jcb2);
		jcb2.setBounds(220, 260, 100, 24);
			
		JLabel maker=new JLabel("单据生成者");
		newin.add(maker);
		maker.setBounds(120,300,80,20);
		final JTextField mf=new JTextField(vo.getId());
		mf.setFont(new Font("SanSerif",Font.PLAIN,12));
		newin.add(mf);
		mf.setBounds(220, 300, 100, 24);mf.setEditable(true);
		mf.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel buttonpanel=new JPanel();
		buttonpanel.setLayout(null);
		JButton save=new JButton("保存(S)");
		JButton cancel=new JButton("取消(C)");
		buttonpanel.add(save);
		buttonpanel.add(cancel);
		save.setBounds(this.getWidth()/2-140,25,100,30);
		cancel.setBounds(this.getWidth()/2+30, 25, 100, 30);
		p.add(buttonpanel);
		buttonpanel.setBounds(0, 7*this.getHeight()/10+10,this.getWidth(),70);
		
		save.addActionListener(new ActionListener(){
			IncomeListBL incomelistdata=new IncomeListBL();
	
			public void actionPerformed(ActionEvent arg0){
				try{				
					if(!datef.getText().matches("\\d{4}-\\d{1,2}-\\d{1,2}"))				
						JOptionPane.showMessageDialog(null, "营业厅收款单格式错误");				
					else{	
//						String data=area.getText();
//						String[] str=data.split("\n");
//					    ArrayList<String> arr=new ArrayList<String>();
//					    for(int i=0;i<str.length;i++){
//					    	arr.add(str[i]);
//					    }						
//						IncomeListVO vo=new IncomeListVO(inf.getText(),Double.valueOf(icf.getText()),cnf.getText(),datef.getText(),arr,pf.getText());		
						IncomeListVO vo=new IncomeListVO(inf.getText(),Double.valueOf(icf.getText()),cnf.getText(),
								datef.getText(),area.getText(),jcb2.getSelectedItem().toString(),mf.getText(),"提交");		

						JOptionPane.showMessageDialog(newin, "保存至营业厅装车单");
						incomelistdata.record(vo);
						InvoiceUI_IncomeList.this.dispose();
						
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
