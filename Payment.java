abstract class Payment {
    public Payment() {
    };

    public Payment(Customer c, Store s, Order o) {
        String oname = o.get_name();
        Integer onumber = o.get_number();
        String cname = c.get_name();
        double balance = c.get_money();
        int is= s.exists(oname);
        System.out.println(s.get_stock(oname));
        if (is == 1) {
            if (onumber <= s.get_stock(oname)) {
                double price = s.get_price(oname) * onumber;
                if ((price) < balance) {
                    c.subtract_money(price);
                    s.get_item(oname, onumber);
                    acknowledge();
                    s.sale(onumber, oname, cname);
                } else {
                    System.out.println(cname + "does not have enough money.");
                }
            }
        } else {
            if(is == 0) {
                System.out.println("Insufficient stock of the item " + o.get_name()+ ".");
          }else{
            System.out.println("The item " + o.get_name()+ " does not exist.");
            }
        }
    }

    public abstract void acknowledge() {
    };
    // the way a payment is acknowledged depends on the medium, so all children of
    // payment shall have different method of acknowledgement.

    // Since all payment has one thing in common, money being transferred.
    // Obsolete now that there's a function to make payment
    // public double get_value() {
    // return value;
    // }
    // A function to combine the above functions into one
}