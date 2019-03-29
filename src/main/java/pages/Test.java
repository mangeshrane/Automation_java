package pages;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.hamcrest.core.IsInstanceOf;

import static io.restassured.module.jsv.JsonSchemaValidator.*;

import io.restassured.http.ContentType;
import pojo.SkillLevel;
import pojo.Xest;

public  class Test {
	
	
	public static void main(String[] args) {
		System.out.println(SkillLevel.values());
		System.out.println(SkillLevel.ADVANCED);
	}
	
	/*@org.testng.annotations.Test
	public void simpleGetRequest(){
		given().accept(ContentType.JSON).
		when().get("http://reqres.in/api/users?page=2").
		then().body("page", equalTo(2)).
		body("data.id", hasItems(4, 5, 6)).
		body("data", hasSize(3)).
		header("Server", "cloudflare").
		statusCode(200).
		body("data.findall.size()", equalTo(4)).
		body(matchesJsonSchemaInClasspath("jsonSchema/users.json")).
		log().all();
	}
	
	@org.testng.annotations.Test(enabled=false)
	public void simplePostRequest(){
		given().accept(ContentType.JSON).
		body("{\"name\": \"morpheus\",\"job\": \"leader\" +}").
		post("https://reqres.in/api/users").
		then().
		body("name", equalTo("morpheus")).
		body("job", equalTo("leader")).
		log().all();
	}
	
	@org.testng.annotations.Test
	public void putRequest(){
		given().accept(ContentType.JSON).
		body("").put("https://reqres.in/api/users/2").
		then().
		body("$", hasKey("updatedAt"));
	
	}
	
	@org.testng.annotations.Test
	public void sampleSampleAuth(){
		given().accept(ContentType.JSON);
	}*/
}
