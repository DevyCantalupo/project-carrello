package progetto.Utility;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.UUID;

import progetto.Items.Article;

public class Utility {

    public static String generateUniqueID() {
        return UUID.randomUUID().toString();
    }

    public static boolean isEnum(String type) {
        return (Objects.equals(type, String.valueOf(Article.TypeOfArticle.TABLET))
                || Objects.equals(type, String.valueOf(Article.TypeOfArticle.SMARTPHONE))
                || Objects.equals(type, String.valueOf(Article.TypeOfArticle.NOTEBOOK)));
    }

    public static boolean checkIndex(int a, List<Article> list) {
        return a >= 0 && a < list.size();
    }

    public void checkIfEmpty(List<Article> list) {
        if (list.isEmpty()) {
            System.out.println("\n No Article were found  \n");
        } else {
            System.out.println("\n" + list + "\n");
            list.clear();
        }
    }

    public static void checkInput(Scanner input) {
        while (!input.hasNextInt()) {
            System.out.println("invalid input , try again");
            input.next();
        }
    }

    static Scanner scan = new Scanner(System.in);

    public static Article.TypeOfArticle validateTypeInput() {
        Article.TypeOfArticle type = null;
        boolean validType = false;
        do {
            System.out.println("Enter the TYPE of the product you want to add");
            String inputType = scan.nextLine().toUpperCase();
            switch (inputType) {
                case "TABLET" -> {
                    type = Article.TypeOfArticle.TABLET;
                    validType = true;
                }
                case "SMARTPHONE" -> {
                    type = Article.TypeOfArticle.SMARTPHONE;
                    validType = true;
                }
                case "NOTEBOOK" -> {
                    type = Article.TypeOfArticle.NOTEBOOK;
                    validType = true;
                }
                default -> System.out.println("Invalid type of product. Please enter a valid product type.");
            }
        } while (!validType);
        return type;
    }

    public static String descriptionInput() {
        System.out.println("Do you wish to add a brief description to this product? y/n");
        char choice = scan.next().toUpperCase().charAt(0);
        String description = null;
        if (choice == 'Y') {
            System.out.println("Description: ");
            scan.nextLine();
            description = scan.nextLine();
        }
        return description;
    }

    public Article.TypeOfArticle inputToTypeOfArticle(String input) {
        return switch (input) {
            case "NOTEBOOK" -> Article.TypeOfArticle.NOTEBOOK;
            case "TABLET" -> Article.TypeOfArticle.TABLET;
            case "SMARTPHONE" -> Article.TypeOfArticle.SMARTPHONE;
            default -> null;
        };
    }
}

