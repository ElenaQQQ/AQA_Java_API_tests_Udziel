import com.github.javafaker.Faker;
import entities.User;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.*;
import pageobject.BasePage;

import static config.TestData.*;

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

    @Test (description = "with valid e-mail: lower case")
    public void userRegistration_1(){
        userToTest.setEmail(USER_EMAIL1);
        Response response = basePage.registerUser(userToTest);
                response.then().log().all().statusCode(201);
        Assert.assertEquals(userToTest.getEmail().toLowerCase(), response.then().extract().jsonPath().getString("email"),
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
        userToTest.setEmail(USER_EMAIL2);
        Response response = basePage.registerUser(userToTest);

        response.then().log().all().statusCode(201);
        Assert.assertEquals(userToTest.getEmail().toLowerCase(), response.then().extract().jsonPath().getString("email"),
                "TEST FAILED");
    }

    @Test (description = "with valid e-mail: starting with number")
    public void userRegistration_3(){
        userToTest.setEmail(USER_EMAIL3);
        Response response = basePage.registerUser(userToTest);

        response.then().log().all().statusCode(201);
        Assert.assertEquals(userToTest.getEmail().toLowerCase(), response.then().extract().jsonPath().getString("email"),
                "TEST FAILED");
    }

    @Test (description = "with valid e-mail: with several dots in name part, not in a row")
    public void userRegistration_4(){
        userToTest.setEmail(USER_EMAIL4);
        Response response = basePage.registerUser(userToTest);

        response.then().log().all().statusCode(201);
        Assert.assertEquals(userToTest.getEmail().toLowerCase(), response.then().extract().jsonPath().getString("email"),
                "TEST FAILED");
    }

    @Test (description = "with valid e-mail: with several dots in domain part, not in a row")
    public void userRegistration_5(){
        userToTest.setEmail(USER_EMAIL5);
        Response response = basePage.registerUser(userToTest);

        response.then().log().all().statusCode(201);
        Assert.assertEquals(userToTest.getEmail().toLowerCase(), response.then().extract().jsonPath().getString("email"),
                "TEST FAILED");
    }

    @Test (description = "with valid e-mail: with \"-\" in name part")
    public void userRegistration_6(){
        userToTest.setEmail(USER_EMAIL6);
        Response response = basePage.registerUser(userToTest);

        response.then().log().all().statusCode(201);
        Assert.assertEquals(userToTest.getEmail().toLowerCase(), response.then().extract().jsonPath().getString("email"),
                "TEST FAILED");
    }

    @Test (description = "with invalid e-mail: empty field")
    public void userRegistration_7(){
        userToTest.setEmail(USER_EMAIL7);
        Response response = basePage.registerUser(userToTest);

        response.then().log().all().statusCode(400);
        Assert.assertTrue(response.then().extract().jsonPath().getString("email").contains(USER_RESPONSE7),
                "TEST FAILED: No expected message");
    }

    @Test (description = "with invalid e-mail: 255 symbols ")
    public void userRegistration_8(){
        userToTest.setEmail(USER_EMAIL8);
        Response response = basePage.registerUser(userToTest);

        response.then().log().all().statusCode(400);
        Assert.assertTrue(response.then().extract().jsonPath().getString("email").contains(USER_RESPONSE8),
                "TEST FAILED: No expected message");

    }

    @Test (description = "with invalid e-mail: without @")
    public void userRegistration_9(){
        userToTest.setEmail(USER_EMAIL9);
        Response response = basePage.registerUser(userToTest);

        response.then().log().all().statusCode(400);
        Assert.assertTrue(response.then().extract().jsonPath().getString("email").contains(USER_RESPONSE9),
                "TEST FAILED: No expected message");
    }

    @Test (description = "with invalid e-mail: contains \"..\"")
    public void userRegistration_10(){
        userToTest.setEmail(USER_EMAIL10);
        Response response = basePage.registerUser(userToTest);

        response.then().log().all().statusCode(400);
        Assert.assertTrue(response.then().extract().jsonPath().getString("email").contains(USER_RESPONSE10),
                "TEST FAILED: No expected message");
    }

    @Test (description = "with invalid e-mail: starts with \".\"")
    public void userRegistration_11(){
        userToTest.setEmail(USER_EMAIL11);
        Response response = basePage.registerUser(userToTest);

        response.then().log().all().statusCode(400);
        Assert.assertTrue(response.then().extract().jsonPath().getString("email").contains(USER_RESPONSE11),
                "TEST FAILED: No expected message");

    }

    @Test (description = "with invalid e-mail: domain part starts with .")
    public void userRegistration_12(){
        userToTest.setEmail(USER_EMAIL12);
        Response response = basePage.registerUser(userToTest);

        response.then().log().all().statusCode(400);
        Assert.assertTrue(response.then().extract().jsonPath().getString("email").contains(USER_RESPONSE12),
                "TEST FAILED: No expected message");
    }

    @Test (description = "with valid password: lowerCase letters only >=8 symbols")
    public void userRegistration_16(){
        userToTest.setPassword(USER_PASSWORD16);
        Response response = basePage.registerUser(userToTest);

        response.then().log().all().statusCode(201);
        Assert.assertEquals(userToTest.getEmail().toLowerCase(), response.then().extract().jsonPath().getString("email"),
                "TEST FAILED");
    }

    @Test (description = "with valid password: UpperCase letters only >=8 symbols")
    public void userRegistration_17(){
        userToTest.setPassword(USER_PASSWORD17);
        Response response = basePage.registerUser(userToTest);

        response.then().log().all().statusCode(201);
        Assert.assertEquals(userToTest.getEmail().toLowerCase(), response.then().extract().jsonPath().getString("email"),
                "TEST FAILED");
    }

    @Test (description = "with valid password: lowerCase and UpperCase letters only >=8 symbols")
    public void userRegistration_18(){
        userToTest.setPassword(USER_PASSWORD18);
        Response response = basePage.registerUser(userToTest);

        response.then().log().all().statusCode(201);
        Assert.assertEquals(userToTest.getEmail().toLowerCase(), response.then().extract().jsonPath().getString("email"),
                "TEST FAILED");
    }

    @Test (description = "with valid password: letters and numbers >=8 symbols")
    public void userRegistration_19(){
        userToTest.setPassword(USER_PASSWORD19);
        Response response = basePage.registerUser(userToTest);

        response.then().log().all().statusCode(201);
        Assert.assertEquals(userToTest.getEmail().toLowerCase(), response.then().extract().jsonPath().getString("email"),
                "TEST FAILED");
    }

    @Test (description = "with valid password: special symbols >= 8")
    public void userRegistration_20(){
        userToTest.setPassword(USER_PASSWORD20);
        Response response = basePage.registerUser(userToTest);

        response.then().log().all().statusCode(201);
        Assert.assertEquals(userToTest.getEmail().toLowerCase(), response.then().extract().jsonPath().getString("email"),
                "TEST FAILED");
    }

    @Test (description = "with invalid password: 7 symbols")
    public void userRegistration_21(){
        userToTest.setPassword(USER_PASSWORD21);
        Response response = basePage.registerUser(userToTest);

        response.then().log().all().statusCode(400);
        Assert.assertTrue(response.then().extract().jsonPath().getString("password").contains(USER_RESPONSE21),
                "TEST FAILED: No expected message");

    }

    @Test (description = "with invalid password: equal to name + \"1\"")
    public void userRegistration_22(){
        userToTest.setPassword(USER_PASSWORD22);
        Response response = basePage.registerUser(userToTest);

        response.then().log().all().statusCode(400);
        Assert.assertTrue(response.then().extract().jsonPath().getString("password").contains(USER_RESPONSE22),
                "TEST FAILED: No expected message");

    }

    @Test (description = "with invalid password: equal to email")
    public void userRegistration_23(){
        userToTest.setPassword(userToTest.getEmail());
        Response response = basePage.registerUser(userToTest);

        response.then().log().all().statusCode(400);
        Assert.assertTrue(response.then().extract().jsonPath().getString("password").contains(USER_RESPONSE23),
                "TEST FAILED: No expected message");

    }

    @Test (description = "with invalid password: numbers only >= 8 symbols")
    public void userRegistration_24(){
        userToTest.setPassword(USER_PASSWORD24);
        Response response = basePage.registerUser(userToTest);

        response.then().log().all().statusCode(400);
        Assert.assertTrue(response.then().extract().jsonPath().getString("password").contains(USER_RESPONSE24),
                "TEST FAILED: No expected message");

    }

    @Test (description = "with invalid password: qwerty")
    public void userRegistration_25(){
        userToTest.setPassword(USER_PASSWORD25);
        Response response = basePage.registerUser(userToTest);

        response.then().log().all().statusCode(400);
        Assert.assertTrue(response.then().extract().jsonPath().getString("password").contains(USER_RESPONSE25),
                "TEST FAILED: No expected message");

    }

    @Test (description = "with valid name: Uppercase and Lowercase letters")
    public void userRegistration_26(){
        userToTest.setUsername(USER_NAME26);
        Response response = basePage.registerUser(userToTest);

        response.then().log().all().statusCode(201);
        Assert.assertEquals(userToTest.getEmail().toLowerCase(), response.then().extract().jsonPath().getString("email"),
                "TEST FAILED");
    }

    @Test (description = "with valid name: Cyrillic letters")
    public void userRegistration_27(){
        userToTest.setUsername(USER_NAME27);
        Response response = basePage.registerUser(userToTest);

        response.then().log().all().statusCode(201);
        Assert.assertEquals(userToTest.getEmail().toLowerCase(), response.then().extract().jsonPath().getString("email"),
                "TEST FAILED");
    }

    @Test (description = "with valid name: Contains numbers")
    public void userRegistration_28(){
        userToTest.setUsername(USER_NAME28);
        Response response = basePage.registerUser(userToTest);

        response.then().log().all().statusCode(201);
        Assert.assertEquals(userToTest.getEmail().toLowerCase(), response.then().extract().jsonPath().getString("email"),
                "TEST FAILED");
    }

    @Test (description = "with valid name: Contains \"@+.-_\"")
    public void userRegistration_29(){
        userToTest.setUsername(USER_NAME29);
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

    @Test (description = "with invalid name: empty field")
    public void userRegistration_31(){
        userToTest.setUsername(USER_NAME31);
        Response response = basePage.registerUser(userToTest);

        response.then().log().all().statusCode(400);
        Assert.assertTrue(response.then().extract().jsonPath().getString("username").contains(USER_RESPONSE31),
                "TEST FAILED: No expected message");

    }

    @Test (description = "with invalid name: 151 symbol")
    public void userRegistration_32(){
        userToTest.setUsername(USER_NAME32);
        Response response = basePage.registerUser(userToTest);

        response.then().log().all().statusCode(400);
        Assert.assertTrue(response.then().extract().jsonPath().getString("username").contains(USER_RESPONSE32),
                "TEST FAILED: No expected message");

    }

    @Test (description = "with invalid name: contains \"*/#\"")
    public void userRegistration_33(){
        userToTest.setUsername(USER_NAME33);
        Response response = basePage.registerUser(userToTest);

        response.then().log().all().statusCode(400);
        Assert.assertTrue(response.then().extract().jsonPath().getString("username").contains(USER_RESPONSE33),
                "TEST FAILED: No expected message");
    }



}
