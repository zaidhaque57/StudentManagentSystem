package TaskManagerApp;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

class TaskItem implements Callable<String> {
    private final int taskId;
    private final String taskName;

    public TaskItem(int taskId, String taskName) {
        this.taskId = taskId;
        this.taskName = taskName;
    }

    public int getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    @Override
    public String call()  throws  Exception{
        System.out.println("Task " + taskId + " (" + taskName + ") -> Processing...");

        int sleepTime = 500 + (int) + (Math.random() * 1000);
        Thread.sleep(sleepTime);

        if(Math.random() < 0.2){
            throw new RuntimeException("Task encountered an unexpected error!");
        }
        System.out.println("Task " + taskId + " (" + taskName + ") -> Completed");
        return "Completed";
    }
}

public class TaskManagerApp {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);

        List<TaskItem> pendingTasks = new ArrayList<>();

        ConcurrentHashMap<Integer, String> CompletedTask = new ConcurrentHashMap<>();
        ConcurrentHashMap<Integer, String> failedTasks = new ConcurrentHashMap<>();

        AtomicInteger idCounter = new AtomicInteger(1);

        while(true) {
            System.out.println("======= Task Manager ============");
            System.out.println("1. Add Task ");
            System.out.println("2. Execute Tasks");
            System.out.println("3. Show Completed Tasks");
            System.out.println("4. Show Failed Tasks");
            System.out.println("5. Exit");
            System.out.println("=====================================");
            System.out.println("enter your choice");

            try{
                int choice = sc.nextInt();
                sc.nextLine();

                switch(choice){
                    case 1:
                        System.out.println("Enter task description/Name");
                        String name = sc.nextLine();
                        int id = idCounter.getAndIncrement();
                        pendingTasks.add(new TaskItem(id, name));
                        System.out.println("Task " + id + " (" + name + ") added successfully.");
                        break;
                    case 2:
                        if (pendingTasks.isEmpty()) {
                            System.out.println("No pending tasks to execute.");
                            break;
                        }
                        System.out.println("\n---- Starting Thread Pool Execution---");

                        ExecutorService executor = Executors.newFixedThreadPool(3);
                        List<Future<String>> futures = new ArrayList<>();

                        for (TaskItem task : pendingTasks) {
                            futures.add(executor.submit(task));
                        }

                        executor.shutdown();

                        for (int i = 0; i < pendingTasks.size(); i++) {
                            TaskItem task = pendingTasks.get(i);
                            Future<String> future = futures.get(i);
                            try {
                                // get() blocks until the specific task finishes
                                future.get();
                                CompletedTask.put(task.getTaskId(), task.getTaskName());
                            } catch (ExecutionException e) {
                                // Wrapped exception thrown inside call()
                                failedTasks.put(task.getTaskId(), task.getTaskName() + " -> Error: " + e.getCause().getMessage());
                                System.out.println("Task " + task.getTaskId() + " (" + task.getTaskName() + ") -> Failed");
                            } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                                System.out.println("Execution interrupted.");
                            }
                        }

                        pendingTasks.clear();
                        System.out.println("--- All Tasks Processed ---\n");
                        break;

                    case 3:
                        System.out.println("\n--- Completed Tasks ---");
                        if (CompletedTask.isEmpty()) {
                            System.out.println("No completed tasks yet.");
                        } else {
                            CompletedTask.forEach((idKey, taskName) ->
                                    System.out.println("Task ID: " + idKey + " | Name: " + taskName)
                            );
                        }
                        break;
                    case 4:
                        System.out.println("\n--- Failed Tasks ---");
                        if (failedTasks.isEmpty()) {
                            System.out.println("No failed tasks.");
                        } else {
                            failedTasks.forEach((idKey, details) ->
                                    System.out.println("Task ID: " + idKey + " | Details: " + details)
                            );
                        }
                        break;
                    case 5:
                        System.out.println("Exiting Task Manager...");
                        sc.close();
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please select between 1 and 5.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input format. Please enter a number.");
                sc.nextLine();
            }
        }
    }
}
