package elms.presentation.uihelper;

import java.awt.Dimension;
import java.awt.Toolkit;

public class ScreenSize {

	private static Toolkit kit = Toolkit.getDefaultToolkit();
	private static Dimension screenSize = kit.getScreenSize();
	public static int screenWidth = (int) screenSize.getWidth();
	public static int screenHeight = (int) screenSize.getHeight();
}
