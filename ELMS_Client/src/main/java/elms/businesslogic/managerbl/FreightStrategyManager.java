package elms.businesslogic.managerbl;
//id:1.南京  2.上海  3.广州   4.北京
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.RemoteException;




import java.util.ArrayList;

import elms.businesslogic.ResultMessage;
import elms.businesslogic_service.managerblservice.FreightStrategyBlService;
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

import elms.dataservice.managerdataservice.FreightStrategyDataService;
import elms.dataservice.managerdataservice.StaffDataService;
import elms.dataservice.memberdataservice.CarDataService;
import elms.dataservice.memberdataservice.DriverDataService;
import elms.dataservice.storagedataservice.StorageDataService;
import elms.dataservice.userdataservice.UserDataService;
import elms.po.FreightStrategyPO;
import elms.vo.FreightStrategyVO;

public class FreightStrategyManager implements FreightStrategyBlService,DataFactory{

	FreightStrategyDataService fsds;
	String id;
	
	public static void main(String[] args) throws IOException{
		FreightStrategyManager fsm = new FreightStrategyManager();
		
		FreightStrategyVO vo1 = new FreightStrategyVO("00","南京","上海",200.0,23,1000);
		System.out.println(fsm.deleteFreight(vo1));
//		FreightStrategyVO vo = fsm.getFreightStrategy("12");
		
//		System.out.println("id:"+vo.getID()+" city1:"+vo.getCity1()+" city2:"+vo.getCity2()
//				+" distance:"+vo.getDistance()+" price:"+vo.getStandardPrice()+" coefficient:"
//				+vo.getCoefficient());
	}

	public FreightStrategyManager(){
		fsds = getFreightStrategyData();
	}
	
	
	//每次新建运费策略时界面上自定义显示的内容
	public FreightStrategyVO initFreight() {
		// TODO 自动生成的方法存根
		FreightStrategyVO vo = new FreightStrategyVO("12","南京","上海",100.0,23,1000);
		return vo;
	}

	
	public FreightStrategyVO getFreightStrategy(String id) {
		// TODO 自动生成的方法存根
		FreightStrategyVO vo;
		try {
			FreightStrategyPO po = fsds.find(id);
			
			if(po==null)
				return null;
			vo = new FreightStrategyVO(po.getID(),po.getCity1(),po.getCity2(),
					po.getDistance(),po.getStandardPrice(),po.getCoefficient());	
			return vo;
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return null;
		} 
	}
	
	private FreightStrategyPO VOtoPO(FreightStrategyVO vo){
		FreightStrategyPO po = new FreightStrategyPO(vo.getID(),vo.getCity1(),vo.getCity2(),vo.getDistance(),
				vo.getStandardPrice(),vo.getCoefficient());
		return po;
	}
	private FreightStrategyVO POtoVO(FreightStrategyPO po){
		FreightStrategyVO vo = new FreightStrategyVO(po.getID(),po.getCity1(),po.getCity2(),po.getDistance(),
				po.getStandardPrice(),po.getCoefficient());
		return vo;
	}
	public double getDistance(String city1,String city2){
		
		String id = getID(city1,city2);
		FreightStrategyVO vo = getFreightStrategy(id);
		return vo.getDistance();
	}
	
	public int getPrice(String city1,String city2){
		 
		
		String id = getID(city1,city2);
		FreightStrategyVO vo = getFreightStrategy(id);
		return vo.getStandardPrice();
	}
	
	//
	public String getID(String city1,String city2){
		int num1 = getSpecialNum(city1);
		int num2 = getSpecialNum(city2);
		
		
		if(num1==-1||num2==-1)
			return "noCity"; //业务扩展相关
		
		if(num1>num2){
			int temp = num2;
			num2 = num1;
			num1 = temp;
		}
		String id = String.valueOf(num1)+String.valueOf(num2);
//		System.out.println(id);
		return id;
	}
	
