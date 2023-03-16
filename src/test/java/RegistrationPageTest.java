import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class RegistrationPageTest extends BasePageTest {

    @Test
    public void getMyUserInfo(){
        given()
                .baseUri("http://udzel.hopto.org/api/")
                .headers("Authorization","Token eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0b2tlbl90eXBlIjoiYWNjZXNzIiwiZXhwIjoxNjgxMzk5NjY3LCJpYXQiOjE2Nzg4MDc2NjcsImp0aSI6IjFjNzNiNmJkYmU2NjQzNTNiMzY4MDU3ZDY4NGNjNWZiIiwidXNlcl9pZCI6NTh9.1Z6X2WyYqPKX6ymCZh9CiUew90kY0TXD1n1Iv9UfvSo")
                .when()
                .get("users/me/")
                .then()
                .statusCode(200);

    }



}

//    @BeforeTest
//    public void precondition() {
//        baseURI = "https://reqres.in/api";
//    }
//
//    @Test
//    public void get_test(){
//        Response response = given().get("/users?id=2");
//        response.then().assertThat().statusCode(200);
//        Assert.assertEquals(response.then().extract().response().jsonPath().getInt("data.id"), 2);
//    }
