package ELMS.businesslogic.FinanceBL;

import java.util.ArrayList;

import ELMS.businesslogicService.FinanceBlBankService;
import ELMS.vo.BankAccountVO;


public class Bank_Driver {
	public Bank_Driver(FinanceBlBankService bs){
		
System.out.println("Bank business logic service!!!!");
		
		ArrayList<BankAccountVO> bank = new ArrayList<BankAccountVO>();
		BankAccountVO bv1 = new BankAccountVO("00000001",0,"中国工商银行");
		BankAccountVO bv2 = new BankAccountVO("00000002",100,"中国工商银行");
		
		bank.add(bv1);
		bank.add(bv2);
		bank.add(new BankAccountVO("00000003",10000,"中国农业银行"));
		bank.add(new BankAccountVO("00000004",1000,"中国工商银行"));
		
		//查询单个银行账户
		if(bv1!=null){
			System.out.println("银行账号是："+bv1.getAccount());
			System.out.println("银行余额为："+bv1.getAmount());
			System.out.println("所属银行为："+bv1.getBankName()+"\n");
		}
		
		//查询某银行的银行账户
		ArrayList<BankAccountVO> bank1 = new ArrayList<BankAccountVO>();
		bank1 = bs.inquiryAccountByBank("中国银行");
		for(int i = 0; i < bank1.size(); i++){
			System.out.println("银行账号是："+bank1.get(i).getAccount());
			System.out.println("银行余额为："+bank1.get(i).getAmount());
			System.out.println("所属银行为："+bank1.get(i).getBankName()+"\n");
			if(i==bank1.size()-1)
				System.out.println("查询完毕！");
		}
		
		//新增银行账户
		if(bs.addAccount(new BankAccountVO("00000011",0,"中国工商银行")))
			System.out.println("成功增加银行账户！\n");
		
		//删除银行账户
		if(bs.deleteAccount("00000011"))
			System.out.println("成功删除银行账户！\n");
		
		//更新银行账户
		BankAccountVO bv3 = bs.changeAccount("00000001");
		if(bv3!=null)
			System.out.println("账户信息更新成功！\n");
		
		
		
		
		
	}
}
