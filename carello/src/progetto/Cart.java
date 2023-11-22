package progetto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cart {
    static Scanner input = new Scanner(System.in);
    static List<Article> userCart = new ArrayList<>();

    public Cart(List<Article> userCart) {
        Cart.userCart = userCart;
    }

    public static List<Article> getUserCart() {
        return userCart;
    }

    public static void addToCart() {
        int userIdex = input.nextInt();
        System.out.println("Added " + userIdex);
        userCart.add(OperationInWarehouse.warehouse.get(userIdex));
        OperationInWarehouse.warehouse.remove(userIdex);
    }

    public static void printCart() {
        for (int i = 0; i < userCart.size(); i++) {
            System.out.println("\n Index [" + i + "];" + userCart.get(i) + "\n");
        }
    }

    public static void removeFromCart() {
        int userIdex = input.nextInt();
        OperationInWarehouse.warehouse.add(userCart.get(userIdex));
        userCart.remove(userIdex);
    }

}
