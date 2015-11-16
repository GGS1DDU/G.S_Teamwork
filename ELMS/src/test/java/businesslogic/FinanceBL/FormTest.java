package businesslogic.FinanceBL;


//感觉我并不需要mock收入类和支出类，因为我在计算收入支出的时候是以收入支出的vo进行计算的，
//而收入类的功能是增删改和各种查，也就是说新建一个收入类，不一定是对应一个收入vo，而可能是多个vo组成的
//一个arrayList，这样的话就并不需要像书上那样把它加到一个list里再gettotal
import static org.junit.Assert.*;

import java.util.ArrayList;

import junit.framework.Assert;

import ELMS.businesslogic.FinanceBL.FinanceStatistic;
import ELMS.businesslogic.FinanceBL.MockIncome;
import ELMS.vo.FExpenseVO;
import ELMS.vo.FIncomeVO;







import org.junit.Test;

public class FormTest {

	@Test
	public void test() {
		FinanceStatistic formData = new FinanceStatistic();
		ArrayList<FIncomeVO> income = new ArrayList<FIncomeVO>();
		ArrayList<FExpenseVO> expense = new ArrayList<FExpenseVO>();
		
		FIncomeVO in1 = new FIncomeVO("010000001","2015-1-1",300,"南京1号营业厅","郑闻昊");
		FIncomeVO in2 = new FIncomeVO("in010000002","2015-2-2",500,"南京2号营业厅","zwh");
		
		income.add(in1);
		income.add(in2);
		
		FExpenseVO ex1 = new FExpenseVO("ex001000001","人员工资","2015-1-1",100,"zwh记录","zwq支出");
		FExpenseVO ex2 = new FExpenseVO("ex001000002","货物运费","2015-2-1",100,"zwh记录","zyt支出");
		
		expense.add(ex1);
		expense.add(ex2);
		
		double totalIn = formData.getTotalIn(income);
		double totalEx = formData.getTotalEx(expense);
		double profit = totalIn - totalEx;
		
		Assert.assertEquals(800.0, totalIn);
		Assert.assertEquals(200.0, totalEx);
		Assert.assertEquals(600.0, profit);
		
		
		
	}
	
//	public void testStatistic(){
//		MockIncome in1 = new MockIncome(200.0);
//		MockIncome in2 = new MockIncome(100.0);
//		
//		ArrayList<MockIncome> income = new ArrayList<MockIncome>();
//		income.add(in1);
//		income.add(in2);
//		
//		FinanceStatistic fs = new FinanceStatistic();
//		
//		double totalIn = fs.getTotalIn(vo)
//	}

}
