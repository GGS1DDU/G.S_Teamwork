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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Timer;

import elms.businesslogic.storagebl.Storage;
import elms.vo.UserVO;

public class Storage_in extends JPanel{
	public TableModel model;
	public JTable table;
	ArrayList<String>   arr;
	static Toolkit kit=Toolkit.getDefaultToolkit();
	static Dimension screenSize=kit.getScreenSize();
	static int screenWidth=(int) screenSize.getWidth();
	static int screenHeight=(int)screenSize.getHeight();
	public static void main(String args[]){
		UserVO vo=new UserVO();
	JFrame f=new JFrame();
	f.setLayout(null);
	f.setVisible(true);
	f.setResizable(false);
	f.setBounds(screenWidth/6,screenHeight/8,screenWidth*2/3,screenHeight*3/4);
		Storage_in u=new Storage_in(vo);
		f.add(u);
		u.setBounds(200, 0, f.getWidth()-200, f.getHeight());

}
public Storage_in(UserVO vo){	
	setVisible(true);
	setOpaque(false);
	setLayout(null);
JLabel jl=new JLabel(" 当前用户：  "+vo.getName()+"  身份：  "+vo.getJob()+"  编号   "+vo.getId());
add(jl);jl.setBounds(200, 0, screenWidth-400, 25);
	
final JLabel time=new JLabel();
time.setFont(new Font("Serif",Font.BOLD,15));	    
add(time);	    
time.setBounds(5*(screenWidth*2/3-200)/12, screenHeight*3/4-50, (screenWidth*2/3-200)/3, 25);
String[] title_name = { "需要入库订单    ID"};
model = new TableModel(title_name);
table = new JTable(model);
table.setBackground(Color.white);	


JScrollPane scrollpane=new JScrollPane(table);
this.add(scrollpane);
scrollpane.setBounds(-1,40,screenWidth*2/3-198,screenHeight*3/8);
scrollpane.setOpaque(false);
scrollpane.getViewport().setOpaque(false); 





table.addMouseListener(new MouseAdapter(){
	Storage storage=new Storage();
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getClickCount()==2) {
			if(table.getSelectedColumn()!=-1){
				String	s=(String) model.getValueAt(table.getSelectedRow(), 0);
				Storage_newStorage ns=new Storage_newStorage();				
				ns.orf.setText(s);
				try {
					storage.getIn(table.getSelectedRow());
					arr=storage.getallin();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				model.removeAllRows(model.getRowCount());
				for(String vos:arr) {	String[] os={vos};		model.addRow(os);}	
					table.updateUI();
			}
	}
	}
});
arr=new ArrayList<String>();
Storage storage=new Storage();
try {
	arr=storage.getallin();
} catch (IOException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
for(String vos:arr) {	String[] os={vos};		model.addRow(os);}	

JButton refresh=new JButton("取消(C)");
add(refresh);
refresh.setBounds((screenWidth*2/3-200)/6, screenHeight*3/8+80, 100,25);
refresh.addActionListener(new ActionListener(){

	public void actionPerformed(ActionEvent arg0) {
		Storage_main.user.setBounds(200, 0, screenWidth-200,screenHeight);	
		Storage_in.this.setVisible(false);
	}
});


Timer timer = new Timer(100,new ActionListener(){
		public void actionPerformed(ActionEvent arg0) {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				time.setText(sdf.format(new Date()));	
		}
 });
 timer.start();
}
}
