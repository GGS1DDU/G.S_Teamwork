package DealPO;

import UserPO.UserPO;

public class DealPO {
String id;
String consigner;
String consignee;
String time;
String expressCategory;
String goodsMessage;
String packing;
double postage;
UserPO courier;
String expressPath;
String shop;

public DealPO(String i,String c1,String c2,
		String t,String ec,String g,String pk,
		double pt,UserPO c,String ep,String sp){
	id=i;
	consigner=c1;
	consignee=c2;
	time=t;
	expressCategory=ec;
	goodsMessage=g;
	packing=pk;
	postage=pt;
	courier=c;
	expressPath=ep;
	shop=sp;
}
public String getID(){
	return id;
}
public String getConsigner(){
	return consigner;
}
public String getConsignee(){
	return consignee;
}
public String getTime(){
	return time;
}
public String getExpressCategory(){
	return expressCategory;
}
public String getGoodsMessage(){
	return goodsMessage;
}
public String getPacking(){
	return packing;
}
public double getPostage(){
	return postage;
}
public UserPO getCourier(){
	return courier;
}
public String getExpressPath(){
	return expressPath;
}
public String getShop(){
	return shop;
}
}
