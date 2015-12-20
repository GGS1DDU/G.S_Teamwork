package elms.presentation.invoiceui;

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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import elms.businesslogic.invoicebl.IncomeListBL;
import elms.vo.IncomeListVO;

public class InvoiceUI_IncomeList extends JFrame{	
	Toolkit kit=Toolkit.getDefaultToolkit();
	Dimension screenSize=kit.getScreenSize();
	int screenWidth=(int) screenSize.getWidth();
	int screenHeight=(int) screenSize.getHeight();
	
	public static void main(String args[]){
		new InvoiceUI_IncomeList();
	}
	
	public InvoiceUI_IncomeList(){
		setLayout(null);
		setResizable(false);
		setTitle("新建收款单");
		setBounds(screenWidth/4,screenHeight/4,screenWidth/3,screenHeight/2);
		setVisible(true);
		
		final JPanel newin=new JPanel();
		newin.setLayout(null);
		add(newin);
		newin.setBounds(0,0,this.getWidth(),7*this.getHeight()/10);
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
			IncomeListBL incomelistdata=new IncomeListBL();
	
			public void actionPerformed(ActionEvent arg0){
				try{				
					if(!datef.getText().matches("\\d{4}-\\d{1,2}-\\d{1,2}"))				
						JOptionPane.showMessageDialog(null, "营业厅收款单格式错误");				
					else{	
						String data=area.getText();
						String[] str=data.split("\n");
					    ArrayList<String> arr=new ArrayList<String>();
					    for(int i=0;i<str.length;i++){
					    	arr.add(str[i]);
					    }
						IncomeListVO vo=new IncomeListVO(inf.getText(),Double.valueOf(icf.getText()),cnf.getText(),datef.getText(),arr);		
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
