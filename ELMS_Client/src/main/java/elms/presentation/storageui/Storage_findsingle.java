package elms.presentation.storageui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import elms.businesslogic.storagebl.Storage;
import elms.presentation.uihelper.MyPanel;
import elms.vo.StorageVO;

public class Storage_findsingle extends JFrame{
	Toolkit kit=Toolkit.getDefaultToolkit();
	Dimension screenSize=kit.getScreenSize();
	int screenWidth=(int) screenSize.getWidth();
	int screenHeight=(int)screenSize.getHeight();
public Storage_findsingle(){
	setLayout(null);
	setTitle("查询");
	setResizable(false);
	setBounds(screenWidth/4,screenHeight/4,screenWidth/4, screenHeight/4);
	setVisible(true);

	MyPanel p=new MyPanel("bg3.png");
	add(p);p.setBounds(0, 0, this.getWidth(), this.getHeight());
	final JTextField idf=new JTextField();
	JLabel ID=new JLabel("Order-ID");
	p.add(ID);
	ID.setBounds(60, 40, 100, 30);
	p.add(idf);
	idf.setBounds(this.getWidth()/2-14,40,150,28);
	JButton ok=new JButton("查询");
	JButton cancle=new JButton("取消");
	p.add(ok);ok.setBounds(this.getWidth()/2-120,3*this.getHeight()/5+10,70,25);
	p.add(cancle);cancle.setBounds(this.getWidth()/2+40,3*this.getHeight()/5+10,70,25);
    
	ok.addActionListener(new ActionListener(){
         Storage storage=new Storage();
		public void actionPerformed(ActionEvent e) {
			try {
				StorageVO vo=storage.inquiry(idf.getText());
				if(vo!=null){
					setVisible(false);
					new Storage_editStorage(vo,false);		
				}
				else {
					JOptionPane.showMessageDialog(null, "订单编号: "+idf.getText()+" 未找到");
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	});
	cancle.addActionListener(new ActionListener(){

		public void actionPerformed(ActionEvent e) {
			setVisible(false);
		}
		
	});
}
}
