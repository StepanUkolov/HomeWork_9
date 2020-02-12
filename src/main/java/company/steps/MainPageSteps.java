package company.steps;

import company.pages.MainPage;
import cucumber.api.java.ru.Когда;

public class MainPageSteps {

    MainPage mainPage = new MainPage();

    @Когда("^Выбран пункт главного меню \"(.*)\"$")
    public void selectMenuItem(String itemName) {
        BaseSteps.scrollDown();
        mainPage.selectMenuItem(itemName);
    }
}
