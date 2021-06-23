package com.optimus.genericUtils;

import static io.restassured.RestAssured.*;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;




public class BaseClass {

	public DataBaseUtility dbLib = new DataBaseUtility();
	public static RequestSpecification httpRequest;
	public static Response response;
	
	public String CreatedBy = "vishnu_raj";
	public String ProjectName = "Optimus";
	public String Status = "Created";
	public String TeamSize = "50";
	
	public Logger logger;
	
	@BeforeSuite
	public void configBS() {

		baseURI ="http://localhost:8084";
		dbLib.connectToDB();
	}
	
	
     @BeforeClass
	 public void setup() 
	 {
    	 baseURI="http://localhost:8084/";
		 logger = Logger.getLogger("Optimus"); //Added Logger
		 PropertyConfigurator.configure("Log4j2.properties");
		 logger.setLevel(Level.DEBUG);
	 }
		 
    @AfterSuite
	public void configAS() throws Throwable {
				dbLib.closeDb();
			}  
			
			
			
			
}
