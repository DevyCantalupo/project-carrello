package progetto;

import java.util.*;

public class OperationInWarehouse {
    static Scanner input = new Scanner(System.in);
    private static List<Article> warehouse = new ArrayList<>();

    public static List<Article> getWarehouse() {
        return warehouse;
    }

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

    public static void addToWarehouse() {
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

            String id = Utilities.generateUniqueID();
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

    public static List<Article> findBuyingPrice() {
        while (!input.hasNextInt()) {
            System.out.println("invalid input , try again");
            input.next();
        }
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
        while (!input.hasNextInt()) {
            System.out.println("invalid input , try again");
            input.next();
        }
        int priceMin = input.nextInt();
        System.out.println("\n Insert maximum price \n");
        while (!input.hasNextInt()) {
            System.out.println("invalid input , try again");
            input.next();
        }
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

    public static List<Article> findByManifacturer(List<Article> listManufacturer, String manufacturerToSearch) {
        for (Article a : warehouse) {
            if (a.getManufacturer().equals(manufacturerToSearch)) {
                listManufacturer.add(a);
            }
        }
        return listManufacturer;
    }

    public static List<Article> findByModel(List<Article> listModel, String modelToSearch) {
        for (Article a : warehouse) {
            if (a.getModel().equals(modelToSearch)) {
                listModel.add(a);
            }
        }
        return listModel;
    }

    public static List<Article> findSellingPrice(List<Article> listPriceOfSelling, int getPriceOfSellingToSearch) {
        for (Article a : warehouse) {
            if (a.getPriceOfSelling() == getPriceOfSellingToSearch) {
                listPriceOfSelling.add(a);
            }
        }
        return listPriceOfSelling;
    }

    public static boolean checkIndex(int a, List<Article> list) {
        return a >= 0 && a < list.size();
    }
}
