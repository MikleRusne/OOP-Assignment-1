public class CashPayment extends Payment {

    public void acknowledge() {
        System.out.println("Cash has been handed over.");
    }
}