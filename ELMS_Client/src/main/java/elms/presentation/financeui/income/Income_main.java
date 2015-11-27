package elms.presentation.financeui.income;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Income_main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Income_main frame = new Income_main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Income_main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 353);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("新增收入项");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame addincome = new Income_add();
				addincome.setVisible(true);
			}
		});
		button.setBounds(155, 85, 110, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("更改收入项");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame change = new Income_change();
				change.setVisible(true);
			}
		});
		button_1.setBounds(155, 134, 110, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("查询收入项");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame find = new Income_find();
				find.setVisible(true);
			}
		});
		button_2.setBounds(155, 182, 106, 23);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("返回");
		button_3.setBounds(155, 228, 110, 23);
		contentPane.add(button_3);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 43, 414, 2);
		contentPane.add(separator);
	}

}
