package pageobject;

import com.github.javafaker.Faker;
import org.testng.annotations.DataProvider;

public class RegistrationPage extends BasePage {

    protected static Faker faker = new Faker();

    @DataProvider(name = "Create user - with valid email")
    public static Object[][] getData(){
        return new Object[][]{
                {faker.bothify("lena?????@gmail.com")},
                {faker.bothify("????".toUpperCase() + "lena?????@gmail.com")},
                {faker.bothify("###lenA26032202@gmail.com")},
                {faker.bothify("lena.21.031.?????@gmail.com")},
                {faker.bothify("lena?????@gmail.com.com.j.com")},
                {faker.bothify("len-a?????@gmail.com")}
        };
    }




}
