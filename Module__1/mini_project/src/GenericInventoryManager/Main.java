package GenericInventoryManager;

public class Main {
    public static void main(String[]args){

        System.out.println("=== BOOK INVENTORY ===");
        Inventory<String> books = new Inventory<>();
        books.addItem("Java programming");
        books.addItem("DSA");
        books.addItem("Clean code");
        System.out.println("\n Currents Books");
        books.display();
        System.out.println();
    }
}
