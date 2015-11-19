package ELMS.dataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import ELMS.po.MemberPO;

public interface MemberDataService {

public MemberPO find(String id) throws RemoteException;
public ArrayList<MemberPO> findAll() throws RemoteException;
public void insert(MemberPO po) throws RemoteException;
public void delete(MemberPO po) throws RemoteException;
public void update(MemberPO po) throws RemoteException;
public void init() throws RemoteException;
public void finish() throws RemoteException;
}
