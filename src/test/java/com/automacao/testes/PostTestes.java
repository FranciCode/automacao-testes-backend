package com.automacao.testes;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostTestes {

    @Test
    public void testePositivoPost() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        String requestBody = "{\"title\": \"foo\", \"body\": \"bar\", \"userId\": 1}";

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/posts")
                .then()
                .statusCode(201) // código de status esperado para criação
                .body("title", equalTo("foo"))
                .body("body", equalTo("bar"))
                .body("userId", equalTo(1))
                .log().all();
    }

    @Test
    public void testeNegativoPost() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        String invalidRequestBody = "{\"\":1";

        given()
                .contentType(ContentType.JSON)
                .body(invalidRequestBody)
                .when()
                .post("/posts")
                .then()
                .statusCode(500)
                .log().all();
    }
}
