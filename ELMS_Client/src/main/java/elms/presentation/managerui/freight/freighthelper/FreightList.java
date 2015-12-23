package elms.presentation.managerui.freight.freighthelper;

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

import elms.businesslogic.managerbl.FreightStrategyManager;
import elms.presentation.financeui.inAndEx.expense.Expense_main;
import elms.presentation.financeui.inAndEx.income.IncomeList;
import elms.presentation.managerui.freight.FreightUI_main;
import elms.presentation.uihelper.TableModel;

import elms.vo.FIncomeVO;
import elms.vo.FreightStrategyVO;
import elms.vo.UserVO;

public class FreightList extends JPanel {

	private TableModel model;
	private JTable table;

	private FreightStrategyManager fm = new FreightStrategyManager();

	UserVO uservo;

	public static ArrayList<FreightStrategyVO> arr = new ArrayList<FreightStrategyVO>();
	private FIncomeVO test = new FIncomeVO("zwq141250192", "in00000001",
			"2015-11-30", 200, "南京市鼓楼营业厅", "张文�?");

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

	public FreightList(Dimension d, final UserVO vo) {
		this.uservo = vo;
//		arr = fm.findAll();

		setSize(d.width, d.height - 25);
		// setBackground(Color.WHITE);
		setLayout(null);
		setVisible(true);

		Border l2 = BorderFactory.createLoweredBevelBorder();
		JLabel incomeList = new JLabel("运费列表");

		JPanel info = new JPanel();
		info.setLayout(new java.awt.BorderLayout());
		info.add(incomeList);
		info.setBounds(0, 23, 70, 25);
		info.setBorder(l2);
		info.setBackground(Color.white);

		String[] title_name = { "选择", "ID", "城市1", "城市2", "距离", "标准运费单价",
				"调整因子" };
		model = new TableModel(title_name);
		table = new JTable(model);
		table.setBackground(Color.white);

		TableColumnModel tcm = table.getColumnModel();
		tcm.getColumn(0).setCellEditor(new DefaultCellEditor(new JCheckBox()));
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
//
//		for (int i = 0; i < arr.size(); i++) {
//			addData(arr.get(i));
//		}

	}

	public String getSelectedID() {
		int row = table.getSelectedRow();
		if (row == -1) {
			return null;
		}
		String id = (String) model.getValueAt(row, 1);
		System.out.println("id:" + id);
		return id;
	}

	public void addAllData(ArrayList<FreightStrategyVO> vo) {
		removeAllData();
		for (int i = 0; i < vo.size(); i++) {
			addData(vo.get(i));
		}
	}

	public void addData(FreightStrategyVO vo) {

		Object[] content = { false, vo.getID(), vo.getCity1(), vo.getCity2().substring(0, 2),
				vo.getDistance(), vo.getStandardPrice(), vo.getCoefficient() };

		model.addRow(content);
		table.updateUI();

	}

	public void removeAllData() {
		model.removeAllRows(model.getRowCount());
		table.updateUI();
	}

	// 与数据层的交互，删除对应内容
	public void removeData() {
		boolean removeSuccess = false;
		ArrayList<Integer> deleteIndex = new ArrayList<Integer>();
		for (int i = 0; i < model.getRowCount(); i++) {
			if ((Boolean) model.getValueAt(i, 0) == true) {
				String id = (String) model.getValueAt(i, 1);
				try {
					FreightStrategyVO vo = fm.getFreightStrategy(id);
					ResultMessage rm = fm.deleteFreight(vo);
					if (rm == ResultMessage.Success) {
						ArrayList<FreightStrategyVO> freight = FreightUI_main.arr;
						int j = 0;
						for (; j < freight.size(); j++) {
							if (freight.get(j).getID().equals(vo.getID())) {
								Expense_main.arr.remove(j);

								break;
							}
						}
						deleteIndex.add(i);
						removeSuccess = true;
						// model.removeRow(i);

					} else if (rm == ResultMessage.changeFailed) {
						JOptionPane.showConfirmDialog(null, id + ":未扩展对应城市！");
						break;
					} else if (rm == ResultMessage.findIDFailed) {
						JOptionPane.showMessageDialog(null, id
								+ ":找不到对应运费策略！", "失败",
								JOptionPane.ERROR_MESSAGE);
						break;
					}
				} catch (Exception e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}

			}
		}
		if (removeSuccess) {
			JOptionPane.showMessageDialog(null, "删除运费策略成功！");

		}
		// model.removeRows(model.getRowCount());
		for (int i = 0; i < deleteIndex.size(); i++) {
			System.out.println("ExpenseList:delete " + deleteIndex.get(i));
		}
		model.removeRows(deleteIndex);
		table.updateUI();
	}

	private void saveData() {
		int col = model.getColumnCount();
		int row = model.getRowCount();
		for (int i = 0; i < col; i++) {

		}
	}
}
