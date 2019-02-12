package com.home.testcases;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

import org.testng.annotations.Test;

import com.home.model.Landlord;
import com.home.util.DataUtils;

import io.restassured.RestAssured;

public class LandLordTests {
	
	@Test(dataProviderClass=DataUtils.class,dataProvider="getData")
	public void createLandlords(String firstName,String lastName,String trusted,String apart){
	
		
		    boolean tru =Boolean.parseBoolean(trusted);
			RestAssured.baseURI ="http://localhost:8080";
			Landlord landLord = new Landlord(firstName,lastName,tru);
			
			String id =given()
			     .header("Content-Type","application/json")
			     .body(landLord)
			.when()
			     .post("/landlords")
			 .then()
			     .statusCode(201)
			     .body("firstName", is(landLord.getFirstName()))
			     .body("lastName", is(landLord.getLastName()))
			     .extract()
			     .path("id");
			
			given()
			      .pathParam("id", id)
			.when()
			      .get("http://localhost:8080/landlords/{id}")
			.then()
			      .statusCode(200)
			      .body("firstName", is(landLord.getFirstName()))
				  .body("lastName", is(landLord.getLastName()));
			
		}
	}


