import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SortPageTestCase {

    @Test
    public void applesSortingOrderTestChrome(){
        SortPage sortPage = new SortPage();
        WebDriver driver = new ChromeDriver();
        System.out.println("" + sortPage.appleSorting(driver));
        Assert.assertTrue(sortPage.appleSorting(driver));
    }

    @Test
    public void applesSortingOrderTestFireFox(){
        SortPage sortPage = new SortPage();
        WebDriver driver = new FirefoxDriver();
        Assert.assertTrue(sortPage.appleSorting(driver));
    }
}
