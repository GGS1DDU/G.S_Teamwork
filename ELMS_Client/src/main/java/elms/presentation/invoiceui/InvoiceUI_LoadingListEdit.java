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

import elms.businesslogic.invoicebl.ArrivalListBL;
import elms.businesslogic.invoicebl.LoadingListBL;
import elms.presentation.uihelper.MyPanel;
import elms.vo.ArrivalListVO;
import elms.vo.LoadingListVO;

public class InvoiceUI_LoadingListEdit extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3827322962961694877L;
	LoadingListVO voall;
	Toolkit kit=Toolkit.getDefaultToolkit();
	Dimension screenSize=kit.getScreenSize();
	int screenWidth=(int) screenSize.getWidth();
	int screenHeight=(int) screenSize.getHeight();
	boolean Edit;
	
//	public static void main(String[] args){
//		LoadingListVO vo=new LoadingListVO("","","","","","","","","",1.2,"","","");
//		boolean edit=false;
//		new InvoiceUI_LoadingListEdit(vo,edit);
//	}
	
	public LoadingListVO getVO(){
		return voall;
	}
	
	public InvoiceUI_LoadingListEdit(LoadingListVO vo,boolean edit){
		voall=vo;
		setLayout(null);
		setTitle("装车单  No："+vo.getID());
		setResizable(false);
		setBounds(screenWidth/4,screenHeight/4,4*screenWidth/9,5*screenHeight/8-50);
		setVisible(true);
		
		Edit=edit;
		
		MyPanel p=new MyPanel("bg3.png");
		add(p);p.setBounds(0, 0, this.getWidth(), this.getHeight());
		
		final JPanel newin=new JPanel();newin.setOpaque(false);
		newin.setLayout(null);
		p.add(newin);newin.setBounds(0,0,this.getWidth(),3*this.getHeight()/5+55);
		newin.setBorder(BorderFactory.createTitledBorder(""));
		
		JLabel id=new JLabel("单据ID");
		//前两位ll 后面五位数字
		newin.add(id);id.setBounds(60,20,80,20);
		final JTextField idf=new JTextField(vo.getID());
		newin.add(idf);idf.setBounds(160, 20, 100, 24);
		idf.setEditable(Edit);
		idf.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel date=new JLabel("装车日期");
		newin.add(date);date.setBounds(310,20,80,20);
		final JTextField df=new JTextField(vo.getTime());
		df.setFont(new Font("Dialog",Font.CENTER_BASELINE,12));
		newin.add(df);df.setBounds(410,20,100,24);
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
		
		JLabel shopNum=new JLabel("营业厅编号");
		newin.add(shopNum);shopNum.setBounds(60,60,80,20);
		final JTextField snf=new JTextField(vo.getShopNumber());
		snf.setFont(new Font("SansSerif",Font.CENTER_BASELINE,12));
		newin.add(snf);snf.setBounds(160,60,100,24);snf.setEditable(Edit);
		snf.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel transNum=new JLabel("汽运编号");
		//20位
		newin.add(transNum);transNum.setBounds(310,60,80,20);
		final JTextField tnf=new JTextField(vo.getTransportNumber());
		tnf.setFont(new Font("SansSerif",Font.CENTER_BASELINE,12));
		newin.add(tnf);tnf.setBounds(410,60,100,24);tnf.setEditable(Edit);
		tnf.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel arrivalPlace=new JLabel("到达地");
		newin.add(arrivalPlace);
		arrivalPlace.setBounds(60,100,80,20);
		final JTextField apf=new JTextField(vo.getArrival());
		apf.setFont(new Font("SansSerif",Font.PLAIN,12));
		newin.add(apf);apf.setBounds(160,100,100,24);apf.setEditable(Edit);
		apf.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel carNum=new JLabel("车辆代号");
		newin.add(carNum);carNum.setBounds(310,100,80,20);
		final JTextField cnf=new JTextField(vo.getCarNumber());
		cnf.setFont(new Font("SansSerif",Font.CENTER_BASELINE,12));
		newin.add(cnf);cnf.setBounds(410,100,100,24);cnf.setEditable(Edit);
		cnf.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel supervisor=new JLabel("监装员");
		newin.add(supervisor);supervisor.setBounds(60,140,80,20);
		final JTextField s1f=new JTextField(vo.getSurpervior());
		s1f.setFont(new Font("SansSerif",Font.CENTER_BASELINE,12));
		newin.add(s1f);s1f.setBounds(160,140,100,24);s1f.setEditable(Edit);
		s1f.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel supercargo=new JLabel("押运员");
		newin.add(supercargo);supercargo.setBounds(310,140,80,20);
		final JTextField s2f=new JTextField(vo.getSupercargo());
		s2f.setFont(new Font("SansSerif",Font.CENTER_BASELINE,12));
		newin.add(s2f);s2f.setBounds(410,140,100,24);s2f.setEditable(Edit);
		s2f.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel orderNum=new JLabel("订单条形号码");
		newin.add(orderNum);orderNum.setBounds(60,180,80,20);
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
		pane.setBounds(160,180,100,64);
		
		JLabel cost=new JLabel("运费");
		newin.add(cost);cost.setBounds(310,180,80,20);
		final JTextField cf=new JTextField(String.valueOf(vo.getCost()));
		cf.setFont(new Font("SansSerif",Font.CENTER_BASELINE,12));
		newin.add(cf);cf.setBounds(410,180,100,24);cf.setEditable(Edit);
		cf.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel place=new JLabel("所属营业厅");
		newin.add(place);
		place.setBounds(60,260,80,20);
		final JComboBox<String> jcb2=new JComboBox<String>();
		if(Edit){
			jcb2.addItem("南京仙林");jcb2.addItem("南京鼓楼");
			jcb2.setBackground(Color.WHITE);jcb2.setFont(new Font("楷体",Font.BOLD,12));
			newin.add(jcb2);jcb2.setBounds(160,260,100,24);
			jcb2.setSelectedItem(vo.getPlace());
			
		}else{
			JLabel pf=new JLabel(vo.getPlace());pf.setFont(new Font("楷体",Font.BOLD,12));
			pf.setOpaque(false);
			newin.add(pf);
			pf.setBounds(160,260,100,24);
			pf.setHorizontalAlignment(SwingConstants.CENTER);
			pf.setEnabled(false);
		}
		
		JLabel maker=new JLabel("单据生成者");
		newin.add(maker);
		maker.setBounds(310,260,80,20);
		final JTextField mf=new JTextField(vo.getMaker());
		mf.setFont(new Font("SansSerif",Font.PLAIN,12));
		newin.add(mf);mf.setBounds(410,260,100,24);mf.setEditable(Edit);
		mf.setHorizontalAlignment(SwingConstants.CENTER);
		
	
		
		if(Edit){
			JPanel buttonpanel=new JPanel();
			buttonpanel.setLayout(null);
			JButton cancle=new JButton("编辑(E)");
			buttonpanel.add(cancle);
			cancle.setBounds(this.getWidth()/2+90,25,100,30);
			p.add(buttonpanel);
			buttonpanel.setBounds(0,3*this.getHeight()/5+55,this.getWidth(),70);
			
			cancle.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					InvoiceUI_LoadingListEdit.this.dispose();
					new InvoiceUI_LoadingListEdit(getVO(),true);
				}
			});
			
			JButton save=new JButton("保存(S)");
			buttonpanel.add(save);
			save.setBounds(this.getWidth()/3-120,25,100,30);
			
			save.addActionListener(new ActionListener(){
				LoadingListBL loadinglistdata=new LoadingListBL();
				LoadingListVO newvo;

				public void actionPerformed(ActionEvent e) {
//					if(idf.getText().equals(voall.getID())&&df.getText().equals(voall.getTime())&&
//							tnf.getText().equals(voall.getOrder())&&jcb.getSelectedItem().toString().equals(voall.getState())
//							&&dpf.getText().equals(voall.getFrom())){
//						JOptionPane.showMessageDialog(newin, "未发生改变");
//						InvoiceUI_LoadingListEdit.this.dispose();
//						new InvoiceUI_LoadingListEdit(voall,false);
//					}else{
						try{
							if(!df.getText().matches("\\d{4}-\\d{1,2}-\\d{1,2}")||snf.getText().length()!=7||tnf.getText()
									.length()!=20||cnf.getText().length()!=9){
								JOptionPane.showMessageDialog(newin,"修改信息格式错误");
							}else{
							InvoiceUI_LoadingListEdit.this.dispose();
							loadinglistdata.delete(getVO());
							newvo=new LoadingListVO(idf.getText(),df.getText(),snf.getText(),tnf.getText(),apf.getText(),
									cnf.getText(),s1f.getText(),s2f.getText(),area.getText(),Double.valueOf(cf.getText()),jcb2.getSelectedItem().toString(),
									mf.getText(),"提交");
							loadinglistdata.record(newvo);
							new InvoiceUI_LoadingListEdit(newvo,false);
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
			JButton back=new JButton("取消(C)");
			buttonpanel.add(back);
			back.setBounds(this.getWidth()/2-65,25,100,30);
			back.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					InvoiceUI_LoadingListEdit.this.dispose();
					new InvoiceUI_LoadingListEdit(getVO(),false);
				}
			});
		}
		
		else{
			JPanel buttonpanel=new JPanel();
			buttonpanel.setLayout(null);
			JButton cancle=new JButton("编辑(E)");
			buttonpanel.add(cancle);
			cancle.setBounds(this.getWidth()/2+70, 25, 100, 30);
			p.add(buttonpanel);
			buttonpanel.setBounds(0,3*this.getHeight()/5+55,this.getWidth(),70);
			
			cancle.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					InvoiceUI_LoadingListEdit.this.dispose();
					new InvoiceUI_LoadingListEdit(getVO(),true);
				}
			});
			
			JButton back=new JButton("删除(D)");
			buttonpanel.add(back);
			back.setBounds(this.getWidth()/2-180, 25,100,30);
			back.addActionListener(new ActionListener(){
				LoadingListBL loadinglistdata=new LoadingListBL();

				public void actionPerformed(ActionEvent e) {
					try{
						loadinglistdata.delete(voall);
					}catch(IOException e1){
						e1.printStackTrace();
					}
					InvoiceUI_LoadingListEdit.this.dispose();
					JOptionPane.showMessageDialog(null, voall.getID()+"已删除");
					
				}
				
			});
			
			
		}
		
	}

}
