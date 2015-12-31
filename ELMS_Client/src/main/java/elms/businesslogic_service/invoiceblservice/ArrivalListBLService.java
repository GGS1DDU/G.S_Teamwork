package elms.businesslogic_service.invoiceblservice;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import elms.vo.ArrivalListVO;

public interface ArrivalListBLService {
	
	public ArrivalListVO inquiry(String id) throws IOException;
	
	public ArrayList<ArrivalListVO> inquiryAll() throws IOException;
	
	public ArrayList<ArrivalListVO> inquiryByMaker(String Maker) throws IOException;
	
	public ArrivalListVO record(ArrivalListVO vo)throws IOException;
//	
    public void reSubmit(String id) throws RemoteException, IOException;
	
	public void RefuseAudit(String id ) throws RemoteException,IOException;
	
	public void AgreeAudit(String id) throws RemoteException,IOException;
	
	public ArrayList<ArrivalListVO> findByMakerAndNoaudit(String maker) throws IOException;
	
	public ArrayList<ArrivalListVO> findNoaudit() throws IOException;
//	
	public void init() throws IOException;
	
	public void delete(ArrivalListVO vo) throws IOException;
	
	public boolean Approval(String id) throws IOException;
	
	public void endOpt() throws IOException;

}
