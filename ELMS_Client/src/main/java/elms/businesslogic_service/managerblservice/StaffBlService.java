package elms.businesslogic_service.managerblservice;

import java.util.ArrayList;



import elms.businesslogic.ResultMessage;
import elms.vo.StaffVO;

public interface StaffBlService {

	public ResultMessage addStaff(StaffVO vo); // 新增职员

	public ResultMessage deleteStaff(StaffVO vo); // 开除

	public StaffVO findStaff(String id); // 寻找职员

	public ResultMessage updateStaff(StaffVO vo); // 对职员信息进行更改

	public ArrayList<StaffVO> findByJob(String job); // 找到对应职位的所有员工
}
