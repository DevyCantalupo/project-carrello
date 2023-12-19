package progetto.Mainprogram;

import progetto.Fakedatabase.Warehouse;

class Main {
    public static void main(String[] args) throws Exception {

        printWelcomeMsg();
        Warehouse.productsAlreadyInWarehouse();
        Menu menu = new Menu();
        menu.printMenuOperations();
        menu.menuOperations();
        printGoodbyeMsg();
    }
    
    public static void printWelcomeMsg() {
        System.out.println();
        System.out.println("*** Welcome to this warehouse management app! ***");
        System.out.println("     ***  Developed by The InBetweeners  ***");
        System.out.println("\nChoose an operation to perform:");
    }

    public static void printGoodbyeMsg() {
        System.out.println("\nClosing the program, have a nice day!");
    }
}