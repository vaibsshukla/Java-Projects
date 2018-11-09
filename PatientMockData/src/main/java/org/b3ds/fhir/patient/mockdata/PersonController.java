
package org.b3ds.fhir.patient.mockdata;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
public class PersonController {
	
	
	
	
	
	private static final Logger logger = LogManager.getLogger(PersonController.class);
	@Autowired
	private Person person;
	
	@RequestMapping("/")
	public String healthCheck() {
		return "OK";
	}
		
	
	@RequestMapping(value="/person/{id}",method=RequestMethod.POST)
	public Person PersonDetails(@RequestParam(name="id",required=true) String id)
	{
		person.setId(id);
		return person;
	}

	@RequestMapping(value="/person/allergy",method=RequestMethod.POST )
//	@ResponseBody
	public String Allergy(@RequestParam(name="id",required=true) String id)
	{
		logger.info("reached");
		if(id.equals("1234"))
		{
		Gson gs = new Gson();
		String str = "{\"name\":\"vivek\"}";
		return str;
		}
		else
		{
			String str="{\"msg\":\"fail\"}";
			return str;
		}
	}

}
