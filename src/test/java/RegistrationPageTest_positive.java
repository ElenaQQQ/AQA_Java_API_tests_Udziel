import com.google.gson.JsonParser;
import entities.UserDataToRegistration;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.*;
import pageobject.BasePage;
import pageobject.BasePage_positive;

import java.io.File;
import java.io.IOException;

import com.google.gson.JsonObject;
import io.restassured.http.ContentType;

import static Config.TestData.*;

public class RegistrationPageTest_positive extends BasePage_positive {
    public String userEmail;
    public String userPassword;
    public String userName;

    /*@AfterMethod
    public void postcondition(){
        deleteUserMe(userEmail, USER_TEST_PASSWORD);
//        deleteUserMe(userToDelete);
        System.out.println("QQQQQQQQQQQQQQQQQQQQQ POSTCONDITION REALIZED");
    }
*/
    @Test (description = "with valid e-mail: lower case")
    public void userRegistration_1(){
        userEmail = USER_EMAIL1;
        UserDataToRegistration userDataToRegistration = new UserDataToRegistration(userEmail, USER_TEST_PASSWORD, USER_TEST_NAME);
        Response response = registerUser(userDataToRegistration);
                response.then().log().all().statusCode(201);
        Assert.assertEquals(userEmail.toLowerCase(), response.then().extract().jsonPath().getString("email"),
                "TEST FAILED");
        deleteUserMe(USER_EMAIL1,USER_TEST_PASSWORD);
    }

   /* @Test
    public void userRegistration_1_1() throws IOException {
//        userEmail = parseJSON("RegistrationPageTest_positive").getAsString(); //.getAsJsonObject("1").toString();
        File file = new File("src/main/java/resourses/RegistrationPageTest_positive.json");
        Object obj = new JsonParser()
//        UserDataToRegistration userDataToRegistration = objectMapper.readValue(file, UserDataToRegistration.class);
        System.out.println("WWWWWWWWWWWWWWWWWWWWWWWWWWW user Email = " + userEmail);
//        Response response = registerUser(userEmail, USER_TEST_PASSWORD, USER_TEST_NAME);
//        response.then().log().all().statusCode(201);
//        Assert.assertEquals(userEmail.toLowerCase(), response.then().extract().jsonPath().getString("email"),
//                "TEST FAILED");
    }*/

    @Test (description = "with valid e-mail: lower case and upper case")
    public void userRegistration_2(){
        userEmail = USER_EMAIL2;
        UserDataToRegistration userDataToRegistration = new UserDataToRegistration(userEmail, USER_TEST_PASSWORD, USER_TEST_NAME);
        Response response = registerUser(userDataToRegistration);

        response.then().log().all().statusCode(201);
        Assert.assertEquals(userEmail.toLowerCase(), response.then().extract().jsonPath().getString("email"),
                "TEST FAILED");
        deleteUserMe(userEmail.toLowerCase(), USER_TEST_PASSWORD);
    }

    @Test (description = "with valid e-mail: starting with number")
    public void userRegistration_3(){
        userEmail = USER_EMAIL3;
        UserDataToRegistration userDataToRegistration = new UserDataToRegistration(userEmail, USER_TEST_PASSWORD, USER_TEST_NAME);
        Response response = registerUser(userDataToRegistration);

        response.then().log().all().statusCode(201);
        Assert.assertEquals(userEmail.toLowerCase(), response.then().extract().jsonPath().getString("email"),
                "TEST FAILED");
        deleteUserMe(userEmail.toLowerCase(),USER_TEST_PASSWORD);
    }

    @Test (description = "with valid e-mail: with several dots in name part, not in a row")
    public void userRegistration_4(){
        userEmail = USER_EMAIL4;
        UserDataToRegistration userDataToRegistration = new UserDataToRegistration(userEmail, USER_TEST_PASSWORD, USER_TEST_NAME);
        Response response = registerUser(userDataToRegistration);

        response.then().log().all().statusCode(201);
        Assert.assertEquals(userEmail.toLowerCase(), response.then().extract().jsonPath().getString("email"),
                "TEST FAILED");
        deleteUserMe(userEmail,USER_TEST_PASSWORD);
    }

    @Test (description = "with valid e-mail: with several dots in domain part, not in a row")
    public void userRegistration_5(){
        userEmail = USER_EMAIL5;
        UserDataToRegistration userDataToRegistration = new UserDataToRegistration(userEmail, USER_TEST_PASSWORD, USER_TEST_NAME);
        Response response = registerUser(userDataToRegistration);

        response.then().log().all().statusCode(201);
        Assert.assertEquals(userEmail.toLowerCase(), response.then().extract().jsonPath().getString("email"),
                "TEST FAILED");
        deleteUserMe(userEmail,USER_TEST_PASSWORD);
    }

    @Test (description = "with valid e-mail: with \"-\" in name part")
    public void userRegistration_6(){
        userEmail = USER_EMAIL6;
        UserDataToRegistration userDataToRegistration = new UserDataToRegistration(userEmail, USER_TEST_PASSWORD, USER_TEST_NAME);
        Response response = registerUser(userDataToRegistration);

        response.then().log().all().statusCode(201);
        Assert.assertEquals(userEmail.toLowerCase(), response.then().extract().jsonPath().getString("email"),
                "TEST FAILED");
        deleteUserMe(userEmail,USER_TEST_PASSWORD);
    }

    @Test (description = "with valid password: lowerCase letters only >=8 symbols")
    public void userRegistration_16(){
        userPassword = USER_PASSWORD16;
        UserDataToRegistration userDataToRegistration = new UserDataToRegistration(USER_EMAIL1, userPassword, USER_TEST_NAME);
        Response response = registerUser(userDataToRegistration);

        response.then().log().all().statusCode(201);
        Assert.assertEquals(USER_EMAIL1.toLowerCase(), response.then().extract().jsonPath().getString("email"),
                "TEST FAILED");
        deleteUserMe(USER_EMAIL1,userPassword);
    }

