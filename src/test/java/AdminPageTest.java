import io.restassured.response.Response;
import org.testng.Assert;
import pageobject.BasePage;
import org.testng.annotations.*;
import static io.restassured.RestAssured.*;
import static Config.Config.*;
import static Config.Credentials.*;

public class AdminPageTest extends BasePage {

    private String accessToken;

    @BeforeTest
    public void start() {
        baseURI = BASE_URI;

        String body = "{\n" +
                " \"email\": \"" + ADMIN_EMAIL + "\",\n" +
                " \"password\": \"" + ADMIN_PASSWORD + "\"\n" +
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
