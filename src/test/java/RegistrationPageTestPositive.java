import entities.UserDataToRegistration;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.*;

import static Config.TestData.*;

public class RegistrationPageTestPositive extends BasePageTest {

    @Test (description = "with valid e-mail: lower case")
    public void userRegistration_1(){
        userEmail = USER_EMAIL1;
        UserDataToRegistration userDataToRegistration = new UserDataToRegistration(userEmail, userPassword, userName);
        Response response = basePage.registerUser(userDataToRegistration);
                response.then().log().all().statusCode(201);
        Assert.assertEquals(userEmail.toLowerCase(), response.then().extract().jsonPath().getString("email"),
                "TEST FAILED");
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
        UserDataToRegistration userDataToRegistration = new UserDataToRegistration(userEmail, userPassword, userName);
        Response response = basePage.registerUser(userDataToRegistration);

        response.then().log().all().statusCode(201);
        Assert.assertEquals(userEmail.toLowerCase(), response.then().extract().jsonPath().getString("email"),
                "TEST FAILED");
    }

    @Test (description = "with valid e-mail: starting with number")
    public void userRegistration_3(){
        userEmail = USER_EMAIL3;
        UserDataToRegistration userDataToRegistration = new UserDataToRegistration(userEmail, userPassword, userName);
        Response response = basePage.registerUser(userDataToRegistration);

        response.then().log().all().statusCode(201);
        Assert.assertEquals(userEmail.toLowerCase(), response.then().extract().jsonPath().getString("email"),
                "TEST FAILED");
    }

    @Test (description = "with valid e-mail: with several dots in name part, not in a row")
    public void userRegistration_4(){
        userEmail = USER_EMAIL4;
        UserDataToRegistration userDataToRegistration = new UserDataToRegistration(userEmail, userPassword, userName);
        Response response = basePage.registerUser(userDataToRegistration);

        response.then().log().all().statusCode(201);
        Assert.assertEquals(userEmail.toLowerCase(), response.then().extract().jsonPath().getString("email"),
                "TEST FAILED");
    }

    @Test (description = "with valid e-mail: with several dots in domain part, not in a row")
    public void userRegistration_5(){
        userEmail = USER_EMAIL5;
        UserDataToRegistration userDataToRegistration = new UserDataToRegistration(userEmail, userPassword, userName);
        Response response = basePage.registerUser(userDataToRegistration);

        response.then().log().all().statusCode(201);
        Assert.assertEquals(userEmail.toLowerCase(), response.then().extract().jsonPath().getString("email"),
                "TEST FAILED");
    }

    @Test (description = "with valid e-mail: with \"-\" in name part")
    public void userRegistration_6(){
        userEmail = USER_EMAIL6;
        UserDataToRegistration userDataToRegistration = new UserDataToRegistration(userEmail, userPassword, userName);
        Response response = basePage.registerUser(userDataToRegistration);

        response.then().log().all().statusCode(201);
        Assert.assertEquals(userEmail.toLowerCase(), response.then().extract().jsonPath().getString("email"),
                "TEST FAILED");
    }

    @Test (description = "with invalid e-mail: empty field")
    public void userRegistration_7(){
        userEmail = USER_EMAIL7;
        UserDataToRegistration userDataToRegistration = new UserDataToRegistration(userEmail, userPassword, userName);
        Response response = basePage.registerUser(userDataToRegistration);

        response.then().log().all().statusCode(400);
        Assert.assertTrue(response.then().extract().jsonPath().getString("email").contains(USER_RESPONSE7),
                "TEST FAILED: No expected message");

    }

    @Test (description = "with invalid e-mail: 255 symbols ")
    public void userRegistration_8(){
        userEmail = USER_EMAIL8;
        UserDataToRegistration userDataToRegistration = new UserDataToRegistration(userEmail, userPassword, userName);
        Response response = basePage.registerUser(userDataToRegistration);

        response.then().log().all().statusCode(400);
        Assert.assertTrue(response.then().extract().jsonPath().getString("email").contains(USER_RESPONSE8),
                "TEST FAILED: No expected message");

    }

    @Test (description = "with invalid e-mail: without @")
    public void userRegistration_9(){
        userEmail = USER_EMAIL9;
        UserDataToRegistration userDataToRegistration = new UserDataToRegistration(userEmail, userPassword, userName);
        Response response = basePage.registerUser(userDataToRegistration);

        response.then().log().all().statusCode(400);
        Assert.assertTrue(response.then().extract().jsonPath().getString("email").contains(USER_RESPONSE9),
                "TEST FAILED: No expected message");
    }

    @Test (description = "with invalid e-mail: contains \"..\"")
    public void userRegistration_10(){
        userEmail = USER_EMAIL10;
        UserDataToRegistration userDataToRegistration = new UserDataToRegistration(userEmail, userPassword, userName);
        Response response = basePage.registerUser(userDataToRegistration);

        response.then().log().all().statusCode(400);
        Assert.assertTrue(response.then().extract().jsonPath().getString("email").contains(USER_RESPONSE10),
                "TEST FAILED: No expected message");

    }

