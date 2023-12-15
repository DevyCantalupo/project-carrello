package progetto;

import java.util.Scanner;

public class ManageUserInput {

    static Scanner scan = new Scanner(System.in);

    public static Article.TypeOfArticle validateTypeInput(){
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

    public static String descriptionInput(){
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
}
