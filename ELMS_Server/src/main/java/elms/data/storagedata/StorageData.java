package elms.data.storagedata;

import java.io.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import elms.dataservice.storagedataservice.StorageDataService;
import elms.po.StoragePO;

public class StorageData extends UnicastRemoteObject implements StorageDataService{
	static File file=new File("Storage.ser");
	FileInputStream fis;
	ObjectInputStream ois;
	ObjectOutputStream oos;
 static ArrayList<String>  ins=new ArrayList<String>();
 static ArrayList<String>  outs=new ArrayList<String>();
public StorageData() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
//public static void main(String args[]) throws IOException, ClassNotFoundException, ParseException{
//	StorageData s=new StorageData();
//	s.setIn("14225");
//	s.setIn("12451");
//	s.getIn(0);
//	
//////		File f=new File("Version-2015");
//////		f.mkdirs();
//////	 file=new File("Storage.ser");
////	StorageData data=new StorageData();ArrayList<StoragePO> aer=new ArrayList<StoragePO>();
//////		data.init();
//////		data.insert(new StoragePO("0000000001", "R2D3L5", "航运区", "000125", "2015-02-14 14:32:10", null,"IN", "南京"));
//////		data.insert(new StoragePO("0000000002", "R2D3L4", "航运区", "000127", "2015-02-14 14:32:10", "2015-02-16 14:32:10","OUT", "南京"));
//////		data.insert(new StoragePO("0000000003", "R2D3L7", "航运区", "000127", "2015-02-14 14:32:10", "2015-02-16 14:32:10","OUT", "北京"));
//////		data.insert(new StoragePO("0000000004", "R2D3L1", "航运区", "000125", "2015-02-14 14:32:10", null,"IN", "南京"));
//////		data.insert(new StoragePO("0000000005", "R2D3L2", "航运区", "000125", "2015-02-14 14:32:10", null,"BROKEN", "南京"));
////		aer=data.findbytime("2015-01-01 11:10:02", "2015-01-01 11:10:02", "南京");
////		for(int i=0;i<aer.size();i++) System.out.println(aer.get(i).getId());
//	}
		public ArrayList<String> getallin() throws RemoteException,IOException{
			return ins;
		}
		public ArrayList<String> getallout() throws RemoteException,IOException{
			return outs;
		}
	  public void setIn(String s) throws RemoteException,IOException  {
		ins.add(s);
	}

	public void setOut(String s) throws RemoteException ,IOException {
		outs.add(s);
	}
	  public void getIn(int s) throws RemoteException,IOException  {
		ins.remove(s);
	}

	public void getOut(int s) throws RemoteException ,IOException {
		outs.remove(s);
	}
	public StoragePO find(String id) throws IOException,RemoteException {
		fis=new FileInputStream(file);
		ois=new ObjectInputStream(fis);
		StoragePO storagepo=null;
		try{
			storagepo=(StoragePO)ois.readObject();
			while(fis.available()>0){
					byte[] buf=new byte[4];
					fis.read(buf);
					storagepo=(StoragePO)ois.readObject();
					if(storagepo.getOrder().equals(id)){
					return storagepo;						
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

	public ArrayList<StoragePO> findall(String center) throws IOException,RemoteException{
		fis=new FileInputStream(file);
		ois=new ObjectInputStream(fis);
		ArrayList<StoragePO> arr=new ArrayList<StoragePO>();
		try{
			StoragePO po=(StoragePO)ois.readObject();
			while(fis.available()>0){
				byte[] buf =new byte[4];
				fis.read(buf);
				po=(StoragePO)ois.readObject();
				if(po.getName().equals(center))
				arr.add(po);
			}
			return arr;
		}catch(Exception e){
			return arr;
		}
		finally{
				ois.close();
			}
		}
		
	

	public ArrayList<StoragePO> findbytime(String time1, String time2,
			String center) throws RemoteException,IOException, ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
		Date date1 =formatter.parse(time1);
		Date date2 =formatter.parse(time2);
		fis=new FileInputStream(file);
		ois=new ObjectInputStream(fis);
		ArrayList<StoragePO> arrin=new ArrayList<StoragePO>();
		ArrayList<StoragePO> arrout=new ArrayList<StoragePO>();
		ArrayList<StoragePO> arr=new ArrayList<StoragePO>();
		try{
			StoragePO po=(StoragePO)ois.readObject();
			while(fis.available()>0){
				byte[] buf =new byte[4];
				fis.read(buf);
				po=(StoragePO)ois.readObject();
	            if(po.getName().equals(center)){				
				if(formatter.parse(po.getTimeIn()).after(date1)) arrin.add(po);
				if(po.getState().equals("OUT")&&formatter.parse(po.getTimeOut()).before(date2)) arrout.add(po);}
			}
			
			arr.add(new StoragePO("---------------这段时间内入库的-----------------","", "", "", "", "", "",""));
		  arr.addAll(arrin);
		   	arr.add(new StoragePO("---------------这段时间内出库的-----------------","", "", "", "", "", "",""));
		  arr.addAll(arrout);
			return arr;
		}catch(Exception e){
			return arr;
		}
		finally{
				ois.close();
			}
		
	}

	public void insert(StoragePO po) throws IOException,RemoteException {
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

	public void delete(StoragePO po) throws RemoteException,IOException {	
	fis=new FileInputStream(file);
	ois=new ObjectInputStream(fis);
	ArrayList<StoragePO> arr=new ArrayList<StoragePO>();
	try{
		StoragePO po1=(StoragePO)ois.readObject();
		arr.add(po1);
		while(fis.available()>0){
			byte[] buf=new byte[4];
			fis.read(buf);
			po1=(StoragePO)ois.readObject();
			arr.add(po1);
		}
	}catch(Exception e){
		e.printStackTrace();
	}
	finally{
		ois.close();
	}
	
	for(int i=1;i<arr.size();i++){
		if(arr.get(i).getOrder().equals(po.getOrder())){
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

	public void update(StoragePO po) throws IOException,RemoteException {
		delete(po);
		insert(po);
		
	}

	public void init() throws RemoteException {
		file.delete();	
		StoragePO po=new StoragePO();
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
