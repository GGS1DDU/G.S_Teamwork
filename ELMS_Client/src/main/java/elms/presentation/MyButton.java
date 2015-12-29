package elms.presentation;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.UIManager;

public class MyButton extends JButton{

	int count = 0;
	String original;
	public MyButton(){
		
		this(15);
		UIManager.put("Button.background", false);
//		UIManager
	}
	
	public MyButton(int fontSize){
		super();
		setFont(new Font("宋体",1,fontSize));
		setBackground(new Color(255,231,186));
		setContentAreaFilled(false);
		setBorderPainted(false);
		
	//	UIManager.put("Button.background", Color.BLACK);
//		setBackground(Color.white);
//		setIcon(file);
	}
	
	public MyButton(String s,int fontSize){
		this(s);
		setFont(new Font("宋体",1,fontSize));
		
		
//		UIManager.put("Button.background", false);
	}
	
	public MyButton(String s){
		super(s);
		setFont(new Font("宋体",1,10));
//		setBackground(new Color(224,241,244)); //淡蓝色
		setContentAreaFilled(false);
		setBorderPainted(false);
//		setBackground(new Color(247,247,198));
//		setForeground(Color.white);
//		this.setForeground(Color.white);
//		setBackground(Color.WHITE);
	}
	
	
	public void setIcon(String file) {
		ImageIcon icon = new ImageIcon(file);
		Image temp = icon.getImage().getScaledInstance(this.getWidth(),
				this.getHeight(), icon.getImage().SCALE_DEFAULT);
		icon = new ImageIcon(temp);
		this.setIcon(icon);
		setContentAreaFilled(false);
		setBorderPainted(false);
		setMargin(new Insets(0,0,0,0));
		
		if(count==0){
			original = file;
		}
		count++;
	}
	
	public void setRolloverIcon(final String file){
		this.addMouseListener(new MouseAdapter(){

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根
				setIcon(file);
			}
			
			public void mouseExited(MouseEvent e){
				setIcon(original);
			}

		});
		
	}
	
	
}