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

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import elms.businesslogic.storagebl.Storage;
import elms.vo.StorageVO;

public class Storage_findtime extends JFrame{
	Toolkit kit=Toolkit.getDefaultToolkit();
	Dimension screenSize=kit.getScreenSize();
	int screenWidth=(int) screenSize.getWidth();
	int screenHeight=(int)screenSize.getHeight();


public Storage_findtime(){
	setLayout(null);
	setTitle("区度查询");
	setResizable(false);
	setBounds(screenWidth/4,screenHeight/4,screenWidth/4, screenHeight/3);
	setVisible(true);
	
	JLabel start=new JLabel("起始时间");  final JTextField js=new JTextField();
	add(start);start.setBounds(this.getWidth()/5, this.getHeight()/6, this.getWidth()/5, 25);
	add(js);js.setBounds(this.getWidth()/2, this.getHeight()/6, this.getWidth()/3+10,25);
	JLabel end =new JLabel("终止时间");final JTextField je=new JTextField();
	add(end);end.setBounds(this.getWidth()/5, this.getHeight()/2, this.getWidth()/5, 25);
	add(je);je.setBounds(this.getWidth()/2, this.getHeight()/2,this.getWidth()/3+10, 25);
	je.addMouseListener(new MouseAdapter(){

		public void mouseClicked(MouseEvent e) {
			if(e.getClickCount()==2) {
				 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   	
				je.setText(sdf.format(new Date()));
			}
		}
		
	});
	
	final JComboBox<String> jcb=new JComboBox<String>();
	jcb.addItem("北京");jcb.addItem("南京");jcb.addItem("上海");jcb.addItem("广州");
	jcb.setBackground(Color.white);jcb.setFont(new Font("楷体",Font.CENTER_BASELINE,12));
	add(jcb);jcb.setBounds(0, 0, 80, 24);
	
	JButton ok=new JButton("查询");
	JButton back=new JButton("取消");
	add(ok);ok.setBounds(this.getWidth()/4, 3*this.getHeight()/4, this.getWidth()/5, 30);
	add(back);back.setBounds(this.getWidth()/2+20, 3*this.getHeight()/4, this.getWidth()/5, 30);
	
	ok.addActionListener(new ActionListener(){
		Storage storage=new Storage();
		public void actionPerformed(ActionEvent arg0) {
       if(!js.getText().matches("\\d{4}-\\d{1,2}-\\d{1,2}\\s\\d{2}:\\d{2}:\\d{2}")||!je.getText().matches("\\d{4}-\\d{1,2}-\\d{1,2}\\s\\d{2}:\\d{2}:\\d{2}"))
		JOptionPane.showMessageDialog(null, "查询时间格式不正确");
       else{
    	SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
   		try {
			Date date1 =formatter.parse(js.getText());
			Date date2 =formatter.parse(je.getText());
			if(date1.after(date2))  	JOptionPane.showMessageDialog(null, "查询时间顺序错误");
			else{
				try {
					Storage_main.arr=storage.inquiryByTime(js.getText(), je.getText(),jcb.getSelectedItem().toString() );
					  			
					Storage_findtime.this.dispose();
					JOptionPane.showMessageDialog(null, "  查询完毕!\n  请刷新库存");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       }
		}
		
	});
	back.addActionListener(new ActionListener(){

		public void actionPerformed(ActionEvent e) {
			Storage_findtime.this.dispose();
			
		}
		
	});
}
}
