package page;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static java.time.Duration.ofSeconds;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegistrationPage {

    @FindBy(how = How.XPATH, using = ".//input")
    private ElementsCollection fields;

    @FindBy(how = How.XPATH, using = ".//button[text()='Зарегистрироваться']")
    private SelenideElement registerButton;

    @FindBy(how = How.XPATH, using = ".//p[text()='Некорректный пароль']")
    private SelenideElement registrationWarning;

    @FindBy(how = How.LINK_TEXT, using = "Войти")
    private SelenideElement loginLink;

    public void registerNewUser(String name, String email, String password) {
        fields.get(0).click();
        fields.get(0).setValue(name);
        fields.get(1).click();
        fields.get(1).setValue(email);
        fields.get(2).click();
        fields.get(2).setValue(password);
        registerButton.click();
    }

    public void waitForLoadingLoginPage() {
        $(byText("Вход")).shouldBe(Condition.visible, ofSeconds(8));
    }

    public boolean isWarningVisible() {
        return registrationWarning.isDisplayed();
    }

    public LoginPage goToLoginPage() {
        loginLink.click();
        return Selenide.page(LoginPage.class);
    }

}
