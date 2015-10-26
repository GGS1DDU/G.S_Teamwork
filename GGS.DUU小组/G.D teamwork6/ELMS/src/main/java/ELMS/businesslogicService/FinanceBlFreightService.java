package ELMS.businesslogicService;

import ELMS.vo.FreightStrategyVO;
import ELMS.po.FreightStrategyPO;

public interface FinanceBlFreightService {
	public String setCities(String city);
	
	public double getDisdance(String city1, String city2);

	public void setDisdance(String city1, String city2);
	
	public double setFreight(String type, double freight);
	
	public int setCoefficient(int coefficient);
	
	public FreightStrategyVO getFreightStrategy(FreightStrategyPO po);//��Ҫ�������PO������
	
	public void endFreightStrategyOpt();
	
}
