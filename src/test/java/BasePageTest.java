
import io.restassured.response.Response;
import pageobject.BasePage;
import org.testng.annotations.*;

import static Config.TestData.*;
import static io.restassured.RestAssured.*;
import static Config.Config.*;
import static Config.Credentials.*;

public class BasePageTest {

    protected BasePage basePage;
    protected String userEmail;
    protected String userPassword = USER_PASSWORD;
    protected String userName = USER_NAME;

    @BeforeTest
    public void beforeAllTests() {
        baseURI = BASE_URI;
        basePage = new BasePage();

    }

    @BeforeMethod
    public void beforeEachTest() {
        userEmail = USER_RANDOM_EMAIL;
    }

    @AfterMethod
    public void deleteUserAfterTest(){
        basePage.deleteUserMe(userEmail, userPassword);
    }







}
