package ELMS.data.Dealdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import ELMS.dataservice.DealDataService;
import ELMS.po.DealPO;
import ELMS.vo.DealVO;

public class DealDate_stub implements DealDataService{
	
	
	public DealPO find(Long id) throws RemoteException{
		System.out.println("Find Succeed！");
		
		return new DealPO((long)1,"快递员A","鼓楼营业厅","2015/10/24","寄件人A","南京","南京大学","110","收件人A","广州","中山大学","119","书",1,1.1,1.1,"标准快递","纸箱",1,3,
				"收件人B","2015/10/27","从鼓楼营业厅出发，到达南京中转中心，从南京中转中心出发，到达中山中转中心，从中山中转中心出发，到达中山市营业厅","已送达");
	}

	
	public ArrayList<DealPO> findall() throws RemoteException{
		System.out.println("Find Succeed！");
		
		ArrayList<DealPO> arr=new ArrayList<DealPO>();
		DealPO po=new DealPO((long)1,"快递员A","鼓楼营业厅","2015/10/24","寄件人A","南京","南京大学","110","收件人A","广州","中山大学","119","书",1,1.1,1.1,"标准快递","纸箱",1,3,
				"收件人B","2015/10/27","从鼓楼营业厅出发，到达南京中转中心，从南京中转中心出发，到达中山中转中心，从中山中转中心出发，到达中山市营业厅","已送达");
		arr.add(po);
		return arr;
		
	}
	
	
	
	public ArrayList<DealPO> findbyCourier(String courier) throws RemoteException{
		
		System.out.println("Find Succeed！");
		ArrayList<DealPO> arr=new ArrayList<DealPO>();
		DealPO po=new DealPO((long)1,"快递员A","鼓楼营业厅","2015/10/24","寄件人A","南京","南京大学","110","收件人A","广州","中山大学","119","书",1,1.1,1.1,"标准快递","纸箱",1,3,
				"收件人B","2015/10/27","从鼓楼营业厅出发，到达南京中转中心，从南京中转中心出发，到达中山中转中心，从中山中转中心出发，到达中山市营业厅","已送达");
		arr.add(po);
		return arr;
	}
	
	
	public ArrayList<DealPO> findbyHall(String hall) throws RemoteException{
		System.out.println("Find Succeed！\n");
		
		ArrayList<DealPO> arr=new ArrayList<DealPO>();
		DealPO po=new DealPO((long)1,"快递员A","鼓楼营业厅","2015/10/24","寄件人A","南京","南京大学","110","收件人A","广州","中山大学","119","书",1,1.1,1.1,"标准快递","纸箱",1,3,
				"收件人B","2015/10/27","从鼓楼营业厅出发，到达南京中转中心，从南京中转中心出发，到达中山中转中心，从中山中转中心出发，到达中山市营业厅","已送达");
		arr.add(po);
		return arr;
	}
	
	
	public void insert(DealPO po) throws RemoteException{
		System.out.println("Insert Succeed！");
	}
	
	
	public void delete(DealPO po) throws RemoteException{
		System.out.println("delete Succeed！");
	}
	
	
	public void update(DealPO po) throws RemoteException{
		System.out.println("Update Succeed！");
	}
	
	
	public void init() throws RemoteException{
		
	}
	
	
	public void finish() throws RemoteException{
		
	}

}
