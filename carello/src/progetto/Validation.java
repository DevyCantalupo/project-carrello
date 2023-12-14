package progetto;

import java.util.Objects;

public class Validation {
    public static boolean isEnum(String type) {
        return (Objects.equals(type, String.valueOf(Article.TypeOfArticle.TABLET)) || Objects.equals(type, String.valueOf(Article.TypeOfArticle.SMARTPHONE)) || Objects.equals(type, String.valueOf(Article.TypeOfArticle.NOTEBOOK)));
    }
}
