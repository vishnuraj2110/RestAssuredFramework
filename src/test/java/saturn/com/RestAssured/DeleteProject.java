package saturn.com.RestAssured;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class DeleteProject {

	@Test
	public void deleteProjectByBDD() {
		
		 when()
		.delete("http://localhost:8084/projects/TY_PROJ_203")
		.then()
		.assertThat().statusCode(204)
		.assertThat().contentType(ContentType.JSON)
		.log().all();
	}
}
