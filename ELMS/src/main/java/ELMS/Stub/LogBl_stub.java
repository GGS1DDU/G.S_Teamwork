package ELMS.Stub;

import java.util.ArrayList;

import ELMS.businesslogicService.LogBlService;
import ELMS.vo.LogVO;

public class LogBl_stub implements LogBlService {

	public boolean buildLog(LogVO vo) {
		// TODO Auto-generated method stub
		return true;
	}

	public LogVO inquiry(String LogID) {
		LogVO vo=new LogVO(LogID, "2015-10-25", "添加支出", "ZHhittta");
		// TODO Auto-generated method stub
		return vo;
	}

	public ArrayList<LogVO> inquiryAll() {
		// TODO Auto-generated method stub
		ArrayList<LogVO> list=new ArrayList<LogVO>();
		LogVO vo=new LogVO("0000", "2015-10-25", "添加支出", "ZHhittta");
		LogVO vo1=new LogVO("0001", "2015-10-26", "删除人员", "ZHhittta");
		LogVO vo2=new LogVO("0001", "2015-10-26", "新增人员", "ZHhittta");
		list.add(vo);list.add(vo1);list.add(vo2);
		return list;
	}
}
