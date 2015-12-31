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

import elms.businesslogic.memberbl.DriverBL;
import elms.presentation.storageui.TableModel;
import elms.vo.DriverVO;
import elms.vo.UserVO;

public class MemberUI_DriverMain extends JPanel{
	Toolkit kit=Toolkit.getDefaultToolkit();
	Dimension screenSize=kit.getScreenSize();
	int screenWidth=(int) screenSize.getWidth();
	int screenHeight=(int) screenSize.getHeight();

	public static ArrayList<DriverVO> arr=new ArrayList<DriverVO>();
	
	public TableModel model;
	public JTable table;
	
	public MemberUI_DriverMain(final UserVO vo) throws IOException{
		setVisible(true);
		setOpaque(false);
		setLayout(null);
		
		JLabel jl=new JLabel(" 当前用户：    "+vo.getName()+" 身份：   "+vo.getJob()+" 编号：   "+vo.getId());
		add(jl);jl.setBounds(200, 0, screenWidth*2/3-200, 25);
				
		String[] title_name = { "司机编号", "姓名","出生日期","身份证号","手机号","性别","行驶证期限"};
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
						DriverBL dr=new DriverBL();
						try{
							new MemberUI_DriverEdit(dr.inquiry(s),false);
						}catch(IOException e1){
							e1.printStackTrace();
						}
					}
				}
			}
		});
		
		final ArrayList<DriverVO> arr=new ArrayList<DriverVO>();
		final DriverBL dr=new DriverBL();
		
//		arr.addAll(dr.inquiryAll());
//		for(DriverVO vo1:arr){
//			model.addRow(model.newchangeRow_Dri(vo1));
//		}
		
		JButton xjdr=new JButton("新建司机信息");
		JButton find=new JButton("查询");
		JButton back=new JButton("返回");back.setForeground(Color.RED);
		JButton refresh=new JButton("刷新(R)");
		add(xjdr);add(find);add(back);add(refresh);
		xjdr.setBounds((screenWidth*2/3-200)/6-60, screenHeight*3/8+150, 150, 25);
		find.setBounds((screenWidth*2/3-200)/6+140, screenHeight*3/8+150, 100, 25);
		refresh.setBounds((screenWidth*2/3-200)/6+290, screenHeight*3/8+150, 100, 25);
		back.setBounds((screenWidth*2/3-200)/6+440, screenHeight*3/8+150, 100,25);
		
		xjdr.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new MemberUI_DriverNew();
			}
		});
		
		find.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new MemberUI_DriverNew();
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
//					arr.addAll(dr.inquiryAll());
//				
//				model.removeAllRows(model.getRowCount());
//				for(DriverVO svo:arr){
//					model.addRow(model.newchangeRow_Dri(svo));
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
		
		DriverBL driver=new DriverBL();
		
		String[] title_name={ "司机编号", "姓名","出生日期","身份证号","手机号","性别","行驶证期限"};
		model=new TableModel(title_name);
		table.setModel(model);
		try {
			ArrayList<DriverVO> arr0=driver.inquiryAll();
			for(DriverVO vo:arr0){
				model.addRow(model.newchangeRow_Dri(vo));
			}
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		table.updateUI();
	}
}
