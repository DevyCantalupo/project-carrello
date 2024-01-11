package progetto.MainProgram;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import jdk.jshell.execution.Util;
import progetto.Items.Article;
import progetto.Items.Notebook;
import progetto.Items.Smartphone;
import progetto.Items.Tablet;
import progetto.Utility.Utility;

public class Menu {
    static Scanner menuScan = new Scanner(System.in);
    Cart cart = new Cart();
    OperationInWarehouse operation = new OperationInWarehouse();
    Utility utility = new Utility();

    public void printMenuOperations() {
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

    public void menuOperations() throws Exception {
        boolean continueMenu = true;
        do {
            System.out.print("\n Insert your menu option: ");
            String menuChoice = menuScan.next();
            switch (menuChoice) {
                case "0":
                    continueMenu = false;
                    break;
                case "1":

                    OperationInWarehouse warehouse = new OperationInWarehouse();

                    Article.TypeOfArticle typeProd = Utility.validateTypeInput();

                    System.out.println("Enter the MANUFACTURER of the product");
                    menuScan.nextLine();
                    String manufacturer = menuScan.nextLine();

                    System.out.println("Enter the MODEL NAME of the product");
                    String modelName = menuScan.nextLine();

                    String briefDescription = Utility.descriptionInput();

                    System.out.println("Enter the SCREEN SIZE of the product");
                    double screenSizeInInches = menuScan.nextDouble();

                    System.out.println("Enter the INTERNAL MEMORY SIZE of the product");
                    int internalMemorySize = menuScan.nextInt();

                    System.out.println("Enter the PURCHASE PRICE of the product");
                    double purchasePrice = menuScan.nextDouble();

                    System.out.println("Enter the SELL PRICE of the product");
                    double sellPrice = menuScan.nextDouble();

                    String id = Utility.generateUniqueID();
                    System.out.println("Assigned unique ID for the product is: " + id);

                    boolean productAdded = false;

                    if (typeProd == Article.TypeOfArticle.TABLET) {
                        Tablet tempProduct = new Tablet(manufacturer, modelName, briefDescription, screenSizeInInches,
                                internalMemorySize, purchasePrice, sellPrice, id);
                        productAdded = warehouse.addToWarehouse(tempProduct);
                    } else if (typeProd == Article.TypeOfArticle.SMARTPHONE) {
                        Smartphone tempProduct = new Smartphone(manufacturer, modelName, briefDescription, screenSizeInInches,
                                internalMemorySize, purchasePrice, sellPrice, id);
                        productAdded = warehouse.addToWarehouse(tempProduct);
                    } else if (typeProd == Article.TypeOfArticle.NOTEBOOK) {
                        Notebook tempProduct = new Notebook(manufacturer, modelName, briefDescription, screenSizeInInches,
                                internalMemorySize, purchasePrice, sellPrice, id);
                        productAdded = warehouse.addToWarehouse(tempProduct);
                    }

                    if (productAdded) {
                        System.out.println("Product added successfully");
                    } else {
                        System.out.println("Error, couldn't add the product to the warehouse");
                    }

                    break;
                case "2":
                    operation.printWarehouseContents();
                    break;
                case "3":
                    userCartMenu();
                    break;
                case "4":
                    System.out.print("\n Please enter the TYPE of the product you wish to search for: \n");
                    operation.searchType();
                    break;
                case "5":
                    System.out.println("\n Insert the manufacturer of the product \n");
                    String manufacturerToSearch = menuScan.next();
                    List<Article> listManufacturer = operation.findByManifacturer(manufacturerToSearch);
                    utility.checkIfEmpty(listManufacturer);
                    break;
                case "6":
                    System.out.println("\n Insert the model of the product \n");
                    String modelToSearch = menuScan.next();
                    List<Article> listModel = operation.findByModel(modelToSearch);
                    utility.checkIfEmpty(listModel);
                    break;
                case "7":
                    System.out.println("\n Insert the selling price to search \n");
                    Utility.checkInput(menuScan);
                    int getPriceOfSellingToSearch = menuScan.nextInt();
                    List<Article> listSelling = operation.findSellingPrice(getPriceOfSellingToSearch);
                    utility.checkIfEmpty(listSelling);
                    break;
                case "8":
                    System.out.println("\n Insert purchase price to find \n");
                    Utility.checkInput(menuScan);
                    int price = menuScan.nextInt();
                    List<Article> listPrice = operation.findBuyingPrice(price);
                    utility.checkIfEmpty(listPrice);
                    break;
                case "9":
                    System.out.println("\n Find product between this selling range price. \n");
                    System.out.println("\n Insert minimum price \n ");
                    Utility.checkInput(menuScan);
                    int priceMin = menuScan.nextInt();
                    System.out.println("\n Insert maximum price \n");
                    Utility.checkInput(menuScan);
                    int priceMax = menuScan.nextInt();
                    if (utility.checkMinMax(priceMin, priceMax)) {
                        List<Article> listRange = operation.findRangePrice(priceMin, priceMax);
                        utility.checkIfEmpty(listRange);
                    } else {
                        System.out.println("\n Error: Maximum price is lower the minimum price \n");
                    }
                    break;
                case "10":
                    System.out.println("Insert type of Article");
                    String input = menuScan.next().toUpperCase();
                    Article.TypeOfArticle type = utility.inputToTypeOfArticle(input);
                    Double result = operation.findAvgPrice(type);
                    if (result != null) {
                        System.out.println("Avg Price of " + input + ": " + result);
                    } else {
                        System.out.println("We don't sell this type of article");
                    }
                    break;
                case "11":
                    if (cart.getUserCart().isEmpty()) {
                        System.out.println("\n user cart is empty \n");
                    } else {
                        cart.printCart();
                        System.out.println("your actual price is : " + cart.calculateTotalCart());
                        System.out.println("\n Would you like to complete your purchase?");
                        System.out.println(
                                "Digit 'YES' if you want to purchase the articles, 'NO' if you don't want to buy the articles anymore, digit a random char to go back to the menu");
                        String choice = menuScan.next();
                        cart.finalizePurchase(choice);
                    }
                    break;
                default:
                    System.out.println("\n Something went wrong \n");
                    break;
            }
        } while (continueMenu);
    }

    public void userCartMenu() {
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
                    cart.addToCart();
                    break;
                case "2":
                    System.out.print("Enter ID of the product:");
                    cart.addToCartById();
                    break;
                case "3":
                    cart.printCart();
                    break;
                case "4":
                    System.out.print("Enter the INDEX of the thing you wish to remove:");
                    cart.removeFromCart();
                    break;
                case "5":
                    System.out.print("Enter the ID of the thing you wish to remove:");
                    cart.removeFromCartById();
                    break;
                case "6":
                    System.out.println("\nTotal Price is : " + cart.calculateTotalCart());
                    break;
                default:
                    System.out.println("\n Something went wrong \n");
                    break;
            }
        } while (continueMenuOperations);

    }

}
