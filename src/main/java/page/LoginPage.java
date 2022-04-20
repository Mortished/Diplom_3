package page;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static java.time.Duration.ofSeconds;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import java.time.Duration;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

    @FindBy(how = How.XPATH, using = ".//input")
    private ElementsCollection fields;

    @FindBy(how = How.XPATH, using = ".//button[text()='Войти']")
    private SelenideElement registerButton;

    @FindBy(how = How.XPATH, using = ".//h2[text()='Вход']")
    private SelenideElement enterLabel;

    public void login(String email, String password) {
        fields.get(0).click();
        fields.get(0).setValue(email);
        fields.get(1).click();
        fields.get(1).setValue(password);
        registerButton.click();
    }

    public boolean waitForLoadMainPage() {
        return $(byText("Соберите бургер"))
            .shouldBe(Condition.visible, Duration.ofSeconds(8)).isDisplayed();
    }

    public boolean isLoginPage() {
        return enterLabel.shouldBe(visible, ofSeconds(8)).isDisplayed();
    }
}
