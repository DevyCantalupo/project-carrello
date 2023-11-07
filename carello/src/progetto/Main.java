package progetto;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Tablet tablet1 = new Tablet(null, null, null, null, null, 0, 0, 0);
        Tablet tablet2 = new Tablet(null, null, null, null, null, 0, 0, 0);
        Tablet smartphone1 = new Tablet(null, null, null, null, null, 0, 0, 0);
        Tablet smartphone2 = new Tablet(null, null, null, null, null, 0, 0, 0);
        Tablet notebook1 = new Tablet(null, null, null, null, null, 0, 0, 0);
        Tablet notebook2 = new Tablet(null, null, null, null, null, 0, 0, 0);
        List<Article> warehouse = new ArrayList<Article>();
        warehouse.add(tablet1);
        warehouse.add(tablet2);
        warehouse.add(smartphone1);
        warehouse.add(smartphone2);
        warehouse.add(notebook1);
        warehouse.add(notebook2);

    }

}