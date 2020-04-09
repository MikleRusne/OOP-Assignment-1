public class OnlineStore extends Store {
    // online stores can only be accessed by their website
    public void sale(Integer n, String s, String c) {
        super.sale(n,s,c);
        System.out.println("A website was provided to the user.");
    }

    public OnlineStore(String s) {
        super(s);
    }
}