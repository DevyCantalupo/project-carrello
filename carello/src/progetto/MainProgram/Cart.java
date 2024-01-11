package progetto.MainProgram;

import progetto.Items.Article;
import progetto.FakeDatabase.Warehouse;
import progetto.Utility.Utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cart {
    static Scanner input = new Scanner(System.in);
    private List<Article> userCart;
    Utility utility= new Utility();

    public Cart() {
        this.userCart = new ArrayList<>();
    }

    public List<Article> getUserCart() {
        return userCart;
    }

    public void addToCart() {
        while (!input.hasNextInt()) {
            System.out.println("\n insert a valid option");
            input.next();
        }
        int userIdex = input.nextInt();
        if (utility.checkIndex(userIdex, Warehouse.getWarehouse())) {
            userCart.add(Warehouse.getWarehouse().get(userIdex));
            Warehouse.getWarehouse().remove(userIdex);
            System.out.println("Added " + userIdex);
        } else {
            System.out.println("\n Incorect index");
        }
    }

    public void printCart() {
        if (userCart.isEmpty()) {
            System.out.println("\n user cart is empty \n");
        } else {
            System.out.println("\n Currently in your shopping cart you have :\n");
            for (int i = 0; i < userCart.size(); i++) {
                System.out.println("Index [" + i + "];" + userCart.get(i) + "\n");
            }
        }

    }

    public void removeFromCart() {
        while (!input.hasNextInt()) {
            System.out.println("\n insert a valid option");
            input.next();
        }
        int userIdex = input.nextInt();
        if (utility.checkIndex(userIdex, userCart)) {
            Warehouse.getWarehouse().add(userCart.get(userIdex));
            userCart.remove(userIdex);
        } else {
            System.out.println("Incorrect Index");
        }
    }

    public double calculateTotalCart() {
        double total = 0.0;
        for (Article article : userCart) {
            total += article.getPriceOfSelling();
        }
        return total;
    }

    public void addToCartById() {
        Article toAdd = null;
        String userId = input.next();
        for (Article a : Warehouse.getWarehouse()) {
            if (a.getId().equals(userId)) {
                toAdd = a;
            }
        }
        if (toAdd != null) {
            userCart.add(toAdd);
            Warehouse.getWarehouse().remove(toAdd);
        } else {
            System.out.println("Incorrect id");
        }
    }

    public void removeFromCartById() {
        Article toRemove = null;
        String userId = input.next();
        for (Article a : userCart) {
            if (a.getId().equals(userId)) {
                toRemove = a;
            }
        }
        if (toRemove != null) {
            userCart.remove(toRemove);
            Warehouse.getWarehouse().add(toRemove);
        } else {
            System.out.println("Incorrect id");
        }
    }

    public  void finalizePurchase(String choice) {
        switch (choice.toUpperCase()) {
            case "YES":
                userCart.clear();
                System.out.println("\n Thanks for the purchase returning to main menu  \n");
                break;
            case "NO":
                Warehouse.getWarehouse().addAll(userCart);
                userCart.clear();
                System.out.println("\n I hope you'll spend some money next time \n");
                break;
            default:
                System.out.println("returning to menu");
                break;
        }
    }

}
