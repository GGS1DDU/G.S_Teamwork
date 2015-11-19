package ELMS.businesslogic.UserBL;


public class MockUserBL extends UserBL {
	
	MockUser user;
	public MockUserBL (MockUser user){
		this.user=user;
	}
	public MockUser findUser(){
		return user;
	}

}
