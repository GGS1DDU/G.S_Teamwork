package businesslogic.DealBL;

import static org.junit.Assert.*;

import org.junit.Test;

import ELMS.businesslogic.DealBL.CalculateFee;
import ELMS.businesslogic.DealBL.MockDeal;
import ELMS.businesslogic.DealBL.MockFinanceStr;
import ELMS.vo.DealVO;

public class CalculateFee_tester {

	@Test
	public void testCalculateFee() {
		MockFinanceStr mfs=new MockFinanceStr(20.7); 
		CalculateFee cf=new CalculateFee();
		MockDeal order=new MockDeal("0000000001", "A", "B",
				"2015-10-23", "A", "南京",
				" ", "110",	"b", "北京"," ", "120",
				"书", 10, 3.0,
				1000, "标准快递", "纸箱", 0,
				0, "B", "2015-10-25",
				" ", "未送达");
		
		assertEquals(67.1,cf.calculatefee(mfs, order),0.1);
		
		
		
	}

}
