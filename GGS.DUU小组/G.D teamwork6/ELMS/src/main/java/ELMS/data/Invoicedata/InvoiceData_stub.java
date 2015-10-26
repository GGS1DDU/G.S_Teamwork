package ELMS.data.Invoicedata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import ELMS.dataservice.InvoiceDataService;
import ELMS.po.InvoicePO;
import ELMS.vo.RecivalListVO;

public class InvoiceData_stub implements InvoiceDataService{

	public RecivalListVO find(String id) throws RemoteException {
		// TODO �Զ����ɵķ������
		RecivalListVO vo=new RecivalListVO(id,"025000","20151025","025000201510250000000","�Ͼ�","����");
		return vo;
	}

	public void insert(InvoicePO po) throws RemoteException {
		// TODO �Զ����ɵķ������
		
	}

	public void delete(InvoicePO po) throws RemoteException {
		// TODO �Զ����ɵķ������
		
	}

	public void update(InvoicePO po) throws RemoteException {
		// TODO �Զ����ɵķ������
		
	}

	public void init() throws RemoteException {
		// TODO �Զ����ɵķ������
		
	}

	public void finish() throws RemoteException {
		// TODO �Զ����ɵķ������
		
	}

}
