package steps;

import io.cucumber.java.After;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Тогда;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.close;
import static java.lang.Thread.sleep;


public class case1 {


    public static ChromeDriver driver;

    @Before
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "C://java//chromedriver.exe");
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
    public void вход_в_бсл_через_с_паролем(String login, String password) throws InterruptedException {
        driver.get("https://sso.kz00c1.kz.infra/opensso/UI/Login?goto=https%3A%2F%2Fbsl.kz00c1.kz.infra%2Fbsl");
        sleep(2000);

        driver.findElementById("IDToken1").sendKeys(login);
        sleep(2000);

        driver.findElement(By.id("IDToken2")).sendKeys(password);
        sleep(2000);

        driver.findElement(By.id("kc-login")).click();
        sleep(2000);

    }

    @Тогда("Нажать на поиск клиента")
    public void нажать_на_поиск_клиента() throws InterruptedException {
        driver.findElementByXPath("//*[@id=\"UC06_040\"]/div").click();
        //sleep(2000);

    }

    @Дано("ИИН клиента")
    public void иин_клиента() throws InterruptedException {
        driver.findElementById("id25").sendKeys("971009450689");
        sleep(2000);
        driver.findElementById("id15").click();
        sleep(2000);

    }

    @Тогда("Проверка страницы клиента")
    public void проверка_страницы_клиента() throws InterruptedException {

        String iin = driver.findElementByXPath("/html/body/div[2]/div[1]/h1").getText();
        Assert.assertNotNull(iin);
        System.out.println(iin);

        sleep(2000);
    }

}
