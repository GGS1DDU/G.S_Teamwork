package elms.presentation.managerui.freight;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import elms.presentation.managerui.freight.freighthelper.FreightListPanel;
import elms.presentation.uihelper.ButtonPanel;
import elms.presentation.uihelper.ScreenSize;
import elms.vo.UserVO;

public class FreightUI_main extends JFrame {

	private int screenWidth = ScreenSize.screenWidth;
	private int screenHeight = ScreenSize.screenHeight;
	private Dimension listD;
	private Dimension buttonD;

	private UserVO uservo;

	private JPanel buttonPanel;

	public static void main(String[] args) {
		UserVO vo = new UserVO();
		JFrame jf = new FreightUI_main(vo);
		jf.setVisible(true);
	}

	public FreightUI_main(UserVO u_vo) {
		setLayout(null);
		setTitle("运费策略");
		setResizable(false);
		setSize(screenWidth / 2, screenHeight / 2 + 100);
		setLocation(screenWidth / 4, screenHeight / 8);
		listD = new Dimension(this.getWidth() - 50, this.getHeight() * 2 / 3);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel fListPanel = new FreightListPanel(listD);
		fListPanel.setLocation(25, 0);
		add(fListPanel);

		buttonD = new Dimension(this.getWidth(), this.getHeight() / 3);
		JPanel buttonPanel = new ButtonPanel(buttonD);
		buttonPanel.setLocation(0, this.getHeight() * 2 / 3);
		add(buttonPanel);

	}

}
