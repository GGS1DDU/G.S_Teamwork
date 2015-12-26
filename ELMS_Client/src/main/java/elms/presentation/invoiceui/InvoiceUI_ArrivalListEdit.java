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
import elms.vo.ArrivalListVO;

public class InvoiceUI_ArrivalListEdit extends JFrame{
	ArrivalListVO voall;
	Toolkit kit=Toolkit.getDefaultToolkit();
	Dimension screenSize=kit.getScreenSize();
	int screenWidth=(int) screenSize.getWidth();
	int screenHeight=(int) screenSize.getHeight();
	boolean Edit;
	
	public ArrivalListVO getVO(){
		return voall;
	}
	
	public InvoiceUI_ArrivalListEdit(ArrivalListVO vo,boolean edit){
		voall=vo;
		setLayout(null);
		setTitle("到达单  No："+vo.getID());
		setResizable(false);
		setBounds(screenWidth/4,screenHeight/4,screenWidth/3,3*screenHeight/8+40);
		setVisible(true);
		
		Edit=edit;
		
		final JPanel newin=new JPanel();
		newin.setLayout(null);
		add(newin);newin.setBounds(0,0,this.getWidth(),7*this.getHeight()/10);
		newin.setBorder(BorderFactory.createTitledBorder(""));
		
		JLabel id=new JLabel("单据ID");
		newin.add(id);id.setBounds(120,10,80,20);
		final JTextField idf=new JTextField(vo.getID());
		newin.add(idf);idf.setBounds(220, 10, 100, 24);
		idf.setEditable(Edit);
		idf.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel transferNum=new JLabel("中转单编号");
		newin.add(transferNum);transferNum.setBounds(120,40,80,20);
		final JTextField tnf=new JTextField(vo.getOrder());
		tnf.setFont(new Font("SansSerif",Font.CENTER_BASELINE,12));
		newin.add(tnf);tnf.setBounds(220, 40, 160, 24);tnf.setEditable(Edit);
		tnf.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel date=new JLabel("到达日期");
		newin.add(date);date.setBounds(120,70,80,20);
		final JTextField df=new JTextField(vo.getTime());
		df.setFont(new Font("Dialog",Font.CENTER_BASELINE,12));
		newin.add(df);df.setBounds(220, 70, 100, 24);
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
		
		
		JLabel state=new JLabel("到达状态");
		newin.add(state);state.setBounds(120, 100, 80, 20);
		final JComboBox<String> jcb=new JComboBox<String>();
		if(Edit){
			jcb.addItem("完整");jcb.addItem("损坏");jcb.addItem("丢失");
			jcb.setBackground(Color.WHITE);jcb.setFont(new Font("楷体",Font.BOLD,12));
			newin.add(jcb);jcb.setBounds(220, 100, 100, 24);
			jcb.setSelectedItem(vo.getState());
			
		}else{
			JLabel sf=new JLabel(vo.getState());sf.setFont(new Font("楷体",Font.BOLD,12));
			sf.setOpaque(false);
			newin.add(sf);
			sf.setBounds(220, 100, 100, 24);
			sf.setHorizontalAlignment(SwingConstants.CENTER);
			sf.setEnabled(false);
		}
		
		JLabel departurePlace=new JLabel("出发地");
		newin.add(departurePlace);
		departurePlace.setBounds(120, 130, 80, 20);
		final JTextField dpf=new JTextField(vo.getFrom());
		dpf.setFont(new Font("SansSerif",Font.PLAIN,12));
		newin.add(dpf);dpf.setBounds(220, 130, 100, 24);dpf.setEditable(Edit);
		dpf.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel place=new JLabel("所属营业厅");
		newin.add(place);
		place.setBounds(120, 160, 80, 20);
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
			pf.setBounds(220, 160, 100, 24);
			pf.setHorizontalAlignment(SwingConstants.CENTER);
			pf.setEnabled(false);
		}
		
		JLabel maker=new JLabel("单据生成者");
		newin.add(maker);
		maker.setBounds(120, 190, 80, 20);
		final JTextField mf=new JTextField(vo.getMaker());
		mf.setFont(new Font("SansSerif",Font.PLAIN,12));
		newin.add(mf);mf.setBounds(220, 190, 100, 24);mf.setEditable(Edit);
		mf.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel buttonpanel=new JPanel();
		buttonpanel.setLayout(null);
		JButton cancle=new JButton("编辑(E)");
		buttonpanel.add(cancle);
		cancle.setBounds(this.getWidth()/2+90,20,100,30);
		add(buttonpanel);
		buttonpanel.setBounds(0,7*this.getHeight()/10,this.getWidth(),70);
		
		cancle.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				InvoiceUI_ArrivalListEdit.this.dispose();
				new InvoiceUI_ArrivalListEdit(getVO(),true);
			}
		});
		
		if(Edit){
			JButton save=new JButton("保存(S)");
			buttonpanel.add(save);
			save.setBounds(this.getWidth()/3-120,20,100,30);
			
			save.addActionListener(new ActionListener(){
				ArrivalListBL arrivallistdata=new ArrivalListBL();
				ArrivalListVO newvo;

				public void actionPerformed(ActionEvent e) {
					if(idf.getText().equals(voall.getID())&&df.getText().equals(voall.getTime())&&
							tnf.getText().equals(voall.getOrder())&&jcb.getSelectedItem().toString().equals(voall.getState())
							&&dpf.getText().equals(voall.getFrom())){
						JOptionPane.showMessageDialog(newin, "未发生改变");
						InvoiceUI_ArrivalListEdit.this.dispose();
						new InvoiceUI_ArrivalListEdit(voall,false);
					}else{
						try{
							if(df.getText().matches("\\d{4}-\\d{2}-\\d{2}\\s")||tnf.getText().length()!=6){
								JOptionPane.showMessageDialog(newin,"修改信息格式错误");
							}else{
							InvoiceUI_ArrivalListEdit.this.dispose();
							arrivallistdata.delete(getVO());
							arrivallistdata.record(newvo);
							newvo=new ArrivalListVO(idf.getText(),tnf.getText(),df.getText(),jcb.getSelectedItem().toString(),
									dpf.getText(),jcb2.getSelectedItem().toString(),mf.getText(),"提交");
							new InvoiceUI_ArrivalListEdit(newvo,false);
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
			back.setBounds(this.getWidth()/2-50,20,100,30);
			back.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					InvoiceUI_ArrivalListEdit.this.dispose();
					new InvoiceUI_ArrivalListEdit(getVO(),false);
				}
			});
			
		}
		else{
			JButton back=new JButton("删除(D)");
			buttonpanel.add(back);
			back.setBounds(this.getWidth()/2-50,20,100,30);
			back.addActionListener(new ActionListener(){
				ArrivalListBL arrivallistdata=new ArrivalListBL();

				public void actionPerformed(ActionEvent e) {
					try{
						arrivallistdata.delete(voall);
					}catch(IOException e1){
						e1.printStackTrace();
					}
					InvoiceUI_ArrivalListEdit.this.dispose();
					JOptionPane.showMessageDialog(null, voall.getID()+"已删除");
					
				}
				
			});
			
			
		}
		
	}

}
