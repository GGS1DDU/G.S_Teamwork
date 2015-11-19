package main;

import java.rmi.RemoteException;

import ELMS.businesslogic.MemberBL.MemberBl_driver;
import ELMS.businesslogic.MemberBL.MemberBl_stub;
import ELMS.data.MemberData.MemberData_driver;
import ELMS.data.MemberData.MemberData_stub;

public class Serve {
public static void main(String args[]) throws RemoteException{
	//member	
			MemberBl_stub ms=new MemberBl_stub();
			new MemberBl_driver(ms);
			
			MemberData_stub mds=new MemberData_stub();
			new MemberData_driver(mds);
			
}
}
