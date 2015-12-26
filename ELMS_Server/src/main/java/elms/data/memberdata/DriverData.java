package elms.data.memberdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import elms.dataservice.memberdataservice.DriverDataService;
import elms.po.DriverPO;

public class DriverData extends UnicastRemoteObject implements DriverDataService{

	File file=new File("Driver.ser");
	FileInputStream fis;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	
	public DriverData() throws RemoteException {
		super();
	}
	
	//9位编号
	public DriverPO find(String id) throws RemoteException, IOException {
		fis=new FileInputStream(file);
		ois=new ObjectInputStream(fis);
		DriverPO driverpo=null;
		try{
			driverpo=(DriverPO)ois.readObject();
			while(fis.available()>0){
				byte[] buf=new byte[4];
				fis.read(buf);
				driverpo=(DriverPO)ois.readObject();
				if(driverpo.getID().equals(id)){
					return driverpo;
				}
			}
			return null;
		}catch(Exception e){
			return null;
		}finally{
			ois.close();
		}
	}
	
	public void insert(DriverPO po) throws RemoteException, IOException {
		try{
			FileOutputStream fs=new FileOutputStream(file,true);
			oos=new ObjectOutputStream(fs);
			oos.writeObject(po);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			oos.close();
		}
		
	}
	
	public void delete(DriverPO po) throws RemoteException, IOException {
		fis=new FileInputStream(file);
		ois=new ObjectInputStream(fis);
		ArrayList<DriverPO> arr=new ArrayList<DriverPO>();
		try{
			DriverPO po1=(DriverPO)ois.readObject();
			arr.add(po1);
			while(fis.available()>0){
				byte[] buf=new byte[4];
				fis.read(buf);
//zyt
//				po1=(DriverPO)ois.readObject();
//				arr.add(po1);
//zyt
//zwh
				DriverPO driverpo=(DriverPO)ois.readObject();
				arr.add(driverpo);
//zwh				
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			ois.close();
		}
		
		for(int i=1;i<arr.size();i++){
			if(arr.get(i).getID().equals(po.getID())){
				arr.remove(i);
				break;
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
	public void update(DriverPO po) throws RemoteException, IOException {
		delete(po);
		insert(po);
	}
	
	public ArrayList<DriverPO> findall() throws RemoteException, IOException{
		fis=new FileInputStream(file);
		ois=new ObjectInputStream(fis); 
		ArrayList<DriverPO> arr=new ArrayList<DriverPO>();
					
		try{
			DriverPO po=(DriverPO)ois.readObject();
			arr.add(po);
			while(fis.available()>0){
				byte[] buf=new byte[4];
				fis.read(buf);
				DriverPO driverpo=(DriverPO)ois.readObject();
				arr.add(driverpo);
			}
			return arr;
		}catch(Exception e){
			return arr;
		}
		finally{
			try{
				ois.close();
			}catch(Exception e){
						
			}
		}				
	}
	
	public void init() throws RemoteException {
		file.delete();
		DriverPO po=new DriverPO();
		try{
			insert(po);
		}catch (IOException e){
			e.printStackTrace();
		}
		
	}
	public void finish() throws RemoteException {
		// TODO 自动生成的方法存根
		
	}

	
}
