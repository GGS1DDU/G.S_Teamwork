package elms.presentation.invoiceui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
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

import elms.businesslogic.invoicebl.LoadingListBL;
import elms.vo.LoadingListVO;

public class InvoiceUI_LoadingList extends JFrame{
	Toolkit kit=Toolkit.getDefaultToolkit();
	Dimension screenSize=kit.getScreenSize();
	int screenWidth=(int) screenSize.getWidth();
	int screenHeight=(int) screenSize.getHeight();
	
//	public static void main(String args[]){
//		new InvoiceUI_LoadingList();
//	}
	
	public InvoiceUI_LoadingList(){
		setLayout(null);
		setResizable(false);
		setTitle("新建营业厅装车单   ");
		setBounds(screenWidth/4,screenHeight/4,screenWidth/3,6*screenHeight/8);
		setVisible(true);
		
		final JPanel newin=new JPanel();
		newin.setLayout(null);
		add(newin);
		newin.setBounds(0, 0, this.getWidth(), 4*this.getHeight()/5);
		newin.setBorder(BorderFactory.createTitledBorder(""));
		
		JLabel invoiceNum=new JLabel("单据ID");
		//前两位ll 后面五位数字
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
		datef.setBounds(220,60,100,24);
		datef.setHorizontalAlignment(SwingConstants.CENTER);
		datef.addMouseListener(new MouseAdapter(){
			
			public void mouseClicked(MouseEvent e){
				if(e.getClickCount()==2){
					SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
					datef.setText(sdf.format(new Date()));
				}		
			}
		});
		
		JLabel shopNum=new JLabel("营业厅编号");
		//7位
		newin.add(shopNum);
		shopNum.setBounds(120,100,80,20);
		final JTextField snf=new JTextField();
		snf.setFont(new Font("SanSerif",Font.PLAIN,12));
		newin.add(snf);
		snf.setBounds(220, 100, 100, 24);
		snf.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel transNum=new JLabel("汽运编号");
		//20位
		newin.add(transNum);
		transNum.setBounds(120,140,80,20);
		final JTextField tnf=new JTextField();
		tnf.setFont(new Font("SanSerif",Font.PLAIN,12));
		newin.add(tnf);
		tnf.setBounds(220, 140, 100, 24);
		tnf.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel arrivalPlace=new JLabel("到达地");
		//本地中转中心或其他营业厅
		newin.add(arrivalPlace);
		arrivalPlace.setBounds(120,180,80,20);
		final JTextField apf=new JTextField();
		apf.setFont(new Font("SanSerif",Font.PLAIN,12));
		newin.add(apf);
		apf.setBounds(220, 180, 100, 24);
		apf.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel carNum=new JLabel("车辆代号");
		//9位
		newin.add(carNum);
		carNum.setBounds(120,220,80,20);
		final JTextField cnf=new JTextField();
		cnf.setFont(new Font("SanSerif",Font.PLAIN,12));
		newin.add(cnf);
		cnf.setBounds(220, 220, 100, 24);
		cnf.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel surpervisor=new JLabel("监装员");
		newin.add(surpervisor);
		surpervisor.setBounds(120,260,80,20);
		final JTextField s1f=new JTextField();
		s1f.setFont(new Font("SanSerif",Font.PLAIN,12));
		newin.add(s1f);
		s1f.setBounds(220, 260, 100, 24);
		s1f.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel supercargo=new JLabel("押运员");
		newin.add(supercargo);
		supercargo.setBounds(120,300,80,20);
		final JTextField s2f=new JTextField();
		s2f.setFont(new Font("SanSerif",Font.PLAIN,12));
		newin.add(s2f);
		s2f.setBounds(220, 300, 100, 24);
		s2f.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel orderNum=new JLabel("订单条形号码");
		//10位 多文本域
		newin.add(orderNum);
		orderNum.setBounds(120,340,80,20);
		final JTextArea area=new JTextArea();
		area.setLineWrap(true);
		area.setFont(new Font("SanSerif",Font.PLAIN,12));
		JScrollPane pane=new JScrollPane(area,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		newin.add(pane);
		pane.setViewportView(area);
		pane.setBounds(220,340,100,64);

		
		//应该是自动生成的，这边暂时先写输入的
		JLabel cost=new JLabel("运费");
		newin.add(cost);
		cost.setBounds(120,420,80,20);
		final JTextField cf=new JTextField();
		cf.setFont(new Font("SanSerif",Font.PLAIN,12));
		newin.add(cf);
		cf.setBounds(220, 420, 100, 24);
		cf.setHorizontalAlignment(SwingConstants.CENTER);
		
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
			LoadingListBL loadinglistdata=new LoadingListBL();
	
			public void actionPerformed(ActionEvent arg0){
				try{				
					if(!datef.getText().matches("\\d{4}-\\d{1,2}-\\d{1,2}")||snf.getText().length()!=7||tnf.getText()
							.length()!=20||cnf.getText().length()!=9)				
						JOptionPane.showMessageDialog(null, "营业厅装车单格式错误");				
					else{	
						String data=area.getText();
						String[] str=data.split("\n");
					    ArrayList<String> arr=new ArrayList<String>();
					    for(int i=0;i<str.length;i++){
					    	arr.add(str[i]);
					    }
						LoadingListVO vo=new LoadingListVO(inf.getText(),datef.getText(),snf.getText(),
								tnf.getText(),apf.getText(),cnf.getText(),s1f.getText(),s2f.getText(),arr,Double.valueOf(cf.getText()));		
						JOptionPane.showMessageDialog(newin, "保存至营业厅装车单");
						loadinglistdata.record(vo);
						InvoiceUI_LoadingList.this.dispose();
						
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
