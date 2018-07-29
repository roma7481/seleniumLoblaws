import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SortPageTestCase {

    private static final String APPLES = "apples";
    private static final String POMMES = "pommes";
    private static final String FRENCH = "FR";
    private static final String ENGLISH = "EN";

    @Test
    public void applesSortingOrderChromeEnglishTest() {
        validateItemSortingForLanguage(new ChromeDriver(), APPLES, ENGLISH);
    }

    @Test
    public void applesSortingOrderChromeFrenchTest() {
        validateItemSortingForLanguage(new ChromeDriver(), POMMES, FRENCH);
    }

    @Test
    public void applesSortingOrderFireFoxEnglishTest() {
        validateItemSortingForLanguage(new FirefoxDriver(), APPLES, ENGLISH);
    }

    @Test
    public void applesSortingOrderFireFoxFrenchTest() {
        validateItemSortingForLanguage(new FirefoxDriver(), POMMES, FRENCH);
    }

    private void validateItemSortingForLanguage(WebDriver driver, String itemName, String language) {
        SortPageValidator sortPageValidator = new SortPageValidator(driver);
        Assert.assertTrue(sortPageValidator.appleSortingVerification(itemName, language));
        driver.quit();
    }
}
