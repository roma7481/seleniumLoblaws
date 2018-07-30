import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SuperStoreTestCases {

    private static final String ORANGES = "oranges";
    private static final int width = 600;
    private static final int height  = 600;

    @Test
    public void applesSortingOrderTestChrome(){
        WebDriver driver = new ChromeDriver();
        SuperStorePage superStorePage = new SuperStorePage(driver);
        Assert.assertTrue(superStorePage.verifyDealBadge(ORANGES));
        driver.quit();
    }
    @Test
    public void applesSortingOrderTestChromeSmallScreen(){
        WebDriver driver = new ChromeDriver();
        SuperStorePage superStorePage = new SuperStorePage(driver);
        Assert.assertTrue(superStorePage.verifyDealBadgeSmallScreen(ORANGES,width,height));
        driver.quit();
    }
    @Ignore
    public void applesSortingOrderTestFireFox(){
        WebDriver driver = new FirefoxDriver();
        SuperStorePage superStorePage = new SuperStorePage(driver);
        Assert.assertTrue(superStorePage.verifyDealBadge(ORANGES));
        driver.quit();
    }
    @Ignore
    public void applesSortingOrderTestFireFoxSmallScreen(){
        WebDriver driver = new FirefoxDriver();
        SuperStorePage superStorePage = new SuperStorePage(driver);
        Assert.assertTrue(superStorePage.verifyDealBadgeSmallScreen(ORANGES,width,height));
        driver.quit();
    }
}
