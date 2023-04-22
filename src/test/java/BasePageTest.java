
import pageobject.BasePage;
import org.testng.annotations.*;

import static Config.TestData.*;
import static io.restassured.RestAssured.*;
import static Config.Config.*;

public class BasePageTest {

    protected BasePage basePage;
    protected String userEmail;
    protected String userPassword;
    protected String userName = USER_TEST_NAME;

    @BeforeTest
    public void beforeAllTests() {
        baseURI = BASE_URI;
        basePage = new BasePage();

    }

    @BeforeMethod
    public void beforeEachTest() {
        userEmail = USER_RANDOM_EMAIL;
        userPassword = USER_RANDOM_PASSWORD;
        userName = USER_TEST_NAME;
    }

    @AfterMethod
    public void deleteUserAfterTest(){
        basePage.deleteUserMe(userEmail, userPassword);
    }







}
