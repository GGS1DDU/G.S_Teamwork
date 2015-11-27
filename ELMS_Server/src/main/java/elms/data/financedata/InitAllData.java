package elms.data.financedata;

import java.io.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import elms.dataservice.financedataservice.InitAllDataService;

public class InitAllData extends UnicastRemoteObject implements InitAllDataService{
	
	public InitAllData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	static int i = 0;
	
	File file1 = new File("Income.ser");
	File file2 = new File("Expense.ser");
	
//	public static void main(String[] args) throws RemoteException{
//		InitAllData iad = new InitAllData();
//		
//		iad.save("张文玘");
//		iad.save("郑闻昊");
//	}
	
	public boolean initAll(String operator) throws RemoteException {
		
		delete();
		return false;
	}
	
	public void delete() throws RemoteException{
		file1.delete();
		file2.delete();
		file1 = new File("Income.ser");
		file2 = new File("Expense.ser");
	}

	public boolean save(String operator) throws RemoteException {
//		String separator = File.separator;
//		System.out.println(separator);
//		String directory = "E:"+separator+"GGS.DDU文档"+separator+"11.19（2）"+separator
//				+"历史记录"+separator+"version"+i;
//		File f = new File(directory,"version1");
//		  if(f.exists()) {
//	          // 文件已经存在，输出文件的相关信息
//	            System.out.println(f.getAbsolutePath());
//	            System.out.println(f.getName());
//	            System.out.println(f.length());
//	        } else {
//	          //  先创建文件所在的目录
//	            f.getParentFile().mkdirs();
//	            try {
//	             // 创建新文件
//	                f.createNewFile();
//	            } catch (IOException e) {
//	                System.out.println("创建新文件时出现了错误。。。");
//	                e.printStackTrace();
//	            }
//	        }
//		  
//		  
//		  i++;
//	       
		return false;
	}
}
