import java.util.Date;

import org.fluttercode.datafactory.impl.DataFactory;

public class DateOfBirth {

	
	public Date[] getRandomDOB(int noofdate)
	{	
		Date[] date=new Date[noofdate];
		DataFactory df = new DataFactory();
		Date minDate = df.getDate(2000, 1, 1);
		Date maxDate = new Date();

		for (int j = 0; j < noofdate; j++) {
			 date[j] = df.getDateBetween(minDate, maxDate);		}
		return date;
}	

	
}
