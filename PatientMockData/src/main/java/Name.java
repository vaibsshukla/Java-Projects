import org.fluttercode.datafactory.impl.DataFactory;

import ca.uhn.fhir.model.dstu2.resource.Patient;
import ca.uhn.fhir.model.dstu2.valueset.NameUseEnum;

class Name
{
		public String[] getRandomName(int noofNames)
		{	
			String[] name=new String[noofNames];
			DataFactory df = new DataFactory();
			for (int j = 0; j < noofNames; j++) {
				 name[j] = df.getFirstName() + " "+ df.getLastName();
			}
			return name;
	}	

}
