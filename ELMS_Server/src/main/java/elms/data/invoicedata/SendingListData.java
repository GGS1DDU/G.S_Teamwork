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

import elms.dataservice.invoicedataservice.SendingListDataService;
import elms.po.SendingListPO;

public class SendingListData extends UnicastRemoteObject implements SendingListDataService {
	File file=new File("SendingList.ser");
	FileInputStream fis;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	
	public SendingListData() throws RemoteException {
		super();
	}

	//sendingList派件单的id定义为sl开头+五位数字，一个七位id
	public SendingListPO find(String id) throws RemoteException, IOException {
		fis=new FileInputStream(file);
		ois=new ObjectInputStream(fis);
		SendingListPO sendingListpo=null;
		try{
			sendingListpo=(SendingListPO)ois.readObject();
			while(fis.available()>0){
				byte[] buf=new byte[4];
				fis.read(buf);
				sendingListpo=(SendingListPO)ois.readObject();
				if(sendingListpo.getID().equals(id)){
					return sendingListpo;
				}
			}
			return null;
		}catch(Exception e){
			return null;
		}finally{
			ois.close();
		}
	}

	public void insert(SendingListPO po) throws RemoteException, IOException {
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

	public void delete(SendingListPO po) throws RemoteException, IOException {
		fis=new FileInputStream(file);
		ois=new ObjectInputStream(fis);
		ArrayList<SendingListPO> arr=new ArrayList<SendingListPO>();
		try{
			SendingListPO po1=(SendingListPO)ois.readObject();
			arr.add(po1);
			while(fis.available()>0){
				byte[] buf=new byte[4];
				fis.read(buf);
//zyt
//				po1=(SendingListPO)ois.readObject();
//				arr.add(po1);
//zyt
//zwh
				SendingListPO sendinglistpo=(SendingListPO)ois.readObject();
				arr.add(sendinglistpo);
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

	public void update(SendingListPO po) throws RemoteException, IOException {
	
		delete(po);
		insert(po);
		
	}

	//zwh
	//这个方法要返回传入的maker的所有未通过审核的单据集合
	public ArrayList<SendingListPO> findall() throws RemoteException, IOException{
		fis=new FileInputStream(file);
		ois=new ObjectInputStream(fis); 
		ArrayList<SendingListPO> arr=new ArrayList<SendingListPO>();
				
		try{
			SendingListPO po=(SendingListPO)ois.readObject();
			arr.add(po);
			while(fis.available()>0){
				byte[] buf=new byte[4];
				fis.read(buf);
				SendingListPO sendinglistpo=(SendingListPO)ois.readObject();
				arr.add(sendinglistpo);
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
	
	
	public ArrayList<SendingListPO> findbymaker(String maker) throws RemoteException, IOException{	
		fis=new FileInputStream(file);
		ois=new ObjectInputStream(fis);	
		ArrayList<SendingListPO> arr=new ArrayList<SendingListPO>();	
	
		try{		
			SendingListPO po=(SendingListPO)ois.readObject();		
			while(fis.available()>0){			
				byte[] buf=new byte[4];			
				fis.read(buf);			
				po=(SendingListPO)ois.readObject();			
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
		SendingListPO po=new SendingListPO();
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
