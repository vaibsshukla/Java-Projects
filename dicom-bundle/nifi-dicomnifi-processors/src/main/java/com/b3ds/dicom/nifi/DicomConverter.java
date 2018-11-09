/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.b3ds.dicom.nifi;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.nifi.annotation.behavior.InputRequirement;
import org.apache.nifi.annotation.behavior.InputRequirement.Requirement;
import org.apache.nifi.annotation.behavior.ReadsAttribute;
import org.apache.nifi.annotation.behavior.ReadsAttributes;
import org.apache.nifi.annotation.behavior.WritesAttribute;
import org.apache.nifi.annotation.behavior.WritesAttributes;
import org.apache.nifi.annotation.documentation.CapabilityDescription;
import org.apache.nifi.annotation.documentation.SeeAlso;
import org.apache.nifi.annotation.documentation.Tags;
import org.apache.nifi.components.PropertyDescriptor;
import org.apache.nifi.flowfile.FlowFile;
import org.apache.nifi.flowfile.attributes.CoreAttributes;
import org.apache.nifi.processor.AbstractProcessor;
import org.apache.nifi.processor.ProcessContext;
import org.apache.nifi.processor.ProcessSession;
import org.apache.nifi.processor.Relationship;
import org.apache.nifi.processor.exception.ProcessException;
import org.apache.nifi.processor.io.StreamCallback;
import org.apache.nifi.processor.util.StandardValidators;
import org.b3ds.dicom.Dcm2Json;
import org.dcm4che3.io.DicomInputStream;
import org.json.JSONException;
import org.json.JSONObject;


@Tags({"Dcm, Json"})
@CapabilityDescription("Convert the Dcm file to Json")
@SeeAlso({})
@InputRequirement(Requirement.INPUT_REQUIRED)
@ReadsAttributes({@ReadsAttribute(attribute="", description="")})
@WritesAttributes({@WritesAttribute(attribute="", description="")})
public class DicomConverter extends AbstractProcessor {

	private static final byte[] EMPTY_JSON_OBJECT = "{}".getBytes(StandardCharsets.UTF_8);

	
	public static final Relationship REL_SUCCESS = new Relationship.Builder()
			.name("Success")
			.description("A new FlowFile is routed to this relationship if it is properly parsed and its metadata extracted")
			.build();
	
	public static final Relationship REL_FAILURE = new Relationship.Builder()
			.name("Failure")
			.description("A new FlowFile is routed to this relationship if it is not properly parsed")
			.build();

    private List<PropertyDescriptor> descriptors;

	@Override
	public Set<Relationship> getRelationships() {
		final Set<Relationship> relationships = new HashSet<>();
		relationships.add(REL_SUCCESS);
		relationships.add(REL_FAILURE);
		return relationships;
	}

	@Override
	public void onTrigger(ProcessContext context, ProcessSession session) throws ProcessException {
		FlowFile flowFile = session.get();
		if(flowFile ==null){
			return;
		}
		
		try{
			flowFile = session.write(flowFile, new StreamCallback() {
				
				@Override
				public void process(final InputStream rawIn, OutputStream rawOut) throws IOException {
					try(final InputStream in = new BufferedInputStream(rawIn);
							final OutputStream out = new BufferedOutputStream(rawOut)){
						Dcm2Json dcm = new Dcm2Json();
						String s1 = dcm.parse(new DicomInputStream(in));
						String output=dcm.CreatingFolder(s1);
						//	JSONObject obj = new JSONObject(s1);
					//	obj.put("loc", "\\loc\\dciom");
					//	String output = obj.toString();
						final byte[] op = ( output== null)? EMPTY_JSON_OBJECT : output.getBytes(StandardCharsets.UTF_8);
						out.write(op);	
					
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		}
		catch(final ProcessException pe)
		{
			getLogger().error("Failed to convert {} to JSON due to {}; transferring to failure", new Object[]{flowFile, pe});
            session.transfer(flowFile, REL_FAILURE);
            return;
		}
		
		flowFile = session.putAttribute(flowFile, CoreAttributes.MIME_TYPE.key(), "application/json");
		session.transfer(flowFile, REL_SUCCESS);
	}
	
	

}
