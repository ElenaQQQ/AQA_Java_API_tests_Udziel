import entities.UserDataToRegistration;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.UserPage;

import static Config.Credentials.*;
import static Config.TestData.*;
import static io.restassured.RestAssured.*;

public class UserPageTest extends UserPage {

    private String accessToken;
    private UserDataToRegistration userRandomToTestChanges;

    @BeforeMethod
    public void precondition1(){
        String userRandomEmail = USER_RANDOM_EMAIL;
        userRandomToTestChanges = new UserDataToRegistration(userRandomEmail, USER_PASSWORD, USER_NAME);
        registerUser(userRandomToTestChanges);
        accessToken = getAccessToken(userRandomEmail, USER_PASSWORD);

    }


//    @Test
//    public void getInfoMe_13(){
//        Response response = given()
//                .header("Authorization", "Token " + getAccessToken(USER_EMAIL, USER_PASSWORD))
//                .when()
//                .get("users/me/");
//
//        response.then().log().all().statusCode(200);
//        Assert.assertEquals(response.then().extract().jsonPath().getString("username"),
//                "Name",
//                "Name is not equal");
//    }

//    @Test
//    public void deleteUserMe_14(){
//        Response response = deleteUserMe("lena26031811@mail.ru", USER_PASSWORD);
//        Assert.assertEquals(response.then().extract().statusCode(),204);
//    }

    @Test (description = "change name to valid: Uppercase and Lowercase letters")
    public void test_44() {
//        String userRandomEmail = USER_RANDOM_EMAIL;
//        UserDataToRegistration userRandomToTestChanges = new UserDataToRegistration(userRandomEmail, USER_PASSWORD, USER_NAME);
//        registerUser(userRandomToTestChanges);
//        String accessToken = getAccessToken(userRandomEmail, USER_PASSWORD);

        Response response1 = changeUsername(USER_NAME44, accessToken);
        response1.then().log().all().statusCode(200);
        Assert.assertEquals(USER_NAME44, response1.then().extract().jsonPath().getString("username"));
        deleteUserMe(userRandomToTestChanges.getEmail().toLowerCase(), userRandomToTestChanges.getPassword());
    }

    @Test (description = "change name to valid: Cyrillic letters")
    public void test_45() {
        String userRandomEmail = USER_RANDOM_EMAIL;
        UserDataToRegistration userRandomToTestChanges = new UserDataToRegistration(userRandomEmail, USER_PASSWORD, USER_NAME);
        Response response = registerUser(userRandomToTestChanges);
        String accessToken = getAccessToken(userRandomEmail, USER_PASSWORD);

        Response response1 = changeUsername(USER_NAME45, accessToken);
        response1.then().log().all().statusCode(200);
        Assert.assertEquals(USER_NAME45, response1.then().extract().jsonPath().getString("username"));

        deleteUserMe(userRandomToTestChanges.getEmail().toLowerCase(), userRandomToTestChanges.getPassword());
    }

    @Test (description = "change name to valid: Contains numbers")
    public void test_46() {
        String userRandomEmail = USER_RANDOM_EMAIL;
        UserDataToRegistration userRandomToTestChanges = new UserDataToRegistration(userRandomEmail, USER_PASSWORD, USER_NAME);
        Response response = registerUser(userRandomToTestChanges);
        String accessToken = getAccessToken(userRandomEmail, USER_PASSWORD);

        Response response1 = changeUsername(USER_NAME46, accessToken);
        response1.then().log().all().statusCode(200);
        Assert.assertEquals(USER_NAME46, response1.then().extract().jsonPath().getString("username"));
        deleteUserMe(userRandomToTestChanges.getEmail().toLowerCase(), userRandomToTestChanges.getPassword());
    }

    @Test (description = "change name to valid: Contains \"@+.-_\"")
    public void test_47() {
        String userRandomEmail = USER_RANDOM_EMAIL;
        UserDataToRegistration userRandomToTestChanges = new UserDataToRegistration(userRandomEmail, USER_PASSWORD, USER_NAME);
        Response response = registerUser(userRandomToTestChanges);
        String accessToken = getAccessToken(userRandomEmail, USER_PASSWORD);

        Response response1 = changeUsername(USER_NAME47, accessToken);
        response1.then().log().all().statusCode(200);
        Assert.assertEquals(USER_NAME47, response1.then().extract().jsonPath().getString("username"));
        deleteUserMe(userRandomToTestChanges.getEmail().toLowerCase(), userRandomToTestChanges.getPassword());
    }

    @Test (description = "change name to valid: Equal to email")
    public void test_48() {
        String userRandomEmail = USER_RANDOM_EMAIL;
        UserDataToRegistration userRandomToTestChanges = new UserDataToRegistration(userRandomEmail, USER_PASSWORD, USER_NAME);
        Response response = registerUser(userRandomToTestChanges);
        String accessToken = getAccessToken(userRandomEmail, USER_PASSWORD);

        Response response1 = changeUsername(USER_NAME48, accessToken);
        response1.then().log().all().statusCode(200);
        Assert.assertEquals(USER_NAME48, response1.then().extract().jsonPath().getString("username"));
        deleteUserMe(userRandomToTestChanges.getEmail().toLowerCase(), userRandomToTestChanges.getPassword());
    }

}
