package elms.presentation.invoiceui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.table.TableColumnModel;

import elms.businesslogic.invoicebl.ArrivalListBL;
import elms.businesslogic.invoicebl.IncomeListBL;
import elms.businesslogic.invoicebl.LoadingListBL;
import elms.businesslogic.invoicebl.LoadingListZZBL;
import elms.businesslogic.invoicebl.RecivalListBL;
import elms.businesslogic.invoicebl.SendingListBL;
import elms.businesslogic.invoicebl.TransferListBL;
import elms.businesslogic.managerbl.Audit;
import elms.businesslogic.storagebl.Storage;
import elms.presentation.managerui.aduit.aduit_main;
import elms.presentation.storageui.Storage_editStorage;
import elms.presentation.storageui.Storage_main;
import elms.presentation.storageui.TableModel;
import elms.presentation.uihelper.MyButton;
import elms.presentation.uihelper.MyPanel;
import elms.vo.ArrivalListVO;
import elms.vo.IncomeListVO;
import elms.vo.InvoiceVO;
import elms.vo.LoadingListVO;
import elms.vo.LoadingListZZVO;
import elms.vo.RecivalListVO;
import elms.vo.SendingListVO;
import elms.vo.StorageVO;
import elms.vo.TransferListVO;
import elms.vo.UserVO;

public class InvoiceUI_ZZZXStaff extends JFrame{
	public ArrayList<String> OrderIn=new ArrayList<String>();
	public ArrayList<String> OrderOut=new ArrayList<String>();
	Toolkit kit=Toolkit.getDefaultToolkit();
	Dimension screenSize=kit.getScreenSize();
	int screenWidth=(int) screenSize.getWidth();
	int screenHeight=(int) screenSize.getHeight();
  int button=40;
  public static TableModel model;
  public static JTable table;
  public UserVO voa;
  final JComboBox<String> jcb;
  static JPanel user;
  JTextField of;
  JTextField tf;
Invoice_unaduit  un;
	
	public static void main(String arg[]){
		EventQueue.invokeLater(new Runnable(){
			public void run(){
//				UserVO vo=new UserVO();
				UserVO vo = new UserVO("333","891213","周颖婷","中转中心业务员");
				JFrame ZZZXStaff=new InvoiceUI_ZZZXStaff(vo);
			}
		});
	}
	
