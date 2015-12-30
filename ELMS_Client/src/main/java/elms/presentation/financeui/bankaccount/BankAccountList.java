package elms.presentation.financeui.bankaccount;

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
import elms.businesslogic.financebl.BankAccountManager;
import elms.businesslogic.financebl.inandex.IncomeManager;
import elms.presentation.financeui.inAndEx.income.IncomeList;
import elms.presentation.financeui.inAndEx.income.Income_main;
import elms.presentation.uihelper.TableModel;
import elms.presentation.uihelper.TagPanel;
import elms.vo.BankAccountVO;
import elms.vo.FIncomeVO;
import elms.vo.UserVO;

public class BankAccountList extends JPanel{

	private TableModel model;
	private JTable table;

	private BankAccountManager bam = new BankAccountManager();
	BankAccount_add in_add;
	UserVO vo;

	public static ArrayList<BankAccountVO> arr = new ArrayList<BankAccountVO>();
	private FIncomeVO test = new FIncomeVO("zwq141250192", "in00000001",
			"2015-11-30", 200, "南京市鼓楼营业厅", "张文�?");

	public static void main(String args[]) {
		JFrame jf = new JFrame();
		jf.setBounds(10, 10, 500, 300);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Dimension d = new Dimension(jf.getWidth(), jf.getHeight() - 200);
		UserVO vo = new UserVO();
		BankAccountList im = new BankAccountList(d, vo);
		jf.add(im);
		jf.setVisible(true);

		// im.removeData();

	}

	//把table表格加入到这个panel上，此panel大小根据d确定
	public BankAccountList(Dimension d, final UserVO vo) {
		this.vo = vo;
		arr = bam.getAllAccount();

		setSize(d.width, d.height - 25);
		// setBackground(Color.WHITE);
		setLayout(null);
		setVisible(true);
		setOpaque(false);

		String[] title_name = { "选择", "ID", "账户名称", "余额", "所属银行" };
		model = new TableModel(title_name);
		table = new JTable(model);
		table.setBackground(Color.white);

		TableColumnModel tcm = table.getColumnModel();
		tcm.getColumn(0).setCellEditor(new DefaultCellEditor(new JCheckBox()));
		tcm.getColumn(4).setPreferredWidth(50);
		tcm.getColumn(3).setPreferredWidth(50);
		tcm.getColumn(2).setPreferredWidth(50);
		tcm.getColumn(1).setPreferredWidth(50);
		tcm.getColumn(0).setPreferredWidth(50);

		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(0, 50, d.width - 25, d.height - 100);
		scroll.setBackground(Color.WHITE);
		add(scroll);

		scroll.setOpaque(false);
		scroll.getViewport().setOpaque(false);
		
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
		System.out.println("id:"+id);
		return id;
	}

	public void addAllData(ArrayList<BankAccountVO> vo) {
		for (int i = 0; i < vo.size(); i++) {
			addData(vo.get(i));
		}
	}

	public void addData(BankAccountVO vo) {

		Object[] content = {false,vo.getID(),vo.getName(),new Double(vo.getAmount()),vo.getBank()};
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
//					BankAccountVO vo = bam.inquiryAccount(id);
					ResultMessage rm = bam.deleteAccount(id);
					if(rm==ResultMessage.Success){
						ArrayList<BankAccountVO> in = BankAccount_main.arr;
						int j = 0;
						for(; j < in.size(); j++){
							if(in.get(j).getID().equals(id)){
								BankAccount_main.arr.remove(j);
								
								break;
							}
						}
						deleteIndex.add(i);
						removeSuccess = true;
//						model.removeRow(i);
						
					}else if(rm==ResultMessage.changeFailed){
						JOptionPane.showMessageDialog(null, id+":银行账户余额不为0");
						break;
					}else if(rm==ResultMessage.lessThanMin){
						JOptionPane.showMessageDialog(null,id+":找不到对应银行账号","失败",JOptionPane.ERROR_MESSAGE);
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
