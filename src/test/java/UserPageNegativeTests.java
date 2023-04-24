import com.github.javafaker.Faker;
import entities.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.*;
import pageobject.BasePage;
import pageobject.UserPage;

import static config.Config.BASE_URI;
import static config.Credentials.USER_NAME;
import static config.TestData.*;
import static io.restassured.RestAssured.baseURI;

public class UserPageNegativeTests extends BasePageTest {

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
        userToTest = new UserDataToRegistration(userEmailRandom, userPasswordRandom, USER_NAME);
        basePage.registerUser(userToTest);
        userToLogin = new UserToLogin(userToTest.getEmail(), userToTest.getPassword());
        accessToken = basePage.getAccessToken(userToLogin);
        userToDelete = new UserToDelete(userToTest.getEmail(), userToTest.getPassword());
    }

    @Test (description = "change name to invalid: empty field")
    public void test_49() {

        Response response1 = userPage.changeUsername(USER_NAME49, accessToken);
        response1.then().log().all().statusCode(400);
        Assert.assertTrue(response1.then().extract().jsonPath().getString("username").contains(USER_RESPONSE49));
    }

    @Test (description = "change name to invalid: 151 symbol")
    public void test_50() {

        Response response1 = userPage.changeUsername(USER_NAME50, accessToken);
        response1.then().log().all().statusCode(400);
        Assert.assertTrue(response1.then().extract().jsonPath().getString("username").contains(USER_RESPONSE50));

    }

    @Test (description = "change name to invalid: contains \"*/#\"")
    public void test_51() {

        Response response1 = userPage.changeUsername(USER_NAME51, accessToken);
        response1.then().log().all().statusCode(400);
        Assert.assertTrue(response1.then().extract().jsonPath().getString("username").contains(USER_RESPONSE51));
    }

    @Test (description = "change password to invalid: 7 symbols")
    public void test_39() {
        Response response1 = userPage.changeUserPassword(USER_PASSWORD39, accessToken);
        response1.then().log().all().statusCode(400);
        Assert.assertTrue(response1.then().extract().jsonPath().getString("new_password").contains(USER_RESPONSE39));
    }

    @Test (description = "change password to invalid: equal to name + \"1\"")
    public void test_40() {
        Response response1 = userPage.changeUserPassword(USER_PASSWORD40, accessToken);
        response1.then().log().all().statusCode(400);
        Assert.assertTrue(response1.then().extract().jsonPath().getString("new_password").contains(USER_RESPONSE40));
    }

    @Test (description = "change password to invalid: equal to email")
    public void test_41() {
        Response response1 = userPage.changeUserPassword(userToTest.getEmail(), accessToken);
        response1.then().log().all().statusCode(400);
        Assert.assertTrue(response1.then().extract().jsonPath().getString("new_password").contains(USER_RESPONSE41));
    }

    @Test (description = "change password to invalid: numbers only >= 8 symbols")
    public void test_42() {
        Response response1 = userPage.changeUserPassword(USER_PASSWORD42, accessToken);
        response1.then().log().all().statusCode(400);
        Assert.assertTrue(response1.then().extract().jsonPath().getString("new_password").contains(USER_RESPONSE42));
    }

    @Test (description = "change password to invalid: \"qwerty\"")
    public void test_43() {
        Response response1 = userPage.changeUserPassword(USER_PASSWORD43, accessToken);
        response1.then().log().all().statusCode(400);
        Assert.assertTrue(response1.then().extract().jsonPath().getString("new_password").contains(USER_RESPONSE43));
    }



}
