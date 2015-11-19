package businesslogic.UserBL;

import static org.junit.Assert.*;

import org.junit.Test;

import ELMS.businesslogic.UserBL.Login;
import ELMS.businesslogic.UserBL.MockUser;
import ELMS.businesslogic.UserBL.MockUserBL;

public class Login_tester {

	@Test
	public void testLogin() {
		MockUserBL userbl=new MockUserBL(new MockUser("admin","zwh","admin","系统管理员"));
		Login login1=new Login();
		
		assertEquals(0,login1.login(userbl,"admin","admin"));		
		assertEquals(-1,login1.login(userbl,"admin","admn"));  
		
		
		
	}

}
