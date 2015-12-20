package elms.businesslogic.storagebl;
/*
 * 这个类负责构建库存对象  并且设置相应的库存分区大小数值
 * 默认的库存大小为三个100的固定区 和1000的机动区
 * 在理论上   机动区应当为无限大
 */
public class StorageCapacity {
String name;
int air=100;
int train=100;
int tory=100;
int temp=1000;
public StorageCapacity(String name) {
	this.name = name;
}
public String getName() {
	return name;
}
public int getAir() {
	return air;
}
public void setAir(int air) {
	this.air = air;
}
public int getTrain() {
	return train;
}
public void setTrain(int train) {
	this.train = train;
}
public int getTory() {
	return tory;
}
public void setTory(int tory) {
	this.tory = tory;
}
public int getTemp() {
	return temp;
}
public void setTemp(int temp) {
	this.temp = temp;
}

}
