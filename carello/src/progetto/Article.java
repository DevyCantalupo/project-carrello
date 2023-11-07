package progetto;

public interface Article {
    public enum TypeOfArticle {
        TABLET, SMARTPHONE, NOTEBOOK
    }

    public String manufacturer = null;
    public String model = null;
    public String description = null;
    public Double display = null;
    public Integer memory = null;
    public Double priceOfBuying = null;
    public Double priceOfSelling = null;
    public Integer id = null;

}
