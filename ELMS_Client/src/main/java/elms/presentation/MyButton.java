package elms.presentation;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MyButton extends JButton{

	public MyButton(){
		super();
//		setIcon(file);
	}
	
	public void setIcon(String file) {
		ImageIcon icon = new ImageIcon(file);
		Image temp = icon.getImage().getScaledInstance(this.getWidth(),
				this.getHeight(), icon.getImage().SCALE_DEFAULT);
		icon = new ImageIcon(temp);
		this.setIcon(icon);
	}
}
