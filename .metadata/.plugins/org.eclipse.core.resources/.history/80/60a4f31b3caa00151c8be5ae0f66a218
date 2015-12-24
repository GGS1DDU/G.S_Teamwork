package elms.presentation.managerui.staff;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import elms.businesslogic.financebl.inandex.ExpenseManager;
import elms.businesslogic.managerbl.StaffManager;
import elms.presentation.financeui.inAndEx.expense.Expense_edit;
import elms.presentation.financeui.inAndEx.expense.Expense_find;
import elms.presentation.managerui.staff.staffhelper.GetIdentifier;
import elms.presentation.managerui.staff.staffhelper.StaffList;
import elms.presentation.uihelper.CheckFormat;
import elms.presentation.uihelper.ScreenSize;
import elms.vo.FExpenseVO;
import elms.vo.StaffVO;
import elms.vo.UserVO;

public class StaffUI_find extends JFrame{

	private int screenWidth = ScreenSize.screenWidth;
	private int screenHeight = ScreenSize.screenHeight;
	
	private JLabel label;
	private JTextField id_f;
	
	private JButton ensure;
	private JButton back;
	
	private StaffManager sm = new StaffManager();
	private GetIdentifier gi = new GetIdentifier();
	private CheckFormat check;
	private UserVO uservo;
	private StaffList staffList;
	
	public StaffUI_find(StaffList list){
		this.staffList = list;
		check = new CheckFormat();
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(screenWidth/4,screenHeight/3,screenWidth/2,screenHeight/4);
		
		
		
		label = new JLabel("ID:");
		label.setBounds(this.getWidth()/4,this.getHeight()/5,40,30);
		label.setBackground(Color.BLACK);
		add(label);
	
		id_f = new JTextField();
		id_f.setBounds(this.getWidth()/4+50,this.getHeight()/5,this.getWidth()*2/5,30);
//		id.setVisible(true);
		add(id_f);
		
		
		ensure = new JButton("确定");
		ensure.setBounds(this.getWidth()/5,3*this.getHeight()/5,70,20);
		add(ensure);
		
		back = new JButton("返回");
		back.setBounds(this.getWidth()*3/5+50,3*this.getHeight()/5,70,20);
		add(back);
		
		ensure.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				
				if(!check.checkID(id_f.getText(),8)){
					JOptionPane.showMessageDialog(null, "输入id格式错误！","失败",JOptionPane.ERROR_MESSAGE);
				}else{
				StaffVO vo = sm.findStaff(id_f.getText());
				JFrame edit = new StaffUI_edit(staffList,vo);
				edit.setVisible(true);
				StaffUI_find.this.dispose();
				}
			}
			
		});
		
		back.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				StaffUI_find.this.dispose();
			}
		});
	}
	
}
