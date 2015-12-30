package elms.presentation.financeui.inAndEx;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import elms.businesslogic.financebl.inandex.IncomeManager;
import elms.businesslogic.financebl.inandex.StatisticManager;
//import elms.presentation.financeui.inAndEx.income.Income_findTime;
import elms.presentation.financeui.inAndEx.income.Income_main;
import elms.presentation.uihelper.ScreenSize;
import elms.vo.FExpenseVO;
import elms.vo.FIncomeVO;
import elms.vo.UserVO;

public class InAndEx_findTime extends JFrame {

	int screenWidth = ScreenSize.screenWidth;
	int screenHeight = ScreenSize.screenHeight;
	JTextField startTime;
	JTextField endTime;

	JButton ok;
	JButton cancel;

	ArrayList<FIncomeVO> incomeList = new ArrayList<FIncomeVO>();
	ArrayList<FExpenseVO> expenseList = new ArrayList<FExpenseVO>();

	private UserVO uservo;

	public InAndEx_findTime(UserVO u_vo) {

		this.uservo = u_vo;

		setLayout(null);
		setTitle("时间查询");
		setResizable(false);
		setBounds(screenWidth / 4, screenHeight / 4, screenWidth / 4,
				screenHeight / 3);

		JLabel start = new JLabel("起始时间");
		start.setBounds(this.getWidth() / 5, this.getHeight() / 6,
				this.getWidth() / 5, 25);
		add(start);

		startTime = new JTextField();
		startTime.setBounds(this.getWidth() / 2, this.getHeight() / 6,
				this.getWidth() / 3 + 10, 25);
		add(startTime);

		JLabel end = new JLabel("终止时间");
		end.setBounds(this.getWidth() / 5, this.getHeight() / 2,
				this.getWidth() / 5, 25);
		add(end);

		endTime = new JTextField();
		endTime.setBounds(this.getWidth() / 2, this.getHeight() / 2,
				this.getWidth() / 3 + 10, 25);
		add(endTime);

		endTime.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					SimpleDateFormat sdf = new SimpleDateFormat(
							"yyyy-MM-dd hh:mm:ss");
					endTime.setText(sdf.format(new Date()));
				}
			}

		});

		ok = new JButton("查询");
		ok.setBounds(this.getWidth() / 4, 3 * this.getHeight() / 4,
				this.getWidth() / 5, 30);
		add(ok);

		cancel = new JButton("返回");
		cancel.setBounds(this.getWidth() / 2 + 20, 3 * this.getHeight() / 4,
				this.getWidth() / 5, 30);
		add(cancel);

		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根

				if (!isAvailableTime(startTime.getText())
						|| !isAvailableTime(endTime.getText())) {
					JOptionPane.showMessageDialog(null, "查询时间格式不正确");
				} else {
					SimpleDateFormat formatter = new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss");
					try {
						Date date1 = formatter.parse(startTime.getText());
						Date date2 = formatter.parse(endTime.getText());
						if (date1.after(date2)) {
							JOptionPane.showMessageDialog(null, "查询时间顺序错误");
						} else {
//							JFrame form = new InAndEx_form(startTime.getText(),
//									endTime.getText(),uservo);
//							form.setVisible(true);
//							InAndEx_findTime.this.dispose();
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}

		});

		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				InAndEx_findTime.this.dispose();
			}

		});

	}

	public boolean isAvailableTime(String time) {
		if (time.matches("\\d{4}-\\d{1,2}-\\d{1,2}\\s\\d{2}:\\d{2}:\\d{2}")) {
			return true;
		}
		return false;
	}
}
