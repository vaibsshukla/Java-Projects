package org.fhir.pkg;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import org.hl7.fhir.dstu3.model.Patient;


import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.parser.IParser;

public class parsingjson {
	
		FhirContext ctx = FhirContext.forDstu3();
		
		String msgString="{\"resourceType\":\"Patient\",\"birthDate\":\"1985-08-01\",\"active\":true,\"gender\":\"male\",\"deceasedBoolean\":false,\"id\":\"Tbt3KuCY0B5PSrJvCu2j-PlK.aiHsu2xUjUM8bWpetXoB\",\"careProvider\":[{\"display\":\"Physician Family Medicine\",\"reference\":\"https://open-ic.epic.com/FHIR/api/FHIR/DSTU2/Practitioner/T3Mz3KLBDVXXgaRoee3EKAAB\"}],\"name\":[{\"use\":\"usual\",\"text\":\"Jason Argonaut\",\"family\":[\"Argonaut\"],\"given\":[\"Jason\"]}],\"identifier\":[{\"use\":\"usual\",\"system\":\"urn:oid:1.2.840.114350.1.13.327.1.7.5.737384.0\",\"value\":\"E3826\"},{\"use\":\"usual\",\"system\":\"urn:oid:1.2.3.4\",\"value\":\"203579\"}],\"address\":[{\"use\":\"home\",\"line\":[\"1979 Milky Way Dr.\"],\"city\":\"Verona\",\"state\":\"WI\",\"postalCode\":\"53593\",\"country\":\"US\"},{\"use\":\"temp\",\"line\":[\"5301 Tokay Blvd\"],\"city\":\"MADISON\",\"state\":\"WI\",\"postalCode\":\"53711\",\"country\":\"US\",\"period\":{\"start\":\"2011-08-04T00:00:00Z\",\"end\":\"2014-08-04T00:00:00Z\"}}],\"telecom\":[{\"system\":\"phone\",\"value\":\"608-271-9000\",\"use\":\"home\"},{\"system\":\"phone\",\"value\":\"608-771-9000\",\"use\":\"work\"},{\"system\":\"phone\",\"value\":\"608-771-9000\",\"use\":\"mobile\"},{\"system\":\"fax\",\"value\":\"608-771-9000\",\"use\":\"home\"},{\"system\":\"phone\",\"value\":\"608-771-9000\",\"use\":\"temp\",\"period\":{\"start\":\"2011-08-04T00:00:00Z\",\"end\":\"2014-08-04T00:00:00Z\"}},{\"system\":\"email\",\"value\":\"open@epic.com\"}],\"maritalStatus\":{\"text\":\"Single\",\"coding\":[{\"system\":\"http://hl7.org/fhir/ValueSet/marital-status\",\"code\":\"S\",\"display\":\"Never Married\"}]},\"communication\":[{\"preferred\":true,\"language\":{\"text\":\"English\",\"coding\":[{\"system\":\"urn:oid:2.16.840.1.113883.6.99\",\"code\":\"en\",\"display\":\"English\"}]}}],\"extension\":[{\"url\":\"http://hl7.org/fhir/StructureDefinition/us-core-race\",\"valueCodeableConcept\":{\"text\":\"Asian\",\"coding\":[{\"system\":\"2.16.840.1.113883.5.104\",\"code\":\"2028-9\",\"display\":\"Asian\"}]}},{\"url\":\"http://hl7.org/fhir/StructureDefinition/us-core-ethnicity\",\"valueCodeableConcept\":{\"text\":\"Not Hispanic or Latino\",\"coding\":[{\"system\":\"2.16.840.1.113883.5.50\",\"code\":\"2186-5\",\"display\":\"Not Hispanic or Latino\"}]}},{\"url\":\"http://hl7.org/fhir/StructureDefinition/us-core-birth-sex\",\"valueCodeableConcept\":{\"text\":\"Male\",\"coding\":[{\"system\":\"http://hl7.org/fhir/v3/AdministrativeGender\",\"code\":\"M\",\"display\":\"Male\"}]}}]}\r\n";
		
		
		IParser parser=ctx.newJsonParser();
		
		Patient patient = parser.parseResource(Patient.class, msgString);
		public String resourceType=patient.getResourceType().getPath();
		Date dateofBirth=patient.getBirthDate();
		boolean active=patient.getActive();
		
		String nText=patient.getName().get(0).getNameAsSingleString();
		String nUse=patient.getName().get(0).getUse().getDisplay();
		String nFamily=patient.getName().get(0).getFamily();
		String nGiven=patient.getName().get(0).getGivenAsSingleString();
		
		String iUse=patient.getIdentifier().get(0).getUse().getDisplay();
		public String iSystem=patient.getIdentifier().get(0).getSystem();
		public String iValue=patient.getIdentifier().get(0).getValue();
		
		String aUse=patient.getAddress().get(0).getUse().getDisplay();
		String aLine=patient.getAddress().get(0).getLine().toString();
		String aCity=patient.getAddress().get(0).getCity();
		String aState=patient.getAddress().get(0).getState();
		String aPostalCode=patient.getAddress().get(0).getPostalCode();
		String aCountry=patient.getAddress().get(0).getCountry();
		
		String tSystem=patient.getTelecom().get(0).getSystem().getDisplay();
		String tValue=patient.getTelecom().get(0).getValue();
		String tUse=patient.getTelecom().get(0).getUse().getDisplay();
		
		
		String mText=patient.getMaritalStatus().getText();
		String mCodingSystem=patient.getMaritalStatus().getCoding().get(0).getSystem();
		String mCodingcode=patient.getMaritalStatus().getCoding().get(0).getCode();
		String mCodingDisplay=patient.getMaritalStatus().getCoding().get(0).getDisplay();
		
		String eUrl=patient.getExtension().get(0).getUrl();
	
//		System.out.println(nUse);
//		System.out.println(nText);
//		System.out.println(nFamily);
//		System.out.println(nGiven);
//		
//		System.out.println(iUse);
//		System.out.println(iSystem);
//				
//		System.out.print(aUse +" :");
//		System.out.print(aLine +",");
//		System.out.print(aCity +",");
//		System.out.print(aState +",");
//		System.out.print(aPostalCode+",");
//		System.out.println(aCountry+",");
//		
//		System.out.println(tSystem);
//		System.out.println(tValue);
//		System.out.println(tValue);
//		
//	//	System.out.println(evalueCodableConcept);
//		
//		try
//		{
//			   Class.forName("com.mysql.cj.jdbc.Driver");
//			   Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/patient", "root", "vaibhav1234");
//			   System.out.println("Connection estabished");
//			   Statement stmt=null;
//			   
//			   System.out.println("Inserting records into the table Telecom...");
//			   stmt=conn.createStatement();
//			   
//			 //  String sql = "INSERT INTO  " +
//	          //         "VALUES ( 12,'vaibs' )";
//			   String sql="INSERT INTO telecom (telecomId,system,value,priod)" + "VALUES (1 ,"+tSystem +"," +tValue+"," + "09/8/2015)";
//			   stmt.executeUpdate(sql);
//			   
//			   System.out.println("Records inserted");
//			   
//			 
//		}catch(SQLException e)
//		{
//			System.out.println(e);
//		}
//		
		
		
		
		
		
		
		
		
		
	

}
