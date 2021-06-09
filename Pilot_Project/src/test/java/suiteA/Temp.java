package suiteA;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Temp {

	public static void main(String[] args) {
		//Date d = new Date();
		Date cuurentdate = new Date();
		System.out.println(cuurentdate);
		//System.out.println(d.toString());
		
		String Date_Select = "03-02-2021";
		
		SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
		
		
		
		
		try {
				Date DateToSelect = sd.parse(Date_Select);
				if(DateToSelect.compareTo(cuurentdate)==1) {
				
				System.out.println("cuurent is greater then date to seelct");
				}else if (DateToSelect.compareTo(cuurentdate)==-1) {
					
					System.out.println("cuurent is less then current");
					
				}
				String day = new SimpleDateFormat("dd").format(DateToSelect);
				System.out.println(day);
				String month = new SimpleDateFormat("MMMM").format(DateToSelect);
				System.out.println(month);
				String year = new SimpleDateFormat("yyyy").format(DateToSelect);
				System.out.println(year);
				String MOS = month+" "+year;
				System.out.println(MOS);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}
