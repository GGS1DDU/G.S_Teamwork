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

import elms.dataservice.invoicedataservice.TransferListDataService;
import elms.po.SendingListPO;
import elms.po.TransferListPO;

public class TransferListData extends UnicastRemoteObject implements TransferListDataService{

	private static final long serialVersionUID = 8223279783568994451L;
	File file=new File("TransferList.ser");
	FileInputStream fis;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	
	public TransferListData() throws RemoteException{
		super();
	}
    public static void main(String args[]) throws IOException{
    	TransferListData ii=new TransferListData();
    	ii.init();
    }
	//transferList中转单的id定义为tl开头+五位数字，一个七位id
	public TransferListPO find(String id) throws RemoteException, IOException {
		fis=new FileInputStream(file);
		ois=new ObjectInputStream(fis);
		TransferListPO transferListpo=null;
		try{
			transferListpo=(TransferListPO)ois.readObject();
			while(fis.available()>0){
				byte[] buf=new byte[4];
				fis.read(buf);
				transferListpo=(TransferListPO)ois.readObject();
				if(transferListpo.getID().equals(id)){
					return transferListpo;
				}
			}
			return null;
		}catch(Exception e){
			return null;
		}finally{
			ois.close();
		}
	}

	public void insert(TransferListPO po) throws RemoteException, IOException {
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

	public void delete(TransferListPO po) throws RemoteException, IOException {
		fis=new FileInputStream(file);
		ois=new ObjectInputStream(fis);
		ArrayList<TransferListPO> arr=new ArrayList<TransferListPO>();
		try{
			TransferListPO po1=(TransferListPO)ois.readObject();
			arr.add(po1);
			while(fis.available()>0){
				byte[] buf=new byte[4];
				fis.read(buf);
//zyt
//				po1=(TransferListPO)ois.readObject();
//				arr.add(po1);
//zyt
//zwh
				TransferListPO transferlistpo=(TransferListPO)ois.readObject();
				arr.add(transferlistpo);
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
			for(int i=1;i<arr.size();i++){
				insert(arr.get(i));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	public void update(TransferListPO po) throws RemoteException, IOException {
		delete(po);
		insert(po);		
	}

	//zwh
	//这个方法要返回传入的maker的所有未通过审核的单据集合
	public ArrayList<TransferListPO> findall() throws RemoteException, IOException{
		fis=new FileInputStream(file);
		ois=new ObjectInputStream(fis); 
		ArrayList<TransferListPO> arr=new ArrayList<TransferListPO>();
					
		try{
			TransferListPO po=(TransferListPO)ois.readObject();
			//arr.add(po);
			while(fis.available()>0){
				byte[] buf=new byte[4];
				fis.read(buf);
				TransferListPO transferlistpo=(TransferListPO)ois.readObject();
					arr.add(transferlistpo);
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
		//zwh
	
	public void init() throws RemoteException {
		file.delete();
		TransferListPO po=new TransferListPO();
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
