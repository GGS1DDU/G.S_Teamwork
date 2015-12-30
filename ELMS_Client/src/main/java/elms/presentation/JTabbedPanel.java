package elms.presentation;

import java.awt.*;
import java.awt.event.MouseEvent;

import javax.swing.*;

import elms.presentation.financeui.inAndEx.income.Income_main;

/**
 * <p>
 * Title: 选项卡演示
 * </p>
 * <p>
 * Description: 这里是一个选项卡演示，点击不同的卡片，显示的内容不同
 * </p>
 */

public class JTabbedPanel extends JPanel {

	private JTabbedPane tabbedPane;
	private ImageIcon imgIcon;
	private Image img;
	private float alpha = 1.0f;

	Font f = new Font("微软雅黑", Font.PLAIN, 12);

	public JTabbedPanel() {
		super(new GridLayout(1, 1));
		//
		// try {
		// UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		// SwingUtilities.updateComponentTreeUI(tabbedPane);
		// } catch (Exception e) {
		//
		// }

		// setFont(f);
		UIManager.put("TabbedPane.contentOpaque", false);

		setOpaque(false);

		tabbedPane = new JTabbedPane();
		tabbedPane.setFont(f);
		tabbedPane.setOpaque(false);

		add(tabbedPane);

	}

	public JTabbedPanel(String img) {
		super(new GridLayout(1, 1));

		UIManager.put("TabbedPane.contentOpaque", false);
		setOpaque(false);
		imgIcon = new ImageIcon(img);
		this.img = imgIcon.getImage();

		tabbedPane = new JTabbedPane();
		tabbedPane.setOpaque(false);

		// 将选项卡添加到panl中
		add(tabbedPane);
	}
	
	public JTabbedPane getTabPane(){
		return tabbedPane;
	}

	public void addTab(String name, Component cp) {
		tabbedPane.add(name, cp);
	}

	public Rectangle getBoundsAt(int i) {
		return tabbedPane.getBoundsAt(i);
	}

	public int getTabCount() {
		return tabbedPane.getTabCount();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		AlphaComposite alphaComposite = AlphaComposite.getInstance(
				AlphaComposite.SRC_OVER, alpha);
		g2d.setComposite(alphaComposite);// 透明度
		g2d.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
	}

	/**
	 * <br>
	 * 方法说明：添加信息到选项卡中 <br>
	 * 输入参数：String text 显示的信息内容 <br>
	 * 返回类型：Component 成员对象
	 */
	protected Component makeTextPanel(String text) {
		JPanel panel = new JPanel(false);
		JLabel filler = new JLabel(text);
		filler.setHorizontalAlignment(JLabel.CENTER);
		panel.setLayout(new GridLayout(1, 1));
		panel.add(filler);
		return panel;
	}

	/**
	 * <br>
	 * 方法说明：获得图片 <br>
	 * 输入参数：String path 图片的路径 <br>
	 * 返回类型：ImageIcon 图片对象
	 */
	protected static ImageIcon createImageIcon(String path) {
		// java.net.URL imgURL = TabbedPaneDemo.class.getResource(path);
		if (path != null) {
			return new ImageIcon(path);
		} else {
			System.out.println("Couldn't find file: " + path);
			return null;
		}
	}

	// public static void main(String[] args) {
	// // 使用Swing窗体描述
	// // JFrame.setDefaultLookAndFeelDecorated(true);
	//
	// try {
	// UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	// } catch (Exception e) {
	//
	// }
	// // 创建窗体
	// JFrame frame = new JFrame("TabbedPaneDemo");
	// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	// // frame.setLayout(null);
	// JTabbedPanel tabbedPanel = new JTabbedPanel("star.jpg");
	//
	//
	// tabbedPanel.setBounds(0,0,frame.getWidth(),frame.getHeight());
	// frame.getContentPane().setBackground(Color.black);
	// frame.getContentPane().add(tabbedPanel);
	//
	//
	// // 显示窗体
	// frame.setSize(400, 200);
	// frame.setVisible(true);
	// }
	//
	// public void test(){
	// Component panel1 = makeTextPanel("#第一个卡片#");
	// }
}
