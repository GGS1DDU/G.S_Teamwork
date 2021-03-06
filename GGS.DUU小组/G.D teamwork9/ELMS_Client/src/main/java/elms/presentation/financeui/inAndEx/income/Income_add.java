package elms.presentation.financeui.inAndEx.income;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import elms.businesslogic.ResultMessage;
import elms.businesslogic.financebl.BankAccountManager;
import elms.businesslogic.financebl.inandex.IncomeManager;
import elms.presentation.uihelper.ScreenSize;
import elms.vo.FIncomeVO;
import elms.vo.UserVO;

public class Income_add extends JFrame{

	int screenWidth = ScreenSize.screenWidth;
	int screenHeight = ScreenSize.screenHeight;
	boolean addSuccess = false;
	
	FIncomeVO vo;
	BankAccountManager bam = new BankAccountManager();
	IncomeManager im = new IncomeManager();
	
//	Table_Model model = new Table_Model();
	
	JLabel j1;
	JLabel j2;
	JLabel j3;
	JLabel j4;
	JLabel j5;
	
	JPanel bp;
	
	JButton ok;
	JButton back;
	
	JTextField id;
	JTextField amount;
	JComboBox<String> hall;
	
	JComboBox<String> bankName;
	
	public Income_add(final UserVO u_vo){
		
		
		setTitle("新建收入项");
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(screenWidth/3,screenHeight/8,screenWidth/3,screenHeight/2);
		
		j1 = new JLabel("ID:");
		j2 = new JLabel("收入金额:");
		j3 = new JLabel("收入营业厅:");
		j4 = new JLabel("入帐账号:");
		
		j1.setBounds(this.getWidth()/5,this.getHeight()/7,80,30);
		add(j1);
		j2.setBounds(this.getWidth()/5,this.getHeight()*2/7,80,30);
		add(j2);
		j3.setBounds(this.getWidth()/5,this.getHeight()*3/7,80,30);
		add(j3);
		j4.setBounds(this.getWidth()/5,this.getHeight()*4/7,80,30);
		add(j4);
		
		id = new JTextField();
		id.setBounds(this.getWidth()/5+80,this.getHeight()/7,140,30);
		add(id);
		
		amount = new JTextField();
		amount.setBounds(this.getWidth()/5+80,this.getHeight()*2/7,140,30);
		add(amount);
		
		String[] hallList = {"南京市鼓楼营业厅","南京市仙林营业厅","上海市营业厅"}; 
		hall = new JComboBox<String>(hallList);
		hall.setBounds(this.getWidth()/5+80,this.getHeight()*3/7,140,30);
		add(hall);
		
		String[] accountList = bam.getNameList();
		bankName = new JComboBox<String>(accountList);
		bankName.setBounds(this.getWidth()/5+80,this.getHeight()*4/7,140,30);
		add(bankName);
		
		bp = new JPanel();
		bp.setBounds(0, this.getHeight()-100, this.getWidth(), 100);
		bp.setLayout(null);
		
		add(bp);
		
		ok = new JButton("确定");
		ok.setBounds(bp.getWidth()/4-20,bp.getHeight()/6,80,bp.getHeight()/3);
		bp.add(ok);
		
		back = new JButton("返回");
		back.setBounds(bp.getWidth()/2+50,bp.getHeight()/6,80,bp.getHeight()/3);
		bp.add(back);
		
		ok.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				addSuccess = false;
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//				DateFormat df = DateFormat.getDateInstance();
				String time = sdf.format(new Date());
				FIncomeVO vo = new FIncomeVO(bankName.getSelectedItem().toString(),id.getText(),
						time,Double.parseDouble(amount.getText()),hall.getSelectedItem().toString(),u_vo.getId());
				
				ResultMessage rm = im.addIncome(vo);
				if(rm==ResultMessage.Success){
//					addSuccess = true;
//					income_add.this.vo = vo;
				
					Income_main.arr.add(vo);
					JOptionPane.showMessageDialog(null, "成功新建收入项","成功",JOptionPane.INFORMATION_MESSAGE);
				}else if(rm==ResultMessage.findIDFailed){
					JOptionPane.showMessageDialog(null,"已存在对应id，请重新输入！","失败",JOptionPane.ERROR_MESSAGE);
				}
			}
			
		});
		
		back.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				Income_add.this.dispose();
			}
			
		});
		setVisible(true);
	}
	
	public boolean addSuccess(){
		return addSuccess;
	}
}
