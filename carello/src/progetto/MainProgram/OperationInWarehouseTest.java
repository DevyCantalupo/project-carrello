package progetto.Mainprogram;

import org.junit.Test;

import progetto.Fakedatabase.Warehouse;
import progetto.Items.Article;

import static org.junit.Assert.assertEquals;

import java.util.List;

public class OperationInWarehouseTest {
  @Test
  public void testFindByManifacturerIfNull() {
    List<Article> testManufacturer = OperationInWarehouse.findByManifacturer(null);
    assertEquals(0, testManufacturer.size());
  }

  @Test
  public void testManufacturerNotFind() {
    List<Article> testManufacturer = OperationInWarehouse.findByManifacturer("adfadf");
    assertEquals(0, testManufacturer.size());
  }

  @Test
  public void testFindByManufacturerWithEmptyWarehouse() {
    Warehouse.getWarehouse().clear();
    List<Article> testManufacturer = OperationInWarehouse.findByManifacturer("Hp");
    assertEquals(0, testManufacturer.size());
  }

  @Test
  public void testfindByModel() {

  }

  @Test
  public void testfindSellingPrice() {

  }

  @Test
  public void findAvgPrice_with_type_TABLET() {
    new Warehouse().productsAlreadyInWarehouse();
    OperationInWarehouse warehouse = new OperationInWarehouse();
    Double expectedResult = 1552.5;
    String type = "TABLET";
    Double result = warehouse.findAvgPrice(type);
    assertEquals(expectedResult, result);
  }

}
