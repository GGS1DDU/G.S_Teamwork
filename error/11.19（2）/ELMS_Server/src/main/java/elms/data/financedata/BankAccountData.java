package elms.data.financedata;

import java.io.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;








import elms.dataservice.financeDataService.FBankAccountDataService;
import elms.po.BankAccountPO;

public class BankAccountData extends UnicastRemoteObject implements FBankAccountDataService{

	File file = new File("BankAccount.ser");
	
	public BankAccountData() throws RemoteException{
		super();
	}
	
//	public static void main(String[] args) throws IOException{
//		BankAccountData bad = new BankAccountData();
//		BankAccountPO po1 = new BankAccountPO("ba00000001","zhang141250192", 0.0, "中国银行");
//		BankAccountPO po2 = new BankAccountPO("ba00000002","zhang141250193", 200.0, "中国银行");
//		BankAccountPO po3 = new BankAccountPO("ba00000003","zhang141250192", 0.0, "中国人民银行");
//		bad.insert(po3);
//		bad.insert(po1);
//		BankAccountPO po = bad.find("ba00000002");
//		ArrayList<BankAccountPO> list = bad.findByBank("中国人民银行");
//		for(int i = 0; i < list.size(); i++){
//			BankAccountPO po = list.get(i);
//			System.out.println(po.getAccountID());
//		}
//		bad.delete("ba00000002");
//		bad.update(po2);
//	}
	
	public BankAccountPO find(String id) throws RemoteException, IOException {
		BankAccountPO account = null;
		FileInputStream fs = null;
		ObjectInputStream os = null;
		try{
			fs = new FileInputStream(file);
			os = new ObjectInputStream(fs);
			account = (BankAccountPO) os.readObject();
			if(account.getAccountID().equals(id)){
				return account;
			}else{
				do{
					byte[] buf = new byte[4];
					fs.read(buf);
					account = (BankAccountPO)os.readObject();
				}while(!(account.getAccountID().equals(id)));
			}
			return account;
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
			if(account.getBankName().equals(bankName)){
				bankAccount.add(account);
			}
			
			while(fs.available()>0){
				byte[] buf = new byte[4];
				fs.read(buf);
				account = (BankAccountPO)os.readObject();
				if(account.getBankName().equals(bankName)){
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

	public void insert(BankAccountPO po) throws RemoteException, IOException {
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

	public void delete(String accountID) throws RemoteException{
		BankAccountPO account = null;
		ArrayList<BankAccountPO> temp = new ArrayList<BankAccountPO>();
		ObjectInputStream os = null;
		FileInputStream fs = null;
		try{
			fs = new FileInputStream(file);
			os = new ObjectInputStream(fs);
			
			account = (BankAccountPO) os.readObject();
			temp.add(account);
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
			for(int i = 0; i < temp.size(); i++){
				BankAccountPO ap = temp.get(i);
				if(ap.getAccountID().equals(accountID)){
					temp.remove(i);
					break;
				}
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
		
	}

	public void update(BankAccountPO po) throws RemoteException{
		delete(po.getAccountID());
		try {
			insert(po);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		
	}

	public void init() throws RemoteException{
		file.delete();
		System.out.println("delete file!");
		file = new File("E://GGS.DDU文档//11.19（2）//ELMS_Server//BankAccount.ser");
		
	}

	
}
