package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class TechGlobalRadioButtonsPage extends TechGlobalBasePage{

    /*
    Go to https://techglobal-training.netlify.app/
    Click on "Practices" dropdown in the header
    Select the "Frontend Testing" option
    Click on the "Radio Buttons" card
    Validate "Java", "JavaScript" and "C#" radio buttons are displayed, enabled and not selected
    Select "Java" and validate it is selected but the other 2 are deselected
    Select "JavaScript" validate it is selected but the other 2 are deselected

     */



    public TechGlobalRadioButtonsPage() {
        super();
    }

    @FindBy(css = "#radio-button-group_1 label")
    public List<WebElement> radioButtonLabel;

    @FindBy(css = "#radio-button-group_1 input")
    public List<WebElement> radioButtonInput;


    @FindBy(css = "#radio-button-group_2 label")
    public List<WebElement> radioButtonLabel2;

    @FindBy(css = "#radio-button-group_2 input")
    public List<WebElement> radioButtonInput2;
}
