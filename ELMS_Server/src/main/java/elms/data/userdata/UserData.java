package elms.data.userdata;

import java.io.*;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;




import elms.dataservice.userdataservice.UserDataService;
import elms.po.UserPO;

public class UserData extends UnicastRemoteObject implements UserDataService{


	public UserData() throws RemoteException {
		super();
	}

	
/*	public static void main(String []args) throws Exception{
		
		UserData ud=new UserData();
		ud.init();		
		
	}*/
	
	
	
	public UserPO find(String id) throws IOException   {		
		UserPO po=null;
		ObjectInputStream os=null;
		try {			
			FileInputStream fs =new FileInputStream("C://学习//大二上//软件工程与计算2//快递物流管理系统//My code//ELMS_Server//User.ser");
			os=new ObjectInputStream(fs);
			po=(UserPO)os.readObject();
			if(po.getId().equals(id)){
				os.close();
				return po;
			}
			else{
				do{
					byte[] buf=new byte[4];
					fs.read(buf);
					po=(UserPO)os.readObject();
				}while(!(po.getId().equals(id)));
			}
			return po;
		} catch (Exception e) {
			return null;
		} 
		finally{
			os.close();
		}				
	}

	public ArrayList<UserPO> findall() throws RemoteException {

		return null;
	}

	public void insert(UserPO po) throws IOException  {
		ObjectOutputStream oos=null;
		try {
			File file=new File("C://学习//大二上//软件工程与计算2//快递物流管理系统//My code//ELMS_Server//User.ser");
			FileOutputStream fs=new FileOutputStream(file,true);
			oos=new ObjectOutputStream(fs);
			oos.writeObject(po);
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			oos.close();
		}


		
	}

	public void delete(UserPO po) throws RemoteException {
		UserPO PO=null;
		ObjectInputStream ois=null;
		ObjectOutputStream oos=null;
		ArrayList<UserPO> arr=new ArrayList<UserPO>();
		try{
			FileInputStream fs =new FileInputStream("C://学习//大二上//软件工程与计算2//快递物流管理系统//My code//ELMS_Server//User.ser");
			ois=new ObjectInputStream(fs);
			PO=(UserPO)ois.readObject();			System.out.println(PO.getId());
			arr.add(PO);
			while(true){
				byte[] buf=new byte[4];
				fs.read(buf);
				PO=(UserPO)ois.readObject();
				System.out.println(PO.getId());
				arr.add(PO);
			}		
		}catch(Exception e){
			System.out.println("User扫描完毕");
		}
		finally{
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			finally{
		
			for(int i=0;i<arr.size();i++){
				if(arr.get(i).getId().equals(po.getId())){
					arr.remove(i);					
				}
			}
			try{
				UserData ud=new UserData();
				ud.init();
				for(int i=1;i<arr.size();i++){
					ud.insert(arr.get(i));				
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}		
}

	public void update(UserPO po) throws RemoteException {
		UserPO PO=null;
		ObjectInputStream ois=null;
		ObjectOutputStream oos=null;
		ArrayList<UserPO> arr=new ArrayList<UserPO>();
		try{
			FileInputStream fs =new FileInputStream("C://学习//大二上//软件工程与计算2//快递物流管理系统//My code//ELMS_Server//User.ser");
			ois=new ObjectInputStream(fs);
			PO=(UserPO)ois.readObject();			System.out.println(PO.getId());
			arr.add(PO);
			while(true){
				byte[] buf=new byte[4];
				fs.read(buf);
				PO=(UserPO)ois.readObject();
				System.out.println(PO.getId());
				arr.add(PO);
			}		
		}catch(Exception e){
			System.out.println("User扫描完毕");
		}
		finally{
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			finally{
		
			for(int i=0;i<arr.size();i++){
				if(arr.get(i).getId().equals(po.getId())){
					arr.remove(i);
					System.out.println("已移除旧的");
				}
			}
			arr.add(po);
			try{
				UserData ud=new UserData();
				ud.init();
				for(int i=1;i<arr.size();i++){
					ud.insert(arr.get(i));				
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}		
} 
		
		
		
	
		
	

	public void init() throws RemoteException {
		File file =new File("C://学习//大二上//软件工程与计算2//快递物流管理系统//My code//ELMS_Server//User.ser");
		file.delete();
		UserData ud=null;
		try {
			ud = new UserData();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		UserPO po=new UserPO("admin","admin","郑闻昊","系统管理员");
		try {
			ud.insert(po);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		
	
		
	}

	public void finish() throws RemoteException {
		
		
	}

}