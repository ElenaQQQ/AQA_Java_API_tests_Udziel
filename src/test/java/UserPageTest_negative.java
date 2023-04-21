import entities.UserDataToRegistration;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.UserPage;

import static Config.Credentials.USER_NAME;
import static Config.Credentials.USER_PASSWORD;
import static Config.TestData.*;
import static io.restassured.RestAssured.given;

public class UserPageTest_negative extends UserPage {

    private String accessToken;
    private UserDataToRegistration userRandomToTestChanges;

    @BeforeMethod
    public void precondition1(){
        String userRandomEmail = USER_RANDOM_EMAIL;
        userRandomToTestChanges = new UserDataToRegistration(userRandomEmail, USER_PASSWORD, USER_NAME);
        registerUser(userRandomToTestChanges);
        accessToken = getAccessToken(userRandomEmail, USER_PASSWORD);

    }

   @Test
    public void deleteUserMe_14(){
        Response response = deleteUserMe(userRandomToTestChanges.getEmail(), userRandomToTestChanges.getPassword());
        Assert.assertEquals(response.then().extract().statusCode(),204);
    }

    @Test (description = "change name to invalid: empty field")
    public void test_49() {

        Response response1 = changeUsername(USER_NAME49, accessToken);
        response1.then().log().all().statusCode(400);
        Assert.assertTrue(response1.then().extract().jsonPath().getString("username").contains(USER_RESPONSE49));
    }

    @Test (description = "change name to invalid: 151 symbol")
    public void test_50() {

        Response response1 = changeUsername(USER_NAME50, accessToken);
        response1.then().log().all().statusCode(400);
        Assert.assertTrue(response1.then().extract().jsonPath().getString("username").contains(USER_RESPONSE50));

    }

    @Test (description = "change name to invalid: contains \"*/#\"")
    public void test_51() {

        Response response1 = changeUsername(USER_NAME51, accessToken);
        response1.then().log().all().statusCode(400);
        Assert.assertTrue(response1.then().extract().jsonPath().getString("username").contains(USER_RESPONSE51));
    }



}
