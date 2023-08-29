package RestAssuredAPI;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import io.restassured.module.jsv.JsonSchemaValidator;


public class JSONSchemaValidator {
	@Test
	public void GetTest() {
		
		baseURI = "http://localhost:3000/";
		
		given().get("users")
		.then()
		.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("localhost.json"))
		.statusCode(200);
	   }
}
