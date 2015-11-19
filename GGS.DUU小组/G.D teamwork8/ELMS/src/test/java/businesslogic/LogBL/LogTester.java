package businesslogic.LogBL;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import ELMS.businesslogic.LogBL.Log;
import ELMS.businesslogic.LogBL.LogList;
import ELMS.businesslogic.LogBL.MockLog;
import ELMS.businesslogic.LogBL.MockUser;
import ELMS.businesslogic.LogBL.Operation;
import ELMS.vo.LogVO;

public class LogTester {

	@Test
	public void test() {
		Log log=new Log();
		MockUser User1=new MockUser(null, "ZHhittta", null, null);
		MockLog Log1=new MockLog("0001", "2015-10-12",Operation.ADD ,User1.getName());
		MockLog Log2=new MockLog("0002","2015-10-13",Operation.DELETE,User1.getName());
		MockLog Log3=new MockLog("0003","2015-10-14",Operation.INQUIRY,User1.getName());
		MockLog Log4=new MockLog("0004","2015-10-15",Operation.UPDATE,User1.getName());
		LogList list=new LogList();
		list.add(Log1);
		list.add(Log2);
		list.add(Log3);
		list.add(Log4);
		
		assertEquals (list.get(0).getCategory(),log.inquiryAll().get(0).getCategory());
		assertEquals (list.get(1).getId(),log.inquiryAll().get(1).getId());
		assertEquals (list.get(2).getName(),log.inquiryAll().get(2).getName());
		assertEquals (list.get(3).getTime(),log.inquiryAll().get(3).getTime());
	}

}
