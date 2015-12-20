package elms.presentation.financeui.inAndEx.income;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import elms.businesslogic.financebl.inandex.IncomeManager;
import elms.presentation.uihelper.ScreenSize;

public class Income_findTime extends JFrame{

	int screenWidth = ScreenSize.screenWidth;
	int screenHeight = ScreenSize.screenHeight;
	JTextField startTime;
	JTextField endTime;
	IncomeManager im = new IncomeManager();
	
	JButton ok;
	JButton cancel;
	
	public Income_findTime(final String hall){
		setLayout(null);
		setTitle("时间查询");
		setResizable(false);
		setBounds(screenWidth/4,screenHeight/4,screenWidth/4, screenHeight/3);
		setVisible(true);
		
		JLabel start=new JLabel("起始时间");  
		start.setBounds(this.getWidth()/5, this.getHeight()/6, this.getWidth()/5, 25);
		add(start);
		
		startTime=new JTextField();
		startTime.setBounds(this.getWidth()/2, this.getHeight()/6, this.getWidth()/3+10,25);
		add(startTime);
		
		JLabel end =new JLabel("终止时间");
		end.setBounds(this.getWidth()/5, this.getHeight()/2, this.getWidth()/5, 25);
		add(end);
		
		endTime=new JTextField();
		endTime.setBounds(this.getWidth()/2, this.getHeight()/2,this.getWidth()/3+10, 25);
		add(endTime);
		
		endTime.addMouseListener(new MouseAdapter(){

			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==2) {
					 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");   	
					endTime.setText(sdf.format(new Date()));
				}
			}
			
		});
		
		ok = new JButton("查询");
		ok.setBounds(this.getWidth()/4, 3*this.getHeight()/4, this.getWidth()/5, 30);
		add(ok);
		
		cancel = new JButton("返回");
		cancel.setBounds(this.getWidth()/2+20, 3*this.getHeight()/4, this.getWidth()/5, 30);
		add(cancel);
		
		ok.addActionListener(new ActionListener(){

		
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				
				if(!isAvailableTime(startTime.getText())||!isAvailableTime(endTime.getText())){
					JOptionPane.showMessageDialog(null, "查询时间格式不正确");
				}else{
			    	SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
			   		try {
						Date date1 =formatter.parse(startTime.getText());
						Date date2 =formatter.parse(endTime.getText());
						if(date1.after(date2)){
							JOptionPane.showMessageDialog(null, "查询时间顺序错误");
						}else{
							if(hall.equals("全部")){
								Income_main.arr=im.inquiryIncomeByTime(startTime.getText(), endTime.getText());
							}else{
								Income_main.arr = im.inquiryInByTimeHall(startTime.getText(), endTime.getText(), hall);
							}
							JOptionPane.showMessageDialog(null, "查询完毕\n请刷新","成功",JOptionPane.INFORMATION_MESSAGE);
						
						}
			   		}catch(Exception e){
			   			e.printStackTrace();
			   		}
				}
			}
			
		});
		
		cancel.addActionListener(new ActionListener(){

	
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				Income_findTime.this.dispose();
			}
			
		});
		
	}
	
	public boolean isAvailableTime(String time){
		if(time.matches("\\d{4}-\\d{1,2}-\\d{1,2}\\s\\d{2}:\\d{2}:\\d{2}")){
			return true;
		}
		return false;
	}
}
