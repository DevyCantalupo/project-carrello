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
        System.out.println("Press 11 to conclude the sale transaction");
    }

    public static void menuOperations() throws Exception {
        boolean continueMenu = true;
        do {
            System.out.println("Insert your menu option: ");
            String menuChoice = menuScan.next();
            switch (menuChoice) {
                case "0":
                    continueMenu = false;
                    break;
                case "1":

                    Article.TypeOfArticle type = ManageUserInput.validateTypeInput();

                    System.out.println("Enter the MANUFACTURER of the product");
                    menuScan.nextLine();
                    String manufacturer = menuScan.nextLine();


                    System.out.println("Enter the MODEL NAME of the product");
                    String modelName = menuScan.nextLine();

                    String briefDescription = ManageUserInput.descriptionInput();

                    System.out.println("Enter the SCREEN SIZE of the product");
                    double screenSizeInInches = menuScan.nextDouble();

                    System.out.println("Enter the INTERNAL MEMORY SIZE of the product");
                    int internalMemorySize = menuScan.nextInt();

                    System.out.println("Enter the PURCHASE PRICE of the product");
                    double purchasePrice = menuScan.nextDouble();

                    System.out.println("Enter the SELL PRICE of the product");
                    double sellPrice = menuScan.nextDouble();

                    String id = GenerateUniqueId.generateUniqueID();
                    System.out.println("Assigned unique ID for the product is: " + id);

                    OperationInWarehouse.addToWarehouse(type, manufacturer, modelName, briefDescription, screenSizeInInches,
                            internalMemorySize, purchasePrice, sellPrice, id);

                    break;
                case "2":
                    OperationInWarehouse.printWarehouseContents();
                    break;
                case "3":
                    userCartMenu();
                    break;
                case "4":
                    System.out.print("\n Please enter the TYPE of the product you wish to search for: \n");
                    OperationInWarehouse.searchType();
                    break;
                case "5":
                    System.out.println("\n Insert the manufacturer of the product \n");
                    OperationInWarehouse.findByManifacturer();
                    break;
                case "6":
                    System.out.println("\n Insert the model of the product \n");
                    OperationInWarehouse.findByModel();
                    break;
                case "7":
                    System.out.println("\n Insert the selling price to search \n");
                    OperationInWarehouse.findSellingPrice();
                    break;
                case "8":
                    System.out.println("\n Insert purchase price to find \n");
                    OperationInWarehouse.findBuyingPrice();
                    break;
                case "9":
                    System.out.println("\n Find product between this selling range price. \n");
                    OperationInWarehouse.findRangePrice();
                    break;
                case "10":
                    System.out.println(OperationInWarehouse.findAvgPrice());
                    break;
                case "11":
                    Cart.finalizePurchase();
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
        System.out.println("Press 2 to add a product to the cart by id");
        System.out.println("Press 3 to see what is in your shopping cart");
        System.out.println("Press 4 to remove an item from your shopping cart");
        System.out.println("Press 5 to remove an item from your shopping cart by id");
        System.out.println("Press 6 to see total price cart");

        boolean continueMenuOperations = true;
        do {
            System.out.print("\n Insert your cart menu option: \n");
            String  menuChoice = menuScan.next();
            switch (menuChoice) {
                case "0":
                    continueMenuOperations = false;
                    break;
                case "1":
                    System.out.print("Enter INDEX of the product:");
                    Cart.addToCart();
                    break;
                case "2":
                    System.out.print("Enter ID of the product:");
                    Cart.addToCartById();
                    break;
                case"3":
                    Cart.printCart();
                    break;
                case "4":
                    System.out.print("Enter the INDEX of the thing you wish to remove:");
                    Cart.removeFromCart();
                    break;
                case "5":
                    System.out.print("Enter the ID of the thing you wish to remove:");
                    Cart.removeFromCartById();
                    break;
                case "6":
                    System.out.println("\nTotal Price is : " + Cart.calculateTotalCart());
                    break;
                default:
                    System.out.println("\n Something went wrong \n");
                    break;
            }
        } while (continueMenuOperations);
    }
}