    @Test (description = "with invalid e-mail: starts with \".\"")
    public void userRegistration_11(){
        userEmail = USER_EMAIL11;
        UserDataToRegistration userDataToRegistration = new UserDataToRegistration(userEmail, userPassword, userName);
        Response response = basePage.registerUser(userDataToRegistration);

        response.then().log().all().statusCode(400);
        Assert.assertTrue(response.then().extract().jsonPath().getString("email").contains(USER_RESPONSE11),
                "TEST FAILED: No expected message");

    }

    @Test (description = "with invalid e-mail: domain part starts with .")
    public void userRegistration_12(){
        userEmail = USER_EMAIL12;
        UserDataToRegistration userDataToRegistration = new UserDataToRegistration(userEmail, userPassword, userName);
        Response response = basePage.registerUser(userDataToRegistration);

        response.then().log().all().statusCode(400);
        Assert.assertTrue(response.then().extract().jsonPath().getString("email").contains(USER_RESPONSE12),
                "TEST FAILED: No expected message");

    }

    @Test (description = "with valid password: lowerCase letters only >=8 symbols")
    public void userRegistration_16(){
        userPassword = USER_PASSWORD16;
        UserDataToRegistration userDataToRegistration = new UserDataToRegistration(userEmail, userPassword, userName);
        Response response = basePage.registerUser(userDataToRegistration);

        response.then().log().all().statusCode(201);
        Assert.assertEquals(userEmail.toLowerCase(), response.then().extract().jsonPath().getString("email"),
                "TEST FAILED");
    }

    @Test (description = "with valid password: UpperCase letters only >=8 symbols")
    public void userRegistration_17(){
        userPassword = USER_PASSWORD17;
        UserDataToRegistration userDataToRegistration = new UserDataToRegistration(userEmail, userPassword, userName);
        Response response = basePage.registerUser(userDataToRegistration);

        response.then().log().all().statusCode(201);
        Assert.assertEquals(userEmail.toLowerCase(), response.then().extract().jsonPath().getString("email"),
                "TEST FAILED");
    }

    @Test (description = "with valid password: lowerCase and UpperCase letters only >=8 symbols")
    public void userRegistration_18(){
        userPassword = USER_PASSWORD18;
        UserDataToRegistration userDataToRegistration = new UserDataToRegistration(userEmail, userPassword, userName);
        Response response = basePage.registerUser(userDataToRegistration);

        response.then().log().all().statusCode(201);
        Assert.assertEquals(userEmail.toLowerCase(), response.then().extract().jsonPath().getString("email"),
                "TEST FAILED");
    }

    @Test (description = "with valid password: letters and numbers >=8 symbols")
    public void userRegistration_19(){
        userPassword = USER_PASSWORD19;
        UserDataToRegistration userDataToRegistration = new UserDataToRegistration(userEmail, userPassword, userName);
        Response response = basePage.registerUser(userDataToRegistration);

        response.then().log().all().statusCode(201);
        Assert.assertEquals(userEmail.toLowerCase(), response.then().extract().jsonPath().getString("email"),
                "TEST FAILED");
    }

    @Test (description = "with valid password: special symbols >= 8")
    public void userRegistration_20(){
        userPassword = USER_PASSWORD20;
        UserDataToRegistration userDataToRegistration = new UserDataToRegistration(userEmail, userPassword, userName);
        Response response = basePage.registerUser(userDataToRegistration);

        response.then().log().all().statusCode(201);
        Assert.assertEquals(userEmail.toLowerCase(), response.then().extract().jsonPath().getString("email"),
                "TEST FAILED");
    }

    @Test (description = "with invalid password: 7 symbols")
    public void userRegistration_21(){
        userPassword = USER_PASSWORD21;
        UserDataToRegistration userDataToRegistration = new UserDataToRegistration(userEmail, userPassword, userName);
        Response response = basePage.registerUser(userDataToRegistration);

        response.then().log().all().statusCode(400);
        Assert.assertTrue(response.then().extract().jsonPath().getString("password").contains(USER_RESPONSE21),
                "TEST FAILED: No expected message");

    }

    @Test (description = "with invalid password: equal to name + \"1\"")
    public void userRegistration_22(){
        userPassword = USER_PASSWORD22;
        UserDataToRegistration userDataToRegistration = new UserDataToRegistration(userEmail, userPassword, userName);
        Response response = basePage.registerUser(userDataToRegistration);

        response.then().log().all().statusCode(400);
        Assert.assertTrue(response.then().extract().jsonPath().getString("password").contains(USER_RESPONSE22),
                "TEST FAILED: No expected message");

    }

    @Test (description = "with invalid password: equal to email")
    public void userRegistration_23(){
        userPassword = userEmail;
        UserDataToRegistration userDataToRegistration = new UserDataToRegistration(userEmail, userPassword, userName);
        Response response = basePage.registerUser(userDataToRegistration);

        response.then().log().all().statusCode(400);
        Assert.assertTrue(response.then().extract().jsonPath().getString("password").contains(USER_RESPONSE23),
                "TEST FAILED: No expected message");

    }

