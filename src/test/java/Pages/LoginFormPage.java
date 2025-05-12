package Pages;

import TestPropertiesConfig.TestPropertiesConfig;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginFormPage extends BasePage{
    TestPropertiesConfig config;
    public static final String LOGIN_FORM_URL = BASE_URL + "login-form.html";

    @FindBy(id = "username")
    private WebElement loginForm;

    @FindBy(id = "password")
    private WebElement passwordForm;

    @FindBy(xpath = "//button[@type = 'submit']")
    private WebElement submitButton;

    @FindBy(className = "alert")
    private WebElement message;

    public LoginFormPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("open login form page")
    public void open() {
        driver.get(LOGIN_FORM_URL);
    }

    @Step("send text to loginForm")
    public void sendTextToLoginForm(String userNameForLoginForm){
        String maskedLogin = "****";
        loginForm.sendKeys(userNameForLoginForm);
        Allure.addAttachment("Password entered", "text/plain", maskedLogin, "txt");
    }

    @Step("send text to passwordForm")
    public void sendTextToPasswordForm(String passwordForLoginForm){
        String maskedPassword = "****";
        passwordForm.sendKeys(passwordForLoginForm);
        Allure.addAttachment("Password entered", "text/plain", maskedPassword, "txt");
    }

    @Step("click submit button")
    public void clickSubmitButton(){
        submitButton.click();
    }

    @Step("get message")
    public String getMessage(){
        return message.getText();
    }
}
