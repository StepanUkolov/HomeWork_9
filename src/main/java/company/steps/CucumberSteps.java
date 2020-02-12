package company.steps;

import cucumber.api.DataTable;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;

public class CucumberSteps {

    ContributionsPageSteps contributionsPageSteps = new ContributionsPageSteps();

    @Когда("^Заполняются поля$")
    public void fillField(DataTable dataTable) {
        dataTable.asMap(String.class, String.class)
                .forEach((fieldName, value) -> contributionsPageSteps.fillField((String) fieldName, (String) value));
    }

    @Тогда("^Проверяем результат$")
    public void checkResult(DataTable dataTable) {
        BaseSteps.takeScreenshot();
        String value = (String) dataTable.asMap(String.class, String.class).get("Ожидаемая сумма к снятию");
        contributionsPageSteps.checkResult(value.replaceAll("\u20BD", "").trim());
    }
}
