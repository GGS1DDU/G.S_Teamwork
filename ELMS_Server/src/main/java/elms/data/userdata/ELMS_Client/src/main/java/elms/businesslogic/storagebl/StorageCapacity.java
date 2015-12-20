package elms.businesslogic.storagebl;

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
