package rest.ComplexRequestResponse;

import static io.restassured.RestAssured.when;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;



public class ValidateComplexStaticResponse {

	@Test
	public void validateComplexStaticResponse() {
		String expData = "Ashwini";
		Response res =  when()
		.get("http://localhost:8084/projects");
		
		Object actData = res.jsonPath().get("[0].createdBy");
		System.out.println(actData);
		
		res.then().log().all();
		Assert.assertEquals(actData, expData);
		
	}
}
