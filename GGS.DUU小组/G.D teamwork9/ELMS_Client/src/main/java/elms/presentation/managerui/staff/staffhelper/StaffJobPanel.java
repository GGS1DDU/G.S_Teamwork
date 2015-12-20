package elms.presentation.managerui.staff.staffhelper;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import elms.presentation.managerui.staff.StaffUI_main;



public class StaffJobPanel extends JPanel{

	private JLabel jl4;
	private JLabel jl5;
	
	protected JComboBox<String> job;
	protected JTextField essentialSalary;
	protected JComboBox<String> salaryStrategy;
	protected JTextField rate;
	protected JTextField organization;// 这一栏应该用comboBox，但是现在机构信息缺失，不能获取所有的机构名称

	private String[] jobList = StaffUI_main.jobList;
	
	public StaffJobPanel(Dimension d){
		
		job = new JComboBox<String>(jobList);
		essentialSalary = new JTextField();
		String[] strategy = { "提成", "计次", "月薪" };
		salaryStrategy = new JComboBox<String>(strategy);
		rate = new JTextField();
		organization = new JTextField();
		
		setLayout(null);
		setBounds(0, 0,d.width, d.height);
		
		setBorder(new TitledBorder(new EtchedBorder()));
		// jobInfo.setBackground(Color.WHITE);

		JLabel jl1 = new MyLabel("职务", this);
		JLabel jl2 = new MyLabel("基本工资", this);
		JLabel jl3 = new MyLabel("工资计算方式", this);
		jl4 = new MyLabel("提成比例",this);
		jl5 = new MyLabel("所属机构", this);

		int w = this.getWidth();
		int h = this.getHeight();
		jl1.setLocation(w / 10, h / 4 - 20);
		jl2.setLocation(w * 6 / 10, jl1.getY());
		jl3.setLocation(jl1.getX(), h * 2 / 4 - 10);
		jl3.setSize(80, 30);
		jl4.setLocation(jl2.getX(), jl3.getY()); jl4.setBackground(Color.WHITE);
		jl5.setLocation(jl1.getX(), h * 3 / 4);

		job.setBounds(jl1.getWidth() + jl1.getX(), jl1.getY(), 150, 30);
		essentialSalary.setBounds(jl2.getWidth() + jl2.getX(), jl2.getY(), 70,
				30);
		salaryStrategy.setBounds(jl3.getX() + jl3.getWidth(), jl3.getY(), 100,
				30);
		
		organization
				.setBounds(jl5.getWidth() + jl5.getX(), jl5.getY(), 150, 30);

		add(rate);
		add(organization);
		add(salaryStrategy);
		add(essentialSalary);
		add(job);

		
		salaryStrategy.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				String type = salaryStrategy.getSelectedItem().toString();
				jl4.setSize(70,30);
				rate.setText("");
				rate.setEnabled(true);
				if (type.equals("提成")) {
					
					jl4.setText("提成比例");
					rate.setBounds(jl4.getX()+jl4.getWidth(),jl4.getY(),70,30);
				} else if (type.equals("计次")) {
					
					jl4.setText("每次单价(元)");
					jl4.setSize(80,30);
					rate.setBounds(jl4.getX()+jl4.getWidth(),jl4.getY(),70,30);
				}else{
					jl4.setText("");
					rate.setText("0.0");
					rate.setBounds(jl4.getX()+jl4.getWidth(),jl4.getY(),70,30);
					rate.setEnabled(false);
				}
			}
		});
	}
	
	public void removeOrganization(){
		this.remove(jl5);
		this.remove(organization);
	}
	
	public String getJob(){
		return job.getSelectedItem().toString();
	}
	
	public String getESalary(){
		return essentialSalary.getText();
	}
	
	public String getSalaryStrategy(){
		return salaryStrategy.getSelectedItem().toString();
	}
	
	public String getRate(){
		return rate.getText();
	}
}
