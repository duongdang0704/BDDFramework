package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObjects.MasterPage;
import pageObjects.products.ProductListPage;
import utils.TestContext;

import java.util.Map;

public class NavigationSteps {
    TestContext context;
    MasterPage masterPage;
    ProductListPage productListPage;

    public NavigationSteps(TestContext context){
        this.context = context;
        masterPage = new MasterPage(context.getDriver());
    }

    @When("I click on menu {string}")
    public void iClickOnMenu(String menu) {
        productListPage = masterPage.gotoPage(menu);
    }

    @Then("I see the product list of this category {string}")
    public void iSeeTheProductListOfThisCategory(String category) {
        Assert.assertEquals(category, productListPage.getHeading());
    }

    @And("I filter these options")
    public void iFilterTheseOptions(DataTable dataTable) {

        Map<String, String> filterOptions = dataTable.asMap();
        productListPage.setFilters(filterOptions);
    }

    @Then("I see the product list of these filters")
    public void iSeeTheProductListOfTheseFilters() {
    }
}
