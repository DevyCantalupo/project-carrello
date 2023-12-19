package progetto.Utility;

import java.util.Objects;

import progetto.Items.Article;

public class Validation {
    public static boolean isEnum(String type) {
        return (Objects.equals(type, String.valueOf(Article.TypeOfArticle.TABLET)) || Objects.equals(type, String.valueOf(Article.TypeOfArticle.SMARTPHONE)) || Objects.equals(type, String.valueOf(Article.TypeOfArticle.NOTEBOOK)));
    }
}
