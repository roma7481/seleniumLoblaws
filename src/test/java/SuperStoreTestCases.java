import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SuperStoreTestCases {

    private static final String ORANGES = "oranges";

    @Test
    public void applesSortingOrderTestChrome(){
        WebDriver driver = new ChromeDriver();
        SuperStorePage superStorePage = new SuperStorePage(driver);
        Assert.assertTrue(superStorePage.verifyDealBadge(ORANGES));
        driver.quit();

    }
}
