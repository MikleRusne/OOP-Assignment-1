public class CashPayment extends Payment {
    public CashPayment(Customer c, Store s, Order o) {
        super(c,s,o);
    }
    public void acknowledge() {
        System.out.println("Cash has been handed over.");
    }
}