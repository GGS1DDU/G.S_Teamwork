package elms.businesslogic.dealbl;


/**
 * @author ZWH
 * @version 1.0
 */
public class CheckOrder {
	/**
	 * 
	 * @param ID
	 * @return
	 */
	public int IsTenNumbers(String ID){
		String [] id=ID.split("");
		if(id.length!=10){
			return 2;  //非10位
		}
		else{
			for(int i=0;i<10;i++){
				if(  (!id[i].equals("0"))&&(!id[i].equals("1"))&&(!id[i].equals("2"))&&(!id[i].equals("3"))&&(!id[i].equals("4"))&&(!id[i].equals("5"))&&(!id[i].equals("6"))&&(!id[i].equals("7"))&&(!id[i].equals("8"))&&(!id[i].equals("9"))   ){
					return 1; //有非数字
				}
			}
		}
		return 0;
		
	}

}
