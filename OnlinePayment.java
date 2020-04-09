public class OnlinePayment extends Payment {
    public OnlinePayment() {
        super();
        System.out.println("Java's weird, man. Who the fuck designed this and what were they smoking?");
    }

    public OnlinePayment(Customer c, Store s, Order o) {
        super(c,s,o);
    }

    public void acknowledge() {
        System.out.println("A payment has been made through online API.");
    }
}