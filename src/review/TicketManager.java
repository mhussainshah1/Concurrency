package review;
//singleton pattern
public class TicketManager {
    private static TicketManager instance;
    private int tickets;

    private TicketManager() {
    }

    static synchronized TicketManager getInstance() { // k1
        if (instance == null) instance = new TicketManager(); // k2
        return instance;
    }

    public int getTicketCount() {
        return tickets;
    }

    public void addTickets(int value) {
        tickets += value;
    } // k3

    public void sellTickets(int value) {
        synchronized (this) { // k4
            tickets -= value;
        }
    }
}
