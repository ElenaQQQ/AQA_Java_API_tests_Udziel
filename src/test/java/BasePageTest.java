
import com.github.javafaker.Faker;
import entities.UserDataToRegistration;
import entities.UserToDelete;
import pageobject.BasePage;
import org.testng.annotations.*;

import static Config.TestData.*;
import static io.restassured.RestAssured.*;
import static Config.Config.*;

public class BasePageTest {

    protected BasePage basePage;
    protected UserDataToRegistration userToTest;
    protected UserToDelete userToDelete;
    protected static Faker faker = new Faker();
    protected static String userEmailRandom;
    protected static String userPasswordRandom;

    @BeforeTest
    public void beforeAllTests() {
        baseURI = BASE_URI;
        basePage = new BasePage();
    }

    @BeforeMethod
    public void beforeEachTest() {
        userEmailRandom = faker.bothify("lena######????@mail.ru");
        userPasswordRandom = faker.bothify("###???###???Q_");
        userToTest = new UserDataToRegistration(userEmailRandom, userPasswordRandom, USER_TEST_NAME);
        userToDelete = new UserToDelete(userToTest.getEmail(), userToTest.getPassword());
    }

    @AfterMethod
    public void deleteUserAfterTest(){
        basePage.deleteUserMe(userToDelete);
    }







}
