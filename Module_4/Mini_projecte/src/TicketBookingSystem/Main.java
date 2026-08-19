package TicketBookingSystem;

class TicketBookingSystem {
    private int availableTickets = 5;

    public synchronized void bookticket(String customerName) {
        System.out.println(customerName + " is tyring to book a ticket....");

        if(availableTickets > 0) {
            try{
                Thread.sleep(100);
            }catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }

            availableTickets--;
            System.out.println("✅ SUCCESS: " + customerName + " booked a ticket! Tickets left: " + availableTickets);
        }else {
            System.out.println("❌ FAILED: " + customerName + " could not book. TICKETS SOLD OUT!");
        }
    }
}

public class Main {
    public static void main(String[] args) {

        // 1. Create a single shared booking system with 5 tickets
        TicketBookingSystem system = new TicketBookingSystem();

        // 2. Create and start 10 customer threads simultaneously
        for (int i = 1; i <= 10; i++) {
            String customerName = "Customer " + i;

            Thread customerThread = new Thread(() -> {
                system.bookticket(customerName);
            });

            customerThread.start();
        }
    }
}
