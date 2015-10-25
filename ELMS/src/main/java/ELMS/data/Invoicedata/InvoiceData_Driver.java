package ELMS.data.Invoicedata;

import ELMS.dataservice.InvoiceDataService;
import ELMS.vo.RecivalListVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class InvoiceData_Driver {
	public void drive(InvoiceDataService InvoiceDataService)throws RemoteException{

	//	public InvoiceData_Driver(InvoiceDataService ids) throws RemoteException{
	
	//朝找单据
	System.out.println("查找单据成功：");
	InvoiceData_stub ss=new InvoiceData_stub();
	
	ArrayList<RecivalListVO> al2=new ArrayList<RecivalListVO>();
	RecivalListVO vo=new RecivalListVO("1234567890","025000","20151025","025000201510250000000","南京","完整");
	al2.add(vo);
//	System.out.println(al2);
	System.out.println("订单号：1234567890\n"+"中转中心编号：025000\n"+"日期：20151025\n"+"中转单编号：025000201510250000000\n"+"出发地：南京\n"+"货物状态：完整\n");
	//初始化单据
    ss.init();
    System.out.println("初始化单据成功！\n");
    
    //单据操作完成
    ss.finish();
    System.out.println("单据操作结束！\n");
    }
	
}
