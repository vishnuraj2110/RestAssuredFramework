package saturn.com.RestAssured;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.optimus.pojolib.PojoClass;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class CreateProject {

	@Test
	public void addProject(){
	  
		 JSONObject obj = new JSONObject();
		 obj.put("createdBy", "Picachu");
		 obj.put("projectName", "SDET-13");
		 obj.put("status", "Completed");
		 obj.put("teamSize", 20);
	    //RequestSpecification res = RestAssured.given(); bcz of making restassured import as static
		 
		// res.contentType(ContentType.JSON);
		// res.body(obj);
		 
		// Response response = res.post("http://localhost:8084/addProject");
		// System.out.println(response.getStatusCode());
         // or we can follow below step where we can save string of variable
	     }
	
	@Test
	public void addProjectByBDD() {
		JSONObject obj = new JSONObject();
		 obj.put("createdBy", "Picachu");
		 obj.put("projectName", "SDET-13");
		 obj.put("status", "Completed");
		 obj.put("teamSize", 20);
		 
		  given()
		 .contentType(ContentType.JSON)
		 .and()
		 .body(obj)
		 .when()
		 .post("http://localhost:8084/addProject")
		 .then()
		 .assertThat().statusCode(201)
		 .log().all();
	      }
	
	@Test
	public void addProjectByMap() {
		HashMap map = new HashMap();
		map.put("createdBy","Nitish" );
		map.put("projectName", "Venus");
		map.put("status", "ongoing");
		map.put("teamSize","10" );
	
		given()
		.contentType(ContentType.JSON)
		.body(map)
		.when()
		.post("http://localhost:8084/addProject")
		.then().log().all()
		.assertThat().statusCode(201);
	   }
	@Test
	public void createProjectByPojo() {
		
	 PojoClass pojo=new PojoClass("Rajesh","Big Bang Theory","10","completed");
	 
	 given()
	 .contentType(ContentType.JSON)
	 .body(pojo)
	 .when()
	 .post("http://localhost:8084/addProject")
	 .then().assertThat().statusCode(201)
	 .log().all();
	 
	 
	 
		
	}
	}


