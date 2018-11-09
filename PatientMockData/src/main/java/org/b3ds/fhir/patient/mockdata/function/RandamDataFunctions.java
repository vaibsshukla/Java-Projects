package org.b3ds.fhir.patient.mockdata.function;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.Set;

import org.apache.commons.codec.digest.DigestUtils;
import org.fluttercode.datafactory.impl.DataFactory;
class Name
{
	private String fullname;
	private String firstName;
	private String lastName;
	
	public Name(String fullname, String fname, String lname)
	{
		
		this.lastName=lname;
		this.firstName=fname;
		this.fullname=lname+fname;
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname=fullname;
	}
}


class Address
{
		private String addressline1;
		private String city;
		private String postalcode;
		
		public Address(String addressline1,String city,String postalcode)
		{
			this.addressline1=addressline1;
			this.city=city;
			this.postalcode=postalcode;
			
		}
		public String getAddressLine1() {
			return addressline1;
		}
		public void setAddressLine1(String addressLine1) {
			this.addressline1 = addressLine1;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getPostalcode() {
			return postalcode;
		}
		public void setPostalcode(String postalcode) {
			this.postalcode = postalcode;
		}
		
}

 class RandamDataFunctions {
	 
	 
	 public String getRandomChar()
		{
			String[] str={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z",
					      "a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z",
							};
			Random rand=new Random();
			String chr=str[rand.nextInt(str.length)];
			return chr;
		}
	 
	/// "Tbt3KuCY0B5PSrJvCu2j-PlK.aiHsu2xUjUM8bWpetXoB"
	 public String GetRandomPatientId()
	 {
		 byte[] array = new byte[7]; // length is bounded by 7
		    new Random().nextBytes(array);
		    String generatedString = new String(array, Charset.forName("UTF-8"));
		 
		    System.out.println(generatedString);
		    return generatedString;
		    
	 }
		

		public Address getRandomAddress()
		{	

			String addressline1=null;
			String city=null;
			String postal=null;
			DataFactory df = new DataFactory();

				Address a1=new Address(df.getAddress(),df.getCity(),df.getNumberText(5));
				String business = df.getBusinessName();
			
			return a1;
		}	
	
		public String getRandomPhoneno()
	    {
	        int num1, num2, num3; //3 numbers in area code
	        int set2, set3; //sequence 2 and 3 of the phone number
	        
	        Random generator = new Random();
	        
	        //Area code number; Will not print 8 or 9
	        num1 = generator.nextInt(7) + 1; //add 1 so there is no 0 to begin  
	        num2 = generator.nextInt(8); //randomize to 8 becuase 0 counts as a number in the generator
	        num3 = generator.nextInt(8);
	        
	        // Sequence two of phone number
	        // the plus 100 is so there will always be a 3 digit number
	        // randomize to 643 because 0 starts the first placement so if i randomized up to 642 it would only go up yo 641 plus 100
	        // and i used 643 so when it adds 100 it will not succeed 742 
	        set2 = generator.nextInt(643) + 100;
	        
	        //Sequence 3 of number
	        // add 1000 so there will always be 4 numbers
	        //8999 so it wont succeed 9999 when the 1000 is added
	        set3 = generator.nextInt(8999) + 1000;
	        
	        String number="(" + num1 + "" + num2 + "" + num3 + ")" + "-" + set2 + "-" + set3 ;
	        
	        return number;
	    }
				
		public Name getRandomName()
		{	
			String firstname=null;
			String lastname=null;
			DataFactory df = new DataFactory();

			Name n1=new Name(df.getFirstName()+df.getLastName(),df.getFirstName(),df.getLastName());
			
			return n1;
		}
		
		
		public Date getRandomDOB()
		{	
			Date date=null;
			DataFactory df = new DataFactory();
			Date minDate = df.getDate(2000, 1, 1);
			Date maxDate = new Date();

			for (int j = 0; j < 1; j++) {
				 date = df.getDateBetween(minDate, maxDate);		}
			return date;
		}	
		
	
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
	
		//"system": "urn:oid:1.2.840.114350.1.13.327.1.7.5.737384.0"
	
		public String getRandomIdentifierSystem()
		{
			
			String system="urn:oid:"+randomDigit(1)+"."+randomDigit(1)+"."+randomDigit(3)+"."+randomDigit(6)+"."+randomDigit(1)
			+"."+randomDigit(2)+"."+randomDigit(3)+"."+randomDigit(1)+"."+randomDigit(1)+"."+randomDigit(1)+"."+randomDigit(6)+
			"."+randomDigit(1);
			return system;
		}
		
		public String  getRandomIdentifierValue()
		{
			String value=""+randomDigit(5);
			return value;
		}
		
		
		public String getMaritalStatus()
		{
			String[] str={"Married","Single"};
			Random rand=new Random();
			String status=str[rand.nextInt(str.length)];
			return status;
		}
		
		public String getPhoneUse()
		{
			String[] str={"home","Work","Mobile","temp"};
			Random rand=new Random();
			String use=str[rand.nextInt(str.length)];
			return use;
		}
		
		
		public String getAllergySubstance()
		{
			String[] str={"EGGS OR EGG-DERIVED PRODUCTS",
					"STRAWBERRY",
					"AMPICILLIN",
					"RAGS ALLERGEN",
					"PENICILLINS",
					"FLAVORING AGENT",
					"Shellfish",
					"TreeNuts",
					"Milk",
					"Sesame",
					"Gluten",
					"Sulphur"
};
			Random rand=new Random();
			String Allergy=str[rand.nextInt(str.length)];
			return Allergy;
		}
		
		
		public String[] getIndividualName(String name)
		{
			String s = name;
			String[] r = s.split("(?<=.)(?=\\p{Lu})");
			
			return r;
		}
		
		public String getRandomId(String name)
		{
			String Url = name;
			String hex= DigestUtils.md5Hex( Url ) ;
			return hex;
		}
		
		
	
	public static void main(String[] args) {
		
		RandamDataFunctions ran=new RandamDataFunctions();
		System.out.println(ran.getRandomId("vaibhav"));
		
	}
		
}
