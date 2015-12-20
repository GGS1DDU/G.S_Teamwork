package elms.businesslogic.dealbl;

import java.text.DecimalFormat;

/**
 * @author ZWH
 * @version 1.0
 * 
 */
public class CalFee {
	/**
	 * 
	 * @param name1
	 * @param name2
	 * @param type
	 * @param pack
	 * @param weight
	 * @param volume
	 * @return fee
	 */
	public double calculatefee(String name1,String name2,String type,String pack,double weight,double volume){
		int p=23;    //标准快递的运费价格
		Double distance=1064.7;
		Double fee=(distance/1000)*p*(weight/1000);
		
		if(type.equals("标准快递")){
			fee=1*fee;
		}
	 	
		else if(type.equals("经济快递")){
			fee=fee/23*18;
		}
		else{
			fee=fee/23*25;
		}
		
		if(pack.equals("纸箱")){
			fee=fee+5;
		}
		
		else if(pack.equals("木箱")){
			fee=fee+10;
		}
		
		else if(pack.equals("快递袋")){
			fee=fee+1;
		}
		
		DecimalFormat df=new DecimalFormat("#.00");
		fee=Double.valueOf(df.format(fee));
		
		return fee;
	}
}
