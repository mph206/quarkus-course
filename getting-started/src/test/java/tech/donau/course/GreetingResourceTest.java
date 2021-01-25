package tech.donau.course;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest // annotation bootstraps app on a different port to run tests
public class GreetingResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body(is("_test martin!your country is test England"));
    }

    @Test
    public void testHelloWithNameEndpoint() {
        final String name = UUID.randomUUID().toString();
        given()
                .when().get("/hello/" + name)
                .then()
                .statusCode(200)
                .body(is("Hello " + name + ", your id is 1234"));
    }

}