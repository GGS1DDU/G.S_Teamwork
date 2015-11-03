package ELMS.data.MemberData;

import java.rmi.RemoteException;
import java.util.ArrayList;

import ELMS.dataservice.MemberDataService;
import ELMS.po.MemberPO;
import ELMS.po.StaffPO;


public class MemberData_stub implements MemberDataService {

	public MemberPO find(String id) throws RemoteException {
		StaffPO po=new StaffPO(id, "edison", "男", "快递员", "123456", 5200, "6151200");
		return po;
	}

	public ArrayList<MemberPO> findAll() throws RemoteException {
		StaffPO s1=new StaffPO("0001", "edison", "男", "快递员", "123456", 5200, "6151200");
		StaffPO s2=new StaffPO("0002", "faker", "女", "中转中心仓库管理员", "54559x", 4900, "1125000");
		StaffPO s3=new StaffPO("0003", "meiko", "女", "营业厅业务员", "358700", 6000, "1989585");
		ArrayList<MemberPO> al=new ArrayList<MemberPO>();
		al.add(s1);
		al.add(s2);
		al.add(s3);
		// TODO Auto-generated method stub
		return al;
	}

	public void insert(MemberPO po) throws RemoteException {
		System.out.println("新增成员成功！\n");
		// TODO Auto-generated method stub
		
	}

	public void delete(MemberPO po) throws RemoteException {
		System.out.println("删除成员成功！\n");
	// TODO Auto-generated method stub
		
	}

	public void update(MemberPO po) throws RemoteException {
		System.out.println("更新成员成功！\n");
// TODO Auto-generated method stub
		
	}

	public void init() throws RemoteException {
		System.out.println("初始化成员清单成功！\n");
		
	}

	public void finish() throws RemoteException {
		System.out.println("人员操作结束！\n");
	// TODO Auto-generated method stub
		
	}

}
