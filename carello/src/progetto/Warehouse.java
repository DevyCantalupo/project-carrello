package progetto;

import java.util.*;

public class Warehouse {
    static List<Article> warehouse = new ArrayList<>();

    public Warehouse(List<Article> warehouse) {
        Warehouse.warehouse = warehouse;
    }

    public static void printWarehouseContents() throws Exception {

        for (int i = 0; i < warehouse.size(); i++) {
            System.out.println("Index [" + i + "]; " + warehouse.get(i));
        }
        if (warehouse.isEmpty()) {
            throw new Exception("The warehouse is empty");
        }
    }

    public static void addToWarehouse() {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the TYPE of the product");
        String inputType = input.nextLine().toUpperCase();
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
        System.out.println("Assigned unique ID for the product is: " + id);

        if (type == Article.TypeOfArticle.TABLET) {
            Tablet tempProduct = new Tablet(manufacturer, modelName, briefDescription, screenSizeInInches,
                    internalMemorySize, purchasePrice, sellPrice, id);
            warehouse.add(tempProduct);
        }
        if (type == Article.TypeOfArticle.SMARTPHONE) {
            Smartphone tempProduct = new Smartphone(manufacturer, modelName, briefDescription, screenSizeInInches,
                    internalMemorySize, purchasePrice, sellPrice, id);
            warehouse.add(tempProduct);
        }
        if (type == Article.TypeOfArticle.NOTEBOOK) {
            Notebook tempProduct = new Notebook(manufacturer, modelName, briefDescription, screenSizeInInches,
                    internalMemorySize, purchasePrice, sellPrice, id);
            warehouse.add(tempProduct);
        }
    }

