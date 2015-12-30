package elms.presentation.managerui.freight;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;






import elms.businesslogic.ResultMessage;
import elms.businesslogic.managerbl.FreightStrategyManager;
import elms.presentation.financeui.inAndEx.income.Income_main;
import elms.presentation.managerui.freight.freighthelper.FreightList;
import elms.presentation.uihelper.CheckFormat;
import elms.presentation.uihelper.ScreenSize;
import elms.vo.FreightStrategyVO;

public class FreightUI_change extends JFrame {

	private int screenWidth = ScreenSize.screenWidth;
	private int screenHeight = ScreenSize.screenHeight;
	private String id;

	private JLabel jl1; // 1城市
	private JLabel jl2; // 2城市
	private JLabel jl3; // 城市间距离
	private JLabel jl4; // 标准价格
	private JLabel jl5; // 价格因子

	private JComboBox<String> city1_j;
	private JComboBox<String> city2_j;
	private JTextField distance;
	private JTextField price;
	private JTextField coefficient;

	private JPanel buttonPanel;
	private CheckFormat cf;

	private FreightStrategyManager fsm = new FreightStrategyManager();
	private FreightList freightList;
	private FreightStrategyVO freightVO;
	
	public FreightUI_change(FreightList list,FreightStrategyVO vo) {
		this.freightList = list;
		this.freightVO = vo;
		setTitle("运费策略");
		setLayout(null);
		setBounds(screenWidth / 3, screenHeight / 4, screenWidth / 3,
				screenHeight / 2 + 50);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		cf = new CheckFormat();

		addContainers();
		setInfo(city1_j.getSelectedItem().toString(), city2_j.getSelectedItem()
				.toString());

		city1_j.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				setInfo(city1_j.getSelectedItem().toString(), city2_j
						.getSelectedItem().toString());
			}

		});

		city2_j.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				setInfo(city1_j.getSelectedItem().toString(), city2_j
						.getSelectedItem().toString());
			}

		});

		addButtons();

		setVisible(true);
	}

	private void addContainers() {
		jl1 = new JLabel("城市1");
		jl2 = new JLabel("城市2");
		jl3 = new JLabel("距离");
		jl4 = new JLabel("标准价格");
		jl5 = new JLabel("调整因子");

		add(jl1);
		add(jl2);
		add(jl3);
		add(jl4);
		add(jl5);

		jl1.setBounds(this.getWidth() / 5 + 20, this.getHeight() / 8, 80, 30);
		jl2.setBounds(this.getWidth() / 5 + 20, this.getHeight() * 2 / 8, 80,
				30);
		jl3.setBounds(this.getWidth() / 5 + 20, this.getHeight() * 3 / 8, 80,
				30);
		jl4.setBounds(this.getWidth() / 5 + 20, this.getHeight() * 4 / 8, 80,
				30);
		jl5.setBounds(this.getWidth() / 5 + 20, this.getHeight() * 5 / 8, 80,
				30);

		String[] cityList = { "南京", "上海", "广州", "北京" };
		city1_j = new JComboBox<String>(cityList);
		city1_j.setBounds(jl1.getX() + jl1.getWidth(), jl1.getY(), 140, 30);

		city2_j = new JComboBox<String>(cityList);
		city2_j.setBounds(jl2.getX() + jl2.getWidth(), jl2.getY(), 140, 30);

		distance = new JTextField();
		distance.setBounds(jl3.getX() + jl3.getWidth(), jl3.getY(), 140, 30);

		price = new JTextField();
		price.setBounds(jl4.getX() + jl4.getWidth(), jl4.getY(), 140, 30);

		coefficient = new JTextField();
		coefficient.setBounds(jl5.getX() + jl5.getWidth(), jl5.getY(), 140, 30);
		
		city1_j.setSelectedItem(freightVO.getCity1());
		city2_j.setSelectedItem(freightVO.getCity2().substring(0, 2));
		distance.setText(""+freightVO.getDistance());
		price.setText(""+freightVO.getStandardPrice());
		coefficient.setText(""+freightVO.getCoefficient());

		add(city1_j);
		add(city2_j);
		add(distance);
		add(price);
		add(coefficient);
	}

	private void setInfo(String city1, String city2) {
		id = fsm.getID(city1, city2);

		FreightStrategyVO vo = fsm.getFreightStrategy(id);
		distance.setText("" + vo.getDistance());
		price.setText("" + vo.getStandardPrice());
		coefficient.setText("" + vo.getCoefficient());

	}

	private void addButtons() {
		buttonPanel = new JPanel();
		buttonPanel.setLayout(null);
		buttonPanel.setBounds(0, this.getHeight() - 100, this.getWidth(),
				this.getHeight() - buttonPanel.getY());
		add(buttonPanel);

		JButton save_b = new JButton("保存");
		JButton back = new JButton("返回");

		buttonPanel.add(save_b);
		buttonPanel.add(back);

		int w = buttonPanel.getWidth();
		int h = buttonPanel.getHeight();

		save_b.setBounds(w / 5, 5, 80, 30);
		back.setBounds(w * 3 / 5, 5, 80, 30);

		save_b.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if (!cf.checkDouble(distance.getText())) {
					JOptionPane.showMessageDialog(null, "距离输入格式错误，请输入一个小数！",
							"失败", JOptionPane.ERROR_MESSAGE);
					return;
				} else if (!cf.checkInteger(price.getText())) {
					JOptionPane.showMessageDialog(null, "价格输入格式错误，请输入一个整数！",
							"失败", JOptionPane.ERROR_MESSAGE);
					return;
				} else if (!cf.checkInteger(price.getText())) {
					JOptionPane.showMessageDialog(null, "调整因子输入格式错误，请输入一个整数！",
							"失败", JOptionPane.ERROR_MESSAGE);
					return;
				} else {
					FreightStrategyVO vo = new FreightStrategyVO(id, city1_j
							.getSelectedItem().toString(), city2_j
							.getSelectedItem().toString(), Double
							.parseDouble(distance.getText()), Integer
							.parseInt(price.getText()), Integer
							.parseInt(coefficient.getText()));
					ResultMessage rm = fsm.changeFreight(vo);
					if (rm == ResultMessage.findIDFailed) {
						try {
							fsm.addFreight(vo);
							
						} catch (IOException e1) {
							// TODO 自动生成的 catch 块
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(null, "新建成功！");
						
					} else {
						JOptionPane.showMessageDialog(null, "修改成功！");
						FreightUI_change.this.dispose();
						
						ArrayList<FreightStrategyVO> freight = FreightUI_main.arr;
						int i = 0; 
						for(; i < freight.size(); i++){
							if(freight.get(i).getID().equals(vo.getID())){
								freight.remove(i);
								freight.add(i, vo);
								break;
							}
						}
						FreightUI_main.arr = freight;
						
						freightList.removeAllData();
						freightList.addAllData(freight);
					}
				}
			}

		});

		back.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				FreightUI_change.this.dispose();
			}

		});

	}

}
