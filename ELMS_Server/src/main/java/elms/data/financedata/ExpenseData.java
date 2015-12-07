package elms.data.financedata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.ArrayList;







import java.util.Date;

import elms.dataservice.financedataservice.ExpenseDataService;
import elms.po.FExpensePO;
import elms.po.FIncomePO;

public class ExpenseData extends UnicastRemoteObject implements ExpenseDataService{

	public ExpenseData() throws RemoteException {
		super();
		isEmpty();
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
			
				do{
					byte[] buf = new byte[4];
					fs.read(buf);
					po = (FExpensePO) os.readObject();
				}while(!(po.getID().equals(id)));
			
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
		
		SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
		
		try{
			FileInputStream fs = new FileInputStream(file);
			os = new ObjectInputStream(fs);
			FExpensePO po = (FExpensePO)os.readObject();
		
			Date date1 = formatter.parse(time1);
			Date date2 =formatter.parse(time2);
			
			while(fs.available()>0){
				byte[] buf = new byte[4];
				fs.read(buf);
				FExpensePO expensepo = (FExpensePO) os.readObject();
				
				if(formatter.parse(expensepo.getTime()).after(date1)&&formatter.parse(expensepo.getTime()).before(date2)){ 
					
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

	public ArrayList<FExpensePO> findAll() throws RemoteException{
		ArrayList<FExpensePO> expense = new ArrayList<FExpensePO>();
		ObjectInputStream os = null;
		try{
			FileInputStream fs = new FileInputStream(file);
			os = new ObjectInputStream(fs);
			FExpensePO po = (FExpensePO)os.readObject();
			
			while(fs.available()>0){
				byte[] buf = new byte[4];
				fs.read(buf);
				FExpensePO expensepo = (FExpensePO) os.readObject();
				expense.add(expensepo);
			}
			
			return expense;
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
			PO=(FExpensePO)ois.readObject();			
			
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

	public void init() {
		file.delete();
		FExpensePO po = new FExpensePO();
		try {
			insert(po);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
	
	public boolean isEmpty(){
		FileInputStream fis = null;
		
		try{
			fis = new FileInputStream(file);
			if(fis.available()<=0){
				FExpensePO po = new FExpensePO();
				insert(po);
				return true;
				
			}
		}catch(Exception e){
			e.printStackTrace();
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
