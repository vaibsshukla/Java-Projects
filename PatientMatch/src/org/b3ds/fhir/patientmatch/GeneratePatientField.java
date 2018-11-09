																																																											package org.b3ds.fhir.patientmatch;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.apache.commons.io.IOUtils;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.model.dstu2.composite.ContactPointDt;
import ca.uhn.fhir.model.dstu2.composite.HumanNameDt;
import ca.uhn.fhir.model.dstu2.resource.Patient;
import ca.uhn.fhir.parser.IParser;

public class GeneratePatientField {

	
	private String getPatientMatch(String oldpatient,String newpatient) throws IOException
	{

		FhirContext ctx = FhirContext.forDstu2();		
		Patient patient=new Patient();	
		IParser parser = ctx.newJsonParser();
		patient = (Patient) parser.parseResource(newpatient);
		Map<String,String> newpatientmap=new HashMap<String,String>();
		newpatientmap=getFieldSet(patient);
		patient = (Patient) parser.parseResource(oldpatient);
		Map<String,String> oldpatientmap=new HashMap<String,String>();
		oldpatientmap=getFieldSet(patient);

		if(newpatientmap.get("name").equals(oldpatientmap.get("name")) && newpatientmap.get("dob").equals(oldpatientmap.get("dob")) &&  newpatientmap.get("telecom").equals(oldpatientmap.get("telecom")))
		{
			return "Match Found";
		}
		else
		{
			return "Match Not Foound";
		}
	}

	
	public Map<String,String> getFieldSet(Patient patient)
	{
		String name=getPatientName(patient);
		String dob=getPatientDOB(patient);
		String telecom=getPatientTelecom(patient);
		
		Map map=new HashMap();
		map.put("name", name);
		map.put("dob", dob);
		map.put("telecom", telecom);
		
		return map; 
				
	}
	
	private String getPatientName(Patient raw)
	{
		 List<HumanNameDt> humanl = raw.getName();
		 ListIterator<HumanNameDt> itr = humanl.listIterator();
		HumanNameDt human=new HumanNameDt();
		
		 List<HumanNameDt> newhuman = new ArrayList<>();
		 while(itr.hasNext())
		 {
			 HumanNameDt temp = itr.next();
			 newhuman.add(temp);
		 }
		 raw.setName(newhuman);
		 return raw.getName().get(0).getText();
	}
	
	private static String getPatientDOB( Patient raw)
	{
		String date=""+raw.getBirthDate();
		return date;
	}
	
	private static String getPatientTelecom(Patient raw)
	{
		 List<ContactPointDt> telecom = raw.getTelecom();
		 ListIterator<ContactPointDt> itr = telecom.listIterator();
		 ContactPointDt cd = new ContactPointDt();
		 
		 List<ContactPointDt> newTelecom = new ArrayList<>();
		 while(itr.hasNext())
		 {
			 ContactPointDt temp = itr.next();		 
			 newTelecom.add(temp);
		 }
		 raw.setTelecom(newTelecom);
		 return raw.getTelecom().get(0).getValue();
		
	}
	
	
	
}
