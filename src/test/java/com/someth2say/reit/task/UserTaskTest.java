package com.someth2say.reit.task;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import com.someth2say.reit.PostgresResource;

@QuarkusTest
@QuarkusTestResource(PostgresResource.class) 
public class UserTaskTest {

    @Test
    public void testTasksEndPoint() {
        given()
          .when().get("/task")
          .then()
             .statusCode(200);
    }

}