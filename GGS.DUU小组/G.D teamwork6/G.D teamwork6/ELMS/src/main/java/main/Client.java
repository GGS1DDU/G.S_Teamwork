package main;

import java.rmi.RemoteException;

import ELMS.businesslogic.DealBL.DealBL_Driver;
import ELMS.businesslogic.DealBL.DealBL_stub;
import ELMS.businesslogic.FinanceBL.Bank_Driver;
import ELMS.businesslogic.FinanceBL.Bank_Stub;
import ELMS.businesslogic.FinanceBL.Form_Driver;
import ELMS.businesslogic.FinanceBL.Form_Stub;
import ELMS.businesslogic.InvoiceBL.InvoiceBL_Driver;
import ELMS.businesslogic.InvoiceBL.InvoiceBL_stub;
import ELMS.businesslogic.LogBL.LogBl_driver;
import ELMS.businesslogic.LogBL.LogBl_stub;
import ELMS.businesslogic.MemberBL.MemberBl_driver;
import ELMS.businesslogic.MemberBL.MemberBl_stub;
import ELMS.businesslogic.StorageBL.StorageBl_driver;
import ELMS.businesslogic.StorageBL.StorageBl_stub;
import ELMS.businesslogic.UserBL.UserBL_driver;
import ELMS.businesslogic.UserBL.UserBL_stub;
import ELMS.businesslogicService.DealBlService;
import ELMS.businesslogicService.InvoiceBLService;
import ELMS.businesslogicService.LogBlService;
import ELMS.businesslogicService.UserBlService;
import ELMS.businesslogicService.FinanceBlService.FinanceBlBankService;
import ELMS.businesslogicService.FinanceBlService.FinanceBlInitAllService;
import ELMS.dataservice.DealDataService;
import ELMS.dataservice.FinanceBankDataService;
import ELMS.dataservice.InvoiceDataService;
import ELMS.dataservice.UserDataService;
import ELMS.data.Dealdata.*;
import ELMS.data.FinanceData.BankData_Driver;
import ELMS.data.FinanceData.BankData_Stub;
import ELMS.data.Invoicedata.InvoiceData_Driver;
import ELMS.data.Invoicedata.InvoiceData_stub;
import ELMS.data.Logdata.LogData_driver;
import ELMS.data.Logdata.LogData_stub;
import ELMS.data.MemberData.MemberData_driver;
import ELMS.data.MemberData.MemberData_stub;
import ELMS.data.Storagedata.StorageData_driver;
import ELMS.data.Storagedata.StorageData_stub;
import ELMS.data.Userdata.Userdata_driver;
import ELMS.data.Userdata.Userdata_stub;

public class Client {

	public static void main(String[] args) throws RemoteException {
		//user
		UserBlService UserBL_stub=new UserBL_stub();
		UserBL_driver UserBL_driver=new UserBL_driver();
		UserBL_driver.driver(UserBL_stub);
		
		
		
		UserDataService Userdata_stub=new Userdata_stub();
		Userdata_driver Userdata_driver=new Userdata_driver();
		try {
			Userdata_driver.drive(Userdata_stub);
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		
		
		//deal
		DealBlService DealBL_stub=new DealBL_stub();
		DealBL_Driver DealBL_driver=new DealBL_Driver();
		DealBL_driver.drive(DealBL_stub);
		
		DealDataService DealData_stub=new DealDate_stub();
		DealData_driver DealData_driver=new DealData_driver();
		try {
			DealData_driver.drive(DealData_stub);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		//Invoice
		InvoiceBLService InvoiceBL_stub=new InvoiceBL_stub();
		InvoiceBL_Driver InvoiceBL_driver=new InvoiceBL_Driver();
		InvoiceBL_driver.drive(InvoiceBL_stub);
				
	    InvoiceDataService InvoiceData_stub=new InvoiceData_stub();
		InvoiceData_Driver InvoiceData_driver=new InvoiceData_Driver();
		try{
			InvoiceData_driver.drive(InvoiceData_stub);
		}catch(RemoteException e){
			e.printStackTrace();
		}
		
		//Log
		LogBl_stub ls=new LogBl_stub();
		new LogBl_driver(ls);
		
		LogData_stub lds=new LogData_stub();
		new LogData_driver(lds);

		
		//Storage
		StorageBl_stub ss=new StorageBl_stub();
		new StorageBl_driver(ss);
		
		StorageData_stub sds=new StorageData_stub();
		new StorageData_driver(sds);

		
		//member	
		MemberBl_stub ms=new MemberBl_stub();
		new MemberBl_driver(ms);
		
		MemberData_stub mds=new MemberData_stub();
		new MemberData_driver(mds);
		
		
		//BankAccount
		FinanceBlBankService bbs = new Bank_Stub();
		new Bank_Driver(bbs);
		
		//BankData
		FinanceBankDataService bds = new BankData_Stub();
		new BankData_Driver(bds);
		
		//FormAccount
		FinanceBlInitAllService bfs = new Form_Stub();
		new Form_Driver(bfs);
	}
	
	

}
