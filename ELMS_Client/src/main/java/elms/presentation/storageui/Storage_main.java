package elms.presentation.storageui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

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
	JMenu m=new JMenu("库存初始化");
	bar.add(j);
	bar.add(m);
	setJMenuBar(bar);
  m.addMenuListener(new MenuListener(){

	public void menuCanceled(MenuEvent e) {
		
	}

	public void menuDeselected(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void menuSelected(MenuEvent e) {
		//Storage_main.this.dispose();
		setVisible(false);
		new Storage_init(vo);
		
		
	}

  
  });
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
	JMenu j1=new Menu("ID       ");JMenu j2=new Menu("区域       ");JMenu j3=new Menu("位置         ");JMenu j4=new Menu("订单号              ");
	JMenu j5=new Menu("入库时间                   ");JMenu j6=new Menu("出库时间              ");JMenu j7=new Menu("状态        ");JMenu j8=new Menu("仓库             ");
	jbar.add(j1);jbar.add(j2);jbar.add(j3);jbar.add(j4);jbar.add(j5);jbar.add(j6);jbar.add(j7);jbar.add(j8);
	add(jbar);jbar.setBounds(5, 48, this.getWidth(), 20);
    add(info2); info2.setBounds(0,0,this.getWidth(),this.getHeight()/2);
    
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
    JButton dxcx=new JButton("单项查询(Q)");
    JButton fscx=new JButton("分时查询(T)");
    JButton zbdy=new JButton("制表打印(P)");
    JButton refresh=new JButton("刷新(R)");refresh.setForeground(Color.GREEN);
    JButton back=new JButton("返回(B)");back.setForeground(Color.red);
    JPanel buttonPal=new JPanel();buttonPal.setLayout(null);
    buttonPal.add(xzrk); buttonPal.add(dxcx); buttonPal.add(fscx); buttonPal.add(zbdy); buttonPal.add(refresh); buttonPal.add(back);
    xzrk.setBounds(10, 30, 102, 30);dxcx.setBounds(130, 30, 104, 30); fscx.setBounds(250, 30, 102, 30); zbdy.setBounds(370, 30, 102, 30);
    refresh.setBounds(560,15,80,30);  back.setBounds(560,55,80,30);
    add(buttonPal);
    buttonPal.setBounds(0,this.getHeight()/2+100,this.getWidth()-30,90);
    buttonPal.setBorder(BorderFactory.createTitledBorder("库存操作"));
    
    xzrk.addActionListener(new ActionListener(){

		public void actionPerformed(ActionEvent e) {
			new Storage_newStorage();
		}
    	
    });
    dxcx.addActionListener(new ActionListener(){

		public void actionPerformed(ActionEvent e) {
			new Storage_findsingle();
		}
    	
    });
    fscx.addActionListener(new ActionListener(){

		public void actionPerformed(ActionEvent e) {
			new Storage_findtime();
		}
    	
    });
    
    refresh.addActionListener(new ActionListener(){

		public void actionPerformed(ActionEvent e) {
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
    time.setFont(new Font("Serif",Font.BOLD,15));
    tp.add(time);
    add(tp);
    tp.setBounds(0,this.getHeight()-80,this.getWidth(),40);
    
    Timer timer = new Timer(100,new ActionListener(){

		public void actionPerformed(ActionEvent arg0) {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   	
			time.setText(sdf.format(new Date()));
		}
    	
    });
    timer.start();
}
}
