package elms.presentation.invoiceui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Timer;

import elms.businesslogic.financebl.InitAll;
import elms.businesslogic.invoicebl.ArrivalListBL;
import elms.businesslogic.invoicebl.IncomeListBL;
import elms.businesslogic.invoicebl.LoadingListBL;
import elms.businesslogic.invoicebl.LoadingListZZBL;
import elms.businesslogic.invoicebl.RecivalListBL;
import elms.businesslogic.invoicebl.SendingListBL;
import elms.businesslogic.invoicebl.TransferListBL;
import elms.presentation.invoiceui.InvoiceUI_ArrivalListEdit;
import elms.presentation.invoiceui.InvoiceUI_IncomeListEdit;
import elms.presentation.invoiceui.InvoiceUI_LoadingListEdit;
import elms.presentation.invoiceui.InvoiceUI_LoadingListZZEdit;
import elms.presentation.invoiceui.InvoiceUI_RecivalListEdit;
import elms.presentation.invoiceui.InvoiceUI_SendingListEdit;
import elms.presentation.invoiceui.InvoiceUI_TransferListEdit;
import elms.presentation.storageui.TableModel;
import elms.vo.InvoiceVO;
import elms.vo.UserVO;


public class Invoice_unaduit extends JPanel{
	public TableModel model;
	public JTable table;
	static Toolkit kit=Toolkit.getDefaultToolkit();
	static Dimension screenSize=kit.getScreenSize();
	static int screenWidth=(int) screenSize.getWidth();
	static int screenHeight=(int)screenSize.getHeight();
//	public static void main(String args[]){
//		JFrame f=new JFrame("gh");
//		f.setLayout(null);
//		f.setVisible(true);
//		f.setResizable(false);
//		f.setBounds(screenWidth/6,screenHeight/8,screenWidth*2/3,screenHeight*3/4);
//		try {
//			Invoice_unaduit u=new Invoice_unaduit("333");
//			f.add(u);
//			u.setBounds(200, 0, f.getWidth()-200, f.getHeight());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	public Invoice_unaduit(final UserVO vo) throws IOException{
		
		setVisible(true);
		setOpaque(false);
		setLayout(null);
	JLabel jl=new JLabel(" 当前用户：  "+vo.getName()+"  身份：  "+vo.getJob()+"  编号   "+vo.getId());
	add(jl);jl.setBounds(200, 0, screenWidth-400, 25);
		
	final JLabel time=new JLabel();
    time.setFont(new Font("Serif",Font.BOLD,15));	    
    add(time);	    
	time.setBounds(screenWidth*2/3/3,screenHeight*3/4-60,200,40);
    String[] title_name = { "ID", "单据类型","制表人"};
	model = new TableModel(title_name);
	table = new JTable(model);
	table.setBackground(Color.white);	
	

	JScrollPane scrollpane=new JScrollPane(table);
	this.add(scrollpane);
	scrollpane.setBounds(-1,40,screenWidth*2/3-198,screenHeight*3/8);
	scrollpane.setOpaque(false);
	scrollpane.getViewport().setOpaque(false); 

	
	

	
    table.addMouseListener(new MouseAdapter(){
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if(e.getClickCount()==2) {
				if(table.getSelectedColumn()!=-1){
					
				String	s=(String) model.getValueAt(table.getSelectedRow(), 0);
				String  c=(String) model.getValueAt(table.getSelectedRow(), 1);
				if(c.equals("到达单")) 	{
					ArrivalListBL  al=new ArrivalListBL();
					try {
						new InvoiceUI_ArrivalListEdit(al.inquiry(s),false);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
										}			
				else	if(c.equals("营业厅收入单")) {
					IncomeListBL  il=new IncomeListBL();
					try {
						new InvoiceUI_IncomeListEdit(il.inquiry(s),false);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
												}
				else	if(c.equals("营业厅装车单")) {
					LoadingListBL  ll=new LoadingListBL();
					try {
						new InvoiceUI_LoadingListEdit(ll.inquiry(s),false);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
												}
				else	if(c.equals("中转中心装车单")) {
					LoadingListZZBL  zc=new LoadingListZZBL();
					try {
						
						new InvoiceUI_LoadingListZZEdit(zc.inquiry(s),false);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
												}
				else	if(c.equals("中转中心接收单")) {
					RecivalListBL  rl=new RecivalListBL();
					try {
						new InvoiceUI_RecivalListEdit(rl.inquiry(s),false);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
												}
				else	if(c.equals("快递员派件单")) {
					SendingListBL  sl=new SendingListBL();
					try {
						new InvoiceUI_SendingListEdit(sl.inquiry(s),false);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
												}
				else{
					TransferListBL  tl=new TransferListBL();
					try {
						new InvoiceUI_TransferListEdit(tl.inquiry(s),false);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
												}			
					}
			}	
		}
    	
    });
    final ArrayList<InvoiceVO>   arr=new ArrayList<InvoiceVO>();
    final ArrivalListBL al=new ArrivalListBL();
    final IncomeListBL il=new IncomeListBL();
    final LoadingListBL ll=new LoadingListBL();
    final LoadingListZZBL zc=new LoadingListZZBL();
    final RecivalListBL rl=new RecivalListBL();
    final SendingListBL sl=new SendingListBL();
    final TransferListBL tl=new TransferListBL();
   
	arr.addAll(al.findByMakerAndNoaudit(vo.getId()));
	arr.addAll(il.findByMakerAndNoaudit(vo.getId()));
	arr.addAll(ll.findByMakerAndNoaudit(vo.getId()));
	arr.addAll(zc.findByMakerAndNoaudit(vo.getId()));
	arr.addAll(rl.findByMakerAndNoaudit(vo.getId()));
	arr.addAll(sl.findByMakerAndNoaudit(vo.getId()));
	arr.addAll(tl.findByMakerAndNoaudit(vo.getId()));
	for(InvoiceVO vos:arr)			model.addRow(model.changeRow_Inv(vos));	
	
	JButton refresh=new JButton("刷新(R)");
	add(refresh);
	refresh.setBounds((screenWidth*2/3-200)/6, screenHeight*3/8+80, 100,25);
	refresh.addActionListener(new ActionListener(){

		public void actionPerformed(ActionEvent arg0) {
			arr.clear();
			try {
				arr.addAll(al.findByMakerAndNoaudit(vo.getId()));
				arr.addAll(il.findByMakerAndNoaudit(vo.getId()));
			arr.addAll(ll.findByMakerAndNoaudit(vo.getId()));
			arr.addAll(zc.findByMakerAndNoaudit(vo.getId()));
			arr.addAll(rl.findByMakerAndNoaudit(vo.getId()));
			arr.addAll(sl.findByMakerAndNoaudit(vo.getId()));
			arr.addAll(tl.findByMakerAndNoaudit(vo.getId()));
			model.removeAllRows(model.getRowCount());
			for(InvoiceVO svo:arr){
				model.addRow(model.changeRow_Inv(svo));
					}
			table.updateUI();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	});
	

    Timer timer = new Timer(100,new ActionListener(){
 		public void actionPerformed(ActionEvent arg0) {
 			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
 				time.setText(sdf.format(new Date()));	
 		}
     });
     timer.start();
}
}
