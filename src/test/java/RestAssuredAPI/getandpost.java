package RestAssuredAPI;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import java.util.Map;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class getandpost {
    @Test
	public void GetTest() {
	
		baseURI = "https://reqres.in/api";
		
		given().get("users?page=2")
		.then()
		.statusCode(200)
		.body("data[4].first_name", equalTo("George"))
		.body("data.first_name", hasItems("George","Rachel"));
	   }
    
    @Test
    public void PostTest() {
    	Map<String, Object> map = new HashMap<String, Object>();
    	
    	map.put("name", "Ragav");
    	map.put("job", "Teacher");
    	System.out.println(map);
    	
    	JSONObject request = new JSONObject();
    	request.put("name", "Ragav");
    	request.put("job", "Teacher");
    	
    	System.out.println(request.toJSONString());
    	
    	baseURI="https://reqres.in/api";
    	
    	given()
    		.header("Content-Type","application/json")
    		.contentType(ContentType.JSON).accept(ContentType.JSON)
    		.body(request.toJSONString())
    	.when()
    		.post("/users")
    	.then()
    		.statusCode(201)
    	.log().all();
    	}
}