package elms.businesslogic.financebl.inandex;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import elms.vo.FExpenseVO;
import elms.vo.FIncomeVO;


//这个类负责对总收入总支出以及报表的相关操作
public class StatisticManager {

	ExpenseManager exmanage;
	IncomeManager inmanage;
	double profit;
	ArrayList<FIncomeVO> incomeList;
	ArrayList<FExpenseVO> expenseList;

	public StatisticManager() {
		exmanage = new ExpenseManager();
		inmanage = new IncomeManager();
		profit = 0.0;
	}

	public ArrayList<FIncomeVO> getIncome(String time1, String time2) {
		ArrayList<FIncomeVO> income = inmanage
				.inquiryIncomeByTime(time1, time2);
		return income;
	}

	public ArrayList<FExpenseVO> getExpense(String time1, String time2) {
		ArrayList<FExpenseVO> expense = exmanage.inquiryByTime(time1, time2);
		return expense;
	}

	public double getTotalIn(ArrayList<FIncomeVO> in) {
		double result = 0.0;
		if (in == null) {
			return result;
		}
		for (FIncomeVO vo : in) {
			result = result + vo.getIncome();
		}
		return result;
	}

	public double getTotalEx(ArrayList<FExpenseVO> ex) {
		double result = 0.0;
		if (ex == null) {
			return result;
		}
		for (FExpenseVO vo : ex) {
			result += vo.getExpense();
		}
		return result;
	}

	public double getProfit(double in, double ex) {
		return in - ex;
	}

	public boolean createForm(String time1, String time2) {

		incomeList = getIncome(time1, time2);
		expenseList = getExpense(time1, time2);

		double totalIn = getTotalIn(incomeList);
		double totalEx = getTotalEx(expenseList);
		profit = totalIn - totalEx;

		return true;

	}

	// 将报表导出为excel表格，之后再写
	public void deriveIncome(List<FIncomeVO> temp, String s) throws IOException {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet st = wb.createSheet("收入");
		ArrayList<String> Items = new ArrayList<String>();
		Items.add("ID");
		Items.add("建立时间");
		Items.add("收入金额");
		Items.add("收入营业厅");
		Items.add("收入记录人员");
		Items.add("入帐账户");
		for (int j = 0; j <= temp.size(); j++) {
			HSSFRow Itemsrow = st.createRow(j);
			if (j == 0)
				for (int i = 0; i < Items.size(); i++) {
					HSSFCell cell = Itemsrow.createCell(i);
					cell.setCellValue(Items.get(i));
				}
			else {
				FIncomeVO vo = temp.get(j - 1);
				ArrayList<String> value = new ArrayList<String>();
				value.add(vo.getID());
				value.add(vo.getTime());
				value.add("" + vo.getIncome());
				value.add(vo.getShop());
				value.add(vo.getClerk());
				value.add(vo.getBankAccountName());
		
				for (int i = 0; i < 8; i++) {
					HSSFCell cell = Itemsrow.createCell(i);
					cell.setCellValue(value.get(i));
				}
			}

		}
		try {

			FileOutputStream writeFile = new FileOutputStream("Income  " + s
					+ ".xlsx");
			wb.write(writeFile);
			writeFile.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deriveExpense(List<FExpenseVO> temp, String s) throws IOException {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet st = wb.createSheet("收入");
		ArrayList<String> Items = new ArrayList<String>();
		Items.add("ID");
		Items.add("支出时间");
		Items.add("支出类型");
		Items.add("支出金额");
		Items.add("支出账户");
		Items.add("实际支出人员");
		Items.add("记录人员");
		for (int j = 0; j <= temp.size(); j++) {
			HSSFRow Itemsrow = st.createRow(j);
			if (j == 0)
				for (int i = 0; i < Items.size(); i++) {
					HSSFCell cell = Itemsrow.createCell(i);
					cell.setCellValue(Items.get(i));
				}
			else {
				FExpenseVO vo = temp.get(j - 1);
				ArrayList<String> value = new ArrayList<String>();
				value.add(vo.getID());
				value.add(vo.getTime());
				value.add(vo.getCategory());
				value.add(""+vo.getExpense());
				value.add(vo.getBankAccountName());
				value.add(vo.getClerk());
				value.add(vo.getAssistant());
				
				for (int i = 0; i < 8; i++) {
					HSSFCell cell = Itemsrow.createCell(i);
					cell.setCellValue(value.get(i));
				}
			}

		}
		try {

			FileOutputStream writeFile = new FileOutputStream("Income  " + s
					+ ".xlsx");
			wb.write(writeFile);
			writeFile.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
