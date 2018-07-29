import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuperStorePage {

    private WebDriver driver;
    private ManageDriver manageDriver;
    private static final String URL = "https://www.realcanadiansuperstore.ca";
    private static final String searchBarId = "search-bar";
    private static final String dealBadgeClassName = "deal-badge";
    private static final String ontarioXPATH = "//li[4]/button"; //Ontario

    SuperStorePage(WebDriver driver) {
        this.driver = driver;
        manageDriver = new ManageDriver(driver);
    }

    public boolean verifyDealBadge(String keyWordToSearch) {
        manageDriver.openWebSiteMaximizeWindow(URL);
        manageDriver.waitJqueryDone();
        selectProvince(ontarioXPATH);
        manageDriver.waitJqueryDone();
        manageDriver.searchKeyWordInSearchBar(keyWordToSearch, searchBarId);
        manageDriver.waitJqueryDone();
        return driver.findElement(By.className(dealBadgeClassName)) != null;
    }

    private void selectProvince(String province) {
        driver.findElement(By.xpath(province)).click();
    }
}
