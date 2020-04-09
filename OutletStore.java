public class OutletStore extends Store {
    // an outlet must be physically entered to shop, so...
    public void sale(Integer n, String s, String c) {
        super.sale(n, s ,c);
        System.out.println("Customer has been provided a building.");
    }

    public OutletStore(String s) {
        super(s);
    }

}