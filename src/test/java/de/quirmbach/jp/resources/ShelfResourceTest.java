package de.quirmbach.jp.resources;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class ShelfResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/shelf")
          .then()
             .statusCode(200)
             .body(is("Hello from RESTEasy Reactive"));
    }

}