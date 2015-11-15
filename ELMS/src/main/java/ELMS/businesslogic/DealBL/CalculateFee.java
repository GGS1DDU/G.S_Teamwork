package ELMS.businesslogic.DealBL;


public class CalculateFee {
	
	public double calculatefee(MockFinanceStr mfs,MockDeal order){
		double fee=mfs.getP()*order.getGood_weight();
		if(order.getType().equals("经济快递")){
			fee=fee*18/23;
		}
		else if(order.getType().equals("次晨特快")){
			fee=fee*25/23;
			
		}
		
		if(order.getPack().equals("纸箱")){
			fee+=5;
		}
		else if(order.getPack().equals("木箱")){
			fee+=10;
		}
		else if(order.getPack().equals("快递袋")){
			fee+=1;
		}
		
		return fee;
	}
	

}
