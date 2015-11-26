package elms.presentation.storageui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import elms.businesslogic.storagebl.Storage;
import elms.businesslogic.storagebl.StorageCapacity;
import elms.vo.StorageVO;

public class Storage_newStorage extends JFrame{
	Toolkit kit=Toolkit.getDefaultToolkit();
	Dimension screenSize=kit.getScreenSize();
	int screenWidth=(int) screenSize.getWidth();
	int screenHeight=(int)screenSize.getHeight();
	

public Storage_newStorage(){
	setLayout(null);
	setResizable(false);
	setTitle("入库新增");
	setBounds(screenWidth/4,screenHeight/4, screenWidth/3, 3*screenHeight/8);
	setVisible(true); 

	
	final JPanel newin=new JPanel();
	newin.setLayout(null);
	add(newin);newin.setBounds(0,0,this.getWidth(),3*this.getHeight()/5);
	newin.setBorder(BorderFactory.createTitledBorder(""));
	
	JLabel id=new JLabel("ID");
	newin.add(id);id.setBounds(20,20,20,20);
	final JTextField idf=new JTextField();idf.setFont(new Font("SansSerif",Font.PLAIN,12));
	newin.add(idf);idf.setBounds(90,20,100,24);idf.setHorizontalAlignment(SwingConstants.CENTER);
	
	JLabel area=new JLabel("分区");
	newin.add(area);area.setBounds(this.getWidth()/2,20,30,20);
	final JComboBox<String> jc=new JComboBox<String>();
	jc.addItem("航运区");jc.addItem("火车区");jc.addItem("汽运区");
	jc.setBackground(Color.white);jc.setFont(new Font("楷体",Font.CENTER_BASELINE,12));
	newin.add(jc);jc.setBounds(this.getWidth()/2+100, 20, 80, 24);
	
	JLabel seat=new JLabel("位置");
	newin.add(seat);seat.setBounds(15,60,30,20);
	final JTextField sef=new JTextField();sef.setFont(new Font("SansSerif",Font.PLAIN,12));
	newin.add(sef);sef.setBounds(90,60,100,24);sef.setHorizontalAlignment(SwingConstants.CENTER);
	
	JLabel order=new JLabel("订单编号");
	newin.add(order);order.setBounds(this.getWidth()/2-10,60,60,20);
	final JTextField orf=new JTextField();orf.setFont(new Font("SansSerif",Font.PLAIN,12));
	newin.add(orf);orf.setBounds(this.getWidth()/2+80,60,100,24);orf.setHorizontalAlignment(SwingConstants.CENTER);
	
	JLabel intime=new JLabel("入库时间");
	newin.add(intime);intime.setBounds(15,100,60,20);
	final JTextField itf=new JTextField();itf.setFont(new Font("Dialog",Font.CENTER_BASELINE,12));
	newin.add(itf);itf.setBounds(90,100,100,24);itf.setHorizontalAlignment(SwingConstants.CENTER);
	itf.addMouseListener(new MouseAdapter(){
   
		public void mouseClicked(MouseEvent e) {
			if(e.getClickCount()==2) {
				 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   	
				itf.setText(sdf.format(new Date()));
			}
		}
		
	});
	
	JLabel outtime=new JLabel("出库时间");
	newin.add(outtime);outtime.setBounds(this.getWidth()/2-10, 100, 60, 20);
	final JTextField otf=new JTextField("NULL");otf.setFont(new Font("Monospaced",Font.CENTER_BASELINE,12));
	newin.add(otf);otf.setBounds(this.getWidth()/2+80,100,100,24);otf.setHorizontalAlignment(SwingConstants.CENTER);
	otf.setEditable(false);
	
	JLabel state=new JLabel("状态");
	newin.add(state);state.setBounds(15, 140, 60, 20);
	JTextField sf=new JTextField("IN");sf.setFont(new Font("楷体",Font.BOLD,12));
	newin.add(sf);sf.setBounds(90,140,100,24);sf.setHorizontalAlignment(SwingConstants.CENTER);
	sf.setEditable(false);
	
	JLabel name=new JLabel("中转中心");
	newin.add(name);name.setBounds(this.getWidth()/2-10,140,60,20);
	final JComboBox<String> jcb=new JComboBox<String>();
	jcb.addItem("北京");jcb.addItem("南京");jcb.addItem("上海");jcb.addItem("广州");
	jcb.setBackground(Color.white);jcb.setFont(new Font("楷体",Font.CENTER_BASELINE,12));
	newin.add(jcb);jcb.setBounds(this.getWidth()/2+100, 140, 80, 24);
	
	JPanel buttonpanel=new JPanel();buttonpanel.setLayout(null);
	JButton save=new JButton("保存(S)");JButton cancel=new JButton("取消(C)");
	buttonpanel.add(save);buttonpanel.add(cancel);save.setBounds(this.getWidth()/2-140, 25, 100, 30);cancel.setBounds(this.getWidth()/2+30, 25, 100, 30);
	add(buttonpanel);buttonpanel.setBounds(0,3*this.getHeight()/5,this.getWidth(),70);
	
	save.addActionListener(new ActionListener(){
		Storage storage=new Storage();
		public void actionPerformed(ActionEvent arg0) {
			try {
				if(idf.getText().length()!=6||jc.getSelectedItem()==null||orf.getText().length()!=10||!itf.getText().matches("\\d{4}-\\d{1,2}-\\d{1,2}\\s\\d{2}:\\d{2}:\\d{2}")||jcb.getSelectedItem()==null)
					JOptionPane.showMessageDialog(null,"入库单格式错误");
				else if(storage.orderhasIN(orf.getText()))  JOptionPane.showMessageDialog(null, "该订单已存在");
				else {if(storage.storage_inChoose(jc.getSelectedItem().toString(), new StorageCapacity(jcb.getSelectedItem().toString()))==1){
			StorageVO vo=new StorageVO(idf.getText(),jc.getSelectedItem().toString(),sef.getText(),orf.getText(),itf.getText(),"null","IN",jcb.getSelectedItem().toString());
			JOptionPane.showMessageDialog(newin,"保存至"+jc.getSelectedItem().toString());
			storage.storage_inRecord(vo);
			Storage_newStorage.this.dispose();
				}
				else{
					StorageVO vo=new StorageVO(idf.getText(),"机动区",sef.getText(),orf.getText(),itf.getText(),"null","IN",jcb.getSelectedItem().toString());
					JOptionPane.showMessageDialog(newin,"保存至机动区");
					storage.storage_inRecord(vo);
					
					Storage_newStorage.this.dispose();	
				}}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
	});
	cancel.addActionListener(new ActionListener(){

		public void actionPerformed(ActionEvent arg0) {
			setVisible(false);
		}
		
	});
}
}
