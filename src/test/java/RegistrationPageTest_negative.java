import entities.UserDataToRegistration;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.*;
import pageobject.RegistrationPage;

import static Config.TestData.*;

public class RegistrationPageTest_negative  extends RegistrationPage {
    public String userEmail;

    @Test (description = "with invalid e-mail: empty field")
    public void userRegistration_7(){
        userEmail = USER_EMAIL7;
        UserDataToRegistration userDataToRegistration = new UserDataToRegistration(userEmail, USER_TEST_PASSWORD, USER_TEST_NAME);
        Response response = registerUser(userDataToRegistration);

        response.then().log().all().statusCode(400);
        Assert.assertTrue(response.then().extract().jsonPath().getString("email").contains(USER_RESPONSE7),
                "TEST FAILED: No expected message");

    }

    @Test (description = "with invalid e-mail: 255 symbols ")
    public void userRegistration_8(){
        userEmail = USER_EMAIL8;
        UserDataToRegistration userDataToRegistration = new UserDataToRegistration(userEmail, USER_TEST_PASSWORD, USER_TEST_NAME);
        Response response = registerUser(userDataToRegistration);

        response.then().log().all().statusCode(400);
        Assert.assertTrue(response.then().extract().jsonPath().getString("email").contains(USER_RESPONSE8),
                "TEST FAILED: No expected message");

    }

    @Test (description = "with invalid e-mail: without @")
    public void userRegistration_9(){

        userEmail = USER_EMAIL9;
        UserDataToRegistration userDataToRegistration = new UserDataToRegistration(userEmail, USER_TEST_PASSWORD, USER_TEST_NAME);
        Response response = registerUser(userDataToRegistration);

        response.then().log().all().statusCode(400);
        Assert.assertTrue(response.then().extract().jsonPath().getString("email").contains(USER_RESPONSE9),
                "TEST FAILED: No expected message");
    }

    @Test (description = "with invalid e-mail: contains \"..\"")
    public void userRegistration_10(){

        userEmail = USER_EMAIL10;
        UserDataToRegistration userDataToRegistration = new UserDataToRegistration(userEmail, USER_TEST_PASSWORD, USER_TEST_NAME);
        Response response = registerUser(userDataToRegistration);

        response.then().log().all().statusCode(400);
        Assert.assertTrue(response.then().extract().jsonPath().getString("email").contains(USER_RESPONSE10),
                "TEST FAILED: No expected message");

    }

    @Test (description = "with invalid e-mail: starts with \".\"")
    public void userRegistration_11(){

        userEmail = USER_EMAIL11;
        UserDataToRegistration userDataToRegistration = new UserDataToRegistration(userEmail, USER_TEST_PASSWORD, USER_TEST_NAME);
        Response response = registerUser(userDataToRegistration);

        response.then().log().all().statusCode(400);
        Assert.assertTrue(response.then().extract().jsonPath().getString("email").contains(USER_RESPONSE11),
                "TEST FAILED: No expected message");

    }

    @Test (description = "with invalid e-mail: domain part starts with .")
    public void userRegistration_12(){

        userEmail = USER_EMAIL12;
        UserDataToRegistration userDataToRegistration = new UserDataToRegistration(userEmail, USER_TEST_PASSWORD, USER_TEST_NAME);
        Response response = registerUser(userDataToRegistration);

        response.then().log().all().statusCode(400);
        Assert.assertTrue(response.then().extract().jsonPath().getString("email").contains(USER_RESPONSE12),
                "TEST FAILED: No expected message");

    }



}

