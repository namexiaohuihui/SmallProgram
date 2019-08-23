package testDemo;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.concurrent.TimeUnit;
import java.net.URL;
import org.openqa.selenium.remote.RemoteWebDriver;
/**
 * @ ClassName: CalculatorTest
 * @ Author: DingDong
 * @ Date: 2019/8/12 15:37
 * @ Version: 1.0
 * @ desc:
 */
public class CalculatorTest {
    private static RemoteWebDriver CalculatorSession = null;
    private static WebElement CalculatorResult = null;

    @BeforeClass
    public static void setup() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
            capabilities.setCapability("platformName", "Windows");
            capabilities.setCapability("deviceName", "WindowsPC");
            CalculatorSession = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            CalculatorSession.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

            CalculatorSession.findElementByXPath("//Button[starts-with(@Name, \"Menu\")]").click();
            CalculatorSession.findElementByXPath("//ListItem[@Name=\"Standard Calculator\"]").click();

            CalculatorSession.findElementByName("Clear").click();
            CalculatorSession.findElementByName("Seven").click();
            CalculatorResult = CalculatorSession.findElementByName("Display is  7 ");
            Assert.assertNotNull(CalculatorResult);

        }catch(Exception e){
            e.printStackTrace();
        } finally {
        }
    }

    @BeforeMethod
    public void Clear()
    {
        CalculatorSession.findElementByName("Clear").click();
        Assert.assertEquals("Display is  0 ", CalculatorResult.getText());
    }

    @AfterClass
    public static void TearDown()
    {
        CalculatorResult = null;
        if (CalculatorSession != null) {
            CalculatorSession.quit();
        }
        CalculatorSession = null;
    }

    @Test
    public void Addition()
    {
        CalculatorSession.findElementByName("One").click();
        CalculatorSession.findElementByName("Plus").click();
        CalculatorSession.findElementByName("Seven").click();
        CalculatorSession.findElementByName("Equals").click();
        Assert.assertEquals("Display is  8 ", CalculatorResult.getText());
    }

    @Test
    public void Combination()
    {
        CalculatorSession.findElementByName("Seven").click();
        CalculatorSession.findElementByName("Multiply by").click();
        CalculatorSession.findElementByName("Nine").click();
        CalculatorSession.findElementByName("Plus").click();
        CalculatorSession.findElementByName("One").click();
        CalculatorSession.findElementByName("Equals").click();
        CalculatorSession.findElementByName("Divide by").click();
        CalculatorSession.findElementByName("Eight").click();
        CalculatorSession.findElementByName("Equals").click();
        Assert.assertEquals("Display is  8 ", CalculatorResult.getText());
    }

    @Test
    public void Division()
    {
        CalculatorSession.findElementByName("Eight").click();
        CalculatorSession.findElementByName("Eight").click();
        CalculatorSession.findElementByName("Divide by").click();
        CalculatorSession.findElementByName("One").click();
        CalculatorSession.findElementByName("One").click();
        CalculatorSession.findElementByName("Equals").click();
        Assert.assertEquals("Display is  8 ", CalculatorResult.getText());
    }

    @Test
    public void Multiplication()
    {
        CalculatorSession.findElementByName("Nine").click();
        CalculatorSession.findElementByName("Multiply by").click();
        CalculatorSession.findElementByName("Nine").click();
        CalculatorSession.findElementByName("Equals").click();
        Assert.assertEquals("Display is  81 ", CalculatorResult.getText());
    }

    @Test
    public void Subtraction()
    {
        CalculatorSession.findElementByName("Nine").click();
        CalculatorSession.findElementByName("Minus").click();
        CalculatorSession.findElementByName("One").click();
        CalculatorSession.findElementByName("Equals").click();
        Assert.assertEquals("Display is  8 ", CalculatorResult.getText());
    }
}
