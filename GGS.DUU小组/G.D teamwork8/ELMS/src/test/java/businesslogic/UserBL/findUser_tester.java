package businesslogic.UserBL;

import static org.junit.Assert.*;

import org.junit.Test;

import ELMS.businesslogic.UserBL.MockUserBL;
import ELMS.businesslogic.UserBL.MockUser;

public class findUser_tester {

	@Test
	public void testFindUser(){
		MockUserBL userbl=new MockUserBL(new MockUser("admin","zwh","admin","系统管理员"));
		
		assertEquals("admin",userbl.findUser().getId());
		assertEquals("admin",userbl.findUser().getPassword());
		
		
		
	}

}
