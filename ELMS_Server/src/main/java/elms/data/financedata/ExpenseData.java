package elms.data.financedata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;






import elms.dataservice.financedataservice.ExpenseDataService;
import elms.po.FExpensePO;
import elms.po.FIncomePO;

public class ExpenseData extends UnicastRemoteObject implements ExpenseDataService{

	public ExpenseData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	File file = new File("Expense.ser");
	
	public FExpensePO find(String id) throws RemoteException, IOException {
		FExpensePO po = null;
		ObjectInputStream os = null;
		try{
			FileInputStream fs = new FileInputStream(file);
			os = new ObjectInputStream(fs);
			po = (FExpensePO)os.readObject();
			if(po.getID().equals(id)){
				os.close();
				System.out.println("find successfully!");
				return po;
			}else{
				do{
					byte[] buf = new byte[4];
					fs.read(buf);
					po = (FExpensePO) os.readObject();
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

	public ArrayList<FExpensePO> findByTime(String time1, String time2)
			throws RemoteException, IOException {
		ArrayList<FExpensePO> expense = new ArrayList<FExpensePO>();
		ObjectInputStream os = null;
		String btime = time1.substring(0, 4)+time1.substring(5, 7)+time1.substring(8, 10);
		String etime = time2.substring(0, 4)+time2.substring(5, 7)+time2.substring(8, 10);
		
		int begintime = Integer.parseInt(btime);
		int endtime = Integer.parseInt(etime);
	
		try{
			FileInputStream fs = new FileInputStream(file);
			os = new ObjectInputStream(fs);
			FExpensePO po = (FExpensePO)os.readObject();
		
			String t = po.getTime();
			String currentTime = t.substring(0, 4)+t.substring(5, 7)+t.substring(8, 10);
			int time = Integer.parseInt(currentTime);
		
			if(time>=begintime&&time<endtime){
				expense.add(po);
		
			}
			
			while(fs.available()>0){
				byte[] buf = new byte[4];
				fs.read(buf);
				FExpensePO expensepo = (FExpensePO) os.readObject();
				
				t = expensepo.getTime();
				currentTime = t.substring(0, 4)+t.substring(5, 7)+t.substring(8, 10);
				time = Integer.parseInt(currentTime);
	
				if(time>=begintime&&time<endtime){
					expense.add(expensepo);
				}
			}
			
			return expense;
		}catch(Exception e){
			return null;
		}
		finally{
			os.close();
		}
	}

	public void insert(FExpensePO po) throws RemoteException, IOException {
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

	public void delete(FExpensePO po) throws RemoteException {
		FExpensePO PO=null;
		ObjectInputStream ois=null;
		ArrayList<FExpensePO> arr=new ArrayList<FExpensePO>();
		try{
			FileInputStream fs =new FileInputStream(file);
			ois=new ObjectInputStream(fs);
			PO=(FExpensePO)ois.readObject();			System.out.println(PO.getID());
			arr.add(PO);
			while(true){
				byte[] buf=new byte[4];
				fs.read(buf);
				PO=(FExpensePO)ois.readObject();
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

	

	public void update(FExpensePO po) throws RemoteException {
		 delete(po);
		 try {
			insert(po);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	private void init() {
		file.delete();
		file = new File("E://GGS.DDU文档//11.19（2）//ELMS_Server//Expense.ser");
		
	}
	
}
