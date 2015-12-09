package elms.presentation.managerui.staff;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import elms.businesslogic.managerbl.StaffManager;
import elms.presentation.managerui.staff.staffhelper.StaffJobPanel;
import elms.presentation.uihelper.CheckFormat;
import elms.presentation.uihelper.ScreenSize;
import elms.vo.StaffVO;

public class StaffUI_editSalary extends JFrame {

	int screenWidth = ScreenSize.screenWidth;
	int screenHeight = ScreenSize.screenHeight;

	private StaffManager sm = new StaffManager();
	private CheckFormat cf = new CheckFormat();
	private ArrayList<StaffVO> arr = new ArrayList<StaffVO>();
	private StaffJobPanel job;
	private JPanel buttonPanel;

	public static void main(String[] args) {
		JFrame jf = new StaffUI_editSalary();
		jf.setVisible(true);
	}

	public StaffUI_editSalary() {
		setTitle("修改职务工资");
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(screenWidth / 3, screenHeight / 5, screenWidth / 3,
				screenHeight / 2);

		Dimension d = new Dimension(this.getWidth(), this.getHeight() - 100);
		job = new StaffJobPanel(d);
		job.setLocation(0, 0);
		add(job);

		job.removeOrganization();
		job.setSize(d.width, d.height - 80);

		buttonPanel = new JPanel();
		buttonPanel.setLayout(null);
		buttonPanel.setBounds(0, job.getHeight(), this.getWidth(),
				this.getHeight() - job.getHeight());
		add(buttonPanel);
		
		addButton();

	}

	private void addButton() {
		JButton save = new JButton("保存");
		JButton back = new JButton("返回");
		
		buttonPanel.add(save);
		buttonPanel.add(back);
		save.setBounds(buttonPanel.getWidth()/4,20,80,30);
		back.setBounds(buttonPanel.getWidth()*2/4,20,80,30);

		save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				if (!cf.checkDouble(job.getESalary())) {
					JOptionPane.showMessageDialog(null, "请输入一个小数类型的基本工资！");
				} else if (!cf.checkDouble(job.getRate())) {

					JOptionPane.showMessageDialog(null,
							"请输入一个小数类型的" + job.getSalaryStrategy() + "!");

				} else {
					String e = job.getESalary();
					double salary = Double.parseDouble(e);
					if (salary < 0 || salary > 10000) {
						JOptionPane.showMessageDialog(null, "请重新输入工资数！");
					} else {
						
						if(rightFormat()){
							execute();
						};
						
					}

				}
			}

		});
		
		back.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				StaffUI_editSalary.this.dispose();
			}
			
		});
	}

	private boolean rightFormat() {
		boolean right = false;
		double rate = Double.parseDouble(job.getRate());
		switch (job.getSalaryStrategy()) {
		case "提成":
			if (rate < 0 || rate > 1) {
				JOptionPane.showMessageDialog(null, "请输入0-1范围内的提成比例！");
			}else{
				right = true;
			}
			break;
		case "计次":
			if (rate < 0 || rate > 600) {
				JOptionPane.showMessageDialog(null, "请输入0-600范围内的每次单价!");
			}else{
				right = true;
			}
			break;
		default: right = true;
		}
		return right;
	}
	
	private void execute(){
		arr = sm.findByJob(job.getJob());
		String strategy = job.getSalaryStrategy();
		double es = Double.parseDouble(job.getESalary());
		double r = Double.parseDouble(job.getRate());
		for (int i = 0; i < arr.size(); i++) {
			StaffVO vo = arr.get(i);
			vo.setSalaryStrategy(strategy);
			vo.setEssentialSalary(es);
			vo.setRate(r);
			System.out.println(vo.getName());
			sm.updateStaff(vo);
			
		}
		JOptionPane.showMessageDialog(null, "更改成功！");
	}
}
