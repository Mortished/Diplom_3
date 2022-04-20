package page;

import static com.codeborne.selenide.Condition.visible;
import static java.time.Duration.ofSeconds;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProfilePage {

    @FindBy(how = How.XPATH, using = ".//button[text()='Выход']")
    private SelenideElement logoutButton;

    @FindBy(how = How.XPATH, using = ".//p[text()='В этом разделе вы можете изменить свои персональные данные']")
    private SelenideElement profileDescription;

    @FindBy(how = How.XPATH, using = ".//p[text()='Конструктор']")
    private SelenideElement constructorLink;

    @FindBy(how = How.XPATH, using = ".//div[@class='AppHeader_header__logo__2D0X2']")
    private SelenideElement logo;

    public void logout() {
        logoutButton.shouldBe(visible, ofSeconds(8)).click();
    }

    public boolean isProfilePage() {
        return profileDescription.shouldBe(visible, ofSeconds(8)).isDisplayed();
    }

    public void clickConstructorLink() {
        constructorLink.shouldBe(visible, ofSeconds(8)).click();
    }

    public void clickMainLogo() {
        logo.shouldBe(visible, ofSeconds(8)).click();
    }

}
