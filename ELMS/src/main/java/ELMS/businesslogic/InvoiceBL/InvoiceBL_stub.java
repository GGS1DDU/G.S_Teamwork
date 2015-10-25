package ELMS.businesslogic.InvoiceBL;

import java.util.ArrayList;

import ELMS.businesslogicService.InvoiceBLService;
import ELMS.po.InvoicePO;
import ELMS.po.RecivalListPO;
import ELMS.vo.InvoiceVO;
import ELMS.vo.RecivalListVO;

public class InvoiceBL_stub implements InvoiceBLService {

	public ArrayList<RecivalListVO> List(RecivalListVO vo) {
		// TODO 
		ArrayList<RecivalListVO> RecivalList =new ArrayList<RecivalListVO>();
		RecivalListVO vo1=new RecivalListVO("1234567890","025000","20151025","025000201510250000000","南京","完整");
		RecivalList.add(vo1);
		return RecivalList;
	}

	public RecivalListVO InvoiceInquiry(String InvoiceID) {
		// TODO 
		System.out.println("查询单据成功！");
		return new RecivalListVO((String)"1","025000","20151025","025000201510250000000","南京","完整");
	}

	public ArrayList<RecivalListVO> InvoiceChange(String InvoiceID) {
		// TODO 
		ArrayList<RecivalListVO> al=new ArrayList<RecivalListVO>();
		RecivalListVO vo=new RecivalListVO(InvoiceID,"025000","20151025","025000201510250000000","南京","完整");
		al.add(vo);
		return al;
	}

	public boolean InvoiceDelete(String InvoiceID) {
		// TODO �Զ����ɵķ������
		return true;
	}

	public boolean InvoiceApproval(String InvoiceID) {
		// TODO �Զ����ɵķ������
		return true;
	}

	public void endInvoiceOpt() {
		// TODO �Զ����ɵķ������
	}

	


}
