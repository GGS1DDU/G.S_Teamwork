package elms.presentation.storageui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JTextArea;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import elms.businesslogic.financebl.InitAll;
import elms.businesslogic.storagebl.Storage;
import elms.vo.StorageVO;
import elms.vo.UserVO;

public class Storage_main extends JFrame{
Toolkit kit=Toolkit.getDefaultToolkit();
Dimension screenSize=kit.getScreenSize();
int screenWidth=(int) screenSize.getWidth();
int screenHeight=(int)screenSize.getHeight();
JTextArea text;
final JComboBox<String> jcb;

String center=null;

public static ArrayList<StorageVO>  arr=new ArrayList<StorageVO>();

/* 
 * 表示待处理入库出库订单  其中String是入库出库商品的订单号
 * 中转中心业务员在本地设置自己的两个Array  并为其设置get方法
* 	两个ArrayList表示需要被中转中心库存管理员操作的项目
 * = 由中转中心库存管理员get数据  进行入库出库操作  并清空ins  outs  
 * 采用time间隔询问是否有新的入库出库请求 
 */
public static ArrayList<String>  ins=new ArrayList<String>();
public static ArrayList<String>  outs=new ArrayList<String>();//
/*
 * 本地在在入库出库后 在这里添加库存项    并为为中转中心业务员设置了get方法
 * 中转中心业务员在get了ino outo后  根据其中内容生成相应的入库单出库单
 * 并将ino  outo清空  等待中转中心库存管理员更新ino  outo后  再读取新的ino  outo
 */
public static ArrayList<StorageVO>  ino=new ArrayList<StorageVO>();//
public static ArrayList<StorageVO>  outo=new ArrayList<StorageVO>();

public static ArrayList<StorageVO>  getStorageInList(){
	return ino;
}
public static void  clearStorageInList(){
	ino.clear();
}
public static ArrayList<StorageVO>  getStorageOutList(){
	return outo;
}
public static void  clearStorageOutList(){
	outo.clear();
}


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
	setSize(screenWidth/2,3*screenHeight/4);
	setLocation(screenWidth/4, screenHeight/8);
	setVisible(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	JMenuBar bar=new JMenuBar();
	JMenu j=new JMenu("库存管理");
	j.setSelected(true);j.setEnabled(false);
	final JMenu m=new JMenu("库存初始化");
	bar.add(j);
	bar.add(m);
	setJMenuBar(bar);
	
	/*
	 * 给菜单加监听  在菜单处选择初始化库存  
	 * 初始化需要确认工作  
	 * 界面提示输入一个随机生成的三位数  
	 * 只有当用户正确的输入了验证码  才能够初始化库存  
	 * 进入库存初始化界面
	 */
  m.addMenuListener(new MenuListener(){

	public void menuCanceled(MenuEvent e) {
		
	}

	public void menuDeselected(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void menuSelected(MenuEvent e){
    	int a=(int)(Math.random()*1000);
    	String s=a+"";
    	
    	String obj=JOptionPane.showInputDialog("请输入 验证码  "+a+" 确认初始化库存");
		if(obj.equals(s)){
		Storage_main.this.dispose();
		new Storage_init(vo);
		Storage storage=new Storage();
		try {
			storage.init();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}
		else  JOptionPane.showMessageDialog(null, "验证码错误！",null,0);
			}
	

  
  });
  /*
   * 界面创建时传入当前用户身份   在界面上可以显示当前用户的姓名、身份、和员工编号
   */
	JLabel jl=new JLabel("  当前用户：  "+vo.getName()+"  身份：  "+vo.getJob()+"  编号   "+vo.getId());
	jl.setForeground(Color.lightGray);
	JPanel user=new JPanel();
	user.add(jl);
	user.setBounds(0, 0, this.getWidth(),25);	
	
	Border li=BorderFactory.createEtchedBorder();
	Border t=BorderFactory.createTitledBorder(li);
	Border l2=BorderFactory.createLoweredBevelBorder();
	user.setBorder(t);
	add(user);
	
	
    JLabel kcqd=new JLabel("库存清单");
	JPanel info=new JPanel();
	info.setLayout(new java.awt.BorderLayout()); 
	info.add(kcqd);
	info.setBounds(0, 23, 70,25);
	info.setBorder(l2);
	add(info);
	
	
	JPanel info2=new JPanel();
	info2.setLayout(null);
	text=new JTextArea(10,10);
	text.setEditable(false);
	text.setFont(new Font("Serif",Font.PLAIN,14));
    
	JScrollPane scrollpane=new JScrollPane(text);
	info2.add(scrollpane);
	scrollpane.setBounds(5,70,this.getWidth()-40,this.getHeight()/2-70);
	
	JMenuBar jbar=new JMenuBar(); 
	class Menu extends JMenu{
		public Menu(String s){
			super(s);
			this.setFont(new Font("楷体",Font.CENTER_BASELINE,12));
		}
	}
	
	/*
	 * 显示库存细节的项目与信息
	 */
	JMenu j1=new Menu("ID       ");JMenu j2=new Menu("区域       ");JMenu j3=new Menu("位置         ");JMenu j4=new Menu("订单号              ");
	JMenu j5=new Menu("入库时间                   ");JMenu j6=new Menu("出库时间              ");JMenu j7=new Menu("状态        ");JMenu j8=new Menu("仓库             ");
	jbar.add(j1);jbar.add(j2);jbar.add(j3);jbar.add(j4);jbar.add(j5);jbar.add(j6);jbar.add(j7);jbar.add(j8);
	add(jbar);jbar.setBounds(5, 48, this.getWidth(), 20);
    add(info2); info2.setBounds(0,0,this.getWidth(),this.getHeight()/2);
    
    /*
     * 选择中转中心城市
     */
    jcb=new JComboBox<String>();
	jcb.addItem("北京");jcb.addItem("南京");jcb.addItem("上海");jcb.addItem("广州");
	jcb.setBackground(Color.white);jcb.setFont(new Font("楷体",Font.CENTER_BASELINE,12));
	add(jcb); jcb.setBounds(5*this.getWidth()/6, this.getHeight()/2, 60, 25);
	
	jcb.addActionListener(new ActionListener(){
       Storage storage=new Storage();
       
		public void actionPerformed(ActionEvent e) {
				text.setText("");
				center=jcb.getSelectedItem().toString();
				try {
					arr=storage.inquiryAll(center);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for(StorageVO svo:arr)  {
					if(svo.getState().equals("OUT"))
					text.append(svo.getId()+"   "+svo.getArea()+"    "+svo.getSeat()+"    "+svo.getOrder()+"     "+svo.getTimeIn()+"    "+svo.getTimeOut()+"    "+svo.getState()+"\r\n");
					else
					text.append(svo.getId()+"   "+svo.getArea()+"    "+svo.getSeat()+"    "+svo.getOrder()+"     "+svo.getTimeIn()+"             "+svo.getTimeOut()+"                    "+svo.getState()+"\r\n");
				}
		}	
		});

 
    JButton xzrk=new JButton("新增入库(A)");
    JButton find=new JButton("库存查询(S)");
    JButton zbdy=new JButton("制表打印(P)");
    JButton refresh=new JButton("刷新(R)");refresh.setForeground(Color.GREEN);
    JButton back=new JButton("返回(B)");back.setForeground(Color.red);
    JPanel buttonPal=new JPanel();buttonPal.setLayout(null);
    buttonPal.add(xzrk); buttonPal.add(find); buttonPal.add(zbdy); buttonPal.add(refresh); buttonPal.add(back);
    xzrk.setBounds(30, 30, 102, 30);find.setBounds(190, 30, 104, 30);  zbdy.setBounds(350, 30, 102, 30);
    refresh.setBounds(560,15,80,30);  back.setBounds(560,55,80,30);
    add(buttonPal);
    buttonPal.setBounds(0,this.getHeight()/2+100,this.getWidth()-30,90);
    buttonPal.setBorder(BorderFactory.createTitledBorder("库存操作"));
    
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
			text.setText("");
			for(StorageVO svo:arr)
			if(svo.getState().equals("OUT"))
				text.append(svo.getId()+"   "+svo.getArea()+"    "+svo.getSeat()+"    "+svo.getOrder()+"     "+svo.getTimeIn()+"    "+svo.getTimeOut()+"    "+svo.getState()+"\r\n");
				else
				text.append(svo.getId()+"   "+svo.getArea()+"    "+svo.getSeat()+"    "+svo.getOrder()+"     "+svo.getTimeIn()+"             "+svo.getTimeOut()+"                    "+svo.getState()+"\r\n");
	
					}
    	
    });
    back.addActionListener(new ActionListener(){

		public void actionPerformed(ActionEvent e) {
				System.exit(0);
		}
    	
    });
    JPanel tp=new JPanel();
    final JLabel time=new JLabel();
    final JLabel in=new JLabel();
    final JLabel out=new JLabel();
    time.setFont(new Font("Serif",Font.BOLD,15));
    tp.add(in);
    tp.add(time);
    tp.add(out);
    add(tp);
    tp.setBounds(0,this.getHeight()-80,this.getWidth(),40);
    
    Timer timer = new Timer(100,new ActionListener(){
       InitAll i=new InitAll();
		public void actionPerformed(ActionEvent arg0) {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			in.setText("入库待处理项： "+ins.size()+"                 ");
			try {
				if(i.getInitState(3))
				time.setText("需要初始化！");
				else
				time.setText(sdf.format(new Date()));	
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			out.setText("            出库待处理项： "+outs.size());

		}
    	
    });
    timer.start();
}
}
