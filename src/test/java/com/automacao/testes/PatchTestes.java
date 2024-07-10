package com.automacao.testes;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PatchTestes {

    @Test
    public void testePositivoPatch() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        String requestBody = "{\"title\": \"updated title\"}";

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .patch("/posts/1")
                .then()
                .statusCode(200)
                .body("title", equalTo("updated title"))
                .body("id", equalTo(1))
                .log().all();
    }

    @Test
    public void testeNegativoPatch() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        given()
                .contentType(ContentType.JSON)
                .body(" ")
                .when()
                .patch("/posts/")
                .then()
                .statusCode(500)
                .log().all();
    }
}
