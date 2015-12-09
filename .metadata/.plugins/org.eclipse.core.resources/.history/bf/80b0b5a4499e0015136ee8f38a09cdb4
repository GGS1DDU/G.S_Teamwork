package elms.businesslogic_service.storageblservice;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import elms.businesslogic.storagebl.StorageCapacity;
import elms.vo.StorageVO;


public interface StorageBlService {
	public boolean orderhasIN(String s) throws IOException;
	public void delete(StorageVO vo) throws IOException;
	public void init() throws  IOException;
	public int storage_inChoose(String area,StorageCapacity center) throws IOException;
	public StorageVO storage_inRecord(StorageVO vo) throws IOException;
	public boolean storage_out(String orderID,String center) throws IOException;
	public ArrayList<StorageVO> inquiryByTime(String time1, String time2, String center) throws  IOException;
	public ArrayList<StorageVO> inquiryAll(String center) throws IOException;
	public StorageVO inquiry(String id) throws IOException;
	public void paint(List<StorageVO> temp,String s) throws IOException;
	public void endStoreOpt();
}
