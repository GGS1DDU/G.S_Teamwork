package ELMS.businesslogic.LogBL;

import java.util.ArrayList;

import ELMS.businesslogicService.LogBlService;
import ELMS.vo.LogVO;
import ELMS.vo.UserVO;

public class Log implements LogBlService {

	public boolean buildLog(LogVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	public LogVO inquiry(String LogID) {
		// TODO Auto-generated method stub
		return null;
	}
	public ArrayList<LogVO> inquiryAll() {
		UserVO User1=new UserVO(null, "ZHhittta", null, null);
		LogVO Log1=new LogVO("0001", "2015-10-12",Operation.ADD ,User1.getName());
		LogVO Log2=new LogVO("0002","2015-10-13",Operation.DELETE,User1.getName());
		LogVO Log3=new LogVO("0003","2015-10-14",Operation.INQUIRY,User1.getName());
		LogVO Log4=new LogVO("0004","2015-10-15",Operation.UPDATE,User1.getName());
		LogList list=new LogList();
		list.add(Log1);
		list.add(Log2);
		list.add(Log3);
		list.add(Log4);
		return list;
		
	}

}
