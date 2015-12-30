package elms.presentation.uihelper;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import elms.businesslogic.financebl.InitAll;

public class TimeLabel extends JPanel{

	private JLabel time;
	private Timer timer;
	
	public TimeLabel(int width,int height){
		setSize(width,height);
		setOpaque(false);
		setLayout(null);
		
		time = new JLabel("1", JLabel.CENTER);
		time.setFont(new Font("微软雅黑", Font.BOLD, 15));
		time.setBounds(0,0,this.getWidth(),this.getHeight());
	
		add(time);
//		time.setBounds(0, this.getHeight() - 30, this.getWidth(), 30);
		add(time);
		timer = new Timer(100, new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SimpleDateFormat sdf = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");
						time.setText(sdf.format(new Date()));
			}

		});
		timer.start();
	}
	
	public void startTimer(){
		
	}
	
	
	
}
