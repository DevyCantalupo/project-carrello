package progetto;

import java.util.Scanner;

public class Menu {
    static Scanner menuScan = new Scanner(System.in);

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

    public static void menuOperations() throws Exception {
        boolean continueMenu = true;
        do {
            System.out.print("Insert your menu option: ");
            int menuChoice = menuScan.nextInt();
            switch (menuChoice) {
                case 0:
                    continueMenu = false;
                    break;
                case 1:
                    System.out.println("\n Enter the TYPE of the product you want to add \n");
                    OperationInWarehouse.addToWarehouse();
                    break;
                case 2:
                    OperationInWarehouse.printWarehouseContents();
                    break;
                case 3:
                    userCartMenu();
                    break;
                case 4:
                    System.out.print("\n Please enter the TYPE of the product you wish to search for: \n");
                    OperationInWarehouse.searchType();
                    break;
                case 5:
                    System.out.println("\n Insert the manufacturer of the product \n");
                    OperationInWarehouse.findByManifacturer();
                    break;
                case 6:
                    System.out.println("\n Insert the model of the product \n");
                    OperationInWarehouse.findByModel();
                    break;
                case 7:
                    System.out.println("\n Insert the selling price to search \n");
                    OperationInWarehouse.findSellingPrice();
                    break;
                case 8:
                    System.out.println("\n Insert purchase price to find \n");
                    OperationInWarehouse.findBuyingPrice();
                    break;
                case 9:
                    System.out.println("\n Find product between this selling range price. \n");
                    OperationInWarehouse.findRangePrice();
                    break;
                case 10:
                    System.out.println(OperationInWarehouse.findAvgPrice());
                    break;
                default:
                    System.out.println("\n Something went wrong \n");
                    break;
            }
        } while (continueMenu);
    }

    public static void userCartMenu() {
        System.out.println("Press 0 to return to the previous menu");
        System.out.println("Press 1 to add a product to the cart");
        System.out.println("Press 2 to see what is in your shopping cart");
        System.out.println("Press 3 to remove an item from your shopping cart");

        boolean continueMenuOperations = true;

        do {
            System.out.print("Insert your cart menu option: ");
            int menuChoice = menuScan.nextInt();
            switch (menuChoice) {
                case 0:
                    continueMenuOperations = false;
                    break;
                case 1:
                    System.out.print("Enter INDEX of the product:");
                    Cart.addToCart();
                    break;
                case 2:
                    System.out.println("You cart has:");
                    Cart.printCart();
                    break;
                case 3:
                    System.out.print("Enter the INDEX of the thing you wish to remove:");
                    Cart.removeFromCart();
                    break;
            }
        } while (continueMenuOperations);
    }
}
