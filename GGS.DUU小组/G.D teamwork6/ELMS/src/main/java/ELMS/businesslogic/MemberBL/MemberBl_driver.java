package ELMS.businesslogic.MemberBL;

import java.util.ArrayList;

import ELMS.businesslogicService.MemberBlService;
import ELMS.vo.MemberVO;
import ELMS.vo.StaffVO;

public class MemberBl_driver {
	public MemberBl_driver(MemberBlService ms){
		
		System.out.println("查找ID-0001的员工！");
		StaffVO vo=(StaffVO) ms.find("0001");
		System.out.println(vo.getID()+" "+vo.getName()+" "+vo.getGender()+" "+vo.getPost()+" "+vo.getIDcard()+" "+vo.getSalary()+" "+vo.getCallNumber()+"\n");	
		
		System.out.println("查看所有员工信息！");
		ArrayList<MemberVO> al=new ArrayList<MemberVO>();
		al=ms.findAll();
		for(int i=0;i<al.size();i++)
			System.out.println("\t"+((StaffVO) al.get(i)).getID()+" "+((StaffVO) al.get(i)).getName()+
					" "+((StaffVO) al.get(i)).getGender()+" "+((StaffVO) al.get(i)).getPost()+" "+
					((StaffVO) al.get(i)).getIDcard()+" "+((StaffVO) al.get(i)).getSalary()+" "+((StaffVO) al.get(i)).getCallNumber()+"\n");	
		System.out.println();
		
		System.out.println("添加新的员工信息！");
		if(ms.addMember(vo))  System.out.println("添加新成员信息成功！\n");
		
		System.out.println("删除员工信息！");
		ms.deleteMember(vo);
		
		System.out.println("更新ID-0001员工信息！");
	    StaffVO vo1=new StaffVO("0001", "Deft", "女", "仓库管理员", "433566", 4500, "0931524");
	    vo1=(StaffVO) ms.update(vo1);
		System.out.println(vo1.getID()+" "+vo1.getName()+" "+vo1.getGender()+" "+vo1.getPost()+" "+vo1.getIDcard()+" "+vo1.getSalary()+" "+vo1.getCallNumber()+"\n");	

		System.out.println("操作完成！");
		ms.endMemberOpt();

	}

}