    @Test (description = "with invalid password: numbers only >= 8 symbols")
    public void userRegistration_24(){
        userPassword = USER_PASSWORD24;
        UserDataToRegistration userDataToRegistration = new UserDataToRegistration(userEmail, userPassword, userName);
        Response response = basePage.registerUser(userDataToRegistration);

        response.then().log().all().statusCode(400);
        Assert.assertTrue(response.then().extract().jsonPath().getString("password").contains(USER_RESPONSE24),
                "TEST FAILED: No expected message");

    }

    @Test (description = "with invalid password: qwerty")
    public void userRegistration_25(){
        userPassword = USER_PASSWORD25;
        UserDataToRegistration userDataToRegistration = new UserDataToRegistration(userEmail, userPassword, userName);
        Response response = basePage.registerUser(userDataToRegistration);

        response.then().log().all().statusCode(400);
        Assert.assertTrue(response.then().extract().jsonPath().getString("password").contains(USER_RESPONSE25),
                "TEST FAILED: No expected message");

    }

    @Test (description = "with valid name: Uppercase and Lowercase letters")
    public void userRegistration_26(){
        userName = USER_NAME26;
        UserDataToRegistration userDataToRegistration = new UserDataToRegistration(userEmail, userPassword, userName);
        Response response = basePage.registerUser(userDataToRegistration);

        response.then().log().all().statusCode(201);
        Assert.assertEquals(userEmail.toLowerCase(), response.then().extract().jsonPath().getString("email"),
                "TEST FAILED");
    }

    @Test (description = "with valid name: Cyrillic letters")
    public void userRegistration_27(){
        userName = USER_NAME27;
        UserDataToRegistration userDataToRegistration = new UserDataToRegistration(userEmail, userPassword, userName);
        Response response = basePage.registerUser(userDataToRegistration);

        response.then().log().all().statusCode(201);
        Assert.assertEquals(userEmail.toLowerCase(), response.then().extract().jsonPath().getString("email"),
                "TEST FAILED");
    }

    @Test (description = "with valid name: Contains numbers")
    public void userRegistration_28(){
        userName = USER_NAME28;
        UserDataToRegistration userDataToRegistration = new UserDataToRegistration(userEmail, userPassword, userName);
        Response response = basePage.registerUser(userDataToRegistration);

        response.then().log().all().statusCode(201);
        Assert.assertEquals(userEmail.toLowerCase(), response.then().extract().jsonPath().getString("email"),
                "TEST FAILED");
    }

    @Test (description = "with valid name: Contains \"@+.-_\"")
    public void userRegistration_29(){
        userName = USER_NAME29;
        UserDataToRegistration userDataToRegistration = new UserDataToRegistration(userEmail, userPassword, userName);
        Response response = basePage.registerUser(userDataToRegistration);

        response.then().log().all().statusCode(201);
        Assert.assertEquals(userEmail.toLowerCase(), response.then().extract().jsonPath().getString("email"),
                "TEST FAILED");
    }

    @Test (description = "with valid name: Equal to email")
    public void userRegistration_30(){
        userName = userEmail;
        UserDataToRegistration userDataToRegistration = new UserDataToRegistration(userEmail, userPassword, userName);
        Response response = basePage.registerUser(userDataToRegistration);

        response.then().log().all().statusCode(201);
        Assert.assertEquals(userEmail.toLowerCase(), response.then().extract().jsonPath().getString("email"),
                "TEST FAILED");
    }

    @Test (description = "with invalid name: empty field")
    public void userRegistration_31(){
        userName = USER_NAME31;
        UserDataToRegistration userDataToRegistration = new UserDataToRegistration(userEmail, userPassword, userName);
        Response response = basePage.registerUser(userDataToRegistration);

        response.then().log().all().statusCode(400);
        Assert.assertTrue(response.then().extract().jsonPath().getString("username").contains(USER_RESPONSE31),
                "TEST FAILED: No expected message");

    }

    @Test (description = "with invalid name: 151 symbol")
    public void userRegistration_32(){
        userName = USER_NAME32;
        UserDataToRegistration userDataToRegistration = new UserDataToRegistration(userEmail, userPassword, userName);
        Response response = basePage.registerUser(userDataToRegistration);

        response.then().log().all().statusCode(400);
        Assert.assertTrue(response.then().extract().jsonPath().getString("username").contains(USER_RESPONSE32),
                "TEST FAILED: No expected message");

    }

    @Test (description = "with invalid name: contains \"*/#\"")
    public void userRegistration_33(){
        userName = USER_NAME33;
        UserDataToRegistration userDataToRegistration = new UserDataToRegistration(userEmail, userPassword, userName);
        Response response = basePage.registerUser(userDataToRegistration);

        response.then().log().all().statusCode(400);
        Assert.assertTrue(response.then().extract().jsonPath().getString("username").contains(USER_RESPONSE33),
                "TEST FAILED: No expected message");

    }



}
