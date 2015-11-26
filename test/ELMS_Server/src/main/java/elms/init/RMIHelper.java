package elms.init;

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;

import elms.data.DataFactoryImpl;
import elms.dataservice.DataFactory;




public class RMIHelper {

	
	private static boolean inited = false;
	
	
	public synchronized static void init() throws ServerInitException {
        if (inited) {
            return;
        }
        try{
        	
        	System.setProperty("java.rmi.server.hostname", "192.168.191.1");
    		LocateRegistry.createRegistry(1099);		
			DataFactory df=new DataFactoryImpl();
			
			java.rmi.Naming.rebind("rmi://192.168.191.1:1099/df",df);
			System.out.println("Server Ready!");
						
					
        }
        catch(Exception e){
        	throw new ServerInitException(e);
        }

}

}