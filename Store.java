import java.util.ArrayList;
//limitations
//  Cannot add items.                                                                               Fixed
//  Have to use ArrayLists, Integer and Double objects.                                             Workaround made
//  Cannot modify price once set.                                                                   To Do
//  A method to check if an item exists, since that has to be done a lot.                           Done

abstract class Store {
    protected ArrayList<String> items; // asssuming a store has unlimited stock, an arraylist of strings should be
                                       // sufficient
    protected ArrayList<Integer> stock; // a second arrlist to keep track of the stock
    protected ArrayList<Double> prices; // yet another arrList to keep track of the prices
    protected String address; // outlets must have address. But for online stores, the warehouse is the
                              // address

    public void sale(String s) {
        System.out.println(s + " has been sold");
    }

    public Store() {
        items = new ArrayList<String>();
        stock = new ArrayList<Integer>();
        prices = new ArrayList<Double>();
    }

    public int exists(String s) {
        int location = items.indexOf(s);
        if (location == -1) {
            System.out.println("That item is invalid.");
            return -1;
        }
        if (stock.get(location) == 0) {
            System.out.println("That item is out of stock.");
            return 0;
        } else
            return 1;
    }

    public void add_item(String s, Double price) {
        int location = items.indexOf(s);
        if (location != -1) {
            // Integer object is immutable, so this ugly thing
            stock.set(location, (stock.get(location)) + 1);
        } else {
            items.add(s);
            stock.add(1);
            prices.add(price);
        }
    }

    public int get_item(String s) {
        int location = items.indexOf(s);
        if (exists(s) == 1) {
            // removing an occurrence from stock
            stock.set(location, (stock.get(location)) - 1);
            System.out.println("The item " + s + "was gotten.");
            return 1;
        } else
            return 0;
    }

    public void set_price(String s, Double d) {
        // Contingencies if the name isn't found
        int response = this.get_item(s);
        if (response != 1) {
            System.out.println("Invalid item.");
        } else {

        }
    }

    public Store(String address) {
    };
}