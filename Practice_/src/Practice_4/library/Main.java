package Practice_4.library;

class Book{
    String title;
    String author;
    double price;

    Book() {
        this("Unknwon","Unknown",0.0);
    }

    Book(String title, String author, double price) {

        this.title = title;
        this.author = author;
        this.price = price;
    }

    void displayBook(){
        System.out.println("+-------------------");
        System.out.println("| Title  =  " + title  + "  |");
        System.out.println("| Author =  " + author + "     |");
        System.out.println("| Price  =  " + price  +  "    |");
        System.out.println("+-------------------+");
    }
}


public class Main {
    public static void main(String[]args){

        Book b1 = new Book("Rain Bow","Zaid",312.23);
        Book b2 = new Book("sky piea","haque",234);

        Book b3 = new Book("elbaf","oda",2321.212);

        b1.displayBook();
        b2.displayBook();
        b3.displayBook();

    }
}
