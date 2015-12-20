package elms.presentation.storageui;

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
import elms.vo.StorageVO;

public class TableModel extends AbstractTableModel {
	protected Vector content = null;
	int count = 0;
	private String[] title_name ;
	
	public TableModel(String[] title) {
		content = new Vector();
		this.count = title.length;
		this.title_name = title;
	}

	// 给每一个需要列表的类写一个类继承自tablemodel，重写addRow方法
	public void addRow(Object[] con) {
		Vector v = new Vector(count);
		for(int i = 0; i < con.length; i++){
			v.add(con[i]);
		}
		content.addElement(v);
	}

	//只删除table中，不删除数据层的内容
	public void removeRow(int row) {
		content.removeElement(row);
	}
	//同上
	public void removeAllRows(int count) {
		
		while(count>0) {
			content.removeElementAt(count-1);
		count--;
		}
		
	}

    public Object[] changeRow(StorageVO vo){
    	Object[] ob={vo.getId(),vo.getArea(),vo.getSeat(),vo.getOrder(),vo.getTimeIn(),vo.getTimeOut(),vo.getState(),vo.getName()};
        return ob;   
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
