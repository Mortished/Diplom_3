import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;

import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import page.LoginPage;
import page.MainPage;
import page.ProfilePage;

@Story("Переход в личный кабинет")
public class ProfileTest {

    private MainPage mainPage;
    private ProfilePage profilePage;
    private LoginPage loginPage;

    @Before
    public void login() {
        mainPage = open(Dictionary.MAIN_URL, MainPage.class);
        loginPage = mainPage.loginButtonClick();
        loginPage.login(Dictionary.EMAIL, Dictionary.PASSWORD);
        loginPage.waitForLoadMainPage();
    }

    @Test
    @DisplayName("Переход в личный кабинет")
    public void openProfilePage() {
        profilePage = mainPage.profileButtonClick();
        Assert.assertTrue("Переход в ЛК не был произведен", profilePage.isProfilePage());
        Assert.assertEquals("Отображается другая страница", Dictionary.PROFILE_URL, url());
    }

    @Test
    @DisplayName("Выход из личного кабинета")
    public void logoutFromProfile() {
        profilePage = mainPage.profileButtonClick();
        profilePage.logout();
        Assert.assertTrue("Выход из УЗ не был произведен", loginPage.isLoginPage());
        Assert.assertEquals("Отображается другая страница", Dictionary.LOGIN_URL, url());
    }

    @After
    public void logout() {
        if (!url().equals(Dictionary.LOGIN_URL)) {
            profilePage.logout();
            loginPage.isLoginPage();
        }
    }

}
