import com.github.javafaker.Faker;
import entities.UserDataToRegistration;
import entities.UserToDelete;
import entities.UserToLogin;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.*;
import pageobject.BasePage;
import pageobject.UserPage;

import static Config.Config.BASE_URI;
import static Config.TestData.*;
import static io.restassured.RestAssured.*;

public class UserPagePositiveTests extends BasePageTest {

    protected UserDataToRegistration userToTest;
    protected UserToLogin userToLogin;
    protected UserToDelete userToDelete;
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
        userToTest = new UserDataToRegistration(userEmailRandom, userPasswordRandom, USER_TEST_NAME);
        basePage.registerUser(userToTest);
        userToLogin = new UserToLogin(userToTest.getEmail(), userToTest.getPassword());
        accessToken = basePage.getAccessToken(userToLogin);
        userToDelete = new UserToDelete(userToTest.getEmail(), userToTest.getPassword());
    }

    @AfterMethod
    public void deleteUserAfterTest() {
        basePage.deleteUserMe(userToDelete);
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
        Response response = basePage.deleteUserMe(userToDelete);
        Assert.assertEquals(response.then().extract().statusCode(),204);
    }

    @Test (description = "change name to valid: Uppercase and Lowercase letters")
    public void test_44() {
        Response response1 = userPage.changeUsername(USER_NAME44, accessToken);
        response1.then().log().all().statusCode(200);
        Assert.assertEquals(USER_NAME44, response1.then().extract().jsonPath().getString("username"));
    }

    @Test (description = "change name to valid: Cyrillic letters")
    public void test_45() {
        Response response1 = userPage.changeUsername(USER_NAME45, accessToken);
        response1.then().log().all().statusCode(200);
        Assert.assertEquals(USER_NAME45, response1.then().extract().jsonPath().getString("username"));
    }

    @Test (description = "change name to valid: Contains numbers")
    public void test_46() {
        Response response1 = userPage.changeUsername(USER_NAME46, accessToken);
        response1.then().log().all().statusCode(200);
        Assert.assertEquals(USER_NAME46, response1.then().extract().jsonPath().getString("username"));
    }

    @Test (description = "change name to valid: Contains \"@+.-_\"")
    public void test_47() {
        Response response1 = userPage.changeUsername(USER_NAME47, accessToken);
        response1.then().log().all().statusCode(200);
        Assert.assertEquals(USER_NAME47, response1.then().extract().jsonPath().getString("username"));
    }

    @Test (description = "change name to valid: Equal to email")
    public void test_48() {
        Response response1 = userPage.changeUsername(userToTest.getEmail(), accessToken);
        response1.then().log().all().statusCode(200);
        Assert.assertEquals(userToTest.getEmail(), response1.then().extract().jsonPath().getString("username"));
    }

    @Test (description = "change password to valid: lowerCase letters only >=8 symbols")
    public void test_34() {
        Response response1 = userPage.changeUserPassword(USER_PASSWORD34, accessToken);
        response1.then().log().all().statusCode(204);
        userToLogin.setPassword(USER_PASSWORD34);
        userToDelete.setPassword(USER_PASSWORD34);
        Assert.assertTrue(basePage.getAccessToken(userToLogin).length() > 10);
    }

    @Test (description = "change password to valid: UpperCase letters only >=8 symbols")
    public void test_35() {
        Response response1 = userPage.changeUserPassword(USER_PASSWORD35, accessToken);
        response1.then().log().all().statusCode(204);
        userToLogin.setPassword(USER_PASSWORD35);
        userToDelete.setPassword(USER_PASSWORD35);
        Assert.assertTrue(basePage.getAccessToken(userToLogin).length() > 10);
    }

    @Test (description = "change password to valid: lowerCase and UpperCase letters only >=8 symbols")
    public void test_36() {
        Response response1 = userPage.changeUserPassword(USER_PASSWORD36, accessToken);
        response1.then().log().all().statusCode(204);
        userToLogin.setPassword(USER_PASSWORD36);
        userToDelete.setPassword(USER_PASSWORD36);
        Assert.assertTrue(basePage.getAccessToken(userToLogin).length() > 10);
    }

    @Test (description = "change password to valid: letters and numbers >=8 symbols")
    public void test_37() {
        Response response1 = userPage.changeUserPassword(USER_PASSWORD37, accessToken);
        response1.then().log().all().statusCode(204);
        userToLogin.setPassword(USER_PASSWORD37);
        userToDelete.setPassword(USER_PASSWORD37);
        Assert.assertTrue(basePage.getAccessToken(userToLogin).length() > 10);
    }

    @Test (description = "change password to valid: special symbols >= 8: ~ ! ? @ # $ % ^ & * _ - + ( ) [ ] { } > < / \\ | \" ' . , : ;")
    public void test_38() {
        Response response1 = userPage.changeUserPassword(USER_PASSWORD38, accessToken);
        response1.then().log().all().statusCode(204);
        userToLogin.setPassword(USER_PASSWORD38);
        userToDelete.setPassword(USER_PASSWORD38);
        Assert.assertTrue(basePage.getAccessToken(userToLogin).length() > 10);
    }

}
