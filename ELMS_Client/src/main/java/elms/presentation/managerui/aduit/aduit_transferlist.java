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
import elms.businesslogic.invoicebl.TransferListBL;
import elms.vo.SendingListVO;
import elms.vo.TransferListVO;

public class aduit_transferlist extends JFrame{
	Toolkit kit=Toolkit.getDefaultToolkit();
	Dimension screenSize=kit.getScreenSize();
	int screenWidth=(int) screenSize.getWidth();
	int screenHeight=(int)screenSize.getHeight();
public static void main(String args[]){
	TransferListVO vo=new TransferListVO();
	new aduit_transferlist(vo);
}

public aduit_transferlist(final TransferListVO vo){
	setLayout(null);
	setResizable(false);
	setTitle("中转中心中转单:　"+vo.getID());
	setBounds(screenWidth/4,screenHeight/4, screenWidth/3, 3*screenHeight/8);
	setVisible(true); 
	JPanel inf=new JPanel();inf.setLayout(null);
	add(inf);inf.setBounds(0,0,this.getWidth(),210);
	inf.setBorder(BorderFactory.createTitledBorder(""));
	
	JLabel id=new JLabel("ID");
	inf.add(id);id.setBounds(20,20,20,20);
	final JTextField idf=new JTextField();idf.setFont(new Font("SansSerif",Font.PLAIN,12));
	inf.add(idf);idf.setBounds(90,20,100,24);idf.setHorizontalAlignment(SwingConstants.CENTER);
	idf.setText(vo.getID());  idf.setEditable(false);
	
	JLabel area=new JLabel("装车日期");
	inf.add(area);area.setBounds(this.getWidth()/2,20,100,20);
	final JTextField jc=new JTextField();jc.setFont(new Font("SansSerif",Font.PLAIN,12));
	inf.add(jc);jc.setBounds(this.getWidth()/2+80, 20, 120, 24);
	jc.setText(vo.getTime());    jc.setEditable(false);
	
	JLabel sn=new JLabel("中转单编号");
	inf.add(sn);sn.setBounds(20,60,80,20);
	final JTextField snf=new JTextField();snf.setFont(new Font("SansSerif",Font.PLAIN,12));
	inf.add(snf);snf.setBounds(90,60,100,24);snf.setHorizontalAlignment(SwingConstants.CENTER);
	snf.setText(vo.getTransferID());   snf.setEditable(false);
	
	JLabel tn=new JLabel("航班号/车次号");
	inf.add(tn);tn.setBounds(this.getWidth()/2,60,100,20);
	final JTextField tnc=new JTextField();tnc.setFont(new Font("SansSerif",Font.PLAIN,12));
	inf.add(tnc);tnc.setBounds(this.getWidth()/2+80, 60, 120, 24);
	tnc.setText(vo.getTransportNum());  tnc.setEditable(false);
	
	JLabel ar=new JLabel("出发地");
	inf.add(ar);ar.setBounds(20,100,80,20);
	final JTextField arf=new JTextField();arf.setFont(new Font("SansSerif",Font.PLAIN,12));
	inf.add(arf);arf.setBounds(90,100,100,24);arf.setHorizontalAlignment(SwingConstants.CENTER);
	arf.setText(vo.getDeparture());  arf.setEditable(false);
	
	JLabel cn=new JLabel("到达地");
	inf.add(cn);cn.setBounds(this.getWidth()/2,100,100,20);
	final JTextField cnc=new JTextField();cnc.setFont(new Font("SansSerif",Font.PLAIN,12));
	inf.add(cnc);cnc.setBounds(this.getWidth()/2+80, 100, 120, 24);
	cnc.setText(vo.getArrival());cnc.setEditable(false);
	
	JLabel surpervisor=new JLabel("货柜号");
	inf.add(surpervisor);surpervisor.setBounds(20,140,80,20);
	final JTextField surpervisorf=new JTextField();surpervisorf.setFont(new Font("SansSerif",Font.PLAIN,12));
	inf.add(surpervisorf);surpervisorf.setBounds(90,140,100,24);surpervisorf.setHorizontalAlignment(SwingConstants.CENTER);
	surpervisorf.setText(vo.getSeatNumber());  surpervisorf.setEditable(false);
	
	JLabel supercargo=new JLabel("监装员");
	inf.add(supercargo);supercargo.setBounds(this.getWidth()/2,140,100,20);
	final JTextField supercargoc=new JTextField();supercargoc.setFont(new Font("SansSerif",Font.PLAIN,12));
	inf.add(supercargoc);supercargoc.setBounds(this.getWidth()/2+80, 140, 120, 24);
	supercargoc.setText(vo.getSurpervior());supercargoc.setEditable(false);
	
	JLabel on=new JLabel("托运订单");
	inf.add(on);on.setBounds(20,180,80,20);
	final JTextField jcb=new JTextField();jcb.setFont(new Font("楷体",Font.CENTER_BASELINE,12));jcb.setHorizontalAlignment(SwingConstants.CENTER);
	inf.add(jcb);jcb.setBounds(90, 180, 100, 24);jcb.setBackground(Color.white);
	jcb.setText(vo.getOrderID());  jcb.setEditable(false);
	
	JLabel cost=new JLabel("运费");
	inf.add(cost);cost.setBounds(this.getWidth()/2,180,100,20);
	final JTextField costf=new JTextField();costf.setFont(new Font("SansSerif",Font.PLAIN,12));
	inf.add(costf);costf.setBounds(this.getWidth()/2+80, 180, 120, 24);
	costf.setText(""+vo.getCost());  costf.setEditable(false);
	
	JButton tg=new JButton("通过");add(tg);tg.setBounds(50,220,80,30);
	JButton refuse=new JButton("未通过");add(refuse);refuse.setBounds(180,220,80,30);
	JButton cancel=new JButton("取消");add(cancel);cancel.setBounds(310,220,80,30);
	
	tg.addActionListener(new ActionListener(){
		TransferListBL  tl=new TransferListBL();
		public void actionPerformed(ActionEvent arg0) {
			try {
				tl.AgreeAudit(vo.getID());JOptionPane.showMessageDialog(null, "审批通过！");
				aduit_main.arr7=tl.findNoaudit();
				aduit_main.model.removeAllRows(aduit_main.model.getRowCount());
				for(TransferListVO vo:aduit_main.arr7)	 aduit_main.model.addRow(aduit_main.model.changeRow_Trl(vo));	
				aduit_main.table.updateUI();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			aduit_transferlist.this.dispose();
		}
		
	});
	refuse.addActionListener(new ActionListener(){
		TransferListBL  tl=new TransferListBL();
		public void actionPerformed(ActionEvent arg0) {
		
			try {
				tl.RefuseAudit(vo.getID());
			JOptionPane.showMessageDialog(null, "审批不通过！");
				aduit_main.arr7=tl.findNoaudit();
				aduit_main.model.removeAllRows(aduit_main.model.getRowCount());
				for(TransferListVO vo:aduit_main.arr7)	 aduit_main.model.addRow(aduit_main.model.changeRow_Trl(vo));	
				aduit_main.table.updateUI();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			aduit_transferlist.this.dispose();
		}
		
	});
	cancel.addActionListener(new ActionListener(){

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			aduit_transferlist.this.dispose();
		}
		
	});
}
}