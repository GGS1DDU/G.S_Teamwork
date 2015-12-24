package elms.presentation.userui;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import elms.businesslogic.userbl.UserManage;
import elms.vo.UserVO;
/**
 * User的数据模型。
 * @author ZWH
 *
 */
public class UserModel extends AbstractTableModel{
	Vector rowData,columnNames;
	
	public UserModel(String name){
		ArrayList<UserVO> arr=new ArrayList<UserVO>();
		UserManage um=new UserManage();
		arr=um.findall();
		
		columnNames=new Vector();
		columnNames.add("账户");
		columnNames.add("密码");
		columnNames.add("姓名");
		columnNames.add("职务");
		
		rowData=new Vector();
		for(int i=1;i<arr.size();i++){
			if(arr.get(i).getName().equals(name)){
				Vector hang=new Vector();
				hang.add(arr.get(i).getId());
				hang.add(arr.get(i).getPassword());
				hang.add(arr.get(i).getName());
				hang.add(arr.get(i).getJob());
				rowData.add(hang);
			}
		}
		
	}
	
	public UserModel(){
		ArrayList<UserVO> arr=new ArrayList<UserVO>();
		UserManage um=new UserManage();
		arr=um.findall();
		
		columnNames=new Vector();
		//设置列名
		columnNames.add("账户");
		columnNames.add("密码");
		columnNames.add("姓名");
		columnNames.add("职务");

		rowData=new Vector();
		//rowData可以存放多行
		for(int i=1;i<arr.size();i++){
			Vector hang=new Vector();
			hang.add(arr.get(i).getId());
			hang.add(arr.get(i).getPassword());
			hang.add(arr.get(i).getName());
			hang.add(arr.get(i).getJob());
			rowData.add(hang);
			
		}			
		
	}
	
	
	@Override
	public String getColumnName(int column) {
		return (String)this.columnNames.get(column);
	}


	public int getRowCount() { 
		return this.rowData.size();
	}
	public int getColumnCount() {
		return this.columnNames.size();
	}
	public Object getValueAt(int rowIndex, int columnIndex) {
		return ((Vector)this.rowData.get(rowIndex)).get(columnIndex);
	}			
}
