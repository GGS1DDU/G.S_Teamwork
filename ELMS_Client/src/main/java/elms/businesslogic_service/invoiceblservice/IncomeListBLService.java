package elms.businesslogic_service.invoiceblservice;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import elms.vo.IncomeListVO;

public interface IncomeListBLService {

	public IncomeListVO inquiry(String id) throws IOException;
	
	public ArrayList<IncomeListVO> inquiryAll() throws IOException;
	
	public IncomeListVO record(IncomeListVO vo)throws IOException;
	
	public void addByCenter(IncomeListVO vo,String date) throws IOException;
//	
    public void reSubmit(String id) throws RemoteException, IOException;
	
	public void RefuseAudit(String id ) throws RemoteException,IOException;
	
	public void AgreeAudit(String id) throws RemoteException,IOException;
	
	public ArrayList<IncomeListVO> findByMakerAndNoaudit(String maker) throws IOException;
	
	public ArrayList<IncomeListVO> findNoaudit() throws IOException;
//	
	public void init() throws IOException;
	
	public void delete(IncomeListVO vo) throws IOException;
	
	public boolean Approval(String id) throws IOException;
	
	public void endOpt() throws IOException;

}
