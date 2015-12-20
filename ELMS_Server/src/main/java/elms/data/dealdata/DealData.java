package elms.data.dealdata;

import java.io.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;










import elms.dataservice.dealdataservice.DealDataService;
import elms.po.DealPO;
/**
 * 
 * @author ZWH
 *
 */
public class DealData extends UnicastRemoteObject implements DealDataService {
	File file=new File("Deal.ser");
	FileInputStream fis;
	ObjectInputStream ois;
	ObjectOutputStream oos;

	public DealData() throws IOException  {
		super();
	}
	
/*	public static void main(String []args) throws Exception{
			DealData dd=new DealData();
			dd.init();
	
}   */
/*	public static void main(String [] args) throws Exception{
		DealData dd=new DealData();
		ArrayList<DealPO> arr=dd.findall();
		for(int i=0;i<arr.size();i++){
			System.out.println(arr.get(i).getOrderID());
		}
		
		
	}*/

	
	/**
	 * 根据ID返回一个DealPO
	 */
	public DealPO find(String id) throws RemoteException,IOException {
		fis=new FileInputStream(file);
		ois=new ObjectInputStream(fis);
		DealPO dealpo=null;
		try{
			dealpo=(DealPO)ois.readObject();
			while(fis.available()>0){
					byte[] buf=new byte[4];
					fis.read(buf);
					dealpo=(DealPO)ois.readObject();
					if(dealpo.getOrderID().equals(id)){
						return dealpo;
					}
			}
			return null;
			
		}
		catch(Exception e){
			return null;
		}
		finally{
			ois.close();
		} 
	}
	
	/**
	 * 返回所有DealPO
	 */
	public ArrayList<DealPO> findall() throws IOException{
		fis=new FileInputStream(file);
		ois=new ObjectInputStream(fis);
		ArrayList<DealPO> arr=new ArrayList<DealPO>();
		try{
			DealPO po=(DealPO)ois.readObject();
			arr.add(po);
			while(fis.available()>0){
				byte[] buf =new byte[4];
				fis.read(buf);
				DealPO dealpo=(DealPO)ois.readObject();
				arr.add(dealpo);
			}
			return arr;
		}catch(Exception e){
			return arr;
		}
		finally{
			try {
				ois.close();
			} catch (IOException e) {
			}
		}
		
	}

	public ArrayList<DealPO> findbyCourier(String courier, String dealtime) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<DealPO> findbyHall(String hall) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 新增一个DealPO
	 */
	public void insert(DealPO po) throws RemoteException ,IOException{
		try{
			FileOutputStream fs=new FileOutputStream(file,true);
			oos=new ObjectOutputStream(fs);
			oos.writeObject(po);
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			oos.close();
		}
		
		
	}
	/**
	 * 删除一个DealPO
	 */
	public void delete(DealPO po) throws RemoteException ,IOException{
		fis=new FileInputStream(file);
		ois=new ObjectInputStream(fis);
		ArrayList<DealPO> arr=new ArrayList<DealPO>();
		try{
			DealPO dealpo0=(DealPO)ois.readObject();
			arr.add(dealpo0);
			
			while(fis.available()>0){
				byte[] buf=new byte[4];
				fis.read(buf);
				DealPO dealpo=(DealPO)ois.readObject();
				arr.add(dealpo);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			ois.close();
		}
		
		for(int i=1;i<arr.size();i++){
			if(arr.get(i).getOrderID().equals(po.getOrderID())){
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

	/**
	 * 删除与传入DealPO的ID相同的po，再插入
	 */
	public void update(DealPO po) throws RemoteException,IOException {
		delete(po);
		insert(po);
		
		
	}
	/**
	 * 初始化
	 */
	public  void init() throws RemoteException {
		file.delete();	
		DealPO po=new DealPO();
		try {
			insert(po);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	

}