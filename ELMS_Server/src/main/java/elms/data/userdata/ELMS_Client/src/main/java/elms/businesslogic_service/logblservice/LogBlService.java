package elms.businesslogic_service.logblservice;

import elms.businesslogic.logbl.LogList;
import elms.vo.LogVO;

public interface LogBlService {
	public boolean buildLog(LogVO vo);
	public LogVO inquiry(String LogID);
	public LogList inquiryAll();
}
