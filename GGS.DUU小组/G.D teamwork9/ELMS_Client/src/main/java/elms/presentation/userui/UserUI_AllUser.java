package elms.presentation.userui;
import javax.swing.*;

import elms.businesslogic.userbl.UserManage;
import elms.vo.UserVO;

import java.util.*;
import java.awt.*;

public class UserUI_AllUser extends JFrame {
	//rowData用来存放行数据
	//columnNames存放列名
	Vector rowData,columnNames;
	JTable jt=null;
	JScrollPane jsp=null;
	
	
	public UserUI_AllUser(){
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
		jt=new JTable(rowData,columnNames);
		
		jsp=new JScrollPane(jt);
		
		this.add(jsp);
		this.setVisible(true);
		this.setSize(800, 1000);
		this.setDefaultCloseOperation(JFrame. HIDE_ON_CLOSE);
	}

}
