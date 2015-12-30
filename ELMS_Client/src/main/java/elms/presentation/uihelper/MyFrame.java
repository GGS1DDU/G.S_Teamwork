package elms.presentation.uihelper;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame extends JFrame{

	int screenWeidth = ScreenSize.screenWidth;
	int screenHeight = ScreenSize.screenHeight;
	protected Rectangle r = new Rectangle(screenWeidth/6+2,screenHeight/8+2,screenWeidth*2/3-5,screenHeight*3/4-5);
	
	protected JPanel contentPane;
	protected MyButton close;
	protected MyButton mini;
	
	public MyFrame(String background){
		setBounds(r);
//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		contentPane = new MyPanel(background);

		add(contentPane);
		contentPane.setBounds(0, 0, this.getWidth(), this.getHeight());
		addCloseOperation();
	}
	
	public MyFrame(String background,Rectangle rec){
		this(background);
		r = rec;
	}
	private void addCloseOperation(){
		close = new MyButton();
		close.setBounds(this.getWidth()-30, 10, 20,20);
		close.setIcon("close_1.png");
		close.setRolloverIcon("close_2.png");
		contentPane.add(close);
		
		mini = new MyButton();
		mini.setBounds(close.getX()-close.getWidth()-25,close.getY(),close.getWidth(),close.getHeight());
		mini.setIcon("mini_1.png");
		mini.setRolloverIcon("mini_2.png");
		contentPane.add(mini);
		
		close.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				System.exit(0);
			}
			
		});
		
		mini.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				MyFrame.this.setExtendedState(JFrame.ICONIFIED);
			}
		});
	}
}
