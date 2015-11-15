package businesslogic.UserBL;

import static org.junit.Assert.*;

import org.junit.Test;

import ELMS.businesslogic.UserBL.MockUserBL;
import ELMS.vo.UserVO;

public class findUser_tester {

	@Test
	public void testFindUser(){
		MockUserBL userbl=new MockUserBL(new UserVO("admin","zwh","admin","系统管理员"));
		
		assertEquals("admin",userbl.findUser().getId());
		assertEquals("admin",userbl.findUser().getPassword());
		
		
		
	}

}
