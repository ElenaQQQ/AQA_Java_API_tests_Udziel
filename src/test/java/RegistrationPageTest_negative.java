import entities.UserDataToRegistration;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.*;
import pageobject.BasePage;
import pageobject.RegistrationPage;

import static Config.Config.*;
import static Config.Credentials.*;
import static io.restassured.RestAssured.*;

public class RegistrationPageTest_negative  extends RegistrationPage {


    @Test (description = "with invalid e-mail: empty field")
    public void userRegistration_7(){

        UserDataToRegistration userRegistration = new UserDataToRegistration(USER_PASSWORD, USER_NAME,"");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(userRegistration)
                .post("users/");

        response.then().log().all().statusCode(400);
        Assert.assertTrue(response.then().extract().jsonPath().getString("email").contains("не может быть пустым"),
                "TEST FAILED: No expected message");

    }

    @Test (description = "with invalid e-mail: 255 symbols ")
    public void userRegistration_8(){

        String email255 = "l".repeat(247).concat("@mail.ru");
        UserDataToRegistration userRegistration = new UserDataToRegistration(USER_PASSWORD, USER_NAME,email255);

        Response response = given()
                .header("Content-Type", "application/json")
                .body(userRegistration)
                .post("users/");

        response.then().log().all().statusCode(400);
        Assert.assertTrue(response.then().extract().jsonPath().getString("email").contains("не более 254 символов"),
                "TEST FAILED: No expected message");

    }

    @Test (description = "with invalid e-mail: without @")
    public void userRegistration_9(){

        UserDataToRegistration userRegistration = new UserDataToRegistration(USER_PASSWORD, USER_NAME,"lenamail.ru");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(userRegistration)
                .post("users/");

        response.then().log().all().statusCode(400);
        Assert.assertTrue(response.then().extract().jsonPath().getString("email").contains("Введите правильный адрес"),
                "TEST FAILED: No expected message");
    }

    @Test (description = "with invalid e-mail: contains \"..\"")
    public void userRegistration_10(){

        UserDataToRegistration userRegistration = new UserDataToRegistration(USER_PASSWORD, USER_NAME,"le..na@mail.ru");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(userRegistration)
                .post("users/");

        response.then().log().all().statusCode(400);
        Assert.assertTrue(response.then().extract().jsonPath().getString("email").contains("Введите правильный адрес"),
                "TEST FAILED: No expected message");

    }

    @Test (description = "with invalid e-mail: starts with \".\"")
    public void userRegistration_11(){

        UserDataToRegistration userRegistration = new UserDataToRegistration(USER_PASSWORD, USER_NAME,".lena@mail.ru");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(userRegistration)
                .post("users/");

        response.then().log().all().statusCode(400);
        Assert.assertTrue(response.then().extract().jsonPath().getString("email").contains("Введите правильный адрес"),
                "TEST FAILED: No expected message");

    }

    @Test (description = "with invalid e-mail: domain part starts with .")
    public void userRegistration_12(){

        UserDataToRegistration userRegistration = new UserDataToRegistration(USER_PASSWORD, USER_NAME,"lena@.mail.ru");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(userRegistration)
                .post("users/");

        response.then().log().all().statusCode(400);
        Assert.assertTrue(response.then().extract().jsonPath().getString("email").contains("Введите правильный адрес"),
                "TEST FAILED: No expected message");

    }



}

