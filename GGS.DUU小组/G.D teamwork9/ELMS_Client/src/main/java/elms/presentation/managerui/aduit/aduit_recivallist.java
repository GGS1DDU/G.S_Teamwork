package elms.presentation.managerui.aduit;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class aduit_recivallist extends JFrame{

		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension screenSize=kit.getScreenSize();
		int screenWidth=(int) screenSize.getWidth();
		int screenHeight=(int)screenSize.getHeight();
		public static void main(String[] args) {
			new aduit_recivallist();
		}
		public aduit_recivallist(){
			setLayout(null);
			setResizable(false);
			setTitle("中转中心到达单");
			setBounds(screenWidth/4,screenHeight/4, screenWidth/3, 3*screenHeight/8);
			setVisible(true); 
			JPanel inf=new JPanel();inf.setLayout(null);
			add(inf);inf.setBounds(0,0,this.getWidth(),200);
			inf.setBorder(BorderFactory.createTitledBorder(""));
			
			
			JLabel id=new JLabel("ID");
			inf.add(id);id.setBounds(20,20,20,20);
			final JTextField idf=new JTextField();idf.setFont(new Font("SansSerif",Font.PLAIN,12));
			inf.add(idf);idf.setBounds(90,20,100,24);idf.setHorizontalAlignment(SwingConstants.CENTER);
			
			JLabel area=new JLabel("装车时期");
			inf.add(area);area.setBounds(this.getWidth()/2,20,100,20);
			final JTextField jc=new JTextField();jc.setFont(new Font("SansSerif",Font.PLAIN,12));
			inf.add(jc);jc.setBounds(this.getWidth()/2+80, 20, 100, 24);
			
			JLabel seat=new JLabel("中转中心编号");
			inf.add(seat);seat.setBounds(10,80,100,20);
			final JTextField sef=new JTextField();sef.setFont(new Font("SansSerif",Font.PLAIN,12));
			inf.add(sef);sef.setBounds(90,80,100,24);sef.setHorizontalAlignment(SwingConstants.CENTER);
			
			JLabel on=new JLabel("中转单编号");
			inf.add(on);on.setBounds(this.getWidth()/2,80,100,20);
			final JTextField onf=new JTextField();onf.setFont(new Font("SansSerif",Font.PLAIN,12));
			inf.add(onf);onf.setBounds(this.getWidth()/2+80,80,100,24);onf.setHorizontalAlignment(SwingConstants.CENTER);
			
			JLabel s=new JLabel("出发地");
			inf.add(s);s.setBounds(20,140,70,20);
			final JTextField sf=new JTextField();sf.setFont(new Font("SansSerif",Font.PLAIN,12));
			inf.add(sf);sf.setBounds(90,140,100,24);sf.setHorizontalAlignment(SwingConstants.CENTER);
			
			JLabel f=new JLabel("货物状态");
			inf.add(f);f.setBounds(this.getWidth()/2,140,100,20);
			final JTextField ff=new JTextField();ff.setFont(new Font("SansSerif",Font.PLAIN,12));
			inf.add(ff);ff.setBounds(this.getWidth()/2+80, 140, 100, 24);
			
			JButton tg=new JButton("通过");add(tg);tg.setBounds(50,210,80,30);
			JButton refuse=new JButton("未通过");add(refuse);refuse.setBounds(180,210,80,30);
			JButton cancel=new JButton("取消");add(cancel);cancel.setBounds(310,210,80,30);
			
		}

	}
