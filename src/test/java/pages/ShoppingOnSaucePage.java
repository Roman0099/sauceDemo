package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class ShoppingOnSaucePage {
    public ShoppingOnSaucePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(id = "user-name")
    public WebElement userNameInput;

    @FindBy(id = "password")
    public WebElement userPasswordInput;

    @FindBy(id = "login-button")
    public WebElement loginBtn;

    @FindBy(xpath = "//select[@class='product_sort_container']")
    public WebElement priceDropdown;

    @FindBy(xpath = "//div[@class='inventory_container']/div/div//button")
    public List<WebElement> addToCartInventory;

    @FindBy(id = "shopping_cart_container")
    public WebElement shoppingCart;

    @FindBy(id = "add-to-cart-sauce-labs-onesie")
    public WebElement addToCartOnesie;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    public WebElement addToCartBikeLight;

   @FindBy(xpath = "//div[@class='cart_list']")
    public WebElement cartList;

   @FindBy(xpath = "//a[@id='item_2_title_link']")
    public WebElement sauceLabOnesie;

   @FindBy(xpath = "//a[@id='item_0_title_link']")
    public WebElement bikeLight;

   @FindBy(xpath = "//button[@id='remove-sauce-labs-bike-light']")
    public WebElement removeBikeLight;

   @FindBy(id = "continue-shopping")
    public WebElement continueShoppingBtn;

   @FindBy(id = "add-to-cart-sauce-labs-backpack")
    public WebElement backPack;

   @FindBy(id = "item_4_title_link")
    public WebElement itemAddedBackPack;

   @FindBy(id = "checkout")
    public WebElement checkoutBtn;

   @FindBy(id = "first-name")
    public WebElement firstNameInputField;

   @FindBy(id = "last-name")
    public WebElement lastNameInputField;

   @FindBy(id = "postal-code")
    public WebElement zipCodeField;

   @FindBy(id = "continue")
    public WebElement continueBtn;

   @FindBy(xpath = "//div[@class='summary_total_label']")
    public WebElement totalPrice;

   @FindBy(id = "finish")
    public WebElement finishBtn;









}
