package elms.presentation.userui;
import javax.swing.*;

import elms.businesslogic.userbl.UserManage;
import elms.vo.UserVO;

import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
/**
 * 
 * @author ZWH
 *
 */
public class UserUI_AllUser extends JFrame implements ActionListener{
	static JTable jt=null;
	JScrollPane jsp=null;
	
	JPanel jp1,jp2;
	JLabel jl1;
	JButton jb1,jb2,jb3,jb4;
	JTextField jtf;
	
	
	public UserUI_AllUser(){
		this.setLocationRelativeTo(null);
		jp1=new JPanel();
		jp1.setBackground(Color.WHITE);
		jp1.setBounds(0, 0, 778, 71);
		jtf=new JTextField(10);
		jtf.setBounds(227, 31, 96, 27);
		jb1=new JButton("查询");
		jb1.setBackground(Color.WHITE);
		jb1.setBounds(348, 31, 69, 29);
		jb1.addActionListener(this);
		jb4=new JButton("显示全部用户");
		jb4.setBackground(Color.WHITE);
		jb4.setBounds(453, 31, 141, 29);
		jb4.addActionListener(this);
		jp1.setLayout(null);
		jl1=new JLabel("请输入名字");
		jl1.setBounds(122, 35, 90, 21);
		
		jp1.add(jl1);
		jp1.add(jtf);
		jp1.add(jb1);
		jp1.add(jb4);
		
		jp2=new JPanel();
		jp2.setBackground(Color.WHITE);
		jp2.setBounds(0, 841, 778, 104);
		jp2.setLayout(null);
		
		
		
		
		
		UserModel um=new UserModel();
		getContentPane().setLayout(null);
		
		jt=new JTable(um);
		
		jsp=new JScrollPane(jt);
		jsp.setBackground(new Color(240, 248, 255));
		jsp.setBounds(0, 70, 778, 769);
		
		getContentPane().add(jsp);
		getContentPane().add(jp1);
		getContentPane().add(jp2);
		
		jb2=new JButton("添加");
		jb2.setBackground(Color.WHITE);
		jb2.setBounds(168, 25, 119, 42);
		jp2.add(jb2);
		jb3=new JButton("更改");
		jb3.setBackground(Color.WHITE);
		jb3.setBounds(418, 25, 126, 42);
		jp2.add(jb3);
		jb3.addActionListener(this);
		jb2.addActionListener(this);
		this.setVisible(true);
		this.setSize(800, 1000);
		this.setDefaultCloseOperation(JFrame. HIDE_ON_CLOSE);
		
		jt.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				if(e.getClickCount()==2){
					if(jt.getSelectedColumn()!=-1){
						int row=jt.getSelectedRow();
						String id=jt.getValueAt(row, 0).toString();
						UserManage um=new UserManage();
						try {
							UserVO vo=um.findUser(id);
							JFrame ucm=new UserUI_ChangeUser_message(vo);
							ucm.setVisible(true);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						
						
						
					}
					
					
					
				}
			}
			
			
		});
	}


	public void actionPerformed(ActionEvent e) {
		//判断是哪个按钮被clicked
		if(e.getSource()==jb1){
			String name=this.jtf.getText().trim();
			UserModel um=new UserModel(name);
			jt.setModel(um);
			
			
		}
		if(e.getSource()==jb2){
			UserUI_addUser ua=new UserUI_addUser();
			ua.setVisible(true);
		}
		if(e.getSource()==jb3){
			UserUI_ChangeUser uc=new UserUI_ChangeUser();
			uc.setVisible(true);
			
		}
		if(e.getSource()==jb4){
			updateTable();
		}
	}
	
	public static void updateTable(){
		UserModel um=new UserModel();
		jt.setModel(um);
	}
	
	

}
