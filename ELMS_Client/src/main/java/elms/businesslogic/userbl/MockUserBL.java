package elms.businesslogic.userbl;

import elms.vo.UserVO;

public class MockUserBL  extends UserBL{
		UserVO user;
		public MockUserBL (UserVO user){
			this.user=user;
		}
		public UserVO findUser(){
			return user;
		}
	

}
