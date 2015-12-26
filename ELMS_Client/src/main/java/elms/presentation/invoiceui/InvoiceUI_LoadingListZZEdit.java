package elms.presentation.invoiceui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import elms.businesslogic.invoicebl.LoadingListZZBL;
import elms.vo.LoadingListZZVO;

public class InvoiceUI_LoadingListZZEdit extends JFrame{
	LoadingListZZVO voall;
	Toolkit kit=Toolkit.getDefaultToolkit();
	Dimension screenSize=kit.getScreenSize();
	int screenWidth=(int) screenSize.getWidth();
	int screenHeight=(int) screenSize.getHeight();
	boolean Edit;
	
	public LoadingListZZVO getVO(){
		return voall;
	}
	
	public InvoiceUI_LoadingListZZEdit(LoadingListZZVO vo,boolean edit){
		voall=vo;
		setLayout(null);
		setTitle("装车单  No："+vo.getID());
		setResizable(false);
		setBounds(screenWidth/4,screenHeight/4,screenWidth/3,11*screenHeight/16+40);
		setVisible(true);
		
		Edit=edit;
		
		final JPanel newin=new JPanel();
		newin.setLayout(null);
		add(newin);newin.setBounds(0,0,this.getWidth(),4*this.getHeight()/5);
		newin.setBorder(BorderFactory.createTitledBorder(""));
		
		JLabel id=new JLabel("单据ID");
		//前两位zc 后面五位数字
		newin.add(id);id.setBounds(120,20,80,20);
		final JTextField idf=new JTextField(vo.getID());
		newin.add(idf);idf.setBounds(220, 20, 100, 24);
		idf.setEditable(Edit);
		idf.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel date=new JLabel("装车日期");
		newin.add(date);date.setBounds(120,55,80,20);
		final JTextField df=new JTextField(vo.getTime());
		df.setFont(new Font("Dialog",Font.CENTER_BASELINE,12));
		newin.add(df);df.setBounds(220, 55, 100, 24);
		df.setEditable(Edit);
		df.setHorizontalAlignment(SwingConstants.CENTER);
		if(Edit){
			df.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
					if(e.getClickCount()==2){
						SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
						df.setText(sdf.format(new Date()));
					}
				}
			});
		}
		
		JLabel transNum=new JLabel("汽运编号");
		//20位
		newin.add(transNum);transNum.setBounds(120,90,80,20);
		final JTextField tnf=new JTextField(vo.getTransportNumber());
		tnf.setFont(new Font("SansSerif",Font.CENTER_BASELINE,12));
		newin.add(tnf);tnf.setBounds(220,90, 150, 24);tnf.setEditable(Edit);
		tnf.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel arrivalPlace=new JLabel("到达地");
		newin.add(arrivalPlace);
		arrivalPlace.setBounds(120, 125, 80, 20);
		final JTextField apf=new JTextField(vo.getArrival());
		apf.setFont(new Font("SansSerif",Font.PLAIN,12));
		newin.add(apf);apf.setBounds(220, 125, 100, 24);apf.setEditable(Edit);
		apf.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel carNum=new JLabel("车辆代号");
		newin.add(carNum);carNum.setBounds(120,160,80,20);
		final JTextField cnf=new JTextField(vo.getCarNumber());
		cnf.setFont(new Font("SansSerif",Font.CENTER_BASELINE,12));
		newin.add(cnf);cnf.setBounds(220, 160, 100, 24);cnf.setEditable(Edit);
		cnf.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel supervisor=new JLabel("监装员");
		newin.add(supervisor);supervisor.setBounds(120,195,80,20);
		final JTextField s1f=new JTextField(vo.getSurpervior());
		s1f.setFont(new Font("SansSerif",Font.CENTER_BASELINE,12));
		newin.add(s1f);s1f.setBounds(220, 195, 100, 24);s1f.setEditable(Edit);
		s1f.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel supercargo=new JLabel("押运员");
		newin.add(supercargo);supercargo.setBounds(120,230,80,20);
		final JTextField s2f=new JTextField(vo.getSupercargo());
		s2f.setFont(new Font("SansSerif",Font.CENTER_BASELINE,12));
		newin.add(s2f);s2f.setBounds(220, 230, 100, 24);s2f.setEditable(Edit);
		s2f.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel orderNum=new JLabel("订单条形号码");
		newin.add(orderNum);orderNum.setBounds(120,265,80,20);
