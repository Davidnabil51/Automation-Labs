package POM.Levelset;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class GetPaid {

    WebDriver driver;
    public GetPaid(WebDriver driver)
    {
        this.driver=driver;
    }


    public String sendDocument()
    {

        By documentPrice_Selector = new By.ByXPath("//span[@class='price-amount'][contains(.,'$149')]");
        By sendDocument = new By.ByXPath("(//div[@class='panel panel--doc-type panel--selectable']/div[@class='panel-heading left-right-pair']/div[@class='left'])[3]");

        WebElement expectedElement =driver.findElement(sendDocument);
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(expectedElement));

        WebElement documentPrice = driver.findElement(documentPrice_Selector);
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(documentPrice));

        Assert.assertEquals(expectedElement.getText(),"Release a Lien","element not found");

        return documentPrice.getText();
    }

}
