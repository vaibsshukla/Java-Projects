package com.b3ds.fhir.patient.id;

import org.apache.commons.codec.digest.DigestUtils;

public class PatientId {

	public String generatePatientId(String dob, String email, String time)
	{	
		String originalString=dob+email+time;
		String sha256hex = DigestUtils.sha256Hex(originalString);
		return sha256hex;
    }
	
	public String generateOtherId(String otherid)
	{
		String originalString=otherid;
		String md5hex=DigestUtils.md5Hex(originalString);
		return md5hex;
	}
	
}