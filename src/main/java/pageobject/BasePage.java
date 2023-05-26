package pageobject;

import entities.*;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;

public class BasePage {

    public String getAccessToken(User userToLogin) {

        Response response = given()
                .header("Content-Type", "application/json")
                .body(userToLogin)
                .post("jwt/create/");

        return response.then().extract().response().jsonPath().getString("access");
    }

    public Response deleteUserMe(User userToDelete){

        return given()
                .when()
                .contentType(ContentType.JSON)
                .header("Authorization", "Token " + getAccessToken(userToDelete))
                .body(userToDelete)
                .delete("users/me/");
    }

    public Response registerUser(User userRegistration) {

        Response response = given()
                .header("Content-Type", "application/json")
                .body(userRegistration)
                .post("users/");
        System.out.println("USER DATA TO REGISTRATION: " + userRegistration.getEmail() + " password: " + userRegistration.getPassword() + " NAME: " + userRegistration.getUsername());
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

