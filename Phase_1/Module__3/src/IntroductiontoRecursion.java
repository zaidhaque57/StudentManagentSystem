public class IntroductiontoRecursion {
    public static void count(int n){
        if(n==0)
            return;
        System.out.println(n);
        count(n-1);
    }
    public static void main(String[]args){
        count(5);
    }
}
