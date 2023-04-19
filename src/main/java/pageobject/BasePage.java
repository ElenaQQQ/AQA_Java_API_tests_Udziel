package pageobject;

//import entities.UserDataToRegistration;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import entities.*;
//import entities.UserToDelete;
//import entities.UserToLogin;
import io.restassured.http.ContentType;
import org.testng.annotations.*;

import static Config.Config.*;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import io.restassured.response.Response;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BasePage {
//    UserToDelete userToDelete;
    @BeforeTest
    public void precondition() {
        baseURI = BASE_URI;
    }

    public String getAccessToken(String email, String password) {

        UserToLogin userToLogin = new UserToLogin(email, password);

        Response response = given()
                .header("Content-Type", "application/json")
                .body(userToLogin)
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

    public Response registerUser(UserDataToRegistration userRegistration) {

        Response response = given()
                .header("Content-Type", "application/json")
                .body(userRegistration)
                .post("users/");
//        userToDelete = new UserToDelete(userRegistration.getEmail(), userRegistration.getPassword());

        return response;
    }


//    public JsonObject parseJSON(String fileName){
//        JsonObject jsonObject = new JsonParser().parse(getJson(fileName)).getAsJsonObject();
//        return jsonObject;
//    }
//
//    public String getJson(String fileName){
//        try {
//            return new String(Files.readAllBytes(Paths.get("src/main/java/resourses/" + fileName + ".json")));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
}

