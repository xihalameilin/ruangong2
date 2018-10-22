package utility;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DatetoString {

	public static String datetostr(Date d){
		String str="";
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		str=sdf.format(d);
		return str;	
	}
	
	public static String datetostr2(Date d){
		String str="";
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd-HH");
		str=sdf.format(d);
		return str;	
	}
}
