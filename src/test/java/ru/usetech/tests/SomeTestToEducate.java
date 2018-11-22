package ru.usetech.tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class SomeTestToEducate {
    private WebDriver driver;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://mlgext.usetech.ru/");
        driver.findElement(By.name("login")).sendKeys("vm_user01@mail.ru");
        driver.findElement(By.name("password")).sendKeys("12345");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Загрузка параметров'])[1]/preceding::button[1]")).click();
        /*driver.findElement(By.linkText("Выход")).click();*/
    }

    @Test
    public void loginTest() throws Exception {

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();

    }


}
