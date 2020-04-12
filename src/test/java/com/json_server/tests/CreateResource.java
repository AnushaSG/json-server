package com.json_server.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.util.IOUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.json_server.generics.BaseLib;
import com.json_server.generics.IEndPoints;
import com.json_server.parser.JsonUtil;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

/**
 * 
 * @author Anusha
 *
 */
public class CreateResource extends BaseLib{

	@Test
	public void createResourceWithValidData() {
		try {
			FileInputStream fis=new FileInputStream(new File("./src/test/resources/Json/CreateResource.json"));
			Response response = given().contentType(ContentType.JSON).and().body(IOUtils.toByteArray(fis))
			.when().post(IEndPoints.CREATE_RESOURCE);
			response.then().assertThat().statusCode(201).and()
			.contentType(ContentType.JSON)
			.time(lessThan(1000l));
			Assert.assertEquals(JsonUtil.getJsonString(response, "author"), "Mathur");
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
