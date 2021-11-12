//import com.codeborne.selenide.SelenideElement;
//import com.codeborne.selenide.WebDriverRunner;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//
//import java.util.ArrayList;
//import java.util.Set;
//
//import static com.codeborne.selenide.Condition.enabled;
//
//public class WebElementFunctions {
//
//    public static void jsClickOnElement(SelenideElement element) {
//
//        /////// Annotation:
//        // wait 0.29s and then clicks on element regardless if it's visible, enabled or not
//        element.shouldBe(enabled);
//
//        try {
//            Thread.sleep(290);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        JavascriptExecutor executor = (JavascriptExecutor) WebDriverRunner.getWebDriver();
//        executor.executeScript("arguments[0].click();", element);
//    }
//
//    public static void switchToBrowserTab(int tabIndex) {
//
//        /////////////// Annotation:
//        // switches to required tab
//
//        WebDriver driver = WebDriverRunner.getWebDriver();
//
//        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
//        driver.switchTo().window(tabs.get(tabIndex-1));
//
//    }
//
//
//}