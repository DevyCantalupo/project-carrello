package progetto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Warehouse {
    static List<Article> warehouse = new ArrayList<>();

    public Warehouse(List<Article> warehouse) {
        Warehouse.warehouse = warehouse;
    }

    public static void printWarehouseContents() throws Exception {

        for(int i = 0; i < warehouse.size(); i++){
            System.out.println("Index [" +i +"]; "+warehouse.get(i));
        }
        if(warehouse.isEmpty()){
            throw new Exception("The warehouse is empty");
        }
    }

    public static void addToWarehouse() {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the TYPE of the product");
        String inputType = input.nextLine();
        Article.TypeOfArticle type = null;
        if (Objects.equals(inputType, "TABLET")) {
             type = Article.TypeOfArticle.TABLET;
        }
        if (Objects.equals(inputType, "SMARTPHONE")) {
            type = Article.TypeOfArticle.SMARTPHONE;
        }
        if (Objects.equals(inputType, "NOTEBOOK")) {
            type = Article.TypeOfArticle.NOTEBOOK;
        }
        System.out.println("Enter the MANUFACTURER of the product");
        String manufacturer = input.nextLine();
        System.out.println("Enter the MODEL NAME of the product");
        String modelName = input.nextLine();
        System.out.println("Enter a brief description for the product");
        String briefDescription = input.nextLine();
        System.out.println("Enter the SCREEN SIZE of the product");
        double screenSizeInInches = input.nextDouble();
        System.out.println("Enter the INTERNAL MEMORY SIZE of the product");
        int internalMemorySize = input.nextInt();
        System.out.println("Enter the PURCHASE PRICE of the product");
        double purchasePrice = input.nextDouble();
        System.out.println("Enter the SELL PRICE of the product");
        double sellPrice = input.nextDouble();
        int id = GenerateUniqueId.generateUniqueID();
        System.out.println("Assigned unique ID for the product is: " +id);

        if(type == Article.TypeOfArticle.TABLET){
            Tablet tempProduct = new Tablet(manufacturer, modelName, briefDescription, screenSizeInInches,
                    internalMemorySize, purchasePrice, sellPrice, id);
            warehouse.add(tempProduct);
        }
        if(type == Article.TypeOfArticle.SMARTPHONE){
            Smartphone tempProduct = new Smartphone(manufacturer, modelName, briefDescription, screenSizeInInches,
                    internalMemorySize, purchasePrice, sellPrice, id);
            warehouse.add(tempProduct);
        }
        if(type == Article.TypeOfArticle.NOTEBOOK){
            Notebook tempProduct = new Notebook(manufacturer, modelName, briefDescription, screenSizeInInches,
                    internalMemorySize, purchasePrice, sellPrice, id);
            warehouse.add(tempProduct);
        }
    }

    public static void searchType() throws Exception{
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the TYPE of the product you wish to search for: ");
        String userType = input.nextLine();
        for(int i = 0; i < Warehouse.warehouse.size(); i++){
            if(Objects.equals(userType, "TABLET")){
                if(Warehouse.warehouse.get(i).getType() == Article.TypeOfArticle.TABLET){
                    System.out.println("Index[" +i +"]; " +Warehouse.warehouse.get(i));
                }
            }else if(Objects.equals(userType, "SMARTPHONE")){
                if(Warehouse.warehouse.get(i).getType() == Article.TypeOfArticle.SMARTPHONE){
                    System.out.println("Index[" +i +"]; " +Warehouse.warehouse.get(i));
                }
            }else if(Objects.equals(userType, "NOTEBOOK")){
                if(Warehouse.warehouse.get(i).getType() == Article.TypeOfArticle.NOTEBOOK){
                    System.out.println("Index[" +i +"]; " +Warehouse.warehouse.get(i));
                }
            }
        }
        if((!(Objects.equals(userType, "TABLET")) && (!(Objects.equals(userType, "SMARTPHONE")) && (!(Objects.equals(userType, "NOTEBOOK")))))){
            throw new Exception("No such product type in the warehouse");
        }
    }

    void addWarehouse(Article a) {
        warehouse.add(a);
    }


    //Un metodo che permetta la ricerca per prezzo di acquisto
    //Dovrà resitutire la lista di dispositivi frutto della ricerca
    // o un errore nel caso in cui la ricerca non produca risultati.
    public static List<Article> findBuyingPrice(int price) throws Exception {
        List<Article> listPrice = new ArrayList<Article>();
        for (Article a : warehouse) {
            if (a.getPriceOfBuying() == price) {
                listPrice.add(a);
            }
        }
        if (listPrice.isEmpty()) {
            throw new Exception("Nessun prodotto a quel prezzo di acquisto in magazzino");
        } else {
            return listPrice;
        }
    }

    //Un metodo che permetta la ricerca in un determinato range di prezzo
    // Dovrà resitutire la lista di dispositivi frutto della ricerca
    // o un errore nel caso in cui la ricerca non produca risultati.
    public static List<Article> findRangePrice(int priceMin, int priceMax) throws Exception {
        List<Article> listRange = new ArrayList<Article>();
        for (Article a : warehouse) {
            if (a.getPriceOfSelling() >= priceMin && a.getPriceOfSelling() <= priceMax) {
                listRange.add(a);
            }
        }
        if (listRange.isEmpty()) {
            throw new Exception("Nessun prodotto in quel range di prezzo in magazzino");
        } else {
            return listRange;
        }
    }

    //Un metodo che calcoli la spesa media di acquisto per singolo dispositivo
    // e che restituisca il valore medio.
    //dovrà resitutire la lista di dispositivi frutto della ricerca
    // o un errore nel caso in cui la ricerca non produca risultati.
    public static double findAvgPrice(String type) throws Exception {
        List<Article> listaVG = new ArrayList<Article>();
        double avg = 0;
        int numArt = 0;
        for (Article art : warehouse) {
            if (art.getType() == Article.TypeOfArticle.valueOf(type)) {
                avg += art.getPriceOfBuying();
                numArt++;
            }
        }
        return avg / numArt;
    }
}
