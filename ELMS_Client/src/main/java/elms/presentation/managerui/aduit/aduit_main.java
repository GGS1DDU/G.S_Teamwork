package elms.presentation.managerui.aduit;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Timer;

public class aduit_main extends JFrame{
	Toolkit kit=Toolkit.getDefaultToolkit();
	Dimension screenSize=kit.getScreenSize();
	int screenWidth=(int) screenSize.getWidth();
	int screenHeight=(int)screenSize.getHeight();
	JTextArea text;
	JComboBox<String> jcb;
	public static void main(String[] args) {
		new aduit_main();
	}
	
	public aduit_main(){
		setLayout(null);
		setTitle("审批单据");
		setResizable(false);
		setSize(screenWidth/2,screenHeight/2);
		setLocation(screenWidth/4, screenHeight/8);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JMenuBar jbar=new JMenuBar(); 
		
		class Menu extends JMenu{
			public Menu(String s){
				super();
				this.setFont(new Font("楷体",Font.CENTER_BASELINE,12));
			}
		}
		final Menu j1=new Menu("");final Menu j2=new Menu("");final Menu j3=new Menu("");final Menu j4=new Menu("");final Menu j5=new Menu("");
		final Menu j6=new Menu("");final Menu j7=new Menu("");final Menu j8=new Menu("");final Menu j9=new Menu("");final Menu j10=new Menu("");
		jbar.add(j1);jbar.add(j2);jbar.add(j3);jbar.add(j4);jbar.add(j5);jbar.add(j6);jbar.add(j7);jbar.add(j8);
		jbar.add(j9);jbar.add(j10);
		add(jbar);jbar.setBounds(0,0,this.getWidth(),25);
		j1.setText("审批单据");
		
		
		
		JPanel info2=new JPanel();
		info2.setLayout(null);
		text=new JTextArea(10,10);
		text.setEditable(false);
		text.setFont(new Font("Serif",Font.PLAIN,14));
	    	text.append("23333");
		JScrollPane scrollpane=new JScrollPane(text);
		info2.add(scrollpane);
		scrollpane.setBounds(5,0,this.getWidth()-15,2*this.getHeight()/3-70);
		 add(info2); info2.setBounds(0,30,this.getWidth(),2*this.getHeight()/3-70);
		 
		 jcb=new JComboBox<String>();
		 jcb.addItem("所有单据"); jcb.addItem("到达单"); jcb.addItem("营业厅收入单");jcb.addItem("营业厅装车单");jcb.addItem("中转中心装运单");
		 jcb.addItem("中转中心到达单"); jcb.addItem("快递员派件单");jcb.addItem("库存变化单");jcb.addItem("中转中心中转单");
		 jcb.setBackground(Color.white);jcb.setFont(new Font("楷体",Font.CENTER_BASELINE,12));
		add(jcb); jcb.setBounds(3*this.getWidth()/4+30, 2*this.getHeight()/3-40, 120, 25);
		
		jcb.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0) {
				int a=jcb.getSelectedIndex();
				switch(a){
				case 0: {j1.setText("单据类型");j2.setText("ID");j3.setText("");j4.setText("");j5.setText("");
				j6.setText("");j7.setText("");j8.setText("");j9.setText("");j10.setText("");break;}
				case 1: {j1.setText("ID        ");j2.setText("中转单编号 ");j3.setText("到达时期");j4.setText("到达状态");j5.setText("出发地");
				j6.setText("");j7.setText("");j8.setText("");j9.setText("");j10.setText("");break;}
				case 2:{j1.setText("ID        ");j2.setText("收费金额");j3.setText("快递员姓名");j4.setText("收款日期");j5.setText("");
				j6.setText("");j7.setText("");j8.setText("");j9.setText("");j10.setText("");break;}
				case 3:{j1.setText("ID        ");j2.setText("装车日期");j3.setText("本营业厅编号");j4.setText("汽运编号");j5.setText("到达地");
				        j6.setText("车辆代号");j7.setText("监装员");j8.setText("押运员");j9.setText("订单条形号码"); j10.setText("运费");  break;          }
				case 4:{j1.setText("ID        ");j2.setText("装车日期");j3.setText("");j4.setText("汽运编号");j5.setText("到达地");
		        j6.setText("车辆代号");j7.setText("监装员");j8.setText("押运员");j9.setText("订单条形号码"); j10.setText("运费");  break;     }
				case 5:{j1.setText("ID        ");j2.setText("装车日期 ");j3.setText("中转中心编号");j4.setText("中转单编号");j5.setText("出发地");
				j6.setText("货物到达状态");j7.setText("");j8.setText("");j9.setText("");j10.setText("");break;}
				case 6:{j1.setText("ID        ");j2.setText("托运订单条形号码 ");j3.setText("派送员");j4.setText("到达日期");j5.setText("");
				j6.setText("");j7.setText("");j8.setText("");j9.setText("");j10.setText("");break;}
				case 7:{j1.setText("ID        ");j2.setText("分区");j3.setText("位置");j4.setText("订单编号");j5.setText("入库时间");
				j6.setText("出库时间");j7.setText("状态");j8.setText("中转中心");j9.setText("");j10.setText("");break;}
				case 8:{j1.setText("ID        ");j2.setText("装车日期");j3.setText("中转单编号");j4.setText("航班号/车次号");j5.setText("出发地");
				        j6.setText("到达地");j7.setText("货柜号");j8.setText("监装员");j9.setText("托运订单");j10.setText("运费");break;}
				
				}
				
			}
			
		});
		
		JPanel jp=new JPanel();jp.setLayout(null);
		add(jp);jp.setBounds(0,2*this.getHeight()/3,this.getWidth(),60);
		jp.setBorder(BorderFactory.createTitledBorder("审批操作"));
		
		JButton dxsp=new JButton("单项审批");
		JButton yjsp=new JButton("一键审批");
		jp.add(dxsp);jp.add(yjsp);
		dxsp.setBounds(this.getWidth()/5,20,100,30);
		yjsp.setBounds(3*this.getWidth()/5,20,100,30);
		
		dxsp.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				new aduit_single();			}
			
		});
		
		
		
		
		final JLabel time=new JLabel();    time.setFont(new Font("Serif",Font.BOLD,15));
		 add(time);time.setBounds(this.getWidth()/3+30,this.getHeight()-55,200,30);		   
		    Timer timer = new Timer(100,new ActionListener(){

				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					time.setText(sdf.format(new Date()));	
				}
	});	    timer.start();

}}
