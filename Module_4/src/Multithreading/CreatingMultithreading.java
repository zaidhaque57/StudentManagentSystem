package Multithreading;

public class CreatingMultithreading {
    public static void main(String[]args) {

        MyTask task = new MyTask();

        MyThread t1 = new MyThread();

        Thread t2 = new Thread(task);

        t1.start();
        t2.start();
    }
}
