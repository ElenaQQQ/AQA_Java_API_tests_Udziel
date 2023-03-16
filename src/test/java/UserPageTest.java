import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.UserPage;
import static io.restassured.RestAssured.*;

public class UserPageTest extends BasePageTest {

    @Test
    public void getInfoMe(){
        Response response = given()
                .header("Authorization", "Token " + getAccessToken())
                .when()
                .get("users/me/");

        response.then().log().all().statusCode(200);
        Assert.assertEquals(response.then().extract().jsonPath().getString("username"),
                "Name",
                "Name is not equal");
    }

}
