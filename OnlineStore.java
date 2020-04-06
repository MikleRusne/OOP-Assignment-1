class OnlineStore extends Store {
    // online stores can only be accessed by their website
    public void sale(String s) {
        super.sale(s);
        System.out.println("A website was provided to the user.");
    }

    public OnlineStore(String s) {
        super(s);
    }
}