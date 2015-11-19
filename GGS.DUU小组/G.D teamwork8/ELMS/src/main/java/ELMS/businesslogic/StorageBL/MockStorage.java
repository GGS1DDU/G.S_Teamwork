package ELMS.businesslogic.StorageBL;

import ELMS.vo.StorageVO;

public class MockStorage extends StorageVO{

	public MockStorage(String id, String area, String seat, String order,
			String timeIn, String timeOut, Enum<State> state, String name) {
		super(id, area, seat, order, timeIn, timeOut, state, name);
		// TODO Auto-generated constructor stub
	}

}
