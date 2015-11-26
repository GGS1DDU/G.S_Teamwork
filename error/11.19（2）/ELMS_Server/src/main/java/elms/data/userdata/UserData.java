package elms.data.userdata;

import java.io.*;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;






import elms.dataservice.userdataservice.UserDataService;
import elms.po.UserPO;

public class UserData extends UnicastRemoteObject implements UserDataService{
	
	File file=new File("User.ser");


	public UserData() throws RemoteException {
		super();
	}

	
/*	public static void main(String []args) throws Exception{
		
		
		init();		
		
	}*/     //软件打包前。
	
	public static void main(String [] args) throws Exception{
		UserData ud=new UserData();
		ArrayList<UserPO> arr=ud.findall();
		for(int i=0;i<arr.size();i++){
			System.out.println(arr.get(i).getId());
		}
	}
	
	
	
	public UserPO find(String id) throws IOException   {		
		UserPO po=null;
		ObjectInputStream os=null;
		try {			
			FileInputStream fs =new FileInputStream(file);
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

	public ArrayList<UserPO> findall() throws RemoteException, IOException {
		ArrayList<UserPO> arr=new ArrayList<UserPO>();
		ObjectInputStream os=null;
		try{
			FileInputStream fs=new FileInputStream(file);
			os=new ObjectInputStream(fs);			
			UserPO po=(UserPO)os.readObject();
			arr.add(po);
			
			while(fs.available()>0){
				byte[] buf =new byte[4];
				fs.read(buf);
				UserPO userpo=(UserPO)os.readObject();
				arr.add(userpo);
			}
			return arr;
		}catch (Exception e){
			return arr;
		}
		finally{
			os.close();
		}
	} 
	
	

	public void insert(UserPO po) throws IOException  {
		ObjectOutputStream oos=null;
		try {
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
		ArrayList<UserPO> arr=new ArrayList<UserPO>();
		try{
			FileInputStream fs =new FileInputStream(file);
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
				init();
				for(int i=1;i<arr.size();i++){
					insert(arr.get(i));				
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}		
}

	public void update(UserPO po) throws RemoteException {
		delete(po);
		try {
			insert(po);
		} catch (IOException e) {
			e.printStackTrace();
		}
} 
		
		
		
	
		
	

	public void init() throws RemoteException {
		file.delete();
		UserPO po=new UserPO("admin","admin","郑闻昊","系统管理员");
		try {
			insert(po);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		
	
		
	}

	public void finish() throws RemoteException {
		
		
	}

}