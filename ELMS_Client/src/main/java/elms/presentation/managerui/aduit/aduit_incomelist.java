package elms.presentation.managerui.aduit;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.rmi.RemoteException;

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
import elms.businesslogic.invoicebl.IncomeListBL;
import elms.vo.ArrivalListVO;
import elms.vo.IncomeListVO;

public class aduit_incomelist extends JFrame{
	Toolkit kit=Toolkit.getDefaultToolkit();
	Dimension screenSize=kit.getScreenSize();
	int screenWidth=(int) screenSize.getWidth();
	int screenHeight=(int)screenSize.getHeight();

	public aduit_incomelist(final IncomeListVO vo){
		setLayout(null);
		setResizable(false);
		setTitle("营业厅收入单: "+vo.getID());
		setBounds(screenWidth/4,screenHeight/4, screenWidth/3, 3*screenHeight/8);
		setVisible(true); 
		
		JPanel inf=new JPanel();inf.setLayout(null);
		add(inf);inf.setBounds(0,0,this.getWidth(),200);
		inf.setBorder(BorderFactory.createTitledBorder(""));
		
		JLabel id=new JLabel("ID");
		inf.add(id);id.setBounds(20,20,20,20);
		final JTextField idf=new JTextField();idf.setFont(new Font("SansSerif",Font.PLAIN,12));
		inf.add(idf);idf.setBounds(90,20,100,24);idf.setHorizontalAlignment(SwingConstants.CENTER);
		idf.setText(vo.getID());idf.setEditable(false);

		
		JLabel area=new JLabel("收费金额");
		inf.add(area);area.setBounds(this.getWidth()/2,20,100,20);
		final JTextField jc=new JTextField();jc.setFont(new Font("SansSerif",Font.PLAIN,12));
		inf.add(jc);jc.setBounds(this.getWidth()/2+80, 20, 100, 24);jc.setHorizontalAlignment(SwingConstants.CENTER);
		jc.setText(""+vo.getPostage());jc.setEditable(false);
		
		JLabel seat=new JLabel("收款日期");
		inf.add(seat);seat.setBounds(90,80,100,20);
		final JTextField sef=new JTextField();sef.setFont(new Font("SansSerif",Font.PLAIN,12));
		inf.add(sef);sef.setBounds(210,80,140,24);sef.setHorizontalAlignment(SwingConstants.CENTER);
		sef.setText(vo.getTime());  sef.setEditable(false);
	
		JLabel courier=new JLabel("快递员姓名");
		inf.add(courier);courier.setBounds(20,140,70,20);
		final JTextField cf=new JTextField();cf.setFont(new Font("SansSerif",Font.PLAIN,12));
		inf.add(cf);cf.setBounds(90,140,100,24);cf.setHorizontalAlignment(SwingConstants.CENTER);
		cf.setText(vo.getCourier());   cf.setEditable(false);
		
		JLabel orderID=new JLabel("订单条形码");
		inf.add(orderID);orderID.setBounds(this.getWidth()/2,140,100,20);
		final JTextField jcb=new JTextField();jcb.setFont(new Font("SansSerif",Font.PLAIN,12));
		inf.add(jcb);jcb.setBounds(this.getWidth()/2+80, 140, 100, 24);jcb.setHorizontalAlignment(SwingConstants.CENTER);
		jcb.setText(vo.getOrderID());  jcb.setEditable(false);
		
		JButton tg=new JButton("通过");add(tg);tg.setBounds(50,210,80,30);
		JButton refuse=new JButton("未通过");add(refuse);refuse.setBounds(180,210,80,30);
		JButton cancel=new JButton("取消");add(cancel);cancel.setBounds(310,210,80,30);
		
		tg.addActionListener(new ActionListener(){
			IncomeListBL  il=new IncomeListBL();
			public void actionPerformed(ActionEvent arg0) {
				try {
					il.AgreeAudit(vo.getID());JOptionPane.showMessageDialog(null, "审批通过！");
					aduit_main.arr2=il.findNoaudit();
					aduit_main.model.removeAllRows(aduit_main.model.getRowCount());
					for(IncomeListVO vo:aduit_main.arr2)	 aduit_main.model.addRow(aduit_main.model.changeRow_Icl(vo));	
					aduit_main.table.updateUI();
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				aduit_incomelist.this.dispose();
			}
			
		});
		refuse.addActionListener(new ActionListener(){
			IncomeListBL  il=new IncomeListBL();
			public void actionPerformed(ActionEvent arg0) {
			
				try {
					il.RefuseAudit(vo.getID());	JOptionPane.showMessageDialog(null, "审批不通过！");
					aduit_main.arr2=il.findNoaudit();
					aduit_main.model.removeAllRows(aduit_main.model.getRowCount());
					for(IncomeListVO vo:aduit_main.arr2)	 aduit_main.model.addRow(aduit_main.model.changeRow_Icl(vo));	
					aduit_main.table.updateUI();
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				aduit_incomelist.this.dispose();
			}
			
		});
		cancel.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				aduit_incomelist.this.dispose();
			}
			
		});
		
	}

}
