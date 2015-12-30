package elms.presentation.managerui.staff;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import elms.businesslogic.ResultMessage;
import elms.businesslogic.managerbl.StaffManager;
import elms.presentation.managerui.staff.staffhelper.GetIdentifier;
import elms.presentation.managerui.staff.staffhelper.StaffInfoFrame;
import elms.presentation.managerui.staff.staffhelper.StaffList;
import elms.vo.StaffVO;
import elms.vo.UserVO;

public class StaffUI_edit extends StaffInfoFrame {

	private JPanel buttonPanel;
	private StaffManager sm = new StaffManager();
	private StaffList staffList;
	public static void main(String[] args) {
		StaffVO vo = new StaffVO();
//		StaffUI_edit se = new StaffUI_edit(vo);
//		se.setVisible(true);
	}

	public StaffUI_edit(StaffList list,StaffVO vo) {
		super();
		this.staffList = list;
		
	
//		String startID = vo.getID();
		System.out.println(vo.getID());
		id.setText(vo.getID());
		id.setEditable(false);

		name.setText(vo.getName());

		String sex = "男";
		if (!vo.getGender()) {
			sex = "女";
		}
		gender.setSelectedItem(sex);

		birthday.setText(vo.getAge());

		phone.setText(vo.getPhoneNum());

		idCard.setText(vo.getIdCard());

		address.setText(vo.getAddress());
		
		job.setSelectedItem(vo.getJob());
		
		essentialSalary.setText(""+vo.getEssentialSalary());
		
		salaryStrategy.setSelectedItem(vo.getSalaryStrategy());
		
		rate.setText(""+vo.getRate());
		
		organization.setText(vo.getOrganization());
		
//		job.addActionListener(new ActionListener(){
//
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				// TODO 自动生成的方法存根
//				id.setEditable(true);
//				String identify = gi.getIdentifier(job.getSelectedItem().toString());
//				if(job.getSelectedItem()!="全部"){
//					id.setText(identify+staffvo.getID().substring(2, staffvo.getID().length()));
//				}
//				id.setEditable(false);
//			}
//			
//		});
		
		addButton();

	}

	protected void addButton() {
		buttonPanel = new JPanel();
		buttonPanel.setLayout(null);
		buttonPanel.setBounds(this.getButtonPanelLocation().width,
				this.getButtonPanelLocation().height,
				this.getButtonPanelSize().width,
				this.getButtonPanelSize().height);
		add(buttonPanel);

		int w = buttonPanel.getWidth();
		int h = buttonPanel.getHeight();

		JButton save= new JButton("保存");
		JButton delete = new JButton("删除");
		JButton back = new JButton("返回");
		save.setBounds(w / 7, 15, 80, 30);
		delete.setBounds(w * 3 / 7, save.getY(), save.getWidth(), save.getHeight());
		back.setBounds(w*5/7,save.getY(),save.getWidth(),save.getHeight());

		buttonPanel.add(save);
		buttonPanel.add(delete);
		buttonPanel.add(back);

		save.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				if (StaffUI_edit.this.checkInput()) {
//					System.out.println(StaffUI_edit.this.rate.getText());
					ResultMessage rm = sm.updateStaff(getVO());
					if (rm == ResultMessage.findIDFailed) {
						JOptionPane.showMessageDialog(null,
								"找不到对应id的职员，请重新输入职员id！");
					} else {
						JOptionPane.showMessageDialog(null, "修改成功！");
						ArrayList<StaffVO> staff = StaffUI_main.arr;
						
						for(int i = 0; i < staff.size(); i++){
							StaffVO svo = staff.get(i);
							if(svo.getID().equals(getVO().getID())){
								staff.remove(i);
								staff.add(i, getVO());
								break;
							}
						}
						
						StaffUI_main.arr = staff;
						staffList.removeAllData();
						staffList.addAllData(staff);
					}
					
				}
			}

		});
		
		delete.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				ResultMessage rm = sm.deleteStaff(getVO());
				if(rm==ResultMessage.findIDFailed){
					JOptionPane.showMessageDialog(null, "找不到对应id的职员！");
				}else{
					JOptionPane.showMessageDialog(null, "删除成功！");
				}
				StaffUI_edit.this.dispose();
			}
			
		});
		
		back.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				StaffUI_edit.this.dispose();
			}
			
		});
	}
	
	private StaffVO getVO(){
		boolean sex = false;
		if (gender.getSelectedItem().toString().equals("男")) {
			sex = true;
		}
		StaffVO vo = new StaffVO(id.getText(), name.getText(),
				birthday.getText(), sex, idCard.getText(), address
						.getText(), phone.getText(), job
						.getSelectedItem().toString(), Double
						.parseDouble(essentialSalary.getText()),
				salaryStrategy.getSelectedItem().toString(), Double
						.parseDouble(rate.getText()), organization
						.getText());
		return vo;
	}
}
