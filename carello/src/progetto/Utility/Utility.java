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
}
