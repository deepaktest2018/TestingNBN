package com.readPropertiesFiles;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.memory.MemoryFile;

public class ReadAndWritePropertyFile {
	static FileReader reader=null;
	static Properties p=null;
	
public static String readPropertyFile(String pagename, String keyValue) throws IOException{
	 
	switch(pagename.toLowerCase()){
	case "login":
		 reader=new FileReader(MemoryFile.getCurentPath()+"\\PropertiesFile\\LoginProperties.properties");
		 break;
	case "homepage":
		 reader=new FileReader(MemoryFile.getCurentPath()+"\\PropertiesFile\\HomePageProperties.properties");
		 break;	 
	
	default:
		break;
	} 
    Properties p=new Properties();  
    p.load(reader);  
    String value=p.getProperty(keyValue);
    return value;
}

public static String readConFigPropertyFile(String keyValue) throws IOException{
	reader=new FileReader(MemoryFile.getCurentPath()+"\\ConfigarationProperties\\Config.properties");
    Properties p=new Properties();  
    p.load(reader);  
    String value=p.getProperty(keyValue);
    return value;
}




}
