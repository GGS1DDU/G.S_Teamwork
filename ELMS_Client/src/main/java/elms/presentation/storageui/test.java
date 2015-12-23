package elms.presentation.storageui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.TableColumnModel;

import elms.vo.StorageVO;

public class test extends JFrame{
	private TableModel model;
	private JTable table;
	Toolkit kit=Toolkit.getDefaultToolkit();
	Dimension screenSize=kit.getScreenSize();
	int screenWidth=(int) screenSize.getWidth();
	int screenHeight=(int)screenSize.getHeight();
	public static void main(String[] args) {
		new test();
	}
public test(){
	setLayout(null);
	setTitle("库存管理");
	setResizable(false);
	setSize(screenWidth/2,3*screenHeight/4);
	setLocation(screenWidth/4, screenHeight/8);
	setVisible(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	String[] title_name = { "ID", "区域", "位置", "订单号", "入库时间", "出库时间",
	"状态","仓库"};
	model = new TableModel(title_name);
	final Object[] arr={"000125","航运区","A2D3S4","0000015487","2015-12-13 15:02:01","2015-12-14 14:01:03","OUT","南京"};
	model.addRow(arr);
StorageVO vo=new StorageVO("000142","火车区","A2F4S3","0000000003","2015-01-02 12:03:05","2015-11-01 12:01:04","IN","北京");
	table = new JTable(model);
	model.addRow(model.changeRow(vo));
	table.setBackground(Color.white);
	TableColumnModel tcm = table.getColumnModel();
	tcm.getColumn(7).setPreferredWidth(20);
	tcm.getColumn(6).setPreferredWidth(20);
	tcm.getColumn(5).setPreferredWidth(100);	
	tcm.getColumn(4).setPreferredWidth(100);
	tcm.getColumn(3).setPreferredWidth(60);
	tcm.getColumn(2).setPreferredWidth(40);
	tcm.getColumn(1).setPreferredWidth(40);
	tcm.getColumn(0).setPreferredWidth(40);
JScrollPane scroll = new JScrollPane(table);
scroll.setBounds(0, 50, this.getWidth() - 25, this.getHeight()/2 - 100);
scroll.setBackground(Color.WHITE);
add(scroll);

JButton jb= new JButton("delete");
jb.addActionListener(new ActionListener(){
  String s;
	public void actionPerformed(ActionEvent arg0) {
		System.out.println(model.getRowCount())
		model.removeAllRows(1);
		table.updateUI();
		if(table.getSelectedColumn()!=-1){
		s=(String) model.getValueAt(table.getSelectedRow(), 3);
		;}
		//model.removeAllRows(model.getRowCount()-1);
		//arr[0]="12";arr[1]="12";arr[2]="12";arr[3]="12";arr[4]="12";arr[5]="12";arr[6]="12";
	}
	
});
add(jb); jb.setBounds(50,this.getHeight()/2,100,30);
}
}