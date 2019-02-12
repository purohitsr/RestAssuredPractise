import org.testng.annotations.Test;

import com.home.model.Landlord;

import io.restassured.RestAssured;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class PostCall {
	
	

	@Test
	public void addLandLord(){
		RestAssured.baseURI ="http://localhost:8080";
		Landlord landLord = new Landlord("Alex", "Tudor", true);
		
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
