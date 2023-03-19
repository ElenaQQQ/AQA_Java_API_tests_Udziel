import entities.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import pageobject.BasePage;
import org.testng.annotations.*;

import java.util.List;
import java.util.stream.Collectors;

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

    @Test
    public void getUsersList(){
        List<User> users = given()
                .header("Authorization", "Token " + getAccessToken())
                .when()
                .contentType(ContentType.JSON)
                .get("users/")
                .then().log().all()
                .extract().jsonPath().getList(".", User.class);
//        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX Users list length = " + users.size());
        Assert.assertTrue(users.size() > 0,
                "Don't get users list");


    }

}

//        users.forEach(x -> Assert.assertTrue(x.getEmail().contains("@")));
//        Assert.assertTrue(users.stream().allMatch(x -> x.getId() >= 0));
//    List<String> names = users.stream().map(User::getUsername).collect(Collectors.toList());
//    List<String> ids = users.stream().map(x -> x.getId().toString()).collect(Collectors.toList());