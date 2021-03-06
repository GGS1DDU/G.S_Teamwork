package elms.presentation.storageui;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import elms.vo.ArrivalListVO;
import elms.vo.CarVO;
import elms.vo.DriverVO;
import elms.vo.IncomeListVO;
import elms.vo.InvoiceVO;
import elms.vo.LoadingListVO;
import elms.vo.LoadingListZZVO;
import elms.vo.RecivalListVO;
import elms.vo.SendingListVO;
import elms.vo.StorageVO;
import elms.vo.TransferListVO;

public class TableModel extends AbstractTableModel {
	protected Vector<Vector<Object>> content = null;
	int count = 0;
	private String[] title_name ;
	
	public TableModel(String[] title) {
		content = new Vector<Vector<Object>>();
		this.count = title.length;
		this.title_name = title;
	}

	// 给每一个需要列表的类写一个类继承自tablemodel，重写addRow方法
	public void addRow(Object[] con) {
		Vector<Object> v = new Vector<Object>(count);
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
    public Object[] changeRow_Inv(InvoiceVO vo){
    	String s=vo.getID().substring(0, 2);
    	if(s.equals("al")) s="到达单";
    	else if(s.equals("il")) s="营业厅收入单";
    	else if(s.equals("ll")) s="营业厅装车单";
    	else if(s.equals("zc")) s="中转中心装车单";
    	else if(s.equals("rl")) s="中转中心接收单";
    	else if(s.equals("sl")) s="快递员派件单";
    	else s="中转中心中转单";
    	Object[] ob={vo.getID(),s,vo.getMaker()};
        return ob;   
    }
    public Object[] changeRow_Arl(ArrivalListVO vo){
    	Object[] ob={vo.getID(),"到达单",vo.getMaker(),vo.getOrder(),vo.getTime(),vo.getPlace(),vo.getFrom(),vo.getState()};
        return ob;   
    }
    public Object[] newchangeRow_Arl(ArrivalListVO vo){
    	Object[] ob={vo.getID(),vo.getAuditState(),vo.getMaker(),vo.getOrder(),vo.getTime(),vo.getState(),vo.getFrom(),vo.getPlace()};
    	return ob;
    }
    public Object[] changeRow_Icl(IncomeListVO vo){
    	Object[] ob={vo.getID(),"营业厅收入单",vo.getMaker(),vo.getOrderID(),vo.getTime(),vo.getPlace(),vo.getCourier(),vo.getPostage()};
        return ob;   
    }
    public Object[] newchangeRow_Icl(IncomeListVO vo){
    	Object[] ob={vo.getID(),vo.getAuditState(),vo.getMaker(),vo.getPostage(),vo.getCourier(),vo.getTime(),vo.getPlace()};
    	return ob;
    }
    public Object[] changeRow_Lol(LoadingListVO vo){
    	Object[] ob={vo.getID(),"营业厅装车单",vo.getMaker(),vo.getOrderNumber(),vo.getTime(),vo.getPlace(),vo.getTransportNumber(),vo.getSupercargo(),vo.getSurpervior(),vo.getShopNumber(),vo.getCarNumber(),vo.getCost()};
        return ob;   
    }
    public Object[] newchangeRow_Lol(LoadingListVO vo){
    	Object[] ob={vo.getID(),vo.getAuditState(),vo.getMaker(),vo.getTime(),vo.getShopNumber(),vo.getTransportNumber(),vo.getArrival(),vo.getCarNumber(),vo.getSurpervior(),vo.getSupercargo(),vo.getCost(),vo.getPlace()};
    	return ob;
    }
    public Object[] changeRow_Lolzz(LoadingListZZVO vo){
    	Object[] ob={vo.getID(),"中转中心装车单",vo.getMaker(),vo.getOrderNumber(),vo.getTime(),vo.getPlace(),vo.getTransportNumber(),vo.getSupercargo(),vo.getSurpervior(),vo.getArrival(),vo.getCarNumber(),vo.getCost()};
        return ob;   
    }
    public Object[] newchangeRow_Lolzz(LoadingListZZVO vo){
    	Object[] ob={vo.getID(),vo.getAuditState(),vo.getMaker(),vo.getTime(),vo.getPlace(),vo.getArrival(),vo.getCost()};
        return ob;   
    }
    public Object[] changeRow_Rcl(RecivalListVO vo){
    	Object[] ob={vo.getID(),"中转中心接收单",vo.getMaker(),vo.getOrderID(),vo.getTime(),vo.getPlace(),vo.getFrom(),vo.getState(),vo.getCenterID()};
        return ob;   
    }
    public Object[] newchangeRow_Rcl(RecivalListVO vo){
    	Object[] ob={vo.getID(),vo.getAuditState(),vo.getMaker(),vo.getTime(),vo.getPlace(),vo.getFrom(),vo.getState()};
        return ob;   
    }
    public Object[] changeRow_Sdl(SendingListVO vo){
    	Object[] ob={vo.getID(),"快递员派件单",vo.getMaker(),vo.getOrderID(),vo.getTime(),vo.getPlace(),vo.getCourier()};
        return ob;   
    }
    public Object[] newchangeRow_Sdl(SendingListVO vo){
    	Object[] ob={vo.getID(),vo.getAuditState(),vo.getMaker(),vo.getOrderID(),vo.getCourier(),vo.getTime()};
    	return ob;
    }
    public Object[] changeRow_Trl(TransferListVO vo){
    	Object[] ob={vo.getID(),"中转中心中转单",vo.getMaker(),vo.getOrderID(),vo.getTime(),vo.getPlace(),vo.getTransportNum(),vo.getSurpervior(),vo.getDeparture(),vo.getSeatNumber(),vo.getArrival(),vo.getCost()};
        return ob;   
    }
    public Object[] newchangeRow_Trl(TransferListVO vo){
    	Object[] ob={vo.getID(),vo.getAuditState(),vo.getMaker(),vo.getTime(),vo.getPlace(),vo.getDeparture(),vo.getArrival(),vo.getCost()};
        return ob;   
    }
    public Object[] newchangeRow_Dri(DriverVO vo){
    	Object[] ob={vo.getID(),vo.getName(),vo.getBirthday(),vo.getIDcard(),vo.getCallNumber(),vo.getGender(),vo.getLicenseDate()};
    	return ob;
    }
    public Object[] newchangeRow_Car(CarVO vo){
    	Object[] ob={vo.getID(),vo.getPlateNumber(),vo.getUsingTime()};
    	return ob;
    }
	// ???使修改的内容生效
	public void setValueAt(Object value, int row, int col) {
		content.get(row).remove(col);
		content.get(row).add(col, value);
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
		return content.get(row).get(col);
	}

	public Class<? extends Object> getColumnClass(int col) {
		return getValueAt(0, col).getClass();
	}
}
