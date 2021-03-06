package elms.presentation.storageui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import elms.businesslogic.storagebl.Storage;
import elms.vo.StorageVO;
import elms.vo.UserVO;

public class Storage_init extends JFrame{
	
	Toolkit kit=Toolkit.getDefaultToolkit();
	Dimension screenSize=kit.getScreenSize();
	int screenWidth=(int) screenSize.getWidth();
	int screenHeight=(int)screenSize.getHeight();
	JTextArea text;
	Storage storage;
	String center=null;
	static ArrayList<StorageVO>  arr=new ArrayList<StorageVO>();
public Storage_init(final UserVO vo){
	
	setLayout(null);
	setTitle("库存初始化");
	setResizable(false);
	setSize(screenWidth/2,screenHeight/2-60);
	setLocation(screenWidth/4, screenHeight/8);
	setVisible(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	JMenuBar bar=new JMenuBar();
	JMenu j=new JMenu("库存管理");
	JMenu m=new JMenu("库存初始化");m.setSelected(true);m.setEnabled(false);
	bar.add(j);
	bar.add(m);
	setJMenuBar(bar);
	j.addMenuListener(new MenuListener(){

		public void menuCanceled(MenuEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void menuDeselected(MenuEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void menuSelected(MenuEvent e) {
			Storage_init.this.dispose();
			new Storage_main(vo);

		}
		
	});
	
	JPanel info2=new JPanel();
	info2.setLayout(null);
	text=new JTextArea(8,10);
	text.setEditable(false);
	text.setFont(new Font("Serif",Font.PLAIN,14));
    
	JScrollPane scrollpane=new JScrollPane(text);
	info2.add(scrollpane);
	scrollpane.setBounds(5,0,screenWidth/2-30,3*screenHeight/10-70);
	
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
	add(jbar);jbar.setBounds(5, 3, this.getWidth(), 20);
    add(info2); info2.setBounds(0,20,screenWidth/2,screenHeight/5+10);
    info2.setBorder(BorderFactory.createTitledBorder("新建库存"));
    
    final JComboBox<String> jcb=new JComboBox<String>();
	jcb.addItem("北京");jcb.addItem("南京");jcb.addItem("上海");jcb.addItem("广州");
	jcb.setBackground(Color.white);jcb.setFont(new Font("楷体",Font.CENTER_BASELINE,12));
	add(jcb); jcb.setBounds(3*screenWidth/7+10, screenHeight/5+25, 60, 25);
	
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
	JButton add=new JButton("添加库存项");JButton delete=new JButton("修改库存项");JButton back=new JButton("返回");
	add(add);add.setBounds(screenWidth/12, screenHeight/4+20, 100, 28);
	add(delete);delete.setBounds(screenWidth/5, screenHeight/4+20, 100, 28);
	add(back);back.setBounds(screenWidth/3, screenHeight/4+20, 100, 28);
	
	add.addActionListener(new ActionListener(){

		public void actionPerformed(ActionEvent e) {
			new Storage_newStorage();
		}
    	
    });
	delete.addActionListener(new ActionListener(){

		public void actionPerformed(ActionEvent arg0) {
		new Storage_findsingle();
			
		}
		
	});
	back.addActionListener(new ActionListener(){

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			System.exit(0);
		}
		
	});

	
}
}
