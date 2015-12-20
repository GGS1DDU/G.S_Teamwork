package elms.data.financedata;

import java.io.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;













import elms.dataservice.financedataservice.BankAccountDataService;
import elms.po.BankAccountPO;

public class BankAccountData extends UnicastRemoteObject implements BankAccountDataService{

	File file = new File("BankAccount.ser");
	
	public BankAccountData() throws RemoteException,IOException{
		super();
		
	}
	
	public static void main(String[] args) throws IOException{
		BankAccountData bad = new BankAccountData();
		BankAccountPO po1 = new BankAccountPO("ba00000001","zhang141250192", 0.0, "中国银行");
		BankAccountPO po2 = new BankAccountPO("ba00000002","zhang141250193", 200.0, "中国银行");
		BankAccountPO po3 = new BankAccountPO("ba00000003","zhang141250192", 0.0, "中国人民银行");
//		bad.insert(po3);
//		bad.insert(po2);
		BankAccountPO po = bad.find("ba00000001");
//		ArrayList<BankAccountPO> list = bad.findByBank("中国银行");
//		System.out.println(bad.isEmpty());
//		for(int i = 0; i < list.size(); i++){
//			BankAccountPO po = list.get(i);
			System.out.println(po.getID());
//		}
//		bad.delete("ba00000003");
//		bad.update(po2);
	}
	
	public BankAccountPO find(String id) throws RemoteException, IOException {
		BankAccountPO account = null;
		FileInputStream fs = null;
		ObjectInputStream os = null;
		try{
			fs = new FileInputStream(file);
			os = new ObjectInputStream(fs);
			account = (BankAccountPO) os.readObject();
	
//				if(account.getID().equals(id)){
//					System.out.println(account);
//					os.close();
//					return account;
//				}
			
			while(fs.available()>0){
				byte[] buf = new byte[4];
				fs.read(buf);
				account = (BankAccountPO) os.readObject();
				if(account.getID().equals(id))
					return account;
			}
			return null;
		}catch(Exception e){
			return null;
		}
		finally{
			os.close();
		}
	}

	public ArrayList<BankAccountPO> findByBank(String bankName)
			throws RemoteException, IOException {
		ArrayList<BankAccountPO> bankAccount = new ArrayList<BankAccountPO>();
		BankAccountPO account = null;
		FileInputStream fs = null;
		ObjectInputStream os = null;
		try{
			fs = new FileInputStream(file);
			os = new ObjectInputStream(fs);
			
			account = (BankAccountPO)os.readObject();
//			if(account.getBank().equals(bankName)){
//				bankAccount.add(account);
//			}
			while(fs.available()>0){
				byte[] buf = new byte[4];
				fs.read(buf);
				account = (BankAccountPO)os.readObject();
				if(account.getBank().equals(bankName)){
					bankAccount.add(account);
				}
			}
			return bankAccount;
		}catch(Exception e){
			return null;
		}
		finally{
			os.close();
		}
	}

	public boolean insert(BankAccountPO po) throws RemoteException, IOException {
		ObjectOutputStream oos=null;
		FileOutputStream fos = null;
		try {
			fos =new FileOutputStream(file,true);
			oos=new ObjectOutputStream(fos);
			oos.writeObject(po);
			oos.close();
			System.out.println("insert successfully!!");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		finally{
			
			oos.close();
		} 
	}

	public boolean delete(String accountID) throws RemoteException{
		BankAccountPO account = null;
		ArrayList<BankAccountPO> temp = new ArrayList<BankAccountPO>();
		ObjectInputStream os = null;
		FileInputStream fs = null;
		try{
			fs = new FileInputStream(file);
			os = new ObjectInputStream(fs);
			
			account = (BankAccountPO) os.readObject();
			
			while(fs.available()>0){
				byte[] buf = new byte[4];
				fs.read(buf);
				account =(BankAccountPO) os.readObject();
				temp.add(account);
			}
			
		}catch(Exception e){
			System.out.println("not found");
			e.printStackTrace();
		}
		finally{
			try {
				os.close();   //读完之后要记得把流关掉
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			boolean isdelete = false;
			for(int i = 0; i < temp.size(); i++){
				BankAccountPO ap = temp.get(i);
				if(ap.getID().equals(accountID)){
					temp.remove(i);
					isdelete = true;
					break;
				}
			}
			if(!isdelete){
				System.out.println("can't find such bank account !");
				return false;
			}
			try{
			init();
			for(int i = 0; i < temp.size(); i++){
				insert(temp.get(i));
			}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return true;
	}

	public boolean update(BankAccountPO po) throws RemoteException{
		delete(po.getID());
		try {
			insert(po);
			return true;
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return false;
		}
		
		
	}

	public void init() throws RemoteException{
		file.delete();
		
		BankAccountPO po = new BankAccountPO();
		try {
			insert(po);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}

	public ArrayList<BankAccountPO> findAll() throws IOException {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		ArrayList<BankAccountPO> accountList = new ArrayList<BankAccountPO>();
		
		try{
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			
			BankAccountPO po = (BankAccountPO) ois.readObject();
//			if(po.getName()!=null)
//				accountList.add(po);
			
			while(fis.available()>0){
				byte[] buf = new byte[4];
				fis.read(buf);
				po = (BankAccountPO) ois.readObject();
				accountList.add(po);
			}
			return accountList;
		}catch(Exception e){
			return null;
		}
		finally{
			ois.close();
		}
	}

	public boolean isEmpty() throws IOException {
		FileInputStream fis = null;
		try{
			fis = new FileInputStream(file);
			if(fis.available()<=0){
				BankAccountPO po = new BankAccountPO();
				insert(po);
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			fis.close();
		}
		return false;
	}

	
}
