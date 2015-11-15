package ELMS.businesslogicService;

import java.util.ArrayList;

import ELMS.businesslogic.StorageBL.StorageList;
import ELMS.vo.StorageVO;

public interface StorageBlService {
	public StorageList init(StorageList StorageList);
	public boolean storage_inChoose(String area,String center);
	public StorageVO storage_inRecord(StorageVO vo);
	public boolean storage_out(String orderID,String center);
	public StorageList inquiryByTime(String time1, String time2, String center);
	public StorageList inquiryAll(String center);
	public StorageVO inquiry(String id);
	public void endStoreOpt();
}
