package pageobject;

import com.github.javafaker.Faker;
import entities.*;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;

public class BasePage {

    public String getAccessToken(User userToLogin) {

        Response response = given()
                .header("Content-Type", "application/json")
                .body(userToLogin)
                .post("jwt/create/");

        return response.then().extract().response().jsonPath().getString("access");
    }

    public Response deleteUserMe(User userToDelete){

        return given()
                .header("Content-Type", "application/json")
                .when()
                .header("Authorization", "Token " + getAccessToken(userToDelete))
                .body(userToDelete)
                .delete("users/me/");
    }

    public Response registerUser(User userRegistration) {

        Response response = given()
                .header("Content-Type", "application/json")
                .body(userRegistration)
                .post("users/");
        System.out.println("USER DATA TO REGISTRATION: " + userRegistration.getEmail() + " password: " + userRegistration.getPassword() + " NAME: " + userRegistration.getUsername());
        return response;
    }

    //There are DataProviders for Registration page and User page tests

    protected static Faker faker = new Faker();

    public static final String USER_TEST_NAME = "Name";

    @DataProvider(name = "valid emails")
    public static Object[][] getValidEmails(){
        return new Object[][]{
                {faker.bothify("lena?????@gmail.com")},
                {faker.bothify("????".toUpperCase() + "lena?????@gmail.com")},
                {faker.bothify("###lenA26032202@gmail.com")},
                {faker.bothify("lena.21.031.?????@gmail.com")},
                {faker.bothify("lena?????@gmail.com.com.j.com")},
                {faker.bothify("len-a?????@gmail.com")}
        };
    }

    @DataProvider(name = "invalid emails")
    public static Object[][] getInvalidEmails(){
        return new Object[][]{
                {"", "не может быть пустым"},
                {"b".repeat(257) + "@mail.ru", "не более 254 символов"},
                {"lenamail.ru", "Введите правильный адрес"},
                {"le..na@mail.ru", "Введите правильный адрес"},
                {".lena@mail.ru", "Введите правильный адрес"},
                {"lena@.mail.ru", "Введите правильный адрес"}
        };
    }

    @DataProvider(name = "valid passwords")
    public static Object[][] getValidPasswords(){
        return new Object[][]{
                {faker.bothify("???????????").toLowerCase()},
                {faker.bothify("???????????").toUpperCase()},
                {faker.bothify("?????".toLowerCase() + "???????????".toUpperCase())},
                {faker.bothify("???###???###")},
                {faker.bothify("~!?@$%^&*_-+()[]{}></|'.,:;????") + "#"}
        };
    }

    @DataProvider(name = "invalid passwords")
    public static Object[][] getInvalidPasswords(){
        return new Object[][]{
                {faker.bothify("???????"), "слишком короткий"},
                {USER_TEST_NAME + "1", "слишком похож на username"},
                {faker.bothify("########"), "только из цифр"},
                {"qwerty", "широко распространён"}
        };
    }

    @DataProvider(name = "valid names")
    public static Object[][] getValidNames(){
        return new Object[][]{
                {faker.bothify("Elena???")},
                {faker.bothify("Елена???")},
                {faker.bothify("?????###")},
                {faker.bothify("???@+.-_")}
        };
    }

    @DataProvider(name = "invalid names")
    public static Object[][] getInvalidNames(){
        return new Object[][]{
                {"", "не может быть пустым"},
                {faker.bothify("?").repeat(151), "не более 150 символов"},
                {faker.bothify("???*/#"), "может содержать только"}
        };
    }

}

