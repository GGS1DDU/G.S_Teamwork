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

import elms.businesslogic.invoicebl.IncomeListBL;
import elms.vo.IncomeListVO;

public class InvoiceUI_IncomeListEdit extends JFrame{
	IncomeListVO voall;
	Toolkit kit=Toolkit.getDefaultToolkit();
	Dimension screenSize=kit.getScreenSize();
	int screenWidth=(int) screenSize.getWidth();
	int screenHeight=(int) screenSize.getHeight();
	boolean Edit;
	
	public IncomeListVO getVO(){
		return voall;
	}
	
	public InvoiceUI_IncomeListEdit(IncomeListVO vo,boolean edit){
		voall=vo;
		setLayout(null);
		setTitle("收款单  No："+vo.getID());
		setResizable(false);
		setBounds(screenWidth/4,screenHeight/4,screenWidth/3,screenHeight/2+80);
		setVisible(true);
		
		Edit=edit;
		
		final JPanel newin=new JPanel();
		newin.setLayout(null);
		add(newin);newin.setBounds(0,0,this.getWidth(),7*this.getHeight()/10+10);
		newin.setBorder(BorderFactory.createTitledBorder(""));
		
		JLabel id=new JLabel("单据ID");
		//前两位il 后面五位数字
		newin.add(id);id.setBounds(120,20,80,20);
		final JTextField idf=new JTextField(vo.getID());
		newin.add(idf);idf.setBounds(220, 20, 100, 24);
		idf.setEditable(Edit);
		idf.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel income=new JLabel("收费金额");
		newin.add(income);income.setBounds(120,60,80,20);
		final JTextField icf=new JTextField(String.valueOf(vo.getPostage()));
		icf.setFont(new Font("SansSerif",Font.CENTER_BASELINE,12));
		newin.add(icf);icf.setBounds(220, 60, 80, 24);icf.setEditable(Edit);
		icf.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel courierName=new JLabel("快递员姓名");
		newin.add(courierName);courierName.setBounds(120,100,80,20);
		final JTextField cnf=new JTextField(vo.getCourier());
		cnf.setFont(new Font("Dialog",Font.CENTER_BASELINE,12));
		newin.add(cnf);cnf.setBounds(220, 100, 100, 24);
		cnf.setEditable(Edit);
		cnf.setHorizontalAlignment(SwingConstants.CENTER);
				
		JLabel date=new JLabel("收款日期");
		newin.add(date);date.setBounds(120,140,80,20);
		final JTextField df=new JTextField(vo.getTime());
		df.setFont(new Font("Dialog",Font.CENTER_BASELINE,12));
		newin.add(df);df.setBounds(220, 140, 100, 24);
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
		
		JLabel orderNum=new JLabel("订单条形号码");
		newin.add(orderNum);orderNum.setBounds(120,180,80,20);
//		ArrayList<String> arr=new ArrayList<String>(vo.getOrderID());
//		String[] strs=new String[arr.size()];
//		String str=null;
//		for(int i=0;i<arr.size();i++){
//			strs[i]=arr.get(i)+"\n";
//			str+=strs[i];
//		}		
//		final JTextArea area=new JTextArea(str);
		final JTextArea area=new JTextArea(vo.getOrderID());
		area.setLineWrap(true);
		area.setFont(new Font("SanSerif",Font.PLAIN,12));
		JScrollPane pane=new JScrollPane(area,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		newin.add(pane);
		pane.setViewportView(area);
		pane.setBounds(220,180,100,64);
		
		JLabel place=new JLabel("所属营业厅");
		newin.add(place);
		place.setBounds(120, 260, 80, 20);
		final JComboBox<String> jcb2=new JComboBox<String>();
		if(Edit){
			jcb2.addItem("南京仙林");jcb2.addItem("南京鼓楼");
			jcb2.setBackground(Color.WHITE);jcb2.setFont(new Font("楷体",Font.BOLD,12));
			newin.add(jcb2);jcb2.setBounds(220, 260, 100, 24);
			jcb2.setSelectedItem(vo.getPlace());
			
		}else{
			JLabel pf=new JLabel(vo.getPlace());pf.setFont(new Font("楷体",Font.BOLD,12));
			pf.setOpaque(false);
			newin.add(pf);
			pf.setBounds(220, 260, 100, 24);
			pf.setHorizontalAlignment(SwingConstants.CENTER);
			pf.setEnabled(false);
		}
		
		JLabel maker=new JLabel("单据生成者");
		newin.add(maker);
		maker.setBounds(120, 300, 80, 20);
		final JTextField mf=new JTextField(vo.getMaker());
		mf.setFont(new Font("SansSerif",Font.PLAIN,12));
		newin.add(mf);mf.setBounds(220, 300, 100, 24);mf.setEditable(Edit);
		mf.setHorizontalAlignment(SwingConstants.CENTER);
			
		JPanel buttonpanel=new JPanel();
		buttonpanel.setLayout(null);
		JButton cancle=new JButton("编辑(E)");
		buttonpanel.add(cancle);
		cancle.setBounds(this.getWidth()/2+90,25,100,30);
		add(buttonpanel);
		buttonpanel.setBounds(0,7*this.getHeight()/10+10,this.getWidth(),70);
		
		cancle.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				InvoiceUI_IncomeListEdit.this.dispose();
				new InvoiceUI_IncomeListEdit(getVO(),true);
			}
		});
		
		if(Edit){
			JButton save=new JButton("保存(S)");
			buttonpanel.add(save);
			save.setBounds(this.getWidth()/3-120,25,100,30);
			
			save.addActionListener(new ActionListener(){
				IncomeListBL incomelistdata=new IncomeListBL();
				IncomeListVO newvo;

				public void actionPerformed(ActionEvent e) {
//					if(idf.getText().equals(voall.getID())&&df.getText().equals(voall.getTime())&&
//							cnf.getText().equals(voall.getCourier())){
//						JOptionPane.showMessageDialog(newin, "未发生改变");
//						InvoiceUI_IncomeListEdit.this.dispose();
//						new InvoiceUI_IncomeListEdit(voall,false);
//					}else{
						try{
							if(df.getText().matches("\\d{4}-\\d{2}-\\d{2}\\s")){
								JOptionPane.showMessageDialog(newin,"修改信息格式错误");
							}else{
							InvoiceUI_IncomeListEdit.this.dispose();
							incomelistdata.delete(getVO());
							newvo=new IncomeListVO(idf.getText(),Double.valueOf(icf.getText()),cnf.getText(),df.getText(),area.getText(),
									jcb2.getSelectedItem().toString(),mf.getText(),"提交");
							incomelistdata.record(newvo);
							new InvoiceUI_IncomeListEdit(newvo,false);
							}
						}catch(HeadlessException e2){
							e2.printStackTrace();
						}
						catch(IOException e2){
							e2.printStackTrace();
						}				
//					}					
				}				
			});
		}
		
		if(Edit){
			JButton back=new JButton("取消(C)");
			buttonpanel.add(back);
			back.setBounds(this.getWidth()/2-50,25,100,30);
			back.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					InvoiceUI_IncomeListEdit.this.dispose();
					new InvoiceUI_IncomeListEdit(getVO(),false);
				}
			});			
		}
		else{
			JButton back=new JButton("删除(D)");
			buttonpanel.add(back);
			back.setBounds(this.getWidth()/2-50,25,100,30);
			back.addActionListener(new ActionListener(){
				IncomeListBL incomelistdata=new IncomeListBL();

				public void actionPerformed(ActionEvent e) {
					try{
						incomelistdata.delete(voall);
					}catch(IOException e1){
						e1.printStackTrace();
					}
					InvoiceUI_IncomeListEdit.this.dispose();
					JOptionPane.showMessageDialog(null, voall.getID()+"已删除");					
				}				
			});
			
			
		}
		
	}

}
