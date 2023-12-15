package progetto;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {
        @Deprecated
    public static void productsAlreadyInWarehouse() {
        Article product1 = new Tablet("Susa", "VK64", "Yep, it's a tablet", 10.5, 64, 80, 59.99,
                Utilities.generateUniqueID());
        OperationInWarehouse.getWarehouse().add(product1);
        Article product2 = new Tablet("SpyPhone", "69", "James Bond approves", 2, 2048, 6000, 10000,
                Utilities.generateUniqueID());
        OperationInWarehouse.getWarehouse().add(product2);
        Article product3 = new Smartphone("Big", "Chungus", "It's big", 20, 512, 400, 800,
                Utilities.generateUniqueID());
        OperationInWarehouse.getWarehouse().add(product3);
        Article product4 = new Smartphone("Susa", "Honor", "Good camera", 6, 128, 250, 500,
                Utilities.generateUniqueID());
        OperationInWarehouse.getWarehouse().add(product4);
        Article product5 = new Notebook("SpyPhone", "SlimJim", "We make notebooks too", 13, 4096, 8999, 24999,
                Utilities.generateUniqueID());
        OperationInWarehouse.getWarehouse().add(product5);
        Article product6 = new Notebook("Tencent", "YadMYqRiN", "It's cheap ;)", 14, 32, 0.05, 0.1,
                Utilities.generateUniqueID());
        OperationInWarehouse.getWarehouse().add(product6);

        Tablet tablet1 = new Tablet("Huawei", "xxx", "bello", 22, 150, 50, 160, Utilities.generateUniqueID());
        OperationInWarehouse.getWarehouse().add(tablet1);
        Tablet tablet2 = new Tablet("Hp", "x222", "brutto", 10, 240, 80, 200, Utilities.generateUniqueID());
        OperationInWarehouse.getWarehouse().add(tablet2);
        Smartphone smartphone1 = new Smartphone("Nokia", "3210", null, 11, 90, 150, 300,
                Utilities.generateUniqueID());
        OperationInWarehouse.getWarehouse().add(smartphone1);
        Smartphone smartphone2 = new Smartphone("Iphone", "12", "Funziona", 31, 120, 150, 400,
                Utilities.generateUniqueID());
        OperationInWarehouse.getWarehouse().add(smartphone2);
        Notebook notebook1 = new Notebook("Hp", "h300", null, 10, 222, 250, 600, Utilities.generateUniqueID());
        OperationInWarehouse.getWarehouse().add(notebook1);
        Notebook notebook2 = new Notebook("Apple", "pro", "vecchio", 22, 400, 300, 800,
                Utilities.generateUniqueID());
        OperationInWarehouse.getWarehouse().add(notebook2);
    }

    public List<Article> getArticlesInWarehouse(){
        Article product1 = new Tablet("Susa", "VK64", "Yep, it's a tablet", 10.5, 64, 80, 59.99,
                Utilities.generateUniqueID());
        Article product2 = new Tablet("SpyPhone", "69", "James Bond approves", 2, 2048, 6000, 10000,
                Utilities.generateUniqueID());
        Article product3 = new Smartphone("Big", "Chungus", "It's big", 20, 512, 400, 800,
                Utilities.generateUniqueID());
        Article product4 = new Smartphone("Susa", "Honor", "Good camera", 6, 128, 250, 500,
                Utilities.generateUniqueID());
        Article product5 = new Notebook("SpyPhone", "SlimJim", "We make notebooks too", 13, 4096, 8999, 24999,
                Utilities.generateUniqueID());
        Article product6 = new Notebook("Tencent", "YadMYqRiN", "It's cheap ;)", 14, 32, 0.05, 0.1,
                Utilities.generateUniqueID());

        Tablet tablet1 = new Tablet("Huawei", "xxx", "bello", 22, 150, 50, 160, Utilities.generateUniqueID());

        Tablet tablet2 = new Tablet("Hp", "x222", "brutto", 10, 240, 80, 200, Utilities.generateUniqueID());

        Smartphone smartphone1 = new Smartphone("Nokia", "3210", null, 11, 90, 150, 300,
                Utilities.generateUniqueID());
        Smartphone smartphone2 = new Smartphone("Iphone", "12", "Funziona", 31, 120, 150, 400,
                Utilities.generateUniqueID());

        Notebook notebook1 = new Notebook("Hp", "h300", null, 10, 222, 250, 600, Utilities.generateUniqueID());

        Notebook notebook2 = new Notebook("Apple", "pro", "vecchio", 22, 400, 300, 800,
                Utilities.generateUniqueID());

        List<Article> list= new ArrayList<Article>();
        list.add(notebook1);
        list.add(notebook2);
        list.add(smartphone1);
        list.add(smartphone2);
        list.add(tablet1);
        list.add(tablet2);
        list.add(product1);
        list.add(product2);
        list.add(product3);
        list.add(product4);
        list.add(product5);
        list.add(product6);
        return list;

    }
}
