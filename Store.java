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
    protected String address; // outlets must have address. But for online stores, the website URL is the
                              // address

    public void sale(Integer n, String s, String c) {
        System.out.println(((int) n ) + " amount of " +s+ " has been sold to " + c+ ".");
    }

    public Store(String address) {
        items = new ArrayList<String>();
        stock = new ArrayList<Integer>();
        prices = new ArrayList<Double>();
        this.address = address;
    }

    public Store() {
        items = new ArrayList<String>();
        stock = new ArrayList<Integer>();
        prices = new ArrayList<Double>();
    }

    public int exists(String s) {
        int location = items.indexOf(s);
        if (location == -1) {
//            System.out.println("That item is invalid.");
            return -1;
        }
        else if (stock.get(location) == 0) {
//            System.out.println("That item is out of stock.");
            return 0;
        } else
            return 1;
    }

    public void add_item(String s, Double price, Integer number) {
        int location = items.indexOf(s);
        if (location != -1) {
            // Integer object is immutable, so this ugly thing
            stock.set(location, (stock.get(location)) + number);
        } else {
            items.add(s);
            stock.add(number);
            prices.add(price);
        }
    }

    public void get_item(String s, Integer number) {
        if (exists(s) == 1) {
            int location = items.indexOf(s);
            if (stock.get(location) < number) {
                System.out.println("Insufficient stock.");
            } else {
                // removing occurrences from stock
                stock.set(location, (stock.get(location)) - number);
                System.out.println(number + " of the item " + s + " was/were gotten.");
            }
        }
    }

    public int get_stock(String s) {
        int location = items.indexOf(s);
        return (int) stock.get(location);
    }

    // Setter was obsolete, would never need it so stopped making it midway.
    // public void set_price(String s, Double d) {
    // // Contingencies if the name isn't found
    // if (exists(s) != 1) {
    // System.out.println("Invalid item.");
    // } else {
    //
    // }
    // }

    public double get_price(String s) {
        // never call this function before verifying that items exist
        int location = items.indexOf(s);
        return prices.get(location);
    }

    public void display_store() {
        System.out.println("The store located at   " + address + "   has the following items:");
        for (int i = 0; i < items.size(); i++) {
            System.out.println(items.get(i) + "   " + stock.get(i) + "  " + prices.get(i));
        }
    }

}