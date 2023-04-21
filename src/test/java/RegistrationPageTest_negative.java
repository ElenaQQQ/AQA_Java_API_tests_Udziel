import entities.UserDataToRegistration;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.*;
import pageobject.RegistrationPage;

import static Config.TestData.*;

public class RegistrationPageTest_negative  extends RegistrationPage {
    public String userEmail = USER_RANDOM_EMAIL;
    public String userPassword = USER_TEST_PASSWORD;
    public String userName = USER_TEST_NAME;

    @Test (description = "with invalid e-mail: empty field")
    public void userRegistration_7(){
        userEmail = USER_EMAIL7;
        UserDataToRegistration userDataToRegistration = new UserDataToRegistration(userEmail, userPassword, userName);
        Response response = registerUser(userDataToRegistration);

        response.then().log().all().statusCode(400);
        Assert.assertTrue(response.then().extract().jsonPath().getString("email").contains(USER_RESPONSE7),
                "TEST FAILED: No expected message");

    }

    @Test (description = "with invalid e-mail: 255 symbols ")
    public void userRegistration_8(){
        userEmail = USER_EMAIL8;
        UserDataToRegistration userDataToRegistration = new UserDataToRegistration(userEmail, userPassword, userName);
        Response response = registerUser(userDataToRegistration);

        response.then().log().all().statusCode(400);
        Assert.assertTrue(response.then().extract().jsonPath().getString("email").contains(USER_RESPONSE8),
                "TEST FAILED: No expected message");

    }

    @Test (description = "with invalid e-mail: without @")
    public void userRegistration_9(){

        userEmail = USER_EMAIL9;
        UserDataToRegistration userDataToRegistration = new UserDataToRegistration(userEmail, userPassword, userName);
        Response response = registerUser(userDataToRegistration);

        response.then().log().all().statusCode(400);
        Assert.assertTrue(response.then().extract().jsonPath().getString("email").contains(USER_RESPONSE9),
                "TEST FAILED: No expected message");
    }

    @Test (description = "with invalid e-mail: contains \"..\"")
    public void userRegistration_10(){

        userEmail = USER_EMAIL10;
        UserDataToRegistration userDataToRegistration = new UserDataToRegistration(userEmail, userPassword, userName);
        Response response = registerUser(userDataToRegistration);

        response.then().log().all().statusCode(400);
        Assert.assertTrue(response.then().extract().jsonPath().getString("email").contains(USER_RESPONSE10),
                "TEST FAILED: No expected message");

    }

    @Test (description = "with invalid e-mail: starts with \".\"")
    public void userRegistration_11(){

        userEmail = USER_EMAIL11;
        UserDataToRegistration userDataToRegistration = new UserDataToRegistration(userEmail, userPassword, userName);
        Response response = registerUser(userDataToRegistration);

        response.then().log().all().statusCode(400);
        Assert.assertTrue(response.then().extract().jsonPath().getString("email").contains(USER_RESPONSE11),
                "TEST FAILED: No expected message");

    }

    @Test (description = "with invalid e-mail: domain part starts with .")
    public void userRegistration_12(){

        userEmail = USER_EMAIL12;
        UserDataToRegistration userDataToRegistration = new UserDataToRegistration(userEmail, userPassword, userName);
        Response response = registerUser(userDataToRegistration);

        response.then().log().all().statusCode(400);
        Assert.assertTrue(response.then().extract().jsonPath().getString("email").contains(USER_RESPONSE12),
                "TEST FAILED: No expected message");

    }

    @Test (description = "with invalid password: 7 symbols")
    public void userRegistration_21(){
        userPassword = USER_PASSWORD21;
        UserDataToRegistration userDataToRegistration = new UserDataToRegistration(userEmail, userPassword, userName);
        Response response = registerUser(userDataToRegistration);

        response.then().log().all().statusCode(400);
        Assert.assertTrue(response.then().extract().jsonPath().getString("password").contains(USER_RESPONSE21),
                "TEST FAILED: No expected message");

    }

    @Test (description = "with invalid password: equal to name + \"1\"")
    public void userRegistration_22(){
        userPassword = USER_PASSWORD22;
        UserDataToRegistration userDataToRegistration = new UserDataToRegistration(userEmail, userPassword, userName);
        Response response = registerUser(userDataToRegistration);

        response.then().log().all().statusCode(400);
        Assert.assertTrue(response.then().extract().jsonPath().getString("password").contains(USER_RESPONSE22),
                "TEST FAILED: No expected message");

    }

    @Test (description = "with invalid password: equal to email")
    public void userRegistration_23(){
        userPassword = userEmail;
        UserDataToRegistration userDataToRegistration = new UserDataToRegistration(userEmail, userPassword, userName);
        Response response = registerUser(userDataToRegistration);

        response.then().log().all().statusCode(400);
        Assert.assertTrue(response.then().extract().jsonPath().getString("password").contains(USER_RESPONSE23),
                "TEST FAILED: No expected message");

    }

    @Test (description = "with invalid password: numbers only >= 8 symbols")
    public void userRegistration_24(){
        userPassword = USER_PASSWORD24;
        UserDataToRegistration userDataToRegistration = new UserDataToRegistration(userEmail, userPassword, userName);
        Response response = registerUser(userDataToRegistration);

        response.then().log().all().statusCode(400);
        Assert.assertTrue(response.then().extract().jsonPath().getString("password").contains(USER_RESPONSE24),
                "TEST FAILED: No expected message");

    }

    @Test (description = "with invalid password: qwerty")
    public void userRegistration_25(){
        userPassword = USER_PASSWORD25;
        UserDataToRegistration userDataToRegistration = new UserDataToRegistration(userEmail, userPassword, userName);
        Response response = registerUser(userDataToRegistration);

        response.then().log().all().statusCode(400);
        Assert.assertTrue(response.then().extract().jsonPath().getString("password").contains(USER_RESPONSE25),
                "TEST FAILED: No expected message");

    }

    @Test (description = "with invalid name: empty field")
    public void userRegistration_31(){
        userName = USER_NAME31;
        UserDataToRegistration userDataToRegistration = new UserDataToRegistration(userEmail, userPassword, userName);
        Response response = registerUser(userDataToRegistration);

        response.then().log().all().statusCode(400);
        Assert.assertTrue(response.then().extract().jsonPath().getString("username").contains(USER_RESPONSE31),
                "TEST FAILED: No expected message");

    }

    @Test (description = "with invalid name: 151 symbol")
    public void userRegistration_32(){
        userName = USER_NAME32;
        UserDataToRegistration userDataToRegistration = new UserDataToRegistration(userEmail, userPassword, userName);
        Response response = registerUser(userDataToRegistration);

        response.then().log().all().statusCode(400);
        Assert.assertTrue(response.then().extract().jsonPath().getString("username").contains(USER_RESPONSE32),
                "TEST FAILED: No expected message");

    }

    @Test (description = "with invalid name: contains \"*/#\"")
    public void userRegistration_33(){
        userName = USER_NAME33;
        UserDataToRegistration userDataToRegistration = new UserDataToRegistration(userEmail, userPassword, userName);
        Response response = registerUser(userDataToRegistration);

        response.then().log().all().statusCode(400);
        Assert.assertTrue(response.then().extract().jsonPath().getString("username").contains(USER_RESPONSE33),
                "TEST FAILED: No expected message");

    }


}

