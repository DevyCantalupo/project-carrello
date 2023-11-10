package progetto;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        Tablet tablet1 = new Tablet("Huawei", "xxx", "bello", 22, 150, 50, 160, 03);
        Tablet tablet2 = new Tablet("Hp", "x222", "brutto", 10, 240, 80, 200, 04);
        Smartphone smartphone1 = new Smartphone("Nokia", "3210", null, 11, 90, 150, 300, 05);
        Smartphone smartphone2 = new Smartphone("Iphone", "12", "Funziona", 31, 120, 150, 400, 06);
        Notebook notebook1 = new Notebook("Hp", "h300", null, 10, 222, 250, 600, 01);
        Notebook notebook2 = new Notebook("Apple", "pro", "vecchio", 22, 400, 300, 800, 02);

        Warehouse warehouse = new Warehouse();
        warehouse.addWarehouse(tablet1);
        warehouse.addWarehouse(tablet2);
        warehouse.addWarehouse(smartphone1);
        warehouse.addWarehouse(smartphone2);
        warehouse.addWarehouse(notebook1);
        warehouse.addWarehouse(notebook2);

        System.out.println("Cerca prodotto con prezzo di acquisto: 80");
        System.out.println(warehouse.findBuyingPrice(80));

        System.out.println("Cerca prodotto con range di prezzo di vendita tra 50 e 200");
        System.out.println(warehouse.findRangePrice(50, 200));

        System.out.println("Trova prezzo medio di acquisto degli articoli TABLET");
        System.out.println(warehouse.findAvgPrice("TABLET"));
    }

}