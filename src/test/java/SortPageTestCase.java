import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SortPageTestCase {

    private static final String APPLES = "apples";
    private static final String POMMES = "pommes";
    private static final String FRENCH = "FR";
    private static final String ENGLISH = "EN";
    private static final int width = 600;
    private static final int height  = 480;


    @Test
    public void applesSortingOrderChromeEnglishTest() {
        validateItemSortingForLanguage(new ChromeDriver(), APPLES, ENGLISH);
    }

    @Test
    public void applesSortingOrderChromeFrenchTest() {
        validateItemSortingForLanguage(new ChromeDriver(), POMMES, FRENCH);
    }

    @Test
    public void applesSortingOrderChromeEnglishTestSmallScreen() {
        validateItemSortingForLanguageSmallScreenSize(new ChromeDriver(), APPLES, ENGLISH,width,height);
    }

    @Test
    public void applesSortingOrderChromeFrenchTestSmallScreen() {
        validateItemSortingForLanguageSmallScreenSize(new ChromeDriver(), APPLES, FRENCH,width,height);
    }
    @Ignore
    public void applesSortingOrderFireFoxEnglishTest() {
        validateItemSortingForLanguage(new FirefoxDriver(), APPLES, ENGLISH);

    }
    @Ignore
    public void applesSortingOrderFireFoxFrenchTest() {
        validateItemSortingForLanguage(new FirefoxDriver(), POMMES, FRENCH);
    }

    @Ignore
    public void applesSortingOrderFireFoxEnglishTestSmallScreen() {
        validateItemSortingForLanguageSmallScreenSize(new FirefoxDriver(), APPLES, ENGLISH,width,height);
    }

    @Ignore
    public void applesSortingOrderFireFoxFrenchTestSmallScreen() {
        validateItemSortingForLanguageSmallScreenSize(new FirefoxDriver(), APPLES, FRENCH,width,height);
    }
    private void validateItemSortingForLanguage(WebDriver driver, String itemName, String language) {
        SortPageValidator sortPageValidator = new SortPageValidator(driver);
        Assert.assertTrue(sortPageValidator.appleSortingVerification(itemName, language));
        driver.quit();
    }

    private void validateItemSortingForLanguageSmallScreenSize(WebDriver driver, String itemName, String language, int x, int y) {
        SortPageValidator sortPageValidator = new SortPageValidator(driver);
        Assert.assertTrue(sortPageValidator.appleSortingVerificationSmallScreen(itemName, language,x,y));
        driver.quit();
    }
}
