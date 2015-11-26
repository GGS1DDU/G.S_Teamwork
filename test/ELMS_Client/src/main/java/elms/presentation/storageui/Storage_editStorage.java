package elms.presentation.storageui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.AbstractButton;
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
import elms.vo.StorageVO;

public class Storage_editStorage extends JFrame {
	StorageVO voall;
	Toolkit kit=Toolkit.getDefaultToolkit();
	Dimension screenSize=kit.getScreenSize();
	int screenWidth=(int) screenSize.getWidth();
	int screenHeight=(int)screenSize.getHeight();
	boolean Edit;
public StorageVO getVO(){
	return voall;
	
}
public Storage_editStorage(StorageVO vo,boolean edit){
	voall=vo;
	setLayout(null);
	setTitle("库存项     No:"+vo.getId());
	setResizable(false);
	setBounds(screenWidth/4,screenHeight/4, screenWidth/3, 3*screenHeight/8);
	setVisible(true);

	Edit=edit;

	
	int t1,t2,t3;
	if(voall.getArea().equals("航运区")) t1=0;
	else if(voall.getArea().equals("火车区")) t1=1;
	else if(voall.getArea().equals("汽运区")) t1=2;
	else t1=3;

	
	if(voall.getName().equals("北京"))t2=0;
	else if(voall.getName().equals("南京"))t2=1;
	else if(voall.getName().equals("上海"))t2=2;
	else t2=3;
	
	if(voall.getState().equals("IN"))t3=0;
	else if(voall.getState().equals("OUT"))t3=1;
	else if(voall.getState().equals("BROKEN"))t3=2;
	else t3=3;
	
	
	
	
	final JPanel newin=new JPanel();
	newin.setLayout(null);
	add(newin);newin.setBounds(0,0,this.getWidth(),3*this.getHeight()/5);
	newin.setBorder(BorderFactory.createTitledBorder(""));
	
	JLabel id=new JLabel("ID");
	newin.add(id);id.setBounds(20,20,20,20);
	final JTextField idf=new JTextField(vo.getId());idf.setFont(new Font("SansSerif",Font.PLAIN,12));
	newin.add(idf);idf.setBounds(90,20,100,24);idf.setEditable(Edit);idf.setHorizontalAlignment(SwingConstants.CENTER);
	
	JLabel area=new JLabel("分区");
	newin.add(area);area.setBounds(this.getWidth()/2,20,30,20);final JComboBox<String> jc=new JComboBox<String>();
	if(Edit){
	jc.addItem("航运区");jc.addItem("火车区");jc.addItem("汽运区");jc.addItem("机动区");	
	jc.setBackground(Color.white);jc.setFont(new Font("楷体",Font.CENTER_BASELINE,12));
	newin.add(jc);jc.setBounds(this.getWidth()/2+100, 20,80, 24);
	jc.setSelectedIndex(t1);
	}
	else{
		JLabel jl=new JLabel(vo.getArea());jl.setBackground(Color.white);jl.setFont(new Font("楷体",Font.CENTER_BASELINE,12));
		newin.add(jl);jl.setBounds(this.getWidth()/2+100, 20, 60, 24);
	}
	
	
	JLabel seat=new JLabel("位置");
	newin.add(seat);seat.setBounds(15,60,30,20);
	final JTextField sef=new JTextField(vo.getSeat());sef.setFont(new Font("SansSerif",Font.PLAIN,12));
	newin.add(sef);sef.setBounds(90,60,100,24);sef.setEditable(Edit);sef.setHorizontalAlignment(SwingConstants.CENTER);
	
	JLabel order=new JLabel("订单编号");
	newin.add(order);order.setBounds(this.getWidth()/2-10,60,60,20);
	final JTextField orf=new JTextField(vo.getOrder());orf.setFont(new Font("SansSerif",Font.PLAIN,12));
	newin.add(orf);orf.setBounds(this.getWidth()/2+80,60,100,24);orf.setEditable(false);orf.setHorizontalAlignment(SwingConstants.CENTER);
	
	JLabel intime=new JLabel("入库时间");
	newin.add(intime);intime.setBounds(15,100,60,20);
	final JTextField itf=new JTextField(vo.getTimeIn());itf.setFont(new Font("Dialog",Font.CENTER_BASELINE,12));
	newin.add(itf);itf.setBounds(80,100,120,24);itf.setEditable(Edit);itf.setHorizontalAlignment(SwingConstants.CENTER);
	if(Edit){itf.addMouseListener(new MouseAdapter(){

		public void mouseClicked(MouseEvent e) {
			if(e.getClickCount()==2) {
				 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   	
				itf.setText(sdf.format(new Date()));
			}
		}
		
	});}
	
	JLabel outtime=new JLabel("出库时间");
	newin.add(outtime);outtime.setBounds(this.getWidth()/2-10, 100, 60, 20);
	final JTextField otf=new JTextField(vo.getTimeOut());otf.setFont(new Font("Monospaced",Font.CENTER_BASELINE,12));
	newin.add(otf);otf.setBounds(this.getWidth()/2+70,100,120,24);
	otf.setEditable(Edit);otf.setHorizontalAlignment(SwingConstants.CENTER);
	if(Edit){
	otf.addMouseListener(new MouseAdapter(){

		public void mouseClicked(MouseEvent e) {
			if(e.getClickCount()==2) {
				 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   	
				otf.setText(sdf.format(new Date()));
			}
		}
		
	});}
	
	JLabel state=new JLabel("状态");
	newin.add(state);state.setBounds(15, 140, 60, 20);final JComboBox<String> jcs=new JComboBox<String>();
	if(Edit){
		
		jcs.addItem("IN");jcs.addItem("OUT");jcs.addItem("BROKEN");jcs.addItem("DISAPPEAR");
		jcs.setBackground(Color.white);jcs.setFont(new Font("楷体",Font.BOLD,12));
		newin.add(jcs);jcs.setBounds(90,140,100,24);
		jcs.setSelectedIndex(t3);
	}
	else{
	JLabel sf=new JLabel(vo.getState());sf.setFont(new Font("楷体",Font.BOLD,12));sf.setOpaque(false);
	newin.add(sf);sf.setBounds(90,140,100,24);sf.setHorizontalAlignment(SwingConstants.CENTER);sf.setEnabled(false);}
	
	JLabel name=new JLabel("中转中心");
	newin.add(name);name.setBounds(this.getWidth()/2-10,140,60,20);final JComboBox<String> jcb=new JComboBox<String>();
	if(Edit){
	
	jcb.addItem("北京");jcb.addItem("南京");jcb.addItem("上海");jcb.addItem("广州");
	jcb.setBackground(Color.white);jcb.setFont(new Font("楷体",Font.CENTER_BASELINE,12));
	newin.add(jcb);jcb.setBounds(this.getWidth()/2+100, 140, 70, 24);
	jcb.setSelectedIndex(t2);
	}
	else{
		JLabel jct=new JLabel(vo.getName());jct.setFont(new Font("楷体",Font.CENTER_BASELINE,12));jct.setEnabled(false);
		newin.add(jct);jct.setBounds(this.getWidth()/2+100, 140, 60, 24);jct.setHorizontalAlignment(SwingConstants.CENTER);
	
	}
	
	JPanel buttonpanel=new JPanel();buttonpanel.setLayout(null);
	JButton save=new JButton("保存(S)");JButton cancel=new JButton("编辑(E)");
	buttonpanel.add(save);buttonpanel.add(cancel);save.setBounds(this.getWidth()/3-120, 25, 100, 30);cancel.setBounds(this.getWidth()/2+90, 25, 100, 30);
	add(buttonpanel);buttonpanel.setBounds(0,3*this.getHeight()/5,this.getWidth(),70);
	
	cancel.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			Storage_editStorage.this.dispose();
			new Storage_editStorage(getVO(),true);
			
		}}
	);
	save.addActionListener(new ActionListener(){
		Storage storage=new Storage();
		public void actionPerformed(ActionEvent e) {
			
           if(Edit){ StorageVO newvo=new StorageVO(idf.getText(),jc.getSelectedItem().toString(),sef.getText(),orf.getText(),itf.getText(),otf.getText(),jcs.getSelectedItem().toString(),jcb.getSelectedItem().toString());
           
           
           try {
        	   if(idf.getText().length()!=6||orf.getText().length()!=10||!itf.getText().matches("\\d{4}-\\d{1,2}-\\d{1,2}\\s\\d{2}:\\d{2}:\\d{2}")||jcb.getSelectedItem()==null)
					JOptionPane.showMessageDialog(null,"修改信息格式错误");
        	   else if(!otf.getText().equals("null")&&!jcs.getSelectedItem().toString().equals("OUT")) 	JOptionPane.showMessageDialog(null,"库存状态矛盾");
        	   else if(jcs.getSelectedItem().toString().equals("OUT")&&!otf.getText().matches("\\d{4}-\\d{1,2}-\\d{1,2}\\s\\d{2}:\\d{2}:\\d{2}"))  JOptionPane.showMessageDialog(null,"出库时间格式错误");

else{   
	SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
	Date date1 =formatter.parse(itf.getText());
	Date date2 =formatter.parse(otf.getText());
	
	if(date1.after(date2))  JOptionPane.showMessageDialog(null,"时间顺序错误");
	else{	 Storage_editStorage.this.dispose();
        	   storage.delete(getVO());
			storage.storage_inRecord(newvo);
			new Storage_editStorage(newvo,false);}}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
            
            
            }
           else{
        	   JOptionPane.showMessageDialog(null, "       未发生改变",null,1);
           }
		}
		
	});
	
	if(Edit){
	JButton back=new JButton("取消(C)");buttonpanel.add(back);back.setBounds(this.getWidth()/2-50, 25, 100, 30);
	back.addActionListener(new ActionListener(){

		public void actionPerformed(ActionEvent e) {
			Storage_editStorage.this.dispose();
		}
		
	});}
	else{
		JButton back=new JButton("删除(D)");buttonpanel.add(back);back.setBounds(this.getWidth()/2-50, 25, 100, 30);	
		back.addActionListener(new ActionListener(){
          Storage storage=new Storage();
			public void actionPerformed(ActionEvent e) {
				try {
					storage.delete(voall);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Storage_editStorage.this.dispose();
				JOptionPane.showMessageDialog(null, voall.getOrder()+"已删除");
			}
			
		});
	}

}
}
