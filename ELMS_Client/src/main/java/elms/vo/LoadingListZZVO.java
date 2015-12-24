package elms.vo;

import java.util.ArrayList;

public class LoadingListZZVO extends InvoiceVO{
	//ZZZX loadingList
			String id;//单据id
			String time;//装车日期
			String transportNumber;//汽运编号
			String arrival;//到达地
			String carNumber;//车辆代号
			String surpervisor;//监装员
			String supercargo;//押运员
			String orderNumber;
//			ArrayList<String> orderNumber;
			double cost;//运费
			String place;
			String maker;
			String auditState;
			public LoadingListZZVO(String id,String time,String transportNumber,String arrival,String carNumber,
					String surpervisor,String supercargo,String orderNumber,double cost,String p,String maker,String auditState){
				this.id=id;
				this.time=time;
				this.transportNumber=transportNumber;
				this.arrival=arrival;
				this.carNumber=carNumber;
				this.surpervisor=surpervisor;
				this.supercargo=supercargo;
				this.orderNumber=orderNumber;
				this.cost=cost;		
				this.place=p;
				this.maker=maker;
				this.auditState=auditState;
			}

			public String getID(){
				return id;
			}
			public String getTime(){
				return time;
			}
			public String getTransportNumber(){
				return transportNumber;
			}
			public String getArrival(){
				return arrival;
			}
			public String getCarNumber(){
				return carNumber;
			}
			public String getSurpervior(){
				return surpervisor;
			}
			public String getSupercargo(){
				return supercargo;
			}
			public String getOrderNumber(){
				return orderNumber;
			}
			public double getCost(){
				return cost;
			}
			public String getPlace(){
				return place;
			}
			public String getMaker(){
				return maker;
			}
			
			public String getAuditState(){
				return auditState;
			}
}
