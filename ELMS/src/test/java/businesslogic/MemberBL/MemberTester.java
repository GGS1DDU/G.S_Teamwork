package businesslogic.MemberBL;

import static org.junit.Assert.*;

import org.junit.Test;

import ELMS.businesslogic.MemberBL.Member;
import ELMS.businesslogic.MemberBL.MemberList;
import ELMS.businesslogic.MemberBL.MockMember;

public class MemberTester {
	
	@Test
	public void test(){
		Member m=new Member();
		
		MockMember mm1=new MockMember("025000000","周颖婷","1997-02-03",
				"320283199702031168","13951972125","女","2020-11-16","3000");
		MockMember mm2=new MockMember("025000001","张海涛","1995-01-01",
				"320283199501011167","18888888888","男","2018-11-11","3000");
		MockMember mm3=new MockMember("025000002","张文玘","1996-06-26",
				"320283199606261166","11111111111","女","2019-01-01","3000");
		MockMember mm4=new MockMember("025000003","陈翔","1989-12-13",
				"320283198912131165","12712712712","男","2025-08-28","4000");
		
		MemberList ml1=new MemberList();
		MemberList ml2=new MemberList();
		
		ml1.add(mm1);ml1.add(mm2);ml1.add(mm3);ml1.add(mm4);
		ml2.add(mm1);ml2.add(mm2);ml2.add(mm3);ml2.add(mm4);
		
		assertEquals(ml1.get(0).getID(),m.findDriver().get(0).getID());
		assertEquals(ml1.get(1).getName(),m.findDriver().get(1).getName());
		assertEquals(ml1.get(2).getBirthday(),m.findDriver().get(2).getBirthday());
		assertEquals(ml1.get(3).getIDcard(),m.findDriver().get(3).getIDcard());
		assertEquals(ml1.get(4).getCallNumber(),m.findDriver().get(4).getCallNumber());
		assertEquals(ml1.get(5).getGender(),m.findDriver().get(5).getGender());
		assertEquals(ml1.get(6).getLicenseDate(),m.findDriver().get(6).getLicenseDate());
		assertEquals(ml1.get(7).getSalary(),m.findDriver().get(7).getSalary());
		
		
	}

}
