package progetto;

import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {

        printWelcomeMsg();
        productsAlreadyInWarehouse();
        printMenuOperations();
        menuOperations();
        printGoodbyeMsg();

    }

    public static void printWelcomeMsg() {
        System.out.println();
        System.out.println("*** Welcome to this warehouse management app! ***");
        System.out.println("     ***  Developed by The InBetweeners  ***");
        System.out.println("\nChoose an operation to perform:");
    }

    public static void printMenuOperations() {
        System.out.println("Press 0 to quit the program");
        System.out.println("Press 1 to add a product to the warehouse");
        System.out.println("Press 2 to see what is currently in the warehouse"); // Metodo 1
        System.out.println("Press 3 to create/edit your shopping cart");
        System.out.println("Press 4 to search products by type"); // Metodo 2
        System.out.println("Press 5 to search products by manufacturer"); // Metodo 3
        System.out.println("Press 6 to search products by model"); // Metodo 4
        System.out.println("Press 7 to search products by sell price"); // Metodo 5
        System.out.println("Press 8 to search products by purchase price"); // Metodo 6
        System.out.println("Press 9 to search products in a certain price range"); // Metodo 7
        System.out.println("Press 10 to find the average price of products"); // Metodo 8
    }

    public static void printGoodbyeMsg() {
        System.out.println("\nClosing the program, have a nice day!");
    }

    private static void menuOperations() throws Exception {

        Scanner menuScan = new Scanner(System.in);

        boolean continueMenu = true;

        do {
            System.out.print("Insert your menu option: ");
            int menuChoice = menuScan.nextInt();
            switch (menuChoice) {
                case 0:
                    continueMenu = false;
                    break;
                case 1:
                    Warehouse.addToWarehouse();
                    break;
                case 2:
                    Warehouse.printWarehouseContents();
                    break;
                case 3:
                    Cart.userCartOperations();
                    break;
                case 4:
                    Warehouse.searchType();
                    break;
                case 5:
                    System.out.println("Cerca articolo per produttore ");
                    System.out.println(Warehouse.findByManifacturer());
                    break;
                case 6:
                    System.out.println("Cerca articolo per modello ");
                    System.out.println(Warehouse.findByModel());
                    break;
                case 7:
                   System.out.println("Cerca articolo per prezzo di vendita  ");
                    System.out.println(Warehouse.findSellingPrice());
                    break;
                case 8:
                    System.out.println("Cerca prodotto con prezzo di acquisto: 80");
                    System.out.println(Warehouse.findBuyingPrice(80));
                    break;
                case 9:
                    System.out.println("Cerca prodotto con range di prezzo di vendita tra 50 e 200");
                    System.out.println(Warehouse.findRangePrice(50, 200));
                    break;
                case 10:
                    System.out.println("Trova prezzo medio di acquisto degli articoli TABLET");
                    System.out.println(Warehouse.findAvgPrice("TABLET"));
                    break;
                default:
                    System.out.println("Something went wrong");
                    break;
            }
        } while (continueMenu);
    }

    public static void productsAlreadyInWarehouse() {
        Article product1 = new Tablet("Susa", "VK64", "Yep, it's a tablet", 10.5, 64, 80, 59.99,
                GenerateUniqueId.generateUniqueID());
        Warehouse.warehouse.add(product1);
        Article product2 = new Tablet("SpyPhone", "69", "James Bond approves", 2, 2048, 6000, 10000,
                GenerateUniqueId.generateUniqueID());
        Warehouse.warehouse.add(product2);
        Article product3 = new Smartphone("Big", "Chungus", "It's big", 20, 512, 400, 800,
                GenerateUniqueId.generateUniqueID());
        Warehouse.warehouse.add(product3);
        Article product4 = new Smartphone("Susa", "Honor", "Good camera", 6, 128, 250, 500,
                GenerateUniqueId.generateUniqueID());
        Warehouse.warehouse.add(product4);
        Article product5 = new Notebook("SpyPhone", "SlimJim", "We make notebooks too", 13, 4096, 8999, 24999,
                GenerateUniqueId.generateUniqueID());
        Warehouse.warehouse.add(product5);
        Article product6 = new Notebook("Tencent", "YadMYqRiN", "It's cheap ;)", 14, 32, 0.05, 0.1,
                GenerateUniqueId.generateUniqueID());
        Warehouse.warehouse.add(product6);

        Tablet tablet1 = new Tablet("Huawei", "xxx", "bello", 22, 150, 50, 160, GenerateUniqueId.generateUniqueID());
        Warehouse.warehouse.add(tablet1);
        Tablet tablet2 = new Tablet("Hp", "x222", "brutto", 10, 240, 80, 200, GenerateUniqueId.generateUniqueID());
        Warehouse.warehouse.add(tablet2);
        Smartphone smartphone1 = new Smartphone("Nokia", "3210", null, 11, 90, 150, 300,
                GenerateUniqueId.generateUniqueID());
        Warehouse.warehouse.add(smartphone1);
        Smartphone smartphone2 = new Smartphone("Iphone", "12", "Funziona", 31, 120, 150, 400,
                GenerateUniqueId.generateUniqueID());
        Warehouse.warehouse.add(smartphone2);
        Notebook notebook1 = new Notebook("Hp", "h300", null, 10, 222, 250, 600, GenerateUniqueId.generateUniqueID());
        Warehouse.warehouse.add(notebook1);
        Notebook notebook2 = new Notebook("Apple", "pro", "vecchio", 22, 400, 300, 800,
                GenerateUniqueId.generateUniqueID());
        Warehouse.warehouse.add(notebook2);
    }
}