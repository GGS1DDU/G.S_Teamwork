package elms.dataservice;

import elms.dataservice.dealdataservice.DealDataService;
import elms.dataservice.userdataservice.UserDataService;

public interface DataFactory {
	public UserDataService getUserData();
	public DealDataService getDealData();

}
