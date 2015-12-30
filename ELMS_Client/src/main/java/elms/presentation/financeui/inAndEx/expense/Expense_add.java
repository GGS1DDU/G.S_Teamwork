package elms.presentation.financeui.inAndEx.expense;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import elms.businesslogic.ResultMessage;
import elms.businesslogic.financebl.BankAccountManager;
import elms.businesslogic.financebl.inandex.ExpenseManager;
import elms.presentation.uihelper.ScreenSize;
import elms.vo.FExpenseVO;
import elms.vo.UserVO;

public class Expense_add extends JFrame{

	private int screenWidth = ScreenSize.screenWidth;
	private int screenHeight = ScreenSize.screenHeight;
	
	private JPanel infoPanel;
	private JPanel bp;

	private JLabel jl1;  //id
	private JLabel jl2;  //支出金额
	private JLabel jl3;  //支出类型
	private JLabel jl4;  //支出账户
	private JLabel jl5;  //支出人员
	
	private JTextField id;
	private JComboBox<String> type;
	private JTextField amount;
	private JComboBox<String> account;
	private JTextField executor;
	
	private JButton ok;
	private JButton cancel;
	
	private UserVO u_vo;
	private ExpenseList exList;
	
	private BankAccountManager bam = new BankAccountManager();
	private ExpenseManager em = new ExpenseManager();
	
	public static void main(String[] args){
		UserVO vo = new UserVO();
//		JFrame jf = new Expense_add(vo);
	}
	
	public Expense_add(ExpenseList list,UserVO vo){
		this.exList = list;
		this.u_vo = vo;
		setLayout(null);
		setTitle("新建支出");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(screenWidth/3,screenHeight/8,screenWidth/3,screenHeight/2+100);
		
		addLabels();
		addButtons();
		
		setVisible(true);
	}
	
	private void addLabels(){
		infoPanel = new JPanel();
		infoPanel.setBounds(0, 0, this.getWidth(), this.getHeight()*5/6-50);
		infoPanel.setLayout(null);
		add(infoPanel);
//		infoPanel.setBackground(Color.white);
		
		jl1 = new JLabel("ID");
		jl2 = new JLabel("支出金额");
		jl3 = new JLabel("支出类型");
		jl4 = new JLabel("支出账户");
		jl5 = new JLabel("支出人员");
		
		infoPanel.add(jl1);
		infoPanel.add(jl2);
		infoPanel.add(jl3);
		infoPanel.add(jl4);
		infoPanel.add(jl5);
		
		jl1.setBounds(infoPanel.getWidth()/5,infoPanel.getHeight()/6,80,30);
		jl2.setBounds(infoPanel.getWidth()/5,infoPanel.getHeight()*2/6,80,30);
		jl3.setBounds(infoPanel.getWidth()/5,infoPanel.getHeight()*3/6,80,30);
		jl4.setBounds(infoPanel.getWidth()/5,infoPanel.getHeight()*4/6,80,30);
		jl5.setBounds(infoPanel.getWidth()/5,infoPanel.getHeight()*5/6,80,30);
		
		id = new JTextField();
		amount = new JTextField();
		
		String[] typeList = {"人员工资","运费","租金"};
		type = new JComboBox<String>(typeList);
		
		String[] accountList = bam.getNameList();
		account = new JComboBox<String>(accountList);
		
		executor = new JTextField();
		
		id.setBounds(jl1.getX()+jl1.getWidth(),jl1.getY(),140,30);
		amount.setBounds(jl2.getX()+jl2.getWidth(),jl2.getY(),140,30);
		type.setBounds(jl3.getX()+jl3.getWidth(),jl3.getY(),140,30);
		account.setBounds(jl4.getX()+jl4.getWidth(),jl4.getY(),140,30);
		executor.setBounds(jl5.getX()+jl5.getWidth(),jl5.getY(),140,30);
		
		infoPanel.add(id);
		infoPanel.add(amount);
		infoPanel.add(type);
		infoPanel.add(account);
		infoPanel.add(executor);
	}
	
	private void addButtons(){
		bp = new JPanel();
		bp.setBounds(0, infoPanel.getHeight(), this.getWidth(), this.getHeight()-infoPanel.getHeight());
		bp.setLayout(null);
		add(bp);
		
		int w = bp.getWidth();
		int h = bp.getHeight();
		
		ok = new JButton("确定");
		cancel = new JButton("取消");
		ok.setBounds(w/5,h/6,80,30);
		cancel.setBounds(w*3/5,h/6,80,30);
		
		bp.add(ok);
		bp.add(cancel);
		
		ok.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				
				if(!isValidID()){
					JOptionPane.showMessageDialog(null, "ID输入格式错误，请重新输入","失败",JOptionPane.ERROR_MESSAGE);
				}else if(!isValidFormat(amount.getText())){
					JOptionPane.showMessageDialog(null, "请在支出金额一栏输入小数格式的数据！","失败",JOptionPane.INFORMATION_MESSAGE);

				}else if(!isValidNum(Double.parseDouble(amount.getText()))){
					JOptionPane.showMessageDialog(null, "请在支出金额一栏输入0-1000之内的小数！","失败",JOptionPane.INFORMATION_MESSAGE);
				}
				else{
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
					String time = sdf.format(new Date()); 
					FExpenseVO vo = new FExpenseVO(account.getSelectedItem().toString(),id.getText(),
						type.getSelectedItem().toString(),time,Double.parseDouble(amount.getText()),
						u_vo.getId(),executor.getText());
					ResultMessage rm = em.addExpense(vo);
					if(rm==ResultMessage.findIDFailed){
						JOptionPane.showMessageDialog(null, "已存在对应id，请重新输入！","失败",JOptionPane.ERROR_MESSAGE);
					
					}else if(rm==ResultMessage.lessThanMin){
						JOptionPane.showMessageDialog(null, "该银行账户余额不足","失败",JOptionPane.ERROR_MESSAGE);
					}else{
						exList.addData(vo);
						JOptionPane.showMessageDialog(null, "成功新建！","成功",JOptionPane.INFORMATION_MESSAGE);			
						Expense_add.this.dispose();
					}
				}
			
			}
			
		});
		
		cancel.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				Expense_add.this.dispose();
			}
			
		});
	}
	
	//输入格式ex+8位数字
	private boolean isValidID(){
		String s = id.getText();
		if(s.length()==10&&s.substring(0, 2).equals("ex")){
			Pattern pattern = Pattern.compile("[0-9]*");
			Matcher isNum = pattern.matcher(s.substring(2, s.length()));
			if( isNum.matches() ){
				return true;
			}
		}
		return false;
	}
	//检查输入的金额格式是否正确
	private boolean isValidFormat(String s){
		try{
			Double.parseDouble(s);
			return true;
		}catch(NumberFormatException e){
			return false;
		}
	}
	//检查输入的金额是否符合常规
	private boolean isValidNum(double d){
		if(d>=0&&d<=1000){
			return true;
		}else{
			return false;
		}
	}
	
}
