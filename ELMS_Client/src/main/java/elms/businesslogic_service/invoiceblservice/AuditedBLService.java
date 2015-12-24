package elms.businesslogic_service.invoiceblservice;

import java.io.IOException;

public interface AuditedBLService {
	public void pass(String id) throws IOException;
	
	public void unPass(String id) throws IOException;

}
