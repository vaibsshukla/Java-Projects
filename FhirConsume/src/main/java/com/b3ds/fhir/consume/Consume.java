package com.b3ds.fhir.consume;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import org.apache.commons.io.IOUtils;
import org.hibernate.engine.transaction.jta.platform.internal.SynchronizationRegistryBasedSynchronizationStrategy;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.model.dstu2.composite.AddressDt;
import ca.uhn.fhir.model.dstu2.composite.ContactPointDt;
import ca.uhn.fhir.model.dstu2.composite.HumanNameDt;
import ca.uhn.fhir.model.dstu2.resource.Patient;
import ca.uhn.fhir.parser.IParser;

public class Consume {
	
	 private static final String BASE_URL = "https://open-ic.epic.com/FHIR/api/FHIR/DSTU2/";
	 private static final String id="Tbt3KuCY0B5PSrJvCu2j-PlK.aiHsu2xUjUM8bWpetXoB";
	
/*  	 IParser parser=ctx.newJsonParser();*/
	
	 public static void main(String[] args) throws IOException {
		 FhirContext ctx = FhirContext.forDstu2();
			Patient patient=new Patient();
			IParser parser = ctx.newJsonParser();
		/*	FileInputStream fis = new FileInputStream(new File("D://patientdata.json"));
			String str = IOUtils.toString(fis);
		*/
			patient = (Patient) parser.parseResource(Consume.getPatient(id));
			String encoded = ctx.newJsonParser().setPrettyPrint(true).encodeResourceToString(patient);
			
			try {
				 Encryption enc = new Encryption();

				//encryptedName(patient);
				//encryptedTelecomData(patient);
				 encryptedAddressData(patient);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
	
	 
	 
	 public static Patient encryptedName(Patient raw) throws Exception 
	 {
		 List<HumanNameDt> humanl = raw.getName();
		 ListIterator<HumanNameDt> itr = humanl.listIterator();
		HumanNameDt human=new HumanNameDt();
		
		 List<HumanNameDt> newhuman = new ArrayList<>();
		 Encryption enc = new Encryption();
		 while(itr.hasNext())
		 {
			 HumanNameDt temp = itr.next();
			 temp.setText(enc.encrypt(temp.getText()));
			 newhuman.add(temp);
		 }
		 raw.setName(newhuman);
		 System.out.println(raw.getName().get(0).getText());
		 return raw;
	 }
	 
	 
	 public static Patient encryptedTelecomData(Patient raw) throws Exception
	 {
		 List<ContactPointDt> telecom = raw.getTelecom();
		 ListIterator<ContactPointDt> itr = telecom.listIterator();
		 ContactPointDt cd = new ContactPointDt();
		 
		 List<ContactPointDt> newTelecom = new ArrayList<>();
		 Encryption enc = new Encryption();
		 while(itr.hasNext())
		 {
			 ContactPointDt temp = itr.next();
			 temp.setValue(enc.encrypt(temp.getValue()));
			 System.out.println(enc.encrypt(temp.getValue()));
			 newTelecom.add(temp);
		 }
		 raw.setTelecom(newTelecom);
		 System.out.println(raw.getTelecom().get(0).getValue());
		 return raw;
	 }
	 
	 public static Patient encryptedAddressData(Patient raw) throws Exception
	 {
		 List<AddressDt> address=raw.getAddress();
		 ListIterator<AddressDt> itr=address.listIterator();
		 AddressDt ad=new AddressDt();
		 
		 List<AddressDt> newAddress=new ArrayList<>();
		 Encryption enc=new Encryption();
		 while(itr.hasNext())
		 {
			// AddressDt[] temp=new AddressDt[25];
			 AddressDt temp=itr.next();
			 temp.setCity(enc.encrypt(temp.getCity()));
			 temp.setState(enc.encrypt(temp.getState()));
			 temp.setCountry(enc.encrypt(temp.getCountry()));
			 temp.setPostalCode(enc.encrypt(temp.getPostalCode()));
		 }
		 raw.setAddress(newAddress);
		 System.out.println(raw.getAddress().get(0).getUse());
		 
		return raw;
		 
	 }
	 
	 
	 
	 
	 
	 public static String getPatient(String id)
	 {
		
		String endpoint="/Patient/" +id;
		String uri = BASE_URL+endpoint;
		RestTemplate restTemplate = new RestTemplate();
	    HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(org.springframework.http.MediaType.APPLICATION_JSON));
	    HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
	    
	    ResponseEntity<String> result = null;
	    try{
	    	result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);     	    
	    }catch(RestClientException rec)
	    {
	    	return new String("{"+result +"The server cannot find the requested page."+"}");
	    }
	    	return result.getBody();
	    }

	
	private static String getAllergy(String id)
	{
		String endpoint="AllergyIntolerance?patient=" +id;
		String uri = BASE_URL+endpoint;
		
		RestTemplate restTemplate = new RestTemplate();
	     
	    HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(org.springframework.http.MediaType.APPLICATION_JSON));
	    HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
	     
