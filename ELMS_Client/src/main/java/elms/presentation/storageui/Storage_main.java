package elms.presentation.storageui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.table.TableColumnModel;

import elms.businesslogic.financebl.InitAll;
import elms.businesslogic.storagebl.Storage;
import elms.presentation.uihelper.MyButton;
import elms.presentation.uihelper.MyPanel;
import elms.vo.StorageVO;
import elms.vo.UserVO;

public class Storage_main extends JFrame{
Toolkit kit=Toolkit.getDefaultToolkit();
Dimension screenSize=kit.getScreenSize();
int screenWidth=(int) screenSize.getWidth();
int screenHeight=(int)screenSize.getHeight();
JTextArea text;
int button=40;
public static TableModel model;
public static JTable table;
final JComboBox<String> jcb;
static JPanel user;
String center=null;

public static ArrayList<StorageVO>  arr=new ArrayList<StorageVO>();

/* 
 * 表示待处理入库出库订单  其中String是入库出库商品的订单号
 * 中转中心业务员在本地设置自己的两个Array  并为其设置get方法
* 	两个ArrayList表示需要被中转中心库存管理员操作的项目
 * = 由中转中心库存管理员get数据  进行入库出库操作  并清空ins  outs  
 * 采用time间隔询问是否有新的入库出库请求 
 */
//
/*
 * 本地在在入库出库后 在这里添加库存项    并为为中转中心业务员设置了get方法
 * 中转中心业务员在get了ino outo后  根据其中内容生成相应的入库单出库单
 * 并将ino  outo清空  等待中转中心库存管理员更新ino  outo后  再读取新的ino  outo
 */
public static ArrayList<StorageVO>  ino=new ArrayList<StorageVO>();//
public static ArrayList<StorageVO>  outo=new ArrayList<StorageVO>();


public static void main(String args[]){
	EventQueue.invokeLater(new Runnable(){
		public void run(){
				UserVO vo=new UserVO();
				JFrame storage=new Storage_main(vo);

		}
	});

}
public Storage_main(final UserVO vo){
	setLayout(null);
	setTitle("库存管理");
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
	setVisible(true);

	
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
	
	final JButton gl = new MyButton("库存管理",20);
	gl.setEnabled(false);
	gl.setForeground(Color.gray);
	gl.setBounds(0,0,200,(int) (1.5*button));
	buttonPanel.add(gl);	
	
	final JButton ini = new MyButton("库存初始化",15);
	ini.setBounds(0,(int) (1.5*button),200,button);
	buttonPanel.add(ini);
	
	gl.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			int a=(int)(Math.random()*10000);
	    	String s=a+"";
	    	
	    	String obj=JOptionPane.showInputDialog(contentPane,"请输入 验证码  "+a+" 确认初始化完成");
			if(obj!=null){
					if(obj.equals(s)){
			gl.setFont(new Font("宋体",1,20));
			gl.setForeground(Color.gray);gl.setBounds(0,0,200,(int) (1.5*button));
			ini.setFont(new Font("宋体",1,15));
			ini.setForeground(Color.black);ini.setBounds(0,(int) (1.5*button),200,button);
			ini.setEnabled(true);
			gl.setEnabled(false);
			InitAll ia=new InitAll();
			try {
				ia.setInitState(3);
				JOptionPane.showMessageDialog(contentPane, "库存已新建", null, 2);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}}
			
			else  JOptionPane.showMessageDialog(contentPane, "验证码错误！",null,0);
		}
		}
	});
	

	
	ini.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			int a=(int)(Math.random()*10000);
	    	String s=a+"";
	    	
	    	String obj=JOptionPane.showInputDialog(contentPane,"请输入 验证码  "+a+" 确认初始化库存");
			if(obj!=null){
					if(obj.equals(s)){
			gl.setFont(new Font("宋体",1,15));
			gl.setForeground(Color.black);gl.setBounds(0,0,200,button);
			ini.setFont(new Font("宋体",1,20));
			ini.setForeground(Color.gray);ini.setBounds(0,button,200,(int) (1.5*button));
			ini.setEnabled(false);
			gl.setEnabled(true);
			Storage storage=new Storage();
			try {
				storage.init();
				JOptionPane.showMessageDialog(contentPane, "初始化库存成功", null, 2);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}}
			
			else  JOptionPane.showMessageDialog(contentPane, "验证码错误！",null,0);
		}
		}
	});

	JLabel jl=new JLabel(" 当前用户：  "+vo.getName()+"  身份：  "+vo.getJob()+"  编号   "+vo.getId());
	user=new JPanel(); user.setLayout(null);
	user.add(jl);jl.setBounds(200, 0, this.getWidth(), 25);
	user.setBounds(200, 0, this.getWidth()-200,this.getHeight());	
	contentPane.add(user);
	user.setOpaque(false);

	String[] title_name = { "ID", "区域", "位置", "订单号", "入库时间", "出库时间","状态","仓库"};
			model = new TableModel(title_name);
			table = new JTable(model);

		    table.addMouseListener(new MouseAdapter(){
		        Storage storage=new Storage();
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					if(e.getClickCount()==2) {
						if(table.getSelectedColumn()!=-1){
						String	s=(String) model.getValueAt(table.getSelectedRow(), 3);
						StorageVO vo;
						try {
							vo = storage.inquiry(s);
						if(vo!=null){
							new Storage_editStorage(vo,false);		
						}
						else {
							JOptionPane.showMessageDialog(null, "订单编号: "+s+" 已删除");
						}
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}					
						
							;}
					}	
				}
		    	
		    });
			table.setBackground(Color.white);
			TableColumnModel tcm = table.getColumnModel();
			tcm.getColumn(7).setPreferredWidth(this.getWidth()/3);
			tcm.getColumn(6).setPreferredWidth(this.getWidth()/15);
			tcm.getColumn(5).setPreferredWidth(4*this.getWidth()/18);	
			tcm.getColumn(4).setPreferredWidth(4*this.getWidth()/18);
			tcm.getColumn(3).setPreferredWidth(2*this.getWidth()/15);
			tcm.getColumn(2).setPreferredWidth(this.getWidth()/15);
			tcm.getColumn(1).setPreferredWidth(this.getWidth()/15);
			tcm.getColumn(0).setPreferredWidth(this.getWidth()/15);  
			JScrollPane scrollpane=new JScrollPane(table);
			user.add(scrollpane);
			scrollpane.setBounds(-1,70,this.getWidth()-40,this.getHeight()/2-70);
            scrollpane.setOpaque(false);scrollpane.getViewport().setOpaque(false);
    
    /*
     * 选择中转中心城市
     */
    jcb=new JComboBox<String>();
	jcb.addItem("北京");jcb.addItem("南京");jcb.addItem("上海");jcb.addItem("广州");
	jcb.setBackground(Color.white);jcb.setFont(new Font("楷体",Font.CENTER_BASELINE,12));
	user.add(jcb); jcb.setBounds(8*user.getWidth()/9, user.getHeight()/2,user.getWidth()/9 , 25);jcb.setOpaque(false);
	
	jcb.addActionListener(new ActionListener(){
       Storage storage=new Storage();
    
		public void actionPerformed(ActionEvent e) { 
			center=jcb.getSelectedItem().toString();
			model.removeAllRows(model.getRowCount());
				try {					
					arr=storage.inquiryAll(center);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for(StorageVO svo:arr)  {					
					model.addRow(model.changeRow(svo));
				}					
				table.updateUI();
		}	
		});

 
    JButton xzrk=new JButton("新增入库(A)");
    JButton find=new JButton("库存查询(S)");
    JButton zbdy=new JButton("制表打印(P)");
    JButton refresh=new JButton("刷新(R)");
    JButton back=new JButton("返回(B)");back.setForeground(Color.red);
    JPanel buttonPal=new JPanel();buttonPal.setLayout(null);buttonPal.setOpaque(false);
    buttonPal.add(xzrk); buttonPal.add(find); buttonPal.add(zbdy); buttonPal.add(refresh); buttonPal.add(back);
    xzrk.setBounds(30, 30, 102, 30);find.setBounds(190, 30, 104, 30);  zbdy.setBounds(350, 30, 102, 30);
    refresh.setBounds(560,15,80,30);  back.setBounds(560,55,80,30);
    user.add(buttonPal);
    buttonPal.setBounds(-1,this.getHeight()/2+40,user.getWidth()+2,90);
    
    xzrk.addActionListener(new ActionListener(){

		public void actionPerformed(ActionEvent e) {
		new Storage_newStorage();
			
		}
    	
    });
   find.addActionListener(new ActionListener(){

		public void actionPerformed(ActionEvent e) {
			new Storage_find();
		}
    	
    });
    
   zbdy.addActionListener(new ActionListener(){
  Storage storage=new Storage();
  String k; 
  List<StorageVO>  temp=new ArrayList<StorageVO>();
	public void actionPerformed(ActionEvent arg0) {
		if(arr.size()==0)  JOptionPane.showMessageDialog(null, "没有制表打印内容！","错误",0);
		else {
		if(arr.get(0).getId().equals("在库查询")) {temp=arr.subList(1,arr.size()-1); k="在库查询";}
		else if(arr.get(0).getId().equals("---------------这段时间内入库的-----------------")){temp=arr.subList(1,arr.size()-1); k="分时查询";}
		else{ k="历史库存";temp=arr;}
		
		try {
			storage.paint(temp, center+k);
			JOptionPane.showMessageDialog(null, "已生成库存报表");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
	}
	   
   });
   
   
    refresh.addActionListener(new ActionListener(){

		public void actionPerformed(ActionEvent e) {
			ArrayList<StorageVO>  temp=new ArrayList<StorageVO>();
			temp=arr;
		if(arr.size()!=0)
		jcb.setSelectedItem(arr.get(0).getName());
	    	arr=temp;
			model.removeAllRows(model.getRowCount());
			for(StorageVO svo:arr){
				model.addRow(model.changeRow(svo));
					}
			table.updateUI();}
    });
    
    back.addActionListener(new ActionListener(){

		public void actionPerformed(ActionEvent e) {
				System.exit(0);
		}
    	
    });
    final JLabel time=new JLabel();
    final JLabel in=new JLabel();
    final JLabel out=new JLabel();
    in.addMouseListener(new MouseAdapter(){
    	public void mouseClicked(MouseEvent e) {
    		if(e.getClickCount()==2) {
    			user.setBounds(-screenWidth, 0, user.getWidth(), user.getHeight());
    			Storage_in sin=new Storage_in(vo);
    			contentPane.add(sin);
    			sin.setBounds(200,0,screenWidth*2/3,screenHeight*3/4);
    			
    		}
    	}
    });
    out.addMouseListener(new MouseAdapter(){
    	public void mouseClicked(MouseEvent e) {
    		if(e.getClickCount()==2) {
    			user.setBounds(-screenWidth, 0, user.getWidth(), user.getHeight());
    			Storage_out sout=new Storage_out(vo);
    			contentPane.add(sout);
    			sout.setBounds(200,0,screenWidth*2/3,screenHeight*3/4);
    			
    		}
    	}
    });
    
    time.setFont(new Font("Serif",Font.BOLD,15));
    user.add(in);in.setBounds(25, 3*this.getHeight()/4, 120, 25);
    user.add(time); time.setBounds(5*user.getWidth()/12, user.getHeight()-50, user.getWidth()/3, 25);
    user.add(out);out.setBounds(25, 3*this.getHeight()/4+50, 120, 25);
    Timer timer = new Timer(100,new ActionListener(){
       InitAll i=new InitAll();
       Storage storage=new Storage();
		public void actionPerformed(ActionEvent arg0) {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				in.setText("入库待处理项： "+storage.getallin().size());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				if(i.getInitState(3))
				time.setText("需要初始化！");
				else
				time.setText(sdf.format(new Date()));	
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				out.setText("出库待处理项： "+storage.getallout().size());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
    	
    });
    timer.start();
}
}
