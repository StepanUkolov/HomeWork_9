package company.steps;

import company.pages.ContributionsPage;
import cucumber.api.java.ru.Когда;
import ru.yandex.qatools.allure.annotations.Step;

public class ContributionsPageSteps {

    ContributionsPage contributionsPage = new ContributionsPage();

    @Когда("^Выбрана валюта \"(.*)\"$")
    public void selectCurrency(String itemName) {
        contributionsPage.selectCurrency(itemName);
    }

    @Step("Поле {0} заполняется значением {1}")
    public void fillField(String fieldName, String value) {
        contributionsPage.fillField(fieldName, value);
    }

    @Когда("^Отмечено \"(.*)\"$")
    public void checkBox(String itemName) {
        contributionsPage.checkBox(itemName);
    }

    @Step("Ожидаемое значение {0} ")
    public void checkResult(String value) {
        contributionsPage.checkResult(value);
    }

}
