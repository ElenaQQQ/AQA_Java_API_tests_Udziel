import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.UserPage;

import static Config.Credentials.*;
import static io.restassured.RestAssured.*;

public class UserPageTest extends UserPage {

    @Test
    public void getInfoMe(){
        Response response = given()
                .header("Authorization", "Token " + getAccessToken(USER_EMAIL, USER_PASSWORD))
                .when()
                .get("users/me/");

        response.then().log().all().statusCode(200);
        Assert.assertEquals(response.then().extract().jsonPath().getString("username"),
                "Name",
                "Name is not equal");
    }

    @Test
    public void deleteUserMe(){
        Response response = deleteUserMe("lena26031811@mail.ru", USER_PASSWORD);
        Assert.assertEquals(response.then().extract().statusCode(),204);
    }

}
