import entities.User;
import io.restassured.http.ContentType;
import org.testng.Assert;
import pageobject.AdminPage;
import org.testng.annotations.*;

import java.util.List;

import static io.restassured.RestAssured.*;

public class AdminPageTest extends AdminPage {

    @Test
    public void getUsersList_15(){
        List<User> users = given()
                .header("Authorization", "Token " + getAdminAccessToken())
                .when()
                .contentType(ContentType.JSON)
                .get("users/")
                .then().log().all()
                .extract().jsonPath().getList(".", User.class);

        Assert.assertTrue(users.size() > 0,
                "Don't get users list");

//        List<User> users2 = users.stream().filter(x -> x.getEmail() == "abc@gmail.com");
    }

}

//        users.forEach(x -> Assert.assertTrue(x.getEmail().contains("@")));
//        Assert.assertTrue(users.stream().allMatch(x -> x.getId() >= 0));
//    List<String> names = users.stream().map(User::getUsername).collect(Collectors.toList());
//    List<String> ids = users.stream().map(x -> x.getId().toString()).collect(Collectors.toList());