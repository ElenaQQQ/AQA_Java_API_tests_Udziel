package pageobject;

import entities.UserDataToRegistration;
import entities.UserToDelete;
import io.restassured.http.ContentType;
import org.testng.annotations.*;

import static Config.Config.*;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;


import io.restassured.response.Response;

public class BasePage {
    UserToDelete userToDelete;
    @BeforeTest
    public void precondition() {
        baseURI = BASE_URI;
    }

    public String getAccessToken(String email, String password) {
//        baseURI = BASE_URI;

        String body = "{\n" +
                " \"email\": \"" + email + "\",\n" +
                " \"password\": \"" + password + "\"\n" +
                "}";

        Response response = given()
                .header("Content-Type", "application/json")
                .body(body)
                .post("jwt/create/");

        return response.then().extract().response().jsonPath().getString("access");
    }



        public Response deleteUserMe(String email, String password){
            String body = "{\n" +
                    " \"current_password\": \"" + password + "\"\n" +
                    "}";
        Response response = given()
                .when()
                .contentType(ContentType.JSON)
                .header("Authorization", "Token " + getAccessToken(email, password))
                .body(body)
                .delete("users/me/");
        response.then().log().all().statusCode(204);
            return response;
    }

    public Response registerUser(String email, String password, String username) {
        UserDataToRegistration userRegistration = new UserDataToRegistration(email, password, username);

        Response response = given()
                .header("Content-Type", "application/json")
                .body(userRegistration)
                .post("users/");
//        userToDelete = new UserToDelete(email, password);

        return response;
    }


}

