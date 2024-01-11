package progetto.MainProgram;

import java.util.*;

import progetto.FakeDatabase.Warehouse;
import progetto.Items.Article;
import progetto.Items.Notebook;
import progetto.Items.Smartphone;
import progetto.Items.Tablet;
import progetto.Utility.Utility;

public class OperationInWarehouse {
    Scanner input = new Scanner(System.in);

    private final List<Article> warehouseList = Warehouse.getWarehouse();

    public OperationInWarehouse() {
    }

    public void printWarehouseContents() {
        if (warehouseList.isEmpty()) {
            System.out.println("The warehouse is empty");
        } else {
            for (int i = 0; i < warehouseList.size(); i++) {
                System.out.println("\n Index [" + i + "]; " + warehouseList.get(i));
            }
        }
    }

    public Boolean addToWarehouse(Article article) {
        if (article != null) {
            return warehouseList.add(article);
        } else {
            return false;
        }

    }

    public void searchType() {
        boolean found = false;
        do {
            String userType = input.nextLine().toUpperCase();
            for (int i = 0; i < warehouseList.size(); i++) {
                Article.TypeOfArticle articleType = warehouseList.get(i).getType();
                if ((Objects.equals(userType, "TABLET") && articleType == Article.TypeOfArticle.TABLET) ||
                        (Objects.equals(userType, "NOTEBOOK") && articleType == Article.TypeOfArticle.NOTEBOOK) ||
                        (Objects.equals(userType, "SMARTPHONE") && articleType == Article.TypeOfArticle.SMARTPHONE)) {
                    System.out.println("index[" + i + "];" + warehouseList.get(i) + "\n");
                    found = true;
                }
            }
            if (!(found)) {
                System.out.println("The product of that type in not found , please try again ");
            }
        } while (found == false);
    }

    public List<Article> findBuyingPrice(int price) {
        List<Article> listPrice = new ArrayList<>();
        for (Article a : warehouseList) {
            if (a.getPriceOfBuying() == price) {
                listPrice.add(a);
            }
        }
        return listPrice;
    }


    public List<Article> findRangePrice(int priceMin, int priceMax) {
        List<Article> listRange = new ArrayList<>();
        for (Article a : warehouseList) {
            if (a.getPriceOfSelling() >= priceMin && a.getPriceOfSelling() <= priceMax) {
                listRange.add(a);
            }
        }
        return listRange;
    }

    @Deprecated
    public Double findAvgPrice(String type) {
        Double totPrice = 0.0;
        Integer numArt = 0;
        for (Article art : warehouseList) {
            if (art.getType() == Article.TypeOfArticle.valueOf(type)) {
                totPrice += art.getPriceOfBuying();
                numArt++;
            }
        }
        Double avg = totPrice / numArt;
        return avg;
    }

    public Double findAvgPrice(Article.TypeOfArticle type) {
        List<Article> listAvg = warehouseList
                .stream()
                .filter(c -> c.getType() == type)
                .toList();
        if (!listAvg.isEmpty()) {
            Double sum = 0.0;
            for (Article a : listAvg) {
                sum += a.getPriceOfBuying();
            }
            return sum / listAvg.size();
        } else {
            return null;
        }
    }

    public List<Article> findByManifacturer(String manufacturerToSearch) {
        List<Article> listManufacturer = new ArrayList<>();
        for (Article a : warehouseList) {
            if (a.getManufacturer().equals(manufacturerToSearch)) {
                listManufacturer.add(a);
            }
        }
        return listManufacturer;
    }

    public List<Article> findByModel(String modelToSearch) {
        List<Article> listModel = new ArrayList<>();
        for (Article a : warehouseList) {
            if (a.getModel().equals(modelToSearch)) {
                listModel.add(a);
            }
        }
        return listModel;
    }

    public List<Article> findSellingPrice(int getPriceOfSellingToSearch) {
        List<Article> listPriceOfSelling = new ArrayList<>();
        for (Article a : warehouseList) {
            if (a.getPriceOfSelling() == getPriceOfSellingToSearch) {
                listPriceOfSelling.add(a);
            }
        }
        return listPriceOfSelling;
    }
}
