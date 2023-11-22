package progetto;

import java.util.*;

public class OperationInWarehouse {
    static Scanner input = new Scanner(System.in);
    static List<Article> warehouse = new ArrayList<>();

    public OperationInWarehouse(List<Article> warehouse) {
        OperationInWarehouse.warehouse = warehouse;
    }

    public static void printWarehouseContents() {
        if (warehouse.isEmpty()) {
            System.out.println("The warehouse is empty");
        } else {
            for (int i = 0; i < warehouse.size(); i++) {
                System.out.println("\n Index [" + i + "]; " + warehouse.get(i));
            }
        }
    }

    // todo
    public static void addToWarehouse() {
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
        String id = GenerateUniqueId.generateUniqueID();
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

    public static void searchType() {
        String userType = input.nextLine().toUpperCase();
        boolean found = false;
        for (int i = 0; i < warehouse.size(); i++) {
            Article.TypeOfArticle articleType = warehouse.get(i).getType();
            if ((Objects.equals(userType, "TABLET") && articleType == Article.TypeOfArticle.TABLET) ||
                    (Objects.equals(userType, "NOTEBOOK") && articleType == Article.TypeOfArticle.NOTEBOOK) ||
                    (Objects.equals(userType, "SMARTPHONE") && articleType == Article.TypeOfArticle.SMARTPHONE)) {
                System.out.println("index[" + i + "];" + warehouse.get(i) + "\n");
                found = true;
            }
        }
        if (!(found)) {
            System.out.println("The product of that type in not found ");
        }
    }

    void addWarehouse(Article a) {
        warehouse.add(a);
    }

    public static List<Article> findBuyingPrice() {
        int price = input.nextInt();
        List<Article> listPrice = new ArrayList<Article>();

        for (Article a : warehouse) {
            if (a.getPriceOfBuying() == price) {
                listPrice.add(a);
            }
        }
        if (listPrice.isEmpty()) {
            System.out.println("\n The product of that price is not found  \n");
        } else {
            System.out.println("\n" + listPrice + "\n");
        }
        return listPrice;
    }

    public static List<Article> findRangePrice() {
        System.out.println("\n Insert minimum price \n ");
        List<Article> listRange = new ArrayList<Article>();
        int priceMin = input.nextInt();
        System.out.println("\n Insert maximum price \n");
        int priceMax = input.nextInt();
        for (Article a : warehouse) {
            if (a.getPriceOfSelling() >= priceMin && a.getPriceOfSelling() <= priceMax) {
                listRange.add(a);
            }
        }
        if (listRange.isEmpty()) {
            System.out.println("\n The product of that price is not found  \n");
        } else {
            System.out.println("\n" + listRange + "\n");
        }
        return listRange;
    }

    public static double findAvgPrice() throws Exception {
        // TODO gestire se viene inserito un articolo inesistente
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

    public static List<Article> findByManifacturer() {

        List<Article> listManufacturer = new ArrayList<Article>();
        String manufacturerToSearch = input.nextLine();
        for (Article a : warehouse) {
            if (a.getManufacturer().equals(manufacturerToSearch)) {
                listManufacturer.add(a);
            }
        }
        if (listManufacturer.isEmpty()) {
            System.out.println("\n There are no article from that manufacturer \n");
        } else {
            System.out.println("\n" + listManufacturer + "\n");
        }
        return listManufacturer;
    }

    public static List<Article> findByModel() {
        List<Article> listModel = new ArrayList<Article>();
        String modelToSearch = input.nextLine();
        for (Article a : warehouse) {
            if (a.getModel().equals(modelToSearch)) {
                listModel.add(a);
            }
        }
        if (listModel.isEmpty()) {
            System.out.println("\n There are no article with that model \n");
        } else {
            System.out.println("\n" + listModel + "\n");
        }
        return listModel;
    }

    public static List<Article> findSellingPrice() {
        List<Article> listPriceOfSelling = new ArrayList<Article>();
        int getPriceOfSellingToSearch = input.nextInt();
        for (Article a : warehouse) {
            if (a.getPriceOfSelling() == getPriceOfSellingToSearch) {
                listPriceOfSelling.add(a);
            }
        }
        if (listPriceOfSelling.isEmpty()) {
            System.out.println("\n There are no article with that selling price \n");
        } else {
            System.out.println("\n" + listPriceOfSelling + "\n");
        }
        return listPriceOfSelling;
    }

}