	public int getSpecialNum(String city){
		int num;
		switch(city){
		case "南京": num = 1;break;
		case "上海": num = 2; break;
		case "广州": num = 3; break;
		case "北京": num = 4; break;
		default: num = -1;
		}
		return num;
	}
	//这里的运费策略还是要新建的，也就是说不一定只有  南京  上海 广州 北京，可能会有新建的城市，要写一个生成id的方法
		//可是计算运费的时候他要怎么对应呢？
		//先不管新增城市，假设只有这4个城市
		//新建一个运费策略的时候id不是由用户输入的，是由系统根据城市信息自动生成的，
		//要写一个自动生成id的类，根据两个城市由界面层调用获取对应id（stirng)
	//南京到上海 和 上海到南京的含义一样ma？如果已经有了南京到上海的运费策略，能不能新建上海到南京的运费策略？
	//一样的！两个方向的策略id是同一个
	public ResultMessage addFreight(FreightStrategyVO vo) throws IOException {
		// TODO 自动生成的方法存根
		String id = getID(vo.getCity1(),vo.getCity2());
		if(id=="noCity")
			return ResultMessage.lessThanMin;//代表没有对应城市的业务扩展
		FreightStrategyVO freight = null;
//		if(!fsds.isEmpty()){
			freight = getFreightStrategy(id);

			if(freight!=null)
				return ResultMessage.findIDFailed;     //代表现在数据中已经有这两个城市之间的运费策略了，返回信息通知用户
//		}
		freight = vo;
		freight.setID(id);
		
		FreightStrategyPO po = VOtoPO(freight);
		try {
			fsds.insert(po);
			return ResultMessage.Success;
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return ResultMessage.Failed;
		}
	}
	
	public ResultMessage deleteFreight(FreightStrategyVO vo) throws IOException{
		String id = getID(vo.getCity1(),vo.getCity2());
		if(id=="noCity")
			return ResultMessage.changeFailed;  //未扩展对应城市的业务
		
//		if(fsds.isEmpty())
//			return ResultMessage.lessThanMin;
		
		FreightStrategyVO freight = getFreightStrategy(id);
		
		
		if(freight==null)
			return ResultMessage.findIDFailed; //无对应po，不可删除
		
		
		FreightStrategyPO po = VOtoPO(freight);
		try {
			fsds.delete(po);
			return ResultMessage.Success;
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return ResultMessage.Failed;
		}

	}
	
	public ResultMessage changeFreight(FreightStrategyVO vo){
		
		FreightStrategyVO freight = getFreightStrategy(vo.getID());
		if(freight==null)
			return ResultMessage.findIDFailed;
		
		FreightStrategyPO po = VOtoPO(vo);
		try {
			fsds.update(po);
			return ResultMessage.Success;
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return ResultMessage.Failed;
		}
	
	}
	
	public ArrayList<FreightStrategyVO> findAll(){
		ArrayList<FreightStrategyPO> arr = new ArrayList<FreightStrategyPO>();
		try {
			arr = fsds.findAll();
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		if(arr==null){
			return null;
		}else{
			ArrayList<FreightStrategyVO> result = new ArrayList<FreightStrategyVO>();
			for(int i = 0; i < arr.size();i++){
				FreightStrategyVO vo = POtoVO(arr.get(i));
				result.add(vo);
			}
			
			return result;
		}
		
	}
	

	public UserDataService getUserData() {
		// TODO 自动生成的方法存根
		return null;
	}

	public DealDataService getDealData() {
		// TODO 自动生成的方法存根
		return null;
	}

	public IncomeDataService getIncomeData() {
		// TODO 自动生成的方法存根
		return null;
	}

	public ExpenseDataService getExpenseData() {
		// TODO 自动生成的方法存根
		return null;
	}

	public BankAccountDataService getBankAccountData() {
		// TODO 自动生成的方法存根
		return null;
	}

	public FreightStrategyDataService getFreightStrategyData() {
		// TODO 自动生成的方法存根
		DataFactory df;
		try{
			df = (DataFactory) Naming.lookup("rmi://localhost:1099/df");
			return df.getFreightStrategyData();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("can't connect to server");
			return null;
		}
		
	}

	public InitAllDataService getInitData() {
		// TODO 自动生成的方法存根
		return null;
	}

//	@Override
//	public StorageDataService getStorageData() throws RemoteException {
//		// TODO 自动生成的方法存根
//		return null;
//	}

	@Override
	public StaffDataService getStaffData() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public StorageDataService getStorageData() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}


	@Override
	public ArrivalListDataService getArrivalListData() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public SendingListDataService getSendingListData() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public IncomeListDataService getIncomeListData() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public RecivalListDataService getRecivalListData() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public LoadingListDataService getLoadingListData() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public TransferListDataService getTransferListData() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public LoadingListZZDataService getLoadingListZZData() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public DriverDataService getDriverData() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public CarDataService getCarData() {
		// TODO 自动生成的方法存根
		return null;
	}

//	@Override
//	public LogDataService getLogData() throws RemoteException {
//		// TODO 自动生成的方法存根
//		return null;
//	}


}
