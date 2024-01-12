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

    OperationInWarehouse operation = new OperationInWarehouse();
    Utility utility = new Utility();
    @Test
    public void testFindByManifacturerIfNull() {
        List<Article> testManufacturer = operation.findByManifacturer(null);
        assertEquals(0, testManufacturer.size());
    }

    @Test
    public void testManufacturerNotFind() {
        List<Article> testManufacturer = operation.findByManifacturer("adfadf");
        assertEquals(0, testManufacturer.size());
    }

    @Test
    public void testFindByManufacturerWithEmptyWarehouse() {
        Warehouse.getWarehouse().clear();
        List<Article> testManufacturer = operation.findByManifacturer("Hp");
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
        Article tablet = new Tablet("Hp", "9000X", "A description", 9, 128, 200, 300, utility.generateUniqueID());
        Boolean validate = operation.addToWarehouse(tablet);
        assertTrue(validate);
    }

    @Test
    public void check_If_addToWarehouse_adds_a_null_product() {
        Article tablet = null;
        Boolean validate = operation.addToWarehouse(tablet);
        assertFalse(validate);
    }

    @Test
    public void check_if_findAvgPrice_return_value_with_correct_input() {
        Warehouse database = new Warehouse();
        database.productsAlreadyInWarehouse();
        Double expectedResult = operation.findAvgPrice(Article.TypeOfArticle.TABLET);
        assertNotNull(expectedResult);
    }

    @Test
    public void check_if_findAvgPrice_return_null_if_there_are_not_Articles_in_the_Database() {
        Warehouse.getWarehouse().clear();
        assertNull(operation.findAvgPrice(Article.TypeOfArticle.TABLET));
    }

    @Test
    public void check_if_findAvgPrice_return_zero_if_priceOfBuying_of_the_articles_are_zero() {
        Warehouse.getWarehouse().clear();
        Notebook t1 = new Notebook("Hp","X100", "blablabla",300, 500, 0, 0,"xx" );
        Notebook t2 = new Notebook("Hp","X200", "blablabla",300, 500, 0, 0,"xxx" );
        Notebook t3 = new Notebook("Hp","X300", "blablabla",300, 500, 0, 0,"xxxx" );
        operation.addToWarehouse(t1);
        operation.addToWarehouse(t2);
        operation.addToWarehouse(t3);
        Double resultExpected = 0.0;
        assertEquals(resultExpected, operation.findAvgPrice(Article.TypeOfArticle.NOTEBOOK));
    }

    @Test
    public void check_if_findRangePrice_return_empty_list_if_there_are_not_Articles_in_the_range(){
        Notebook t1 = new Notebook("Hp","X100", "blablabla",300, 500, 10, 100,"xx" );
        Notebook t2 = new Notebook("Hp","X200", "blablabla",300, 500, 50, 200,"xxx" );
        Notebook t3 = new Notebook("Hp","X300", "blablabla",300, 500, 50, 300,"xxxx" );
        operation.addToWarehouse(t1);
        operation.addToWarehouse(t2);
        operation.addToWarehouse(t3);
        List<Article> resultExpected = operation.findRangePrice(1000, 1100);
        assertTrue(resultExpected.isEmpty());
    }


    @Test
    public void check_if_findRangePrice_return_Not_empty_list_if_there_Articles_in_the_range(){
        Notebook t1 = new Notebook("Hp","X100", "blablabla",300, 500, 10, 100,"xx" );
        Notebook t2 = new Notebook("Hp","X200", "blablabla",300, 500, 50, 200,"xxx" );
        Notebook t3 = new Notebook("Hp","X300", "blablabla",300, 500, 50, 300,"xxxx" );
        operation.addToWarehouse(t1);
        operation.addToWarehouse(t2);
        operation.addToWarehouse(t3);
        List<Article> resultExpected = operation.findRangePrice(100, 200);
        assertFalse(resultExpected.isEmpty());
    }

    @Test
    public void check_if_findRangePrice_return_null_if_PriceMin_is_higher_then_priceMax(){
        List<Article> result = operation.findRangePrice(100, 50);
        assertNull(result);
    }


}

