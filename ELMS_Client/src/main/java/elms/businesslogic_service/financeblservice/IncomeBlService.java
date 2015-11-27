package elms.businesslogic_service.financeblservice;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import elms.vo.FIncomeVO;


public interface IncomeBlService {
	public boolean addIncome(FIncomeVO vo);
	
	public boolean deleteIncome(FIncomeVO vo);
	
	public boolean changeIncome(FIncomeVO vo);
	
	public FIncomeVO inquiryIncome(String id) throws RemoteException, IOException;
	
	
	public ArrayList<FIncomeVO> inquiryIncomeByHall(String center);
	
	public ArrayList<FIncomeVO> inquiryIncomeByTime(String time1, String time2) throws RemoteException;
	
	public ArrayList<FIncomeVO> inquiryInByTimeHall(String time1, String time2, String center);
	
	
}
