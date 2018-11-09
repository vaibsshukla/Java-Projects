package com.b3ds.fhir.metadata.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.b3ds.fhir.metadata.config.AppConfig;
import com.b3ds.fhir.metadata.dao.MetaDataInterface;
import com.b3ds.fhir.metadata.models.MetaData;
import com.b3ds.fhir.metadata.service.MetaDataServiceInterface;

public class AppMain {

	public static void main(String args[])
	{
		AnnotationConfigApplicationContext  context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		MetaDataServiceInterface service = (MetaDataServiceInterface) context.getBean("metaDataServiceInterface");
		
		
		MetaData metadata1=new MetaData();
		metadata1.setFhirVersion("dstu3");
		metadata1.setpId("Tbt3KuCY0B5PSrJvCu2j-PlK.aiHsu2xUjUM8bWpetXoB");
		metadata1.setpSource("http://hl7.org/fhir/v3/AdministrativeGender");
		metadata1.setResourceType("Patient");
		
		service.saveMetaData(metadata1);
		System.out.println("Working");
	}
}
