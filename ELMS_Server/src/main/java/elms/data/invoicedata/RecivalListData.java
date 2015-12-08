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

import elms.dataservice.invoicedataservice.RecivalListDataService;
import elms.po.RecivalListPO;

public class RecivalListData extends UnicastRemoteObject implements RecivalListDataService{
	File file=new File("RecivalList.ser");
	FileInputStream fis;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	
	public RecivalListData() throws RemoteException{
		super();
	}

	//recivalList接收单的id定义为rl开头+五位数字，一个七位id
	public RecivalListPO find(String id) throws RemoteException, IOException {
		fis=new FileInputStream(file);
		ois=new ObjectInputStream(fis);
		RecivalListPO recivalListpo=null;
		try{
			recivalListpo=(RecivalListPO)ois.readObject();
			while(fis.available()>0){
				byte[] buf=new byte[4];
				fis.read(buf);
				recivalListpo=(RecivalListPO)ois.readObject();
				if(recivalListpo.getID().equals(id)){
					return recivalListpo;
				}
			}
			return null;
		}catch(Exception e){
			return null;
		}finally{
			ois.close();
		}
	}

	public void insert(RecivalListPO po) throws RemoteException, IOException {
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

	public void delete(RecivalListPO po) throws RemoteException, IOException {
		fis=new FileInputStream(file);
		ois=new ObjectInputStream(fis);
		ArrayList<RecivalListPO> arr=new ArrayList<RecivalListPO>();
		try{
			RecivalListPO po1=(RecivalListPO)ois.readObject();
			arr.add(po1);
			while(fis.available()>0){
				byte[] buf=new byte[4];
				fis.read(buf);
				po1=(RecivalListPO)ois.readObject();
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

	public void update(RecivalListPO po) throws RemoteException, IOException {
		delete(po);
		insert(po);
		
	}

	public void init() throws RemoteException {
		file.delete();
		RecivalListPO po=new RecivalListPO();
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
