package org.b3ds.fhir.dicom.DicomDetials;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import com.b3ds.dicom.json.reader.StreamDicomMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.model.dstu2.composite.HumanNameDt;
import ca.uhn.fhir.model.dstu2.composite.IdentifierDt;
import ca.uhn.fhir.model.dstu2.composite.ResourceReferenceDt;
import ca.uhn.fhir.model.dstu2.resource.Device;
import ca.uhn.fhir.model.dstu2.resource.DiagnosticReport;
import ca.uhn.fhir.model.dstu2.resource.Patient;
import ca.uhn.fhir.model.dstu2.valueset.IdentifierUseEnum;
import ca.uhn.fhir.model.primitive.BoundCodeDt;

/**
 * Hello world!
 *
 */
public class DicomDetails 
{
		
	private void getDicomDetails(String str) throws FileNotFoundException
	{
		try
		{
		FhirContext ctx = FhirContext.forDstu2();
		InputStream in = new FileInputStream(new File(str));
		StreamDicomMapper mapper = new StreamDicomMapper(in);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		com.google.gson.JsonObject obj = gson.fromJson(mapper.transformedJson(), com.google.gson.JsonObject.class);
		Patient patient=new Patient();
		
		
		List<HumanNameDt> names = new ArrayList<>();
		HumanNameDt hm = new HumanNameDt();
		
		hm.setText(obj.get("PatientName").getAsString());
		names.add(hm);
		patient.setName(names);
		
		List<IdentifierDt> identifier=new ArrayList<>();
		IdentifierDt id=new IdentifierDt();
		id.setSystem(obj.get("PatientID").getAsString());
		identifier.add(id);
		patient.setIdentifier(identifier);

		String string =obj.get("PatientBirthDate").getAsString();
		System.out.println(getString(string));
		
		DateFormat format = new SimpleDateFormat("yyyy/mm/dd", Locale.ENGLISH);
		
		Date date = format.parse(getString(string));
		
		System.out.println(date);
		System.out.println(date);
		patient.setBirthDateWithDayPrecision(date);
	
		
		Device device=new Device();
		
		device.setModel(obj.get("ManufacturerModelName").getAsString());
		device.setVersion(obj.get("DeviceSerialNumber").getAsString());
		
		
		
		DiagnosticReport diagnosticReport=new DiagnosticReport();
		diagnosticReport.setId(getUUID());
		ResourceReferenceDt rr=new ResourceReferenceDt();
		rr.setDisplay(obj.get("ReferringPhysicianName").getAsString());
		diagnosticReport.setPerformer(rr);
		
		
		
		String encodedPatient = ctx.newJsonParser().setPrettyPrint(true).encodeResourceToString(patient);
		String encodedDevice = ctx.newJsonParser().setPrettyPrint(true).encodeResourceToString(device);
		String encodedDiagnostic = ctx.newJsonParser().setPrettyPrint(true).encodeResourceToString(diagnosticReport);

		System.out.println(encodedPatient);
		System.out.println(encodedDevice);
		System.out.println(encodedDiagnostic);
		
		}catch(Exception e)
		{
			System.out.println("Certain Fields are not Available in the file");
		}
		
	}
	
	private String getUUID()
	{
		UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();
		System.out.println("Random UUID String = " + randomUUIDString);
		System.out.println("UUID version       = " + uuid.version());
		System.out.println("UUID variant       = " + uuid.variant());    
		return randomUUIDString;
	}
	
	private String getString(String str1)
	{
	 String str = str1;
	 String split="";
	    String []splitterString=str.split("\"");
	    for (String s : splitterString) 
	        split+=s;
	    
	    char arr[]=new char[10];
	    String date="";
	    String month="";
	    String year="";
	    arr=split.toCharArray();
	    for(int i=0;i<arr.length;i++)
	    {
	    	if(i>=0 && i<4)
	    	year=year+arr[i];
	    	if(i>=4 && i<6)
	    	month=month+arr[i];
	    	if(i>=6 && i<8)
	    	date=date+arr[i];
	    	
	    	
	    }
		String fulldate=year +"/"+month+"/"+date;
	    
	    return fulldate;
	}

public static void main(String[] args) throws FileNotFoundException {
	DicomDetails details=new DicomDetails();
	details.getDicomDetails( "C:\\Users\\Vaibhav Shukla\\Desktop\\ttfm1.json");
}
}
