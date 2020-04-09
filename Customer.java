public class Customer {
    private String name;
    private double money;

    public Customer(String n, double m) {
        name = n;
        money = m;
    }

    public String get_name() {
        return name;
    }

    public double get_money() {
        return money;
    }

    // not needed anymore but left just in case
    public void subtract_money(double m) {
        money -= m;
    }

}