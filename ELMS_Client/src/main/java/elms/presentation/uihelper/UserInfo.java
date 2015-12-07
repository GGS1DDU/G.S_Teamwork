package elms.presentation.uihelper;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import elms.vo.UserVO;

public class UserInfo extends JPanel {

	JLabel jl;

	public UserInfo(UserVO vo) {
		jl = new JLabel("  当前用户：  " + vo.getName() + "  身份：  " + vo.getJob()
				+ "  编号   " + vo.getId(), JLabel.CENTER);
		jl.setBounds(0, 0, this.getWidth(), this.getHeight());
		jl.setForeground(Color.lightGray);
		this.add(jl);

		Border li = BorderFactory.createEtchedBorder();
		Border t = BorderFactory.createTitledBorder(li);
		this.setBorder(t);
	}
}
