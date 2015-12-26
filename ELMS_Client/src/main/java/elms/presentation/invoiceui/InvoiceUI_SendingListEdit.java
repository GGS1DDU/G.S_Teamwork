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
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import elms.businesslogic.invoicebl.ArrivalListBL;
import elms.businesslogic.invoicebl.SendingListBL;
import elms.vo.ArrivalListVO;
import elms.vo.SendingListVO;

public class InvoiceUI_SendingListEdit extends JFrame{
	SendingListVO voall;
	Toolkit kit=Toolkit.getDefaultToolkit();
	Dimension screenSize=kit.getScreenSize();
	int screenWidth=(int) screenSize.getWidth();
	int screenHeight=(int) screenSize.getHeight();
	boolean Edit;
	
	public SendingListVO getVO(){
		return voall;
	}

	public InvoiceUI_SendingListEdit(SendingListVO vo, boolean edit) {
		voall=vo;
		setLayout(null);
		setTitle("派件单  No："+vo.getID());
		setResizable(false);
		setBounds(screenWidth/4,screenHeight/4,screenWidth/3,3*screenHeight/8+40);
		setVisible(true);
		
		Edit=edit;
		
		final JPanel newin=new JPanel();
		newin.setLayout(null);
		add(newin);newin.setBounds(0,0,this.getWidth(),3*this.getHeight()/5);
		newin.setBorder(BorderFactory.createTitledBorder(""));
		
		JLabel id=new JLabel("单据ID");
		newin.add(id);
		id.setBounds(100,10,80,20);
		final JTextField idf=new JTextField(vo.getID());
		newin.add(idf);
		idf.setBounds(220,10,100,24);
		idf.setEditable(Edit);
		idf.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel orderNum=new JLabel("托运订单条形号码");
		newin.add(orderNum);orderNum.setBounds(100,40,120,20);
		final JTextField onf=new JTextField(vo.getOrderID());
		onf.setFont(new Font("SansSerif",Font.CENTER_BASELINE,12));
		newin.add(onf);onf.setBounds(220, 40, 100, 24);onf.setEditable(Edit);
		onf.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel courier=new JLabel("派件员");
		newin.add(courier);
		courier.setBounds(100, 70, 80, 20);
		final JTextField cf=new JTextField(vo.getCourier());
		cf.setFont(new Font("SansSerif",Font.PLAIN,12));
		newin.add(cf);cf.setBounds(220, 70, 100, 24);cf.setEditable(Edit);
		cf.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel date=new JLabel("到达日期");
		newin.add(date);date.setBounds(100,100,80,20);
		final JTextField df=new JTextField(vo.getTime());
		df.setFont(new Font("Dialog",Font.CENTER_BASELINE,12));
		newin.add(df);df.setBounds(220, 100, 100, 24);
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
		
		JLabel place=new JLabel("所属营业厅");
		newin.add(place);
		place.setBounds(100, 130, 80, 20);
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
			pf.setBounds(220, 130, 100, 24);
			pf.setHorizontalAlignment(SwingConstants.CENTER);
			pf.setEnabled(false);
		}
			
		JLabel maker=new JLabel("单据生成者");
		newin.add(maker);
		maker.setBounds(100, 160, 80, 20);
		final JTextField mf=new JTextField(vo.getMaker());
		mf.setFont(new Font("SansSerif",Font.PLAIN,12));
		newin.add(mf);mf.setBounds(220, 160, 100, 24);mf.setEditable(Edit);
		mf.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel buttonpanel=new JPanel();
		buttonpanel.setLayout(null);
		JButton cancle=new JButton("编辑(E)");
		buttonpanel.add(cancle);
		cancle.setBounds(this.getWidth()/2+90,25,100,30);
		add(buttonpanel);
		buttonpanel.setBounds(0,3*this.getHeight()/5,this.getWidth(),70);
		
		cancle.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				InvoiceUI_SendingListEdit.this.dispose();
				new InvoiceUI_SendingListEdit(getVO(),true);
			}
		});
		
		if(Edit){
			JButton save=new JButton("保存(S)");
			buttonpanel.add(save);
			save.setBounds(this.getWidth()/3-120,25,100,30);
			
			save.addActionListener(new ActionListener(){
				SendingListBL sendinglistdata=new SendingListBL();
				SendingListVO newvo;

				public void actionPerformed(ActionEvent e) {
					if(idf.getText().equals(voall.getID())&&df.getText().equals(voall.getTime())
							&&onf.getText().equals(voall.getOrderID())&&cf.getText().equals(voall.getCourier())){
						JOptionPane.showMessageDialog(newin, "未发生改变");
						InvoiceUI_SendingListEdit.this.dispose();
						new InvoiceUI_SendingListEdit(voall,false);
					}else{
						try{
							if(df.getText().matches("\\d{4}-\\d{2}-\\d{2}\\s")||onf.getText().length()!=10){
								JOptionPane.showMessageDialog(newin,"修改信息格式错误");
							}else{
							InvoiceUI_SendingListEdit.this.dispose();
							sendinglistdata.delete(getVO());
							newvo=new SendingListVO(idf.getText(),onf.getText(),cf.getText(),df.getText(),jcb2.getSelectedItem().toString(),mf.getText(),"提交");
							sendinglistdata.record(newvo);
							new InvoiceUI_SendingListEdit(newvo,false);
							}
						}catch(HeadlessException e2){
							e2.printStackTrace();
						}
						catch(IOException e2){
							e2.printStackTrace();
						}				
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
					InvoiceUI_SendingListEdit.this.dispose();
					new InvoiceUI_SendingListEdit(getVO(),false);
				}
			});			
		}
		else{
			JButton back=new JButton("删除(D)");
			buttonpanel.add(back);
			back.setBounds(this.getWidth()/2-50,25,100,30);
			back.addActionListener(new ActionListener(){
				SendingListBL sendinglistdata=new SendingListBL();

				public void actionPerformed(ActionEvent e) {
					try{
						sendinglistdata.delete(voall);
					}catch(IOException e1){
						e1.printStackTrace();
					}
					InvoiceUI_SendingListEdit.this.dispose();
					JOptionPane.showMessageDialog(null, voall.getID()+"已删除");					
				}				
			});			
		}		
	}
}
