package page;

import static com.codeborne.selenide.Condition.visible;
import static java.time.Duration.ofSeconds;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import java.time.Duration;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class MainPage {

    @FindBy(how = How.XPATH, using = ".//button[text()='Войти в аккаунт']")
    private SelenideElement loginButton;

    @FindBy(how = How.XPATH, using = ".//p[text()='Личный Кабинет']")
    private SelenideElement profileLink;

    @FindBy(how = How.XPATH, using = ".//span[text()='Булки']")
    private SelenideElement constructorBun;

    @FindBy(how = How.XPATH, using = ".//span[text()='Соусы']")
    private SelenideElement constructorSause;

    @FindBy(how = How.XPATH, using = ".//span[text()='Начинки']")
    private SelenideElement constructorIngredients;

    @FindBy(how = How.XPATH, using = ".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Булки']")
    private SelenideElement constructorBunTap;

    @FindBy(how = How.XPATH, using = ".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Соусы']")
    private SelenideElement constructorSauseTap;

    @FindBy(how = How.XPATH, using = ".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Начинки']")
    private SelenideElement constructorIngredientsTap;

    @FindBy(how = How.XPATH, using = ".//h1[text()='Соберите бургер']")
    private SelenideElement mainLabel;

    public LoginPage loginButtonClick() {
        loginButton.click();
        return Selenide.page(LoginPage.class);
    }

    public ProfilePage profileButtonClick() {
        profileLink.click();
        return Selenide.page(ProfilePage.class);
    }

    public void clickConstructorBun() {
        constructorBun.shouldBe(visible).click();
    }

    public void clickConstructorSause() {
        constructorSause.shouldBe(visible).click();
    }

    public void clickConstructorIngredients() {
        constructorIngredients.shouldBe(visible).click();
    }

    public boolean isBunTransferWork() {
        return constructorBunTap.shouldBe(visible, ofSeconds(8)).isDisplayed();
    }

    public boolean isSauseTransferWork() {
        return constructorSauseTap.shouldBe(visible, ofSeconds(8)).isDisplayed();
    }

    public boolean isIngredientsTransferWork() {
        return constructorIngredientsTap.shouldBe(visible, ofSeconds(8)).isDisplayed();
    }

    public boolean isMainPageLoaded() {
        return mainLabel.shouldBe(Condition.visible, Duration.ofSeconds(8)).isDisplayed();
    }

}
