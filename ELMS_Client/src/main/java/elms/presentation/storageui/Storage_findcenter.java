package elms.presentation.storageui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import elms.businesslogic.storagebl.Storage;
import elms.vo.StorageVO;


public class Storage_findcenter extends JFrame {
	Toolkit kit=Toolkit.getDefaultToolkit();
	Dimension screenSize=kit.getScreenSize();
	int screenWidth=(int) screenSize.getWidth();
	int screenHeight=(int)screenSize.getHeight();

	public Storage_findcenter(){
		setLayout(null);
		setTitle("当前查询");
		setResizable(false);
		setBounds(screenWidth/3,screenHeight/4,screenWidth/4, screenHeight/4);
		setVisible(true);
		
		final JComboBox<String> jcb=new JComboBox<String>();
		jcb.addItem("北京");jcb.addItem("南京");jcb.addItem("上海");jcb.addItem("广州");
		jcb.setBackground(Color.white);jcb.setFont(new Font("楷体",Font.CENTER_BASELINE,12));
		add(jcb);jcb.setBounds(this.getWidth()/5, this.getHeight()/4+10,80, 25);
		
		JButton ok=new JButton("确定");
		
		add(ok);ok.setBounds(this.getWidth()/2+30, this.getHeight()/4+10, 60, 25);
		ok.addActionListener(new ActionListener(){
			 Storage storage=new Storage();
			public void actionPerformed(ActionEvent arg0) {
				String center=jcb.getSelectedItem().toString();
				ArrayList<StorageVO> voarr=new ArrayList<StorageVO>();
				ArrayList<StorageVO> voarr2=new ArrayList<StorageVO>();
				voarr2.add(new StorageVO("在库查询","","","","","","",""));
				try {
					voarr=storage.inquiryAll(center);
					for(StorageVO vo:voarr)  if(!vo.getState().equals("OUT"))  voarr2.add(vo);
					if(voarr2.size()<=1)
				   JOptionPane.showMessageDialog(null, center+" 没有库存!");
					else{
						   JOptionPane.showMessageDialog(null, "查询完毕！\n 请刷新库存界面");
						Storage_main.arr=voarr2;
					}
					Storage_findcenter.this.dispose();
					
					
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				}
			
			
		});
		
	}
}
