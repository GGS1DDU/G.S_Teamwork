package elms.presentation.uihelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckFormat {

	//检验格式是否为两位字母加n-2位数字
	public boolean checkID(String str, String id, int length) {
		String s = str;
		if (s.length() == length && s.substring(0, 2).equals(id)) {
			Pattern pattern = Pattern.compile("[0-9]*");
			Matcher isNum = pattern.matcher(s.substring(2, s.length()));
			if (isNum.matches()) {
				return true;
			}
		}
		return false;
	}
	
	//检验
	public boolean checkID(String str,int length){
		String s = str;
		String id = s.substring(0, 2);
		Pattern p = Pattern.compile("[a-z]*");
		Matcher isCh = p.matcher(id);
		if(!isCh.matches()){
			return false;
		}else if(s.length()!=length){
			return false;
		}else{
			Pattern pattern = Pattern.compile("[0-9]*");
			Matcher isNum = pattern.matcher(s.substring(2, s.length()));
			if (isNum.matches()) {
				return true;
			}
			return false;
		}
		
	}

	//检验一个字符串是不是length长度的数字组成
	public boolean checkNum(String str, int length) {
		if (str.length() != length) {
			return false;
		} else {
			Pattern pattern = Pattern.compile("[0-9]*");
			Matcher isNum = pattern.matcher(str);
			if (isNum.matches()) {
				return true;
			} else {
				return false;
			}
		}
	}

	//检验一个字符串是不是符合format要求的日期格式
	public boolean checkData(String dateFormat, String date){
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		boolean convertSuccess = true;
		
		try{
			// 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01// 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
			sdf.setLenient(false);
			sdf.parse(date);
		}catch(ParseException e){
			convertSuccess = false;
		}
		
		
		return convertSuccess;
	}

	//判断第二个时间是否小于当前时间
	public boolean lessThan(String dateFormat,String date1,String date2){
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		boolean less = true;
		
		try {
			Date d1 = sdf.parse(date1);
			Date d2 = sdf.parse(date2);
			if(d1.getTime()>d2.getTime()){
				less = false;
			}
			return less;
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return false;
		}
		
		
	}
	
	//检验一个字符串是不是double
	public boolean checkDouble(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	//检验一个字符串是不是由整数组成
	public boolean checkInteger(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
