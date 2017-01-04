import static com.jayway.restassured.RestAssured.*;
import static com.jayway.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class CN001_Atendimento {
		
	
	@Test(priority = 1)
	public void postJsonOrder(){
	
		baseURI = "https://sandbox.moip.com.br";
			
		String myJson1 = "{ \"ownId\": \"Teste 1\",\"amount\": {\"currency\": \"BRL\",\"subtotals\": {\"shipping\": 1000}},\"items\": [{\"product\": \"Descrição do pedido\",\"quantity\": 1,\"detail\": \"Mais info...\",\"price\": 1000}],\"customer\": { \"ownId\": \"1234\", \"fullname\": \"Rubens de medeiros lobo\",\"email\": \"rubensLobo@hotmail.com\", \"birthDate\": \"1988-12-30\", \"taxDocument\": { \"type\": \"CPF\", \"number\": \"07873340490\" }, \"phone\": { \"countryCode\": \"55\", \"areaCode\": \"11\", \"number\": \"66778899\" }, \"shippingAddress\": { \"street\": \"Avenida Faria Lima\",\"streetNumber\": 2927, \"complement\": 8,\"district\": \"Itaim\", \"city\": \"Sao Paulo\", \"state\": \"SP\", \"country\": \"BRA\", \"zipCode\": \"01234000\" } }}";
		
		given()
			.contentType("application/json")
			.header("Authorization", "Basic UFFTRDBSUENJTVBSRElPV0FVR0JaWlJUWTlUR1pOWUY6TVBEVjVUWFhEM1lZSjNMTTdGUVFWQk40NUNJR0hYVEY3Q1RRRlI0Mg==")
			.body(myJson1)
		.when()
			.post("/v2/orders/")
		.then()
			.log()	
				.body()
			.statusCode(201);
				
  }
	
	@Test(priority = 2)
	public void getJsonOrder(){
	
		baseURI = "https://sandbox.moip.com.br";
				
		given()
			.contentType("application/json")
			.header("Authorization", "Basic UFFTRDBSUENJTVBSRElPV0FVR0JaWlJUWTlUR1pOWUY6TVBEVjVUWFhEM1lZSjNMTTdGUVFWQk40NUNJR0hYVEY3Q1RRRlI0Mg==")
		.when()
			.get("/v2/orders/ORD-MIIH0RAL6A3D")
		.then()
			.log()	
				.body()
			.statusCode(200);
				
  }
	
}

