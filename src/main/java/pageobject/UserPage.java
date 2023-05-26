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

    public Response changeUsernameAndName(String userEmail, String userName, String accessToken){
        return given()
                .when()
                .contentType(ContentType.JSON)
                .header("Authorization", "Token " + accessToken)
                .body("{\n" +
                        " \"email\": \"" + userEmail + "\",\n" +
                        " \"username\": \"" + userName + "\",\n" +
                        " \"donor\": \"" + "[]" + "\"\n" +
                        "}")
                .put("users/me/");
    }

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
