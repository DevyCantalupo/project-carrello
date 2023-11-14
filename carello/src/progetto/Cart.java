package progetto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cart {

    static List<Article> userCart = new ArrayList<>();

    public Cart(List<Article> userCart) {
        Cart.userCart = userCart;
    }

    public static List<Article> getUserCart() {
        return userCart;
    }

    public static void userCartOperations() {

        System.out.println("Press 0 to return to the previous menu");
        System.out.println("Press 1 to add a product to the cart");
        System.out.println("Press 2 to see what is in your shopping cart");
        System.out.println("Press 3 to remove an item from your shopping cart");

        boolean continueMenuOperations = true;
        Scanner input = new Scanner(System.in);
        do {
            System.out.print("Insert your cart menu option: ");
            int menuChoice = input.nextInt();
            switch (menuChoice) {
                case 0:
                    continueMenuOperations = false;
                    break;
                case 1:
                    System.out.print("Enter INDEX of the product:");

                    int userIdex = input.nextInt();
                    System.out.println("Added " + userIdex);
                    userCart.add(Warehouse.warehouse.get(userIdex));
                    Warehouse.warehouse.remove(userIdex);
                    break;
                case 2:
                    System.out.println("You cart has:");
                    for (int i = 0; i < userCart.size(); i++) {
                        System.out.println("Index [" + i + "]; " + userCart.get(i));
                    }
                    break;
                case 3:
                    System.out.print("Enter the INDEX of the thing you wish to remove:");
                    userIdex = input.nextInt();
                    Warehouse.warehouse.add(userCart.get(userIdex));
                    userCart.remove(userIdex);
                    break;
            }
        } while (continueMenuOperations);

    }
}
