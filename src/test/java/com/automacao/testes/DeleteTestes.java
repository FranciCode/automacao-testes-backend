package com.automacao.testes;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class DeleteTestes {

    @Test
    public void testePositivoDelete() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        given()
                .when()
                .delete("/posts/1")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void testeNegativoDelete() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        given()
                .when()
                .delete("/posts/")
                .then()
                .statusCode(404)
                .log().all();
    }
}
