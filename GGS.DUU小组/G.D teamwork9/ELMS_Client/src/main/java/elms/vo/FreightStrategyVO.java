package elms.vo;

public class FreightStrategyVO extends FinanceVO{
	String city1;
	String city2;
	String id;
	double distance;
	String expressCategory;
	int standardPriceEachKM;

	int coefficient;
	public FreightStrategyVO(String id, String city1, String city2, double distance, int standardPrice,int coefficient) {
		this.id = id;
		this.city1 = city1;
		this.city2 = city2;
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
	
	
	public void setExpressCategory(String category){
		this.expressCategory = category;
	}
	
	public String getExpressCategory() {
		return expressCategory;
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
