package businesslogic.FinanceBL;

//感觉自己写的好乱，觉得并不需要Mock
import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Test;

import ELMS.businesslogic.FinanceBL.FinanceBankAccount;
import ELMS.businesslogic.FinanceBL.MockExpense;
import ELMS.businesslogic.FinanceBL.MockIncome;
import ELMS.vo.BankAccountVO;
import ELMS.vo.FExpenseVO;
import ELMS.vo.FIncomeVO;

public class BankAccountTest {

	@Test
	public void testadd() {
		BankAccountVO vo1 = new BankAccountVO("00000001","141250192",0.0,"zhong guo yin hang");
		BankAccountVO vo2 = new BankAccountVO("00000002","141250193",0.0,"zhong guo ren ming yin hang");
		BankAccountVO vo3 = new BankAccountVO("00000003","141250194",0.0,"zhong guo yin hang");
		
		FinanceBankAccount fba = new FinanceBankAccount();
		fba.addAccount(vo1);
		fba.addAccount(vo2);
		fba.addAccount(vo3);
		
		Assert.assertEquals(3, fba.getAllAccount().size());
		
		fba.deleteAccount("141250192");
		
		Assert.assertEquals(2, fba.getAllAccount().size());
		
		fba.addAccount(vo1);
		
		Assert.assertEquals("141250190",fba.changeAccount("00000001", "141250190").getAccount());
		
	}
//	
	public void testIncome(){
		BankAccountVO vo1 = new BankAccountVO("00000001","141250192",0.0,"zhong guo yin hang");
		BankAccountVO vo2 = new BankAccountVO("00000002","141250193",0.0,"zhong guo ren ming yin hang");
		BankAccountVO vo3 = new BankAccountVO("00000003","141250194",0.0,"zhong guo yin hang");
		
		FinanceBankAccount fba = new FinanceBankAccount();
		fba.addAccount(vo1);
		fba.addAccount(vo2);
		fba.addAccount(vo3);
		
		MockIncome income = new MockIncome(200.0,"141250192");
		FIncomeVO vo = new FIncomeVO(income.getAccountName(),"in00000001","2015-1-1",income.getIncome(),"NanJing","zwq");
	
		income.addIncome(vo);
		
		BankAccountVO vo4 = fba.inquiryAccount(income.getAccountName());
		Assert.assertEquals(200.0,vo4.getAmount());
		
	}
	
	public void testExpense(){
		BankAccountVO vo1 = new BankAccountVO("00000001","141250192",200.0,"zhong guo yin hang");
		BankAccountVO vo2 = new BankAccountVO("00000002","141250193",0.0,"zhong guo ren ming yin hang");
		BankAccountVO vo3 = new BankAccountVO("00000003","141250194",0.0,"zhong guo yin hang");
		
		FinanceBankAccount fba = new FinanceBankAccount();
		fba.addAccount(vo1);
		fba.addAccount(vo2);
		fba.addAccount(vo3);
		
		MockExpense expense = new MockExpense(101.0,"141250192");
		FExpenseVO vo = new FExpenseVO(expense.getAccountName(),"ex00000001","人员工资","2015-1-1",
				expense.getExpense(),"assistant:zwq","operator:zwh");
		
		expense.addExpense(vo);
		
		BankAccountVO vo4 = fba.inquiryAccount(expense.getAccountName());
		Assert.assertEquals(99.0,vo4.getAmount());
		
	}
	
	public void testInquiry(){
		BankAccountVO vo1 = new BankAccountVO("00000001","141250192",200.0,"zhong guo yin hang");
		BankAccountVO vo2 = new BankAccountVO("00000002","141250193",0.0,"zhong guo ren ming yin hang");
		BankAccountVO vo3 = new BankAccountVO("00000003","141250194",0.0,"zhong guo yin hang");
		
		FinanceBankAccount fba = new FinanceBankAccount();
		fba.addAccount(vo1);
		fba.addAccount(vo2);
		fba.addAccount(vo3);
		
		ArrayList<BankAccountVO> findByBank = new ArrayList<BankAccountVO>();
		
		try {
			findByBank = fba.inquiryAccountByBank("zhong guo yin hang");
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		for(int i = 0; i < findByBank.size(); i++){
			Assert.assertEquals("zhong guo yin hang",findByBank.get(i).getBankName());
		}
	}
}
