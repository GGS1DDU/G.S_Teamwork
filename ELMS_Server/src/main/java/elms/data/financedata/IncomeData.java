package elms.data.financedata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.io.*;

import elms.dataservice.financedataservice.IncomeDataService;
import elms.po.FIncomePO;


public class IncomeData extends UnicastRemoteObject implements IncomeDataService{
	
	File file = new File("Income.ser");
	
	public IncomeData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}
	
//	public static void main(String [] args) throws Exception{
//		IncomeData income = new IncomeData();
//		FIncomePO po1 = new FIncomePO("zhang141250192","in00000001","2015-01-01",200.0,
//				"南京市鼓楼营业厅","张文玘");
//		FIncomePO po2 = new FIncomePO("中国银行","in00000002","2015-02-01",200.0,
//				"南京市仙林营业厅","周颖婷");
//		FIncomePO po3 = new FIncomePO("中国银行","in00000003","2015-01-01",200.0,
//				"南京市仙林营业厅","周颖婷");
//		FIncomePO po4 = new FIncomePO("中国银行","in00000003","2015-01-01",200.0,
//				"南京市仙林营业厅","郑闻昊");
//		income.insert(po1);
//		income.insert(po2);
//		income.insert(po3);
//		income.insert(po1);
//		income.delete(po1);
//		income.update(po4);
//		FIncomePO po = income.find("in00000002");
//		ArrayList<FIncomePO> incomeList = income.findbyHall("南京市仙林营业厅");
//		for(int i = 0; i < incomeList.size(); i++){
//			System.out.println(incomeList.get(i).getID());
//		}
//		ArrayList<FIncomePO> incomeList = income.findByTime("2015-01-01","2015-01-31");
//		for(int i = 0; i < incomeList.size(); i++){
//			System.out.println(incomeList.get(i).getTime());
//		}
//		ArrayList<FIncomePO> incomeList = income.findHallTime("2015-01-01","2015-01-31",
//				"南京市仙林营业厅");
//		for(int i = 0; i < incomeList.size(); i++){
//			System.out.println(incomeList.get(i).getID());
//		}
//		System.out.println(po.getClerk());
//		fdc.deleteIncome(po1);
//	}
	
	public  void insert(FIncomePO po) throws RemoteException, IOException  {
		ObjectOutputStream oos=null;
		try {
			FileOutputStream fs=new FileOutputStream(file,true);
			oos=new ObjectOutputStream(fs);
			oos.writeObject(po);
			oos.close();
			System.out.println("insert successfully!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			oos.close();
		} 
	}
	
	public void delete(FIncomePO po) throws RemoteException {
		FIncomePO PO=null;
		ObjectInputStream ois=null;
		ArrayList<FIncomePO> arr=new ArrayList<FIncomePO>();
		try{
			FileInputStream fs =new FileInputStream(file);
			ois=new ObjectInputStream(fs);
			PO=(FIncomePO)ois.readObject();			System.out.println(PO.getID());
			arr.add(PO);
			while(true){
				byte[] buf=new byte[4];
				fs.read(buf);
				PO=(FIncomePO)ois.readObject();
				System.out.println(PO.getID());
				arr.add(PO);
			}		
		}catch(Exception e){
			System.out.println("Income扫描完毕");
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
	
	public void update(FIncomePO po) throws RemoteException {
		 delete(po);
		 try {
			insert(po);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
	
	public FIncomePO find(String id) throws RemoteException, IOException {
		FIncomePO po = null;
		ObjectInputStream os = null;
		try{
			FileInputStream fs = new FileInputStream(file);
			os = new ObjectInputStream(fs);
			po = (FIncomePO)os.readObject();
			if(po.getID().equals(id)){
				os.close();
				System.out.println("find successfully!");
				return po;
			}else{
				do{
					byte[] buf = new byte[4];
					fs.read(buf);
					po = (FIncomePO) os.readObject();
				}while(!(po.getID().equals(id)));
			}
			System.out.println("find successfully!");
			return po;
		}catch(Exception e){
			return null;
		}
		finally{
			os.close();
		}
	}

	
	public ArrayList<FIncomePO> findbyHall(String hall) throws RemoteException, IOException {
		ArrayList<FIncomePO> income = new ArrayList<FIncomePO>();
		ObjectInputStream os = null;
		System.out.println("start find!");
		try{
			FileInputStream fs = new FileInputStream(file);
			os = new ObjectInputStream(fs);
			FIncomePO po = (FIncomePO)os.readObject();
			
			if(po.getShop().equals(hall))
				income.add(po);
			
			while(fs.available()>0){
				byte[] buf = new byte[4];
				fs.read(buf);
				FIncomePO incomepo = (FIncomePO) os.readObject();
				
				if(incomepo.getShop().equals(hall)){
					income.add(incomepo);
				}
			}
			
			return income;
		}catch(Exception e){
			return null;
		}
		finally{
			os.close();
		}
		
	}

	public ArrayList<FIncomePO> findByTime(String time1, String time2)
			throws RemoteException, IOException {
		ArrayList<FIncomePO> income = new ArrayList<FIncomePO>();
		ObjectInputStream os = null;
		String btime = time1.substring(0, 4)+time1.substring(5, 7)+time1.substring(8, 10);
		String etime = time2.substring(0, 4)+time2.substring(5, 7)+time2.substring(8, 10);
		
		int begintime = Integer.parseInt(btime);
		int endtime = Integer.parseInt(etime);
	
		try{
			FileInputStream fs = new FileInputStream(file);
			os = new ObjectInputStream(fs);
			FIncomePO po = (FIncomePO)os.readObject();
		
			String t = po.getTime();
			String currentTime = t.substring(0, 4)+t.substring(5, 7)+t.substring(8, 10);
			int time = Integer.parseInt(currentTime);
		
			if(time>=begintime&&time<endtime){
				income.add(po);
		
			}
			
			while(fs.available()>0){
				byte[] buf = new byte[4];
				fs.read(buf);
				FIncomePO incomepo = (FIncomePO) os.readObject();
				
				t = incomepo.getTime();
				currentTime = t.substring(0, 4)+t.substring(5, 7)+t.substring(8, 10);
				time = Integer.parseInt(currentTime);
	
				if(time>=begintime&&time<endtime){
					income.add(incomepo);
				}
			}
			
			return income;
		}catch(Exception e){
			return null;
		}
		finally{
			os.close();
		}
	}

	public ArrayList<FIncomePO> findHallTime(String time1, String time2,
			String hall) throws RemoteException, IOException {
		ArrayList<FIncomePO> timeList = this.findByTime(time1,time2);
		ArrayList<FIncomePO> result = new ArrayList<FIncomePO>();
		
		for(int i = 0; i < timeList.size(); i++){
			FIncomePO po = timeList.get(i);
			if(po.getShop().equals(hall))
				result.add(po);
		}
		
		return result;
	}
	
	public void init() throws RemoteException{
		file.delete();
		file = new File("Income.ser");
	}

	public boolean isEmpty() throws RemoteException {
		FileInputStream fis = null;
		try{
			fis = new FileInputStream(file);
			if(fis.available()<=0){
				return true;
			}
		}catch(Exception e){
			
		}
		finally{
			try {
				fis.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		return false;
	}
}
