package elms.presentation.managerui.staff.staffhelper;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MyLabel extends JLabel{

	public MyLabel(String s, JPanel jp) {
		super(s);
		// setPreferredSize();
		setSize(70, 30);
		setHorizontalAlignment(SwingConstants.CENTER);
		jp.add(this);

	}

	public MyLabel(JPanel jp) {
		super();
		setSize(70, 30);
		setHorizontalAlignment(SwingConstants.CENTER);
		jp.add(this);
	}
	
}