	public InvoiceUI_ZZZXStaff(final UserVO vo){
		voa=vo;
		setLayout(null);
		setTitle("中转中心管理");
		setResizable(false);
		setBounds(screenWidth/6,screenHeight/8,screenWidth*2/3,screenHeight*3/4);
		
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (ClassNotFoundException e2) {
				// TODO 自动生成的 catch 块
				e2.printStackTrace();
			} catch (InstantiationException e2) {
				// TODO 自动生成的 catch 块
				e2.printStackTrace();
			} catch (IllegalAccessException e2) {
				// TODO 自动生成的 catch 块
				e2.printStackTrace();
			} catch (UnsupportedLookAndFeelException e2) {
				// TODO 自动生成的 catch 块
				e2.printStackTrace();
			}
		
		//setUndecorated(true);
		setVisible(true);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		final MyPanel contentPane = new MyPanel("inbg.jpg");
		contentPane.setBounds(0, 0, this.getWidth(), this.getHeight());
		add(contentPane);
		contentPane.setLayout(null);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBorder(new TitledBorder(new EtchedBorder()));
		buttonPanel.setLayout(null);
		buttonPanel.setBounds(0, 0, 200, this.getHeight());
		buttonPanel.setBackground(Color.white);
		contentPane.add(buttonPanel);
		
		final JButton gl = new MyButton("单据信息",20);
		//UIManager.put("Button.background", false);
		gl.setEnabled(false);
		gl.setForeground(Color.gray);
		gl.setBounds(0,0,200,(int) (1.5*button));
		buttonPanel.add(gl);	
		
		final JButton ini = new MyButton("未通过单据",15);
		ini.setBounds(0,(int) (1.5*button),200,button);
		ini.setBackground(Color.black);
		buttonPanel.add(ini);

	
		JLabel jl=new JLabel(" 当前用户：  "+vo.getName()+"  身份：  "+vo.getJob()+"  编号   "+vo.getId());
		user=new JPanel(); user.setLayout(null);
		user.add(jl);jl.setBounds(200, 0, this.getWidth(), 25);
		user.setBounds(200, 0, this.getWidth()-200,this.getHeight());	
		contentPane.add(user);	
		user.setOpaque(false);
		
		gl.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				un.setVisible(false);
				user.setBounds(200, 0, screenWidth-200,screenHeight);	
				gl.setFont(new Font("宋体",1,20));
				gl.setForeground(Color.gray);gl.setBounds(0,0,200,(int) (1.5*button));
				ini.setFont(new Font("宋体",1,15));
				ini.setForeground(Color.black);ini.setBounds(0,(int) (1.5*button),200,button);
				ini.setEnabled(true);
				gl.setEnabled(false);
				
			}
			
		});
		
			ini.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				gl.setFont(new Font("宋体",1,15));
				gl.setForeground(Color.black);gl.setBounds(0,0,200,button);
				ini.setFont(new Font("宋体",1,20));
				ini.setForeground(Color.gray);ini.setBounds(0,button,200,(int) (1.5*button));
				ini.setEnabled(false);
				gl.setEnabled(true);
				
				try {
					user.setBounds(-screenWidth, 0, user.getWidth(), user.getHeight());
//					aduit_main sd=new aduit_main();
//					contentPane.add(sd);
//					sd.setBounds(200, 0, screenWidth-200,screenHeight);	
				un=new Invoice_unaduit(vo);					
					contentPane.add(un);
					un.setBounds(200, 0, screenWidth-200,screenHeight);	
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				
			
			}
		});
		String[] title_name = { "ID", "单据状态","制表人","装车时间","所属中转中心","出发地","货物到达状态"};
		model = new TableModel(title_name);
		table = new JTable(model);

	    table.addMouseListener(new MouseAdapter(){
	    	RecivalListBL rl=new RecivalListBL();
			LoadingListZZBL zc=new LoadingListZZBL();
			TransferListBL tl=new TransferListBL();
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(e.getClickCount()==2) {
					if(table.getSelectedColumn()!=-1){
						
						String	s=(String) model.getValueAt(table.getSelectedRow(), 0);
						String c=jcb.getSelectedItem().toString();
					if(c.equals("装车单")) {
							try {
								
								new InvoiceUI_LoadingListZZEdit(zc.inquiry(s),false);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
														}
						else	if(c.equals("接收单")) {
							try {
								new InvoiceUI_RecivalListEdit(rl.inquiry(s),false);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
														}
						else{
							try {
								new InvoiceUI_TransferListEdit(tl.inquiry(s),false);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
														}			
							}
				}	
			}
	    	
	    });
		table.setBackground(Color.white);  
		JScrollPane scrollpane=new JScrollPane(table);
		user.add(scrollpane);
		scrollpane.setBounds(-1,70,this.getWidth()-40,this.getHeight()/2-70);
        scrollpane.setOpaque(false);scrollpane.getViewport().setOpaque(false);

        jcb=new JComboBox<String>();
    	jcb.addItem("接收单");jcb.addItem("装车单");jcb.addItem("中转单");
    	jcb.setBackground(Color.white);jcb.setFont(new Font("楷体",Font.CENTER_BASELINE,12));
    	user.add(jcb); jcb.setBounds(8*user.getWidth()/9-10, user.getHeight()/2,user.getWidth()/9 , 25);jcb.setOpaque(false);
    	
    	jcb.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0) {
				setrows();					
			}
			
		});
		
    	
    	
