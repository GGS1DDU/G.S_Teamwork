package ELMS.businesslogicService;

import java.util.ArrayList;

import ELMS.vo.StorageVO;

public interface StorageBlService {
	public ArrayList<StorageVO> init(ArrayList<StorageVO> StorageList);
	public boolean storage_inChoose(String area);
	public StorageVO storage_inRecord(StorageVO vo);
	public boolean storage_out(String orderID);
	public ArrayList<StorageVO> inquiryByTime(String time1, String time2, String center);
	public ArrayList<StorageVO> inquiryAll(String center);
	public StorageVO inquiry(String id);
	public void endStoreOpt();
}
