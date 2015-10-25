package ELMS.businesslogic.UserBL;

import ELMS.businesslogicService.UserBlService;
import ELMS.vo.UserVO;

public class UserBL_driver {
	public void driver(UserBlService UserBlService){
		//登录
		String a="zwh";
		String b="111111";
		UserVO vo=UserBlService.login(a, b);
		if(vo!=null){
			System.out.println("登录成功!\n");
		}
		
		//查询
		UserVO VO=UserBlService.inquiryUser("zwh");
		if(VO!=null){
			System.out.println("账号是："+VO.getId());
			System.out.println("密码是："+VO.getPassword());
			System.out.println("职务是"+VO.getJob()+"\n");
		}
		
		//新增账户
		if(UserBlService.addUser("aaa", "111111", "快递员B", "快递员")) System.out.println("成功增加账户！\n");
		
		//删除账户
		if(UserBlService.deleteUser("zwh"))   System.out.println("成功删除账户!\n");
		
		//更新账户
		
		UserVO VO2=UserBlService.updateJob("zwh", "总经理");
		if(VO2!=null) System.out.println("账户信息更新成功!\n");
		
		
	}
	

}
