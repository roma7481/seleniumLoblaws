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

    public boolean appleSorting(){

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 30000);
        driver.get("https://www.loblaws.ca");
        driver.manage().window().maximize();
        WebElement element = driver.findElement(By.id("search-bar"));
        element.sendKeys("apples");
        element.submit();
        driver.findElement(By.xpath("//div[3]/div/ul/li[3]/button")).click();
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
        wait.until(d -> (boolean)((JavascriptExecutor)driver).executeScript("return jQuery.active == 0"));
        while(driver.findElement(By.cssSelector("button.btn-inline-link.btn-show-more")).isDisplayed()){
            ((JavascriptExecutor) driver)
                    .executeScript("window.scrollTo(0, document.body.scrollHeight)");
                driver.findElement(By.cssSelector("button.btn-inline-link.btn-show-more")).click();
                wait.until(d -> (boolean)((JavascriptExecutor)driver).executeScript("return jQuery.active == 0"));

        }
        List<WebElement> list = driver.findElements(By.className("reg-price-text"));
        List<Double> prices = new ArrayList<>();
        list.forEach(e->prices.add(getPrice(e)));
        boolean sorted = Ordering.natural().isOrdered(prices);
        driver.quit();
        return sorted;
    }
    private Double getPrice(WebElement e) {
        return Double.valueOf( e.getText().replace("$",""));
    }
}
