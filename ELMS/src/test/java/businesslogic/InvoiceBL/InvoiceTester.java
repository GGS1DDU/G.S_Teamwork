package businesslogic.InvoiceBL;

import static org.junit.Assert.*;

import org.junit.Test;

import ELMS.businesslogic.InvoiceBL.Invoice;
import ELMS.businesslogic.InvoiceBL.InvoiceList;
import ELMS.businesslogic.InvoiceBL.MockInvoice;
import ELMS.businesslogic.InvoiceBL.State;

public class InvoiceTester {
	
	@Test
	public void test(){
		Invoice i=new Invoice();
		MockInvoice mi1=new MockInvoice("025000","2015-11-11","025000201511110000000","南京",State.COMPLETE);
		MockInvoice mi2=new MockInvoice("025001","2015-11-12","025001201511120000001","上海",State.BROKEN);
		MockInvoice mi3=new MockInvoice("025002","2015-11-13","025002201511130000002","北京",State.DISAPPEAR);
		MockInvoice mi4=new MockInvoice("025003","2015-11-14","025003201511140000003","南京",State.COMPLETE);
		
		InvoiceList il1=new InvoiceList();
		InvoiceList il2=new InvoiceList();
		
		il1.add(mi1);il1.add(mi2);il1.add(mi3);il1.add(mi4);
		il2.add(mi1);il2.add(mi2);il2.add(mi3);il2.add(mi4);
        
		assertEquals(il1.get(0).getCenterID(),i.List(null).get(0).getCenterID());
		assertEquals(il1.get(1).getTime(),i.List(null).get(1).getTime());
		assertEquals(il1.get(2).getID(),i.List(null).get(2).getID());
		assertEquals(il1.get(3).getFrom(),i.List(null).get(3).getFrom());
		assertEquals(il1.get(4).getState(),i.List(null).get(4).getState());
	}
	

}
