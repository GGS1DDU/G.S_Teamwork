package ELMS.businesslogic.FinanceBL;

import java.util.ArrayList;

import ELMS.businesslogicService.FinanceBlFormService;
import ELMS.vo.FExpenseVO;
import ELMS.vo.FIncomeVO;


public class Form_Driver {

	public Form_Driver(FinanceBlFormService formService){
		//新建账户
				String str = "zwq";
				if(formService.init("zwq"))
					System.out.println(str+"期初建账成功!\n");
				
				//新建收入项列表
				ArrayList<FIncomeVO> income = formService.createInForm("20150101", "20150201");
				for(int i = 0; i < income.size(); i++){
					System.out.println("订单id："+income.get(i).getID()+" ");
					System.out.println("收入时间："+income.get(i).getTime()+" ");
					System.out.println("收入数额："+income.get(i).getIncome()+" ");
					System.out.println("上交营业厅号:"+income.get(i).getShop()+" ");
					System.out.println("操作人员："+income.get(i).getClerk()+"\n");
				}
				System.out.println("新建成功！\n");
				
				//新建支出项列表
				ArrayList<FExpenseVO> expense = formService.createExForm("20150101","20150201");
				
				//获取总收入 
				double TotalIn = formService.getTotalIncome(income);
				System.out.println("Total income:"+TotalIn);
				
				//获取总支出
				double TotalEx = formService.getTotalExpense(expense);
				
				//获取利润
				double profit = formService.getBalance(TotalIn, TotalEx);
				System.out.println("Total profit:"+profit);
				
				//导出报表
				if(formService.deriveForm("zwq"))
					System.out.println("成功导出报表！\n");
				
		
	}
	
	
	
}
