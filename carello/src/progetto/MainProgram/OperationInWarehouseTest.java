package progetto.MainProgram;

import org.junit.Assert;
import org.junit.Test;

import progetto.FakeDatabase.Warehouse;
import progetto.Items.Article;
import progetto.Items.Notebook;
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

    @Test
    public void check_if_findAvgPrice_return_value_with_correct_input() {
        Warehouse database = new Warehouse();
        database.productsAlreadyInWarehouse();
        OperationInWarehouse warehouse = new OperationInWarehouse();
        Double expectedResult = warehouse.findAvgPrice(Article.TypeOfArticle.TABLET);
        assertNotNull(expectedResult);
    }

    @Test
    public void check_if_findAvgPrice_return_null_if_there_are_not_Articles_in_the_Database() {
        OperationInWarehouse warehouse = new OperationInWarehouse();
        assertNull(warehouse.findAvgPrice(Article.TypeOfArticle.TABLET));
    }

    @Test
    public void check_if_findAvgPrice_return_zero_if_priceOfBuying_of_the_articles_are_zero() {
        Notebook t1 = new Notebook("Hp","X100", "blablabla",300, 500, 0, 0,"xx" );
        Notebook t2 = new Notebook("Hp","X200", "blablabla",300, 500, 0, 0,"xxx" );
        Notebook t3 = new Notebook("Hp","X300", "blablabla",300, 500, 0, 0,"xxxx" );
        OperationInWarehouse warehouse = new OperationInWarehouse();
        warehouse.addToWarehouse(t1);
        warehouse.addToWarehouse(t2);
        warehouse.addToWarehouse(t3);
        Double resultExpected = 0.0;
        assertEquals(resultExpected, warehouse.findAvgPrice(Article.TypeOfArticle.NOTEBOOK));
    }
}

