package ELMS.businesslogic.FinanceBL;


import java.rmi.RemoteException;
import java.util.ArrayList;

import ELMS.data.FinanceData.FinanceData;
import ELMS.po.BankAccountPO;
import ELMS.vo.BankAccountVO;

public class FinanceBankAccount {
	static ArrayList<BankAccountVO> bavo = new ArrayList<BankAccountVO>();
	FinanceData fd = new FinanceData();
	
	
	
	public boolean addAccount(BankAccountVO vo) {
		// TODO 自动生成的方法存�?
		
		BankAccountPO po;
		String accountID = vo.getAccountID();
		String accountName = vo.getAccount();
		double balance = vo.getAmount();
		String bankName = vo.getBankName();
		po = new BankAccountPO(accountID,accountName,balance,bankName);
		try {
			fd.insertAccount(po);
			bavo.add(vo);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		System.out.println(bavo.size());
		return true;
	}

	public boolean deleteAccount(String bankAccount) {
		// TODO 自动生成的方法存�?
		System.out.println("before delete,bavo.size="+bavo.size());
		int i = 0;
		for( ; i < bavo.size();i++){
			String account = bavo.get(i).getAccount();
			if(account.equals(bankAccount)){
				break;
			}
		}
		if(i!=bavo.size()){
			bavo.remove(i);
			try {
				fd.deleteAccount(bankAccount);
			} catch (RemoteException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			return true;
		}
		return false;
	}

	public BankAccountVO changeAccount(String accountID,String accountName) {
		// TODO 自动生成的方法存�?
		int i = 0;
		for( ; i < bavo.size(); i++){
			if(bavo.get(i).getAccountID().equals(accountID)){
				bavo.get(i).setAccount(accountName);
				BankAccountVO vo = bavo.get(i);
				BankAccountPO po = new BankAccountPO(vo.getAccountID(),vo.getAccount(),vo.getAmount(),vo.getBankName());
				try {
					fd.updateAccount(po);
				} catch (RemoteException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				break;
			}
		}
		System.out.println(bavo.get(i).getAccount());
		if(i!=bavo.size())
			return bavo.get(i);
		return null;
	}
	
	public boolean changeBalance(String BankName,String type,double amount){
		System.out.println("start change balance");
		System.out.println(bavo.size());
		for(int i = 0; i < bavo.size(); i++){
			if(bavo.get(i).getAccount().equals(BankName)){
				if(type.equals("income")){
					bavo.get(i).setAmount(bavo.get(i).getAmount()+amount);
					
					System.out.println(bavo.get(i).getAmount());
					return true;
				}else if(type.equals("expense")){
					bavo.get(i).setAmount(bavo.get(i).getAmount()-amount);
					return true;
				}
			}
		}
		
		
		return false;
	}

	public BankAccountVO inquiryAccount(String accountName) {
		// TODO 自动生成的方法存�?
		//真正的测试不用bavo，从数据层获取数据
		int i = 0;
		for(; i < bavo.size(); i++){
			if(accountName.equals(bavo.get(i).getAccount()))
				break;
		}
		System.out.println("i="+i);
		System.out.println(bavo.get(i).getAccount());
		System.out.println(bavo.get(i).getAmount());
		if(i!=bavo.size())
			return bavo.get(i);
		return null;
	}

	public ArrayList<BankAccountVO> inquiryAccountByBank(String bankName) throws RemoteException {
		// TODO 自动生成的方法存�?
		
//		ArrayList<BankAccountPO> account = fd.findByBank(bankName);
//		ArrayList<BankAccountVO> accountVO = new ArrayList<BankAccountVO>();
//		for(int i = 0; i < account.size(); i++){
//			BankAccountPO po = account.get(i);
//			BankAccountVO vo = new BankAccountVO(po.getAccountID(),po.getAccountName(),po.getAmount(),
//					po.getBankName());
//			accountVO.add(vo);
//		}
		int i = 0;
		ArrayList<BankAccountVO> byBank = new ArrayList<BankAccountVO>();
		for(; i < bavo.size(); i++){
			if(bavo.get(i).getAccount().equals(bankName))
				byBank.add(bavo.get(i));
		}
		return byBank;
	}
	
	public ArrayList<BankAccountPO> getAllAccount(){
		//真实的应该从数据层调用，此时只是为了测试而假设的数据
		ArrayList<BankAccountPO> list = new ArrayList<BankAccountPO>();
		for(int i = 0; i < bavo.size(); i++){
			BankAccountPO po = new BankAccountPO(null,null,0.0,null);
			list.add(po);
		}
		
		System.out.println(list.size());
		return list;
	}
	
	
	public void endFinanceOpt() {
		// TODO 自动生成的方法存�?
		
	}

}
