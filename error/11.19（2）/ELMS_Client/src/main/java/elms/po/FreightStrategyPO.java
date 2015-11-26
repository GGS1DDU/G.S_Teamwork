package elms.po;

import java.io.Serializable;



public class FreightStrategyPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	/**
	 * 
	 */
	
	String city1;
	String city2;
	String id;
	double distance;
	String expressCategory;
	double standardPriceEachKM;
	double economyPriceEachKM;
	double fastPriceEachKM;
	int coefficient;
	public FreightStrategyPO(String id,String city1,String city2,double distance, double standardPrice,double economyPrice, 
			double fastPrice, int coefficient) {
		
		this.city1 = city1;
		this.city2 = city2;
		
		this.id = id;
		
		this.distance = distance;
		
		this.standardPriceEachKM = standardPrice;
		this.economyPriceEachKM = economyPrice;
		this.fastPriceEachKM = fastPrice;
		this.coefficient=coefficient;
	}
	
	public void setID(String id){
		this.id = id;
	}
	
	public String getID(){
		return id;
	}
	
	public void setCity1(String city){
		this.city1 = city;
	}
	
	public String getCity1(){
		return this.city1;
	}
	
	public void setCity2(String city){
		this.city2 = city;
	}
	
	public String getCity2(){
		return this.city2;
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