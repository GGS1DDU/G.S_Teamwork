package ELMS.Stub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import ELMS.dataservice.LogDataService;
import ELMS.po.LogPO;
import ELMS.vo.LogVO;

public class LogData_stub implements LogDataService {

	public LogPO find(String id) throws RemoteException {
		LogPO po=new LogPO(id, "2015-10-25", "添加支出", "ZHhittta");
		// TODO Auto-generated method stub
		return po;
	}

	public ArrayList<LogPO> findall() throws RemoteException {
		ArrayList<LogPO> list=new ArrayList<LogPO>();
		LogPO vo=new LogPO("0000", "2015-10-25", "添加支出", "ZHhittta");
		LogPO vo1=new LogPO("0001", "2015-10-26", "删除人员", "ZHhittta");
		LogPO vo2=new LogPO("0001", "2015-10-26", "新增人员", "ZHhittta");
		list.add(vo);list.add(vo1);list.add(vo2);
		return list;
	}

	public ArrayList<LogPO> findbyID(String ID) throws RemoteException {
		ArrayList<LogPO> list=new ArrayList<LogPO>();
		LogPO vo=new LogPO("0000", "2015-10-25", "添加支出", ID);
		LogPO vo1=new LogPO("0001", "2015-10-26", "删除人员", ID);
		LogPO vo2=new LogPO("0001", "2015-10-26", "新增人员", ID);
		list.add(vo);list.add(vo1);list.add(vo2);
		return list;
	}

	public void insert(LogPO po) throws RemoteException {
		System.out.println("成功生成系统记录");
		// TODO Auto-generated method stub
		
	}

	public void init() throws RemoteException {
		System.out.println("系统日志初始化成功");// TODO Auto-generated method stub
		
	}

	public void finish() throws RemoteException {
		System.out.println("系统日志记录结束");/// TODO Auto-generated method stub
		
	}
	

}