    public static void searchType() throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the TYPE of the product you wish to search for: ");
        String userType = input.nextLine().toUpperCase();
        for (int i = 0; i < Warehouse.warehouse.size(); i++) {
            if (Objects.equals(userType, "TABLET")) {
                if (Warehouse.warehouse.get(i).getType() == Article.TypeOfArticle.TABLET) {
                    System.out.println("Index[" + i + "]; " + Warehouse.warehouse.get(i));
                }
            } else if (Objects.equals(userType, "SMARTPHONE")) {
                if (Warehouse.warehouse.get(i).getType() == Article.TypeOfArticle.SMARTPHONE) {
                    System.out.println("Index[" + i + "]; " + Warehouse.warehouse.get(i));
                }
            } else if (Objects.equals(userType, "NOTEBOOK")) {
                if (Warehouse.warehouse.get(i).getType() == Article.TypeOfArticle.NOTEBOOK) {
                    System.out.println("Index[" + i + "]; " + Warehouse.warehouse.get(i));
                }
            }
        }
        if ((!(Objects.equals(userType, "TABLET"))
                && (!(Objects.equals(userType, "SMARTPHONE")) && (!(Objects.equals(userType, "NOTEBOOK")))))) {
            throw new Exception("No such product type in the warehouse");
        }
    }

    void addWarehouse(Article a) {
        warehouse.add(a);
    }


    public static List<Article> findBuyingPrice() throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Insert purchase price to find");
        int price = input.nextInt();
        List<Article> listPrice = new ArrayList<Article>();
        for (Article a : warehouse) {
            if (a.getPriceOfBuying() == price) {
                listPrice.add(a);
            }
        }
        if (listPrice.isEmpty()) {
            throw new Exception("There are no product with this purchase price in the warehouse");
        } else {
            return listPrice;
        }
    }

    public static List<Article> findRangePrice() throws Exception {
        Scanner input = new Scanner(System.in);
        List<Article> listRange = new ArrayList<Article>();
        System.out.println("Find product between this selling range price. \n Insert minimum price");
        int priceMin = input.nextInt();
        System.out.println("Insert maximum price");
        int priceMax = input.nextInt();
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

    public static double findAvgPrice() throws Exception {
        //TODO gestire se viene inserito un articolo inesistente
        Scanner input = new Scanner(System.in);
        System.out.println("Insert type of Article");
        String type = input.next().toUpperCase();
        double avg = 0;
        int numArt = 0;
        for (Article art : warehouse) {
            if (art.getType() == Article.TypeOfArticle.valueOf(type)) {
                avg += art.getPriceOfBuying();
                numArt++;
            }
        }
        avg = avg / numArt;
        if (avg != 0) {
            return avg;
        } else {
            throw new Exception("This type of Article is not available in the warehouse");
        }

    }


    public static List<Article> findByManifacturer() throws Exception {

        List<Article> listManufacturer = new ArrayList<Article>();
        Scanner input = new Scanner(System.in);
        System.out.println("inserisci il produttore con cui filtrare la ricerca");
        String manufacturerToSearch = input.nextLine();
        for (Article a : warehouse) {
            if (a.getManufacturer().equals(manufacturerToSearch)) {
                listManufacturer.add(a);
            }
        }

        if (listManufacturer.isEmpty()) {
            throw new Exception("Nessun articolo di quel produttore nel magazzino");
        }

        return listManufacturer;
    }

    public static List<Article> findByModel() throws Exception {

        List<Article> listModel = new ArrayList<Article>();
        Scanner input = new Scanner(System.in);
        System.out.println("inserisci il modello con cui filtrare la ricerca");
        String modelToSearch = input.nextLine();
        for (Article a : warehouse) {
            if (a.getModel().equals(modelToSearch)) {
                listModel.add(a);
            }
        }

        if (listModel.isEmpty()) {
            throw new Exception("Nessun articolo di quel modello nel magazzino");
        }

        return listModel;
    }


    public static List<Article> findSellingPrice() throws Exception {
        List<Article> listPriceOfSelling = new ArrayList<Article>();
        Scanner input = new Scanner(System.in);
        System.out.println("inserisci il prezzo di vendita con cui filtrare la ricerca");
        int getPriceOfSellingToSearch = input.nextInt();
        for (Article a : warehouse) {
            if (a.getPriceOfSelling() == getPriceOfSellingToSearch) {
                listPriceOfSelling.add(a);
            }
        }
        if (listPriceOfSelling.isEmpty()) {
            throw new Exception("Nessun prodotto a quel prezzo di vendita in magazzino");
        } else {
            return listPriceOfSelling;
        }
    }

    public static void productsAlreadyInWarehouse() {
        Article product1 = new Tablet("Susa", "VK64", "Yep, it's a tablet", 10.5, 64, 80, 59.99,
                GenerateUniqueId.generateUniqueID());
        Warehouse.warehouse.add(product1);
        Article product2 = new Tablet("SpyPhone", "69", "James Bond approves", 2, 2048, 6000, 10000,
                GenerateUniqueId.generateUniqueID());
        Warehouse.warehouse.add(product2);
        Article product3 = new Smartphone("Big", "Chungus", "It's big", 20, 512, 400, 800,
                GenerateUniqueId.generateUniqueID());
        Warehouse.warehouse.add(product3);
        Article product4 = new Smartphone("Susa", "Honor", "Good camera", 6, 128, 250, 500,
                GenerateUniqueId.generateUniqueID());
        Warehouse.warehouse.add(product4);
        Article product5 = new Notebook("SpyPhone", "SlimJim", "We make notebooks too", 13, 4096, 8999, 24999,
                GenerateUniqueId.generateUniqueID());
        Warehouse.warehouse.add(product5);
        Article product6 = new Notebook("Tencent", "YadMYqRiN", "It's cheap ;)", 14, 32, 0.05, 0.1,
                GenerateUniqueId.generateUniqueID());
        Warehouse.warehouse.add(product6);

        Tablet tablet1 = new Tablet("Huawei", "xxx", "bello", 22, 150, 50, 160, GenerateUniqueId.generateUniqueID());
        Warehouse.warehouse.add(tablet1);
        Tablet tablet2 = new Tablet("Hp", "x222", "brutto", 10, 240, 80, 200, GenerateUniqueId.generateUniqueID());
        Warehouse.warehouse.add(tablet2);
        Smartphone smartphone1 = new Smartphone("Nokia", "3210", null, 11, 90, 150, 300,
                GenerateUniqueId.generateUniqueID());
        Warehouse.warehouse.add(smartphone1);
        Smartphone smartphone2 = new Smartphone("Iphone", "12", "Funziona", 31, 120, 150, 400,
                GenerateUniqueId.generateUniqueID());
        Warehouse.warehouse.add(smartphone2);
        Notebook notebook1 = new Notebook("Hp", "h300", null, 10, 222, 250, 600, GenerateUniqueId.generateUniqueID());
        Warehouse.warehouse.add(notebook1);
        Notebook notebook2 = new Notebook("Apple", "pro", "vecchio", 22, 400, 300, 800,
                GenerateUniqueId.generateUniqueID());
        Warehouse.warehouse.add(notebook2);
    }
}
