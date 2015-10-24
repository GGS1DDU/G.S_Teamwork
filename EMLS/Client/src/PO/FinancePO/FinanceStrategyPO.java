package FinancePO;

public class FinanceStrategyPO {
double distance;
String expressCategory;
double priceEachKM;
int coefficient;
public FinanceStrategyPO(double distance, String expressCategory,
		double priceEachKM,int coeffcient, int coefficient) {
	this.distance = distance;
	this.expressCategory = expressCategory;
	this.priceEachKM = priceEachKM;
	this.coefficient=coefficient;
}
public double getDistance() {
	return distance;
}
public String getExpressCategory() {
	return expressCategory;
}
public double getPriceEachKM() {
	return priceEachKM;
}public int getCoefficient(){
	return coefficient;
}
}
