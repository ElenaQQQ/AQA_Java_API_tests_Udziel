
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobject.BasePage;
import org.testng.annotations.*;
import static io.restassured.RestAssured.baseURI;

import static Config.Config.*;
import static Config.Credentials.*;
import static io.restassured.RestAssured.given;

public class BasePageTest extends BasePage {

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



//    @AfterTest
//    public void finish() {
//
//    }
//
//    @Test (description = "", groups = "")
//    public void test1 (){
//
//    };

}