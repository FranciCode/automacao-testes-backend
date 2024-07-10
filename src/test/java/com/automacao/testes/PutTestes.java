package com.automacao.testes;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PutTestes {

    @Test
    public void testePositivoPut() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        String requestBody = "{\"id\": 1, \"title\": \"foo updated\", \"body\": \"bar updated\", \"userId\": 1}";

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .put("/posts/1")
                .then()
                .statusCode(200)
                .body("title", equalTo("foo updated"))
                .body("body", equalTo("bar updated"))
                .body("userId", equalTo(1))
                .log().all();
    }

    @Test
    public void testeNegativoPut() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        String invalidRequestBody = "{\"title\": \"foo updated\", \"body\": \"bar updated\", \"userId\": 1}";

        given()
                .contentType(ContentType.JSON)
                .body(invalidRequestBody)
                .when()
                .put("")
                .then()
                .statusCode(404)
                .log().all();
    }
}
