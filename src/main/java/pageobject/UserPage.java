package pageobject;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserPage extends BasePage {

    public Response changeUsername(String newName, String accessToken){
        return given()
                .when()
                .contentType(ContentType.JSON)
                .header("Authorization", "Token " + accessToken)
                .body("{\n" +
                        " \"username\": \"" + newName + "\"\n" +
                        "}")
                .patch("users/me/");
    }

//    public Response changeUserData(UserDataToRegistration userToTestNew){
//        return given()
//                .when()
//                .contentType(ContentType.JSON)
//                .header("Authorization", "Token " + getAccessToken(userToLogin))
//                .body("{\n" +
//                        " \"email\": \"" + userToTestNew.getEmail() + "\"\n" +
//                        " \"username\": \"" + userToTestNew.getUsername() + "\"\n" +
//                        " \"password\": \"" + userToTestNew.getPassword() + "\"\n" +
//                        "}")
//                .put("users/me/");
//    }

    public Response changeUserPassword(String newPassword, String accessToken){
        return given()
                .when()
                .contentType(ContentType.JSON)
                .header("Authorization", "Token " + accessToken)
                .body("{\n" +
                        " \"new_password\": \"" + newPassword + "\"\n" +
                        "}")
                .post("users/set_password/");
    }

}
