package saturn.com.RestAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SamplePrac1 {
	
	@Test
	public void getAllProject() {
      Response res=RestAssured.get("http://localhost:8084/projects");
      //System.out.println(res.asString());
     // res.prettyPeek();
      res.then().log().all();

	}

}
