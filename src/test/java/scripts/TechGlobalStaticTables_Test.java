package scripts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalFrontendTestingHomePage;
import pages.TechGlobalStaticTablesPage;
import utilities.TableData;

import java.util.List;
import java.util.stream.IntStream;

public class TechGlobalStaticTables_Test extends TechGlobalBase{

    /**
     * Verify the headers of the table
     * Go to https://techglobal-training.netlify.app/
     * Click on “Practices” dropdown in the header
     * Select the “Frontend Testing” option
     * Click on the “Static Tables” card
     * Check that the headers of the table are “Rank”, “Company”, “Employees”, and “Country”
     * Verify the rows of the table
     */

    @BeforeMethod
    public void setPage() {

        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalStaticTablesPage = new TechGlobalStaticTablesPage();
        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard("Static Tables");
    }

    @Test(priority = 1, description = "Validate Static Tables")
    public void validateStaticTables() {

        String[] actualTexts = {"Rank", "Company", "Employees", "Country"};

            /*
        for (int i = 0; i < actualTexts.length; i++) {

            Assert.assertEquals(techGlobalStaticTablesPage.tableHeader.get(i).getText(), actualTexts[i]);
        }
             */
/*
        IntStream.range(0, actualTexts.length).forEach
                (i -> {
                    System.out.println(techGlobalStaticTablesPage.tableHeader.get(i).getText());
                    Assert.assertEquals(techGlobalStaticTablesPage.tableHeader.get(i).getText(), actualTexts[i])
              });


 */
    }

    /**
     * Go to https://techglobal-training.netlify.app/
     * Click on “Practices” dropdown in the header
     * Select the “Frontend Testing” option
     * Click on the “Static Tables” card
     * Check that first row of the table has the values “1", “Amazon”, “1,523,000", and “USA”
     * Verify the columns of the table
     */

    @Test(priority = 2, description = "Validate first row of the table")
    public void validateRow() {

        String[] rowData = {"1", "Amazon", "1,523,000", "USA"};
        List<WebElement> tableRow = TableData.getTableRow(driver, 1);

        for (int i = 0; i < tableRow.size(); i++) {
            Assert.assertEquals(tableRow.get(i).getText(), rowData[i]);
        }
        }

    /**
     * Go to https://techglobal-training.netlify.app/
     * Click on “Practices” dropdown in the header
     * Select the “Frontend Testing” option
     * Click on the “Static Tables” card
     * Check that the “Country” column of the table has the values “USA”, “China”, “USA”, “USA”, “S. Korea”
     * Verify the entire table
      */

    @Test(priority = 3, description = "Validate Country Column Of The Table")
    public void validateCountryColumn() {

        String[] columnData = {"USA", "China", "USA", "USA", "S.Korea"};
        List<WebElement> countryColumn = TableData.getTableColumn(driver, 4);

        for (int i = 0; i < columnData.length; i++) {
            Assert.assertEquals(countryColumn.get(i).getText(), columnData[i]);
        }

        IntStream.range(0, columnData.length).forEach(i -> {
            System.out.println(countryColumn.get(i).getText());
            Assert.assertEquals(countryColumn.get(i).getText(), columnData[i]);
                }
        );

    }

    @Test(priority = 4, description = "Validate all cells")
    public void validateAllCells() {

        List<List<WebElement>> tableData = techGlobalStaticTablesPage.getTableData();

        for (int i = 0; i < tableData.size(); i++) {
            for (int j = 0; j < tableData.get(i).size(); j++) {

                System.out.println(tableData.get(i).get(j).getText());
            }
        }
    }
}

