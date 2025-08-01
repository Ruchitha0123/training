package Day8;
class TicketBookings extends Thread {
    static int tickets = 5; 
    int ticketsToBook;
    String user;

    TicketBookings(String user, int ticketsToBook) {
        this.user = user;
        this.ticketsToBook = ticketsToBook;
    }

    public void run() {
        try {
            if (tickets >= ticketsToBook) {
                System.out.println(user + " booked " + ticketsToBook + " ticket(s).");
                tickets -= ticketsToBook;
                System.out.println("Tickets left: " + tickets);
            } else {
                throw new Exception("Not enough tickets for " + user);
            }
        } catch (Exception e) {
            System.out.println(user + " failed to book: " + e.getMessage());
        }
    }
}


public class TicketBooking {
	public static void main(String[] args) {
        TicketBookings t1 = new TicketBookings("Alice", 1);
        TicketBookings t2 = new TicketBookings("Bob", 1);
        TicketBookings t3 = new TicketBookings("Charlie", 1); 

        t1.start();
        t2.start();
        t3.start();
    }
}

