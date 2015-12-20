package elms.data.managerdata;

/*
 * 默认第一个插入一个全为空的po
 */
//在界面层跳转出一个设置运费信息的窗口时，记得设置各个文本框中的默认值（coefficient）
import java.io.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import elms.dataservice.managerdataservice.FreightStrategyDataService;
import elms.po.FExpensePO;
import elms.po.FreightStrategyPO;
import elms.po.StaffPO;

public class FreightStrategyData extends UnicastRemoteObject implements FreightStrategyDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	File file = new File("FreightStrategy.ser");
	FreightStrategyPO po1 = new FreightStrategyPO("11","南京","南京",30.0,23,1000);
	FreightStrategyPO po2 = new FreightStrategyPO("12","南京","上海",266.0,23,1000);
	FreightStrategyPO po3 = new FreightStrategyPO("13","南京","广州",1132.0,23,1000);
	FreightStrategyPO po4 = new FreightStrategyPO("14","南京","北京",900.0,23,1000);
	FreightStrategyPO po5 = new FreightStrategyPO("22","上海","上海",30.0,23,1000);
	FreightStrategyPO po6 = new FreightStrategyPO("23","上海","广州",1213.0,23,1000);
	FreightStrategyPO po7 = new FreightStrategyPO("24","上海","北京",1064.7,23,1000);
	FreightStrategyPO po8 = new FreightStrategyPO("33","广州","广州",30.0,23,1000);
	FreightStrategyPO po9 = new FreightStrategyPO("34","广州","北京",1888.8,23,1000);
	FreightStrategyPO po10 = new FreightStrategyPO("44","北京","北京",30.0,23,1000);
	
	public FreightStrategyData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
		isEmpty();
	}

	
	
	public static void main(String[] args) throws IOException{
		FreightStrategyData fd = new FreightStrategyData();
//		FreightStrategyPO po = new FreightStrategyPO();
//		fd.insert(po);
//		FreightStrategyPO po1 = new FreightStrategyPO("13","南京","广州",200.0,
//				23, 1000);
//		fd.delete(po1);
//		System.out.println(fd.isEmpty());
//		fd.insert(po1);
//		FreightStrategyPO po2 = new FreightStrategyPO("00000001","南京","杭州",200.0,
//				15.7,14.3, 18.5, 1000);
		ArrayList<FreightStrategyPO> arr = fd.findAll();
		for(int i = 0; i < arr.size(); i++){
			System.out.println(arr.get(i).getID());
		}
//		fd.insert(po1);
//		fd.insert(po2);
//		fd.delete(po1);
	}
	
	public FreightStrategyPO find(String id) throws RemoteException, IOException {
		
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try{
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			
			FreightStrategyPO po = (FreightStrategyPO) ois.readObject();
			
			while(fis.available()>0){
				byte[] buf = new byte[4];
				fis.read(buf);
				po = (FreightStrategyPO) ois.readObject();
				if(po.getID().equals(id)){
					return po;
				}
			}
			System.out.println("can't find");
			return null;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Exception!");
			return null;
		}
		finally{
			ois.close();
		}
	}

	public void insert(FreightStrategyPO po) throws RemoteException {
		
		ObjectOutputStream os = null;
		
		try{
			FileOutputStream fs = new FileOutputStream(file,true);
			os = new ObjectOutputStream(fs);
			os.writeObject(po);
			os.close();
			System.out.println("insert successfully!");
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try {
				os.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		
	}

	public void delete(FreightStrategyPO po) throws RemoteException {
		FreightStrategyPO PO=null;
		ObjectInputStream ois=null;
		ArrayList<FreightStrategyPO> arr=new ArrayList<FreightStrategyPO>();
		try{
			FileInputStream fs =new FileInputStream(file);
			ois=new ObjectInputStream(fs);
			PO=(FreightStrategyPO)ois.readObject();			System.out.println(PO.getID());
//			arr.add(PO);
			while(true){
				byte[] buf=new byte[4];
				fs.read(buf);
				PO=(FreightStrategyPO)ois.readObject();
				System.out.println(PO.getID());
				arr.add(PO);
			}		
		}catch(Exception e){
			System.out.println("Expense扫描完毕");
		}
		finally{
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			finally{
		
			for(int i=0;i<arr.size();i++){
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
	}		
		
	}

	public void update(FreightStrategyPO po) throws RemoteException {
		delete(po);
		insert(po);
		
	}
	
//	private void DefaultFreight() throws RemoteException{
////		FreightStrategyPO po = new FreightStrategyPO("00","初始","初始",0.0,0,0);
//		FreightStrategyPO po = new FreightStrategyPO();
//		insert(po);
//	}

	public void init() throws RemoteException{
		
		file.delete();
//		file = new File("FreightStrategy.ser");
		FreightStrategyPO po = new FreightStrategyPO();
		insert(po);
	}
	
	private boolean isEmpty(){
		FileInputStream fis = null;
		try{
			fis = new FileInputStream(file);
			if(fis.available()<=0){
				FreightStrategyPO po = new FreightStrategyPO();
				insert(po);
				insert(po1);
				insert(po2);
				insert(po3);
				insert(po4);
				insert(po5);
				insert(po6);
				insert(po7);
				insert(po8);
				insert(po9);
				insert(po10);
				
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			return false;
		}
		finally{
			try {
				fis.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
	
	
	public ArrayList<FreightStrategyPO> findAll() throws RemoteException{
		FreightStrategyPO po = null;
		ObjectInputStream os = null;
		ArrayList<FreightStrategyPO> arr = new ArrayList<FreightStrategyPO>();
		try{
			FileInputStream fs = new FileInputStream(file);
			os = new ObjectInputStream(fs);
			po = (FreightStrategyPO)os.readObject();
//			if(po.getID().equals(id)){
//				os.close();
//				System.out.println("find successfully!");
//				return po;
//			}else{
				while(fs.available()>0){
					byte[] buf = new byte[4];
					fs.read(buf);
					po = (FreightStrategyPO) os.readObject();
					arr.add(po);
				}
//			}
			System.out.println("find successfully!");
			return arr;
		}catch(Exception e){
			return null;
		}
		finally{
			try {
				os.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}

	}
	
}
