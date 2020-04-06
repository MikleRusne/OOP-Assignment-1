class OnlinePayment extends Payment {
    public void acknowledge() {
        System.out.println("A payment has been made through online API.");
    }
}