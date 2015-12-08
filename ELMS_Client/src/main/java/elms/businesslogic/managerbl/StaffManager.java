package elms.businesslogic.managerbl;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;





import elms.businesslogic.ResultMessage;
import elms.businesslogic_service.managerblservice.StaffBlService;
import elms.dataservice.DataFactory;
import elms.dataservice.dealdataservice.DealDataService;
import elms.dataservice.financedataservice.BankAccountDataService;
import elms.dataservice.financedataservice.ExpenseDataService;
import elms.dataservice.financedataservice.IncomeDataService;
import elms.dataservice.financedataservice.InitAllDataService;
import elms.dataservice.invoicedataservice.ArrivalListDataService;
import elms.dataservice.invoicedataservice.IncomeListDataService;
import elms.dataservice.invoicedataservice.LoadingListDataService;
import elms.dataservice.invoicedataservice.LoadingListZZDataService;
import elms.dataservice.invoicedataservice.RecivalListDataService;
import elms.dataservice.invoicedataservice.SendingListDataService;
import elms.dataservice.invoicedataservice.TransferListDataService;
import elms.dataservice.logdataservice.LogDataService;
import elms.dataservice.managerdataservice.FreightStrategyDataService;
import elms.dataservice.managerdataservice.StaffDataService;
import elms.dataservice.memberdataservice.CarDataService;
import elms.dataservice.memberdataservice.DriverDataService;
import elms.dataservice.storagedataservice.StorageDataService;
import elms.dataservice.userdataservice.UserDataService;
import elms.po.StaffPO;
import elms.vo.StaffVO;

public class StaffManager implements StaffBlService, DataFactory {

	StaffDataService staffData;

	public StaffManager() {
		try {
			staffData = this.getStaffData();
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}


	public ResultMessage addStaff(StaffVO vo) {
		// TODO 自动生成的方法存根
		StaffPO po = getPO(vo);

		try {
			if (findStaff(vo.getID()) == null) {
				staffData.insert(po);
				return ResultMessage.Success;
			} else {
				return ResultMessage.findIDFailed; // 已存在对应id的职员
			}
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return ResultMessage.Failed;
		}
	}

	@Override
	public ResultMessage deleteStaff(StaffVO vo) {
		// TODO 自动生成的方法存根
		StaffPO po = getPO(vo);
		try {
			if (findStaff(vo.getID()) != null) {
				staffData.delete(po);
				return ResultMessage.Success;
			} else {
				return ResultMessage.findIDFailed; // 未找到对应职员
			}

		} catch (Exception e) {
			e.printStackTrace();
			return ResultMessage.Failed;
		}

	}

	@Override
	public StaffVO findStaff(String id) {
		// TODO 自动生成的方法存根
		StaffPO po = null;
		try {
			po = staffData.find(id);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

		if (po == null) {
			return null; // 未找到对应职员
		} else {
			StaffVO vo = getVO(po);
			return vo;

		}
	}

	@Override
	public ResultMessage updateStaff(StaffVO vo) {
		// TODO 自动生成的方法存根
		StaffPO po = getPO(vo);
		if (findStaff(vo.getID()) != null) {
			try {
				staffData.update(po);
				return ResultMessage.Success;
			} catch (RemoteException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
				return ResultMessage.Failed;
			}
		} else {
			return ResultMessage.findIDFailed;
		}

	}

	@Override
	public ArrayList<StaffVO> findByJob(String job) {
		// TODO 自动生成的方法存根
		ArrayList<StaffPO> all = new ArrayList<StaffPO>();
		ArrayList<StaffVO> arr = new ArrayList<StaffVO>();
		try {
			all = staffData.findall();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		if (all == null) {
			return null; // 职员清单为空
		} else {
			for (int i = 0; i < all.size(); i++) {
				StaffPO po = all.get(i);
				if(po.getJob().equals(job)){
					StaffVO vo = getVO(po);
					arr.add(vo);
				}
			}
			return arr;
		}
		
	}

	private StaffPO getPO(StaffVO vo) {
		StaffPO po = new StaffPO(vo.getID(), vo.getName(), vo.getAge(),
				vo.getGender(), vo.getIdCard(), vo.getAddress(),
				vo.getPhoneNum(), vo.getJob(), vo.getEssentialSalary(),
				vo.getSalaryStrategy(), vo.getOrganization());
		return po;
	}

	private StaffVO getVO(StaffPO po) {
		StaffVO vo = new StaffVO(po.getID(), po.getName(), po.getAge(),
				po.getGender(), po.getIdCard(), po.getAddress(),
				po.getPhoneNum(), po.getJob(), po.getEssentialSalary(),
				po.getSalaryStrategy(), po.getOrganization());
		return vo;
	}

	@Override
	public UserDataService getUserData() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public DealDataService getDealData() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public IncomeDataService getIncomeData() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ExpenseDataService getExpenseData() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public BankAccountDataService getBankAccountData() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public FreightStrategyDataService getFreightStrategyData()
			throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public InitAllDataService getInitData() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public StorageDataService getStorageData() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public StaffDataService getStaffData() throws RemoteException {
		// TODO 自动生成的方法存根
		DataFactory df;
		try {
			df = (DataFactory) Naming.lookup("rmi://localhost:1099/df");
			return df.getStaffData();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public LogDataService getLogData() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public ArrivalListDataService getArrivalListData() {
		// TODO 自动生成的方法存根
		return null;
	}

	public SendingListDataService getSendingListData() {
		// TODO 自动生成的方法存根
		return null;
	}

	public IncomeListDataService getIncomeListData() {
		// TODO 自动生成的方法存根
		return null;
	}

	public RecivalListDataService getRecivalListData() {
		// TODO 自动生成的方法存根
		return null;
	}

	public LoadingListDataService getLoadingListData() {
		// TODO 自动生成的方法存根
		return null;
	}

	public TransferListDataService getTransferListData() {
		// TODO 自动生成的方法存根
		return null;
	}

	public LoadingListZZDataService getLoadingListZZData() {
		// TODO 自动生成的方法存根
		return null;
	}

	public DriverDataService getDriverData() {
		// TODO 自动生成的方法存根
		return null;
	}

	public CarDataService getCarData() {
		// TODO 自动生成的方法存根
		return null;
	}

}