/*
 * 选择中转中心城市
 */
		
		
		

		
		JButton xjjsd=new JButton("新建单据");
		JButton find=new JButton("查询");
		JLabel oin=new JLabel("中转入库");JLabel oot=new JLabel("中转出库");
		 of=new JTextField(); tf=new JTextField();
		JButton back=new JButton("返回(B)");back.setForeground(Color.RED);
	    user.add(xjjsd);user.add(find);user.add(back);user.add(oin);user.add(oot);user.add(of);user.add(tf);
	    xjjsd.setBounds(this.getWidth()/5-100, 3*this.getHeight()/4-50, 100, 25);
	    find.setBounds(2*this.getWidth()/5-100, 3*this.getHeight()/4-50, 100, 25);
	    back.setBounds(3*this.getWidth()/5-100, 3*this.getHeight()/4-50, 100, 25);
		oin.setBounds(3*this.getWidth()/10-200, 3*this.getHeight()/4+50, 60, 25);
        of.setBounds(3*this.getWidth()/10-120, 3*this.getHeight()/4+50, 100, 25);
		oot.setBounds(5*this.getWidth()/10-70, 3*this.getHeight()/4+50, 60, 25);
		tf.setBounds(5*this.getWidth()/10+10, 3*this.getHeight()/4+50, 100, 25);
		xjjsd.addActionListener(new ActionListener(){
         
			public void actionPerformed(ActionEvent e) {
				int a=jcb.getSelectedIndex();
				switch(a){
				case 0:{new InvoiceUI_RecivalList(vo);break;}
				case 1:{new InvoiceUI_LoadingListZZ(vo);break;}
				case 2:{new InvoiceUI_TransferList(vo);break;}
				default :{}
				}
				
			}	
		});
		find.addActionListener(new ActionListener(){
		  
			public void actionPerformed(ActionEvent e) { 
				int a=jcb.getSelectedIndex();
				switch(a){
				case 0:{new InvoiceUI_RecivalListFind();break;}
				case 1:{new InvoiceUI_LoadingListZZFind();break;}
				case 2:{new InvoiceUI_TransferListFind();break;}
				default :{}
				}			
			}		
		});
		
		back.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		
		oin.addMouseListener(new MouseAdapter(){
		Storage storage=new Storage();
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==2) {
				 try {
						if(of.getText().length()!=10)  JOptionPane.showMessageDialog(contentPane,"订单编号格式错误" );
					else	if(storage.orderhasIN(of.getText()))  JOptionPane.showMessageDialog(contentPane,"该订单已存在" );
					else	{storage.setIn(of.getText()); JOptionPane.showMessageDialog(contentPane,"已告知仓库管理员" );of.setText("");}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}catch( IOException e1){
					e1.printStackTrace();
				}
				}
			}
			
		});
		oot.addMouseListener(new MouseAdapter(){
		Storage storage=new Storage();
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==2) {
				 try {
						if(tf.getText().length()!=10)  JOptionPane.showMessageDialog(contentPane,"订单编号格式错误" );
					else	if(!storage.orderhasIN(tf.getText()))  JOptionPane.showMessageDialog(contentPane,"该订单不存在" );
					else	 { storage.setOut(tf.getText());JOptionPane.showMessageDialog(contentPane,"已告知仓库管理员" );tf.setText("");}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}catch(  IOException e1){
					e1.printStackTrace();
				}
				}
			}
			
		});
		final JLabel time=new JLabel();
	    time.setFont(new Font("Serif",Font.BOLD,15));	    
	    user.add(time);	    
	    time.setBounds(this.getWidth()/3,this.getHeight()-60,200,40);
		
	    Timer timer = new Timer(100,new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
				time.setText(sdf.format(new Date()));				

			}
	    	
	    });
	    timer.start();
	}

	protected void setrows() {
		int a=jcb.getSelectedIndex();
		model.removeAllRows(model.getRowCount());
		try {
			RecivalListBL rl=new RecivalListBL();
			LoadingListZZBL zc=new LoadingListZZBL();
			TransferListBL tl=new TransferListBL();
		switch(a){	
		case 0:{
				String[] title_name = { "ID", "单据状态","制表人","装车时间","所属中转中心","出发地","货物到达状态"};
				model=new TableModel(title_name);
				table.setModel(model);
				ArrayList<RecivalListVO> arr0 = rl.findByMaker(voa.getId());
				for(RecivalListVO vo:arr0)		model.addRow(model.newchangeRow_Rcl(vo));	
				break;
				}
			case 1:{
				String[] title_name = { "ID", "单据状态","制表人","装车时间","所属中转中心","到达地","运费"};
				model=new TableModel(title_name);
				table.setModel(model);
				ArrayList<LoadingListZZVO> arr1 = zc.findByMaker(voa.getId());
				for(LoadingListZZVO vo:arr1)		model.addRow(model.newchangeRow_Lolzz(vo));	
				break;
				}

			case 2:{
				String[] title_name = { "ID", "单据状态","制表人","装车时间","所属中转中心","出发地","到达地","运费"};
				model=new TableModel(title_name);
				table.setModel(model);
				ArrayList<TransferListVO> arr2 = tl.findByMaker(voa.getId());
				for(TransferListVO vo:arr2)		model.addRow(model.newchangeRow_Trl(vo));	
				break;
				}	
		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		table.updateUI();	
	}
	
}
