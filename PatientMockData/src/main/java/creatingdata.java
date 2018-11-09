import java.util.Date;
import java.util.Random;

import org.fluttercode.datafactory.impl.DataFactory;

public class creatingdata {

	public int randomDigit(int num)
	{   int n2=num-1;
		int number=1;
		
		while((n2) > 0)
		{
			number*=10;
			n2--;
		}
		Random rnd = new Random();
		int n1 = 1*number + rnd.nextInt(9*number);
		return n1;
	}
	public static void main(String[] args) {
		DataFactory df = new DataFactory();
		for (int i = 0; i < 3; i++) {
			String name = df.getFirstName() + " "+ df.getLastName();
		}
		
		for (int i = 0; i < 2; i++) {
			String address = df.getAddress()+","+df.getCity()+","+df.getNumberText(5);
			String business = df.getBusinessName();			
		}
		
		Date minDate = df.getDate(2000, 1, 1);
		Date maxDate = new Date();
		for (int i = 0; i < 2	; i++) {
			Date start = df.getDateBetween(minDate, maxDate);
//			System.out.println("Date = "+start);
		}
		
/*		System.out.println(df.getEmailAddress());
		System.out.println(df.getRandomWord(2));
		System.out.println(df.getRandomChar());*/
		creatingdata cd=new creatingdata();
		int num = cd.randomDigit(1);
		
			}
}
