package ELMS.data.Logdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import ELMS.dataservice.LogDataService;
import ELMS.po.LogPO;

public class LogData_driver {
public LogData_driver(LogDataService lds) throws RemoteException{
	System.out.println("系统日志-0001      查询：");
	LogPO po=lds.find("0001");
	System.out.println(po.getId()+" "+po.getTime()+" "+po.getCategory()+" "+po.getName());
	
	System.out.println("系统日志显示： ");
	 ArrayList<LogPO> as=lds.findAll();
	    for(int i=0;i<as.size();i++)
	    	 System.out.println(((LogPO) as.get(i)).getId()+" "+((LogPO) as.get(i)).getTime()+" "+((LogPO) as.get(i)).getCategory()+" "+((LogPO) as.get(i)).getName());
	
    System.out.println("操作人员ZHT的系统操作：");
     ArrayList<LogPO> as1=lds.findbyID("ZHT");
		    for(int i=0;i<as1.size();i++)
		    	 System.out.println(((LogPO) as1.get(i)).getId()+" "+((LogPO) as1.get(i)).getTime()+" "+((LogPO) as1.get(i)).getCategory()+" "+((LogPO) as1.get(i)).getName());
	
	System.out.println("系统日志记录初始化： ");
     lds.init();
     
     System.out.println("系统日志增加： ");
     lds.insert(po);
     
     System.out.print("结束操作: ");
     lds.finish();
		
}
}