	    ResponseEntity<String> result = null;
	    try{
	    	result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);     	    
	    }catch(RestClientException rec)
	    {
	    	return new String("{"+result +"The server cannot find the requested page."+"}");
	    }
	    return result.getBody();
	     	
	}
	
	private static String getCondition(String id)
	{
		String endpoint="Condition?patient=" +id;
		String uri = BASE_URL+endpoint;
		
		RestTemplate restTemplate = new RestTemplate();
	     
	    HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(org.springframework.http.MediaType.APPLICATION_JSON));
	    HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
	     
	    ResponseEntity<String> result = null;
	    try{
	    	result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);     	    
	    }catch(RestClientException rec)
	    {
	    	return new String("{"+result +"The server cannot find the requested page."+"}");
	    }
	    return result.getBody();
		
	}
	
	private static String getFamilyHistory(String id)
	{
		String endpoint="FamilyMemberHistory?patient=" +id;
		String uri = BASE_URL+endpoint;
		
		RestTemplate restTemplate = new RestTemplate();
	     
	    HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(org.springframework.http.MediaType.APPLICATION_JSON));
	    HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
	     
	    ResponseEntity<String> result = null;
	    try{
	    	result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);     	    
	    }catch(RestClientException rec)
	    {
	    	return new String("{"+result +"The server cannot find the requested page."+"}");
	    }
	    return result.getBody();
		
	}
	private static String getObservation(String Oid)
	{
		String code="&code=8310-5";
		String endpoint="Observation?patient=" +id+code;
		String uri = BASE_URL+endpoint;
		
		RestTemplate restTemplate = new RestTemplate();
	     
	    HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(org.springframework.http.MediaType.APPLICATION_JSON));
	    HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
	     
	    ResponseEntity<String> result = null;
	    try{
	    	result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);     	    
	    }catch(RestClientException rec)
	    {
	    	return new String("{"+result +"The server cannot find the requested page."+"}");
	    }
	    return result.getBody();	}
	
	private static String getReport(String id)
	{
		String endpoint="DiagnosticReport?patient=" +id;
		String uri = BASE_URL+endpoint;
		
		RestTemplate restTemplate = new RestTemplate();
	     
	    HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(org.springframework.http.MediaType.APPLICATION_JSON));
	    HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
	     
	    ResponseEntity<String> result = null;
	    try{
	    	result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);     	    
	    }catch(RestClientException rec)
	    {
	    	return new String("{"+result +"The server cannot find the requested page."+"}");
	    }
	    return result.getBody();
		
		
		}
	
	private static String getDevice(String id)
	{
		String endpoint="Device?patient=" +id;
		String uri = BASE_URL+endpoint;
		
		RestTemplate restTemplate = new RestTemplate();
	     
	    HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(org.springframework.http.MediaType.APPLICATION_JSON));
	    HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
	     
	    ResponseEntity<String> result = null;
	    try{
	    	result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);     	    
	    }catch(RestClientException rec)
	    {
	    	return new String("{"+result +"The server cannot find the requested page."+"}");
	    }
	    return result.getBody(); 
	    
	    
		
	}
}

