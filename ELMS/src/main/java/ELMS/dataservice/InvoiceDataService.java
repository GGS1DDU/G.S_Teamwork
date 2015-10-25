package ELMS.dataservice;

import java.rmi.RemoteException;

import ELMS.po.InvoicePO;
import ELMS.vo.RecivalListVO;

public interface InvoiceDataService {
	public RecivalListVO find(String id) throws RemoteException;
	public void insert(InvoicePO po) throws RemoteException;
	public void delete(InvoicePO po) throws RemoteException;
	public void update(InvoicePO po) throws RemoteException;
	public void init() throws RemoteException;
	public void finish() throws RemoteException;
}
