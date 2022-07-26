package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
	public static boolean isPhone(String phone){
        String checkPhone = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";
        Pattern pattern = Pattern.compile(checkPhone);
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }
}
