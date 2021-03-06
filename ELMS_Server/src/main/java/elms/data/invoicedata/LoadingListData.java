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

	//loadingList营业厅装车单的id定义为ll开头+五位数字，一个七位id
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
//zyt
//				po1=(LoadingListPO)ois.readObject();
//				arr.add(po1);
//zyt
//zwh
				LoadingListPO loadinglistpo=(LoadingListPO)ois.readObject();
				arr.add(loadinglistpo);
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

	public void update(LoadingListPO po) throws RemoteException, IOException {
		delete(po);
		insert(po);
	}

	//zwh
	//这个方法要返回传入的maker的所有未通过审核的单据集合
	public ArrayList<LoadingListPO> findall() throws RemoteException, IOException{
		fis=new FileInputStream(file);
		ois=new ObjectInputStream(fis); 
		ArrayList<LoadingListPO> arr=new ArrayList<LoadingListPO>();
					
		try{
			LoadingListPO po=(LoadingListPO)ois.readObject();
			arr.add(po);
			while(fis.available()>0){
				byte[] buf=new byte[4];
				fis.read(buf);
				LoadingListPO loadinglistpo=(LoadingListPO)ois.readObject();
				arr.add(loadinglistpo);
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
	
	public ArrayList<LoadingListPO> findbymaker(String maker) throws RemoteException, IOException{	
		fis=new FileInputStream(file);
		ois=new ObjectInputStream(fis);	
		ArrayList<LoadingListPO> arr=new ArrayList<LoadingListPO>();	
	
		try{		
			LoadingListPO po=(LoadingListPO)ois.readObject();		
			while(fis.available()>0){			
				byte[] buf=new byte[4];			
				fis.read(buf);			
				po=(LoadingListPO)ois.readObject();			
				if(po.getMaker().equals(maker)){				
					arr.add(po);			
				}				
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
