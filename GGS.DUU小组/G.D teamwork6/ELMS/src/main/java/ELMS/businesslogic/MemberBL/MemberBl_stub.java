package ELMS.businesslogic.MemberBL;

import java.util.ArrayList;

import ELMS.businesslogicService.MemberBlService;
import ELMS.po.MemberPO;
import ELMS.po.StaffPO;
import ELMS.vo.MemberVO;
import ELMS.vo.StaffVO;

public class MemberBl_stub implements MemberBlService{

	public MemberVO find(String ID) {
		StaffVO vo=new StaffVO(ID, "edison", "男", "快递员", "123456", 5200, "6151200");
		return vo;
	}
public ArrayList<MemberVO> findAll() {
	StaffVO s1=new StaffVO("0001", "edison", "男", "快递员", "123456", 5200, "6151200");
	StaffVO s2=new StaffVO("0002", "faker", "女", "中转中心仓库管理员", "54559x", 4900, "1125000");
	StaffVO s3=new StaffVO("0003", "meiko", "女", "营业厅业务员", "358700", 6000, "1989585");
	ArrayList<MemberVO> al=new ArrayList<MemberVO>();
	al.add(s1);
	al.add(s2);
	al.add(s3);
	return al;
	}
	public boolean addMember(MemberVO vo) {
		return true;
	}

	public void deleteMember(MemberVO vo) {
	System.out.println("该成员信息已删除！ \n");
		
	}

	public MemberVO update(MemberVO vo) {
		return vo;
	}

	public void endMemberOpt() {
		System.out.println("人员操作结束！\n");
	}

	

}
