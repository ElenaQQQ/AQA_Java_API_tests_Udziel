import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.*;
import pageobject.BasePage;
import pageobject.BasePage_positive;

import static Config.TestData.*;

public class RegistrationPageTest_positive extends BasePage_positive {

    @Test (description = "with valid e-mail: lower case")
    public void userRegistration_1(){
        Response response = registerUser(USER_EMAIL1, USER_TEST_PASSWORD, USER_TEST_NAME);
                response.then().log().all().statusCode(201);
        Assert.assertEquals(USER_EMAIL1.toLowerCase(), response.then().extract().jsonPath().getString("email"),
                "TEST FAILED");
        deleteUserMe(USER_EMAIL1,USER_TEST_PASSWORD);
    }

    @Test (description = "with valid e-mail: lower case and upper case")
    public void userRegistration_2(){

        Response response = registerUser(USER_EMAIL2, USER_TEST_PASSWORD, USER_TEST_NAME);

        response.then().log().all().statusCode(201);
        Assert.assertEquals(USER_EMAIL2.toLowerCase(), response.then().extract().jsonPath().getString("email"),
                "TEST FAILED");
        deleteUserMe(USER_EMAIL2,USER_TEST_PASSWORD);
    }

    @Test (description = "with valid e-mail: starting with number")
    public void userRegistration_3(){

        Response response = registerUser(USER_EMAIL3, USER_TEST_PASSWORD, USER_TEST_NAME);

        response.then().log().all().statusCode(201);
        Assert.assertEquals(USER_EMAIL3.toLowerCase(), response.then().extract().jsonPath().getString("email"),
                "TEST FAILED");
        deleteUserMe(USER_EMAIL3,USER_TEST_PASSWORD);
    }

    @Test (description = "with valid e-mail: with several dots in name part, not in a row")
    public void userRegistration_4(){

        Response response = registerUser(USER_EMAIL4, USER_TEST_PASSWORD, USER_TEST_NAME);

        response.then().log().all().statusCode(201);
        Assert.assertEquals(USER_EMAIL4.toLowerCase(), response.then().extract().jsonPath().getString("email"),
                "TEST FAILED");
        deleteUserMe(USER_EMAIL4,USER_TEST_PASSWORD);
    }

    @Test (description = "with valid e-mail: with several dots in domain part, not in a row")
    public void userRegistration_5(){

        Response response = registerUser(USER_EMAIL5, USER_TEST_PASSWORD, USER_TEST_NAME);

        response.then().log().all().statusCode(201);
        Assert.assertEquals(USER_EMAIL5.toLowerCase(), response.then().extract().jsonPath().getString("email"),
                "TEST FAILED");
        deleteUserMe(USER_EMAIL5,USER_TEST_PASSWORD);
    }

    @Test (description = "with valid e-mail: with \"-\" in name part")
    public void userRegistration_6(){

        Response response = registerUser(USER_EMAIL6, USER_TEST_PASSWORD, USER_TEST_NAME);

        response.then().log().all().statusCode(201);
        Assert.assertEquals(USER_EMAIL6.toLowerCase(), response.then().extract().jsonPath().getString("email"),
                "TEST FAILED");
        deleteUserMe(USER_EMAIL6,USER_TEST_PASSWORD);
    }



}
