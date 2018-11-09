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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;


import org.apache.nifi.util.MockFlowFile;
import org.apache.nifi.util.TestRunner;
import org.apache.nifi.util.TestRunners;
import org.junit.Test;


public class MyProcessorTest {

	@Test
	public void TestParseDicom() throws FileNotFoundException
	{		
		final TestRunner runner = TestRunners.newTestRunner(new DicomConverter());
		final String location = "C:\\Users\\Vaibhav Shukla\\Downloads\\ttfm.dcm";
		InputStream fis = new FileInputStream(new File(location));		
		
		runner.enqueue(fis);
		runner.run();
		runner.assertAllFlowFilesTransferred(DicomConverter.REL_SUCCESS,1);
		final MockFlowFile ff = runner.getFlowFilesForRelationship(DicomConverter.REL_SUCCESS).get(0);
	}

}
