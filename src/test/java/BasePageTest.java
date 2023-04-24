
import org.testng.annotations.*;
import static io.restassured.RestAssured.*;
import static config.Config.*;

public class BasePageTest {



    @BeforeTest
    public void beforeAllTests() {
        baseURI = BASE_URI;

    }



}
