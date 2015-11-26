package elms.data.financedata;

//在界面层跳转出一个设置运费信息的窗口时，记得设置各个文本框中的默认值（coefficient）
import java.io.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import elms.dataservice.financeDataService.FStrategyDataService;
import elms.po.FreightStrategyPO;

public class FreightStrategyData extends UnicastRemoteObject implements FStrategyDataService{

	public FreightStrategyData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	File file = new File("FreightStrategy.ser");
	
//	public static void main(String[] args) throws RemoteException{
//		FreightStrategyData fd = new FreightStrategyData();
//		FreightStrategyPO po1 = new FreightStrategyPO("00000001","南京","上海",200.0,
//				15.7,14.3, 18.5, 1000);
//		FreightStrategyPO po2 = new FreightStrategyPO("00000001","南京","杭州",200.0,
//				15.7,14.3, 18.5, 1000);
////		fd.insert(po1);
////		fd.insert(po2);
//		fd.delete(po1);
//	}
	
	public FreightStrategyPO find(String id) throws RemoteException, IOException {
		FileInputStream fs = null;
		ObjectInputStream os = null;
		FreightStrategyPO po = null;
		
		try{
			fs = new FileInputStream(file);
			os = new ObjectInputStream(fs);
			
			po = (FreightStrategyPO)os.readObject();
			if(po.getID().equals(id)){
				return po;
			}else{
				do{
				byte[] buf = new byte[4];
				fs.read(buf);
				po = (FreightStrategyPO) os.readObject();
				
				}while(!(po.getID().equals(id)));
			}
			return po;
		}catch(Exception e){
			return null;
		}
		finally{
			os.close();
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
			arr.add(PO);
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

	public void init() throws RemoteException{
		
		file.delete();
		file = new File("E://GGS.DDU文档//11.19（2）//ELMS_Server//FreightStrategy.ser");
//		insert(po);
		
	}
	
}
