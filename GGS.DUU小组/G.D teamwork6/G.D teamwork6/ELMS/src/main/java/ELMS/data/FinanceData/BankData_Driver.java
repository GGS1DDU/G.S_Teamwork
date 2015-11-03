package ELMS.data.FinanceData;

import java.rmi.RemoteException;
import java.util.ArrayList;

import ELMS.dataservice.FinanceBankDataService;
import ELMS.po.BankAccountPO;


public class BankData_Driver {
	public BankData_Driver(FinanceBankDataService bankData) throws RemoteException{
		
		
		System.out.println("Bank data service option!!!");
		String id = "po000001";
		
		//查找银行账户
		BankAccountPO ba = bankData.find(id);
		if(ba!=null){
		System.out.println("银行账号是："+ba.getAccount());
		System.out.println("银行余额为："+ba.getAmount());
		System.out.println("所属银行为："+ba.getBankName()+"\n");
		}
		
		//根据银行名称查找银行账户
		ArrayList<BankAccountPO> bank1 = bankData.findByBank("中国工商银行");
		for(int i = 0; i < bank1.size(); i++){
			System.out.println("银行账号是："+bank1.get(i).getAccount());
			System.out.println("银行余额为："+bank1.get(i).getAmount());
			System.out.println("所属银行为："+bank1.get(i).getBankName()+"\n");
			if(i==bank1.size()-1)
				System.out.println("查询完毕！");
		}
		
		bankData.insert(ba);
		System.out.println("新建银行账户成功！\n");
		
		bankData.delete(ba);
		System.out.println("删除银行账户成功！\n");
		
		bankData.update(ba);
		System.out.println("更新银行账户成功！\n");
	}
}
