package progetto;

import java.util.*;

public class OperationInWarehouse {
    static Scanner input = new Scanner(System.in);
    private static List<Article> warehouse = new ArrayList<>();

    public static List<Article> getWarehouse() {
        return warehouse;
    }

    public OperationInWarehouse() {
    }

    public void printWarehouseContents() {
        if (warehouse.isEmpty()) {
            System.out.println("The warehouse is empty");
        } else {
            for (int i = 0; i < warehouse.size(); i++) {
                System.out.println("\n Index [" + i + "]; " + warehouse.get(i));
            }
        }
    }

    public void addToWarehouse() {
        Article.TypeOfArticle type = null;
        boolean correctType = false;
        do {
            String inputType = input.nextLine().toUpperCase();
            if (Objects.equals(inputType, "TABLET")) {
                type = Article.TypeOfArticle.TABLET;
                correctType = true;
            } else if (Objects.equals(inputType, "SMARTPHONE")) {
                type = Article.TypeOfArticle.SMARTPHONE;
                correctType = true;
            } else if (Objects.equals(inputType, "NOTEBOOK")) {
                type = Article.TypeOfArticle.NOTEBOOK;
                correctType = true;
            } else {
                System.out.println("invalid input. Enter a correct product Type");
            }
        } while (correctType == false);

        System.out.println("Enter the MANUFACTURER of the product");
        String manufacturer = input.nextLine();
        System.out.println("Enter the MODEL NAME of the product");
        String modelName = input.nextLine();
        System.out.println("Enter a brief description for the product");
        String briefDescription = input.nextLine();

        try {
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
        } catch (InputMismatchException e) {
            System.out.println("\n invalid input , returning to the main menu ");
            input.nextLine();
        }
    }

    public static void searchType() {
        boolean found = false;
        do {
            String userType = input.nextLine().toUpperCase();
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
                System.out.println("The product of that type in not found , please try again ");
            }
        } while (found == false);
    }

    void addWarehouse(Article a) {
        warehouse.add(a);
    }

    public static List<Article> findBuyingPrice(int price) {
        List<Article> listPrice = new ArrayList<>();
        for (Article a : warehouse) {
            if (a.getPriceOfBuying() == price) {
                listPrice.add(a);
            }
        }
        return listPrice;
    }

    public static List<Article> findRangePrice(int priceMin, int priceMax) {
        List<Article> listRange = new ArrayList<>();
        for (Article a : warehouse) {
            if (a.getPriceOfSelling() >= priceMin && a.getPriceOfSelling() <= priceMax) {
                listRange.add(a);
            }
        }
        return listRange;
    }

    @Deprecated
    public static Double findAvgPrice(String type) {
        Double totPrice = 0.0;
        Integer numArt = 0;
        for (Article art : warehouse) {
            if (art.getType() == Article.TypeOfArticle.valueOf(type)) {
                totPrice += art.getPriceOfBuying();
                numArt++;
            }
        }
        Double avg = totPrice / numArt;
        return avg;
    }

    public Double findAvgPrice(Article.TypeOfArticle type){
        Double totPrice = 0.0;
        Integer numArt = 0;
        for (Article art : warehouse) {
            if (art.getType() == type) {
                totPrice += art.getPriceOfBuying();
                numArt++;
            }
        }
        Double avg = totPrice / numArt;
        return avg;
    }

    public static List<Article> findByManifacturer(String manufacturerToSearch) {
        List<Article> listManufacturer = new ArrayList<>();
        for (Article a : warehouse) {
            if (a.getManufacturer().equals(manufacturerToSearch)) {
                listManufacturer.add(a);
            }
        }
        return listManufacturer;
    }

    public static List<Article> findByModel(String modelToSearch) {
        List<Article> listModel = new ArrayList<>();
        for (Article a : warehouse) {
            if (a.getModel().equals(modelToSearch)) {
                listModel.add(a);
            }
        }
        return listModel;
    }

    public static List<Article> findSellingPrice(int getPriceOfSellingToSearch) {
        List<Article> listPriceOfSelling = new ArrayList<>();
        for (Article a : warehouse) {
            if (a.getPriceOfSelling() == getPriceOfSellingToSearch) {
                listPriceOfSelling.add(a);
            }
        }
        return listPriceOfSelling;
    }
}
