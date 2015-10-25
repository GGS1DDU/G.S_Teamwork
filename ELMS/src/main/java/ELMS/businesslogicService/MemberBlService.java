package ELMS.businesslogicService;
import java.util.ArrayList;

import ELMS.vo.MemberVO;


public interface MemberBlService {
	public MemberVO find(String ID);
	public ArrayList<MemberVO> findAll();
	public boolean addMember( MemberVO vo);
	public void deleteMember( MemberVO vo);
    public MemberVO update(MemberVO vo);
	public void endMemberOpt();
}
