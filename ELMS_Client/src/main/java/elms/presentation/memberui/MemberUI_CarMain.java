package elms.presentation.memberui;

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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Timer;
import elms.businesslogic.memberbl.CarBL;
import elms.presentation.storageui.TableModel;
import elms.vo.CarVO;
import elms.vo.UserVO;

public class MemberUI_CarMain extends JPanel{
	Toolkit kit=Toolkit.getDefaultToolkit();
	Dimension screenSize=kit.getScreenSize();
	int screenWidth=(int) screenSize.getWidth();
	int screenHeight=(int) screenSize.getHeight();
	
	public static ArrayList<CarVO> arr=new ArrayList<CarVO>();
	
//	public static void main(String args[]){
//		EventQueue.invokeLater(new Runnable(){
//			public void run(){
//				UserVO vo=new UserVO();
//				try {
//					JPanel Car=new MemberUI_CarMain(vo);
//				} catch (IOException e) {
//					// TODO 自动生成的 catch 块
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
	public TableModel model;
	public JTable table;
	
	public MemberUI_CarMain(final UserVO vo) throws IOException{
		setVisible(true);
		setOpaque(false);
		setLayout(null);
		
		JLabel jl=new JLabel(" 当前用户：    "+vo.getName()+" 身份：   "+vo.getJob()+" 编号：   "+vo.getId());
		add(jl);jl.setBounds(200, 0, screenWidth*2/3-200, 25);
		
		
		String[] title_name = {"车辆代号","车牌号","服役时间"};
		model = new TableModel(title_name);
		table = new JTable(model);
		table.setBackground(Color.white);	
		
		JScrollPane scrollpane=new JScrollPane(table);
		this.add(scrollpane);
		scrollpane.setBounds(-1,70,screenWidth*2/3-200,screenHeight*3/8);
		scrollpane.setOpaque(false);
		scrollpane.getViewport().setOpaque(false); 
		
		table.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				if(e.getClickCount()==2){
					if(table.getSelectedColumn()!=-1){
						
						String	s=(String) model.getValueAt(table.getSelectedRow(), 0);
						CarBL ca=new CarBL();
						try{
							new MemberUI_CarEdit(ca.inquiry(s),false);
						}catch(IOException e1){
							e1.printStackTrace();
						}
					}
				}
			}
		});
		
		final ArrayList<CarVO> arr=new ArrayList<CarVO>();
		final CarBL ca=new CarBL();
		
//		arr.addAll(ca.inquiryAll());
//		for(CarVO vo1:arr){
//			model.addRow(model.newchangeRow_Car(vo1));
//		}
		
		JButton xjca=new JButton("新建车辆信息");
		JButton find=new JButton("查询");
		JButton back=new JButton("返回");back.setForeground(Color.RED);
		JButton refresh=new JButton("刷新(R)");
		add(xjca);add(find);add(back);add(refresh);
		xjca.setBounds((screenWidth*2/3-200)/6-60, screenHeight*3/8+150, 150, 25);
		find.setBounds((screenWidth*2/3-200)/6+140, screenHeight*3/8+150, 100, 25);
		refresh.setBounds((screenWidth*2/3-200)/6+290, screenHeight*3/8+150, 100, 25);
		back.setBounds((screenWidth*2/3-200)/6+440, screenHeight*3/8+150, 100,25);
		
		xjca.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new MemberUI_CarNew();
			}
		});
		
		find.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new MemberUI_CarNew();
			}
		});
		
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		
		
		refresh.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				setrows();
//				arr.clear();
//				try {
//					arr.addAll(ca.inquiryAll());
//				
//				model.removeAllRows(model.getRowCount());
//				for(CarVO svo:arr){
//					model.addRow(model.newchangeRow_Car(svo));
//				}
//				table.updateUI();
//				} catch (IOException e1) {
//					// TODO 自动生成的 catch 块
//					e1.printStackTrace();
//				}
			}
			
		});
		
		final JLabel time=new JLabel();
		add(time); time.setBounds((screenWidth*2/3-200)/3,screenHeight*3/4-50,200, 25);
		time.setFont(new Font("Serif",Font.BOLD,15));
				
	    Timer timer = new Timer(100,new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
				time.setText(sdf.format(new Date()));				

			}
	    	
	    });
	    timer.start();
		
	}

	protected void setrows(){
		model.removeAllRows(model.getRowCount());
		
		CarBL carbl=new CarBL();
		
		String[] title_name={"车辆代号","车牌号","服役时间"};
		model=new TableModel(title_name);
		table.setModel(model);
		try {
			ArrayList<CarVO> arr0=carbl.inquiryAll();
			for(CarVO vo:arr0){
				model.addRow(model.newchangeRow_Car(vo));
			}
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		table.updateUI();
	}
	
}
