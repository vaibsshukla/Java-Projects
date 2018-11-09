package org.b3ds.fhir.patient.mockdata.function;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.b3ds.fhir.patient.mockdata.RandomDateOfBirth;
import org.springframework.beans.factory.support.ReplaceOverride;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.model.dstu2.composite.BoundCodeableConceptDt;
import ca.uhn.fhir.model.dstu2.composite.CodeableConceptDt;
import ca.uhn.fhir.model.dstu2.composite.NarrativeDt;
import ca.uhn.fhir.model.dstu2.resource.AllergyIntolerance;
import ca.uhn.fhir.model.dstu2.resource.Bundle;
import ca.uhn.fhir.model.dstu2.resource.Bundle.Entry;
import ca.uhn.fhir.model.dstu2.resource.Bundle.EntryRequest;
import ca.uhn.fhir.model.dstu2.valueset.IdentifierUseEnum;
import ca.uhn.fhir.model.primitive.BoundCodeDt;
import ca.uhn.fhir.model.dstu2.resource.Patient;
import ca.uhn.fhir.model.dstu2.resource.Substance;
import ca.uhn.fhir.parser.IParser;

public class AllergyBundle {

		public static void main(String[] args) throws IOException {
			
			FhirContext ctx = FhirContext.forDstu2();
			AllergyBundle allergy=new AllergyBundle();
			IParser parser = ctx.newJsonParser();
			FileInputStream fis = new FileInputStream(new File("D://PatientAllergy.json"));
			String str = IOUtils.toString(fis);
			allergy=(AllergyBundle) parser.parseResource(str);
			
			RandamDataFunctions rand=new RandamDataFunctions();
			
			try
			{
				for(int i=0;i<1;i++)
				{
					AllergyIntolerance allergyIntolerence=new AllergyIntolerance();
					Substance substance=new Substance();
					NarrativeDt narrativeDt=new NarrativeDt();
					
					
				}
			}catch(Exception e)
			{
				
			}
			
			
		}
}
