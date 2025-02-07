package com.restassuredapi.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredApiPages {
	
	public static void main(String[] args) {
		final Logger logger = LogManager.getLogger(RestAssuredApiPages.class);
		RestAssured.baseURI = "https://reqres.in/";
		RequestSpecification reqSpec = RestAssured.given();
		Response response = null;
		//Get req - retrieve the data 
		response = reqSpec.request(Method.GET, "api/users/3");
		logger.info(response.asPrettyString());
		logger.info(response.getStatusLine());
		//Post req - create the resource
		reqSpec = RestAssured.given().body("{\r\n"
				+ "    \"id\": 14,\r\n"
				+ "    \"email\": \"marshal.howell@reqres.in\",\r\n"
				+ "    \"first_name\": \"Marshal\",\r\n"
				+ "    \"last_name\": \"Howell\",\r\n"
				+ "    \"avatar\": \"https://reqres.in/img/faces/14-image.jpg\",\r\n"
				+ "}");
		response = reqSpec.request(Method.POST, "api/users");
		logger.info(response.asPrettyString());
		logger.info(response.getStatusLine());
		logger.info("Element is retrieved");
		//Put req - update/modify the resource
		response = reqSpec.request(Method.PUT, "api/users/14");
		logger.info(response.asPrettyString());
		logger.info(response.getStatusLine());
		logger.info("Element is retrieved");
		//Delete req - delete the resource
		response = reqSpec.request(Method.DELETE, "api/users/14");
		System.out.println(response.asPrettyString());
		System.out.println(response.getStatusLine());
		logger.info("Element is retrieved");
		
	}

}
