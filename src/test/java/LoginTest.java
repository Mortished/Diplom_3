import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import page.ForgotPasswordPage;
import page.LoginPage;
import page.MainPage;
import page.ProfilePage;
import page.RegistrationPage;

@Story("Логин в аккаунт")
public class LoginTest {

    private LoginPage loginPage;

    @Test
    @DisplayName("Логин пользователя через ЛК")
    public void loginFromLoginPage() {
        loginPage = open(Dictionary.LOGIN_URL, LoginPage.class);
        loginPage.login(Dictionary.EMAIL, Dictionary.PASSWORD);
        Assert.assertTrue(loginPage.waitForLoadMainPage());
        Assert.assertEquals(Dictionary.MAIN_URL, url());
    }

    @Test
    @DisplayName("Логин пользователя через главную")
    public void loginFromMainPage() {
        MainPage mainPage = open(Dictionary.MAIN_URL, MainPage.class);
        loginPage = mainPage.loginButtonClick();
        loginPage.login(Dictionary.EMAIL, Dictionary.PASSWORD);
        Assert.assertTrue(loginPage.waitForLoadMainPage());
        Assert.assertEquals(Dictionary.MAIN_URL, url());
    }

    @Test
    @DisplayName("Логин пользователя через форму регистрации")
    public void loginFromRegistrationPage() {
        RegistrationPage registrationPage = open(Dictionary.REGISTER_URL, RegistrationPage.class);
        loginPage = registrationPage.goToLoginPage();
        loginPage.login(Dictionary.EMAIL, Dictionary.PASSWORD);
        Assert.assertTrue(loginPage.waitForLoadMainPage());
        Assert.assertEquals(Dictionary.MAIN_URL, url());
    }

    @Test
    @DisplayName("Логин пользователя через страницу восстановления пароля ")
    public void loginFromForgotPasswordPage() {
        ForgotPasswordPage forgotPasswordPage = open(Dictionary.FORGOT_PASSWORD_URL, ForgotPasswordPage.class);
        loginPage = forgotPasswordPage.goToLoginPage();
        loginPage.login(Dictionary.EMAIL, Dictionary.PASSWORD);
        Assert.assertTrue(loginPage.waitForLoadMainPage());
        Assert.assertEquals(Dictionary.MAIN_URL, url());
    }

    @After
    public void logout() {
        Selenide.page(MainPage.class)
            .profileButtonClick()
            .logout();
        loginPage.isLoginPage();
    }

}
