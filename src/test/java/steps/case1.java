package steps;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Тогда;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.close;
import static com.google.common.primitives.Ints.max;
import static java.lang.Thread.sleep;

public class case1 {

    public static ChromeDriver driver;

    @Before
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "C://Program Files//webdriver//chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @After
    public static void tearDown() {
        driver.quit();
        close();
    }



    @Дано("Вход в бсл через (.*) с паролем (.*)")
    public void вход_в_бсл_через_с_паролем() {
driver.get("https://sso.kz00c1.kz.infra/opensso/UI/Login?goto=https%3A%2F%2Fbsl.kz00c1.kz.infra%2Fbsl%2Fhome%3F");
        Selenide.sleep(10000);
driver.findElementByXPath("/html/body/div/div[2]/div/div/div/div/form/div[1]/input").sendKeys("uatuser1");
        Selenide.sleep(3000);
driver.findElementByXPath("/html/body/div/div[2]/div/div/div/div/form/div[2]/input").sendKeys("12345678");
        Selenide.sleep(3000);
driver.findElementByXPath("/html/body/div/div[2]/div/div/div/div/form/div[4]/input[2]").click();
Selenide.sleep(10000);

    }

    @Тогда("Нажать на создать банк")
    public void создать_банк()  {
        driver.findElementByXPath("/html/body/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/a/div").click();
        Selenide.sleep(4000);

    }

    @Дано("Данные банка")
    public void параметры_банка() {
        driver.findElementByXPath("/html/body/div[2]/div[1]/div/form/div[2]/div[1]/div/ul[1]/ul/li[1]/input").sendKeys("RAUSHANY");
        Selenide.sleep(3000);
        driver.findElementByXPath("/html/body/div[2]/div[1]/div/form/div[2]/div[1]/div/ul[1]/ul/li[2]/input").sendKeys("143");
        Selenide.sleep(3000);
        driver.findElementByXPath("/html/body/div[2]/div[1]/div/form/div[2]/div[1]/div/ul[1]/li/input").sendKeys("RAAAAU");
        Selenide.sleep(3000);
        driver.findElementByXPath("/html/body/div[2]/div[1]/div/form/div[2]/div[1]/div/ul[2]/li[1]/select").click();
        Selenide.sleep(1000);
        driver.findElementByXPath("/html/body/div[2]/div[1]/div/form/div[2]/div[1]/div/ul[2]/li[1]/select/option[2]").click();
        Selenide.sleep(1000);
        driver.findElementByXPath("/html/body/div[2]/div[1]/div/form/div[2]/div[1]/div/ul[3]/li[3]/input").sendKeys("6");
        Selenide.sleep(3000);

        driver.findElementByXPath("/html/body/div[2]/div[1]/div/form/div[2]/div[2]/ul/li[1]/input").click();
        Selenide.sleep(10000);


    }

    @Тогда("Проверка страницы банка")
    public void проверка_страницы_банка() {

       String iin = driver.findElementByXPath("/html/body/div[2]/div[1]/div[1]/div/div[1]/ul[1]/li[2]/span[2]/span").getText();
       Assert.assertNotNull(iin);
        Selenide.sleep(2000);
    }




}
