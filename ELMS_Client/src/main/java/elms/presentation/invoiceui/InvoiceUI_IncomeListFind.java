package elms.presentation.invoiceui;

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

import elms.businesslogic.invoicebl.IncomeListBL;
import elms.vo.IncomeListVO;

public class InvoiceUI_IncomeListFind extends JFrame{
	Toolkit kit=Toolkit.getDefaultToolkit();
	Dimension screenSize=kit.getScreenSize();
	int screenWidth=(int) screenSize.getWidth();
	int screenHeight=(int) screenSize.getHeight();
	
	public InvoiceUI_IncomeListFind(){
		setLayout(null);
		setTitle("查询");
		setResizable(false);
		setBounds(screenWidth/4,screenHeight/4,screenWidth/4,screenHeight/4);
		setVisible(true);
		
		final JTextField idf=new JTextField();
		JLabel ID=new JLabel("单据ID");
		add(ID);
		ID.setBounds(60,40,100,30);
		add(idf);
		idf.setBounds(this.getWidth()/2-14,40,150,28);
		JButton ok=new JButton("查询");
		JButton cancle=new JButton("取消");
		add(ok);ok.setBounds(this.getWidth()/2-120,3*this.getHeight()/5+10,70,25);
		add(cancle);cancle.setBounds(this.getWidth()/2+40,3*this.getHeight()/5+10,70,25);
		
		ok.addActionListener(new ActionListener(){
			IncomeListBL incomelistdata=new IncomeListBL();
		
			public void actionPerformed(ActionEvent e) {
				try{
					IncomeListVO vo=incomelistdata.inquiry(idf.getText());
					if(vo!=null){
					 	setVisible(false);
						new InvoiceUI_IncomeListEdit(vo,false);
					}else{
						JOptionPane.showMessageDialog(null, "订单编号："+idf.getText()+"未找到");
					}
				}catch(IOException e1){
					e1.printStackTrace();
				}		
			}		
		});
		cancle.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}		
		});	
	}

}
