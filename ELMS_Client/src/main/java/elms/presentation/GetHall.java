package elms.presentation;

public class GetHall {

	public String getHallId(String hall){
		String result = null;
		switch(hall){
		case "南京市仙林营业厅":result = "01";break;
		case "南京市鼓楼营业厅": result = "02";break;
		}
		return result;
	}
}
