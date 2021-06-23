package rest.ParameterAuthentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BasicAuth {

	@Test
	public void basicAuthentication() {
		
		given().auth().basic("rmgyanta","rmgy@9999")
	    .when().get("http://localhost:8084/login")
	    .then().log().all()
	    .assertThat().statusCode(200);
	}
     
     
     
}
