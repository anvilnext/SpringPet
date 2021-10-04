package com.springpet.steps;

import com.springpet.basesteps.DriverBaseSteps;
import com.springpet.models.ui.UserSwag;
import com.springpet.pages.HomePage;
import com.springpet.pages.ProductPage;
import com.springpet.pages.ShoppingCartPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class UITestsSteps {

    private HomePage homePage = new HomePage();
    private ProductPage mainPage = new ProductPage();
    private ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

    @Before
    public static void ma() {
        DriverBaseSteps.maximizeDriver();
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

    @After
    public static void after_all() {
        DriverBaseSteps.quitDriver();
    }
}
