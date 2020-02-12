package company.pages;

import company.steps.BaseSteps;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage extends BasePageObject {
    public MainPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='nav']//div[@class='nav__item']/a")
    private List<WebElement> mainMenuItems;

    public void selectMenuItem(String itemName) {
        selectItem(mainMenuItems, itemName);
    }
}
