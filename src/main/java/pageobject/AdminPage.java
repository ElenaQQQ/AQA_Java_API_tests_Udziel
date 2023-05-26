package pageobject;

import entities.User;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;

import static config.Config.BASE_URI;
import static config.Credentials.*;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;

public class AdminPage extends BasePage {

    protected String accessToken;

    @BeforeTest
    public void start() {
        baseURI = BASE_URI;

        User admin = new User(ADMIN_EMAIL, ADMIN_PASSWORD);

        Response response = given()
                .header("Content-Type", "application/json")
                .body(admin)
                .post("jwt/create/");

        setAdminAccessToken(response.then().extract().response().jsonPath().getString("access"));
    }

    public String getAdminAccessToken() {
        return accessToken;
    }

    public void setAdminAccessToken(String accessToken){
        this.accessToken = accessToken;
    }
}
