package progetto;

import java.util.ArrayList;
import java.util.List;
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
        List<Article> listOfArticleToSearch = new ArrayList<Article>();
        do {
            System.out.print("\n Insert your menu option: ");
            String menuChoice = menuScan.next();
            switch (menuChoice) {
                case "0":
                    continueMenu = false;
                    break;
                case "1":
                    System.out.println("\n Enter the TYPE of the product you want to add \n");
                    OperationInWarehouse.addToWarehouse();
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
                    String manufacturerToSearch = menuScan.next();
                    OperationInWarehouse.findByManifacturer(listOfArticleToSearch, manufacturerToSearch);
                    checkIfEmpty(listOfArticleToSearch);
                    break;
                case "6":
                    System.out.println("\n Insert the model of the product \n");
                    String modelToSearch = menuScan.next();
                    OperationInWarehouse.findByModel(listOfArticleToSearch, modelToSearch);
                    checkIfEmpty(listOfArticleToSearch);
                    break;
                case "7":
                    System.out.println("\n Insert the selling price to search \n");
                    while (!menuScan.hasNextInt()) {
                        System.out.println("invalid input , try again");
                        menuScan.next();
                    }
                    int getPriceOfSellingToSearch = menuScan.nextInt();
                    OperationInWarehouse.findSellingPrice(listOfArticleToSearch, getPriceOfSellingToSearch);
                    checkIfEmpty(listOfArticleToSearch);
                    break;
                case "8":
                    System.out.println("\n Insert purchase price to find \n");
                    int price = menuScan.nextInt();
                    List<Article> listPrice = OperationInWarehouse.findBuyingPrice(price);
                    checkIfEmpty(listPrice);
                    break;
                case "9":
                    System.out.println("\n Find product between this selling range price. \n");
                    System.out.println("\n Insert minimum price \n ");
                    int priceMin = menuScan.nextInt();
                    System.out.println("\n Insert maximum price \n");
                    int priceMax = menuScan.nextInt();
                    List<Article> listRange = OperationInWarehouse.findRangePrice(priceMin, priceMax);
                    checkIfEmpty(listRange);
                    break;
                case "10":
                    System.out.println("Insert type of Article");
                    String type = menuScan.next().toUpperCase();
                    if (Validation.isEnum(type)) {
                        Double result = OperationInWarehouse.findAvgPrice(type);
                        System.out.println("Avg Price of " + type + ": " + result);
                    } else {
                        System.out.println("We don't sell this type of article");
                    }
                    break;
                case "11":
                    if (Cart.getUserCart().isEmpty()) {
                        System.out.println("\n user cart is empty \n");
                    } else {
                        Cart.printCart();
                        System.out.println("your actual price is : " + Cart.calculateTotalCart());
                        System.out.println("\n Would you like to complete your purchase?");
                        System.out.println(
                                "Digit 'YES' if you want to puchase the articles, 'NO' if you don't want to buy the articles anymore, digit a random char to go back to the menu");
                        String choice = menuScan.next();
                        Cart.finalizePurchase(choice);
                    }
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
            String menuChoice = menuScan.next();
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
                case "3":
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

    public static void checkIfEmpty(List<Article> list) {
        if (list.isEmpty()) {
            System.out.println("\n No Article were found  \n");
        } else {
            System.out.println("\n" + list + "\n");
            list.clear();
        }
    }
}
