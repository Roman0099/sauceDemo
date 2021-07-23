package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.ShoppingOnSaucePage;
import utilities.Config;
import utilities.Driver;

import java.util.List;

public class ShoppingOnSauce_StepDefs {
    private ShoppingOnSaucePage shoppingOnSaucePage = new ShoppingOnSaucePage();

    @Given("user is logged in into the site")
    public void user_is_logged_in_into_the_site() {
        Driver.getDriver().get(Config.getProperty("sauceUrl"));
        shoppingOnSaucePage.userNameInput.sendKeys(Config.getProperty("userName"));
        shoppingOnSaucePage.userPasswordInput.sendKeys(Config.getProperty("userPassword"));
        shoppingOnSaucePage.loginBtn.click();
    }
    @When("user is on landing page")
    public void user_is_on_landing_page() {
        String actualUrl = Driver.getDriver().getCurrentUrl();
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(actualUrl,expectedUrl);

    }
    @And("user should be able to select {string} from dropdown")
    public void userShouldBeAbleToSelectFromDropdown(String selectedValue){
        Select select = new Select(shoppingOnSaucePage.priceDropdown);
        select.selectByValue(selectedValue);
    }

    @When("user should be able to add multiple items to shopping cart")
    public void user_should_be_able_to_add_multiple_items_to_shopping_cart() {
        WebElement bikeLight = shoppingOnSaucePage.addToCartBikeLight;
        bikeLight.click();
        WebElement onesie = shoppingOnSaucePage.addToCartOnesie;
        onesie.click();

        }

    @Then("user clicks on shopping cart")
    public void user_clicks_on_shopping_cart() {
        shoppingOnSaucePage.shoppingCart.click();

    }
    @Then("user should verify items selected are present in the cart")
    public void user_should_verify_items_selected_are_present_in_the_cart() {
        String actualValue = shoppingOnSaucePage.bikeLight.getText();
        String expectedValue = "Sauce Labs Bike Light";
        Assert.assertEquals(expectedValue,actualValue);
        String actualValue1 = shoppingOnSaucePage.sauceLabOnesie.getText();
        String expectedValue1 = "Sauce Labs Onesie";
        Assert.assertEquals(expectedValue1,actualValue1);
    }
    @Then("user removes item from cart")
    public void user_removes_item_from_cart() {
        shoppingOnSaucePage.removeBikeLight.click();

    }
    @Then("user continue shopping")
    public void user_continue_shopping() {
        shoppingOnSaucePage.continueShoppingBtn.click();

    }
    @Then("user add another item to the cart and select checkout button")
    public void user_add_another_item_to_the_cart_and_select_checkout_button() {
        shoppingOnSaucePage.backPack.click();
        shoppingOnSaucePage.shoppingCart.click();
        String actualItemAdded = shoppingOnSaucePage.itemAddedBackPack.getText();
        String expectedItemAdded = "Sauce Labs Backpack";
        Assert.assertEquals(expectedItemAdded,actualItemAdded);
        shoppingOnSaucePage.checkoutBtn.click();
        shoppingOnSaucePage.firstNameInputField.sendKeys("Roman");
        shoppingOnSaucePage.lastNameInputField.sendKeys("Yusupov");
        shoppingOnSaucePage.zipCodeField.sendKeys("60634");
        shoppingOnSaucePage.continueBtn.click();

    }
    @Then("user should verify items purchased are correct")
    public void user_should_verify_items_purchased_are_correct() {
        Assert.assertTrue(shoppingOnSaucePage.sauceLabOnesie.isDisplayed());
        Assert.assertTrue(shoppingOnSaucePage.itemAddedBackPack.isDisplayed());


    }
    @Then("user verifies total price is correct")
    public void user_verifies_total_price_is_correct() {
        String actualAmount = shoppingOnSaucePage.totalPrice.getText();
        String expectedAmount = "Total: $41.02";
        Assert.assertEquals(expectedAmount,actualAmount);

    }
    @Then("user clicks on checkout button")
    public void user_clicks_on_checkout_button() {
        shoppingOnSaucePage.finishBtn.click();

    }



}
