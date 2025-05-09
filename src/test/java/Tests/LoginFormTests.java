package Tests;

import Pages.LoginFormPage;
import TestPropertiesConfig.TestPropertiesConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.*;

public class LoginFormTests extends BaseTest{
    TestPropertiesConfig config;
    private LoginFormPage loginFormPage;

    @BeforeEach
    void setUpLoginForm(){
        loginFormPage = new LoginFormPage(driver);
        config = ConfigFactory.create(TestPropertiesConfig.class, System.getProperties());
        loginFormPage.open();
    }

    @DisplayName("Проверка проведения авторизации")
    @Tags({@Tag("Smoke"), @Tag("UI")})
    @Test
    void signInTest(){
        String expectedMessage = "Login successful";
        String userNameFromProperties = config.getUsername();
        String passwordFromProperties = config.getPassword();

        loginFormPage.sendTextToLoginForm(userNameFromProperties);
        loginFormPage.sendTextToPasswordForm(passwordFromProperties);
        loginFormPage.clickSubmitButton();

        String actualMessage = loginFormPage.getMessage();

        Assertions.assertEquals(expectedMessage, actualMessage, "Значения должны совпадать");
    }

    @DisplayName("Проверка провала авторизации")
    @Tags({@Tag("Smoke"), @Tag("UI")})
    @Test
    void InvalidSignInTest(){
        String userNameFromProperties = config.getUsername();
        String InvalidPassword = "1234";
        String expectedMessage = "Invalid credentials";

        loginFormPage.sendTextToLoginForm(userNameFromProperties);
        loginFormPage.sendTextToPasswordForm(InvalidPassword);
        loginFormPage.clickSubmitButton();
        String actualMessage = loginFormPage.getMessage();

        Assertions.assertEquals(expectedMessage, actualMessage, "Значения должны совпадать");
    }
}
