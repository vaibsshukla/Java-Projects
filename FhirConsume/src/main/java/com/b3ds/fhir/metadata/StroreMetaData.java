/*package com.b3ds.fhir.metadata;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.b3ds.fhir.consume.Consume;
import com.b3ds.fhir.metadata.models.MetaData;
import com.b3ds.fhir.metadata.service.MetaDataServiceInterface;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.model.dstu2.resource.Patient;
import ca.uhn.fhir.parser.IParser;

public class StroreMetaData {

		public static void main(String args[])
		{
			AnnotationConfigApplicationContext  context = new AnnotationConfigApplicationContext(AppConfig.class);
			
			MetaDataServiceInterface service = (MetaDataServiceInterface) context.getBean("metaDataServiceInterface");
			
			Consume consume = new Consume();
			String msg = consume.getPatient("Tbt3KuCY0B5PSrJvCu2j-PlK.aiHsu2xUjUM8bWpetXoB");
			MetaData metadata = new MetaData();
			FhirContext ctx = FhirContext.forDstu3();
			IParser parser = ctx.newJsonParser();
			Patient pt = parser.parseResource(Patient.class, msg);
			System.out.println(pt.getResourceMetadata());
			System.out.println("Fhir Version 3");
			System.out.println(pt.getIdBase());
			System.out.println(pt.getExtension().get(0).getUrl());
			
			System.out.println(pt.getAddress().get(0).getCity());
			String nText=pt.getName().get(0).getNameAsSingleString();
			System.out.println(nText);
			String nUse=pt.getName().get(0).getUse().getDisplay();
			String nFamily=pt.getName().get(0).getFamily();
			String nGiven=pt.getName().get(0).getGivenAsSingleString();
			
			String iUse=pt.getIdentifier().get(0).getUse().getDisplay();
			String iSystem=pt.getIdentifier().get(0).getSystem();
			String iValue=pt.getIdentifier().get(0).getValue();
			
			String aUse=pt.getAddress().get(0).getUse().getDisplay();
			String aLine=pt.getAddress().get(0).getLine().toString();
			String aCity=pt.getAddress().get(0).getCity();
			String aState=pt.getAddress().get(0).getState();
			String aPostalCode=pt.getAddress().get(0).getPostalCode();
			String aCountry=pt.getAddress().get(0).getCountry();
			
			String tSystem=pt.getTelecom().get(0).getSystem().getDisplay();
			String tValue=pt.getTelecom().get(0).getValue();
			String tUse=pt.getTelecom().get(0).getUse().getDisplay();
			
			
			String mText=pt.getMaritalStatus().getText();
			String mCodingSystem=pt.getMaritalStatus().getCoding().get(0).getSystem();
			String mCodingcode=pt.getMaritalStatus().getCoding().get(0).getCode();
			String mCodingDisplay=pt.getMaritalStatus().getCoding().get(0).getDisplay();
			

						Consume c=new Consume();
			
			Consume cnsm=new Consume();
			MetaData metadata1=new MetaData();
			metadata1.setFhirVersion("DSTU3");
			metadata1.setpId(Consume.pId);
			metadata1.setpSource("http://hl7.org/fhir/v3/AdministrativeGender");
			metadata1.setResourceType(Consume.resourceType);
			
			service.saveMetaData(metadata1);
			System.out.println("Working");
			
			
		}
	}

*/