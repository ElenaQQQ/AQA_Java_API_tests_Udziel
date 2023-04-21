import entities.UserDataToRegistration;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.UserPage;

import static Config.Credentials.*;
import static Config.TestData.*;
import static io.restassured.RestAssured.*;

public class UserPageTest_positive extends UserPage {

    private String accessToken;
    private UserDataToRegistration userRandomToTestChanges;

    @BeforeMethod
    public void precondition1(){
        String userRandomEmail = USER_RANDOM_EMAIL;
        userRandomToTestChanges = new UserDataToRegistration(userRandomEmail, USER_PASSWORD, USER_NAME);
        registerUser(userRandomToTestChanges);
        accessToken = getAccessToken(userRandomEmail, USER_PASSWORD);

    }


    @AfterMethod
    public void deleteUserAfterTest(){
        deleteUserMe(userRandomToTestChanges.getEmail().toLowerCase(), userRandomToTestChanges.getPassword());
    }

    @Test
    public void getInfoMe_13(){
        Response response = given()
                .header("Authorization", "Token " + accessToken)
                .when()
                .get("users/me/");

        response.then().log().all().statusCode(200);
        Assert.assertEquals(response.then().extract().jsonPath().getString("username"),
                "Name",
                "Name is not equal");
    }


    @Test (description = "change name to valid: Uppercase and Lowercase letters")
    public void test_44() {
        Response response1 = changeUsername(USER_NAME44, accessToken);
        response1.then().log().all().statusCode(200);
        Assert.assertEquals(USER_NAME44, response1.then().extract().jsonPath().getString("username"));
    }

    @Test (description = "change name to valid: Cyrillic letters")
    public void test_45() {
        Response response1 = changeUsername(USER_NAME45, accessToken);
        response1.then().log().all().statusCode(200);
        Assert.assertEquals(USER_NAME45, response1.then().extract().jsonPath().getString("username"));
    }

    @Test (description = "change name to valid: Contains numbers")
    public void test_46() {
        Response response1 = changeUsername(USER_NAME46, accessToken);
        response1.then().log().all().statusCode(200);
        Assert.assertEquals(USER_NAME46, response1.then().extract().jsonPath().getString("username"));
    }

    @Test (description = "change name to valid: Contains \"@+.-_\"")
    public void test_47() {
        Response response1 = changeUsername(USER_NAME47, accessToken);
        response1.then().log().all().statusCode(200);
        Assert.assertEquals(USER_NAME47, response1.then().extract().jsonPath().getString("username"));
    }

    @Test (description = "change name to valid: Equal to email")
    public void test_48() {
        Response response1 = changeUsername(USER_NAME48, accessToken);
        response1.then().log().all().statusCode(200);
        Assert.assertEquals(USER_NAME48, response1.then().extract().jsonPath().getString("username"));
    }

}
