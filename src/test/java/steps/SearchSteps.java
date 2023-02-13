package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObjects.MasterPage;
import pageObjects.products.ProductListPage;
import utils.TestContext;

public class SearchSteps {

    TestContext context;
    MasterPage homePage;
    ProductListPage productListPage;

    public SearchSteps(TestContext context){
        this.context = context;
        homePage = new MasterPage(context.getDriver());
    }
    @Given("I am on Home page")
    public void i_am_on_home_page(){

    }
    @When("I search a keyword")
    public void i_search_a_keyword() {
        productListPage = homePage.searchProduct("Winter coat");
    }
    @Then("I see the result")
    public void i_see_the_result() {

        Assert.assertTrue(productListPage.getSearchResult().contains("Winter coat"));
    }
}
