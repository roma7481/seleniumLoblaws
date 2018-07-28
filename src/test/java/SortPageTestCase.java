import org.junit.Assert;
import org.junit.Test;

public class SortPageTestCase {

    @Test
    public void applesSortingOrderTest(){
        SortPage sortPage = new SortPage();
        Assert.assertTrue(sortPage.appleSorting());
    }
}
