package ELMS.businesslogic.StorageBL;

import java.util.ArrayList;

import ELMS.businesslogicService.StorageBlService;
import ELMS.vo.StorageVO;

public class Storage implements StorageBlService {

    int StorageSize=1000;
	public boolean storage_inChoose(String area,String center) {
		int num=0;
		StorageList list=new StorageList();
		list=this.inquiryAll(center);
        for(StorageVO s:list)
        	if(s.getArea()==area) num++;
        if(num<=(int)0.9*StorageSize)return true;
		return false;
	}

	public StorageVO storage_inRecord(StorageVO vo) {
		// TODO Auto-generated method stub
		return vo;
	}

	public boolean storage_out(String orderID,String center) {
		StorageList list=new StorageList();
		list=this.inquiryAll(center);
		for(StorageVO s:list){
			if(s.getOrder()==orderID&&s.getState()==State.IN) return true;
		}
		return false;
	}

	public StorageList inquiryAll(String center) {
		//等data
		StorageVO ms1=new StorageVO("0001","航运","R4L3S6","0001","2015-10-01","2015-10-12",State.OUT,center);
		StorageVO ms2=new StorageVO("0002","汽运","R4L3S6","0201","2015-10-15",null,State.IN,center);
		StorageVO ms3=new StorageVO("0003","汽运","R4L3S6","0781","2015-10-16",null,State.IN,center);
		StorageList sl=new StorageList();
		sl.add(ms1);sl.add(ms2);sl.add(ms3);
		return sl;
	}

	public StorageVO inquiry(String id) {
		//
		return null;
	}

	public void endStoreOpt() {
		// TODO Auto-generated method stub
		
	}

	public StorageList init(StorageList StorageList) {
		// TODO Auto-generated method stub
		return StorageList;
	}

	public StorageList inquiryByTime(String time1, String time2, String center) {
		// TODO Auto-generated method stub
		return null;
	}
  public void setStorageSize(int size){
	  StorageSize=size;
  }
  public void setStorageState(String id,State a){
	 //  等data写完
  }
}
