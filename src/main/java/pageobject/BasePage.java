package pageobject;

import org.testng.annotations.*;
import io.restassured.RestAssured.*;
import static Config.Config.*;
import static io.restassured.RestAssured.baseURI;

import io.restassured.response.Response;

public class BasePage {

//@BeforeTest
//    public void begin (){
//        baseURI = BASE_URI;
//    }

    @BeforeTest
    public void precondition() {
        baseURI = BASE_URI;
    }

}

