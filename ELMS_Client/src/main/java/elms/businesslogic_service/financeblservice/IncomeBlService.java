package elms.businesslogic_service.financeblservice;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;



import elms.businesslogic.ResultMessage;
import elms.vo.FIncomeVO;


public interface IncomeBlService {
	public ResultMessage addIncome(FIncomeVO vo);
	
	public ResultMessage deleteIncome(FIncomeVO vo);
	
	public ResultMessage changeIncome(FIncomeVO vo);
	
	public FIncomeVO inquiryIncome(String id) throws RemoteException, IOException;
	
	
	public ArrayList<FIncomeVO> inquiryIncomeByHall(String center);
	
	public ArrayList<FIncomeVO> inquiryIncomeByTime(String time1, String time2) throws RemoteException;
	
	public ArrayList<FIncomeVO> inquiryInByTimeHall(String time1, String time2, String center);
	
	public ArrayList<FIncomeVO> inquiryAll();
	
	
}
