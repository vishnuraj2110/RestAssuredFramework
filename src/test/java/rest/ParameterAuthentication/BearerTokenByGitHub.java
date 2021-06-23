package rest.ParameterAuthentication;

import static io.restassured.RestAssured.DEFAULT_BODY_ROOT_PATH;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class BearerTokenByGitHub {

	@Test
	public void authenticatingByBearerToken() {
		JSONObject obj = new JSONObject();
		obj.put("name", "RestAssuredCheck1");
		given()
		//.contentType(ContentType.JSON)
		.body(obj)
		.auth().oauth2("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")
		.when().post("https://api.github.com/user/repos")
		.then().assertThat().statusCode(201)
		.log().all();
		
	}
}
