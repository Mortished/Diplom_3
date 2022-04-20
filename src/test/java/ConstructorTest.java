import static com.codeborne.selenide.Selenide.open;

import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import page.MainPage;

@Story("Раздел «Конструктор»")
public class ConstructorTest {
    MainPage mainPage;

    @Test
    @DisplayName("Проверка перехода к разделу «Булки»")
    public void constructorBunTransfer() {
        mainPage = open(Dictionary.MAIN_URL, MainPage.class);
        mainPage.clickConstructorIngredients();
        mainPage.clickConstructorBun();
        Assert.assertTrue(mainPage.isBunTransferWork());
    }

    @Test
    @DisplayName("Проверка перехода к разделу «Соусы»")
    public void constructorSauseTransfer() {
        mainPage = open(Dictionary.MAIN_URL, MainPage.class);
        mainPage.clickConstructorSause();
        Assert.assertTrue(mainPage.isSauseTransferWork());
    }

    @Test
    @DisplayName("Проверка перехода к разделу «Начинки»")
    public void constructorIngredientsTransfer() {
        mainPage = open(Dictionary.MAIN_URL, MainPage.class);
        mainPage.clickConstructorIngredients();
        Assert.assertTrue(mainPage.isIngredientsTransferWork());
    }
}
