import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;

import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import page.RegistrationPage;

@Story("Регистрация пользователя")
public class RegistrationTest {

    @Test
    @DisplayName("Регистрация пользователя")
    public void registerUser() {
        RegistrationPage registrationPage = open("https://stellarburgers.nomoreparties.site/register",
            RegistrationPage.class);
        registrationPage.registerNewUser("Test", new DataGenerator().getRandomEmail(),"Test12");
        registrationPage.waitForLoadingLoginPage();
        Assert.assertEquals("Переход на форму логина не произведен", Dictionary.LOGIN_URL, url());
    }

    @Test
    @DisplayName("Неуспешная регистрация пользователя")
    public void registerUserNegative() {
        RegistrationPage registrationPage = open("https://stellarburgers.nomoreparties.site/register",
            RegistrationPage.class);
        registrationPage.registerNewUser("Test", new DataGenerator().getRandomEmail(),"Test");
        Assert.assertTrue("Отсутствует предупреждение системы", registrationPage.isWarningVisible());
    }
}
