package ELMS.businesslogic.LogBL;

import ELMS.vo.LogVO;

public class MockLog extends LogVO{

	public MockLog(String id, String time, Enum category, String name) {
		super(id, time, category, name);
		// TODO Auto-generated constructor stub
	}
    public MockLog getMockLog(){
    	return this;
    }
}
