package elms.presentation.managerui.freight.freighthelper;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import elms.presentation.managerui.freight.FreightUI_add;
import elms.presentation.uihelper.ButtonPanel;

public class FreightButton extends ButtonPanel {

	public FreightButton(Dimension d) {
		super(d);
		// TODO 自动生成的构造函数存根

	}

	public void addListener() {
		add.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				JFrame add_f = new FreightUI_add();
				add_f.setVisible(true);
			}

		});

		delete.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根

			}

		});

		find.addActionListener(new ActionListener() {

		
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根

			}

		});

		refresh.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根

			}

		});

		back.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根

			}

		});
	}

}
