package ELMS.Driver;

import java.rmi.RemoteException;
import java.util.ArrayList;

import ELMS.Stub.StorageData_stub;
import ELMS.dataservice.StorageDataService;
import ELMS.po.StoragePO;

public class StorageData_driver {
public StorageData_driver(StorageDataService sds) throws RemoteException{
	StoragePO sp=sds.find("AE86");
	System.out.println(sp.getId()+" "+sp.getArea()+" "+sp.getSeat()+" "+sp.getOrder()+" "+sp.getTimeIn()+" "+sp.getTimeOut()+" "+sp.getState()+" "+sp.getName());

	ArrayList<StoragePO> al1=new ArrayList<StoragePO>();
	al1=sds.findall("广州");
	for(int i=0;i<al1.size();i++) 
		System.out.println(al1.get(i).getId()+" "+al1.get(i).getArea()+" "+al1.get(i).getSeat()+" "+al1.get(i).getOrder()+
			" "+al1.get(i).getTimeIn()+" "+al1.get(i).getTimeOut()+" "+al1.get(i).getState()+" "+al1.get(i).getName());
	
	
	ArrayList<StoragePO> al2=new ArrayList<StoragePO>();
	al2=sds.findbytime("2015-05-22", "2015-05-26", "南京");
	for(int i=0;i<al2.size();i++) 
		System.out.println(al2.get(i).getId()+" "+al2.get(i).getArea()+" "+al2.get(i).getSeat()+" "+al2.get(i).getOrder()+
			" "+al2.get(i).getTimeIn()+" "+al2.get(i).getTimeOut()+" "+al2.get(i).getState()+" "+al2.get(i).getName());
	
	sds.insert(sp);
	sds.delete(sp);
	sds.update(sp);
	sds.init();
	sds.finish();
	
}
}
