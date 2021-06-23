package rest.ComplexRequestResponse;

import static io.restassured.RestAssured.when;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class ValidateComplexDyanmicResponse {

	@Test
	public void validateComplexResponseDynamically() {
		
		String ExpData= "Mars excavation";
        Response res = when().get("http://localhost:8084/projects");
        List <String> projectNames = res.jsonPath().get("projectName");
        
		for(String s: projectNames) {
			if(s.equalsIgnoreCase(ExpData)) {
				System.out.println(ExpData+ " expected response ");
				break;
			}
		}
	    res.then().log().all();
	}
}
