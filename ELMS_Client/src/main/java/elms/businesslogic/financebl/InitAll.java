package elms.businesslogic.financebl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;

import elms.businesslogic_service.financeblservice.InitAllBlService;
import elms.dataservice.DataFactory;
import elms.dataservice.dealdataservice.DealDataService;
import elms.dataservice.financedataservice.BankAccountDataService;
import elms.dataservice.financedataservice.ExpenseDataService;
import elms.dataservice.financedataservice.IncomeDataService;
import elms.dataservice.financedataservice.InitAllDataService;
import elms.dataservice.logdataservice.LogDataService;
import elms.dataservice.managerdataservice.FreightStrategyDataService;
import elms.dataservice.managerdataservice.StaffDataService;
import elms.dataservice.storagedataservice.StorageDataService;
import elms.dataservice.userdataservice.UserDataService;
import elms.po.AccountPO;
import elms.vo.AccountVO;

public class InitAll implements DataFactory,InitAllBlService {
InitAllDataService initall;

public InitAll(){
	try {
		initall=getInitData();
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	public void init(String s) throws RemoteException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		initall.initAll(s);
	}

	public void copy(String s) throws RemoteException, FileNotFoundException, ClassNotFoundException, IOException {
		initall.copy(s);
	}

	public void recovery(String s) throws FileNotFoundException, ClassNotFoundException, IOException{
	    initall.recovery(s);
		
	}

	public boolean getInitState(int a) throws RemoteException{
		return initall.getInitState(a);
	}

	public void setInitState() {
		try {
			initall.setInitState();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void addAccount(AccountVO vo) {
		AccountPO po=new AccountPO(vo.getName(),vo.getOperator(),vo.getDate());
		try {
			initall.addAccount(po);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<AccountVO> getAccount() throws ClassNotFoundException, IOException {
		ArrayList<AccountPO> arr=initall.getAccount();
		ArrayList<AccountVO> newarr=new ArrayList<AccountVO>();
		for(AccountPO po:arr){
			AccountVO vo=new AccountVO(po.getName(),po.getOperator(),po.getDate());
			newarr.add(vo);
		}
		return newarr;
	}

	
	
	
	
	
	public UserDataService getUserData() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public DealDataService getDealData() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public LogDataService getLogData() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public StorageDataService getStorageData() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public IncomeDataService getIncomeData() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ExpenseDataService getExpenseData() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public BankAccountDataService getBankAccountData() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public FreightStrategyDataService getFreightStrategyData()
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public InitAllDataService getInitData() throws RemoteException {
		DataFactory df;
		try{
			df=(DataFactory)Naming.lookup("rmi://192.168.191.1:1099/df");
			return df.getInitData();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	public void copy() throws RemoteException, FileNotFoundException,
			ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		
	}
	public void recovery() throws RemoteException, FileNotFoundException,
			ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		
	}

	public StaffDataService getStaffData() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}


	
}
