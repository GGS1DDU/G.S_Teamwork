package elms.data.invoicedata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;



import elms.dataservice.invoicedataservice.LoadingListZZDataService;
import elms.po.LoadingListZZPO;

public class LoadingListZZData extends UnicastRemoteObject implements LoadingListZZDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2858159389550218925L;
	File file=new File("LoadingListZZ.ser");
	FileInputStream fis;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	
	public LoadingListZZData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public LoadingListZZPO find(String id) throws RemoteException, IOException {
		fis=new FileInputStream(file);
		ois=new ObjectInputStream(fis);
		LoadingListZZPO loadingListZZpo=null;
		try{
			loadingListZZpo=(LoadingListZZPO)ois.readObject();
			while(fis.available()>0){
				byte[] buf=new byte[4];
				fis.read(buf);
				loadingListZZpo=(LoadingListZZPO)ois.readObject();
				if(loadingListZZpo.getID().equals(id)){
					return loadingListZZpo;
				}
			}
			return null;
		}catch(Exception e){
			return null;
		}finally{
			ois.close();
		}
	}

	public void insert(LoadingListZZPO po) throws RemoteException, IOException {
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

	public void delete(LoadingListZZPO po) throws RemoteException, IOException {
		fis=new FileInputStream(file);
		ois=new ObjectInputStream(fis);
		ArrayList<LoadingListZZPO> arr=new ArrayList<LoadingListZZPO>();
		try{
			LoadingListZZPO po1=(LoadingListZZPO)ois.readObject();
			arr.add(po1);
			while(fis.available()>0){
				byte[] buf=new byte[4];
				fis.read(buf);
//zyt				
//				po1=(LoadingListZZPO)ois.readObject();
//				arr.add(po1);
//zyt
//zwh
				LoadingListZZPO loadinglistzzpo=(LoadingListZZPO)ois.readObject();
				arr.add(loadinglistzzpo);
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
			for(int i=0;i<arr.size();i++){
				insert(arr.get(i));
			}
		}catch(Exception e){
			e.printStackTrace();
		}		
	}

	public void update(LoadingListZZPO po) throws RemoteException, IOException {
		delete(po);
		insert(po);
	}

	//zwh
	//这个方法要返回传入的maker的所有未通过审核的单据集合
	public ArrayList<LoadingListZZPO> findall() throws RemoteException, IOException{
		fis=new FileInputStream(file);
		ois=new ObjectInputStream(fis); 
		ArrayList<LoadingListZZPO> arr=new ArrayList<LoadingListZZPO>();
					
		try{
			LoadingListZZPO po=(LoadingListZZPO)ois.readObject();
			arr.add(po);
			while(fis.available()>0){
				byte[] buf=new byte[4];
				fis.read(buf);
				LoadingListZZPO loadinglistzzpo=(LoadingListZZPO)ois.readObject();
				arr.add(loadinglistzzpo);
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
//zwh
	
	public void init() throws RemoteException {
		file.delete();
		LoadingListZZPO po=new LoadingListZZPO();
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
