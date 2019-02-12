import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.hamcrest.Matchers;
import org.hamcrest.collection.IsEmptyCollection;
import org.testng.annotations.Test;
import org.testng.internal.annotations.ConfigurationAnnotation;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import junit.framework.Assert;

//some Urls to test
//http://services.groupkt.com/country/get/all

public class BesicTests {
	
	//Simply check status code
	@Test
	public void testStatusCode(){
		
		Response response =given()
			   .contentType(ContentType.JSON)
	    .when()
		      .get("http://jsonplaceholder.typicode.com/posts/3")
		     
		.then()
		      .statusCode(200)
		      .extract()
		      .response();
		
		Assert.assertTrue(response.header("Content-Encoding").equals("gzip"));
		
		

	}
	
	//verify the response size
	@Test
	public void testlandlords(){

		given()
		      .contentType(ContentType.JSON)
		.when()
		      .get("http://jsonplaceholder.typicode.com/posts")
		.then()
		      .statusCode(200)
		      .body("size()", is(100));
		      
	}
	
	@Test
	public void testlandlords1(){

		given()
		       .contentType(ContentType.JSON)
		.when()
		       .get("http://jsonplaceholder.typicode.com/posts/3")
		.then()
		       .statusCode(200)
		       .body("size()", is(4))
		       .body("title", is("ea molestias quasi exercitationem repellat qui ipsa sit aut"))
		       .log().all()
		       .header("Content-Type", is("application/json; charset=utf-8"));
	}
	
	//verifying multiple content 
	
	@Test
	public void testmultipleContents(){
		given()
		   /*   .contentType("application/json;charset=UTF-8")
	    .when()*/
	          .get("http://services.groupkt.com/country/get/all")
	    .then()
//	          .statusCode(200)
	    //verify has items
	          .body("RestResponse.result.name", hasItems("Afghanistan","Algeria","Angola"))
	          .body("RestResponse.result.name.size()", equalTo(249))
	        //verify does not have items
	          .body("RestResponse.result.name", not(hasItems("cbc","db","ang")))
	         
	          .log().all();
		
	}
	
	//verify a perticular set of value in json array
	@Test
	public void test4thElementJsonArray(){
		given()
		       .get("http://services.groupkt.com/country/get/all")
		.then()
		       .body("RestResponse.result[3].name", is("Algeria"));
	}
	
	
	@Test
	public void test4thElementJsonArray1(){
		ValidatableResponse response =given()
		       .get("http://services.groupkt.com/country/get/all")
		.then()
		       .body("RestResponse.result[3].name", is("Algeria"))
		       .body("RestResponse.result[3].alpha2_code", is("DZ"))
		       .body("RestResponse.result[3].alpha3_code", is("DZA"));
		
		
		
	    
		
		
		
	}
	//above test can also be written as below by setting the root to 3rd result
	@Test
	public void test4thElementJsonArray2(){
		given()
		       .get("http://services.groupkt.com/country/get/all")
		.then()
		        .root("RestResponse.result[3]")
		       .body("name", is("Algeria"))
		       .body("alpha2_code", is("DZ"))
		       .body("alpha3_code", is("DZA"));
		
	}
	
	
	//we can also detach root
	@Test
	public void testdetachRoot(){
		given()
		       .get("http://services.groupkt.com/country/get/iso3code/ITA")
		.then()
		        .root("RestResponse.result")
		       .body("name", is("Italy"))
		       .body("alpha2_code", is("IT"))
		       .detachRoot("result")
		       .body("result.alpha3_code", is("ITA"));
		       
		
	}
	
	
	@Test
	public void testresponseStringSize(){
		Response response =given()
		       .get("http://jsonplaceholder.typicode.com/posts/3")
		.then()
		       .extract()
		       .response();
		
		
		
		
		       
		
	}
	

}
