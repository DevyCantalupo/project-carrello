package progetto.FakeDatabase;

import java.util.ArrayList;
import java.util.List;

import progetto.Items.Article;
import progetto.Items.Notebook;
import progetto.Items.Smartphone;
import progetto.Items.Tablet;
import progetto.Utility.Utility;


public class Warehouse {
    private static List<Article> warehouse = new ArrayList<>();

    public static List<Article> getWarehouse() {
        return warehouse;
    }

    public static void productsAlreadyInWarehouse() {
        Utility utility = new Utility();
        Article product1 = new Tablet("Susa", "VK64", "Yep, it's a tablet", 10.5, 64, 80, 59.99,
                utility.generateUniqueID());
        Article product2 = new Tablet("SpyPhone", "69", "James Bond approves", 2, 2048, 6000, 10000,
                utility.generateUniqueID());
        Article product3 = new Smartphone("Big", "Chungus", "It's big", 20, 512, 400, 800,
                utility.generateUniqueID());
        Article product4 = new Smartphone("Susa", "Honor", "Good camera", 6, 128, 250, 500,
                utility.generateUniqueID());
        Article product5 = new Notebook("SpyPhone", "SlimJim", "We make notebooks too", 13, 4096, 8999, 24999,
                utility.generateUniqueID());
        Article product6 = new Notebook("Tencent", "YadMYqRiN", "It's cheap ;)", 14, 32, 0.05, 0.1,
                utility.generateUniqueID());
        Tablet tablet1 = new Tablet("Huawei", "xxx", "bello", 22, 150, 50, 160,
                utility.generateUniqueID());
        Tablet tablet2 = new Tablet("Hp", "x222", "brutto", 10, 240, 80, 200,
                utility.generateUniqueID());
        Smartphone smartphone1 = new Smartphone("Nokia", "3210", null, 11, 90, 150, 300,
                utility.generateUniqueID());

        Smartphone smartphone2 = new Smartphone("Iphone", "12", "Funziona", 31, 120, 150, 400,
                utility.generateUniqueID());
        Notebook notebook1 = new Notebook("Hp", "h300", null, 10, 222, 250, 600,
                utility.generateUniqueID());
        Notebook notebook2 = new Notebook("Apple", "pro", "vecchio", 22, 400, 300, 800,
                utility.generateUniqueID());
        addWarehouse(product1);
        addWarehouse(product2);
        addWarehouse(product3);
        addWarehouse(product4);
        addWarehouse(product5);
        addWarehouse(product6);
        addWarehouse(tablet1);
        addWarehouse(tablet2);
        addWarehouse(smartphone1);
        addWarehouse(smartphone2);
        addWarehouse(notebook1);
        addWarehouse(notebook2);

    }

    public static void addWarehouse(Article a) {
        warehouse.add(a);
    }

}
