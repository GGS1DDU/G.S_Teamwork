package ELMS.businesslogicService;

import java.util.ArrayList;

import ELMS.vo.LogVO;

public interface LogBlService {
	public boolean buildLog(LogVO vo);
	public LogVO inquiry(String LogID);
	public ArrayList<LogVO> inquiryAll();
}
