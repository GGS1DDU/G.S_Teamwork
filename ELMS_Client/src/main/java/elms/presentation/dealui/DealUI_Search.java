package elms.presentation.dealui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JButton;

import elms.businesslogic.dealbl.CheckOrder;
import elms.businesslogic.dealbl.DealBL;
import elms.vo.DealVO;
import elms.vo.UserVO;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
/**
 * 
 * @author ZWH
 *
 */
public class DealUI_Search extends JFrame {
	UserVO uservo=null;
	private JTextField textField;

	/**
	 * 
	 * @param uservo
	 */
	public DealUI_Search(final UserVO uservo) {
		this.uservo=uservo;
		Dimension   screensize   =   Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)screensize.getWidth();
		int height = (int)screensize.getHeight();
		
		setDefaultCloseOperation(JFrame. HIDE_ON_CLOSE);
		setBounds((width-747)/2, (height)/2, 747, 374);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("请输入要查询物流的订单号");
		label.setFont(new Font("宋体", Font.PLAIN, 22));
		label.setBounds(35, 75, 282, 38);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(132, 117, 419, 38);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton check = new JButton("查询");
		check.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String ID=textField.getText();
				CheckOrder co=new CheckOrder();
				if(co.IsTenNumbers(ID)==2){
					JOptionPane.showMessageDialog(null, "请输入10位数字的订单号！","失败!", JOptionPane.ERROR_MESSAGE);
					return ;
				}
				else{
						if(co.IsTenNumbers(ID)==1){
							JOptionPane.showMessageDialog(null, "请确保输入的10位订单号是纯数字！","失败!", JOptionPane.ERROR_MESSAGE);
							return;
						}
					
				}
				
				DealBL dealbl=new DealBL();
				DealVO dealvo=null;
				try {
					dealvo = dealbl.FindOrder(ID);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				if(dealvo==null){
					JOptionPane.showMessageDialog(null, "该订单号不存在!", "失败!", JOptionPane.ERROR_MESSAGE);
				}
				else{
					DealUI_CheckOrder dc=new DealUI_CheckOrder(uservo,dealvo);
					dc.setVisible(true);
					DealUI_Search.this.dispose();
				}
				
				
			}
		});
		check.setBounds(149, 212, 139, 51);
		contentPane.add(check);

		JButton cancel = new JButton("取消");
		cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DealUI_Search.this.dispose();
			}
		});
		cancel.setBounds(412, 212, 139, 51);
		contentPane.add(cancel);
	}
}
