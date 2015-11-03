package ELMS.dataservice;

import java.rmi.RemoteException;

import ELMS.po.FreightStrategyPO;
import ELMS.vo.FreightStrategyVO;

public interface FinanceFreightDataService {
	public FreightStrategyVO find() throws RemoteException;
	
	public void init() throws RemoteException;
	
	public FreightStrategyPO add(FreightStrategyVO vo) throws RemoteException;
	
	public void delete(FreightStrategyPO po) throws RemoteException;
	
	public void update(FreightStrategyPO po) throws RemoteException;
	
	public void finish() throws RemoteException;
}
