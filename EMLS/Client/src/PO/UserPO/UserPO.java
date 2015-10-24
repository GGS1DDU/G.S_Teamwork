package UserPO;
 
import java.io.Serializable;

public class UserPO implements Serializable {
	int id;
	String name;
	String password;
	UserRole role;
	
	public UserPO(int i,String n,String p,UserRole r){
		id=i;
		name=n;
		password=p;
		role=r;
	}	
	public String getName(){
		return name;	
	}
	public int getID(){
	return id;
	}
	public String getPassword(){
		return password;
	}
	public UserRole getRole(){
		return role;		
	}
}

