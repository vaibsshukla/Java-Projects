package org.b3ds.fhir.patient.mockdata.function;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.model.api.ExtensionDt;
import ca.uhn.fhir.model.dstu2.composite.AddressDt;
import ca.uhn.fhir.model.dstu2.composite.BoundCodeableConceptDt;
import ca.uhn.fhir.model.dstu2.composite.CodeableConceptDt;
import ca.uhn.fhir.model.dstu2.composite.CodingDt;
import ca.uhn.fhir.model.dstu2.composite.ContactPointDt;
import ca.uhn.fhir.model.dstu2.composite.HumanNameDt;
import ca.uhn.fhir.model.dstu2.composite.IdentifierDt;
import ca.uhn.fhir.model.dstu2.resource.Patient;
import ca.uhn.fhir.model.dstu2.valueset.AddressUseEnum;
import ca.uhn.fhir.model.dstu2.valueset.ContactPointSystemEnum;
import ca.uhn.fhir.model.dstu2.valueset.ContactPointUseEnum;
import ca.uhn.fhir.model.dstu2.valueset.IdentifierUseEnum;
import ca.uhn.fhir.model.dstu2.valueset.MaritalStatusCodesEnum;
import ca.uhn.fhir.model.dstu2.valueset.NameUseEnum;
import ca.uhn.fhir.model.primitive.BoundCodeDt;
import ca.uhn.fhir.parser.IParser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.IOUtils;
import org.b3ds.fhir.patient.mockdata.function.*;
import org.hl7.fhir.dstu3.model.codesystems.MaritalStatus;

import com.google.gson.JsonSyntaxException;

public class Applicaion {

	public static void main(String args[]) throws IOException
	{
		FhirContext ctx = FhirContext.forDstu2();
		Patient patient=new Patient();
		IParser parser = ctx.newJsonParser();
		FileInputStream fis = new FileInputStream(new File("D://patientdata.json"));
		String str = IOUtils.toString(fis);
		patient = (Patient) parser.parseResource(str);
		try
		{
		
			for(int i=0;i<10;i++)
			{
/*				FhirContext ctx = FhirContext.forDstu2();
				Patient patient=new Patient();
				FileInputStream fis = new FileInputStream(new File("D://patientdata.json"));*/
				
				RandamDataFunctions rand=new RandamDataFunctions();
				
				Name name = rand.getRandomName();
				Address address=rand.getRandomAddress();
				
				List<IdentifierDt> identifier=new ArrayList<>();
				IdentifierDt id=new IdentifierDt();
				id.setUse((BoundCodeDt<IdentifierUseEnum>) new BoundCodeDt<>().setValue("usual"));
				id.setSystem(rand.getRandomIdentifierSystem());
				id.setValue(rand.getRandomIdentifierValue());
				identifier.add(id);
				patient.setIdentifier(identifier);
				
				List<HumanNameDt> names = new ArrayList<>();
				HumanNameDt hm = new HumanNameDt();
				hm.setUse((BoundCodeDt<NameUseEnum>) new BoundCodeDt<>().setValue("usual"));
				String fullname=name.getFullname();
				String[] arr=new String[50];
				arr=rand.getIndividualName(fullname);
				hm.setText(fullname);
				hm.addGiven(arr[0]);
				hm.addFamily(arr[1]);
				names.add(hm);
				patient.setName(names);
				
				
				List<AddressDt> address1=new ArrayList<>();
				AddressDt ad=new AddressDt();
				ad.setUse((BoundCodeDt<AddressUseEnum>) new BoundCodeDt<>().setValue("usual"));
				ad.addLine(address.getAddressLine1());
				ad.setCity(address.getCity());
				ad.setPostalCode(address.getPostalcode());
				address1.add(ad);
				patient.setAddress(address1);
				
				List<ContactPointDt> telecom=new ArrayList<>();
				ContactPointDt cp=new ContactPointDt();
				cp.setSystem((BoundCodeDt<ContactPointSystemEnum>) new BoundCodeDt<>().setValue("Phone"));
				cp.setValue(rand.getRandomPhoneno());
				cp.setUse((BoundCodeDt<ContactPointUseEnum>) new BoundCodeDt<>().setValue(rand.getPhoneUse()));
				telecom.add(cp);
				patient.setTelecom(telecom);	
				
				patient.setBirthDateWithDayPrecision(rand.getRandomDOB());
				patient.setId(rand.getRandomId(fullname));
				
				String encoded = ctx.newJsonParser().setPrettyPrint(true).encodeResourceToString(patient);
				
				File file=new File(""); 
				
				System.out.println(encoded);
				System.out.println("-----------------------------------------------------------------------------------------------------------");
				}
				
				
				}catch(IllegalStateException | JsonSyntaxException exception)
				{
				System.out.println(exception);
				}
	}
}
