package elms.presentation.financeui.inAndEx.expense;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.TableColumnModel;

import elms.businesslogic.ResultMessage;
import elms.businesslogic.financebl.inandex.ExpenseManager;

import elms.presentation.financeui.inAndEx.income.IncomeList;

import elms.presentation.uihelper.TableModel;
import elms.vo.FExpenseVO;
import elms.vo.FIncomeVO;
import elms.vo.UserVO;

public class ExpenseList extends JPanel{

	private TableModel model;
	private JTable table;

	private ExpenseManager em = new ExpenseManager();
	
	UserVO vo;

	public static ArrayList<FExpenseVO> arr = new ArrayList<FExpenseVO>();
//	private FIncomeVO test = new FIncomeVO("zwq141250192", "in00000001",
//			"2015-11-30", 200, "南京市鼓楼营业厅", "张文�?");

	public static void main(String args[]) {
		JFrame jf = new JFrame();
		jf.setBounds(10, 10, 500, 300);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Dimension d = new Dimension(jf.getWidth(), jf.getHeight() - 200);
		UserVO vo = new UserVO();
		IncomeList im = new IncomeList(d, vo);
		jf.add(im);
		jf.setVisible(true);

		// im.removeData();

	}

	public ExpenseList(Dimension d, final UserVO vo) {
		this.vo = vo;
		arr = em.inquiryAll();

		setSize(d.width, d.height - 25);
		// setBackground(Color.WHITE);
		setLayout(null);
		setVisible(true);

		Border l2 = BorderFactory.createLoweredBevelBorder();
		JLabel incomeList = new JLabel("支出清单");

		JPanel info = new JPanel();
		info.setLayout(new java.awt.BorderLayout());
		info.add(incomeList);
		info.setBounds(0, 23, 70, 25);
		info.setBorder(l2);
		info.setBackground(Color.white);

		String[] title_name = { "选择", "ID", "支出记录时间", "支出类型", "支出金额", "支出账户",
				"实际支出人员" ,"记录人员"};
		model = new TableModel(title_name);
		table = new JTable(model);
		table.setBackground(Color.white);

		TableColumnModel tcm = table.getColumnModel();
		tcm.getColumn(0).setCellEditor(new DefaultCellEditor(new JCheckBox()));
		tcm.getColumn(7).setPreferredWidth(50);
		tcm.getColumn(6).setPreferredWidth(50);
		tcm.getColumn(5).setPreferredWidth(50);
		tcm.getColumn(4).setPreferredWidth(50);
		tcm.getColumn(3).setPreferredWidth(50);
		tcm.getColumn(2).setPreferredWidth(50);
		tcm.getColumn(1).setPreferredWidth(50);
		tcm.getColumn(0).setPreferredWidth(50);

		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(0, 50, d.width - 25, d.height - 100);
		scroll.setBackground(Color.WHITE);
		add(scroll);

		add(info);

		for (int i = 0; i < arr.size(); i++) {
			addData(arr.get(i));
		}
		
		

	}
	
	public String getSelectedID(){
		int row = table.getSelectedRow();
		if(row==-1){
			return null;
		}
		String id = (String)model.getValueAt(row, 1);
		return id;
	}

	public void addAllData(ArrayList<FExpenseVO> vo) {
		for (int i = 0; i < vo.size(); i++) {
			addData(vo.get(i));
		}
	}

	public void addData(FExpenseVO vo) {

		Object[] content = {false,vo.getID(),vo.getTime(),vo.getCategory(),new Double(vo.getExpense()),
				vo.getBankAccountName(),vo.getClerk(),vo.getAssistant()};
		
		model.addRow(content);
		table.updateUI();

	}

	public void removeAllData() {
		model.removeAllRows(model.getRowCount());
		table.updateUI();
	}

	//与数据层的交互，删除对应内容
	public void removeData() {
		boolean removeSuccess = false;
		ArrayList<Integer> deleteIndex = new ArrayList<Integer>();
		for(int i = 0; i < model.getRowCount(); i++){
			if((Boolean)model.getValueAt(i, 0)==true){
				String id = (String)model.getValueAt(i, 1);
				try {
					FExpenseVO vo = em.inquiryExpense(id);
					ResultMessage rm = em.deleteExpense(vo);
					if(rm==ResultMessage.Success){
						ArrayList<FExpenseVO> in = Expense_main.arr;
						int j = 0;
						for(; j < in.size(); j++){
							if(in.get(j).getID().equals(vo.getID())){
								Expense_main.arr.remove(j);
								
								break;
							}
						}
						deleteIndex.add(i);
						removeSuccess = true;
//						model.removeRow(i);
						
					}else if(rm==ResultMessage.changeFailed){
						JOptionPane.showConfirmDialog(null, id+":找不到对应银行账户");
						break;
					}else if(rm==ResultMessage.lessThanMin){
						JOptionPane.showMessageDialog(null,id+":银行账户余额不足，不可删除！","失败",JOptionPane.ERROR_MESSAGE);
						break;
					}
				} catch (Exception e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				
			}
		}
		if(removeSuccess){
			JOptionPane.showMessageDialog(null, "删除支出项成功！");
			
		}
//		model.removeRows(model.getRowCount());
		for(int i = 0; i < deleteIndex.size();i++){
			System.out.println("ExpenseList:delete "+deleteIndex.get(i));
		}
		model.removeRows(deleteIndex);
		table.updateUI();
	}

//	private void saveData() {
//		int col = model.getColumnCount();
//		int row = model.getRowCount();
//		for (int i = 0; i < col; i++) {
//
//		}
//	}
}
