package saturn.com.RestAssured;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetAllProjects {

	@Test
	public void getAllProject() {
		
//		Response res = RestAssured.get("http://localhost:8084/projects");
//		res.prettyPrint();
//		res.then().statusCode(200);
	}
	
	@Test
	public void getAllProjectsByBDD() {
		
		when()
		.get("http://localhost:8084/projects")
		.then().assertThat().contentType(ContentType.JSON)
		.assertThat().statusCode(200);
		
		
	}
	
}
