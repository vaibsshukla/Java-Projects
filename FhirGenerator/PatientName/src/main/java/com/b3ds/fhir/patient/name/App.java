package com.b3ds.fhir.patient.name;

import java.io.IOException;
import java.util.List;

import org.apache.commons.io.IOUtils;

public class App 
{
	public static void main(String args[]) throws IOException
	{
	  NameGenerator generator=new NameGenerator();
	  List<Name> names = generator.generateNames(1);
	  System.out.println(names);
		
	}
	
	private void hello()
	{
		String result = "";
		
		ClassLoader classLoader = getClass().getClassLoader();
		try {
		    result = IOUtils.toString(classLoader.getResourceAsStream("dist.all.last.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

}
