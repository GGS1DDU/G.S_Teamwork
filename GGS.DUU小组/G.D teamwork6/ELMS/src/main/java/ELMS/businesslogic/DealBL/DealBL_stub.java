package ELMS.businesslogic.DealBL;

import java.util.ArrayList;

import ELMS.businesslogicService.DealBlService;
import ELMS.vo.DealVO;
import ELMS.vo.RecordVO;

public class DealBL_stub implements DealBlService{
	
	
	
	public boolean BuildOrder(DealVO vo){
		System.out.println("成功生成订单!");
		
		return true;
	}
	
	
	
	public DealVO CourierInquiry(String orderID){
		System.out.println("成功查询账户！");
		return new DealVO((long)1,"快递员A","鼓楼营业厅","2015/10/24","寄件人A","南京","南京大学","110","收件人A","广州","中山大学","119","书",1,1.1,1.1,"标准快递","纸箱",1,3,
				"收件人B","2015/10/27","从鼓楼营业厅出发，到达南京中转中心，从南京中转中心出发，到达中山中转中心，从中山中转中心出发，到达中山市营业厅","已送达");
		
	}
		
	
	
	
	public  DealVO recipients(String orderid,String acutalReciever, String time){
		System.out.println("成功输入收件信息");
		
		return new DealVO((long)1,"快递员A","鼓楼营业厅","2015/10/24","寄件人A","南京","南京大学","110","收件人A","广州","中山大学","119","书",1,1.1,1.1,"标准快递","纸箱",1,3,
				"收件人B","2015/10/27","从鼓楼营业厅出发，到达南京中转中心，从南京中转中心出发，到达中山中转中心，从中山中转中心出发，到达中山市营业厅","已送达");	
	}
		
	
	public ArrayList<RecordVO> Record(String time1, String time2,String courier_name){
		 RecordVO vo=new RecordVO((long)1,"2015/10/24","快递员A",1);
		 ArrayList<RecordVO> arr=new ArrayList<RecordVO>();
		 arr.add(vo);
		 return arr;
	}
	
	
	public void endDealOpt(){
		System.out.println("End！");
	
	}

}
