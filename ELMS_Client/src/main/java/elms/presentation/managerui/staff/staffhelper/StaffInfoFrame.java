package elms.presentation.managerui.staff.staffhelper;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import elms.businesslogic.ResultMessage;
import elms.businesslogic.managerbl.StaffManager;
import elms.presentation.managerui.staff.StaffUI_main;
import elms.presentation.managerui.staff.StaffUI_add;
import elms.presentation.uihelper.CheckFormat;
import elms.presentation.uihelper.ScreenSize;
import elms.presentation.uihelper.TagPanel;
import elms.vo.StaffVO;

public class StaffInfoFrame extends JFrame {
	private int screenWidth = ScreenSize.screenWidth;
	private int screenHeight = ScreenSize.screenHeight;

	private JPanel personInfo;
	private JPanel jobInfo;

	private JPanel tag1; // 在personInfo面板之上显示“基本信息”
	private JPanel tag2; // 在jobInfo面板之上显示“职员信息";

	private JLabel jl4;// 根据所选的职位显示计算的rate

	protected JTextField id;
	protected JTextField name;
	protected JComboBox<String> gender;
	protected JTextField birthday;
	protected JTextField idCard;
	protected JTextField phone;
	protected JTextField address;

	protected JComboBox<String> job;
	protected JTextField essentialSalary;
	protected JComboBox<String> salaryStrategy;
	protected JTextField rate;
	protected JTextField organization;// 这一栏应该用comboBox，但是现在机构信息缺失，不能获取所有的机构名称

	private String[] jobList = StaffUI_main.jobList;
	private CheckFormat check = new CheckFormat();
	private StaffManager sm = new StaffManager();
	private GetIdentifier gi = new GetIdentifier();

	public static void main(String[] args) {
//		JFrame jf = new StaffUI_add();
//		jf.setVisible(true);
	}

	public StaffInfoFrame() {
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(screenWidth / 3, screenHeight / 8, screenWidth / 2,
				screenHeight * 3 / 4);
		setTitle("新增职员");
		setResizable(false);

		// pLabel = new JLabel("个人信息");
		// pLabel.setBounds(10,0,80,30);
		// add(pLabel);

		tag1 = new TagPanel("职务信息");
		tag1.setBounds(10, 0, 80, 30);
		add(tag1);
		job = new JComboBox<String>(jobList);
		essentialSalary = new JTextField();
		String[] strategy = { "提成", "计次", "月薪" };
		salaryStrategy = new JComboBox<String>(strategy);
		rate = new JTextField();
		organization = new JTextField();
		addJobInfo();

		tag2 = new TagPanel("个人信息");
		tag2.setBounds(10, jobInfo.getHeight() + tag1.getHeight(), 80, 30);
		add(tag2);

		id = new JTextField();
		name = new JTextField();
		idCard = new JTextField();
		String[] genderList = { "男", "女" };
		gender = new JComboBox<String>(genderList);
		birthday = new JTextField();
		phone = new JTextField();
		address = new JTextField();

		addPersonInfo();

	}

