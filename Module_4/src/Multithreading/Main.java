package Multithreading;

import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {

        ExecutorService executor =
                Executors.newFixedThreadPool(2);

        Callable<Integer> task = () -> {

            System.out.println("Calculating...");

            return 100 + 200;

        };

        Future<Integer> future =
                executor.submit(task);

        try {

            int result = future.get();

            System.out.println("Result: " + result);

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();

        } catch (ExecutionException e) {

            System.out.println(
                    "Task failed: " + e.getCause()
            );

        } finally {

            executor.shutdown();

        }
    }
}