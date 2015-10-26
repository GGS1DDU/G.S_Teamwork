package ELMS.businesslogic.DealBL;


import ELMS.businesslogicService.DealBlService;
import ELMS.vo.DealVO;

public class DealBL_Driver {
	
	public void drive(DealBlService DealBlservice){
		//生成订单
		DealVO vo=new DealVO();
		boolean result=DealBlservice.BuildOrder(vo);
		if(result==true) System.out.println("成功生成订单\n");	
		
		//输入收件信息
		String ID1="0000000001";
		String actualReceiver="收件人B";
		String time="2015/10/27";
		DealVO vo2=DealBlservice.recipients(ID1, actualReceiver, time);
		if(vo2!=null) System.out.println("成功输入收件信息!\n");
		
		//查询订单
		String ID2="0000000001";
		DealVO vo3=DealBlservice.CourierInquiry(ID2);
		if(vo3!=null) {
			System.out.println("成功查询到订单信息:");
			System.out.println("订单号:"+vo3.getOrderID());
			System.out.println("所属快递员："+vo3.getCourier_name());
			System.out.println("寄件人:"+vo3.getSender_name());
			System.out.println("收件人:"+vo3.getActualreceiver_name()+" ......\n");
		}
		
		
		
						
		
		
	}
	
	

}

