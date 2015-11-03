package ELMS.businesslogicService;

//import java.util.Arraylist;

import java.util.ArrayList;

import ELMS.vo.RecivalListVO;

public interface InvoiceBLService {
	public ArrayList<RecivalListVO> List(RecivalListVO vo);

	public RecivalListVO InvoiceInquiry(String InvoiceID);
	
	public ArrayList<RecivalListVO> InvoiceChange(String InvoiceID);
	
	public boolean InvoiceDelete(String InvoiceID);
	
	public boolean InvoiceApproval(String InvoiceID);
	
	public void endInvoiceOpt();
}
