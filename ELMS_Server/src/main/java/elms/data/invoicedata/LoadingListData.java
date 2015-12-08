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

import elms.dataservice.invoicedataservice.LoadingListDataService;
import elms.po.LoadingListPO;

public class LoadingListData extends UnicastRemoteObject implements LoadingListDataService{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4964098333053702134L;
	File file=new File("LoadingList.ser");
	FileInputStream fis;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	
	public LoadingListData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public LoadingListPO find(String id) throws RemoteException, IOException {
		fis=new FileInputStream(file);
		ois=new ObjectInputStream(fis);
		LoadingListPO loadingListpo=null;
		try{
			loadingListpo=(LoadingListPO)ois.readObject();
			while(fis.available()>0){
				byte[] buf=new byte[4];
				fis.read(buf);
				loadingListpo=(LoadingListPO)ois.readObject();
				if(loadingListpo.getID().equals(id)){
					return loadingListpo;
				}
			}
			return null;
		}catch(Exception e){
			return null;
		}finally{
			ois.close();
		}
	}

	public void insert(LoadingListPO po) throws RemoteException, IOException {
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

	public void delete(LoadingListPO po) throws RemoteException, IOException {
		fis=new FileInputStream(file);
		ois=new ObjectInputStream(fis);
		ArrayList<LoadingListPO> arr=new ArrayList<LoadingListPO>();
		try{
			LoadingListPO po1=(LoadingListPO)ois.readObject();
			arr.add(po1);
			while(fis.available()>0){
				byte[] buf=new byte[4];
				fis.read(buf);
				po1=(LoadingListPO)ois.readObject();
				arr.add(po1);
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

	public void update(LoadingListPO po) throws RemoteException, IOException {
		delete(po);
		insert(po);
	}

	public void init() throws RemoteException {
		file.delete();
		LoadingListPO po=new LoadingListPO();
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
