package Variables;

public class VariableScope {

    static int number = 100;
    public static void show(){
        System.out.println(number);
    }
    public static void main(String[]args){
        show();
    }
}
