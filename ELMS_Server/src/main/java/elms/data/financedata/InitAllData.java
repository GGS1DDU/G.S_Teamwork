package elms.data.financedata;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;

import elms.dataservice.financedataservice.InitAllDataService;
import elms.po.AccountPO;
import elms.po.StoragePO;

public class InitAllData extends UnicastRemoteObject implements InitAllDataService{
   
    
   static  boolean initMember;
   static	boolean initStorage;
   static	boolean initAccount;
   static	boolean initCar;
    public InitAllData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}
   
    
    public static void main(String args[]) throws RemoteException{
	   InitAllData i=new InitAllData();
	   String time=""+new Date().toLocaleString();time=time.substring(0,4);
	    time="Version-"+time;
	   try {
		i.initAll(time);
	//i.recovery(time);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
	
	public void  initAll(String time) throws RemoteException,IOException, ClassNotFoundException {
/*
 * 需要补全
 */
		Path p1=Paths.get(time,time+" Storage.ser");
		Path p2=Paths.get("Storage.ser");
		Files.copy(p2,p1,StandardCopyOption.REPLACE_EXISTING);
		Path p3=Paths.get(time,time+" Car.ser");
		Path p4=Paths.get("Car.ser");
		Files.copy(p4,p3,StandardCopyOption.REPLACE_EXISTING);		
		setInitState();
		   //    在告知初始化前  现将现有的数据情况储存起来  然后设置初始化状态  告知初始化
	}

	public void copy(String time)  throws IOException, ClassNotFoundException{
		Path p1=Paths.get(time,"copy Storage.ser");
		Path p2=Paths.get("Storage.ser");
		Files.copy(p2,p1,StandardCopyOption.REPLACE_EXISTING);
		Path p3=Paths.get(time,"copy Car.ser");
		Path p4=Paths.get("Car.ser");
		Files.copy(p4,p3,StandardCopyOption.REPLACE_EXISTING);	
	}


	public void recovery(String time) throws IOException, ClassNotFoundException {
		Path p1=Paths.get(time,"copy Storage.ser");
		Path p2=Paths.get("Storage.ser");
		Files.copy(p1,p2,StandardCopyOption.REPLACE_EXISTING);
		
		Path p3=Paths.get(time,"copy Car.ser");
		Path p4=Paths.get("Car.ser");
		Files.copy(p3,p4,StandardCopyOption.REPLACE_EXISTING);	
	}


	public boolean getInitState(int a) throws RemoteException {
		switch(a){
		case 1: return initMember;
		case 2: return initCar;
		case 3: return initStorage;
		case 4: return initAccount;
		default : return false;
		}//  按照不同界面上返回的数值类型  来确定需要的值   然后确定是否进行初始化
	}

  /*
   *     File file=new File("buff.data");
    try {
         file.delete();
		FileOutputStream fos=new FileOutputStream(file,true);
		
	
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
   */
	public void setInitState() throws RemoteException {
		initCar=true;
		initMember=true;
		initStorage=true;
		initAccount=true;	
	}
	public void setInitState(int a) throws RemoteException {
		switch(a){
		case 1:{initMember=true;break;}
		case 2:{initCar=true;break;}
		case 3:{initStorage=true;break;}
		case 4:{initAccount=true;break;}
		default :{}
		}
	}
	
	
	public  void  addAccount(AccountPO po) throws IOException{
		File file=new File("Account.ser");
		FileOutputStream fos=new FileOutputStream(file,true);
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(po);
	    oos.close();
	}
	public ArrayList<AccountPO> getAccount() throws ClassNotFoundException, IOException{
		File file=new File("Account.ser");
		FileInputStream fis=new FileInputStream(file);
		ObjectInputStream ois=new ObjectInputStream(fis);
	    ArrayList<AccountPO> arr=new ArrayList<AccountPO>();
	    AccountPO accountpo=null;
	    accountpo=(AccountPO)ois.readObject();
	    while(fis.available()>0){
			byte[] buf =new byte[4];
			fis.read(buf);
			accountpo=(AccountPO)ois.readObject();
			arr.add(accountpo);
		}   
	    return arr;
	}
}
