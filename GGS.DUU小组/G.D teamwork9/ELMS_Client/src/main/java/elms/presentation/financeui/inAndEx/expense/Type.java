package elms.presentation.financeui.inAndEx.expense;

public enum Type {
	wages(1),freight(2),rent(3);
	
	private int cNode;
	
	private Type(int node){
		cNode = node;
	}
	
	public String toString(){
		return String.valueOf(this.cNode);
	}
}
