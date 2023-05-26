package pageobject;


import entities.User;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class UserPage extends BasePage {

    public Response changeUsername(String newName, String accessToken){
        return given()
                .header("Content-Type", "application/json")
                .when()
                .header("Authorization", "Token " + accessToken)
                .body("{\n" +
                        " \"username\": \"" + newName + "\"\n" +
                        "}")
                .patch("users/me/");
    }

    public Response changeUserEmailAndName(User userToTest, String accessToken){
        return given()
                .header("Content-Type", "application/json")
                .when()
                .header("Authorization", "Token " + accessToken)
                .body(userToTest)
                .put("users/me/");
    }

    public Response changeUserPassword(User userToTest, String accessToken){
        return given()
                .header("Content-Type", "application/json")
                .when()
                .header("Authorization", "Token " + accessToken)
                .body(userToTest)
                .post("users/set_password/");
    }

}
