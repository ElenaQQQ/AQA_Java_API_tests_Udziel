package pageobject;

import entities.UserDataToRegistration;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import static Config.Config.BASE_URI;
import static Config.Credentials.*;
import static Config.TestData.*;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class UserPage extends BasePage {

    protected UserDataToRegistration userRandomToTestChanges;
    protected String accessToken;

    @BeforeMethod
    public void beforeEachTest(){
        userRandomToTestChanges = new UserDataToRegistration(USER_RANDOM_EMAIL, USER_PASSWORD, USER_NAME);
        registerUser(userRandomToTestChanges);
        accessToken = getAccessToken(USER_RANDOM_EMAIL, USER_PASSWORD);
    }


    @AfterMethod
    public void deleteUserAfterTest(){
        deleteUserMe(userRandomToTestChanges.getEmail(), userRandomToTestChanges.getPassword());
    }

    public Response changeUsername(String newName, String accessToken){
        Response response = given()
                .when()
                .contentType(ContentType.JSON)
                .header("Authorization", "Token " + accessToken)
                .body("{\n" +
                        " \"username\": \"" + newName + "\"\n" +
                        "}")
                .patch("users/me/");

        return response;
    }

    public Response changeUserData(String newEmail, String newName, String newPassword){
        Response response = given()
                .when()
                .contentType(ContentType.JSON)
                .header("Authorization", "Token " + getAccessToken(newEmail, newPassword))
                .body("{\n" +
                        " \"email\": \"" + newEmail + "\"\n" +
                        " \"username\": \"" + newName + "\"\n" +
                        " \"password\": \"" + newPassword + "\"\n" +
                        "}")
                .put("users/me/");
        return response;
    }

    public Response changeUserPassword(String newPassword, String accessToken){
        Response response = given()
                .when()
                .contentType(ContentType.JSON)
                .header("Authorization", "Token " + accessToken)
                .body("{\n" +
                        " \"new_password\": \"" + newPassword + "\"\n" +
                        "}")
                .post("users/set_password/");
        return response;
    }

}
