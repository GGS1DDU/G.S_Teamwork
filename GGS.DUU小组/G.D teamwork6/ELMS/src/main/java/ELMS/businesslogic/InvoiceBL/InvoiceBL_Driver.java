package ELMS.businesslogic.InvoiceBL;

import java.util.ArrayList;

import ELMS.businesslogicService.InvoiceBLService;
import ELMS.vo.RecivalListVO;

public class InvoiceBL_Driver {
//	public InvoiceBL_Driver(InvoiceBLService is){
	public void drive(InvoiceBLService InvoiceBLService){
		
		System.out.println("请输入单据数据\n");
        System.out.println("查询单据信息：");
		InvoiceBL_stub ss=new InvoiceBL_stub();
		
		ArrayList<RecivalListVO> al=new ArrayList<RecivalListVO>();
		RecivalListVO vo=new RecivalListVO("订单号：1234567890\n","中转中心编号：025000\n","日期：20151025\n","中转单编号：025000201510250000000\n","出发地：南京\n","货物状态：完整\n");
		al.add(vo);
//		System.out.println(al);
//		System.out.println(al);
//		System.out.println(al);
		System.out.println("订单号：1234567890\n"+"中转中心编号：025000\n"+"日期：20151025\n"+"中转单编号：025000201510250000000\n"+"出发地：南京\n"+"货物状态：完整\n");
        
		System.out.println("修改单据信息成功：");
		System.out.println("订单号：1234567890\n"+"中转中心编号：025000\n"+"日期：20151025\n"+"中转单编号：025000201510250000000\n"+"出发地：南京\n"+"货物状态：完整\n");
		
		
		if(ss.InvoiceDelete("1234567890")){
			System.out.println("单据删除成功\n");
		}
		
		if(ss.InvoiceApproval("1234567890")){
			System.out.println("单据已经过审批\n");
		}
		
		ss.endInvoiceOpt();
	}

}
