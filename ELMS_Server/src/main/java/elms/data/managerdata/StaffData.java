package elms.data.managerdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import elms.dataservice.managerdataservice.StaffDataService;
import elms.po.StaffPO;

public class StaffData extends UnicastRemoteObject implements StaffDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1700856463403538324L;
	File file = new File("Staff.ser");

	public StaffData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}
	
	public static void main(String[] args) throws Exception{
		StaffData sd = new StaffData();
		StaffPO po = new StaffPO("kd000001", "张文玘", 20, false,
				"140311199512251522", "南京大学", "18260068636", "快递员",
				1500.0, "提成", "南京市仙林营业厅");
//		sd.insert(po);
//		sd.delete(po);
//		StaffPO po1 = sd.find("kd000001");
//		System.out.println(po1.getName());
	}

	public StaffPO find(String id) throws RemoteException, IOException {
		// TODO 自动生成的方法存根
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try{
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			StaffPO staff = (StaffPO)ois.readObject();
			
			while(fis.available()>0){
				byte[] buf = new byte[4];
				fis.read(buf);
				staff = (StaffPO) ois.readObject();
				if(staff.getID().equals(id)){
					return staff;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			ois.close();
		}
		return null;
	}

	public ArrayList<StaffPO> findall() throws RemoteException, IOException {
		// TODO 自动生成的方法存根
		
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		ArrayList<StaffPO> arr = new ArrayList<StaffPO>();
		try{
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			StaffPO staff = (StaffPO) ois.readObject();
			
			while(fis.available()>0){
				byte[] buf = new byte[4];
				fis.read(buf);
				staff = (StaffPO) ois.readObject();
				arr.add(staff);
			}
			return arr;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		finally{
			ois.close();
		}
		
	}

	public void insert(StaffPO po) throws Exception {
		// TODO 自动生成的方法存根
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(file,true);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(po);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			oos.close();
		}
		
	}

	public void delete(StaffPO po) throws RemoteException {
		// TODO 自动生成的方法存根
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		ArrayList<StaffPO> arr = new ArrayList<StaffPO>();
		try{
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			
			StaffPO staff = (StaffPO) ois.readObject();
			
			while(fis.available()>0){
				byte[] buf = new byte[4];
				fis.read(buf);
				staff = (StaffPO) ois.readObject();
				arr.add(staff);
				System.out.println(staff.getID());
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("扫描完毕!");
		}
		finally{
			try {
				ois.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			for(int i = 0; i < arr.size(); i++){
				if(arr.get(i).getID().equals(po.getID())){
					arr.remove(i);
					break;
				}
			}
			
			init();
			for(int i = 0; i < arr.size(); i++){
				try {
					insert(arr.get(i));   System.out.println(arr.get(i).getID());
				} catch (Exception e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		}
	}

	public void update(StaffPO po) throws RemoteException {
		// TODO 自动生成的方法存根
		delete(po);
		try {
			insert(po);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		

	}

	public void init() throws RemoteException {
		// TODO 自动生成的方法存根
		file.delete();
		StaffPO po = new StaffPO();
		try {
			insert(po);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

	}

	public void finish() throws RemoteException {
		// TODO 自动生成的方法存根

	}

}
