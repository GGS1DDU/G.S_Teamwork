package elms.businesslogic_service.managerblservice;

import java.io.IOException;



import elms.businesslogic.ResultMessage;
import elms.po.FreightStrategyPO;
import elms.vo.FreightStrategyVO;



public interface FreightStrategyBlService {

	public FreightStrategyVO initFreight();
	
	public FreightStrategyVO getFreightStrategy(String id);
	
	public ResultMessage addFreight(FreightStrategyVO vo) throws IOException;
	
	public ResultMessage deleteFreight(FreightStrategyVO vo) throws IOException;
	
	public ResultMessage changeFreight(FreightStrategyVO vo);
}
