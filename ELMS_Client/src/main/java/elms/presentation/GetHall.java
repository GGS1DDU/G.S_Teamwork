package elms.presentation;

public class GetHall {

	public String getHallId(String hall){
		String result = null;
		if(hall.equals("南京市仙林营业厅")){
			result = "01";
		}else if(hall.equals("南京市鼓楼营业厅")){
			result = "02";
		}
		
		return result;
	}
}
