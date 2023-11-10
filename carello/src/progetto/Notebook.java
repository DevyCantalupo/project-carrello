package progetto;

public class Notebook implements Article {

    TypeOfArticle type = TypeOfArticle.NOTEBOOK;
    private String manufacturer;
    private String model;
    private String description;
    private int display;
    private int memory;
    private double priceOfBuying;
    private double priceOfSelling;
    private int id;

    public Notebook(String manufacturer, String model, String description, int display, int memory, double priceOfBuying, double priceOfSelling, int id) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.description = description;
        this.display = display;
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
                ", display=" + display +
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

    public int getId() {
        return id;
    }
}
