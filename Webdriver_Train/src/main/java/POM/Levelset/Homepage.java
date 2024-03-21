package POM.Levelset;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;


public class Homepage {
    WebDriver driver;
    String homepageUrl = "https://www.levelset.com/";
    By getPaid_Selector = new By.ByXPath("//nav[@class='main-nav-box']/ul/li[@class='top-level-link ml-sm-05 mr-sm-05 relative ml-0']");

    public Homepage(WebDriver driver) {
        this.driver = driver;
    }


    public void navigateHome(){
        driver.get(homepageUrl);
        WebElement expectedElement = driver.findElement(getPaid_Selector);
        WebDriverWait waitForHomePage = new WebDriverWait(driver, Duration.ofSeconds(30));
        waitForHomePage.until(ExpectedConditions.visibilityOf(expectedElement));
        Assert.assertEquals(expectedElement.getText(),"Get paid","element not found");
    }

    public GetPaid clickOnGetPaid(){

        WebElement getPaidButton= driver.findElement(getPaid_Selector);
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(getPaidButton));

        getPaidButton.click();
        return new GetPaid(driver);
    }

}
