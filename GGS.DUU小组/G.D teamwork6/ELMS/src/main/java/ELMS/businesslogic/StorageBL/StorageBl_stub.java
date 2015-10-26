package ELMS.businesslogic.StorageBL;

import java.util.ArrayList;

import ELMS.businesslogicService.StorageBlService;
import ELMS.vo.StorageVO;

public class StorageBl_stub implements StorageBlService {

	public ArrayList<StorageVO> init(ArrayList<StorageVO> StorageList) {
		
		// TODO Auto-generated method stub
		return StorageList;
	}

	public boolean storage_inChoose(String area) {
		// TODO Auto-generated method stub
		return true;
	}

	public StorageVO storage_inRecord(StorageVO vo) {
		// TODO Auto-generated method stub
		return vo;
	}

	public boolean storage_out(String orderID) {
		// TODO Auto-generated method stub
		return true;
	}

	public ArrayList<StorageVO> inquiryByTime(String time1, String time2,
			String center) {
		ArrayList<StorageVO> al=new ArrayList<StorageVO>();
		StorageVO vo=new StorageVO("0006", "航运区", "S3R4S23","0000012543",time1 , "2015-05-23", "出库", center);
		StorageVO vo1=new StorageVO("0007", "汽运区", "S9R4S15","0000004158","2015-05-25" , null, "在库存", center);
		StorageVO vo2=new StorageVO("0008", "机动区", "S1R7S04","0000013254","2015-05-24" , time2, "出库", center);
		al.add(vo);
		al.add(vo1);
		al.add(vo2);
		return al;
	}

	public ArrayList<StorageVO> inquiryAll(String center) {
		ArrayList<StorageVO> al=new ArrayList<StorageVO>();
		StorageVO vo=new StorageVO("0006", "航运区", "S3R4S23","0000012543","2015-05-22", "2015-05-23", "出库", center);
		StorageVO vo1=new StorageVO("0007", "汽运区", "S9R4S15","0000004158","2015-05-25" , null, "在库存", center);
		StorageVO vo2=new StorageVO("0008", "机动区", "S1R7S04","0000013254","2015-05-24" , "2015-05-25", "出库", center);
		al.add(vo);
		al.add(vo1);
		al.add(vo2);
		return al;
	}

	public StorageVO inquiry(String id) {
		StorageVO vo1=new StorageVO(id, "汽运区", "S9R4S15","0000004158","2015-10-26" , null, "在库存", "南京");
		// TODO Auto-generated method stub
		return vo1;
	}

	public void endStoreOpt() {
	System.out.println("结束库存操作");	// TODO Auto-generated method stub
		
	}

}
