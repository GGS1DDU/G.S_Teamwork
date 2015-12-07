package elms.businesslogic.dealbl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import elms.vo.DealVO;

public class Courier {
	ArrayList<DealVO> arr=new ArrayList<DealVO>();
	
	/**
	 * 获得对应姓名的快递员当月快递件数的方法
	 */
	public int getNumberOfOrderThisMonth(String name) throws IOException{
		int number=0;
		DealBL db=new DealBL();
		ArrayList<DealVO> All=db.FindAllOrder();
		Date dt=new Date();
		SimpleDateFormat matter=new SimpleDateFormat("yyyy-MM-dd");
		String nowtime=matter.format(dt);
		String[] YearAndMonth=nowtime.split("-");
		
		
		for(int i=1;i<All.size();i++){
			String [] temp=All.get(i).getDealTime().split("-");
			if((All.get(i).getCourier_name().equals(name))&&(temp[0].equals(YearAndMonth[0]))&&(temp[1].equals(YearAndMonth[1]))){
				number++;
			}			
		}
		
		return number;
	}

}
