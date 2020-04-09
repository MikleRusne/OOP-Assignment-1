
abstract class Payment {
    public Payment() {
    };

    String iname;
    Integer inumber;
    String customer;
    double price;
    protected int was_successful;

    public Payment(Customer c, Store s, Order o) {
        was_successful = 0; // fails by default
        System.out.println("\nProcessing payment.");
        iname = o.get_name();
        inumber = o.get_number();
        customer = c.get_name();
        double balance = c.get_money();
        int is = s.exists(iname);
        // System.out.println(s.get_stock(oname) + "Hello");
        switch (is) {
            case 1:
                if (inumber <= s.get_stock(iname)) {
                    price = (s.get_price(iname) * inumber);
                    if (price <= balance) {
                        c.subtract_money(price);
                        s.get_item(iname, inumber);
                        acknowledge();
                        s.sale(inumber, iname, customer);
                        was_successful = 1;
                    } else
                        System.out.println(customer + " does not have enough money.");
                } else {
                    System.out.flush();
                    System.out.println("Insufficient stock of the item " + iname + ".");
                }
                break;
            case 0:
                System.out.println("Stock is zero.");
                break;
            case -1:
                System.out.println("The item " + o.get_name() + " does not exist.");
        }

    }

    public void details() {
        String response = ((was_successful == 0) ? "unsuccessful" : "successful");
        System.out.println(customer + " attempted to buy " + inumber.intValue() + " " + iname + " which cost " + price
                + ". It was " + response + ".");
    }

    public abstract void acknowledge();
    // the way a payment is acknowledged depends on the medium, so all children of
    // payment shall have different method of acknowledgement.

    // Since all payment has one thing in common, money being transferred.
    // Obsolete now that there's a function to make payment
    // public double get_value() {
    // return value;
    // }
    // A function to combine the above functions into one
}