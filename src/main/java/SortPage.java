import com.google.common.collect.Ordering;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SortPage {

    private WebDriver driver;
    private ManageDriver manageDriver;
    public SortPage(WebDriver driver){
        this.driver = driver;
        manageDriver = new ManageDriver(this.driver);
    }
    public boolean appleSorting(String keyWordToSearch,String language){
        String url = "https://www.loblaws.ca";
        manageDriver.openWebSiteMaximizeWindow(url);
        WebDriverWait wait = new WebDriverWait(driver, 30000);
        if(language.equals("FR")){
            driver.findElement(By.linkText("FR")).click();
        }
        manageDriver.searchKeyWord(keyWordToSearch);
        driver.findElement(By.xpath("//div[3]/div/ul/li[3]/button")).click();
        manageDriver.waitJqueryDone();
        while(driver.findElement(By.cssSelector("button.btn-inline-link.btn-show-more")).isDisplayed()){
            ((JavascriptExecutor) driver)
                    .executeScript("window.scrollTo(0, document.body.scrollHeight)");
                driver.findElement(By.cssSelector("button.btn-inline-link.btn-show-more")).click();
                manageDriver.waitJqueryDone();
        }
        List<WebElement> list = driver.findElements(By.className("reg-price-text"));
        List<Double> prices = new ArrayList<>();
        list.forEach(e->prices.add(getPrice(e)));
        boolean sorted = Ordering.natural().reverse().isOrdered(prices);
        return sorted;
    }
    private Double getPrice(WebElement e) {
        return Double.valueOf( e.getText().replace("$","").replace(",","."));
    }
}
