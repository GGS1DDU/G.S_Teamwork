package elms.vo;

public class AccountVO {
	String name;
	String operator;
	String date;
	public String getName() {
		return name;
	}
	public String getOperator() {
		return operator;
	}
	public String getDate() {
		return date;
	}
	public AccountVO(String name, String operator, String date) {
		super();
		this.name = name;
		this.operator = operator;
		this.date = date;
	}
}
