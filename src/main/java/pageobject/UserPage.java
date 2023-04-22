package pageobject;

import com.github.javafaker.Faker;
import entities.UserDataToRegistration;
import entities.UserToDelete;
import entities.UserToLogin;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static Config.Credentials.*;
import static Config.TestData.*;
import static io.restassured.RestAssured.given;

public class UserPage extends BasePage {

    protected UserDataToRegistration userToTest;
    protected UserToLogin userToLogin;
    protected UserToDelete userToDelete;
    protected String accessToken;
    protected static Faker faker = new Faker();
    protected static String userEmailRandom;
    protected static String userPasswordRandom;

    @BeforeMethod
    public void beforeEachTest(){
        userEmailRandom = faker.bothify("lena######????@mail.ru");
        userPasswordRandom = faker.bothify("###???###???Q_");
        userToTest = new UserDataToRegistration(userEmailRandom, userPasswordRandom, USER_NAME);
        registerUser(userToTest);
        userToLogin = new UserToLogin(userToTest.getEmail(), userToTest.getPassword());
        accessToken = getAccessToken(userToLogin);
        userToDelete = new UserToDelete(userToTest.getEmail(), userToTest.getPassword());
    }


    @AfterMethod
    public void deleteUserAfterTest(){
        deleteUserMe(userToDelete);
    }

    public Response changeUsername(String newName, String accessToken){
        return given()
                .when()
                .contentType(ContentType.JSON)
                .header("Authorization", "Token " + accessToken)
                .body("{\n" +
                        " \"username\": \"" + newName + "\"\n" +
                        "}")
                .patch("users/me/");
    }

    public Response changeUserData(UserDataToRegistration userToTestNew){
        return given()
                .when()
                .contentType(ContentType.JSON)
                .header("Authorization", "Token " + getAccessToken(userToLogin))
                .body("{\n" +
                        " \"email\": \"" + userToTestNew.getEmail() + "\"\n" +
                        " \"username\": \"" + userToTestNew.getUsername() + "\"\n" +
                        " \"password\": \"" + userToTestNew.getPassword() + "\"\n" +
                        "}")
                .put("users/me/");
    }

    public Response changeUserPassword(String newPassword, String accessToken){
        return given()
                .when()
                .contentType(ContentType.JSON)
                .header("Authorization", "Token " + accessToken)
                .body("{\n" +
                        " \"new_password\": \"" + newPassword + "\"\n" +
                        "}")
                .post("users/set_password/");
    }

}
