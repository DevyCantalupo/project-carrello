package progetto;

public class Warehouse {
    public static void productsAlreadyInWarehouse() {
        Article product1 = new Tablet("Susa", "VK64", "Yep, it's a tablet", 10.5, 64, 80, 59.99,
                GenerateUniqueId.generateUniqueID());
        OperationInWarehouse.warehouse.add(product1);
        Article product2 = new Tablet("SpyPhone", "69", "James Bond approves", 2, 2048, 6000, 10000,
                GenerateUniqueId.generateUniqueID());
        OperationInWarehouse.warehouse.add(product2);
        Article product3 = new Smartphone("Big", "Chungus", "It's big", 20, 512, 400, 800,
                GenerateUniqueId.generateUniqueID());
        OperationInWarehouse.warehouse.add(product3);
        Article product4 = new Smartphone("Susa", "Honor", "Good camera", 6, 128, 250, 500,
                GenerateUniqueId.generateUniqueID());
        OperationInWarehouse.warehouse.add(product4);
        Article product5 = new Notebook("SpyPhone", "SlimJim", "We make notebooks too", 13, 4096, 8999, 24999,
                GenerateUniqueId.generateUniqueID());
        OperationInWarehouse.warehouse.add(product5);
        Article product6 = new Notebook("Tencent", "YadMYqRiN", "It's cheap ;)", 14, 32, 0.05, 0.1,
                GenerateUniqueId.generateUniqueID());
        OperationInWarehouse.warehouse.add(product6);

        Tablet tablet1 = new Tablet("Huawei", "xxx", "bello", 22, 150, 50, 160, GenerateUniqueId.generateUniqueID());
        OperationInWarehouse.warehouse.add(tablet1);
        Tablet tablet2 = new Tablet("Hp", "x222", "brutto", 10, 240, 80, 200, GenerateUniqueId.generateUniqueID());
        OperationInWarehouse.warehouse.add(tablet2);
        Smartphone smartphone1 = new Smartphone("Nokia", "3210", null, 11, 90, 150, 300,
                GenerateUniqueId.generateUniqueID());
        OperationInWarehouse.warehouse.add(smartphone1);
        Smartphone smartphone2 = new Smartphone("Iphone", "12", "Funziona", 31, 120, 150, 400,
                GenerateUniqueId.generateUniqueID());
        OperationInWarehouse.warehouse.add(smartphone2);
        Notebook notebook1 = new Notebook("Hp", "h300", null, 10, 222, 250, 600, GenerateUniqueId.generateUniqueID());
        OperationInWarehouse.warehouse.add(notebook1);
        Notebook notebook2 = new Notebook("Apple", "pro", "vecchio", 22, 400, 300, 800,
                GenerateUniqueId.generateUniqueID());
        OperationInWarehouse.warehouse.add(notebook2);
    }
}
