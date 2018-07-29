import com.google.common.collect.Ordering;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SortPageValidator {

    private WebDriver driver;
    private ManageDriver manageDriver;
    private static final String URL = "https://www.loblaws.ca";
    private static final String FRENCH = "FR";
    private static final String moreButtonCSSSelector = "button.btn-inline-link.btn-show-more";
    private static final String pricesClassNameSelector = "reg-price-text";
    private static final String searchBarId = "search-bar";
    private static final String sortFromHighToLowXPath = "//div[3]/div/ul/li[3]/button";

    SortPageValidator(WebDriver driver) {
        this.driver = driver;
        manageDriver = new ManageDriver(this.driver);
    }

    public boolean appleSortingVerification(String keyWordToSearch, String language) {
        manageDriver.openWebSiteMaximizeWindow(URL);
        if (language.equals(FRENCH)) {
            driver.findElement(By.linkText(FRENCH)).click();
        }
        manageDriver.searchKeyWordInSearchBar(keyWordToSearch, searchBarId);
        driver.findElement(By.xpath(sortFromHighToLowXPath)).click();
        manageDriver.waitJqueryDone();
        loadAllItems(driver.findElement(By.cssSelector(moreButtonCSSSelector)));
        List<WebElement> list = driver.findElements(By.className(pricesClassNameSelector));
        List<Double> prices = new ArrayList<>();
        list.forEach(e -> prices.add(getPrice(e)));
        return Ordering.natural().reverse().isOrdered(prices);
    }

    private void loadAllItems(WebElement moreItemsButton) {
        while (moreItemsButton.isDisplayed()) {
            manageDriver.scrollDown();
            moreItemsButton.click();
            manageDriver.waitJqueryDone();
        }
    }

    private Double getPrice(WebElement e) {
        return Double.valueOf(e.getText().replace("$", "").replace(",", "."));
    }
}
