package com.json_server.generics;

import org.testng.annotations.BeforeSuite;
import static io.restassured.RestAssured.*;

/**
 * 
 * @author Anusha
 *
 */
public class BaseLib {

	/**
	 * to initialize the base URI, port and authentication
	 */
	@BeforeSuite
	public void config() {
		baseURI="http://localhost";
		port=3000;

		// basic auth
		// given().auth().basic(userName, password);

		// Bearer Token
		// given().auth().oauth2(token);
	}
}
