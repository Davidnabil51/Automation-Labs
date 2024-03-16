
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Test1 {
    WebDriver webDriver;
    String item_price = "$29.99";
    String item_name = "Sauce Labs Backpack";
    String url = "https://www.saucedemo.com/";
    String username = "standard_user";
    String password = "secret_sauce";

@Test
    public void TestCase_No1(){

        webDriver = new FirefoxDriver();
        webDriver.get(url);
        By username_Selector = By.id("user-name");
        By Password_Selector = By.id("password");
        By submitButton_Selector = By.id("login-button");
        WebElement usernameInput = webDriver.findElement(username_Selector);
        WebElement passwordInput = webDriver.findElement(Password_Selector);
        WebElement submitButton = webDriver.findElement(submitButton_Selector);
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        submitButton.click();

        String locator = "//div[@class=\"inventory_item_name \" and contains(.,\"%s\")]";
        String.format(locator,item_name);

        //Validate the price
        By price_Selector = By.xpath("//div[@class=\"inventory_item_name \" and contains(.,\"Sauce Labs Backpack\")]/ancestor::div[@class=\"inventory_item\"]//following-sibling::div[@class=\"pricebar\"]/div");
        WebElement priceOfItem = webDriver.findElement(price_Selector);
        String foundPrice = priceOfItem.getAttribute("innerHTML");
        Assert.assertEquals(foundPrice,item_price,"Price Not Valid!");

        By addToCart_Selector = By.xpath("//div[@class=\"inventory_item_name \" and contains(.,\"Sauce Labs Backpack\")]/ancestor::div[@class=\"inventory_item\"]//following-sibling::div[@class=\"pricebar\"]/button");
        WebElement addToCartButton = webDriver.findElement(addToCart_Selector);
        addToCartButton.click();


        By cartLink_Selector = By.className("shopping_cart_link");
        WebElement cartLink = webDriver.findElement(cartLink_Selector);
        cartLink.click();





    }
}