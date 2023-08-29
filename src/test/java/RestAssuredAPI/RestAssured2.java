package RestAssuredAPI;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;


public class RestAssured2 {
    @Test
	public void test1() 
	{
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getBody().asString());
		System.out.println(response.statusLine());
		int statuscode = response.getStatusCode();
		Assert.assertEquals(statuscode, 200);

	}
	
}
