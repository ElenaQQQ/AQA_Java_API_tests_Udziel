package pageobject;

import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;

import static Config.Config.BASE_URI;
import static Config.Credentials.USER_EMAIL;
import static Config.Credentials.USER_PASSWORD;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class UserPage extends BasePage {
    private String accessToken;

    @BeforeTest
    public void start() {
        baseURI = BASE_URI;

        String body = "{\n" +
                " \"email\": \"" + USER_EMAIL + "\",\n" +
                " \"password\": \"" + USER_PASSWORD + "\"\n" +
                "}";

        Response response = given()
                .header("Content-Type", "application/json")
                .body(body)
                .post("jwt/create/");

        response.then().log().all().statusCode(200);

        setAccessToken(response.then().extract().response().jsonPath().getString("access"));
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken){
        this.accessToken = accessToken;
    }

}
