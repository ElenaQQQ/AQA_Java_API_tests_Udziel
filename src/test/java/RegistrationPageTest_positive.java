import entities.UserDataToRegistration;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.*;
import pageobject.BasePage;

import static Config.Credentials.*;
import static io.restassured.RestAssured.*;

public class RegistrationPageTest_positive extends BasePage {

    @Test (description = "with valid e-mail: lower case")
    public void userRegistration_1(){

        UserDataToRegistration userRegistration = new UserDataToRegistration(USER_PASSWORD, USER_NAME,"lena21031524@gmail.com");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(userRegistration)
                        .post("users/");

        response.then().log().all().statusCode(201);
        Assert.assertEquals(USER_NAME, response.then().extract().jsonPath().getString("username"),
                "TEST FAILED: Name of registered user not equal to user registration data");
    }

    @Test (description = "with valid e-mail: lower case and upper case")
    public void userRegistration_2(){

        UserDataToRegistration userRegistration = new UserDataToRegistration(USER_PASSWORD, USER_NAME,"LenA21031215@gmail.com");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(userRegistration)
                .post("users/");

        response.then().log().all().statusCode(201);
        Assert.assertEquals(USER_NAME, response.then().extract().jsonPath().getString("username"),
                "TEST FAILED: Name of registered user not equal to user registration data");

    }

    @Test (description = "with valid e-mail: starting with number")
    public void userRegistration_3(){

        UserDataToRegistration userRegistration = new UserDataToRegistration(USER_PASSWORD, USER_NAME,"1lena21031215@gmail.com");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(userRegistration)
                .post("users/");

        response.then().log().all().statusCode(201);
        Assert.assertEquals(USER_NAME, response.then().extract().jsonPath().getString("username"),
                "TEST FAILED: Name of registered user not equal to user registration data");

    }

    @Test (description = "with valid e-mail: with several dots in name part, not in a row")
    public void userRegistration_4(){

        UserDataToRegistration userRegistration = new UserDataToRegistration(USER_PASSWORD, USER_NAME,"lena.21.031.215@gmail.com");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(userRegistration)
                .post("users/");

        response.then().log().all().statusCode(201);
        Assert.assertEquals(USER_NAME, response.then().extract().jsonPath().getString("username"),
                "TEST FAILED: Name of registered user not equal to user registration data");

    }

    @Test (description = "with valid e-mail: with several dots in domain part, not in a row")
    public void userRegistration_5(){

        UserDataToRegistration userRegistration = new UserDataToRegistration(USER_PASSWORD, USER_NAME,"lena21031215@gmail.com.com.j.com");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(userRegistration)
                .post("users/");

        response.then().log().all().statusCode(201);
        Assert.assertEquals(USER_NAME, response.then().extract().jsonPath().getString("username"),
                "TEST FAILED: Name of registered user not equal to user registration data");

    }

    @Test (description = "with valid e-mail: with \"-\" in name part")
    public void userRegistration_6(){

        UserDataToRegistration userRegistration = new UserDataToRegistration(USER_PASSWORD, USER_NAME,"len-a21031215@gmail.com");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(userRegistration)
                .post("users/");

        response.then().log().all().statusCode(201);
        Assert.assertEquals(USER_NAME, response.then().extract().jsonPath().getString("username"),
                "TEST FAILED: Name of registered user not equal to user registration data");

    }



}
