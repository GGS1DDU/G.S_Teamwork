package ELMS.data.Storagedata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import ELMS.dataservice.StorageDataService;
import ELMS.po.StoragePO;

public class StorageData_stub implements StorageDataService {

	public StoragePO find(String id) throws RemoteException {
		StoragePO po=new StoragePO(id, "汽运区", "S9R4S15","0000004158","2015-10-26" , null, "在库存", "南京");
		// TODO Auto-generated method stub
		return po;
	}

	public ArrayList<StoragePO> findall(String center) throws RemoteException {
		ArrayList<StoragePO> al=new ArrayList<StoragePO>();
		StoragePO vo=new StoragePO("0006", "航运区", "S3R4S23","0000012543","2015-05-22", "2015-05-23", "出库", center);
		StoragePO vo1=new StoragePO("0007", "汽运区", "S9R4S15","0000004158","2015-05-25" , null, "在库存", center);
		StoragePO vo2=new StoragePO("0008", "机动区", "S1R7S04","0000013254","2015-05-24" , "2015-05-25", "出库", center);
		al.add(vo);
		al.add(vo1);
		al.add(vo2);
		return al;
	}

	public ArrayList<StoragePO> findbytime(String time1, String time2,
			String center) throws RemoteException {
		ArrayList<StoragePO> al=new ArrayList<StoragePO>();
		StoragePO vo=new StoragePO("0006", "航运区", "S3R4S23","0000012543",time1 , "2015-05-23", "出库", center);
		StoragePO vo1=new StoragePO("0007", "汽运区", "S9R4S15","0000004158","2015-05-25" , null, "在库存", center);
		StoragePO vo2=new StoragePO("0008", "机动区", "S1R7S04","0000013254","2015-05-24" , time2, "出库", center);
		al.add(vo);
		al.add(vo1);
		al.add(vo2);
		return al;
	}

	public void insert(StoragePO po) throws RemoteException {
		System.out.println("新建库存项成功！");
		// TODO Auto-generated method stub
		
	}

	public void delete(StoragePO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("该库存项已删除！");
	}

	public void update(StoragePO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("库存项已更新");
	}

	public void init() throws RemoteException {
		System.out.println("数据库已初始化完成！");
		// TODO Auto-generated method stub
		
	}

	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("数据库使用完毕！");
	}

}
