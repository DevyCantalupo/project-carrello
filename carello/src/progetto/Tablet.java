package progetto;

public class Tablet implements Article {

    private String manufacturer;
    private String model;
    private String description;
    private String display;
    private String memory;
    private double priceOfBuying;
    private double priceOfSelling;
    private int id;

    public Tablet(String manufacturer, String model, String description, String display, String memory, double priceOfBuying, double priceOfSelling, int id) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.description = description;
        this.display = display;
        this.memory = memory;
        this.priceOfBuying = priceOfBuying;
        this.priceOfSelling = priceOfSelling;
        this.id = id;
    }
}
