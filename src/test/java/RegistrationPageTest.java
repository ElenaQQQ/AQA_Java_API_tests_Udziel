import entities.UserCreated;
import entities.UserRegistration;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.*;
import pageobject.BasePage;

import static Config.Credentials.*;
import static io.restassured.RestAssured.*;

public class RegistrationPageTest  extends BasePage {

    @Test (description = "with valid e-mail: lower case")
    public void userRegistration1(){

        UserRegistration userRegistration = new UserRegistration(USER_PASSWORD, USER_NAME,"lena19032139@gmail.com");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(userRegistration)
                        .post("http://udzel.hopto.org/api/users/");

        response.then().log().all().statusCode(201);
        System.out.println("XXXXXXXXXXXXXXX " + response.then().extract().jsonPath().getString("username"));
//        Assert.assertEquals(USER_NAME, userCreated.getUsername(),
//                "Not equal");

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
