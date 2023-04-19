package pageobject;

import entities.UserDataToRegistration;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import static Config.Config.BASE_URI;
import static Config.Credentials.*;
import static Config.TestData.*;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class UserPage extends BasePage {
//    private String accessToken;
//    private UserDataToRegistration userRandomToTestChanges;
//
//    @BeforeTest
//    public void start() {
//        baseURI = BASE_URI;
//
//        String body = "{\n" +
//                " \"email\": \"" + USER_EMAIL + "\",\n" +
//                " \"password\": \"" + USER_PASSWORD + "\"\n" +
//                "}";
//
//        Response response = given()
//                .header("Content-Type", "application/json")
//                .body(body)
//                .post("jwt/create/");
//
//        response.then().log().all().statusCode(200);
//
//        setAccessToken(response.then().extract().response().jsonPath().getString("access"));
//        getAccessToken(USER_EMAIL, USER_PASSWORD);
//    }

//    public String getAccessToken() {
//        return accessToken;
//    }
//
//    public void setAccessToken(String accessToken){
//        this.accessToken = accessToken;
//    }

//    @BeforeMethod
//    public void precondition(){
//        String userRandomEmail = USER_RANDOM_EMAIL;
//        userRandomToTestChanges = new UserDataToRegistration(userRandomEmail, USER_PASSWORD, USER_NAME);
//        Response response = registerUser(userRandomToTestChanges);
//        accessToken = getAccessToken(userRandomEmail, USER_PASSWORD);
//
//    }

    public Response changeUsername(String newName, String accessToken){
        Response response = given()
                .when()
                .contentType(ContentType.JSON)
                .header("Authorization", "Token " + accessToken)
                .body("{\n" +
                        " \"username\": \"" + newName + "\"\n" +
                        "}")
                .patch("users/me/");
        response.then().log().all().statusCode(200);
        return response;
    }

}
