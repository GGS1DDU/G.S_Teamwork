package elms.businesslogic.dealbl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import elms.vo.DealVO;
/**
 * 
 * @author ZWH
 *
 */
public class EstDay {
	/**
	 * 估算订单到达日期。
	 * @param name1
	 * @param name2
	 * @return result
	 */
	public int Estimate(String name1,String name2) {
		DealBL db=new DealBL();
		int result=0;
		ArrayList<DealVO> AllOrder = null;
		try {
			AllOrder = db.FindAllOrder();
		} catch (IOException e) {
			e.printStackTrace();
		} //找到所有订单。		
		 ArrayList<Integer> arr=new ArrayList<Integer>();
		 
		 for(int i=1;i<AllOrder.size();i++){
			 if(!(AllOrder.get(i).getReceivaltime().equals(" "))){	
				 if((AllOrder.get(i).getSender_city().equals(name1))&&(AllOrder.get(i).getReceiver_city().equals(name2))){
					 System.out.println("寄件时间："+AllOrder.get(i).getDealTime()+"收件时间："+AllOrder.get(i).getReceivaltime());
					 int temp=(int)DaysBetweenTwoData(AllOrder.get(i).getDealTime(),AllOrder.get(i).getReceivaltime());
					 arr.add(temp);			 
			 	}
			 }
		 }
		 if(arr.isEmpty()){
			 return 0;
		 }
		 else{
			 for(int i=0;i<arr.size();i++){
				 result=result+arr.get(i);
			 }
			 result=result/arr.size();
			 return result;
		 }
	}


/**
 * 计算两个日期之间的天数。
 * @param time1
 * @param time2
 * @return result
 */
	private static long DaysBetweenTwoData(String time1,String time2){
		long result=0;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try{
			Date date1=sdf.parse(time1);
			Date date2=sdf.parse(time2);
			System.out.println(date2.getTime());
			System.out.println(date1.getTime());
			result=date2.getTime()-date1.getTime();
			result=result/1000/60/60/24;
			
		}catch(Exception e){
			e.printStackTrace();
			}
		return result;
		}
	}
