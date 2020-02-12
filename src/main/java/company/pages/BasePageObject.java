package company.pages;

import company.steps.BaseSteps;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePageObject {
    public static WebDriverWait wait;

    public BasePageObject() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void selectItem(List<WebElement> itemsList, String itemName) {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (WebElement item : itemsList) {

            if (item.getText().equals(itemName)) {
                item.click();
                return;
            }
        }
    }

    public void fillField(WebElement field, String value) {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        field.sendKeys(value);
    }

    public void selectField(WebElement field, String value) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Select select = new Select(field);
        select.selectByVisibleText(value);
    }
}
