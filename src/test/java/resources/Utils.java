package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Utils {
	static RequestSpecification req;
	
	public RequestSpecification getRequestSpecification() throws Exception
	{
		if(req==null)
		{
		PrintStream log =new PrintStream(new FileOutputStream("logging.txt"));
		 req = new RequestSpecBuilder().setBaseUri(Utils.getGlobalPropertyValue("baseUrl"))
				.addQueryParam("key", "qaclick123").setContentType(ContentType.JSON)
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log)).build();
		}
		 return req;
	}
	
	public static String getGlobalPropertyValue(String key) throws IOException
	{
		
		Properties prop = new Properties();
		FileInputStream fis =new FileInputStream("./global.properties");
		prop.load(fis);
		return prop.getProperty(key);
		
		
	}


}
