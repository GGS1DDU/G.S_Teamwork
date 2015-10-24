package ELMS.Driver;

import java.rmi.RemoteException;
import java.util.ArrayList;

import ELMS.Stub.StorageData_stub;
import ELMS.po.StoragePO;

public class StorageData_driver {
public void main(String args[]) throws RemoteException{
	StorageData_stub ss=new StorageData_stub();

	StoragePO sp=ss.find("AE86");
	System.out.println(sp.getId()+" "+sp.getArea()+" "+sp.getSeat()+" "+sp.getOrder()+" "+sp.getTimeIn()+" "+sp.getTimeOut()+" "+sp.getState()+" "+sp.getName());

	ArrayList<StoragePO> al1=new ArrayList<StoragePO>();
	al1=ss.findall("广州");
	for(int i=0;i<al1.size();i++) System.out.println(al1.get(i).getId()+" "+al1.get(i).getArea()+" "+al1.get(i).getSeat()+" "+al1.get(i).getOrder()+
			" "+al1.get(i).getTimeIn()+" "+al1.get(i).getTimeOut()+" "+al1.get(i).getState()+" "+al1.get(i).getName());
	
	
	ArrayList<StoragePO> al2=new ArrayList<StoragePO>();
	al2=ss.findbytime("2015-05-22", "2015-05-26", "南京");
	for(int i=0;i<al2.size();i++) System.out.println(al2.get(i).getId()+" "+al2.get(i).getArea()+" "+al2.get(i).getSeat()+" "+al2.get(i).getOrder()+
			" "+al2.get(i).getTimeIn()+" "+al2.get(i).getTimeOut()+" "+al2.get(i).getState()+" "+al2.get(i).getName());
	
	ss.insert(sp);
	ss.delete(sp);
	ss.update(sp);
	ss.init();
	ss.finish();
	
}
}
