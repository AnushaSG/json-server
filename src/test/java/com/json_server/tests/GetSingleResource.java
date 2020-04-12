package com.json_server.tests;


import org.testng.annotations.Test;
import com.json_server.generics.BaseLib;
import com.json_server.generics.IEndPoints;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/**
 * 
 * @author Anusha
 *
 */
public class GetSingleResource extends BaseLib {

	@Test
	public void getSingleResourceWithValidId() {
		given().pathParam("id", 107).when().get(IEndPoints.SINGLE_RESOURCE)
		.then().assertThat().statusCode(200).and()
				.contentType(ContentType.JSON)
				.and().body("title", equalTo("DSP")).and()
				.body("author", equalTo("Ganesh Rao"))
				.and().time(lessThan(1000l));
	}
	
	@Test
	public void getSingleResourceWithInValidId() {
		given().pathParam("id", 188).when().get(IEndPoints.SINGLE_RESOURCE)
		.then().assertThat().statusCode(404).and()
				.contentType(ContentType.JSON)
				.and().time(lessThan(1200l));
	}

}
