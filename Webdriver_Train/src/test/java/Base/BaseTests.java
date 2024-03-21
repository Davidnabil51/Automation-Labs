package Base;
import POM.Levelset.GetPaid;
import POM.Levelset.Homepage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BaseTests {
    WebDriver driver = new FirefoxDriver();
    Homepage home = new Homepage(driver);
    GetPaid getPaid = new GetPaid(driver);

    @Test
    public void Test1()
    {
        home.navigateHome();
        home.clickOnGetPaid();
        Assert.assertEquals(getPaid.sendDocument(),"$149","Price is not the same");



    }


}