//		ArrayList<String> arr=new ArrayList<String>(vo.getOrderNumber());
//		String[] strs=new String[arr.size()];
//		String str=null;
//		for(int i=0;i<arr.size();i++){
//			strs[i]=arr.get(i)+"\n";
//			str+=strs[i];
//		}		
//		final JTextArea area=new JTextArea(str);
		final JTextArea area=new JTextArea(vo.getOrderNumber());
		area.setLineWrap(true);
		area.setFont(new Font("SanSerif",Font.PLAIN,12));
		JScrollPane pane=new JScrollPane(area,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		newin.add(pane);
		pane.setViewportView(area);
		pane.setBounds(220,265,100,64);
		
		JLabel cost=new JLabel("运费");
		newin.add(cost);cost.setBounds(120,340,80,20);
		final JTextField cf=new JTextField(String.valueOf(vo.getCost()));
		cf.setFont(new Font("SansSerif",Font.CENTER_BASELINE,12));
		newin.add(cf);cf.setBounds(220, 340, 100, 24);cf.setEditable(Edit);
		cf.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel place=new JLabel("所属中转中心");
		newin.add(place);
		place.setBounds(120, 375, 80, 20);
		final JComboBox<String> jcb2=new JComboBox<String>();
		if(Edit){
			jcb2.addItem("南京仙林");jcb2.addItem("南京鼓楼");
			jcb2.setBackground(Color.WHITE);jcb2.setFont(new Font("楷体",Font.BOLD,12));
			newin.add(jcb2);jcb2.setBounds(220, 160, 100, 24);
			jcb2.setSelectedItem(vo.getPlace());
			
		}else{
			JLabel pf=new JLabel(vo.getPlace());pf.setFont(new Font("楷体",Font.BOLD,12));
			pf.setOpaque(false);
			newin.add(pf);
			pf.setBounds(220, 375, 100, 24);
			pf.setHorizontalAlignment(SwingConstants.CENTER);
			pf.setEnabled(false);
		}
		
		JLabel maker=new JLabel("单据生成者");
		newin.add(maker);
		maker.setBounds(120, 410, 80, 20);
		final JTextField mf=new JTextField(vo.getMaker());
		mf.setFont(new Font("SansSerif",Font.PLAIN,12));
		newin.add(mf);mf.setBounds(220, 410, 100, 24);mf.setEditable(Edit);
		mf.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		JPanel buttonpanel=new JPanel();
		buttonpanel.setLayout(null);
		JButton cancle=new JButton("编辑(E)");
		buttonpanel.add(cancle);
		cancle.setBounds(this.getWidth()/2+90,25,100,30);
		add(buttonpanel);
		buttonpanel.setBounds(0,4*this.getHeight()/5,this.getWidth(),70);
		
		cancle.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				InvoiceUI_LoadingListZZEdit.this.dispose();
				new InvoiceUI_LoadingListZZEdit(getVO(),true);
			}
		});
		
		if(Edit){
			JButton save=new JButton("保存(S)");
			buttonpanel.add(save);
			save.setBounds(this.getWidth()/3-120,25,100,30);
			
			save.addActionListener(new ActionListener(){
				LoadingListZZBL loadinglistzzdata=new LoadingListZZBL();
				LoadingListZZVO newvo;

				public void actionPerformed(ActionEvent e) {
//					if(idf.getText().equals(voall.getID())&&df.getText().equals(voall.getTime())&&
//							tnf.getText().equals(voall.getOrder())&&jcb.getSelectedItem().toString().equals(voall.getState())
//							&&dpf.getText().equals(voall.getFrom())){
//						JOptionPane.showMessageDialog(newin, "未发生改变");
//						InvoiceUI_LoadingListZZEdit.this.dispose();
//						new InvoiceUI_LoadingListZZEdit(voall,false);
//					}else{
						try{
							if(!df.getText().matches("\\d{4}-\\d{1,2}-\\d{1,2}")||tnf.getText()
									.length()!=21||cnf.getText().length()!=9){
								JOptionPane.showMessageDialog(newin,"修改信息格式错误");
							}else{
							InvoiceUI_LoadingListZZEdit.this.dispose();
							loadinglistzzdata.delete(getVO());
							newvo=new LoadingListZZVO(idf.getText(),df.getText(),tnf.getText(),apf.getText(),cnf.getText(),s1f.getText(),
									s2f.getText(),area.getText(),Double.valueOf(cf.getText()),jcb2.getSelectedItem().toString(),mf.getText(),"提交");
							loadinglistzzdata.record(newvo);
							new InvoiceUI_LoadingListZZEdit(newvo,false);
							}
						}catch(HeadlessException e2){
							e2.printStackTrace();
						}
						catch(IOException e2){
							e2.printStackTrace();
//						}				
					}
					
				}
				
			});
		}
		
		if(Edit){
			JButton back=new JButton("取消(C)");
			buttonpanel.add(back);
			back.setBounds(this.getWidth()/2-50,25,100,30);
			back.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					InvoiceUI_LoadingListZZEdit.this.dispose();
					new InvoiceUI_LoadingListZZEdit(getVO(),false);
				}
			});
			
		}
		else{
			JButton back=new JButton("删除(D)");
			buttonpanel.add(back);
			back.setBounds(this.getWidth()/2-50,25,100,30);
			back.addActionListener(new ActionListener(){
				LoadingListZZBL loadinglistzzdata=new LoadingListZZBL();

				public void actionPerformed(ActionEvent e) {
					try{
						loadinglistzzdata.delete(voall);
					}catch(IOException e1){
						e1.printStackTrace();
					}
					InvoiceUI_LoadingListZZEdit.this.dispose();
					JOptionPane.showMessageDialog(null, voall.getID()+"已删除");
					
				}
				
			});
			
			
		}
		
	}
}
