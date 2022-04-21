import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static io.restassured.RestAssured.given;

import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import page.RegistrationPage;
import pojo.LoginForm;

@Story("Регистрация пользователя")
public class RegistrationTest {

    private final String email = new DataGenerator().getRandomEmail();
    boolean isPositive;

    @Test
    @DisplayName("Регистрация пользователя")
    public void registerUser() {
        RegistrationPage registrationPage = open("https://stellarburgers.nomoreparties.site/register",
            RegistrationPage.class);
        registrationPage.registerNewUser("Test", email, Dictionary.PASSWORD);
        registrationPage.waitForLoadingLoginPage();
        Assert.assertEquals("Переход на форму логина не произведен", Dictionary.LOGIN_URL, url());
        isPositive = true;
    }

    @Test
    @DisplayName("Неуспешная регистрация пользователя")
    public void registerUserNegative() {
        RegistrationPage registrationPage = open("https://stellarburgers.nomoreparties.site/register",
            RegistrationPage.class);
        registrationPage.registerNewUser("Test", email,"Test");
        Assert.assertTrue("Отсутствует предупреждение системы", registrationPage.isWarningVisible());
    }

    @After
    public void cleanUp() {
        if (isPositive) {
            ValidatableResponse response = given()
                .header("Content-type", "application/json")
                .body(new LoginForm(email, Dictionary.PASSWORD))
                .when()
                .post("https://stellarburgers.nomoreparties.site/api/auth/login")
                .then();

            String token = response.extract().path("accessToken");

            given()
                .headers("Authorization", token,
                    "Content-type", "application/json")
                .when()
                .delete("https://stellarburgers.nomoreparties.site/api/auth/user")
                .then();
        }
    }
}
