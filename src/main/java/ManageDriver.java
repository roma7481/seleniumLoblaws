import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ManageDriver {

    private WebDriver driver;
    private WebDriverWait wait;
    private static final int LOADING_TIMEOUT = 10;
    private static final int TIME_OUT_IN_MILLI_SECONDS = 30000;
    private String jqueryActiveScript = "return jQuery.active == 0";

    ManageDriver(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(LOADING_TIMEOUT, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, TIME_OUT_IN_MILLI_SECONDS);
    }

    public void openWebSiteMaximizeWindow(String url) {
        driver.get(url);
//        Dimension d = new Dimension(600,480);
//        driver.manage().window().setSize(d);
        driver.manage().window().maximize();
    }

    public void searchKeyWordInSearchBar(String strToSearch, String searchBarId) {
        WebElement element = driver.findElement(By.id(searchBarId));
        element.sendKeys(strToSearch);
        element.submit();
    }

    public void waitJqueryDone() {
        wait.until(d -> {
            return (boolean) ((JavascriptExecutor) driver).executeScript(jqueryActiveScript);
        });
    }

    public void scrollDown() {
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
}
