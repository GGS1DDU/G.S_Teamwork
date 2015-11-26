package elms.businesslogic.dealbl;

import java.text.DecimalFormat;

public class CalAndEst {
	public double calculatefee(String name1,String name2,String type,String pack,double weight,double volume){
		double fee=0;
			if(name1.equals("北京")){
				if(name2.equals("上海")){
					fee=19*weight/1000;
				}
				else if(name2.equals("广州")){
					fee=34*weight/1000;
				}
				else{
					fee=16.2*weight/1000;
				}
			}
			
			else if(name1.equals("上海")){
				if(name2.equals("北京")){
					fee=19*weight/1000;
				}
				else if(name2.equals("广州")){
					fee=21.8*weight/1000;
				}
				else {
					fee=4.8*weight/1000;
				}
			}
			
			else if(name1.equals("广州")){
				if(name2.equals("北京")){
					fee=34*weight/1000;
				}
				else if(name2.equals("上海")){
					fee=21.8*weight/1000;
				}
				else {
					fee=20.4*weight/1000;
				}
			}
			
			else if(name1.equals("南京")){
				if(name2.equals("北京")){
					fee=16.2*weight/1000;
				}
				else if(name2.equals("广州")){
					fee=20.4*weight/1000;
				}
				else {
					fee=4.8*weight/1000;
				}
			}
		
			if(type.equals("标准快递")){
				fee=fee/18*23;
			}
			else if(type.equals("特快专递")){
				fee=fee/18*25;
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
	
	
	
	
	
	public int estDays(String name1,String name2){
		int days=0;	
		
		return days;
	}
	
}
