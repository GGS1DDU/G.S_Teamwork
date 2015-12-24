package elms.data.memberdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import elms.dataservice.memberdataservice.CarDataService;
import elms.po.CarPO;

public class CarData extends UnicastRemoteObject implements CarDataService{

	private static final long serialVersionUID = -4350548559000877352L;
	File file=new File("Car.ser");
	FileInputStream fis;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	
	public CarData() throws RemoteException{
		super();
	}

	public CarPO find(String id) throws RemoteException, IOException {
		fis=new FileInputStream(file);
		ois=new ObjectInputStream(fis);
		CarPO carpo=null;
		try{
			carpo=(CarPO)ois.readObject();
			while(fis.available()>0){
				byte[] buf=new byte[4];
				fis.read(buf);
				carpo=(CarPO)ois.readObject();
				if(carpo.getID().equals(id)){
					return carpo;
				}
			}
			return null;
		}catch(Exception e){
			return null;
		}finally{
			ois.close();
		}
	}

	public void insert(CarPO po) throws RemoteException, IOException {
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

	public void delete(CarPO po) throws RemoteException, IOException {
		fis=new FileInputStream(file);
		ois=new ObjectInputStream(fis);
		ArrayList<CarPO> arr=new ArrayList<CarPO>();
		try{
			CarPO po1=(CarPO)ois.readObject();
			arr.add(po1);
			while(fis.available()>0){
				byte[] buf=new byte[4];
				fis.read(buf);
//zyt
//				po1=(CarPO)ois.readObject();
//				arr.add(po1);
//zyt
//zwh
				CarPO carpo=(CarPO)ois.readObject();
				arr.add(carpo);
//zwh				
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

	public void update(CarPO po) throws RemoteException, IOException {
		delete(po);
		insert(po);
		
	}
	
	public ArrayList<CarPO> findall() throws RemoteException, IOException{
		fis=new FileInputStream(file);
		ois=new ObjectInputStream(fis); 
		ArrayList<CarPO> arr=new ArrayList<CarPO>();
					
		try{
			CarPO po=(CarPO)ois.readObject();
			arr.add(po);
			while(fis.available()>0){
				byte[] buf=new byte[4];
				fis.read(buf);
				CarPO carpo=(CarPO)ois.readObject();
					arr.add(carpo);
			}
			return arr;
		}catch(Exception e){
			return arr;
		}
		finally{
			try{
				ois.close();
			}catch(Exception e){
						
			}
		}				
	}

	public void init() throws RemoteException {
		file.delete();
		CarPO po=new CarPO();
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
