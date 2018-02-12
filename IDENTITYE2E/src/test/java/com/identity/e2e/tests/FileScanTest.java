// ************************************
// This test will scan through all the files provided by the path in application properties and will return
// file MIME types
//*************************************

package com.identity.e2e.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.identity.e2e.propertyconfig.ReadProperties;
import com.identity.e2e.scan.ScanFiles;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})

public class FileScanTest  {
	
	@Autowired
	public ScanFiles scanFiles;	
	public static String directoryName;

	
	@Test
	public void fileMimeTypesTest() {
		// get the path from application propeties file
		directoryName=ReadProperties.getValueFromProperties("filePathForScanFiles");
		System.out.println(directoryName);
		// read and display all filtered files (excel and csv only) 
		scanFiles.readFileDetails(directoryName);
	}

}
