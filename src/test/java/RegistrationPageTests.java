import com.github.javafaker.Faker;
import entities.User;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.*;
import pageobject.BasePage;
import pageobject.RegistrationPage;

import static pageobject.BasePage.USER_TEST_NAME;

public class RegistrationPageTests extends BasePageTest {

    protected BasePage basePage;
    protected User userToTest;
    protected static Faker faker = new Faker();
    protected static String userEmailRandom;
    protected static String userPasswordRandom;

    @BeforeMethod
    public void beforeEachTest() {
        userEmailRandom = faker.bothify("lena######????@mail.ru");
        userPasswordRandom = faker.bothify("###???###???Q_");
        userToTest = new User(userEmailRandom, userPasswordRandom, USER_TEST_NAME);
        basePage = new BasePage();
    }

    @AfterMethod
    public void deleteUserAfterTest(){
        basePage.deleteUserMe(userToTest);
    }

    @Test (dataProvider = "valid emails", dataProviderClass = RegistrationPage.class)
    public void createUserWithValidEmail (String userEmail) {
        userToTest.setEmail(userEmail);
        Response response = basePage.registerUser(userToTest);
        response.then().log().all().statusCode(201);
        Assert.assertEquals(userToTest.getEmail().toLowerCase(), response.then().extract().jsonPath().getString("email"),
                "TEST FAILED");
    }

    @Test (dataProvider = "invalid emails", dataProviderClass = RegistrationPage.class)
    public void createUserWithInvalidEmail (String userEmail, String userResponse) {
        userToTest.setEmail(userEmail);
        Response response = basePage.registerUser(userToTest);
        response.then().log().all().statusCode(400);
        Assert.assertTrue(response.then().extract().jsonPath().getString("email").contains(userResponse),
                "TEST FAILED: No expected message");
    }

    @Test (dataProvider = "valid passwords", dataProviderClass = RegistrationPage.class)
    public void createUserWithValidPassword (String userPassword) {
        userToTest.setPassword(userPassword);
        Response response = basePage.registerUser(userToTest);
        response.then().log().all().statusCode(201);
        Assert.assertEquals(userToTest.getEmail().toLowerCase(), response.then().extract().jsonPath().getString("email"),
                "TEST FAILED");
    }

    @Test (dataProvider = "invalid passwords", dataProviderClass = RegistrationPage.class)
    public void createUserWithInvalidPassword (String userPassword, String userResponse) {
        userToTest.setPassword(userPassword);
        Response response = basePage.registerUser(userToTest);
        response.then().log().all().statusCode(400);
        Assert.assertTrue(response.then().extract().jsonPath().getString("password").contains(userResponse),
                "TEST FAILED: No expected message");
    }

    @Test (description = "with invalid password: equal to email")
    public void userRegistration_23(){
        userToTest.setPassword(userToTest.getEmail());
        Response response = basePage.registerUser(userToTest);

        response.then().log().all().statusCode(400);
        Assert.assertTrue(response.then().extract().jsonPath().getString("password").contains("слишком похож на email"),
                "TEST FAILED: No expected message");
    }

    @Test (dataProvider = "valid names", dataProviderClass = RegistrationPage.class)
    public void createUserWithValidName (String userName) {
        userToTest.setUsername(userName);
        Response response = basePage.registerUser(userToTest);
        response.then().log().all().statusCode(201);
        Assert.assertEquals(userToTest.getEmail().toLowerCase(), response.then().extract().jsonPath().getString("email"),
                "TEST FAILED");
    }

    @Test (description = "with valid name: Equal to email")
    public void userRegistration_30(){
        userToTest.setUsername(userToTest.getEmail());
        Response response = basePage.registerUser(userToTest);

        response.then().log().all().statusCode(201);
        Assert.assertEquals(userToTest.getEmail().toLowerCase(), response.then().extract().jsonPath().getString("email"),
                "TEST FAILED");
    }

    @Test (dataProvider = "invalid names", dataProviderClass = RegistrationPage.class)
    public void createUserWithInvalidName (String userName, String userResponse) {
        userToTest.setUsername(userName);
        Response response = basePage.registerUser(userToTest);
        response.then().log().all().statusCode(400);
        Assert.assertTrue(response.then().extract().jsonPath().getString("username").contains(userResponse),
                "TEST FAILED: No expected message");
    }


}
