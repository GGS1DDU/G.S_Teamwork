package ELMS.businesslogic.InvoiceBL;

import ELMS.vo.InvoiceVO;
import ELMS.vo.RecivalListVO;

public class MockInvoice extends RecivalListVO{
	public MockInvoice(String certerID,String time,String id,String from,Enum<State> state){
		super(certerID,time,id,from,state);
	}
}
