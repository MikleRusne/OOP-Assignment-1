public class CardPayment extends Payment {
    // I'm not adding authorizations since it is only a payment, not a class for a
    // card.
    public CardPayment() {
    };
    public CardPayment(Customer c, Store s, Order o) {
        super(c,s,o);
    }
    public void acknowledge() {
        System.out.println("A payment has been made through Bank Card.");
    }
}