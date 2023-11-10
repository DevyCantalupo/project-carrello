package progetto;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {
    List<Article> warehouse = new ArrayList<>();


    public Warehouse() {
    }

    void addWarehouse(Article a) {
        warehouse.add(a);
    }


    //Un metodo che permetta la ricerca per prezzo di acquisto
    //Dovrà resitutire la lista di dispositivi frutto della ricerca
    // o un errore nel caso in cui la ricerca non produca risultati.
    public List<Article> findBuyingPrice(int price) throws Exception {
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
    public List<Article> findRangePrice(int priceMin, int priceMax) throws Exception {
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
    public double findAvgPrice(String type) throws Exception {
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
