package ELMS.Driver;

import java.rmi.RemoteException;
import java.util.ArrayList;

import ELMS.Stub.LogData_stub;
import ELMS.po.LogPO;

public class LogData_driver {
public void main(String args[]) throws RemoteException{
	LogData_stub ls=new LogData_stub();
	
	LogPO po=ls.find("0001");
	System.out.println(po.getId()+" "+po.getTime()+" "+po.getCategory()+" "+po.getName());
	
	 ArrayList<LogPO> as=ls.findall();
	    for(int i=0;i<as.size();i++)
	    	 System.out.println(((LogPO) as.get(i)).getId()+" "+((LogPO) as.get(i)).getTime()+" "+((LogPO) as.get(i)).getCategory()+" "+((LogPO) as.get(i)).getName());
	

     ArrayList<LogPO> as1=ls.findbyID("ZHT");
		    for(int i=0;i<as1.size();i++)
		    	 System.out.println(((LogPO) as1.get(i)).getId()+" "+((LogPO) as1.get(i)).getTime()+" "+((LogPO) as1.get(i)).getCategory()+" "+((LogPO) as1.get(i)).getName());
		
     ls.init();
     ls.insert(po);
     ls.finish();
		
}
}
