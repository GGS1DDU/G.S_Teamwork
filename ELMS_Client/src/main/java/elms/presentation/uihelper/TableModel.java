package elms.presentation.uihelper;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import elms.businesslogic.ResultMessage;
import elms.businesslogic.financebl.inandex.IncomeManager;
import elms.presentation.financeui.inAndEx.income.Income_main;
import elms.vo.FIncomeVO;

public class TableModel extends AbstractTableModel {
	protected Vector content = null;
	int count = 0;

	private String[] title_name = { "选择", "ID", "建立时间", "收入金额", "收入营业厅",
			"收入记录人员", "入账账户" };

//	public TableModel() {
//		content = new Vector();
//	}

	public TableModel(String[] title) {
		content = new Vector();
		this.count = title.length;
		this.title_name = title;
	}

	// 给每一个需要列表的类写一个类继承自tablemodel，重写addRow方法
	public void addRow(Object[] con) {
		Vector v = new Vector(count);
		v.add(0, new Boolean(false));
		for(int i = 1; i < con.length; i++){
			v.add(con[i]);
		}
//		v.add(1, vo.getID());
//		v.add(2, vo.getTime());
//		v.add(3, new Double(vo.getIncome()));
//		v.add(4, vo.getShop());
//		v.add(5, vo.getClerk());
//		System.out.println(vo.getClerk());
//		v.add(6, vo.getBankAccountName());
		content.addElement(v);
	}

	//只删除table中，不删除数据层的内容
	public void removeRow(int row) {
		content.removeElement(row);
	}
	//同上
	public void removeAllRows(int count) {
		System.out.println(count);
		for (int i = 0; i < count; i++) {
			content.removeElementAt(i);
			i--;
			count--;
		}
		
	}


	//deleteIndex是选中的删除的内容的行编号
	public void removeRows(ArrayList<Integer> deleteIndex){
		for(int i = 0; i < deleteIndex.size(); i++){
			int index = 0;
//			if(i!=0){
				index = deleteIndex.get(i)-i;  //已经把前面的删了的话，deleteIndex中存的index就要减掉之前删了的
//			}
			content.removeElementAt(index);
			
			System.out.println("delete:"+index);
		}
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if (columnIndex == 1) {
			return false;
		}
		return true;
	}

	// ???使修改的内容生效
	public void setValueAt(Object value, int row, int col) {
		((Vector) content.get(row)).remove(col);
		((Vector) content.get(row)).add(col, value);
		this.fireTableCellUpdated(row, col); // ??
	}

	public String getColumnName(int col) {
		return title_name[col];
	}

	public int getColumnCount() {
		// TODO 自动生成的方法存�?
		return title_name.length;

	}

	public int getRowCount() {
		// TODO 自动生成的方法存�?
		return content.size();
	}

	public Object getValueAt(int row, int col) {
		// TODO 自动生成的方法存�?
		return ((Vector) content.get(row)).get(col);
	}

	public Class getColumnClass(int col) {
		return getValueAt(0, col).getClass();
	}
}
