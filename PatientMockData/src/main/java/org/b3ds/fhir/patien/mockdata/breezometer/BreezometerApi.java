package org.b3ds.fhir.patien.mockdata.breezometer;

import java.util.Arrays;
import java.sql.*;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class BreezometerApi {

	public static  String getBreezometer(double d, double e)
{
	
	String uri ="https://api.breezometer.com/baqi/?lat="+d+"&lon="+e+"&key=bbba56175f4540d2ac8dfadbf692dd0a";					
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

private static void  getCountryCode(String cc,String city)
{
	try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(  
				"jdbc:mysql://192.168.1.16:3306/hapi","vivek","2611798");  
		System.out.println("Connected to database");
		Statement stmt=con.createStatement();  
		
		ResultSet rs=stmt.executeQuery("SELECT * from Cities WHERE country_code = '"+cc+"' AND city_name = '"+city+"';" );  
		System.out.println("QueryExecuted");
		while(rs.next())  
		System.out.println(BreezometerApi.getBreezometer( rs.getFloat(4),rs.getFloat(5)));
		
		
		con.close();  
	}catch(Exception e)
	
		{
		System.out.println(e);
		}

}

public static void main(String[] args) {

	BreezometerApi ba=new BreezometerApi();
	ba.getCountryCode("US","New York");
	
	}


}
