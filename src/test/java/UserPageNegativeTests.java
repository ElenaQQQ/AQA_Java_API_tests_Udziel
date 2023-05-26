import com.github.javafaker.Faker;
import entities.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.*;
import pageobject.BasePage;
import pageobject.UserPage;

import static config.Config.BASE_URI;
import static io.restassured.RestAssured.baseURI;
import static pageobject.BasePage.USER_TEST_NAME;

public class UserPageNegativeTests extends BasePageTest {

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

    @Test (dataProvider = "invalid passwords", dataProviderClass = UserPage.class)
    public void changeUserPasswordToInvalidUnavailable(String userPassword, String userResponce) {
        userToTest.setNew_password(userPassword);
        Response response1 = userPage.changeUserPassword(userToTest, accessToken);
        response1.then().log().all().statusCode(400);
        Assert.assertTrue(response1.then().extract().jsonPath().getString("new_password").contains(userResponce));
    }

    @Test (description = "change password to invalid: equal to email")
    public void test_41() {
        userToTest.setNew_password(userToTest.getEmail());
        Response response1 = userPage.changeUserPassword(userToTest, accessToken);
        response1.then().log().all().statusCode(400);
        Assert.assertTrue(response1.then().extract().jsonPath().getString("new_password").contains("слишком похож на email"));
    }

    @Test (dataProvider = "invalid names", dataProviderClass = UserPage.class)
    public void changeNameToInvalidUnavailable (String userName, String userResponse) {
        Response response = userPage.changeUsername(userName, accessToken);
        response.then().log().all().statusCode(400);
        Assert.assertTrue(response.then().extract().jsonPath().getString("username").contains(userResponse));
    }

    @Test (description = "change: valid email + invalid name")
    public void changeUserDataWithInvalidName() {
        userToTest.setEmail("new_" + userToTest.getEmail());
        userToTest.setUsername(faker.bothify("####*"));
        Response response = userPage.changeUserEmailAndName(userToTest, accessToken);
        response.then().log().all().statusCode(400);
        Assert.assertTrue(response.then().extract().jsonPath().getString("username").contains("правильное имя пользователя"));
    }


}
