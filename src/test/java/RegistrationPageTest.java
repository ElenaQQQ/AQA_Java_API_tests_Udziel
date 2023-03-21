import entities.UserDataToRegistration;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.*;
import pageobject.BasePage;
import static Config.Config.*;
import static Config.Credentials.*;
import static io.restassured.RestAssured.*;

public class RegistrationPageTest  extends BasePage {

    @Test (description = "with valid e-mail: lower case")
    public void userRegistration_1(){

        UserDataToRegistration userRegistration = new UserDataToRegistration(USER_PASSWORD, USER_NAME,"lena21031524@gmail.com");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(userRegistration)
                        .post("users/");

        response.then().log().all().statusCode(201);
        Assert.assertEquals(USER_NAME, response.then().extract().jsonPath().getString("username"),
                "TEST FAILED: Name of registered user not equal to user registration data");
    }

    @Test (description = "with valid e-mail: lower case and upper case")
    public void userRegistration_2(){

        UserDataToRegistration userRegistration = new UserDataToRegistration(USER_PASSWORD, USER_NAME,"LenA21031215@gmail.com");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(userRegistration)
                .post("users/");

        response.then().log().all().statusCode(201);
        Assert.assertEquals(USER_NAME, response.then().extract().jsonPath().getString("username"),
                "TEST FAILED: Name of registered user not equal to user registration data");

    }

    @Test (description = "with valid e-mail: starting with number")
    public void userRegistration_3(){

        UserDataToRegistration userRegistration = new UserDataToRegistration(USER_PASSWORD, USER_NAME,"1lena21031215@gmail.com");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(userRegistration)
                .post("users/");

        response.then().log().all().statusCode(201);
        Assert.assertEquals(USER_NAME, response.then().extract().jsonPath().getString("username"),
                "TEST FAILED: Name of registered user not equal to user registration data");

    }

    @Test (description = "with valid e-mail: with several dots in name part, not in a row")
    public void userRegistration_4(){

        UserDataToRegistration userRegistration = new UserDataToRegistration(USER_PASSWORD, USER_NAME,"lena.21.031.215@gmail.com");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(userRegistration)
                .post("users/");

        response.then().log().all().statusCode(201);
        Assert.assertEquals(USER_NAME, response.then().extract().jsonPath().getString("username"),
                "TEST FAILED: Name of registered user not equal to user registration data");

    }

    @Test (description = "with valid e-mail: with several dots in domain part, not in a row")
    public void userRegistration_5(){

        UserDataToRegistration userRegistration = new UserDataToRegistration(USER_PASSWORD, USER_NAME,"lena21031215@gmail.com.com.j.com");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(userRegistration)
                .post("users/");

        response.then().log().all().statusCode(201);
        Assert.assertEquals(USER_NAME, response.then().extract().jsonPath().getString("username"),
                "TEST FAILED: Name of registered user not equal to user registration data");

    }

    @Test (description = "with valid e-mail: with \"-\" in name part")
    public void userRegistration_6(){

        UserDataToRegistration userRegistration = new UserDataToRegistration(USER_PASSWORD, USER_NAME,"len-a21031215@gmail.com");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(userRegistration)
                .post("users/");

        response.then().log().all().statusCode(201);
        Assert.assertEquals(USER_NAME, response.then().extract().jsonPath().getString("username"),
                "TEST FAILED: Name of registered user not equal to user registration data");

    }

    @Test (description = "with invalid e-mail: empty field")
    public void userRegistration_7(){

        UserDataToRegistration userRegistration = new UserDataToRegistration(USER_PASSWORD, USER_NAME,"");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(userRegistration)
                .post("users/");

        response.then().log().all().statusCode(400);
        Assert.assertTrue(response.then().extract().jsonPath().getString("email").contains("не может быть пустым"),
                "TEST FAILED: No expected message");

    }

    @Test (description = "with invalid e-mail: 255 symbols ")
    public void userRegistration_8(){

        String email255 = "l".repeat(247).concat("@mail.ru");
        UserDataToRegistration userRegistration = new UserDataToRegistration(USER_PASSWORD, USER_NAME,email255);

        Response response = given()
                .header("Content-Type", "application/json")
                .body(userRegistration)
                .post("users/");

        response.then().log().all().statusCode(400);
        Assert.assertTrue(response.then().extract().jsonPath().getString("email").contains("не более 254 символов"),
                "TEST FAILED: No expected message");

    }

    @Test (description = "with invalid e-mail: without @")
    public void userRegistration_9(){

        UserDataToRegistration userRegistration = new UserDataToRegistration(USER_PASSWORD, USER_NAME,"lenamail.ru");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(userRegistration)
                .post("users/");

        response.then().log().all().statusCode(400);
        Assert.assertTrue(response.then().extract().jsonPath().getString("email").contains("Введите правильный адрес"),
                "TEST FAILED: No expected message");
    }

    @Test (description = "with invalid e-mail: contains \"..\"")
    public void userRegistration_10(){

        UserDataToRegistration userRegistration = new UserDataToRegistration(USER_PASSWORD, USER_NAME,"le..na@mail.ru");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(userRegistration)
                .post("users/");

        response.then().log().all().statusCode(400);
        Assert.assertTrue(response.then().extract().jsonPath().getString("email").contains("Введите правильный адрес"),
                "TEST FAILED: No expected message");

    }

    @Test (description = "with invalid e-mail: starts with \".\"")
    public void userRegistration_11(){

        UserDataToRegistration userRegistration = new UserDataToRegistration(USER_PASSWORD, USER_NAME,".lena@mail.ru");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(userRegistration)
                .post("users/");

        response.then().log().all().statusCode(400);
        Assert.assertTrue(response.then().extract().jsonPath().getString("email").contains("Введите правильный адрес"),
                "TEST FAILED: No expected message");

    }

    @Test (description = "with invalid e-mail: domain part starts with .")
    public void userRegistration_12(){

        UserDataToRegistration userRegistration = new UserDataToRegistration(USER_PASSWORD, USER_NAME,"lena@.mail.ru");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(userRegistration)
                .post("users/");

        response.then().log().all().statusCode(400);
        Assert.assertTrue(response.then().extract().jsonPath().getString("email").contains("Введите правильный адрес"),
                "TEST FAILED: No expected message");

    }



}

//    @BeforeTest
//    public void precondition() {
//        baseURI = "https://reqres.in/api";
//    }
//
//    @Test
//    public void get_test(){
//        Response response = given().get("/users?id=2");
//        response.then().assertThat().statusCode(200);
//        Assert.assertEquals(response.then().extract().response().jsonPath().getInt("data.id"), 2);
//    }
