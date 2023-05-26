import com.github.javafaker.Faker;
import entities.User;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.*;
import pageobject.BasePage;
import pageobject.UserPage;

import static config.Config.BASE_URI;
import static io.restassured.RestAssured.*;
import static pageobject.BasePage.USER_TEST_NAME;

public class UserPagePositiveTests extends BasePageTest {

    protected User userToTest;
    protected String accessToken;
    protected static Faker faker = new Faker();
    protected static String userEmailRandom;
    protected static String userPasswordRandom;
    protected  UserPage userPage;
    protected BasePage basePage;

    @BeforeTest
    public void beforeAllTests() {
        baseURI = BASE_URI;
        basePage = new BasePage();
        userPage = new UserPage();
    }

    @BeforeMethod
    public void beforeEachTest(){
        userEmailRandom = faker.bothify("lena######????@mail.ru");
        userPasswordRandom = faker.bothify("###???###???Q_");
        userToTest = new User(userEmailRandom, userPasswordRandom, USER_TEST_NAME);
        basePage.registerUser(userToTest);
        accessToken = basePage.getAccessToken(userToTest);
    }

    @AfterMethod
    public void deleteUserAfterTest() {
        basePage.deleteUserMe(userToTest);
    }

    @Test
    public void getInfoMe_13(){
        Response response = given()
                .header("Authorization", "Token " + accessToken)
                .when()
                .get("users/me/");

        response.then().log().all().statusCode(200);
        Assert.assertEquals(response.then().extract().jsonPath().getString("username"),
                "Name",
                "Name is not equal");
    }

    @Test
    public void deleteUserMe_14(){
        Response response = basePage.deleteUserMe(userToTest);
        Assert.assertEquals(response.then().extract().statusCode(),204);
    }

    @Test (dataProvider = "valid passwords", dataProviderClass = UserPage.class)
    public void changePasswordToValidAvailable(String userPassword) {
        Response response1 = userPage.changeUserPassword(userPassword, accessToken);
        response1.then().log().all().statusCode(204);
        userToTest.setPassword(userPassword);
        userToTest.setCurrent_password(userPassword);
        Assert.assertTrue(basePage.getAccessToken(userToTest).length() > 10);
    }

    @Test (dataProvider = "valid names", dataProviderClass = UserPage.class)
    public void changeNameToValidAvailable(String userName) {
        Response response = userPage.changeUsername(userName, accessToken);
        response.then().log().all().statusCode(200);
        Assert.assertEquals(userName, response.then().extract().jsonPath().getString("username"));
    }

    @Test (description = "change name to valid: Equal to email")
    public void test_48() {
        Response response1 = userPage.changeUsername(userToTest.getEmail(), accessToken);
        response1.then().log().all().statusCode(200);
        Assert.assertEquals(userToTest.getEmail(), response1.then().extract().jsonPath().getString("username"));
    }
}
