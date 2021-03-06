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

import elms.dataservice.invoicedataservice.ArrivalListDataService;
import elms.po.ArrivalListPO;
import elms.po.SendingListPO;

public class ArrivalListData extends UnicastRemoteObject implements ArrivalListDataService{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8622470618454289613L;
	File file=new File("ArrivalList.ser");
	FileInputStream fis;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	
	public ArrivalListData() throws RemoteException {
		super();
	}

//	public static void main(String arg[])throws IOException,ClassNotFoundException,ParseException{
//		ArrivalListData data=new ArrivalListData();
//		ArrivalListPO aer=new ArrivalListPO();
//		data.init();
//		data.insert(new ArrivalListPO("al00001","025000201511190000001","2015-11-19","完整","北京"));
//		data.insert(new ArrivalListPO("al00002","025000201511200000002","2015-11-20","损坏","上海"));
//		data.insert(new ArrivalListPO("al00003","025000201511210000003","2015-11-21","丢失","广州"));
//		data.insert(new ArrivalListPO("al00004","025000201511220000004","2015-11-22","完整","南京"));
//		aer=data.find("al00001");
//		System.out.println(aer.getID()+"  "+aer.getOrder()+"   "+aer.getTime()+"   "+aer.getState()+"   "+aer.getFrom());
//	}
	
	//arrivalList到达单的id定义为al开头+五位数字，一个七位id
	public ArrivalListPO find(String id) throws RemoteException, IOException {
		fis=new FileInputStream(file);
		ois=new ObjectInputStream(fis);
		ArrivalListPO arrivalListpo=null;
		try{
			arrivalListpo=(ArrivalListPO)ois.readObject();
			while(fis.available()>0){
				byte[] buf=new byte[4];
				fis.read(buf);
				arrivalListpo=(ArrivalListPO)ois.readObject();
				if(arrivalListpo.getID().equals(id)){
					return arrivalListpo;
				}
			}
			return null;
		}catch(Exception e){
			return null;
		}finally{
			ois.close();
		}
	}

	public void insert(ArrivalListPO po) throws RemoteException, IOException {
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

	public void delete(ArrivalListPO po) throws RemoteException, IOException {
		fis=new FileInputStream(file);
		ois=new ObjectInputStream(fis);
		ArrayList<ArrivalListPO> arr=new ArrayList<ArrivalListPO>();
		try{
			ArrivalListPO po1=(ArrivalListPO)ois.readObject();
			arr.add(po1);
			while(fis.available()>0){
				byte[] buf=new byte[4];
				fis.read(buf);
//zyt				
//				po1=(ArrivalListPO)ois.readObject();
//				arr.add(po1);
//zyt			
//zwh
				ArrivalListPO arrivallistpo=(ArrivalListPO)ois.readObject();
				arr.add(arrivallistpo);
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

	public void update(ArrivalListPO po) throws RemoteException, IOException {
	
		delete(po);
		insert(po);
		
	}

	//zwh
	//这个方法要返回传入的maker的所有未通过审核的单据集合
	public ArrayList<ArrivalListPO> findall() throws RemoteException, IOException{
		fis=new FileInputStream(file);
		ois=new ObjectInputStream(fis); 
		ArrayList<ArrivalListPO> arr=new ArrayList<ArrivalListPO>();
					
		try{
			ArrivalListPO po=(ArrivalListPO)ois.readObject();
			arr.add(po);
			while(fis.available()>0){
				byte[] buf=new byte[4];
				fis.read(buf);
				ArrivalListPO arrivallistpo=(ArrivalListPO)ois.readObject();
				arr.add(arrivallistpo);
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
	
	public ArrayList<ArrivalListPO> findbymaker(String maker) throws RemoteException, IOException{	
		fis=new FileInputStream(file);
		ois=new ObjectInputStream(fis);	
		ArrayList<ArrivalListPO> arr=new ArrayList<ArrivalListPO>();	
	
		try{		
			ArrivalListPO po=(ArrivalListPO)ois.readObject();		
			while(fis.available()>0){			
				byte[] buf=new byte[4];			
				fis.read(buf);			
				po=(ArrivalListPO)ois.readObject();			
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
		ArrivalListPO po=new ArrivalListPO();
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
