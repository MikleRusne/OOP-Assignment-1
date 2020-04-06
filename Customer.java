class Customer {
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

    public void place_order(Store s, Order o) {
        String oname = o.get_name();
        Integer onumber = o.get_number();
        if (s.exists(oname) == 1) {
            if (onumber <= s.get_stock(oname)) {
                double price = s.get_price(oname);
                if ((price * onumber) < money) {
                    money -= price;
                    s.get_item(oname, onumber);
                } else {
                    System.out.println("Not enough money.");
                }
            } else {
                System.out.println("Insufficient stock.");
            }
        } else {
            System.out.println("That item does not exist.");
        }
    }
}