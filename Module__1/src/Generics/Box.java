package Generics;

class Box<T> {
    private T name;
    private T number;
    private T price;

    public void setName(T name) {this.name = name;}
    public void setNumber(T number) {this.number = number;}
    public void setPrice(T price){this.price = price;}

    public T getName() {return name;}
    public T getNumber() {return number;}
    public T getPrice() {return price;}

    public static void main(String[]args){

        Box<String> box1 = new Box<>();
        box1.setName("Zaid");
        box1.setNumber("11");
        box1.setPrice("99.1");

        System.out.println(box1.getName());
        System.out.println(box1.getPrice());
        System.out.println(box1.getNumber());

    }
}
