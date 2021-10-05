package com.springpet.steps;

import com.springpet.models.ui.UserSwag;
import com.springpet.pages.HomePage;
import com.springpet.pages.ProductPage;
import com.springpet.pages.ShoppingCartPage;
import com.springpet.FrameworkConfiguration;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import org.junit.Assert;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = FrameworkConfiguration.class)
@RequiredArgsConstructor
public class UITestsSteps {

    private HomePage homePage;
    private ProductPage mainPage;
    private ShoppingCartPage shoppingCartPage;

    /*@Before
    public static void maximizeDriver() {
        DriverBaseSteps.maximizeDriver();
    }*/

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

    /*@After
    public static void quitDriver() {
        DriverBaseSteps.quitDriver();
    }*/
}
