package progetto;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

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
    OperationInWarehouse.getWarehouse().clear();
    List<Article> testManufacturer = OperationInWarehouse.findByManifacturer("Hp");
    assertEquals(0, testManufacturer.size());
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
  public void findAvgPrice_with_type_a_caso() {
    new Warehouse().productsAlreadyInWarehouse();
    OperationInWarehouse warehouse = new OperationInWarehouse();
    Double expectedResult = 1552.5;
    String type = "a caso";
    assertThrows(IllegalArgumentException.class,()->warehouse.findAvgPrice(type));
  }

  @Test
  public void checkIfNumArtIsStillZeroAfterTheSearch() {
    new Warehouse().productsAlreadyInWarehouse();
    OperationInWarehouse warehouse = new OperationInWarehouse();
    Double expectedResult = 1552.5;
    String type = "a caso";
    assertThrows(IllegalArgumentException.class,()->warehouse.findAvgPrice(type));
  }

//TODO Scrivere test che controlla se totPrice sia ancora zero, con numArt diverso da zero
  //TODO Scrivere test che controlla se totPrice sia ancora zero, con numArt uguale a zero
  // TODO
}
