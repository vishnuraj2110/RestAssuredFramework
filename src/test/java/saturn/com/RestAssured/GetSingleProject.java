package saturn.com.RestAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetSingleProject {

	@Test
	public void getSingleProject() {
		Response res = RestAssured.get("http://localhost:8084/projects/TY_PROJ_404");
		System.out.println(res.asString());
		res.prettyPrint();
		res.then().statusCode(200);
		
	}
	
	
}
