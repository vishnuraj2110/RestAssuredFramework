package saturn.com.RestAssured;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateProject {

	@Test
	public void updateProject() {
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "Marvel");
		obj.put("projectName", "Mars");
		
		RequestSpecification req = RestAssured.given();
		
		 req.contentType(ContentType.JSON);
		 req.body(obj);
		
		Response res = RestAssured.put("http://localhost:8084/projects/TY_PROJ_606");
		res.prettyPrint();
		res.then().assertThat().statusCode(200);
	}
	
	@Test
	public void updateProjectByBDD() {
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "Marvel1");
		obj.put("projectName", "Mars1");
		
		RestAssured.given()
		.contentType(ContentType.JSON)
		.and()
		.body(obj)
		.when()
		.put("http://localhost:8084/projects/TY_PROJ_605")
		.then()
		.assertThat().statusCode(200).log().all();
		
	}
	
}
