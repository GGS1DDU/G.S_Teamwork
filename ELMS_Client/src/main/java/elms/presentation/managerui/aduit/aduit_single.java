package elms.presentation.managerui.aduit;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import elms.businesslogic.invoicebl.ArrivalListBL;
import elms.businesslogic.invoicebl.IncomeListBL;
import elms.businesslogic.invoicebl.LoadingListBL;
import elms.businesslogic.invoicebl.LoadingListZZBL;
import elms.businesslogic.invoicebl.RecivalListBL;
import elms.businesslogic.invoicebl.TransferListBL;
import elms.vo.ArrivalListVO;
import elms.vo.IncomeListVO;
import elms.vo.LoadingListVO;
import elms.vo.LoadingListZZVO;
import elms.vo.RecivalListVO;
import elms.vo.TransferListVO;

public class aduit_single extends JFrame {
	Toolkit kit=Toolkit.getDefaultToolkit();
	Dimension screenSize=kit.getScreenSize();
	int screenWidth=(int) screenSize.getWidth();
	int screenHeight=(int)screenSize.getHeight();
public aduit_single(){
	setLayout(null);
	setTitle("单项审批");
	setResizable(false);
	setBounds(screenWidth/4,screenHeight/4,screenWidth/4, screenHeight/4);
	setVisible(true);

	
	final JTextField idf=new JTextField();
	JLabel ID=new JLabel("Order-ID");
	add(ID);
	ID.setBounds(60, 40, 100, 30);
	add(idf);
	idf.setBounds(this.getWidth()/2-14,40,150,28);
	JButton ok=new JButton("查询");
	JButton cancle=new JButton("取消");
	add(ok);ok.setBounds(this.getWidth()/2-120,3*this.getHeight()/5+10,70,25);
	add(cancle);cancle.setBounds(this.getWidth()/2+40,3*this.getHeight()/5+10,70,25);
	
	ok.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
       String id=idf.getText();   		aduit_single.this.dispose();
       	if(id.substring(0, 2).equals("al")) {
   		ArrivalListBL al=new ArrivalListBL();
   		try {
   			ArrivalListVO vo=al.inquiry(id);
   			if(vo!=null)  new aduit_arrivallist(vo);
   			else JOptionPane.showMessageDialog(null,"到达单: "+id+"未找到！");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
   	}
   	else if(id.substring(0, 2).equals("il")){
   		IncomeListBL il=new IncomeListBL();
   		try {
   			IncomeListVO vo=il.inquiry(id);
   			if(vo!=null)  new aduit_incomelist(vo);
   			else JOptionPane.showMessageDialog(null,"营业厅收入单: "+id+"未找到！");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
   	}
   	else if(id.substring(0, 2).equals("ll")){
   		LoadingListBL ll=new LoadingListBL();
   		try {
   			LoadingListVO vo=ll.inquiry(id);
   			if(vo!=null)  new aduit_loadinglist(vo);
   			else JOptionPane.showMessageDialog(null,"营业厅装车单: "+id+"未找到！");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
   	}
   	else if(id.substring(0, 2).equals("zc")){
   		LoadingListZZBL zc=new LoadingListZZBL();
   		try {
   			LoadingListZZVO vo=zc.inquiry(id);
   			if(vo!=null)  new aduit_loadinglistzz(vo);
   			else JOptionPane.showMessageDialog(null,"中转中心接收单: "+id+"未找到！");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
   	}
   	else if(id.substring(0, 2).equals("rl")){
   		RecivalListBL rl=new RecivalListBL();
   		try {
   			RecivalListVO vo=rl.inquiry(id);
   			if(vo!=null)  new aduit_recivallist(vo);
   			else JOptionPane.showMessageDialog(null,"中转中心到达单: "+id+"未找到！");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
   	}
   	else if(id.substring(0, 2).equals("tl")){
   		TransferListBL tl=new TransferListBL();
   		try {
   			TransferListVO vo=tl.inquiry(id);
   			if(vo!=null)  new aduit_transferlist(vo);
   			else JOptionPane.showMessageDialog(null,"中转中心中转单: "+id+"未找到！");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
   	}
   	else {
   		JOptionPane.showMessageDialog(null, "ID 格式不正确");
   	}
		}
		
	});
	
	cancle.addActionListener(new ActionListener(){

		public void actionPerformed(ActionEvent e) {
		aduit_single.this.dispose();
			
		}
		
	});
}
}
