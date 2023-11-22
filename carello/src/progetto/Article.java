package progetto;

public interface Article {
    public enum TypeOfArticle {
        TABLET, SMARTPHONE, NOTEBOOK
    }

    public TypeOfArticle type = null;
    public String manufacturer = null;
    public String model = null;
    public String description = null;
    public Double screenSizeInInches = null;
    public Integer memory = null;
    public Double priceOfBuying = null;
    public Double priceOfSelling = null;
    public String id = null;


    public TypeOfArticle getType();

    public String getManufacturer();

    public String getModel();

    public double getPriceOfBuying();

    public double getPriceOfSelling();

    public String getId();
}
