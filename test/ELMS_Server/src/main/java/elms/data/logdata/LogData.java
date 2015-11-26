package elms.data.logdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import elms.dataservice.logdataservice.LogDataService;
import elms.po.LogPO;
import elms.po.StoragePO;

public class LogData extends UnicastRemoteObject implements LogDataService{
	
	File file=new File("Log.ser");
	FileInputStream fis;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	
	public LogData() throws IOException {
		super();
		
	}

	
	public LogPO find(String id) throws IOException,RemoteException {
		fis=new FileInputStream(file);
		ois=new ObjectInputStream(fis);
		LogPO logpo=null;
		try{
			logpo=(LogPO)ois.readObject();
			while(fis.available()>0){
					byte[] buf=new byte[4];
					fis.read(buf);
					logpo=(LogPO)ois.readObject();
					if(logpo.getId().equals(id)){
					return logpo;						
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

	public ArrayList<LogPO> findAll() throws RemoteException, IOException {
		fis=new FileInputStream(file);
		ois=new ObjectInputStream(fis);
		ArrayList<LogPO>  ar=new ArrayList<LogPO>();
		LogPO logpo=null;
		try{
			logpo=(LogPO)ois.readObject();
			while(fis.available()>0){
					byte[] buf=new byte[4];
					fis.read(buf);
					logpo=(LogPO)ois.readObject();
				    ar.add(logpo);
			}
			return ar;
		}catch(Exception e){
			return ar;
		}
		finally{
			ois.close();
		} 
	}

	public ArrayList<LogPO> findbyID(String ID) throws IOException,RemoteException {
		fis=new FileInputStream(file);
		ois=new ObjectInputStream(fis);
		ArrayList<LogPO>  ar=new ArrayList<LogPO>();
		LogPO logpo=null;
		try{
			logpo=(LogPO)ois.readObject();
			while(fis.available()>0){
					byte[] buf=new byte[4];
					fis.read(buf);
					logpo=(LogPO)ois.readObject();
					if(logpo.getName().equals(ID))
				    ar.add(logpo);
			}
			return ar;
		}catch(Exception e){
			return ar;
		}
		finally{
			ois.close();
		} 
	}

	public void insert(LogPO po) throws IOException,RemoteException {
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

	public void init() throws RemoteException {
		file.delete();	
		LogPO po=new LogPO();
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
