package trials;

import java.text.SimpleDateFormat;
import java.util.Date;

public class test {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Date d = new Date();
		String str = d.toString();
		System.out.print(str);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		String date = sdf.format(d);
		System.out.print(date);
		
		
		
		
	}
}
