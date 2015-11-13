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
        	
    		LocateRegistry.createRegistry(1099);		
			DataFactory df=new DataFactoryImpl();
			java.rmi.Naming.rebind("rmi://localhost:1099/df",df);
			System.out.println("Server Ready!");
						
					
        }
        catch(Exception e){
        	throw new ServerInitException(e);
        }

}

}