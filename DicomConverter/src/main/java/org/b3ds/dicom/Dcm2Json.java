package org.b3ds.dicom;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.json.Json;
import javax.json.stream.JsonGenerator;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.dcm4che3.data.Attributes;
import org.dcm4che3.io.BulkDataDescriptor;
import org.dcm4che3.io.DicomInputStream;
import org.dcm4che3.io.DicomInputStream.IncludeBulkData;
import org.dcm4che3.json.JSONWriter;
import org.json.JSONException;
import org.json.JSONObject;



/**
 * @author Gunter Zeilinger <gunterze@gmail.com>
 */

public  class Dcm2Json
{

        private boolean indent = false;
        private IncludeBulkData includeBulkData = IncludeBulkData.URI;
        private boolean catBlkFiles = false;
        private String blkFilePrefix = "blk";
        private String blkFileSuffix;
        private File blkDirectory;
        private Attributes blkAttrs;

        public final void setIndent(boolean indent) {
            this.indent = indent;
        }

        public final void setIncludeBulkData(IncludeBulkData includeBulkData) {
            this.includeBulkData = includeBulkData;
        }

        public final void setConcatenateBulkDataFiles(boolean catBlkFiles) {
            this.catBlkFiles = catBlkFiles;
        }

        public final void setBulkDataFilePrefix(String blkFilePrefix) {
            this.blkFilePrefix = blkFilePrefix;
        }

        public final void setBulkDataFileSuffix(String blkFileSuffix) {
            this.blkFileSuffix = blkFileSuffix;
        }

        public final void setBulkDataDirectory(File blkDirectory) {
            this.blkDirectory = blkDirectory;
        }

        public final void setBulkDataAttributes(Attributes blkAttrs) {
            this.blkAttrs = blkAttrs;
        }

      



        public String parse(DicomInputStream dis) throws IOException {
            dis.setIncludeBulkData(includeBulkData);
            if (blkAttrs != null)
                dis.setBulkDataDescriptor(BulkDataDescriptor.valueOf(blkAttrs));
            dis.setBulkDataDirectory(blkDirectory);
            dis.setBulkDataFilePrefix(blkFilePrefix);
            dis.setBulkDataFileSuffix(blkFileSuffix);
            dis.setConcatenateBulkDataFiles(catBlkFiles);
            //ByteArrayOutputStream bout=new ByteArrayOutputStream()os;
           ByteArrayOutputStream out = new ByteArrayOutputStream();
            
            JsonGenerator jsonGen = createGenerator(out);
            JSONWriter jsonWriter = new JSONWriter(jsonGen);
            dis.setDicomInputHandler(jsonWriter);
            dis.readDataset(-1, -1);
            jsonGen.flush();
           
            return IOUtils.toString(out.toByteArray());
        }
          
        

        public JsonGenerator createGenerator(OutputStream out) {
            Map<String, ?> conf = new HashMap<String, Object>(2);
            if (indent)
                conf.put(JsonGenerator.PRETTY_PRINTING, null);
            return Json.createGeneratorFactory(conf).createGenerator(out);
        }	

        public static String CreatingFolder(String s1) throws JSONException
        {
        	String s2=null;
        	s2=s1;
        	
        	int count=0;	
        	String name = null;
        	String Filename=null;
        	File file=new File("C:\\Users\\Vaibhav Shukla\\Downloads\\");
        	File[] listoffiles=file.listFiles();
        	
        	for(int i=0;i<listoffiles.length;i++)
    		{	
    			String ext=getFileExtension(listoffiles[i]);
    			//System.out.println(ext);
    			if(ext.equals(".dcm") )
    			{	count++; 
    			if(count==1)
    			{	name=listoffiles[i].getName();
    			Filename = name.replaceFirst("[.][^.]+$", "");
    			}	}
    		}
        	
        	String folderloc=null;
        	if(count==1)
        	{	folderloc="C:\\Users\\Vaibhav Shukla\\Downloads\\" +Filename;
        		
        	}
        	
        	JSONObject obj = new JSONObject(s2);
			obj.put("loc", folderloc);
			String output = obj.toString();
			
			return output;
        	
        }
        private static String getFileExtension(File file)
   	 {
   		String filename=file.getName();
   		if(filename.lastIndexOf(".")!=-1 && filename.lastIndexOf(".")!=0)
   		{
   			
   				return filename.substring(filename.lastIndexOf("."));
   		}
   		
   		else return "";
   	 }
 
}

