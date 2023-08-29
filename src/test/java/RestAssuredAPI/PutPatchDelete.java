package RestAssuredAPI;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PutPatchDelete 
{	
	@Test
	public void PutTest() {
    
	   JSONObject request = new JSONObject();
	   request.put("name", "Raghav");
	   request.put("job", "Teacher");
	   
	   System.out.println(request.toJSONString());
	   baseURI="https://reqres.in/api";
	   
	   given()
	   		.header("Content-Type", "application/json")
	   		.contentType(ContentType.JSON).accept(ContentType.JSON)
	        .body(request.toJSONString()).
	   when().
	   		put("/users/2").
	   then().
	        statusCode(200);
	        
	}
	
	@Test
	public void PatchTest() {
		JSONObject request = new JSONObject();
		   request.put("name", "Raghav");
		   request.put("job", "Teacher");
		   
		   System.out.println(request.toJSONString());
		   baseURI="https://reqres.in";
		   
		   given()
		   		.header("Content-Type", "application/json")
		   		.contentType(ContentType.JSON).accept(ContentType.JSON)
		        .body(request.toJSONString()).
		   when().
		   		patch("/api/users/2").
		   then().
		        statusCode(200);
		        
		}
	
	@Test
	public void DeleteTest() {
		  
		   baseURI="https://reqres.in";
		   when().
			    delete("/api/users/2").
	       then().
		     statusCode(204);
		    
	}
}