    @Test (description = "with valid password: UpperCase letters only >=8 symbols")
    public void userRegistration_17(){
        userPassword = USER_PASSWORD17;
        UserDataToRegistration userDataToRegistration = new UserDataToRegistration(USER_EMAIL1, userPassword, USER_TEST_NAME);
        Response response = registerUser(userDataToRegistration);

        response.then().log().all().statusCode(201);
        Assert.assertEquals(USER_EMAIL1.toLowerCase(), response.then().extract().jsonPath().getString("email"),
                "TEST FAILED");
        deleteUserMe(USER_EMAIL1,userPassword);
    }

    @Test (description = "with valid password: lowerCase and UpperCase letters only >=8 symbols")
    public void userRegistration_18(){
        userPassword = USER_PASSWORD18;
        UserDataToRegistration userDataToRegistration = new UserDataToRegistration(USER_EMAIL1, userPassword, USER_TEST_NAME);
        Response response = registerUser(userDataToRegistration);

        response.then().log().all().statusCode(201);
        Assert.assertEquals(USER_EMAIL1.toLowerCase(), response.then().extract().jsonPath().getString("email"),
                "TEST FAILED");
        deleteUserMe(USER_EMAIL1,userPassword);
    }

    @Test (description = "with valid password: letters and numbers >=8 symbols")
    public void userRegistration_19(){
        userPassword = USER_PASSWORD19;
        UserDataToRegistration userDataToRegistration = new UserDataToRegistration(USER_EMAIL1, userPassword, USER_TEST_NAME);
        Response response = registerUser(userDataToRegistration);

        response.then().log().all().statusCode(201);
        Assert.assertEquals(USER_EMAIL1.toLowerCase(), response.then().extract().jsonPath().getString("email"),
                "TEST FAILED");
        deleteUserMe(USER_EMAIL1,userPassword);
    }

    @Test (description = "with valid password: special symbols >= 8")
    public void userRegistration_20(){
        userPassword = USER_PASSWORD20;
        UserDataToRegistration userDataToRegistration = new UserDataToRegistration(USER_EMAIL1, userPassword, USER_TEST_NAME);
        Response response = registerUser(userDataToRegistration);

        response.then().log().all().statusCode(201);
        Assert.assertEquals(USER_EMAIL1.toLowerCase(), response.then().extract().jsonPath().getString("email"),
                "TEST FAILED");
        deleteUserMe(USER_EMAIL1,userPassword);
    }

    @Test (description = "with valid name: Uppercase and Lowercase letters")
    public void userRegistration_26(){
        userName = USER_NAME26;
        UserDataToRegistration userDataToRegistration = new UserDataToRegistration(USER_EMAIL1, USER_TEST_PASSWORD, userName);
        Response response = registerUser(userDataToRegistration);

        response.then().log().all().statusCode(201);
        Assert.assertEquals(USER_EMAIL1.toLowerCase(), response.then().extract().jsonPath().getString("email"),
                "TEST FAILED");
        deleteUserMe(USER_EMAIL1,USER_TEST_PASSWORD);
    }

    @Test (description = "with valid name: Cyrillic letters")
    public void userRegistration_27(){
        userName = USER_NAME27;
        UserDataToRegistration userDataToRegistration = new UserDataToRegistration(USER_EMAIL1, USER_TEST_PASSWORD, userName);
        Response response = registerUser(userDataToRegistration);

        response.then().log().all().statusCode(201);
        Assert.assertEquals(USER_EMAIL1.toLowerCase(), response.then().extract().jsonPath().getString("email"),
                "TEST FAILED");
        deleteUserMe(USER_EMAIL1,USER_TEST_PASSWORD);
    }

    @Test (description = "with valid name: Contains numbers")
    public void userRegistration_28(){
        userName = USER_NAME28;
        UserDataToRegistration userDataToRegistration = new UserDataToRegistration(USER_EMAIL1, USER_TEST_PASSWORD, userName);
        Response response = registerUser(userDataToRegistration);

        response.then().log().all().statusCode(201);
        Assert.assertEquals(USER_EMAIL1.toLowerCase(), response.then().extract().jsonPath().getString("email"),
                "TEST FAILED");
        deleteUserMe(USER_EMAIL1,USER_TEST_PASSWORD);
    }

    @Test (description = "with valid name: Contains \"@+.-_\"")
    public void userRegistration_29(){
        userName = USER_NAME29;
        UserDataToRegistration userDataToRegistration = new UserDataToRegistration(USER_EMAIL1, USER_TEST_PASSWORD, userName);
        Response response = registerUser(userDataToRegistration);

        response.then().log().all().statusCode(201);
        Assert.assertEquals(USER_EMAIL1.toLowerCase(), response.then().extract().jsonPath().getString("email"),
                "TEST FAILED");
        deleteUserMe(USER_EMAIL1,USER_TEST_PASSWORD);
    }

    @Test (description = "with valid name: Equal to email")
    public void userRegistration_30(){
        userName = USER_NAME30;
        UserDataToRegistration userDataToRegistration = new UserDataToRegistration(USER_EMAIL1, USER_TEST_PASSWORD, userName);
        Response response = registerUser(userDataToRegistration);

        response.then().log().all().statusCode(201);
        Assert.assertEquals(USER_EMAIL1.toLowerCase(), response.then().extract().jsonPath().getString("email"),
                "TEST FAILED");
        deleteUserMe(USER_EMAIL1,USER_TEST_PASSWORD);
    }


}
