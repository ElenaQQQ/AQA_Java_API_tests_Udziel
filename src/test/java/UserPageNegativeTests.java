import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.UserPage;

import static Config.TestData.*;
import static io.restassured.RestAssured.given;

public class UserPageNegativeTests extends UserPage {


   @Test
    public void deleteUserMe_14(){
        Response response = deleteUserMe(userToDelete);
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

    @Test (description = "change password to invalid: 7 symbols")
    public void test_39() {
        Response response1 = changeUserPassword(USER_PASSWORD39, accessToken);
        response1.then().log().all().statusCode(400);
        Assert.assertTrue(response1.then().extract().jsonPath().getString("new_password").contains(USER_RESPONSE39));
    }

    @Test (description = "change password to invalid: equal to name + \"1\"")
    public void test_40() {
        Response response1 = changeUserPassword(USER_PASSWORD40, accessToken);
        response1.then().log().all().statusCode(400);
        Assert.assertTrue(response1.then().extract().jsonPath().getString("new_password").contains(USER_RESPONSE40));
    }

    @Test (description = "change password to invalid: equal to email")
    public void test_41() {
        Response response1 = changeUserPassword(userToTest.getEmail(), accessToken);
        response1.then().log().all().statusCode(400);
        Assert.assertTrue(response1.then().extract().jsonPath().getString("new_password").contains(USER_RESPONSE41));
    }

    @Test (description = "change password to invalid: numbers only >= 8 symbols")
    public void test_42() {
        Response response1 = changeUserPassword(USER_PASSWORD42, accessToken);
        response1.then().log().all().statusCode(400);
        Assert.assertTrue(response1.then().extract().jsonPath().getString("new_password").contains(USER_RESPONSE42));
    }

    @Test (description = "change password to invalid: \"qwerty\"")
    public void test_43() {
        Response response1 = changeUserPassword(USER_PASSWORD43, accessToken);
        response1.then().log().all().statusCode(400);
        Assert.assertTrue(response1.then().extract().jsonPath().getString("new_password").contains(USER_RESPONSE43));
    }



}
