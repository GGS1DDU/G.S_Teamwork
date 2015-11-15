package elms.po;

import java.io.Serializable;

public class DealPO implements Serializable{
	
		
		

		 String OrderID;
		 String courier_name; 
		 String hall;  //应该用枚举
		 String dealTime; //生成该订单的日期 
		 
		 String sender_name;
		 String sender_city;  //应该用枚举
		 String sender_company;
		 String sender_phonenumber;
		 
		 String receiver_name;
		 String receiver_city;  //应该用枚举
		 String receiver_company;
		 String receiver_phonenumber;
		 
		 String goods_name;
		 int goods_amount;
		 double goods_weight;
		 double goods_volume;
		 
		 String type; //应该用枚举
		 String pack; //应该用枚举
		 
		 double fee;  //邮费+包装费
		 int delaydays; //预计到达所需天数
		 
		 String actualreceiver_name;
		 String receivaltime;
		 
		 String track;
		 
		 String state; //应该用枚举
		 
		 
		 
		 public DealPO(String orderID, String courier_name, String hall,
					String dealTime, String sender_name, String sender_city,
					String sender_company, String sender_phonenumber,
					String receiver_name, String receiver_city,
					String receiver_company, String receiver_phonenumber,
					String goods_name, int goods_amount, double goods_weight,
					double goods_volume, String type, String pack, double fee,
					int delaydays, String actualreceiver_name, String receivaltime,
					String track, String state) {
				super();
				OrderID = orderID;
				this.courier_name = courier_name;
				this.hall = hall;
				this.dealTime = dealTime;
				this.sender_name = sender_name;
				this.sender_city = sender_city;
				this.sender_company = sender_company;
				this.sender_phonenumber = sender_phonenumber;
				this.receiver_name = receiver_name;
				this.receiver_city = receiver_city;
				this.receiver_company = receiver_company;
				this.receiver_phonenumber = receiver_phonenumber;
				this.goods_name = goods_name;
				this.goods_amount =goods_amount;
				this.goods_weight = goods_weight;
				this.goods_volume = goods_volume;
				this.type = type;
				this.pack = pack;
				this.fee = fee;
				this.delaydays = delaydays;
				this.actualreceiver_name = actualreceiver_name;
				this.receivaltime = receivaltime;
				this.track = track;
				this.state = state;
			}



		public DealPO() {
			// TODO Auto-generated constructor stub
		}







		public String getOrderID() {
			return OrderID;
		}



		public String getCourier_name() {
			return courier_name;
		}



		public String getHall() {
			return hall;
		}



		public String getDealTime() {
			return dealTime;
		}



		public String getSender_name() {
			return sender_name;
		}



		public String getSender_city() {
			return sender_city;
		}



		public String getSender_company() {
			return sender_company;
		}



		public String getSender_phonenumber() {
			return sender_phonenumber;
		}



		public String getReceiver_name() {
			return receiver_name;
		}



		public String getReceiver_city() {
			return receiver_city;
		}



		public String getReceiver_company() {
			return receiver_company;
		}



		public String getReceiver_phonenumber() {
			return receiver_phonenumber;
		}



		public String getGoods_name() {
			return goods_name;
		}



		public int getGoods_amount() {
			return goods_amount;
		}



		public double getGood_weight() {
			return goods_weight;
		}



		public double getGood_volume() {
			return goods_volume;
		}



		public String getType() {
			return type;
		}



		public String getPack() {
			return pack;
		}



		public double getFee() {
			return fee;
		}



		public int getDelaydays() {
			return delaydays;
		}



		public String getActualreceiver_name() {
			return actualreceiver_name;
		}



		public String getReceivaltime() {
			return receivaltime;
		}



		public String getTrack() {
			return track;
		}



		public String getState() {
			return state;
		}
		 
	 
	 
	
}



