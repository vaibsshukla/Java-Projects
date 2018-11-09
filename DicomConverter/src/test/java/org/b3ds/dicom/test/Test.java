
package org.b3ds.dicom.test;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.b3ds.dicom.Dcm2Json;
import org.dcm4che3.io.BulkDataDescriptor;
import org.dcm4che3.io.DicomInputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Test {

	public static void main(String[] args) throws IOException , JSONException{
		Dcm2Json dcm = new Dcm2Json();
		DicomInputStream dis=new DicomInputStream(new File("C:\\Users\\Vaibhav Shukla\\Downloads\\case1\\case1\\case1_008.dcm"));
		
		String s1=dcm.parse(dis);
	
	
		String creatingfolderstring=dcm.CreatingFolder(s1);
		JSONObject obj = new JSONObject(s1);
		obj.put("loc", "\\loc\\dciom");
		String ss = obj.toString();
		System.out.println(ss);
		//String title = (String) obj.get("00100010");
		//System.out.println(title);
		//		System.out.println(creatingfolderstring);

		String s2="{\"00020012\":{\"Value\":[\"1.2.276.0.50.20060201.4.1\"],\"vr\":\"UI\"},\"00020010\":{\"Value\":[\"1.2.840.10008.1.2\"],\"vr\":\"UI\"},\"00401003\":{\"vr\":\"SH\"},\"00100010\":{\"Value\":[{\"Alphabetic\":\"Fall 1\"}],\"vr\":\"PN\"},\"00401004\":{\"vr\":\"LO\"},\"00401400\":{\"vr\":\"LT\"},\"00081090\":{\"Value\":[\"Intera\"],\"vr\":\"LO\"},\"00282110\":{\"Value\":[\"00\"],\"vr\":\"CS\"},\"00400275\":{\"Value\":[{\"00401001\":{\"Value\":[\"0000154779\"],\"vr\":\"SH\"},\"20051213\":{\"InlineBinary\":\"AAAAAA==\",\"vr\":\"UN\"},\"00400007\":{\"Value\":[\"MRT Sakroiliakalgelenke\"],\"vr\":\"LO\"},\"20050012\":{\"Value\":[\"Philips MR Imaging DD 003\"],\"vr\":\"LO\"},\"00400008\":{\"vr\":\"SQ\"},\"00400009\":{\"Value\":[\"0000154779\"],\"vr\":\"SH\"}}],\"vr\":\"SQ\"},\"00401001\":{\"Value\":[\"0000154779\"],\"vr\":\"SH\"},\"00020013\":{\"Value\":[\"JIVEX_TK_41\"],\"vr\":\"SH\"},\"00401002\":{\"vr\":\"LO\"},\"00181251\":{\"Value\":[\"B\"],\"vr\":\"SH\"},\"00181250\":{\"Value\":[\"SENSE-body\"],\"vr\":\"SH\"},\"00200013\":{\"Value\":[9],\"vr\":\"IS\"},\"00080031\":{\"Value\":[\"113322\"],\"vr\":\"TM\"},\"00080030\":{\"Value\":[\"113322\"],\"vr\":\"TM\"},\"00380050\":{\"vr\":\"LO\"},\"7FE00010\":{\"BulkDataURI\":\"file:/C:/Users/Vaibhav%20Shukla/Downloads/case1/case1/case1_008.dcm?offset=3454&length=524288\",\"vr\":\"OW\"},\"00324000\":{\"Value\":[\"MRT Sakroiliakalgelenke\"],\"vr\":\"LT\"},\"00080033\":{\"Value\":[\"113322\"],\"vr\":\"TM\"},\"00020001\":{\"InlineBinary\":\"AAE=\",\"vr\":\"OB\"},\"00401010\":{\"vr\":\"PN\"},\"0020000D\":{\"Value\":[\"1.2.276.0.50.192168001099.7810872.14547392.270\"],\"vr\":\"UI\"},\"0020000E\":{\"Value\":[\"1.2.276.0.50.192168001099.7810872.14547392.458\"],\"vr\":\"UI\"},\"00400321\":{\"vr\":\"SQ\"},\"00020003\":{\"Value\":[\"1.3.46.670589.11.0.0.11.4.2.0.5526.5.2220.2004042613242401500\"],\"vr\":\"UI\"},\"00020002\":{\"Value\":[\"1.2.840.10008.5.1.4.1.1.4\"],\"vr\":\"UI\"},\"00081080\":{\"vr\":\"LO\"},\"00181000\":{\"Value\":[\"05526\"],\"vr\":\"LO\"},\"00181088\":{\"Value\":[0],\"vr\":\"IS\"},\"00181083\":{\"Value\":[0],\"vr\":\"IS\"},\"00400280\":{\"Value\":[\"MRT Sakroiliakalgelenke\"],\"vr\":\"ST\"},\"00181082\":{\"Value\":[0],\"vr\":\"IS\"},\"00200010\":{\"Value\":[\"11788759296812\"],\"vr\":\"SH\"},\"00200011\":{\"Value\":[601],\"vr\":\"IS\"},\"00181084\":{\"Value\":[0],\"vr\":\"IS\"},\"00200012\":{\"Value\":[6],\"vr\":\"IS\"},\"00080021\":{\"Value\":[\"20070511\"],\"vr\":\"DA\"},\"00081111\":{\"Value\":[{\"00081155\":{\"Value\":[\"1.3.46.670589.11.0.0.11.4.2.0.5526.5.3580.2004042612422029238\"],\"vr\":\"UI\"},\"00200013\":{\"Value\":[0],\"vr\":\"IS\"},\"00080005\":{\"Value\":[\"ISO_IR 100\"],\"vr\":\"CS\"},\"00081150\":{\"Value\":[\"1.2.840.10008.3.1.2.3.3\"],\"vr\":\"UI\"},\"00080014\":{\"Value\":[\"1.3.46.670589.11.5526.5\"],\"vr\":\"UI\"},\"00080013\":{\"Value\":[\"132602\"],\"vr\":\"TM\"},\"00080012\":{\"Value\":[\"20040426\"],\"vr\":\"DA\"}}],\"vr\":\"SQ\"},\"00080020\":{\"Value\":[\"20010101\"],\"vr\":\"DA\"},\"00401005\":{\"vr\":\"LO\"},\"00380500\":{\"vr\":\"LO\"},\"00080023\":{\"Value\":[\"20070511\"],\"vr\":\"DA\"},\"00400251\":{\"Value\":[\"124231\"],\"vr\":\"TM\"},\"00181314\":{\"Value\":[10],\"vr\":\"DS\"},\"00400252\":{\"vr\":\"CS\"},\"loc\":\"\\\\loc\\\\dciom\",\"00280030\":{\"Value\":[0.732421875,0.732421875],\"vr\":\"DS\"},\"00400250\":{\"Value\":[\"20040426\"],\"vr\":\"DA\"},\"00400255\":{\"vr\":\"LO\"},\"00100032\":{\"Value\":[\"0000\"],\"vr\":\"TM\"},\"00181310\":{\"Value\":[368,0,0,368],\"vr\":\"US\"},\"00280034\":{\"Value\":[1,1],\"vr\":\"IS\"},\"00400253\":{\"Value\":[\"136298540\"],\"vr\":\"SH\"},\"00100030\":{\"Value\":[\"19000101\"],\"vr\":\"DA\"},\"00181312\":{\"Value\":[\"COL\"],\"vr\":\"CS\"},\"00400254\":{\"Value\":[\"MRT Sakroiliakalgelenke\"],\"vr\":\"LO\"},\"00181030\":{\"Value\":[\"*ISG/THRI/KM\"],\"vr\":\"LO\"},\"00321070\":{\"vr\":\"LO\"},\"00080018\":{\"Value\":[\"1.2.276.0.50.192168001099.7810872.14547392.467\"],\"vr\":\"UI\"},\"00080016\":{\"Value\":[\"1.2.840.10008.5.1.4.1.1.4\"],\"vr\":\"UI\"},\"00080014\":{\"Value\":[\"1.3.46.670589.11.5526.5\"],\"vr\":\"UI\"},\"00080013\":{\"Value\":[\"132601\"],\"vr\":\"TM\"},\"00080012\":{\"Value\":[\"20040426\"],\"vr\":\"DA\"},\"00102160\":{\"vr\":\"SH\"},\"00100020\":{\"Value\":[\"11788759296811\"],\"vr\":\"LO\"},\"00080008\":{\"Value\":[\"ORIGINAL\",\"PRIMARY\",\"M_FFE\",\"M\",\"FFE\"],\"vr\":\"CS\"},\"00080090\":{\"Value\":[{\"Alphabetic\":\"Dr. Anonymous\"}],\"vr\":\"PN\"},\"00201040\":{\"vr\":\"LO\"},\"00181020\":{\"Value\":[\"NT 10.3.1\",\"PIIM V2.1.4.1 MIMIT MCS\"],\"vr\":\"LO\"},\"00201041\":{\"Value\":[7.99999625451827],\"vr\":\"DS\"},\"00185100\":{\"Value\":[\"HFS\"],\"vr\":\"CS\"},\"00180050\":{\"Value\":[2],\"vr\":\"DS\"},\"00200105\":{\"Value\":[1],\"vr\":\"IS\"},\"00080081\":{\"Value\":[\"Anonymized Address\"],\"vr\":\"ST\"},\"20011003\":{\"InlineBinary\":\"AAAAAA==\",\"vr\":\"UN\"},\"00080080\":{\"Value\":[\"Anonymized Hospital\"],\"vr\":\"LO\"},\"2001100A\":{\"InlineBinary\":\"OSA=\",\"vr\":\"UN\"},\"00080005\":{\"Value\":[\"ISO_IR 100\"],\"vr\":\"CS\"},\"00102110\":{\"vr\":\"LO\"},\"00402010\":{\"vr\":\"SH\"},\"00180089\":{\"Value\":[368],\"vr\":\"IS\"},\"00280010\":{\"Value\":[512],\"vr\":\"US\"},\"00280011\":{\"Value\":[512],\"vr\":\"US\"},\"00180085\":{\"Value\":[\"1H\"],\"vr\":\"SH\"},\"00200060\":{\"vr\":\"CS\"},\"00180086\":{\"Value\":[1],\"vr\":\"IS\"},\"00180087\":{\"Value\":[1.5],\"vr\":\"DS\"},\"00180088\":{\"Value\":[1],\"vr\":\"DS\"},\"00180081\":{\"Value\":[3.70510005950927],\"vr\":\"DS\"},\"00180082\":{\"Value\":[0],\"vr\":\"DS\"},\"00180083\":{\"Value\":[3],\"vr\":\"DS\"},\"00180084\":{\"Value\":[63.8923629999999],\"vr\":\"DS\"},\"00200100\":{\"Value\":[1],\"vr\":\"IS\"},\"00180091\":{\"Value\":[20],\"vr\":\"IS\"},\"00080070\":{\"Value\":[\"Philips Medical Systems\"],\"vr\":\"LO\"},\"00402009\":{\"vr\":\"SH\"},\"00402008\":{\"vr\":\"PN\"},\"00402007\":{\"vr\":\"SH\"},\"00081040\":{\"vr\":\"LO\"},\"00402006\":{\"vr\":\"SH\"},\"00100040\":{\"Value\":[\"O\"],\"vr\":\"CS\"},\"00281051\":{\"Value\":[2223],\"vr\":\"DS\"},\"0008103E\":{\"Value\":[\"Rheuma     *ISG/THRI/KM\"],\"vr\":\"LO\"},\"00281050\":{\"Value\":[1112],\"vr\":\"DS\"},\"00400241\":{\"Value\":[\"MR_STORE_EXP\"],\"vr\":\"AE\"},\"00281053\":{\"Value\":[1.54163614163614],\"vr\":\"DS\"},\"00281052\":{\"Value\":[0],\"vr\":\"DS\"},\"00400244\":{\"Value\":[\"20040426\"],\"vr\":\"DA\"},\"00281054\":{\"Value\":[\"normalized\"],\"vr\":\"LO\"},\"00400245\":{\"Value\":[\"124231\"],\"vr\":\"TM\"},\"00104000\":{\"vr\":\"LT\"},\"00400242\":{\"vr\":\"SH\"},\"00400243\":{\"vr\":\"SH\"},\"00280002\":{\"Value\":[1],\"vr\":\"US\"},\"00102180\":{\"vr\":\"SH\"},\"00200052\":{\"Value\":[\"1.3.46.670589.11.0.0.11.4.2.0.5526.5.4584.2004042612425903415\"],\"vr\":\"UI\"},\"00280004\":{\"Value\":[\"MONOCHROME2\"],\"vr\":\"CS\"},\"00180080\":{\"Value\":[7.73110008239746],\"vr\":\"DS\"},\"00080060\":{\"Value\":[\"MR\"],\"vr\":\"CS\"},\"00321060\":{\"Value\":[\"MRT Sakroiliakalgelenke\"],\"vr\":\"LO\"},\"00081030\":{\"Value\":[\"MRT Sakroiliakalgelenke\"],\"vr\":\"LO\"},\"00180023\":{\"vr\":\"CS\"},\"00180024\":{\"vr\":\"SH\"},\"00204000\":{\"vr\":\"LT\"},\"00180020\":{\"Value\":[\"GR\"],\"vr\":\"CS\"},\"00180021\":{\"Value\":[\"SP\"],\"vr\":\"CS\"},\"00180022\":{\"Value\":[\"FS\"],\"vr\":\"CS\"},\"00181081\":{\"Value\":[0],\"vr\":\"IS\"},\"00200037\":{\"Value\":[1,0,0,0,0.71103039832921,-0.7031612707279],\"vr\":\"DS\"},\"00080050\":{\"Value\":[\"11788759296818\"],\"vr\":\"SH\"},\"001021C0\":{\"Value\":[4],\"vr\":\"US\"},\"00081140\":{\"Value\":[{\"00081155\":{\"Value\":[\"1.3.46.670589.11.0.0.11.4.2.0.5526.5.2220.2004042612433728204\"],\"vr\":\"UI\"},\"00081150\":{\"Value\":[\"1.2.840.10008.5.1.4.1.1.4\"],\"vr\":\"UI\"}},{\"00081155\":{\"Value\":[\"1.3.46.670589.11.0.0.11.4.2.0.5526.5.2220.2004042612433654194\"],\"vr\":\"UI\"},\"00081150\":{\"Value\":[\"1.2.840.10008.5.1.4.1.1.4\"],\"vr\":\"UI\"}},{\"00081155\":{\"Value\":[\"1.3.46.670589.11.0.0.11.4.2.0.5526.5.2220.2004042612433692199\"],\"vr\":\"UI\"},\"00081150\":{\"Value\":[\"1.2.840.10008.5.1.4.1.1.4\"],\"vr\":\"UI\"}}],\"vr\":\"SQ\"},\"00321033\":{\"Value\":[\"RequestingService\"],\"vr\":\"LO\"},\"00321032\":{\"Value\":[{\"Alphabetic\":\"RequestingPhysician\"}],\"vr\":\"PN\"},\"00402001\":{\"vr\":\"LO\"},\"00102000\":{\"vr\":\"LO\"},\"00402005\":{\"vr\":\"TM\"},\"00402004\":{\"vr\":\"DA\"},\"00402400\":{\"vr\":\"LT\"},\"00280100\":{\"Value\":[16],\"vr\":\"US\"},\"00101030\":{\"Value\":[88],\"vr\":\"DS\"},\"00280102\":{\"Value\":[11],\"vr\":\"US\"},\"00280101\":{\"Value\":[12],\"vr\":\"US\"},\"00181100\":{\"Value\":[375],\"vr\":\"DS\"},\"00280103\":{\"Value\":[0],\"vr\":\"US\"},\"00280106\":{\"Value\":[0],\"vr\":\"SS\"},\"00180093\":{\"Value\":[80],\"vr\":\"DS\"},\"00200032\":{\"Value\":[-177.71115303039,-100.01669364424,143.324983706748],\"vr\":\"DS\"},\"00180094\":{\"Value\":[80.4347839355468],\"vr\":\"DS\"},\"00280107\":{\"Value\":[1687],\"vr\":\"SS\"},\"001021B0\":{\"vr\":\"LT\"},\"00081010\":{\"Value\":[\"Any Station\"],\"vr\":\"SH\"}}\r\n";
	/*	final JSONObject obj1=new JSONObject(s2);
		final JSONArray patientdata=obj1.getJSONArray("00020012");
		final int n=patientdata.length();
		System.out.println(n);
		for(int i=0;i<n;i++)
		{
			final JSONObject person=patientdata.getJSONObject(i);
			System.out.println(person.getInt("Value"));
		}
	*/
		try{  
			   JSONObject patientdetail=(new JSONObject(s2)).getJSONObject("00100010");  
			   String patientvr=patientdetail.getString("vr");  
			   Class patientValue= patientdetail.getClass();
			   
			  // int empsalary=emp.getInt("salary");  

			   //String str="Employee Name:"+empname+"\n"+"Employee Salary:"+empsalary;  
			  // textView1.setText(str);  
			   System.out.println(patientvr);
			  // System.out.println(patientValue.toString());

			}catch (Exception e) {e.printStackTrace();}  
			   //Do when JSON has problem.
			}
		
		/*	BufferedOutputStream bos=null;
		File file=new File("C:\\Users\\Vaibhav Shukla\\Downloads\\");
		File[] filearray=file.listFiles();
		
		
		try
		{
			for(int i=0;i<filearray.length;i++)
			{
			String str=getFileExtension(filearray[i]);
			if(filearray[i].isFile()  )
			{
				System.out.println("Filename : " +filearray[i]);
				System.out.println("File Extension :" +getFileExtension(filearray[i]));
			}
			
			}
		}catch(Exception e)
		{
			
		}
		
	}

	private static String getFileExtension(File file) {
		
		String filename=file.getName();
		if(filename.lastIndexOf(".")!=-1 && filename.lastIndexOf(".")!=0)
			return filename.substring(filename.lastIndexOf("."));
		else return "";
	}
*/
}

