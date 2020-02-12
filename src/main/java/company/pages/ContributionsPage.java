package company.pages;

import company.steps.BaseSteps;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ContributionsPage extends BasePageObject {
    public ContributionsPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    @FindBy(xpath = "//label[@class='calculator__currency-field']//span[@class='calculator__currency-field-text']")
    private List<WebElement> currency;

    @FindBy(xpath = "//label[@class='calculator__slide-input-label']")
    private List<WebElement> inputFields;

    @FindBy(xpath = "//span[@class='calculator__check-text']")
    private List<WebElement> checkBoxs;

    @FindBy(xpath = "//span[@class='js-calc-result']")
    private WebElement result;

    public void selectCurrency(String itemName) {
        selectItem(currency, itemName);
    }

    public void fillField(String fieldName, String value) {
        //Здесь такая лажа, потому что я так и не смог обойти исключение NoSuchElement,
        //а работать с красивой таблицей все равно хочется

        for (WebElement field : inputFields) {

            if (field.getText().equals(fieldName)) {

                if (fieldName.equals("Сумма вклада")) {
                    fillField(field.findElement(By.xpath("./..//input")), value);
                }else if (fieldName.equals("Ежемесячное пополнение")) {
                    fillField(field.findElement(By.xpath("./..//input")), value);
                }else if (fieldName.equals("На срок")) {
                    selectField(field.findElement(By.xpath("./..//select")), value);
                }
            }
        }

        //Изначальная задумка примерно такая:

//        for (WebElement field : inputFields){
//
//            if (field.getText().equals(fieldName)){
//
//                if (field.findElement(By.xpath("./..//input")).isDisplayed()) {
//                    fillField(field.findElement(By.xpath("./..//input")), value);
//
//                } else if (field.findElement(By.xpath("./..//select")).isDisplayed()) {
//                    selectField(field.findElement(By.xpath("./..//select")), value);
//                }
//            }
//        }

    }

    public void checkBox(String itemName) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (WebElement element : checkBoxs) {
            if (element.getText().equals(itemName) && !element.isSelected()) {
                element.click();
            }
        }
    }

    public void checkResult(String value) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(
                String.format("К снятию [%s]. Ожидалось - [%s]", result.getText(), value),
                value, result.getText());
    }
}
