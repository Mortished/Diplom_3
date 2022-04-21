package page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ForgotPasswordPage {

    @FindBy(how = How.LINK_TEXT, using = "Войти")
    private SelenideElement loginLink;

    public LoginPage goToLoginPage() {
        loginLink.click();
        return Selenide.page(LoginPage.class);
    }

}
