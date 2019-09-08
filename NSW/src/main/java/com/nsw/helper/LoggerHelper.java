package com.nsw.helper;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoggerHelper {
	
	private static  boolean root=false;
	
	public static Logger getLogger(Class Agency){
		if(root) {
			return Logger.getLogger(Agency);
			
		}
		PropertyConfigurator.configure("log4j.properties");	
		root=true;
		return Logger.getLogger(Agency);
			
		}
	
	
}
