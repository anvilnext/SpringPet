package com.springpet.steps;

import com.springpet.basesteps.DriverBaseSteps;
import com.springpet.models.ui.UserSwag;
import com.springpet.pages.HomePage;
import com.springpet.pages.ProductPage;
import com.springpet.pages.ShoppingCartPage;
import com.springpet.FrameworkConfiguration;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = FrameworkConfiguration.class)
public class UITestsSteps {

    @Autowired
    private DriverBaseSteps driverBaseSteps;

    @Autowired
    private HomePage homePage;

    @Autowired
    private ProductPage mainPage;

    @Autowired
    private ShoppingCartPage shoppingCartPage;

    @Before
    public void maximizeDriver() {
        driverBaseSteps.maximizeDriver();
    }

    @Given("I opened Swag Labs homepage")
    public void openPage() {
        homePage.openHomePage();
    }

    @Given("I login with credentials:")
    public void loginToSite(UserSwag table) {
        homePage.login(table.getUsername(), table.getPassword());
    }

    @When("I add {string} to the Shopping Cart")
    public void addToCart(String productName) {
        mainPage.addToCart(productName);
    }

    @When("I open Shopping Cart")
    public void openShoppingCart() {
        mainPage.openShoppingCart();
    }

    @Then("I am on page URL ending in {string}")
    public void checkUrlEnding(String ending) {
        Assert.assertTrue(mainPage.checkUrlOnMainPage(ending));
    }

    @Then("{string} should be in the Shopping Cart")
    public void checkProductInCart(String name) {
        Assert.assertTrue(shoppingCartPage.checkProductIsInCart(name));
    }
}
