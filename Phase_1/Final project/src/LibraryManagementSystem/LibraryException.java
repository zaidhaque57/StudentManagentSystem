package LibraryManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class LibraryException extends Exception{
    public LibraryException(String message){
        super(message);
    }
}

abstract class Person{
    protected String name;

    public Person(String name){
        this.name = name;
    }

    public abstract void displayRole();

    public abstract void displayole();
}

class Member extends Person {
    private String memberId;

    public Member(String name, String memberId){
        super(name);
        this.memberId = memberId;
    }

    public String getMemberId(){
        return memberId;
    }

    @Override
    public void displayRole(){
        System.out.println("Library Member : "+ name + " (ID: " + memberId + ")");
    }

    @Override
    public void displayole() {
//        System.out.println("Library Member : "+ name + " (ID: " + memberId + ")");
    }
}

class Book{
    private String id;
    private String title;
    private String author;
    private boolean isAvailabel;

    public Book(String id, String title, String author){
        this.id = id;
        this.title = title;
        this.author = author;
        this.isAvailabel = true;
    }

    public String getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }

    public boolean isAvailabel() {
        return isAvailabel;
    }
    public void setAvailabel(boolean availabel){
        this.isAvailabel = isAvailabel;
    }

    @Override
    public String toString(){
        String status = isAvailabel ? "Available" : "Issued";
        return String.format("ID: %-5s | Title: %-20s | Author: %s", id, title, author,status);
    }
}

interface LibraryOperation{
    void addBook(Book book);
    void removeBook(String bookId) throws LibraryException;
    void searchBook(String keyword) throws LibraryException;
    void issueBook(String bookId, Member member) throws LibraryException;
    void returnBook(String bookId) throws LibraryException;
    void displayAlBook();
}

class Library implements LibraryOperation{
    private List<Book> books = new ArrayList<>();

    @Override
    public void addBook(Book book){
        books.add(book);
        System.out.println("Success: Added " + book.getTitle() + " to the library.");
    }
    @Override
    public void removeBook(String bookId) throws LibraryException{
        Book bookToRemove = findBookById(bookId);
        if(bookToRemove == null){
            throw new LibraryException("Cannot Remove. Book ID " + bookId + "Not found.");
        }
        books.remove(bookToRemove);
        System.out.println("Success: Remove boo ID " + bookId +" .");
    }
    @Override
    public void searchBook(String keyword) throws LibraryException {
        boolean found = false;
        System.out.println("\n====== Search Result ======");
        for(Book b : books){
            if(b.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(b.toString());
                found = true;
            }
        }if (!found){
            throw new LibraryException("No books found matching: " + keyword);
        }
    }
    @Override
    public void issueBook(String bookId, Member member) throws LibraryException {
        Book book = findBookById(bookId);
        if (book == null) {
            throw new LibraryException("Cannot issue " + book.getTitle() + " is Current checked out");
        }
        book.setAvailabel(false);
        System.out.println("Success: " + book.getTitle() + "issueed to " + member.getMemberId());
    }

    @Override
    public void returnBook(String bookId) throws LibraryException {
        Book book = findBookById(bookId);
        if (book == null){
            throw new LibraryException("Cannot return. Book ID " + bookId + "does not belong to this library.");
        }
        if (book.isAvailabel()){
            System.out.println("Success: " + book.getTitle() + " has been returned ");
        }
    }
    @Override
    public void displayAlBook() {
        if(books.isEmpty()){
            System.out.println("The Library is currently empty.");
        }
        for(Book b : books){
            System.out.println(b.toString());
        }
    }

    private Book findBookById(String bookId){
        for (Book b : books){
            if(b.getId().equalsIgnoreCase(bookId)){
                return b;
            }
        }
        return null;
    }
}
