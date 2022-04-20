package page;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static java.time.Duration.ofSeconds;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
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
        return $(byXpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Булки']"))
            .shouldBe(visible, ofSeconds(8)).isDisplayed();
    }

    public boolean isSauseTransferWork() {
        return $(byXpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Соусы']"))
            .shouldBe(visible, ofSeconds(8)).isDisplayed();
    }

    public boolean isIngredientsTransferWork() {
        return $(byXpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Начинки']"))
            .shouldBe(visible, ofSeconds(8)).isDisplayed();
    }

}
