import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Response response = get("");
		ValidatableResponse resp = response.then();
		resp.and().and().noRoot();

	}

}
