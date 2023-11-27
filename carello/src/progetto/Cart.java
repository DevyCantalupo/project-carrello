package progetto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cart {
    static Scanner input = new Scanner(System.in);
    private static List<Article> userCart = new ArrayList<>();

    public Cart(List<Article> userCart) {
        Cart.userCart = userCart;
    }

    public static List<Article> getUserCart() {
        return userCart;
    }

    public static void addToCart() {
        int userIdex = input.nextInt();
        if (checkIndex(userIdex, OperationInWarehouse.getWarehouse())) {
            userCart.add(OperationInWarehouse.getWarehouse().get(userIdex));
            OperationInWarehouse.getWarehouse().remove(userIdex);
            System.out.println("Added " + userIdex);
        } else {
            System.out.println("Incorect index");
        }
    }

    public static void printCart() {
        if (userCart.isEmpty()) {
            System.out.println("\n user cart is empty \n");
        } else {
            System.out.println("\nYour cart has :\n");
            for (int i = 0; i < userCart.size(); i++) {
                System.out.println("Index [" + i + "];" + userCart.get(i) + "\n");
            }
        }

    }

    public static void removeFromCart() {
        int userIdex = input.nextInt();
        if (checkIndex(userIdex, userCart)) {
            OperationInWarehouse.getWarehouse().add(userCart.get(userIdex));
            userCart.remove(userIdex);
        } else {
            System.out.println("Incorrect Index");
        }
    }

    public static double calculateTotalCart() {
        double total = 0.0;
        for (Article article : userCart) {
            total += article.getPriceOfSelling();
        }
        return total;
    }

    public static void addToCartById() {
        Article toAdd = null;
        String userId = input.next();
        for (Article a : OperationInWarehouse.getWarehouse()) {
            if (a.getId().equals(userId)) {
                toAdd = a;
            }
        }

        if (toAdd != null) {
            userCart.add(toAdd);
            OperationInWarehouse.getWarehouse().remove(toAdd);
        } else {
            System.out.println("Incorrect id");
        }
    }

    public static void removeFromCartById() {
        Article toRemove = null;
        String userId = input.next();
        for (Article a : userCart) {
            if (a.getId().equals(userId)) {
                toRemove = a;
            }
        }
        if (toRemove != null) {
            userCart.remove(toRemove);
            OperationInWarehouse.getWarehouse().add(toRemove);
        } else {
            System.out.println("Incorrect id");
        }
    }


    public static void finalizePurchase() {

        String choice = input.next();
        switch (choice.toUpperCase()) {
            case "YES":
                userCart.clear();
                System.out.println("\n Thanks for the purchase \n");
                break;
            case "NO":
                OperationInWarehouse.getWarehouse().addAll(userCart);
                userCart.clear();
                System.out.println("\n I hope you'll spend some money next time \n");
                break;
            default:
                System.out.println("returning to menu");
                break;
        }
    }

    public static boolean checkIndex(int a, List<Article> list) {
        return a >= 0 && a < list.size();
    }
}
