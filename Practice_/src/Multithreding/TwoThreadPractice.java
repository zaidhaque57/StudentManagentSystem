package Multithreding;

public class TwoThreadPractice {
    public static void main(String[]args) {

        Thread t1 = new Thread( () -> {
            for (int i = 1; i <= 10; i++) {
                System.out.println("Thread 1: " + i);
                try{
                    Thread.sleep(10);
                }catch(InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        });

        Thread t2 = new Thread( () -> {
            for (int i = 10; i >= 1; i--) {
                System.out.println("Thread 2: " + i);
                try{
                    Thread.sleep(10);
                }catch(InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        });

        t1.start();
        t2.start();
    }
}
