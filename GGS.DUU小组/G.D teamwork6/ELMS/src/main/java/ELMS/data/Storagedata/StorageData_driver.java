package ELMS.data.Storagedata;

import java.rmi.RemoteException;
import java.util.ArrayList;
import ELMS.dataservice.StorageDataService;
import ELMS.po.StoragePO;

public class StorageData_driver {
public StorageData_driver(StorageDataService sds) throws RemoteException{
	
	System.out.println("库存编码为AE86的库存项查询： ");
	StoragePO sp=sds.find("AE86");
	System.out.println(sp.getId()+" "+sp.getArea()+" "+sp.getSeat()+" "+sp.getOrder()+" "+sp.getTimeIn()+" "+sp.getTimeOut()+" "+sp.getState()+" "+sp.getName()+"\n");
	
    System.out.print("广州中转中心库存查询：");
	ArrayList<StoragePO> al1=new ArrayList<StoragePO>();
	al1=sds.findall("广州");
	for(int i=0;i<al1.size();i++) 
		System.out.println(al1.get(i).getId()+" "+al1.get(i).getArea()+" "+al1.get(i).getSeat()+" "+al1.get(i).getOrder()+
			" "+al1.get(i).getTimeIn()+" "+al1.get(i).getTimeOut()+" "+al1.get(i).getState()+" "+al1.get(i).getName());
	System.out.println();
	
	System.out.println("南京中转中心 2015-05-22 到 2015-05-26日的出入库信息：");
	ArrayList<StoragePO> al2=new ArrayList<StoragePO>();
	al2=sds.findbytime("2015-05-22", "2015-05-26", "南京");
	for(int i=0;i<al2.size();i++) 
		System.out.println(al2.get(i).getId()+" "+al2.get(i).getArea()+" "+al2.get(i).getSeat()+" "+al2.get(i).getOrder()+
			" "+al2.get(i).getTimeIn()+" "+al2.get(i).getTimeOut()+" "+al2.get(i).getState()+" "+al2.get(i).getName());
	System.out.println();
	
	System.out.println("生成新的库存项");
	sds.insert(sp);
	System.out.println();
	System.out.println("删除库存项");
	sds.delete(sp);
	System.out.println("\n更新库存项");
	sds.update(sp);
	System.out.println("\n信息初始化！");
	sds.init();
	System.out.println("\n结束操作");
	sds.finish();
	
}
}
