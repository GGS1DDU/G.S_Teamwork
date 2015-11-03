package ELMS.data.Dealdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import ELMS.dataservice.DealDataService;
import ELMS.po.DealPO;

public class DealData_driver {
	public void drive(DealDataService DealDataService) throws RemoteException{
		//给定ID寻找订单
		long id1=1;
		DealPO po1=DealDataService.find(id1);
		if(po1!=null){
			System.out.println("寻找到对应该ID的订单\n");
		}
		
		//按照快递员姓名找所属订单
		ArrayList<DealPO> arr=new ArrayList<DealPO>();
		String courier="快递员A";
		arr=DealDataService.findbyCourier(courier);
		System.out.println("找到快递员对应的订单!\n");
		
		//新增一个订单
		DealPO po=new DealPO();
		DealDataService.insert(po);
		System.out.println("新增订单成功!\n");
		
		//删除一个订单
		DealDataService.delete(po);
		System.out.println("删除订单成功!\n");
		
		//更新一个订单
		DealDataService.update(po);
		System.out.println("更新订单成功!\n");
		
	}

}
