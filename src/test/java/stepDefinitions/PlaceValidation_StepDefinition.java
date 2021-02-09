package stepDefinitions;

import java.util.ArrayList;
import java.util.List;

import com.Pojo.AddPlace;
import com.Pojo.Location;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import junit.framework.Assert;
import resources.ApiResources;
import resources.TestDataPayload;
import resources.Utils;

public class PlaceValidation_StepDefinition extends Utils {
	RequestSpecification request;
	Response response;
	TestDataPayload payload = new TestDataPayload();

	@Given("Add place payload {string} {string} {string}")
	public void add_place_payload(String name, String language, String address) throws Exception {

		 request = RestAssured.given().spec(getRequestSpecification()).body(payload.addPlacePayload(name,language,address));

	}

	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String httpCall) {
		//creating object for Enum and loading the Enum constructor with resource value
		ApiResources apiResource= ApiResources.valueOf(resource);
		System.out.println(apiResource.getResource());
		
		ResponseSpecification res = new ResponseSpecBuilder().expectStatusCode(200).build();
		
		if(httpCall.equalsIgnoreCase("POST"))
		{
			response = request.when().post(apiResource.getResource())
					.then().spec(res).extract().response();
		}
		else if(httpCall.equalsIgnoreCase("GET"))
		{
			response = request.when().get(apiResource.getResource())
					.then().spec(res).extract().response();
		}
		
		 
		
		
		
		

	}

	@Then("Validate Statuscode {int}")
	public void validate_statuscode(Integer Statuscode) {
		Assert.assertEquals(response.getStatusCode(), 200);

	}

	@Then("Status is OK")
	public void status_is_ok() {
		String resp = response.asString();
		System.out.println(resp);
		JsonPath js =new JsonPath(resp);
		Assert.assertEquals(js.getString("status"), "OK");

	}

}
