package elms.presentation.financeui.inAndEx.income;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;





import elms.businesslogic.HallInfo;
import elms.businesslogic.financebl.inandex.IncomeManager;
import elms.presentation.GetHall;
import elms.presentation.MyComboBox;
import elms.presentation.MyPanel;
import elms.presentation.financeui.FinanceUI_main;
import elms.presentation.uihelper.CheckFormat;
import elms.presentation.uihelper.TagPanel;
import elms.vo.FIncomeVO;
import elms.vo.UserVO;

public class Income_main extends JPanel {

	private JButton add;
	private JButton delete;
	private JButton edit;
	private JButton find;
	private JButton back;

	private JLabel jl3;

	private JLabel j1;// 起始时间
	private JLabel j2;// 结束时间

	private JTextField start;
	private JTextField end;

	private JPanel findInfo;
	private JPanel info;

	private JComboBox<String> hall;
	private IncomeList inList;

	private GetHall getHall = new GetHall();

	public static ArrayList<FIncomeVO> arr = new ArrayList<FIncomeVO>();

	IncomeManager im = new IncomeManager();
	CheckFormat check;
	UserVO uservo;

//	public Income_main(String icon){
//		super(icon);
//	}
	
	public Income_main(Dimension d, final UserVO vo) {
//		this(icon);
		this.uservo = vo;
		check = new CheckFormat();
		Dimension inD = new Dimension(d.width, d.height * 2 / 3 - 100);

		setLayout(null);
		setVisible(true);
		setSize(d.width, d.height - 25);
		inList = new IncomeList(inD, vo);
//		inList.setOpaque(false);
		add(inList);

		info = new TagPanel("收入清单");
		info.setBounds(0, 23, 70, 25);

		findInfo = new JPanel();
		findInfo.setBounds(0, d.height - 315, d.width, 80);
		findInfo.setLayout(null);
		add(findInfo);
		
		findInfo.setOpaque(false);

		jl3 = new JLabel("收入营业厅");
		jl3.setBounds(410, 50, 70, 30);

		String[] hallList = { "全部", "南京市鼓楼营业厅", "南京市仙林营业厅" };
		hall = new JComboBox<String>(hallList);
//		hall.setOpaque(false);
		hall.setBounds(480, 50, 140, 30);

		findInfo.add(jl3);
		findInfo.add(hall);
		addTime();

		showHallList("全部");

		hall.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				String sHall = hall.getSelectedItem().toString();

				showHallList(sHall);
			}

		});

		// buttonpanel 用来放各种按钮
		JPanel buttonPanel = new JPanel();
		buttonPanel.setOpaque(false);
		buttonPanel.setLayout(null);
		add = new JButton("新建");
		delete = new JButton("删除");
		edit = new JButton("更改");
		find = new JButton("查询");
		// find.setForeground(Color.GREEN);
		back = new JButton("返回");
		back.setForeground(Color.red);
		buttonPanel.setBounds(0, this.getHeight() / 2 + 100,
				this.getWidth() - 30, 90);

		add.setBounds(50, 30, 102, 30);
		delete.setBounds(200, 30, 104, 30);
		edit.setBounds(350, 30, 102, 30);
		find.setBounds(560, 15, 80, 30);
		back.setBounds(560, 55, 80, 30);
		buttonPanel.add(add);
		buttonPanel.add(delete);
		buttonPanel.add(edit);
		buttonPanel.add(find);
		buttonPanel.add(back);
		add(buttonPanel);
		addActionListener();

		add(info);

	}

	private void addActionListener() {
		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根

				// Income_add j_add = new Income_add(inList, vo);
				// j_add.setVisible(true);
				ArrayList<HallInfo> info = im.getHallInfo();
				if (info == null) {

					return;
				}
				// id由时间和营业厅编号组成（9+2）
				for (int i = 0; i < info.size(); i++) {
					HallInfo hi = info.get(i);
					String[] t = hi.getTime().split("-");
					String time = "";
					for (int j = 0; j < t.length; j++) {
						time = time + t[j];
					}
					String hall = getHall.getHallId(hi.getHall());
					String id = time + hall;
					FIncomeVO findvo = im.inquiryIncome(id);

					FIncomeVO vo = new FIncomeVO("请选择", id, hi.getTime(), hi
							.getAmount(), hi.getHall(), uservo.getId());

					if (findvo != null) {
						int opt = JOptionPane.showConfirmDialog(null, "已存在 "
								+ vo.getShop() + " 于 " + vo.getTime()
								+ " 的记录，替换该记录？");
						if (opt == 0) {
							for (int j = 0; j < arr.size(); j++) {
								if (arr.get(j).getID().equals(id)) {
									arr.remove(j);
									arr.add(i, vo);
								}
							}
							inList.removeAllData();
							inList.addAllData(arr);
						}
					} else {

						arr.add(vo);
						inList.addData(vo);
					}
				}

			}

		});
		// 删除的和数据层的交互在tablemodel里
		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				inList.removeData();
			}

		});
		edit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				// JFrame find_time = new
				// Income_findTime(hall.getSelectedItem().toString());
				// find_time.setVisible(true);
				String id = inList.getSelectedID();
				System.out.println(id);
				if (id == null) {
					JOptionPane.showMessageDialog(null, "请选择要修改的收入项!");
				} else {
					try {
						FIncomeVO inVO = null;
						for (int i = 0; i < arr.size(); i++) {
							System.out.println(arr.get(i).getID());
							if (arr.get(i).getID().equals(id)) {
								inVO = arr.get(i);

								break;
							}
						}
						Income_edit edit = new Income_edit(inList, inVO, uservo);
						edit.setVisible(true);
					} catch (Exception e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}

				}
			}

		});
		find.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根

				JFrame findframe = new Income_find(inList, uservo);
				findframe.setVisible(true);
			}

		});
		
	}
	
	public JButton getBackButton(){
		return back;
	}

	// 根据营业厅信息显示对应的收入项信息
	private void showHallList(String choose) {
		if (choose.equals("全部")) {
			arr = im.inquiryAll();

			inList.removeAllData();
			inList.addAllData(arr);

		} else {
			arr = im.inquiryIncomeByHall(choose);
			inList.removeAllData();
			inList.addAllData(arr);

		}
	}

	// 根据时间获取收入项信息
	private void getShowList(String startTime, String endTime) {
		if (startTime.length() < 1 && endTime.length() < 1) { // 若开始和结束输入框中全为空，默认查询所有

			arr = im.inquiryAll();
		} else if (startTime.length() < 1 || endTime.length() < 1) {
			arr = im.inquiryAll();
		} else {
			String hallName = hall.getSelectedItem().toString();
			if (hallName.equals("全部")) {
				arr = im.inquiryIncomeByTime(startTime, endTime);
			} else {
				arr = im.inquiryInByTimeHall(startTime, endTime, hallName);
			}

		}
	}

	private void showList() {
		inList.removeAllData();
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.size(); i++) {
			FIncomeVO vo = arr.get(i);
			inList.addData(vo);
		}
	}

	private void addTime() {
		j1 = new JLabel("起始时间：");
		j2 = new JLabel("结束时间：");

		// findInfo = new JPanel();
		// findInfo.setBounds(0, d.height-275, d.width, 30);
		// findInfo.setLayout(null);
		// add(findInfo);

		j1.setBounds(findInfo.getWidth() / 6, 0, 80, 30);
		findInfo.add(j1);
		j2.setBounds(findInfo.getWidth() * 3 / 6 + 10, 0, 80, 30);
		findInfo.add(j2);

		// 可以扩展，弹出一个日历的形式
		start = new JTextField();
		start.setBounds(j1.getX() + j1.getWidth(), 0, 140, 30);
		findInfo.add(start);

		end = new JTextField();
		end.setBounds(j2.getX() + j2.getWidth(), 0, 140, 30);
		findInfo.add(end);

		end.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					end.setText(sdf.format(new Date()));
				}
			}
		});

		// 开始和结束时间的输入框中加监听，自动显示规定时间内的支出项
		start.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void changedUpdate(DocumentEvent arg0) {
				// TODO 自动生成的方法存根
				if (start.getText().length() < 10) {
					return;
				}
				if (check.checkData("yyyy-MM-dd", end.getText())) {
					if (check.checkData("yyyy-MM-dd", start.getText())) {
						if (check.lessThan("yyyy-MM-dd", start.getText(),
								end.getText())) {
							getShowList(start.getText(), end.getText());
							showList();
						} else {
							JOptionPane
									.showMessageDialog(null, "开始时间必须小于结束时间！");
						}

					} else {
						JOptionPane.showMessageDialog(null,
								"请在开始时间一栏中输入格式为yyyy-MM-dd格式的时间！");
					}
				} else {
					if (end.getText().length() < 1)
						JOptionPane.showMessageDialog(null,
								"请在结束时间一栏中输入格式为yyyy-MM-dd格式的时间!");
				}
			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				// TODO 自动生成的方法存根
				if (start.getText().length() < 10) {
					return;
				}
				if (check.checkData("yyyy-MM-dd", end.getText())) {
					if (check.checkData("yyyy-MM-dd", start.getText())) {
						getShowList(start.getText(), end.getText());
						showList();

					} else {
						JOptionPane.showMessageDialog(null,
								"请在开始时间一栏中输入格式为yyyy-MM-dd格式的时间！");
					}
				} else {
					// if(end.getText().length()<1)
					// JOptionPane.showMessageDialog(null,
					// "请在结束时间一栏中输入格式为yyyy-MM-dd格式的时间!");
				}
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				// TODO 自动生成的方法存根
				arr = im.inquiryAll();
				showList();
			}
		});

		end.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void changedUpdate(DocumentEvent arg0) {
				// TODO 自动生成的方法存根
				if (end.getText().length() != 10)
					return;
				if (check.checkData("yyyy-MM-dd", end.getText())) {
					if (check.checkData("yyyy-MM-dd", start.getText())) {
						if (check.lessThan("yyyy-MM-dd", start.getText(),
								end.getText())) {
							getShowList(start.getText(), end.getText());
							showList();
						} else {
							JOptionPane
									.showMessageDialog(null, "开始时间必须小于结束时间！");
						}

					} else {
						JOptionPane.showMessageDialog(null,
								"请在开始时间一栏中输入格式为yyyy-MM-dd格式的时间！");
					}
				} else {

					JOptionPane.showMessageDialog(null,
							"请在结束时间一栏中输入格式为yyyy-MM-dd格式的时间!");
				}
			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				// TODO 自动生成的方法存根
				if (end.getText().length() != 10)
					return;
				if (check.checkData("yyyy-MM-dd", end.getText())) {
					if (check.checkData("yyyy-MM-dd", start.getText())) {
						if (check.lessThan("yyyy-MM-dd", start.getText(),
								end.getText())) {
							getShowList(start.getText(), end.getText());
							showList();
						} else {
							JOptionPane
									.showMessageDialog(null, "开始时间必须小于结束时间！");
						}

					} else {
						JOptionPane.showMessageDialog(null,
								"请在开始时间一栏中输入格式为yyyy-MM-dd格式的时间！");
					}
				} else {
					JOptionPane.showMessageDialog(null,
							"请在结束时间一栏中输入格式为yyyy-MM-dd格式的时间!");
				}
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				// TODO 自动生成的方法存根
				arr = im.inquiryAll();
				showList();
			}

		});
	}
}
