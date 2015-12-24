package elms.presentation.managerui.staff.staffhelper;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
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
import elms.businesslogic.managerbl.StaffManager;
import elms.presentation.financeui.inAndEx.expense.Expense_main;
import elms.presentation.financeui.inAndEx.income.IncomeList;
import elms.presentation.managerui.staff.StaffUI_main;
import elms.presentation.uihelper.TableModel;
import elms.vo.FExpenseVO;
import elms.vo.StaffVO;
import elms.vo.UserVO;

public class StaffList extends JPanel{

	private TableModel model;
	private JTable table;

	private StaffManager sm = new StaffManager();
	
	private UserVO vo;

	public static ArrayList<StaffVO> arr = new ArrayList<StaffVO>();
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

	public StaffList(Dimension d, final UserVO vo) {
		this.vo = vo;
		arr = sm.findByJob("全部");

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

		String[] title_name = { "选择", "ID", "姓名", "性别", "联系方式 ", "身份",
				"基本工资" ,"薪水计算方式"};
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

	public void addAllData(ArrayList<StaffVO> vo) {
		for (int i = 0; i < vo.size(); i++) {
			addData(vo.get(i));
		}
	}

	public void addData(StaffVO vo) {

		boolean gender = vo.getGender();
		String sex = "男";
		if(!gender){
			sex = "女";
		}
		Object[] content = {false,vo.getID(),vo.getName(),sex,vo.getPhoneNum(),vo.getJob(),
				new Double(vo.getEssentialSalary()),vo.getSalaryStrategy()};
		
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
					StaffVO vo = sm.findStaff(id);
					ResultMessage rm = sm.deleteStaff(vo);
					if(rm==ResultMessage.Success){
						ArrayList<StaffVO> staff = StaffUI_main.arr;
						int j = 0;
						for(; j < staff.size(); j++){
							if(staff.get(j).getID().equals(vo.getID())){
								Expense_main.arr.remove(staff);
								
								break;
							}
						}
						deleteIndex.add(i);
						removeSuccess = true;
//						model.removeRow(i);
						
					}else if(rm==ResultMessage.findIDFailed){
						JOptionPane.showConfirmDialog(null, id+":找不到对应用户");
						break;
					}
				} catch (Exception e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				
			}
		}
		if(removeSuccess){
			JOptionPane.showMessageDialog(null, "删除员工信息成功！");
			
		}
//		model.removeRows(model.getRowCount());
		for(int i = 0; i < deleteIndex.size();i++){
			System.out.println("ExpenseList:delete "+deleteIndex.get(i));
		}
		model.removeRows(deleteIndex);
		table.updateUI();
	}
}
