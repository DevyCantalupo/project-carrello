package progetto;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class OperationInWarehouseTest {
    @Test
    public void testFindByManifacturer() {

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
