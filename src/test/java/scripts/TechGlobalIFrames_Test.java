package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalFrontendTestingHomePage;
import pages.TechGlobalIFramesPage;

import java.util.stream.IntStream;

public class TechGlobalIFrames_Test extends TechGlobalBase {

    /*
Go to https://techglobal-training.netlify.app/
Click on “Practices” dropdown in the header
Select the “Frontend Testing” option
Click on the “IFrames” card
Validate the “Please fill out your information below” text
     */


    @BeforeMethod
    public void setPage() {
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalIFramesPage = new TechGlobalIFramesPage();
        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard("IFrames");

    }

    @Test(priority = 1, description = "Validating input header text")
    public void validateInputText() {

        driver.switchTo().frame(techGlobalIFramesPage.iFrameId);

        // Assert.assertTrue(techGlobalIFramesPage.headingText.isDisplayed());
        Assert.assertEquals(techGlobalIFramesPage.headingText.getText(), "Please fill out your information below");

    }

    /*
    Go to https://techglobal-training.netlify.app/
    Click on “Practices” dropdown in the header
    Select the “Frontend Testing” option
    Click on the “IFrames” card
    Enter “John” to first name input box
    Enter “Doe” to last name input box
    Click on “SUBMIT” button
    Validate the result equals “You entered: John Doe”
     */

    @Test(priority = 2, description = "Enter user input and validate the result")
    public void userInput() {
        driver.switchTo().frame(techGlobalIFramesPage.iFrameId);

        String[] credentials = {"John", "Doe"};

        IntStream.range(0, credentials.length).forEach(i -> techGlobalIFramesPage.inputFields.get(i).sendKeys(credentials[i]));
        techGlobalIFramesPage.submitButton.click();

        driver.switchTo().defaultContent();

        Assert.assertEquals(techGlobalIFramesPage.resultText.getText(), "You entered: " + credentials[0] + " " + credentials[1]);
    }
}