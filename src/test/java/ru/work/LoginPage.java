package ru.work;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {
    public WebDriver driver;
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    @FindBy(xpath = "//*[@id=\"name-input\"]")
    private WebElement nameField;

    @FindBy(xpath = "//*[@id=\"feedbackForm\"]/label[2]/input")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"drink2\"]")
    private WebElement milkCheckbox;

    @FindBy(xpath = "//*[@id=\"drink3\"]")
    private WebElement coffeeCheckbox;

    @FindBy(xpath = "//*[@id=\"color3\"]")
    private WebElement yellowRadio;

    @FindBy(xpath = "//*[@id=\"automation\"]")
    private WebElement selectAutomation;

    @FindBy(xpath = "//*[@id=\"email\"]")
    private WebElement emailField;

    @FindBy(xpath = "//*[@id=\"feedbackForm\"]/ul")
    private WebElement automationTools;

    @FindBy(xpath = "//*[@id=\"message\"]")
    private WebElement messageField;

    @FindBy(xpath = "//*[@id=\"submit-btn\"]")
    private WebElement submitBtn;

    public void zoomingOut(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom = '" + 0.45 + "'");
    }
    public void scrollBy(int pixels) {
        ((JavascriptExecutor)driver).executeScript(String.format("scroll(0,%s)",pixels));
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void inputName(String name) {
        nameField.sendKeys(name);
    }
    public void inputPassword(String password) {
        passwordField.sendKeys(password);
    }
    public void selectCheckbox() {
        milkCheckbox.click();
        coffeeCheckbox.click();
    }
    public void selectColor() {
        yellowRadio.click();
    }
    public void clickSelect() {
        Select select = new Select(selectAutomation);
        select.selectByValue("yes");
    }
    public void inputEmail(String email) {
        if (email.matches("\\w+@example.com")) {
            emailField.sendKeys(email);
        }
    }
    public int size(){
        String[] array = automationTools.getText().split("\n");
        return array.length;
    }
    public String findMaxTools(){
        int len = 0;
        String tools = "";
        String[] array = automationTools.getText().split("\n");
        for (int i = 0; i < array.length; i++) {
            if(array[i].length()>len){
                len = array[i].length();
                tools = array[i];
            }
        }
        return tools;
    }
    public void inputMessage(int size, String tools) {
        messageField.sendKeys("Количество инструментов в пункте Automation tools: " + size
                + "\n" +
                "Инструмент из списка Automation tools, содержащий наибольшее количество символов: " + tools);
    }
    public void clickSubmitBtn() {
        submitBtn.click();
    }
}