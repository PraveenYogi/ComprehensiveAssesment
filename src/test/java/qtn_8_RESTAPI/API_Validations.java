package qtn_8_RESTAPI;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class API_Validations {

	@BeforeMethod
	public void setup() {
		RestAssured.baseURI = "https://reqres.in";
	}

@Test
public void getResponseBody(){
Response response =
(Response) given().log().all()
.contentType(ContentType.XML)
.queryParam( "page", "2")
.when()
.get("/api/users");
System.out.println(response.body().prettyPrint());

ResponseBody body = response.body();
Assert.assertEquals(body.path("data[l].last_name"), "Ferguson","Does NOT contains given Lastname");
Assert.assertTrue(body.path( "data[0].last_name").equals("Lawson"),"Response Does NOT contains given Lastname");
}
}
