package progetto;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class OperationInWarehouseTest {
  Warehouse warehouse = new Warehouse();
  List<Article> articleList = warehouse.getArticlesInWarehouse(); 

    @Test
    public void testFindByManifacturer() {
      String toFind = "hp";
      List<Article> foundArticles = OperationInWarehouse.findByManifacturer(articleList, toFind);
      Assert.assertFalse(foundArticles.isEmpty());
    }

    @Test
    public void testFindByManufcacturereNotReturnNull(){
      String toFind = "hp";
      List<Article> foundArticles = OperationInWarehouse.findByManifacturer(articleList, toFind);
      Assert.assertNotNull(foundArticles);
    }

      @Test
    public void testfindByModel() {

    }

      @Test
    public void testfindSellingPrice() {

    }
}
