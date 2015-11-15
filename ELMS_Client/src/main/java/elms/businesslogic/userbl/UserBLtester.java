package elms.businesslogic.userbl;

import static org.junit.Assert.*;

import org.junit.Test;

import elms.vo.UserVO;

public class UserBLtester {

	@Test
	public void testFindUser(){
		MockUserBL userbl=new MockUserBL(new UserVO("admin","admin","zwh","系统管理员"));
		
		assertEquals("admin",userbl.findUser().getId());
		assertEquals("admin",userbl.findUser().getPassword());
		
		
		
	}
}