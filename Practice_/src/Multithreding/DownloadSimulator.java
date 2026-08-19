package Multithreding;

public class DownloadSimulator {
    public static void main(String []args) {

        Thread d1 = new Thread(createDownloadTask("Dowbload 1"));
        Thread d2 = new Thread(createDownloadTask("Dowbload 2"));
        Thread d3 = new Thread(createDownloadTask("Dowbload 3"));

        d1.start();
        d2.start();
        d3.start();
    }
    private static Runnable createDownloadTask(String downloadName) {
        return () -> {
            System.out.println(downloadName + " -> Downloading....");

            for(int i = 20; i <= 100; i +=20) {
                try{
                    Thread.sleep(500);
                }catch(InterruptedException e) {
                    System.out.println(e.getMessage());
                }
                System.out.println(downloadName + " -> " + i + "%");
            }
            System.out.println(downloadName + " -> Completed");
        };
    }
}
