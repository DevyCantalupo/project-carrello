package progetto.MainProgram;

import org.junit.Test;

import progetto.FakeDatabase.Warehouse;
import progetto.Items.Article;
import progetto.Items.Tablet;
import progetto.Utility.Utility;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

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

  @Test
  public void check_If_addToWarehouse_adds_a_product() {
    OperationInWarehouse warehouse = new OperationInWarehouse();
    Article tablet = new Tablet("Hp", "9000X", "A description", 9, 128, 200, 300, Utility.generateUniqueID());
    Boolean validate = warehouse.addToWarehouse(tablet);
    assertTrue(validate);
  }

  @Test
  public void check_If_addToWarehouse_adds_a_null_product() {
    OperationInWarehouse warehouse = new OperationInWarehouse();
    Article tablet = null;
    Boolean validate = warehouse.addToWarehouse(tablet);
    assertFalse(validate);
  }

}
