package elms.po;

import java.io.Serializable;


/*
 * id:1 南京  2 上海    3 广州    4 北京
*/
public class FreightStrategyPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	String city1;
	String city2;
	String id;
	double distance;
	int standardPriceEachKM;

	int coefficient;
	
	public FreightStrategyPO(){
		
	}
	
	public FreightStrategyPO(String id,String city1,String city2,double distance, int standardPrice, int coefficient) {
		
		this.city1 = city1;
		this.city2 = city2;
		
		this.id = id;
		
		this.distance = distance;
		
		this.standardPriceEachKM = standardPrice;
	
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
	
	public void setStandardPrice(int price){
		this.standardPriceEachKM = price;
	}
	
	public int getStandardPrice() {
		return standardPriceEachKM;
	}
	
	public void setCoefficient(int coefficient){
		this.coefficient = coefficient;
	}
	
	public int getCoefficient(){
		return coefficient;
	}	
}