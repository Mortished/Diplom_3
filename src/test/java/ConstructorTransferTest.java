import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import page.LoginPage;
import page.MainPage;
import page.ProfilePage;

@Story("Переход в конструктор из ЛК")
public class ConstructorTransferTest {

    private ProfilePage profilePage;
    private LoginPage loginPage;

    @Before
    public void login() {
        MainPage mainPage = open(Dictionary.MAIN_URL, MainPage.class);
        loginPage = mainPage.loginButtonClick();
        loginPage.login(Dictionary.EMAIL, Dictionary.PASSWORD);
        loginPage.waitForLoadMainPage();
        profilePage = mainPage.profileButtonClick();
    }

    @Test
    @DisplayName("Переход в конструктор из ЛК")
    public void openConstructor() {
        profilePage.clickConstructorLink();
        Assert.assertTrue("Главная страница не загружена", loginPage.waitForLoadMainPage());
        Assert.assertEquals("Переход в конструктор не работает", Dictionary.MAIN_URL, url());
    }

    @Test
    @DisplayName("Переход в конструктор из ЛК по логотипу ")
    public void openConstructorByLogo() {
        profilePage.clickMainLogo();
        Assert.assertTrue("Главная страница не загружена", loginPage.waitForLoadMainPage());
        Assert.assertEquals("Переход в конструктор не работает", Dictionary.MAIN_URL, url());
    }

    @After
    public void logout() {
        Selenide.page(MainPage.class)
            .profileButtonClick()
            .logout();
        loginPage.isLoginPage();
    }

}
