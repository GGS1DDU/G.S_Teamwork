package ELMS.vo;

public class FreightStrategyVO {
	double distance;
	String expressCategory;
	double standardPriceEachKM;
	double economyPriceEachKM;
	double fastPriceEachKM;
	int coefficient;
	public FreightStrategyVO(double distance, double standardPrice,double economyPrice, 
			double fastPrice, int coefficient) {
		this.distance = distance;
		
		this.standardPriceEachKM = standardPrice;
		this.economyPriceEachKM = economyPrice;
		this.fastPriceEachKM = fastPrice;
		this.coefficient=coefficient;
	}
	
	public void setDistance(double distance){
		this.distance = distance;
	}
	
	public double getDistance() {
		return distance;
	}
	
	
	public void setExpressCategory(String category){
		this.expressCategory = category;
	}
	
	public String getExpressCategory() {
		return expressCategory;
	}
	
	public void setStandardPrice(double price){
		this.standardPriceEachKM = price;
	}
	
	public double getStandardPrice() {
		return standardPriceEachKM;
	}
	
	public void setEconomyPrice(double price){
		this.economyPriceEachKM = price;
	}
	
	public double getEconomyPrice(){
		return economyPriceEachKM;
	}
	
	public void setFastPrice(double price){
		this.fastPriceEachKM = price;
	}
	
	public double getFastPrice(){
		return fastPriceEachKM;
	}
	
	public void setCoefficient(int coefficient){
		this.coefficient = coefficient;
	}
	
	public int getCoefficient(){
		return coefficient;
	}	
}
