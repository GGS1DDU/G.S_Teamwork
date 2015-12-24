package elms.presentation.financeui.inAndEx.income;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;

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
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumnModel;

import elms.businesslogic.ResultMessage;
import elms.businesslogic.financebl.inandex.IncomeManager;
import elms.presentation.uihelper.TableModel;
import elms.vo.FIncomeVO;
import elms.vo.UserVO;

public class IncomeList extends JPanel {

	private TableModel model;
	private JTable table;

	private IncomeManager im = new IncomeManager();
	UserVO vo;

	public static ArrayList<FIncomeVO> arr = new ArrayList<FIncomeVO>();
	private FIncomeVO test = new FIncomeVO("zwq141250192", "in00000001",
			"2015-11-30", 200, "南京市鼓楼营业厅", "张文�?");

//	public static void main(String args[]) {
//		JFrame jf = new JFrame();
//		jf.setBounds(10, 10, 500, 300);
//		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//		Dimension d = new Dimension(jf.getWidth(), jf.getHeight() - 200);
//		UserVO vo = new UserVO();
//		IncomeList im = new IncomeList(d, vo);
//		jf.add(im);
//		jf.setVisible(true);
//
//		// im.removeData();
//
//	}

	public IncomeList(Dimension d, final UserVO vo) {
		setOpaque(false);
		this.vo = vo;
		arr = im.inquiryAll();

		setSize(d.width, d.height - 25);
		// setBackground(Color.WHITE);
		setLayout(null);
		setVisible(true);

		Border l2 = BorderFactory.createLoweredBevelBorder();
		JLabel incomeList = new JLabel("收入清单");

		JPanel info = new JPanel();
		info.setOpaque(false);
		info.setLayout(new java.awt.BorderLayout());
		info.add(incomeList);
		info.setBounds(0, 23, 70, 25);
		info.setBorder(l2);
		info.setBackground(Color.white);

		String[] title_name = { "选择", "ID", "建立时间", "收入金额", "收入营业厅", "收入记录人员",
				"入账账户" };
		model = new TableModel(title_name);
		table = new JTable(model);
//		table.setBackground(Color.black);

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
//		scroll.setOpaque(false);
		scroll.setBounds(0, 50, d.width - 25, d.height - 100);
		scroll.setBackground(Color.black);
	
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
//		System.out.println("id:"+id);
		return id;
	}

	public void addAllData(ArrayList<FIncomeVO> vo) {
		for (int i = 0; i < vo.size(); i++) {
			addData(vo.get(i));
		}
	}

	public void addData(FIncomeVO vo) {

		Object[] content = {false,vo.getID(),vo.getTime(),new Double(vo.getIncome()),vo.getShop(),vo.getClerk(),vo.getBankAccountName()};
		model.addRow(content);
		table.updateUI();

	}

	public void removeAllData() {
		model.removeAllRows(model.getRowCount());
		table.updateUI();
	}

	public void removeData() {
		boolean removeSuccess = false;
		ArrayList<Integer> deleteIndex = new ArrayList<Integer>();
		for(int i = 0; i < model.getRowCount(); i++){
			if((Boolean)model.getValueAt(i, 0)==true){
				String id = (String)model.getValueAt(i, 1);
				try {
					FIncomeVO vo = im.inquiryIncome(id);
					ResultMessage rm = im.deleteIncome(vo);
					if(rm==ResultMessage.Success){
						ArrayList<FIncomeVO> in = Income_main.arr;
						int j = 0;
						for(; j < in.size(); j++){
							if(in.get(j).getID().equals(vo.getID())){
								Income_main.arr.remove(j);
								deleteIndex.add(i);
								break;
							}
						}
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
			JOptionPane.showMessageDialog(null, "删除收入项成功！");
			
		}
//		model.removeRows(model.getRowCount());
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
