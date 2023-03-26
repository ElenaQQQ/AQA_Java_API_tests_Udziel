package pageobject;

import io.restassured.http.ContentType;
import org.testng.annotations.*;
import io.restassured.RestAssured.*;
import static Config.Config.*;
import static Config.Credentials.USER_EMAIL;
import static Config.Credentials.USER_PASSWORD;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;


import io.restassured.response.Response;

public class BasePage {

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

//        response.then().log().all().statusCode(200);

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
//        response.then().log().all().statusCode(204);
            return response;
    }


}

