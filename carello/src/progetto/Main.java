package progetto;

import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {

        printWelcomeMsg();
        Warehouse.productsAlreadyInWarehouse();
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
                    System.out.println(Warehouse.findBuyingPrice());
                    break;
                case 9:
                    System.out.println(Warehouse.findRangePrice());
                    break;
                case 10:
                    System.out.println(Warehouse.findAvgPrice());
                    break;
                default:
                    System.out.println("Something went wrong");
                    break;
            }
        } while (continueMenu);
    }

}