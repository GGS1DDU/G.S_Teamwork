package elms.presentation.uihelper;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class TagPanel extends JPanel {

	public TagPanel(String s) {
		Border l2 = BorderFactory.createLoweredBevelBorder();
		JLabel tag = new JLabel(s);
		setLayout(new java.awt.BorderLayout());
		add(tag);
		setBorder(l2);
	}
}
