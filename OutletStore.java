class OutletStore extends Store {
    // an outlet must be physically entered to shop, so...
    public void sale(String s) {
        super.sale(s);
        System.out.println("Customer has been provided a building.");
    }

    public OutletStore(String s) {
        super(s);
    }

}