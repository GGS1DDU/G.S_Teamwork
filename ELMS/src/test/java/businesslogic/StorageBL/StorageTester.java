package businesslogic.StorageBL;

import static org.junit.Assert.*;

import org.junit.Test;

import ELMS.businesslogic.StorageBL.MockStorage;
import ELMS.businesslogic.StorageBL.State;
import ELMS.businesslogic.StorageBL.Storage;
import ELMS.businesslogic.StorageBL.StorageList;

public class StorageTester {

	@Test
	public void test() {
		Storage s=new Storage();
	MockStorage ms1=new MockStorage("0001","航运","R4L3S6","0001","2015-10-01","2015-10-12",State.OUT,"南京");
	MockStorage ms2=new MockStorage("0002","汽运","R4L3S6","0201","2015-10-15",null,State.IN,"南京");
	MockStorage ms3=new MockStorage("0003","汽运","R4L3S6","0781","2015-10-16",null,State.IN,"南京");
	MockStorage ms4=new MockStorage("0004","火车","R4L3S6","0101","2015-10-12","2015-10-13",State.OUT,"广州");
	StorageList sl=new StorageList();
	StorageList sl2=new StorageList();
	sl.add(ms1);sl.add(ms2);sl.add(ms3);sl.add(ms4);
	sl2.add(ms1);sl2.add(ms2);sl2.add(ms3);
	
	s.setStorageSize(2);
	
    assertEquals(sl.get(0).getId(),s.init(sl).get(0).getId());
    assertEquals(sl.get(1).getArea(),s.init(sl).get(1).getArea());
    assertEquals(sl.get(2).getName(),s.init(sl).get(2).getName());
    assertEquals(sl.get(3).getState(),s.init(sl).get(3).getState());

    assertEquals(false,s.storage_inChoose("汽运","南京"));
    assertEquals(true,s.storage_out("0781", "南京"));
    assertEquals(sl2.get(0).getId(),s.inquiryAll("南京").get(0).getId());
    
	}

}
