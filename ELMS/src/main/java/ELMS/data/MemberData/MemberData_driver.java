package ELMS.data.MemberData;

import java.rmi.RemoteException;
import java.util.ArrayList;

import ELMS.dataservice.MemberDataService;
import ELMS.po.MemberPO;
import ELMS.po.StaffPO;

public class MemberData_driver  {
public MemberData_driver(MemberDataService mds) throws RemoteException{
	
	System.out.println("查找ID-0001的员工！");
	StaffPO vo=(StaffPO) mds.find("0001");
	System.out.println(vo.getID()+" "+vo.getName()+" "+vo.getGender()+" "+vo.getPost()+" "+vo.getIDcard()+" "+vo.getSalary()+" "+vo.getCallNumber()+"\n");	
	
	System.out.println("查看所有员工信息！");
	ArrayList<MemberPO> al=new ArrayList<MemberPO>();
	al=mds.findAll();
	for(int i=0;i<al.size();i++)
		System.out.println("\t"+((StaffPO) al.get(i)).getID()+" "+((StaffPO) al.get(i)).getName()+
				" "+((StaffPO) al.get(i)).getGender()+" "+((StaffPO) al.get(i)).getPost()+" "+
				((StaffPO) al.get(i)).getIDcard()+" "+((StaffPO) al.get(i)).getSalary()+" "+((StaffPO) al.get(i)).getCallNumber()+"\t");	
	System.out.println();
	
	System.out.println("添加员工信息！");
     mds.insert(vo);
     
 	System.out.println("删除员工信息！");
 	mds.delete(vo);
 	
 	System.out.println("更新与昂信息！");
 	mds.update(vo);
 	
 	System.out.println("初始化成员信息！");
 	mds.init();
 	
 	System.out.println("完成操作！");
 	mds.finish();
	
}
}
