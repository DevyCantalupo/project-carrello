package progetto.Items;

public class Notebook implements Article {

    TypeOfArticle type = TypeOfArticle.NOTEBOOK;
    private String manufacturer;
    private String model;
    private String description;
    private double screenSizeInInches;
    private int memory;
    private double priceOfBuying;
    private double priceOfSelling;
    private String id;

    public Notebook(String manufacturer, String model, String description, double screenSizeInInches, int memory, double priceOfBuying, double priceOfSelling, String id) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.description = description;
        this.screenSizeInInches = screenSizeInInches;
        this.memory = memory;
        this.priceOfBuying = priceOfBuying;
        this.priceOfSelling = priceOfSelling;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "type=" + type +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", description='" + description + '\'' +
                ", screenSizeInInches=" + screenSizeInInches +
                ", memory=" + memory +
                ", priceOfBuying=" + priceOfBuying +
                ", priceOfSelling=" + priceOfSelling +
                ", id=" + id +
                '}';
    }

    public TypeOfArticle getType() {
        return type;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public double getPriceOfBuying() {
        return priceOfBuying;
    }

    public double getPriceOfSelling() {
        return priceOfSelling;
    }

    public String getId() {
        return id;
    }
}
