
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobject.BasePage;
import org.testng.annotations.*;

public class BasePageTest {

    public BasePage basePage;

    @BeforeTest
    public void start () {

    }

    @AfterTest
    public void finish() {

    }

    @Test (description = "", groups = "")
    public void test1 (){

    };

}
