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

import elms.dataservice.invoicedataservice.IncomeListDataService;
import elms.po.IncomeListPO;

public class IncomeListData extends UnicastRemoteObject implements IncomeListDataService{

	private static final long serialVersionUID = 848942304598014956L;
	File file=new File("IncomeList.ser");
	FileInputStream fis;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	
	public IncomeListData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}
    
	//incomeList收款单的id定义为il开头+五位数字，一个七位id
	public IncomeListPO find(String id) throws RemoteException, IOException {
		fis=new FileInputStream(file);
		ois=new ObjectInputStream(fis);
		IncomeListPO incomeListpo=null;
		try{
			incomeListpo=(IncomeListPO)ois.readObject();
			while(fis.available()>0){
				byte[] buf=new byte[4];
				fis.read(buf);
				incomeListpo=(IncomeListPO)ois.readObject();
				if(incomeListpo.getID().equals(id)){
					return incomeListpo;
				}
			}
			return null;
		}catch(Exception e){
			return null;
		}finally{
			ois.close();
		}
	}

	public void insert(IncomeListPO po) throws RemoteException, IOException {
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

	public void delete(IncomeListPO po) throws RemoteException, IOException {
		fis=new FileInputStream(file);
		ois=new ObjectInputStream(fis);
		ArrayList<IncomeListPO> arr=new ArrayList<IncomeListPO>();
		try{
			IncomeListPO po1=(IncomeListPO)ois.readObject();
			arr.add(po1);
			while(fis.available()>0){
				byte[] buf=new byte[4];
				fis.read(buf);
				po1=(IncomeListPO)ois.readObject();
				arr.add(po1);
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
			for(int i=0;i<arr.size();i++){
				insert(arr.get(i));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}

	public void update(IncomeListPO po) throws RemoteException, IOException {
		delete(po);
		insert(po);
		
	}

	public void init() throws RemoteException {
		file.delete();
		IncomeListPO po=new IncomeListPO();
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