	private void addPersonInfo() {
		personInfo = new JPanel();
		personInfo.setBounds(0, jobInfo.getHeight() + tag1.getHeight() * 2,
				this.getWidth(), this.getHeight() / 2 - 20);
		personInfo.setLayout(null);
		add(personInfo);
		personInfo.setBorder(new TitledBorder(new EtchedBorder()));
		// personInfo.setBackground(Color.WHITE);

		int w = personInfo.getWidth();
		int h = personInfo.getHeight();

		JLabel jl1 = new MyLabel("员工编号：", personInfo);
		JLabel jl2 = new MyLabel("姓名:", personInfo);
		JLabel jl3 = new MyLabel("身份证号码:", personInfo);
		JLabel jl4 = new MyLabel("性别:", personInfo);
		JLabel jl5 = new MyLabel("出生年月:", personInfo);
		JLabel jl6 = new MyLabel("联系电话:", personInfo);
		JLabel jl7 = new MyLabel("家庭住址:", personInfo);

		jl1.setLocation(w / 9 - 10, h / 5 - 20);
		jl2.setLocation(w * 4 / 8, jl1.getY());
		jl3.setLocation(jl1.getX(), h * 2 / 5 - 20);
		jl4.setLocation(jl2.getX() + 50, jl3.getY());
		jl5.setLocation(jl1.getX(), h * 3 / 5 - 20);
		jl6.setLocation(jl2.getX(), jl5.getY());
		jl7.setLocation(jl1.getX(), h * 4 / 5 - 20);
		//
		personInfo.add(id);
		personInfo.add(name);
		personInfo.add(idCard);
		personInfo.add(gender);
		personInfo.add(birthday);
		personInfo.add(phone);
		personInfo.add(address);

		// id.setSize(140,30);
		id.setBounds(jl1.getX() + jl1.getWidth(), jl1.getY(), 100, 30);
		name.setBounds(jl2.getX() + jl2.getWidth(), jl2.getY(), 100, 30);
		idCard.setBounds(jl3.getX() + jl3.getWidth(), jl3.getY(), 140, 30);
		gender.setBounds(jl4.getX() + jl4.getWidth(), jl4.getY(), 50, 30);
		birthday.setBounds(jl5.getX() + jl5.getWidth(), jl5.getY(), 100, 30);
		phone.setBounds(jl6.getX() + jl6.getWidth(), jl6.getY(), 120, 30);
		address.setBounds(jl7.getX() + jl7.getWidth(), jl7.getY(),
				w - (jl7.getX() + jl7.getWidth() + 30), 30);



		idCard.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void changedUpdate(DocumentEvent arg0) {
				// TODO 自动生成的方法存根
				if (check.checkNum(idCard.getText(), 18)) {
					// 自动生成出生年月
					String year = idCard.getText().substring(6, 10);
					String month = idCard.getText().substring(10, 12);
					birthday.setText(year + "-" + month);

					// 自动选择性别
					int i = Integer
							.parseInt(idCard.getText().substring(16, 17));
					if (i % 2 == 0) {
						gender.setSelectedIndex(1);
					} else {
						gender.setSelectedIndex(0);
					}
				}
			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				// TODO 自动生成的方法存根
				if (check.checkNum(idCard.getText(), 18)) {
					String year = idCard.getText().substring(6, 10);
					String month = idCard.getText().substring(10, 12);
					birthday.setText(year + "-" + month);

					int i = Integer
							.parseInt(idCard.getText().substring(16, 17));
					if (i % 2 == 0) {
						gender.setSelectedIndex(1);
					} else {
						gender.setSelectedIndex(0);
					}
				}
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				// TODO 自动生成的方法存根
				birthday.setText("");
			}

		});
	}

	private void addJobInfo() {
		jobInfo = new JPanel();
		jobInfo.setLayout(null);
		jobInfo.setBounds(0, 30, this.getWidth(), 150);
		add(jobInfo);
		jobInfo.setBorder(new TitledBorder(new EtchedBorder()));
		// jobInfo.setBackground(Color.WHITE);

		JLabel jl1 = new MyLabel("职务", jobInfo);
		JLabel jl2 = new MyLabel("基本工资", jobInfo);
		JLabel jl3 = new MyLabel("工资计算方式", jobInfo);
		jl4 = new MyLabel("提成比例", jobInfo);
		JLabel jl5 = new MyLabel("所属机构", jobInfo);

		int w = jobInfo.getWidth();
		int h = jobInfo.getHeight();
		jl1.setLocation(w / 10, h / 4 - 20);
		jl2.setLocation(w * 6 / 10, jl1.getY());
		jl3.setLocation(jl1.getX(), h * 2 / 4 - 10);
		jl3.setSize(80, 30);
		jl4.setLocation(jl2.getX(), jl3.getY());
		jl4.setBackground(Color.WHITE);
		jl5.setLocation(jl1.getX(), h * 3 / 4);

		job.setBounds(jl1.getWidth() + jl1.getX(), jl1.getY(), 150, 30);
		essentialSalary.setBounds(jl2.getWidth() + jl2.getX(), jl2.getY(), 70,
				30);
		salaryStrategy.setBounds(jl3.getX() + jl3.getWidth(), jl3.getY(), 100,
				30);

		organization
				.setBounds(jl5.getWidth() + jl5.getX(), jl5.getY(), 150, 30);

		jobInfo.add(rate);
		jobInfo.add(organization);
		jobInfo.add(salaryStrategy);
		jobInfo.add(essentialSalary);
		jobInfo.add(job);

		
		
		salaryStrategy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				String type = salaryStrategy.getSelectedItem().toString();
				jl4.setSize(70, 30);
				rate.setText("");
				rate.setEnabled(true);
				if (type.equals("提成")) {

					jl4.setText("提成比例");
					rate.setBounds(jl4.getX() + jl4.getWidth(), jl4.getY(), 70,
							30);
				} else if (type.equals("计次")) {

					jl4.setText("每次单价(元)");
					jl4.setSize(80, 30);
					rate.setBounds(jl4.getX() + jl4.getWidth(), jl4.getY(), 70,
							30);
				} else {
					jl4.setText("");
					rate.setText("0.0");
					rate.setBounds(jl4.getX() + jl4.getWidth(), jl4.getY(), 70,
							30);
					rate.setEnabled(false);
				}
			}
		});

	}

	protected Dimension getButtonPanelSize() {
		Dimension d = new Dimension(this.getWidth(), this.getHeight());
		return d;
	}

	protected Dimension getButtonPanelLocation() {
		Dimension d = new Dimension(0, personInfo.getHeight()
				+ jobInfo.getHeight() + tag1.getHeight() + tag2.getHeight());
		return d;
	}

	//检查输入是否符合条件
	protected boolean checkInput() {
		String identify = gi.getIdentifier(job.getSelectedItem().toString());
		boolean right = false;

		if (identify == null) {
			JOptionPane.showMessageDialog(null, "请选择一个职业！");
		} else {
			if (!check.checkID(id.getText(), identify, 8)) {
				JOptionPane.showMessageDialog(null, "员工编号输入错误，请重新输入！");
			} else if (!check.checkNum(idCard.getText(), 18)) {
				JOptionPane.showMessageDialog(null, "身份证号输入格式错误，请重新输入18位的数字！");
			} else if (!check.checkDouble(essentialSalary.getText())) {
				JOptionPane.showMessageDialog(null, "请在基本工资一栏中输入一个小数！");
			} else if (!(check.checkNum(phone.getText(), 11) || check.checkNum(
					phone.getText(), 7))) {
				// 手机号11位，电话号码7位
				JOptionPane.showMessageDialog(null, "请输入正确的手机号码或者电话号码！");
			}  else {
				if(salaryStrategy.getSelectedIndex()==0){//编辑页面中没有请选择一项
					if(Double.parseDouble(rate.getText())>1){//提成模式下的比例限制
						JOptionPane.showMessageDialog(null, "提成模式下提成比例必须小于1！");
						return false;
					}
				}
				right = true;
				
			}
		}
		return right;
	}

	protected void addButton(Dimension d) {

	}
}
