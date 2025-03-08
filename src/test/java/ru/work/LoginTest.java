package ru.work;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest {
    public static LoginPage loginPage;
    public static WebDriver driver;


    @BeforeAll
    public static void setup() {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);

        driver.manage().window().maximize();
        driver.get(ConfProperties.getProperty("loginpage"));
    }

    @Test
    public void loginTest() {
        //loginPage.zoomingOut();
        loginPage.inputName("name");
        loginPage.inputPassword("pass");
        loginPage.selectCheckbox();

        loginPage.scrollBy(1200);
        loginPage.selectColor();

        loginPage.scrollBy(1200);
        loginPage.clickSelect();

        loginPage.scrollBy(1200);
        loginPage.inputEmail("test@example.com");

        loginPage.scrollBy(1200);
        loginPage.inputMessage(loginPage.size(), loginPage.findMaxTools());

        loginPage.scrollBy(1200);
        loginPage.clickSubmitBtn();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        assertEquals("Message received!", alertText);
    }

    @AfterAll
    public static void end(){
        driver.quit();
    }
}
