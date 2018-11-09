import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.util.Date;

import org.apache.commons.io.IOUtils;
import org.fluttercode.datafactory.impl.DataFactory;

import com.google.gson.JsonSyntaxException;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.model.dstu2.resource.Patient;
import ca.uhn.fhir.model.dstu2.valueset.NameUseEnum;
import ca.uhn.fhir.parser.IParser;


public class DeleteAfterUse {

	public static void main(String[] args) throws IOException {


		FhirContext ctx = FhirContext.forDstu2();
		IParser parser=ctx.newJsonParser();
		for(int i=0;i<2;i++)
		{
			Patient patient=new Patient();
			DataFactory df = new DataFactory();
			for (int j = 0; j < 4; j++) {
				String name = df.getFirstName() + " "+ df.getLastName();
				patient.addIdentifier().setSystem("http://example.com/fictitious-mrns").setValue(name);
				patient.addName().setUse(NameUseEnum.OFFICIAL).addFamily(df.getLastName()).addGiven(df.getFirstName()).addGiven("Q");							
		}
		
		for (int j = 0; j < 2; j++) {
			String address = df.getAddress()+","+df.getCity()+","+df.getNumberText(5);
			String business = df.getBusinessName();
			System.out.println(business + " located at " + address);
			patient.addAddress().addLine(df.getAddress()).setCity(df.getAddress()).setPostalCode(df.getNumberText(6));
		}
		
		Date minDate = df.getDate(2000, 1, 1);
		Date maxDate = new Date();
		for (int j = 0; j < 1	; j++) {
			Date start = df.getDateBetween(minDate, maxDate);
			System.out.println("Date = "+start);
			patient.setBirthDateWithDayPrecision(start);
		}
		
				
		try
		{
		FileInputStream fis = new FileInputStream(new File("D://patientdata.json"));
		
		String str = IOUtils.toString(fis);		 
		String encoded = ctx.newJsonParser().setPrettyPrint(true).encodeResourceToString(patient);
		System.out.println(encoded);

		
		}catch(IllegalStateException | JsonSyntaxException exception)
		{
		System.out.println(exception);
		}
		}
	}
}


