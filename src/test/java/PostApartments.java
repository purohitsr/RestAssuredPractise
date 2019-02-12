import org.testng.annotations.Test;

import com.home.model.Apartments;
import com.home.model.Landlord;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.List;
public class PostApartments {
	
	@Test
	public void testPostApartments(){
		RestAssured.baseURI="http://localhost:8080";
		Landlord landlord = new Landlord("Kyle", "Mills", false);
		List<String> features = new ArrayList<String>();
		features.add("gym");
		features.add("swimming pool");
		features.add("play Area");
		Apartments apartment = new Apartments("Hal", 5100000, 1200, features, true);
		String id =given()
		      .header("Content-Type","application/json")
		      .body(landlord)
	    .when()
	          .post("/landlords")
	    .then()
	          .statusCode(201)
	          .extract()
	          .path("id");
		
		
		given()
		      .pathParam("id", id)
		      .header("Content-Type","application/json")
		      .body(apartment)
		.when()
		      .post("/landlords/{id}/apartments")
		 .then()
		      .statusCode(201);
		 
		
		
	}

}
