package elms.businesslogic_service.financeblservice;

import elms.po.FreightStrategyPO;
import elms.vo.FreightStrategyVO;



public interface FreightStrategyBlService {

	public boolean initFreight();
	
	public FreightStrategyPO getFreightStrategy();
	
	public FreightStrategyVO setFreight(FreightStrategyVO vo);
}
