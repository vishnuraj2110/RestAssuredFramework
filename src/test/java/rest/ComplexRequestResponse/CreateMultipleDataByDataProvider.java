package rest.ComplexRequestResponse;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.optimus.pojolib.PojoClass;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;


public class CreateMultipleDataByDataProvider {

	
	@Test(dataProvider = "provideData")
	public void createProjectByMultipleByDataProvider(String createdBy, String projectName, String teamSize) {
		
		PojoClass pojo = new PojoClass(createdBy, projectName, teamSize, "Ongoing");
		
		given()
		.contentType(ContentType.JSON)
		.body(pojo)
		.when()
		.post("http://localhost:8084/addProject")
		.then().log().all()
		.assertThat().statusCode(201);
	}
	
	@DataProvider
	@Test
	public Object[][] provideData() {
		
		Object [][] obj = new Object [5][3];
		
		obj[0][0]= "ramji";
		obj[0][1]="Mars excavation";
	    obj[0][2]="20";
	

		obj[1][0]= "LaxMiJi";
		obj[1][1]="venu exploration";
	    obj[1][2]="10";

		obj[2][0]= "Vikrant";
		obj[2][1]="Optimus";
	    obj[2][2]="5";

		obj[3][0]= "ramji";
		obj[3][1]="Mars excavation";
	    obj[3][2]="6";
	    
	    return obj;
	
	}
}
