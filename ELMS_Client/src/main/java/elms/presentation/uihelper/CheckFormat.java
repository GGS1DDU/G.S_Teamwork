package elms.presentation.uihelper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckFormat {

	public boolean checkID(String str) {
		String s = str;
		if (s.length() == 10 && s.substring(0, 2).equals("ex")) {
			Pattern pattern = Pattern.compile("[0-9]*");
			Matcher isNum = pattern.matcher(s.substring(2, s.length()));
			if (isNum.matches()) {
				return true;
			}
		}
		return false;
	}

	public boolean checkDouble(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public boolean checkInteger(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
